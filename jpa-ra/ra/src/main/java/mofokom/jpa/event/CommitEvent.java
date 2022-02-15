package mofokom.jpa.event;

import java.util.Collection;
import java.util.Collections;

public class CommitEvent {

    /**
     * Names of added classes, updated and deleted Object IDs.
     */
    public static final int PAYLOAD_OIDS = 0;

    /**
     * Names of added classes, added, updated and deleted Object IDs.
     */
    public static final int PAYLOAD_OIDS_WITH_ADDS = 1;

    /**
     * Names of added, updated, and deleted classes only.
     */
    public static final int PAYLOAD_EXTENTS = 2;

    public static final int PAYLOAD_LOCAL_STALE_DETECTION = 3;

    private int _payload = PAYLOAD_OIDS;
    private Collection _addIds = null;
    private Collection _addClasses = null;
    private Collection _updates = null;
    private Collection _deletes = null;

    /**
     * Constructor. All collections will be proxied with unmodifiable views.
     *
     * @param payloadType PAYLOAD constant for type of data in this event
     * @param addIds set of object IDs for added instances, or null
     * @param addClasses set of class names for added instances
     * @param updates set of class names or object IDs for updated instances
     * @param deletes set of class names or object IDs for deleted instances
     */
    public CommitEvent(int payloadType, Collection addIds,
        Collection addClasses, Collection updates, Collection deletes) {
        _payload = payloadType;
        if (addIds != null)
            _addIds = Collections.unmodifiableCollection(addIds);
        if (addClasses != null)
            _addClasses = Collections.unmodifiableCollection(addClasses);
        if (updates != null)
            _updates = Collections.unmodifiableCollection(updates);
        if (deletes != null)
            _deletes = Collections.unmodifiableCollection(deletes);
    }

    /**
     * The event PAYLOAD constant.
     */
    public int getPayloadType() {
        return _payload;
    }

    /**
     * When the event type is PAYLOAD_OIDS_WITH_ADDS, return the set of
     * object IDs for added objects. This will only be callable when the
     * backward compatability property transmitAddObjectIds is true.
     */
    public Collection getPersistedObjectIds() {
        if (_payload != PAYLOAD_OIDS_WITH_ADDS) {
            if (_payload == PAYLOAD_OIDS)
                throw new IllegalStateException("no-added-oids");
            throw new IllegalStateException("extent-only-event");
        }
        return (_addIds == null) ? Collections.EMPTY_LIST : _addIds;
    }

    /**
     * When the event type is not PAYLOAD_EXTENTS, return the set of
     * object IDs for updated objects. When the event type is
     * PAYLOAD_LOCAL_STALE_DETECTION, items in this list may actually have
     * been deleted from the database.
     */
    public Collection getUpdatedObjectIds() {
        if (_payload == PAYLOAD_EXTENTS)
            throw new IllegalStateException("extent-only-event");
        return (_updates == null) ? Collections.EMPTY_LIST : _updates;
    }

    /**
     * When the event type is not PAYLOAD_EXTENTS, return the set of
     * object IDs for deleted objects.
     */
    public Collection getDeletedObjectIds() {
        if (_payload == PAYLOAD_EXTENTS)
            throw new IllegalStateException("extent-only-event");
        return (_deletes == null) ? Collections.EMPTY_LIST : _deletes;
    }

    /**
     * For all event types, return the set of class names for
     * the classes of inserted objects.
     */
    public Collection getPersistedTypeNames() {
        return (_addClasses == null) ? Collections.EMPTY_LIST : _addClasses;
    }

    /**
     * When the event type is PAYLOAD_EXTENTS, return the set of class
     * names for the classes of updated objects.
     */
    public Collection getUpdatedTypeNames() {
        if (_payload != PAYLOAD_EXTENTS)
            throw new IllegalStateException("nonextent-event");
        return (_updates == null) ? Collections.EMPTY_LIST : _updates;
    }

    /**
     * When the event type is PAYLOAD_EXTENTS, return the set of class
     * names for the classes of deleted objects.
     */
    public Collection getDeletedTypeNames() {
        if (_payload != PAYLOAD_EXTENTS)
            throw new IllegalStateException("nonextent-event");
        return (_deletes == null) ? Collections.EMPTY_LIST : _deletes;
    }
}