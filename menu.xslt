<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
<xsl:output method="xml"
version="1.0" encoding="UTF-8" indent="yes"
doctype-public="-//WAPFORUM//DTD WML 1.1//EN"
doctype-systems="http://www.wapforum.org/DTD/wml_1.1.xml"/>

<xsl:template match="/">
<wml>
  <xsl:call-template name="createSplashCard"/>
  <card id="Home" newcontext="true">
  <p align="center">
  Select Assignment:
  <select name="Assignments" multiple="false">
  <xsl:apply-templates select="Assignments"/>
  </select>
  </p>
  
  </card>
</wml>
</xsl:template>


<xsl:template match="Assignments">
<option value="{@id}">
<xsl:value-of select="name"/>
</option>
</xsl:template>

<xsl:template name="createSplashCard">
<card id="splash" title="Assignments" ontimer="#home">
<timer value="15"/>
<p align="center">
<big>WPS Assignments</big>
</p>
<p>results</p>
<do type="accept">
<go href="#home"/>
</do>
</card>
</xsl:template>
</xsl:stylesheet>



