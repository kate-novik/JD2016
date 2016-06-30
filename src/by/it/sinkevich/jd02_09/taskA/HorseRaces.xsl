<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/HorseRaces">
        <table border="1">
            <tr>
                <td>Clients</td>
                <td>Races</td>
                <td>BookMaker</td>
                <td>Horses</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/HorseRaces/HorseRace">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/HorseRaces/HorseRace/Clients">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/HorseRaces/HorseRace/Races">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/HorseRaces/HorseRace/BookMaker">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/HorseRaces/HorseRace/Horses">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
</xsl:stylesheet>