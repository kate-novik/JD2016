<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/Hotel">
        <table border="1" width="500px">
            <tr>
                <td colspan="3" align="center">Hotel</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>Stars</td>
                <td>Address</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Hotel/Name">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/Hotel/Stars">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/Hotel/Address">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/Hotel/Rooms">
        <table border="1" width="500px">
            <tr>
                <td colspan="3" align="center">Rooms</td>
            </tr>
            <tr>
                <td>Type</td>
                <td>Area</td>
                <td>Price</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Hotel/Rooms/Room">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/Hotel/Rooms/Room/Type">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/Hotel/Rooms/Room/Area">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/Hotel/Rooms/Room/Price">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

</xsl:stylesheet>