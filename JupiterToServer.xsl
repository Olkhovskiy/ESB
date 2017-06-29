<?xml version="1.0"?>
<xsl:stylesheet version="1.0"  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >

    <xsl:template match="Jupiter">
        <xsl:element name = "Server">
            <xsl:attribute name = "name">
                <xsl:value-of select = "/Jupiter/RequestParams/Name"/>
            </xsl:attribute>
            <xsl:attribute name = "id">
                <xsl:value-of select = "/Jupiter/RequestParams/id"/>
            </xsl:attribute>
            <xsl:attribute name = "type">
                <xsl:value-of select = "/Jupiter/RequestParams/Operation/Type"/>
            </xsl:attribute>
            <xsl:attribute name = "value">
                <xsl:value-of select = "/Jupiter/RequestParams/Operation/Value"/>
            </xsl:attribute>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>