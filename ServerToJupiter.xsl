<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >

    <xsl:template match="Server">
        <xsl:element name = "Jupiter">
            <xsl:element name = "ResponseParams">
                <xsl:element name = "Name">
                    <xsl:value-of select="@name"/>
                </xsl:element>
                <xsl:element name = "id">
                    <xsl:value-of select="@id"/>
                </xsl:element>
                <xsl:element name = "status">
                    <xsl:value-of select="@status"/>
                </xsl:element>
            </xsl:element>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>