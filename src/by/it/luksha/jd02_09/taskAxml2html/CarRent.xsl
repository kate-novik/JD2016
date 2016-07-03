<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/CarRent">
        <table border="1">

            <xsl:template match="CarRent/Name">
                <tr>
                    <td colspan="8" align="center">
                        <b>
                            <xsl:apply-templates/>
                        </b>
                    </td>
                </tr>
            </xsl:template>

        </table>
    </xsl:template>

    <xsl:template match="CarRent/Address">
        <tr>
            <tr>
                <td colspan="3">
                    <b>Address:</b>
                </td>
                <td colspan="3">
                    <b>Webaddress:</b>
                </td>
                <td colspan="2">
                    <b>Phone:</b>
                </td>
            </tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="CarRent/Address/Geoaddress">
        <td colspan="3">
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="CarRent/Address/Webaddress">
        <td colspan="3">
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="CarRent/Address/Phone">
        <td colspan="2">
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="CarRent/ListCars">
        <tr>
            <td colspan="8" align="center">
                <b>Our cars:</b>
            </td>
        </tr>
        <tr>
            <td>
                <b>Price:</b>
            </td>
            <td>
                <b>Brand:</b>
            </td>
            <td>
                <b>Model:</b>
            </td>
            <td>
                <b>Gearbox:</b>
            </td>
            <td>
                <b>Engine:</b>
            </td>
            <td>
                <b>Places:</b>
            </td>
            <td>
                <b>AirCool:</b>
            </td>
            <td>
                <b>Isofix:</b>
            </td>
        </tr>
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>


    <xsl:template match="CarRent/ListCars/Car">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="CarRent/ListCars/Car/Price">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="CarRent/ListCars/Car/Brand">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="CarRent/ListCars/Car/Model">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="CarRent/ListCars/Car/Gearbox">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="CarRent/ListCars/Car/Engine">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="CarRent/ListCars/Car/Places">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="CarRent/ListCars/Car/AirCool">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="CarRent/ListCars/Car/Isofix">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>


</xsl:stylesheet>