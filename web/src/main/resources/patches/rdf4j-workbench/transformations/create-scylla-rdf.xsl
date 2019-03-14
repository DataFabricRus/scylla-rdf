<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE xsl:stylesheet>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:sparql="http://www.w3.org/2005/sparql-results#" xmlns="http://www.w3.org/1999/xhtml">

    <xsl:include href="../locale/messages.xsl"/>

    <xsl:variable name="title">
        <xsl:value-of select="$repository-create.title"/>
    </xsl:variable>

    <xsl:include href="template.xsl"/>

    <xsl:template match="sparql:sparql">
        <form action="create" method="post">
            <table class="dataentry">
                <tbody>
                    <tr style="display: none">
                        <th>
                            <xsl:value-of select="$repository-type.label"/>
                        </th>
                        <td>
                            <select id="type" name="type">
                                <option value="scylla-rdf">Scylla RDF</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <xsl:value-of select="$repository-id.label"/>
                        </th>
                        <td>
                            <input id="id" name="Repository ID" size="16" value=""/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>
                            <xsl:value-of select="$repository-title.label"/>
                        </th>
                        <td>
                            <input id="title" name="Repository title" size="48" value=""/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>
                            Scylla Keyspace
                        </th>
                        <td>
                            <input id="keyspace" name="Scylla Keyspace" size="48" value="triplestore"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>Scylla Hosts</th>
                        <td>
                            <input id="hosts" name="Scylla Hosts" size="48" value=""/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>Scylla Port</th>
                        <td>
                            <input type="number" id="port" name="Scylla Port" size="48" value="9042"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>Cardinality Estimation Enabled</th>
                        <td>
                            <input type="checkbox" id="cardinalityEstimationEmabled"
                                   name="Cardinality Estimation Enabled" value="true" checked="checked"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>Elasticsearch Host (optional)</th>
                        <td>
                            <input id="elasticsearchHost" name="Elasticsearch Host" size="48" value=""/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>Elasticsearch Max Documents (optional)</th>
                        <td>
                            <input type="number" id="elasticsearchMaxDocuments" name="Elasticsearch Max Documents"
                                   size="6" value="100"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="button" value="{$cancel.label}" style="float:right"
                                   data-href="repositories"
                                   onclick="document.location.href=this.getAttribute('data-href')"/>
                            <input id="create" type="button" value="{$create.label}"
                                   onclick="checkOverwrite()"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        <script src="../../scripts/create.js" type="text/javascript">
        </script>
    </xsl:template>

</xsl:stylesheet>