<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/Rolls">
        <table border="1">
            <xsl:apply-templates/>
        </table>
    </xsl:template>
    <xsl:template match="/Rolls/Roll">
        <tr>
            <td>
                <xsl:value-of select="@idRoll"/>
            </td>
            <td>
                <xsl:value-of select="@name"/>
            </td>
        </tr>
        <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User">
        <td>
            <xsl:value-of select="@idUser"/>
        </td>
        <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/First_Name">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Middle_Name">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Last_Name">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Passport">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Address">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Phone">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Email">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Nickname">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Password">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Accounts">
        <td><table border="1">
            <xsl:apply-templates/>
        </table></td>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Accounts/account">
        <tr><td>
            <xsl:value-of select="@idAccount"/>
        </td>
        <td>
            <xsl:value-of select="@state"/>
        </td>
        <xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Accounts/account/Amount">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Accounts/account/Payments">
        <td><table border="1">
            <xsl:apply-templates/>
        </table></td>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Accounts/account/Payments/payment">
       <tr> <td>
            <xsl:value-of select="@idPayment"/>
        </td>
        <xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Accounts/account/Payments/payment/Source">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Accounts/account/Payments/payment/Description">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Accounts/account/Payments/payment/Destination">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Accounts/account/Payments/payment/Date">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="/Rolls/Roll/Users/User/Accounts/account/Payments/payment/Amount_p">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
</xsl:stylesheet>