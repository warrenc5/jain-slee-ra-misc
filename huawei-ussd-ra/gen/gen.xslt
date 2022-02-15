<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" />
	<!--variables -->
  <xsl:param name="impl"/>
  <xsl:param name="ext"/>
	<xsl:variable name="page" select="/"/>
	<xsl:variable name="bpkg" >mofokom.in.ussd</xsl:variable>
	<!-- templates -->

	<xsl:template match="/spec">
    ---START MessageFactory
    package <xsl:value-of select="$bpkg"/>.resource;
    import <xsl:value-of select="$bpkg"/>.*;
    import javax.annotation.Generated;
    @Generated(value={})
    public interface MessageFactory {
      <xsl:for-each select="class[@name and count(field)>0]" >
        <xsl:if test="not(@name='UssdCommand')">
          <xsl:value-of select="@name"/> create<xsl:value-of select="@name"/>();
        </xsl:if>
      </xsl:for-each>
    }
    ---END

    ---START MessageFactoryImpl
    package <xsl:value-of select="$bpkg"/>.resource.impl;
    import javax.annotation.Generated;
    import static <xsl:value-of select="$bpkg"/>.impl.util.Util.setup;
    import <xsl:value-of select="$bpkg"/>.resource.*;
    import <xsl:value-of select="$bpkg"/>.impl.*;
    import <xsl:value-of select="$bpkg"/>.*;
    @Generated(value={})
    public class MessageFactoryImpl implements MessageFactory{
      <xsl:for-each select="class[@name and count(field)>0]" >
        <xsl:if test="not(@name='UssdCommand')">
        public <xsl:value-of select="@name"/> create<xsl:value-of select="@name"/>(){
         <xsl:value-of select="@name"/>Impl cmd = new  <xsl:value-of select="@name"/>Impl();
         setup(cmd);
         return cmd;
        }
        </xsl:if>
      </xsl:for-each>
    }
    ---END

    <xsl:apply-templates select="node()"/>
    <xsl:apply-templates select="node()[count(field)>0]" mode="impl"/>
	</xsl:template>

	<xsl:template match="class[@name and count(field)=0]" >
        ---START <xsl:value-of select="@name"/>
        package <xsl:value-of select="$bpkg"/>.marker;
        import javax.annotation.Generated;
        /**
        *
        * <xsl:value-of select="doc"/>
        *
        **/
        @Generated(value={})
        public interface <xsl:value-of select="@name"/> {
        }
        ---END
	</xsl:template>

	<xsl:template match="class[@name and count(field)>0]" >
        ---START <xsl:value-of select="@name"/>
        
        package <xsl:value-of select="$bpkg"/>;
        import javax.annotation.Generated;

        /**
        *
        * <xsl:value-of select="doc"/>
        *
        **/
        @Generated(value={})
        public interface <xsl:value-of select="@name"/><xsl:if test="count(field)>0 and not(@name='UssdCommand')"> extends UssdCommand</xsl:if> {
            <xsl:apply-templates select="field"/>
        }
        ---END
	</xsl:template>
	<xsl:template match="class[@name and count(value)>0]" >
        ---START <xsl:value-of select="@name"/>
        
        package <xsl:value-of select="$bpkg"/>;
        import javax.annotation.Generated;

        /**
        *
        * <xsl:value-of select="doc"/>
        *
        **/
        @Generated(value={})
        public enum <xsl:value-of select="@name"/> {
            <xsl:apply-templates select="value"/>;
            int i;
            <xsl:value-of select="@name"/>(int i) {
              this.i = i;
            }
            public int intValue() {
              return i;
            }
            public static <xsl:value-of select="@name"/> forInt(int i) {
              for(<xsl:value-of select="@name"/> e: values()){
                if(e.intValue() == i)
                  return e;
              }
              throw new IllegalArgumentException(new StringBuilder("Unknown value").append(i).toString());
            }
        }
        ---END
	</xsl:template>
	<xsl:template match="class[@name]" mode="impl">
        ---START <xsl:value-of select="@name"/>Impl
        
        package <xsl:value-of select="$bpkg"/>.impl;
        import <xsl:value-of select="$bpkg"/>.impl.util.Util;
        import <xsl:value-of select="$bpkg"/>.<xsl:value-of select="@name"/>;
        import static mofokom.in.ussd.CommandID.*;
        
        import javax.slee.EventTypeID;
        import javax.annotation.Generated;

        /**
        *
        * <xsl:value-of select="doc"/>
        *
        **/
        @Generated(value={})
        public <xsl:if test="@name='UssdCommand'">abstract</xsl:if> class <xsl:value-of select="@name"/>Impl <xsl:if test="not(@name='UssdCommand')"> extends UssdCommandImpl</xsl:if> implements <xsl:value-of select="@name"/>{

            public <xsl:value-of select="@name"/>Impl(byte[] data){
            <xsl:if test="not(@name='UssdCommand')">
              super(data);
              super.setCommandID(<xsl:value-of select="@name"/>.intValue());
            </xsl:if>
              fromByteArray(data);
            }

              <xsl:if test="not(@name='UssdCommand')">
            public final static EventTypeID EVENT_TYPE_ID = new EventTypeID("<xsl:value-of select="@name"/>", "MOFOKOM", "1.1");
              </xsl:if>

            public <xsl:value-of select="@name"/>Impl(){
            <xsl:if test="not(@name='UssdCommand')">
              super.setCommandID(<xsl:value-of select="@name"/>.intValue());
            </xsl:if>
            }

            <xsl:apply-templates select="field[count(@header)=0]" mode="impl"/>

            public byte[] toByteArray(){
              byte[] ret = null;
              byte[] cmd = new byte[1000];
              byte[] f = null;
              int p = 0;
              <xsl:if test="not(@name='UssdCommand')">
                byte[] scmd = super.toByteArray();
                System.arraycopy(scmd,0,cmd,0,scmd.length);
                p += scmd.length;
              </xsl:if>
              <xsl:apply-templates select="field[count(@header)=0]" mode="write"/>

              setCommandLength(p);
              f = Util.encode(p,4);
              System.arraycopy(f,0,cmd,0,f.length);

              
              ret = new byte[p];
              System.arraycopy(cmd,0,ret,0,p);
              return ret;
            }

            public int fromByteArray(byte[] data){ 
              int p = 0;
              <xsl:if test="not(@name='UssdCommand')">
                p = super.fromByteArray(data);
              </xsl:if>

              byte[] f = null;
              <xsl:apply-templates select="field[count(@header)=0]" mode="read"/>
              return p;
            }

            public String toString(){ 
              StringBuilder bob = new StringBuilder();
              
              <xsl:if test="not(@name='UssdCommand')">
                bob.append(this.getClass().getSimpleName()).append('\n');
                bob.append(super.toString());
              </xsl:if>
              <xsl:apply-templates select="field[count(@header)=0]" mode="string"/>
              return bob.toString();
            }
        }
        ---END
	</xsl:template>
	<xsl:template match="field[@name]" mode="string">
        bob.append("<xsl:value-of select="@name"/>").append('=').append(<xsl:value-of select="@name"/>).append('\n');
  </xsl:template>
	<xsl:template match="field[@name]" mode="write">
        <xsl:choose>
        <xsl:when test="@var">
        f = Util.encodeVar(<xsl:value-of select="@name"/>,<xsl:value-of select="@len"/>);
        </xsl:when>
        <xsl:otherwise>
        f = Util.encode(<xsl:value-of select="@name"/>,<xsl:value-of select="@len"/>);
        </xsl:otherwise>
        </xsl:choose>
        System.arraycopy(f,0,cmd,p,f.length);
        p += f.length;
  </xsl:template>
	<xsl:template match="field[@name]" mode="read">
        <xsl:choose>
        <xsl:when test="@var='true'">
        f = new byte[data.length-p];
        System.arraycopy(data,p,f,0,data.length-p);
        p += <xsl:value-of select="@len"/>;
        <xsl:value-of select="@name"/> = Util.decodeVar(f,<xsl:value-of select="@type"/>.class);
        </xsl:when>
        <xsl:otherwise>
        f = new byte[<xsl:value-of select="@len"/>];
        System.arraycopy(data,p,f,0,<xsl:value-of select="@len"/>);
        p += <xsl:value-of select="@len"/>;
        <xsl:value-of select="@name"/> = Util.decode(f,<xsl:value-of select="@type"/>.class);
        </xsl:otherwise>
        </xsl:choose>
  </xsl:template>
	<xsl:template match="field[@name]">
        <xsl:variable name="name"><xsl:value-of select="@name"/></xsl:variable>
        <xsl:if test="not(@header) or ancestor::class[@name='UssdCommand']">
	      /**
        *
        * <xsl:value-of select="doc"/>
        *<br/>
        * Reference <xsl:value-of select="@ref"/>
        * <br/>
        * Length <xsl:value-of select="@len"/>
        *
        * @see  <xsl:choose>
        <xsl:when test="@name = 'CommandID' or @name = 'UssdOpType'">
          <xsl:value-of select="$bpkg"/>.<xsl:value-of select="@name"/><xsl:text> </xsl:text><xsl:value-of select="@name"/>
        </xsl:when>
        <xsl:when test="@name = 'UssdVersion'">
          <xsl:value-of select="$bpkg"/>.marker.InterfaceVersion InterfaceVersion
        </xsl:when>
        <xsl:otherwise>
        <xsl:value-of select="$bpkg"/>.marker.<xsl:value-of select="@name"/><xsl:text> </xsl:text><xsl:value-of select="@name"/>
        </xsl:otherwise>
        </xsl:choose>
        * <br/>
        *
        **/

        public void set<xsl:value-of select="@name"/>(<xsl:value-of select="@type"/> value);
        public <xsl:value-of select="@type"/> get<xsl:value-of select="@name"/>();
        </xsl:if>

</xsl:template>
	<xsl:template match="field[@name]" mode="impl">
	      /**
        *
        * <xsl:value-of select="doc"/>
        *
        * Reference <xsl:value-of select="@ref"/>
        * Length <xsl:value-of select="@len"/>
        *
        **/
        private <xsl:value-of select="@type"/><xsl:text> </xsl:text><xsl:value-of select="@name"/>
        <xsl:if test="@name='CommandID' and not(ancestor::class[@name='UssdCommand'])">
          = <xsl:value-of select="ancestor::class/@name"/>.intValue();
        </xsl:if>;

        <xsl:if test="not(@header) or ancestor::class[@name='UssdCommand']">
        public <xsl:value-of select="@type"/> get<xsl:value-of select="@name"/>() {
          return <xsl:value-of select="@name"/>;
        }
        public void set<xsl:value-of select="@name"/>(<xsl:value-of select="@type"/> value) {
          this.<xsl:value-of select="@name"/> = value;
        }
        </xsl:if>

</xsl:template>
	<xsl:template match="value[@name]">
        <xsl:value-of select="@name"/>(<xsl:value-of select="@value"/>),
</xsl:template>

</xsl:stylesheet>
