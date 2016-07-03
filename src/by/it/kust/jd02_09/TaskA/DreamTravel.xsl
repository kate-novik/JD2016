<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/DreamTravel">
        <table border="1" width="700px">
            <tr>
                <td align="center" colspan="4">Customer</td>
            </tr>
            <tr>
                <td align="center">Name</td>
                <td align="center">Email</td>
                <td align="center">Address</td>
                <td align="center">Discount</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/DreamTravel/Customer">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="/DreamTravel/Customer/Name">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/DreamTravel/Customer/Email">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/DreamTravel/Customer/Address">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/DreamTravel/Customer/Discount">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>

    <xsl:template match="/DreamTravel/Tours">
        <table border="1.5" width="1100">
            <tr>
                <td colspan="10" align="center">Tours</td>
            </tr>
            <tr>
                <td align="center">Country</td>
                <td align="center">City</td>
                <td align="center">Hotel</td>
                <td align="center">URL</td>
                <td align="center">Date</td>
                <td align="center">Days</td>
                <td align="center">Price</td>
                <td align="center">Type</td>
                <td align="center">Option</td>
                <td align="center">Option</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>
    <xsl:template match="/DreamTravel/Tours/Tour">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/DreamTravel/Tours/Tour/Country">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/DreamTravel/Tours/Tour/City">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/DreamTravel/Tours/Tour/Hotel">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/DreamTravel/Tours/Tour/URL">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/DreamTravel/Tours/Tour/Date">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/DreamTravel/Tours/Tour/Days">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/DreamTravel/Tours/Tour/Price">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/DreamTravel/Tours/Tour/Type">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/DreamTravel/Tours/Tour/Option">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/DreamTravel/Tours/Tour/Option">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>

</xsl:stylesheet>