package cc.datafabric.scyllardf.coder.vocabularies;

import cc.datafabric.scyllardf.coder.IVocabulary;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.util.Vocabularies;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Set;

/**
 * "The Geonames ontology"@en
 * Modifications from version 3.01 :
 * Added : gn:GeonamesFeature, subclass of gn:Feature.
 * Added : explicit property gn:geonamesID, mandatory and unique for each gn:GeonamesFeature instance.
 * Deleted : owl:FunctionalProperty declarations for properties attached to gn:Feature, replaced by local cardinality restrictions on gn:GeonamesFeature
 * The gn:Feature class and attached properties can therefore be used in the open world for features not necessarily identified in the Geonames data base, or with partial descriptions.
 * Modified : Equivalent classes and superclasses of geonames:Feature in other vocabularies.
 * Added : new feature codes for historical features.
 * Improved metadata.
 * <p>
 * <p>
 * Namespace GeoNamesVocabulary
 * Prefix: {@code <http://www.geonames.org/ontology>}
 */
public class GeoNamesVocabulary implements IVocabulary {

    /**
     * {@code <http://www.geonames.org/ontology>}
     */
    public static final String NAMESPACE = "http://www.geonames.org/ontology#";

    /**
     * {@code <http://www.geonames.org/ontology>}
     */
    public static final IRI NAMESPACE_IRI;

    /**
     * {@code <GeoNamesVocabulary>}
     */
    public static final String PREFIX = "GeoNamesVocabulary";

    /**********************
     * IRI String Constants
     **********************/

    /*****************************
     * Local Name String Constants
     *****************************/

    /***************
     * IRI Constants
     ***************/

    /**
     * {@code http://www.geonames.org/ontology#A}
     * <p>
     * country, state, region ...
     *
     * @see <a href="http://www.geonames.org/ontology#A">#A</a>
     */
    public static final IRI A;

    /**
     * first-order administrative division
     * <p>
     * {@code http://www.geonames.org/ontology#A.ADM1}
     * <p>
     * a primary administrative division of a country, such as a state in the
     * United States
     *
     * @see <a href="http://www.geonames.org/ontology#A.ADM1">#A.ADM1</a>
     */
    public static final IRI A_ADM1;

    /**
     * historical first-order administrative division
     * <p>
     * {@code http://www.geonames.org/ontology#A.ADM1H}
     *
     * @see <a href="http://www.geonames.org/ontology#A.ADM1H">#A.ADM1H</a>
     */
    public static final IRI A_ADM1H;

    /**
     * andra ordningens administrativ avdelning
     * <p>
     * {@code http://www.geonames.org/ontology#A.ADM2}
     * <p>
     * a subdivision of a first-order administrative division
     *
     * @see <a href="http://www.geonames.org/ontology#A.ADM2">#A.ADM2</a>
     */
    public static final IRI A_ADM2;

    /**
     * historical second-order administrative division
     * <p>
     * {@code http://www.geonames.org/ontology#A.ADM2H}
     *
     * @see <a href="http://www.geonames.org/ontology#A.ADM2H">#A.ADM2H</a>
     */
    public static final IRI A_ADM2H;

    /**
     * administrativ inndeling av tredje grad
     * <p>
     * {@code http://www.geonames.org/ontology#A.ADM3}
     * <p>
     * a subdivision of a second-order administrative division
     *
     * @see <a href="http://www.geonames.org/ontology#A.ADM3">#A.ADM3</a>
     */
    public static final IRI A_ADM3;

    /**
     * historical third-order administrative division
     * <p>
     * {@code http://www.geonames.org/ontology#A.ADM3H}
     *
     * @see <a href="http://www.geonames.org/ontology#A.ADM3H">#A.ADM3H</a>
     */
    public static final IRI A_ADM3H;

    /**
     * administrativ inndeling av fjerde grad
     * <p>
     * {@code http://www.geonames.org/ontology#A.ADM4}
     * <p>
     * a subdivision of a third-order administrative division
     *
     * @see <a href="http://www.geonames.org/ontology#A.ADM4">#A.ADM4</a>
     */
    public static final IRI A_ADM4;

    /**
     * historical fourth-order administrative division
     * <p>
     * {@code http://www.geonames.org/ontology#A.ADM4H}
     *
     * @see <a href="http://www.geonames.org/ontology#A.ADM4H">#A.ADM4H</a>
     */
    public static final IRI A_ADM4H;

    /**
     * fifth-order administrative division
     * <p>
     * {@code http://www.geonames.org/ontology#A.ADM5}
     * <p>
     * a subdivision of a fourth-order administrative division
     *
     * @see <a href="http://www.geonames.org/ontology#A.ADM5">#A.ADM5</a>
     */
    public static final IRI A_ADM5;

    /**
     * administrativ avdelning
     * <p>
     * {@code http://www.geonames.org/ontology#A.ADMD}
     * <p>
     * an administrative division of a country, undifferentiated as to
     * administrative level
     *
     * @see <a href="http://www.geonames.org/ontology#A.ADMD">#A.ADMD</a>
     */
    public static final IRI A_ADMD;

    /**
     * historical administrative division
     * <p>
     * {@code http://www.geonames.org/ontology#A.ADMH}
     *
     * @see <a href="http://www.geonames.org/ontology#A.ADMH">#A.ADMH</a>
     */
    public static final IRI A_ADMH;

    /**
     * leased area
     * <p>
     * {@code http://www.geonames.org/ontology#A.LTER}
     * <p>
     * a tract of land leased to another country, usually for military
     * installations
     *
     * @see <a href="http://www.geonames.org/ontology#A.LTER">#A.LTER</a>
     */
    public static final IRI A_LTER;

    /**
     * political entity
     * <p>
     * {@code http://www.geonames.org/ontology#A.PCL}
     *
     * @see <a href="http://www.geonames.org/ontology#A.PCL">#A.PCL</a>
     */
    public static final IRI A_PCL;

    /**
     * avhengig politisk enhet
     * <p>
     * {@code http://www.geonames.org/ontology#A.PCLD}
     *
     * @see <a href="http://www.geonames.org/ontology#A.PCLD">#A.PCLD</a>
     */
    public static final IRI A_PCLD;

    /**
     * freely associated state
     * <p>
     * {@code http://www.geonames.org/ontology#A.PCLF}
     *
     * @see <a href="http://www.geonames.org/ontology#A.PCLF">#A.PCLF</a>
     */
    public static final IRI A_PCLF;

    /**
     * historical political entity
     * <p>
     * {@code http://www.geonames.org/ontology#A.PCLH}
     *
     * @see <a href="http://www.geonames.org/ontology#A.PCLH">#A.PCLH</a>
     */
    public static final IRI A_PCLH;

    /**
     * independent political entity
     * <p>
     * {@code http://www.geonames.org/ontology#A.PCLI}
     *
     * @see <a href="http://www.geonames.org/ontology#A.PCLI">#A.PCLI</a>
     */
    public static final IRI A_PCLI;

    /**
     * del av oberoende politisk enhet
     * <p>
     * {@code http://www.geonames.org/ontology#A.PCLIX}
     *
     * @see <a href="http://www.geonames.org/ontology#A.PCLIX">#A.PCLIX</a>
     */
    public static final IRI A_PCLIX;

    /**
     * delvis oberoende politisk enhet
     * <p>
     * {@code http://www.geonames.org/ontology#A.PCLS}
     *
     * @see <a href="http://www.geonames.org/ontology#A.PCLS">#A.PCLS</a>
     */
    public static final IRI A_PCLS;

    /**
     * historical capital of a political entity
     * <p>
     * {@code http://www.geonames.org/ontology#A.PPCLH}
     *
     * @see <a href="http://www.geonames.org/ontology#A.PPCLH">#A.PPCLH</a>
     */
    public static final IRI A_PPCLH;

    /**
     * historical populated place
     * <p>
     * {@code http://www.geonames.org/ontology#A.PPLH}
     *
     * @see <a href="http://www.geonames.org/ontology#A.PPLH">#A.PPLH</a>
     */
    public static final IRI A_PPLH;

    /**
     * kommun
     * <p>
     * {@code http://www.geonames.org/ontology#A.PRSH}
     * <p>
     * an ecclesiastical district
     *
     * @see <a href="http://www.geonames.org/ontology#A.PRSH">#A.PRSH</a>
     */
    public static final IRI A_PRSH;

    /**
     * territorium
     * <p>
     * {@code http://www.geonames.org/ontology#A.TERR}
     *
     * @see <a href="http://www.geonames.org/ontology#A.TERR">#A.TERR</a>
     */
    public static final IRI A_TERR;

    /**
     * sone
     * <p>
     * {@code http://www.geonames.org/ontology#A.ZN}
     *
     * @see <a href="http://www.geonames.org/ontology#A.ZN">#A.ZN</a>
     */
    public static final IRI A_ZN;

    /**
     * buffer zone
     * <p>
     * {@code http://www.geonames.org/ontology#A.ZNB}
     * <p>
     * a zone recognized as a buffer between two nations in which military
     * presence is minimal or absent
     *
     * @see <a href="http://www.geonames.org/ontology#A.ZNB">#A.ZNB</a>
     */
    public static final IRI A_ZNB;

    /**
     * {@code http://www.geonames.org/ontology#alternateName}
     *
     * @see <a href="http://www.geonames.org/ontology#alternateName">#alternateName</a>
     */
    public static final IRI alternateName;

    /**
     * children features
     * <p>
     * {@code http://www.geonames.org/ontology#childrenFeatures}
     * <p>
     * Links to an RDF document containing the descriptions of children
     * features
     *
     * @see <a href="http://www.geonames.org/ontology#childrenFeatures">#childrenFeatures</a>
     */
    public static final IRI childrenFeatures;

    /**
     * Class
     * <p>
     * {@code http://www.geonames.org/ontology#Class}
     * <p>
     * A class of features.
     *
     * @see <a href="http://www.geonames.org/ontology#Class">#Class</a>
     */
    public static final IRI Class;

    /**
     * Code
     * <p>
     * {@code http://www.geonames.org/ontology#Code}
     * <p>
     * A feature code.
     *
     * @see <a href="http://www.geonames.org/ontology#Code">#Code</a>
     */
    public static final IRI Code;

    /**
     * colloquial name
     * <p>
     * {@code http://www.geonames.org/ontology#colloquialName}
     *
     * @see <a href="http://www.geonames.org/ontology#colloquialName">#colloquialName</a>
     */
    public static final IRI colloquialName;

    /**
     * ISO country code
     * <p>
     * {@code http://www.geonames.org/ontology#countryCode}
     * <p>
     * A two letters country code in the ISO 3166 list
     *
     * @see <a href="http://www.geonames.org/ontology#countryCode">#countryCode</a>
     */
    public static final IRI countryCode;

    /**
     * Feature
     * <p>
     * {@code http://www.geonames.org/ontology#Feature}
     * <p>
     * A geographical feature
     *
     * @see <a href="http://www.geonames.org/ontology#Feature">#Feature</a>
     */
    public static final IRI Feature;

    /**
     * feature class
     * <p>
     * {@code http://www.geonames.org/ontology#featureClass}
     * <p>
     * The main category of the feature, as defined in geonames taxonomy.
     *
     * @see <a href="http://www.geonames.org/ontology#featureClass">#featureClass</a>
     */
    public static final IRI featureClass;

    /**
     * feature code
     * <p>
     * {@code http://www.geonames.org/ontology#featureCode}
     * <p>
     * Type of the feature, as defined in geonames taxonomy.
     *
     * @see <a href="http://www.geonames.org/ontology#featureCode">#featureCode</a>
     */
    public static final IRI featureCode;

    /**
     * Geonames Feature
     * <p>
     * {@code http://www.geonames.org/ontology#GeonamesFeature}
     * <p>
     * A feature described in geonames database, uniquely defined by its
     * geonames identifier
     *
     * @see <a href="http://www.geonames.org/ontology#GeonamesFeature">#GeonamesFeature</a>
     */
    public static final IRI GeonamesFeature;

    /**
     * geonames identifier
     * <p>
     * {@code http://www.geonames.org/ontology#geonamesID}
     *
     * @see <a href="http://www.geonames.org/ontology#geonamesID">#geonamesID</a>
     */
    public static final IRI geonamesID;

    /**
     * {@code http://www.geonames.org/ontology#H}
     * <p>
     * stream, lake, ...
     *
     * @see <a href="http://www.geonames.org/ontology#H">#H</a>
     */
    public static final IRI H;

    /**
     * landingsområde for sjøfly
     * <p>
     * {@code http://www.geonames.org/ontology#H.AIRS}
     * <p>
     * a place on a waterbody where floatplanes land and take off
     *
     * @see <a href="http://www.geonames.org/ontology#H.AIRS">#H.AIRS</a>
     */
    public static final IRI H_AIRS;

    /**
     * anchorage
     * <p>
     * {@code http://www.geonames.org/ontology#H.ANCH}
     * <p>
     * an area where vessels may anchor
     *
     * @see <a href="http://www.geonames.org/ontology#H.ANCH">#H.ANCH</a>
     */
    public static final IRI H_ANCH;

    /**
     * bay
     * <p>
     * {@code http://www.geonames.org/ontology#H.BAY}
     * <p>
     * a coastal indentation between two capes or headlands, larger than a
     * cove but smaller than a gulf
     *
     * @see <a href="http://www.geonames.org/ontology#H.BAY">#H.BAY</a>
     */
    public static final IRI H_BAY;

    /**
     * bays
     * <p>
     * {@code http://www.geonames.org/ontology#H.BAYS}
     * <p>
     * coastal indentations between two capes or headlands, larger than a
     * cove but smaller than a gulf
     *
     * @see <a href="http://www.geonames.org/ontology#H.BAYS">#H.BAYS</a>
     */
    public static final IRI H_BAYS;

    /**
     * bight(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.BGHT}
     * <p>
     * an open body of water forming a slight recession in a coastline
     *
     * @see <a href="http://www.geonames.org/ontology#H.BGHT">#H.BGHT</a>
     */
    public static final IRI H_BGHT;

    /**
     * bank(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.BNK}
     * <p>
     * an elevation, typically located on a shelf, over which the depth of
     * water is relatively shallow but sufficient for most surface navigation
     *
     * @see <a href="http://www.geonames.org/ontology#H.BNK">#H.BNK</a>
     */
    public static final IRI H_BNK;

    /**
     * elvebredd
     * <p>
     * {@code http://www.geonames.org/ontology#H.BNKR}
     * <p>
     * a sloping margin of a stream channel which normally confines the
     * stream to its channel on land
     *
     * @see <a href="http://www.geonames.org/ontology#H.BNKR">#H.BNKR</a>
     */
    public static final IRI H_BNKR;

    /**
     * del av bredd
     * <p>
     * {@code http://www.geonames.org/ontology#H.BNKX}
     *
     * @see <a href="http://www.geonames.org/ontology#H.BNKX">#H.BNKX</a>
     */
    public static final IRI H_BNKX;

    /**
     * bog(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.BOG}
     * <p>
     * a wetland characterized by peat forming sphagnum moss, sedge, and
     * other acid-water plants
     *
     * @see <a href="http://www.geonames.org/ontology#H.BOG">#H.BOG</a>
     */
    public static final IRI H_BOG;

    /**
     * icecap
     * <p>
     * {@code http://www.geonames.org/ontology#H.CAPG}
     * <p>
     * a dome-shaped mass of glacial ice covering an area of  mountain
     * summits or other high lands; smaller than an ice sheet
     *
     * @see <a href="http://www.geonames.org/ontology#H.CAPG">#H.CAPG</a>
     */
    public static final IRI H_CAPG;

    /**
     * channel
     * <p>
     * {@code http://www.geonames.org/ontology#H.CHN}
     * <p>
     * the deepest part of a stream, bay, lagoon, or strait, through which
     * the main current flows
     *
     * @see <a href="http://www.geonames.org/ontology#H.CHN">#H.CHN</a>
     */
    public static final IRI H_CHN;

    /**
     * lake channel(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.CHNL}
     * <p>
     * that part of a lake having water deep enough for navigation between
     * islands, shoals, etc.
     *
     * @see <a href="http://www.geonames.org/ontology#H.CHNL">#H.CHNL</a>
     */
    public static final IRI H_CHNL;

    /**
     * marine channel
     * <p>
     * {@code http://www.geonames.org/ontology#H.CHNM}
     * <p>
     * that part of a body of water deep enough for navigation through an
     * area otherwise not suitable
     *
     * @see <a href="http://www.geonames.org/ontology#H.CHNM">#H.CHNM</a>
     */
    public static final IRI H_CHNM;

    /**
     * merket skipsled
     * <p>
     * {@code http://www.geonames.org/ontology#H.CHNN}
     * <p>
     * a buoyed channel of sufficient depth for the safe navigation of
     * vessels
     *
     * @see <a href="http://www.geonames.org/ontology#H.CHNN">#H.CHNN</a>
     */
    public static final IRI H_CHNN;

    /**
     * confluence
     * <p>
     * {@code http://www.geonames.org/ontology#H.CNFL}
     * <p>
     * a place where two or more streams or intermittent streams flow
     * together
     *
     * @see <a href="http://www.geonames.org/ontology#H.CNFL">#H.CNFL</a>
     */
    public static final IRI H_CNFL;

    /**
     * canal
     * <p>
     * {@code http://www.geonames.org/ontology#H.CNL}
     * <p>
     * an artificial watercourse
     *
     * @see <a href="http://www.geonames.org/ontology#H.CNL">#H.CNL</a>
     */
    public static final IRI H_CNL;

    /**
     * akvedukt
     * <p>
     * {@code http://www.geonames.org/ontology#H.CNLA}
     * <p>
     * a conduit used to carry water
     *
     * @see <a href="http://www.geonames.org/ontology#H.CNLA">#H.CNLA</a>
     */
    public static final IRI H_CNLA;

    /**
     * canal bend
     * <p>
     * {@code http://www.geonames.org/ontology#H.CNLB}
     * <p>
     * a conspicuously curved or bent section of a canal
     *
     * @see <a href="http://www.geonames.org/ontology#H.CNLB">#H.CNLB</a>
     */
    public static final IRI H_CNLB;

    /**
     * drainage canal
     * <p>
     * {@code http://www.geonames.org/ontology#H.CNLD}
     * <p>
     * an artificial waterway carrying water away from a wetland or from
     * drainage ditches
     *
     * @see <a href="http://www.geonames.org/ontology#H.CNLD">#H.CNLD</a>
     */
    public static final IRI H_CNLD;

    /**
     * bevattningskanal
     * <p>
     * {@code http://www.geonames.org/ontology#H.CNLI}
     * <p>
     * a canal which serves as a main conduit for irrigation water
     *
     * @see <a href="http://www.geonames.org/ontology#H.CNLI">#H.CNLI</a>
     */
    public static final IRI H_CNLI;

    /**
     * navigation canal(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.CNLN}
     * <p>
     * a watercourse constructed for navigation of vessels
     *
     * @see <a href="http://www.geonames.org/ontology#H.CNLN">#H.CNLN</a>
     */
    public static final IRI H_CNLN;

    /**
     * abandoned canal
     * <p>
     * {@code http://www.geonames.org/ontology#H.CNLQ}
     *
     * @see <a href="http://www.geonames.org/ontology#H.CNLQ">#H.CNLQ</a>
     */
    public static final IRI H_CNLQ;

    /**
     * underground irrigation canal(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.CNLSB}
     * <p>
     * a gently inclined underground tunnel bringing water for irrigation
     * from aquifers
     *
     * @see <a href="http://www.geonames.org/ontology#H.CNLSB">#H.CNLSB</a>
     */
    public static final IRI H_CNLSB;

    /**
     * del av kanal
     * <p>
     * {@code http://www.geonames.org/ontology#H.CNLX}
     *
     * @see <a href="http://www.geonames.org/ontology#H.CNLX">#H.CNLX</a>
     */
    public static final IRI H_CNLX;

    /**
     * cove(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.COVE}
     * <p>
     * a small coastal indentation, smaller than a bay
     *
     * @see <a href="http://www.geonames.org/ontology#H.COVE">#H.COVE</a>
     */
    public static final IRI H_COVE;

    /**
     * tidal creek(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.CRKT}
     * <p>
     * a meandering channel in a coastal wetland subject to bi-directional
     * tidal currents
     *
     * @see <a href="http://www.geonames.org/ontology#H.CRKT">#H.CRKT</a>
     */
    public static final IRI H_CRKT;

    /**
     * current
     * <p>
     * {@code http://www.geonames.org/ontology#H.CRNT}
     * <p>
     * a horizontal flow of water in a given direction with uniform velocity
     *
     * @see <a href="http://www.geonames.org/ontology#H.CRNT">#H.CRNT</a>
     */
    public static final IRI H_CRNT;

    /**
     * avskåret
     * <p>
     * {@code http://www.geonames.org/ontology#H.CUTF}
     * <p>
     * a channel formed as a result of a stream cutting through a meander
     * neck
     *
     * @see <a href="http://www.geonames.org/ontology#H.CUTF">#H.CUTF</a>
     */
    public static final IRI H_CUTF;

    /**
     * dock(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.DCK}
     * <p>
     * a waterway between two piers, or cut into the land for the berthing of
     * ships
     *
     * @see <a href="http://www.geonames.org/ontology#H.DCK">#H.DCK</a>
     */
    public static final IRI H_DCK;

    /**
     * docking basin
     * <p>
     * {@code http://www.geonames.org/ontology#H.DCKB}
     * <p>
     * a part of a harbor where ships dock
     *
     * @see <a href="http://www.geonames.org/ontology#H.DCKB">#H.DCKB</a>
     */
    public static final IRI H_DCKB;

    /**
     * icecap dome
     * <p>
     * {@code http://www.geonames.org/ontology#H.DOMG}
     * <p>
     * a comparatively elevated area on an icecap
     *
     * @see <a href="http://www.geonames.org/ontology#H.DOMG">#H.DOMG</a>
     */
    public static final IRI H_DOMG;

    /**
     * fordypning i iskappen
     * <p>
     * {@code http://www.geonames.org/ontology#H.DPRG}
     * <p>
     * a comparatively depressed area on an icecap
     *
     * @see <a href="http://www.geonames.org/ontology#H.DPRG">#H.DPRG</a>
     */
    public static final IRI H_DPRG;

    /**
     * dike
     * <p>
     * {@code http://www.geonames.org/ontology#H.DTCH}
     * <p>
     * a small artificial watercourse dug for draining or irrigating the land
     *
     * @see <a href="http://www.geonames.org/ontology#H.DTCH">#H.DTCH</a>
     */
    public static final IRI H_DTCH;

    /**
     * drainage ditch
     * <p>
     * {@code http://www.geonames.org/ontology#H.DTCHD}
     * <p>
     * a ditch which serves to drain the land
     *
     * @see <a href="http://www.geonames.org/ontology#H.DTCHD">#H.DTCHD</a>
     */
    public static final IRI H_DTCHD;

    /**
     * bevattningsdike
     * <p>
     * {@code http://www.geonames.org/ontology#H.DTCHI}
     * <p>
     * a ditch which serves to distribute irrigation water
     *
     * @see <a href="http://www.geonames.org/ontology#H.DTCHI">#H.DTCHI</a>
     */
    public static final IRI H_DTCHI;

    /**
     * dikesmynning
     * <p>
     * {@code http://www.geonames.org/ontology#H.DTCHM}
     * <p>
     * an area where a drainage ditch enters a lagoon, lake or bay
     *
     * @see <a href="http://www.geonames.org/ontology#H.DTCHM">#H.DTCHM</a>
     */
    public static final IRI H_DTCHM;

    /**
     * elvemunning
     * <p>
     * {@code http://www.geonames.org/ontology#H.ESTY}
     * <p>
     * a funnel-shaped stream mouth or embayment where fresh water mixes with
     * sea water under tidal influences
     *
     * @see <a href="http://www.geonames.org/ontology#H.ESTY">#H.ESTY</a>
     */
    public static final IRI H_ESTY;

    /**
     * fishing area
     * <p>
     * {@code http://www.geonames.org/ontology#H.FISH}
     * <p>
     * a fishing ground, bank or area where fishermen go to catch fish
     *
     * @see <a href="http://www.geonames.org/ontology#H.FISH">#H.FISH</a>
     */
    public static final IRI H_FISH;

    /**
     * fjord
     * <p>
     * {@code http://www.geonames.org/ontology#H.FJD}
     * <p>
     * a long, narrow, steep-walled, deep-water arm of the sea at high
     * latitudes, usually along mountainous coasts
     *
     * @see <a href="http://www.geonames.org/ontology#H.FJD">#H.FJD</a>
     */
    public static final IRI H_FJD;

    /**
     * fjordar
     * <p>
     * {@code http://www.geonames.org/ontology#H.FJDS}
     * <p>
     * long, narrow, steep-walled, deep-water arms of the sea at high
     * latitudes, usually along mountainous coasts
     *
     * @see <a href="http://www.geonames.org/ontology#H.FJDS">#H.FJDS</a>
     */
    public static final IRI H_FJDS;

    /**
     * foss
     * <p>
     * {@code http://www.geonames.org/ontology#H.FLLS}
     * <p>
     * a perpendicular or very steep descent of the water of a stream
     *
     * @see <a href="http://www.geonames.org/ontology#H.FLLS">#H.FLLS</a>
     */
    public static final IRI H_FLLS;

    /**
     * del av foss
     * <p>
     * {@code http://www.geonames.org/ontology#H.FLLSX}
     *
     * @see <a href="http://www.geonames.org/ontology#H.FLLSX">#H.FLLSX</a>
     */
    public static final IRI H_FLLSX;

    /**
     * mud flat(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.FLTM}
     * <p>
     * a relatively level area of mud either between high and low tide lines,
     * or subject to flooding
     *
     * @see <a href="http://www.geonames.org/ontology#H.FLTM">#H.FLTM</a>
     */
    public static final IRI H_FLTM;

    /**
     * tidal flat(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.FLTT}
     * <p>
     * a large flat area of mud or sand attached to the shore and alternately
     * covered and uncovered by the tide
     *
     * @see <a href="http://www.geonames.org/ontology#H.FLTT">#H.FLTT</a>
     */
    public static final IRI H_FLTT;

    /**
     * glacier(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.GLCR}
     * <p>
     * a mass of ice, usually at high latitudes or high elevations, with
     * sufficient thickness to flow away from the source area in lobes,
     * tongues, or masses
     *
     * @see <a href="http://www.geonames.org/ontology#H.GLCR">#H.GLCR</a>
     */
    public static final IRI H_GLCR;

    /**
     * golf, bukt
     * <p>
     * {@code http://www.geonames.org/ontology#H.GULF}
     * <p>
     * a large recess in the coastline, larger than a bay
     *
     * @see <a href="http://www.geonames.org/ontology#H.GULF">#H.GULF</a>
     */
    public static final IRI H_GULF;

    /**
     * geyser
     * <p>
     * {@code http://www.geonames.org/ontology#H.GYSR}
     * <p>
     * a type of hot spring with intermittent eruptions of jets of hot water
     * and steam
     *
     * @see <a href="http://www.geonames.org/ontology#H.GYSR">#H.GYSR</a>
     */
    public static final IRI H_GYSR;

    /**
     * hamn(ar)
     * <p>
     * {@code http://www.geonames.org/ontology#H.HBR}
     * <p>
     * a haven or space of deep water so sheltered by the adjacent land as to
     * afford a safe anchorage for ships
     *
     * @see <a href="http://www.geonames.org/ontology#H.HBR">#H.HBR</a>
     */
    public static final IRI H_HBR;

    /**
     * del av hamn
     * <p>
     * {@code http://www.geonames.org/ontology#H.HBRX}
     *
     * @see <a href="http://www.geonames.org/ontology#H.HBRX">#H.HBRX</a>
     */
    public static final IRI H_HBRX;

    /**
     * inlet
     * <p>
     * {@code http://www.geonames.org/ontology#H.INLT}
     * <p>
     * a narrow waterway extending into the land, or connecting a bay or
     * lagoon with a larger body of water
     *
     * @see <a href="http://www.geonames.org/ontology#H.INLT">#H.INLT</a>
     */
    public static final IRI H_INLT;

    /**
     * former inlet
     * <p>
     * {@code http://www.geonames.org/ontology#H.INLTQ}
     * <p>
     * an inlet which has been filled in, or blocked by deposits
     *
     * @see <a href="http://www.geonames.org/ontology#H.INLTQ">#H.INLTQ</a>
     */
    public static final IRI H_INLTQ;

    /**
     * gammel innsjøbunn
     * <p>
     * {@code http://www.geonames.org/ontology#H.LBED}
     * <p>
     * a dried up or drained area of a former lake
     *
     * @see <a href="http://www.geonames.org/ontology#H.LBED">#H.LBED</a>
     */
    public static final IRI H_LBED;

    /**
     * lagoon
     * <p>
     * {@code http://www.geonames.org/ontology#H.LGN}
     * <p>
     * a shallow coastal waterbody, completely or partly separated from a
     * larger body of water by a barrier island, coral reef or other
     * depositional feature
     *
     * @see <a href="http://www.geonames.org/ontology#H.LGN">#H.LGN</a>
     */
    public static final IRI H_LGN;

    /**
     * lagoons
     * <p>
     * {@code http://www.geonames.org/ontology#H.LGNS}
     * <p>
     * shallow coastal waterbodies, completely or partly separated from a
     * larger body of water by a barrier island, coral reef or other
     * depositional feature
     *
     * @see <a href="http://www.geonames.org/ontology#H.LGNS">#H.LGNS</a>
     */
    public static final IRI H_LGNS;

    /**
     * del av lagun
     * <p>
     * {@code http://www.geonames.org/ontology#H.LGNX}
     *
     * @see <a href="http://www.geonames.org/ontology#H.LGNX">#H.LGNX</a>
     */
    public static final IRI H_LGNX;

    /**
     * innsjø
     * <p>
     * {@code http://www.geonames.org/ontology#H.LK}
     * <p>
     * a large inland body of standing water
     *
     * @see <a href="http://www.geonames.org/ontology#H.LK">#H.LK</a>
     */
    public static final IRI H_LK;

    /**
     * crater lake
     * <p>
     * {@code http://www.geonames.org/ontology#H.LKC}
     * <p>
     * a lake in a crater or caldera
     *
     * @see <a href="http://www.geonames.org/ontology#H.LKC">#H.LKC</a>
     */
    public static final IRI H_LKC;

    /**
     * intermittent lake
     * <p>
     * {@code http://www.geonames.org/ontology#H.LKI}
     *
     * @see <a href="http://www.geonames.org/ontology#H.LKI">#H.LKI</a>
     */
    public static final IRI H_LKI;

    /**
     * salt lake
     * <p>
     * {@code http://www.geonames.org/ontology#H.LKN}
     * <p>
     * an inland body of salt water with no outlet
     *
     * @see <a href="http://www.geonames.org/ontology#H.LKN">#H.LKN</a>
     */
    public static final IRI H_LKN;

    /**
     * intermittent salt lake
     * <p>
     * {@code http://www.geonames.org/ontology#H.LKNI}
     *
     * @see <a href="http://www.geonames.org/ontology#H.LKNI">#H.LKNI</a>
     */
    public static final IRI H_LKNI;

    /**
     * kroksjø
     * <p>
     * {@code http://www.geonames.org/ontology#H.LKO}
     * <p>
     * a crescent-shaped lake commonly found adjacent to meandering streams
     *
     * @see <a href="http://www.geonames.org/ontology#H.LKO">#H.LKO</a>
     */
    public static final IRI H_LKO;

    /**
     * intermittent oxbow lake
     * <p>
     * {@code http://www.geonames.org/ontology#H.LKOI}
     *
     * @see <a href="http://www.geonames.org/ontology#H.LKOI">#H.LKOI</a>
     */
    public static final IRI H_LKOI;

    /**
     * innsjøer
     * <p>
     * {@code http://www.geonames.org/ontology#H.LKS}
     * <p>
     * large inland bodies of standing water
     *
     * @see <a href="http://www.geonames.org/ontology#H.LKS">#H.LKS</a>
     */
    public static final IRI H_LKS;

    /**
     * underground lake
     * <p>
     * {@code http://www.geonames.org/ontology#H.LKSB}
     * <p>
     * a standing body of water in a cave
     *
     * @see <a href="http://www.geonames.org/ontology#H.LKSB">#H.LKSB</a>
     */
    public static final IRI H_LKSB;

    /**
     * crater lakes
     * <p>
     * {@code http://www.geonames.org/ontology#H.LKSC}
     * <p>
     * lakes in a crater or caldera
     *
     * @see <a href="http://www.geonames.org/ontology#H.LKSC">#H.LKSC</a>
     */
    public static final IRI H_LKSC;

    /**
     * intermittent lakes
     * <p>
     * {@code http://www.geonames.org/ontology#H.LKSI}
     *
     * @see <a href="http://www.geonames.org/ontology#H.LKSI">#H.LKSI</a>
     */
    public static final IRI H_LKSI;

    /**
     * salt lakes
     * <p>
     * {@code http://www.geonames.org/ontology#H.LKSN}
     * <p>
     * inland bodies of salt water with no outlet
     *
     * @see <a href="http://www.geonames.org/ontology#H.LKSN">#H.LKSN</a>
     */
    public static final IRI H_LKSN;

    /**
     * intermittent salt lakes
     * <p>
     * {@code http://www.geonames.org/ontology#H.LKSNI}
     *
     * @see <a href="http://www.geonames.org/ontology#H.LKSNI">#H.LKSNI</a>
     */
    public static final IRI H_LKSNI;

    /**
     * del av innsjø
     * <p>
     * {@code http://www.geonames.org/ontology#H.LKX}
     *
     * @see <a href="http://www.geonames.org/ontology#H.LKX">#H.LKX</a>
     */
    public static final IRI H_LKX;

    /**
     * salt evaporation ponds
     * <p>
     * {@code http://www.geonames.org/ontology#H.MFGN}
     * <p>
     * diked salt ponds used in the production of solar evaporated salt
     *
     * @see <a href="http://www.geonames.org/ontology#H.MFGN">#H.MFGN</a>
     */
    public static final IRI H_MFGN;

    /**
     * mangrove swamp
     * <p>
     * {@code http://www.geonames.org/ontology#H.MGV}
     * <p>
     * a tropical tidal mud flat characterized by mangrove vegetation
     *
     * @see <a href="http://www.geonames.org/ontology#H.MGV">#H.MGV</a>
     */
    public static final IRI H_MGV;

    /**
     * hed(ar)
     * <p>
     * {@code http://www.geonames.org/ontology#H.MOOR}
     * <p>
     * an area of open ground overlaid with wet peaty soils
     *
     * @see <a href="http://www.geonames.org/ontology#H.MOOR">#H.MOOR</a>
     */
    public static final IRI H_MOOR;

    /**
     * marsh(es)
     * <p>
     * {@code http://www.geonames.org/ontology#H.MRSH}
     * <p>
     * a wetland dominated by grass-like vegetation
     *
     * @see <a href="http://www.geonames.org/ontology#H.MRSH">#H.MRSH</a>
     */
    public static final IRI H_MRSH;

    /**
     * marskland
     * <p>
     * {@code http://www.geonames.org/ontology#H.MRSHN}
     * <p>
     * a flat area, subject to periodic salt water inundation, dominated by
     * grassy salt-tolerant plants
     *
     * @see <a href="http://www.geonames.org/ontology#H.MRSHN">#H.MRSHN</a>
     */
    public static final IRI H_MRSHN;

    /**
     * narrows
     * <p>
     * {@code http://www.geonames.org/ontology#H.NRWS}
     * <p>
     * a navigable narrow part of a bay, strait, river, etc.
     *
     * @see <a href="http://www.geonames.org/ontology#H.NRWS">#H.NRWS</a>
     */
    public static final IRI H_NRWS;

    /**
     * hav
     * <p>
     * {@code http://www.geonames.org/ontology#H.OCN}
     * <p>
     * one of the major divisions of the vast expanse of salt water covering
     * part of the earth
     *
     * @see <a href="http://www.geonames.org/ontology#H.OCN">#H.OCN</a>
     */
    public static final IRI H_OCN;

    /**
     * brenninger
     * <p>
     * {@code http://www.geonames.org/ontology#H.OVF}
     * <p>
     * an area of breaking waves caused by the meeting of currents or by
     * waves moving against the current
     *
     * @see <a href="http://www.geonames.org/ontology#H.OVF">#H.OVF</a>
     */
    public static final IRI H_OVF;

    /**
     * damm
     * <p>
     * {@code http://www.geonames.org/ontology#H.PND}
     * <p>
     * a small standing waterbody
     *
     * @see <a href="http://www.geonames.org/ontology#H.PND">#H.PND</a>
     */
    public static final IRI H_PND;

    /**
     * intermittent pond
     * <p>
     * {@code http://www.geonames.org/ontology#H.PNDI}
     *
     * @see <a href="http://www.geonames.org/ontology#H.PNDI">#H.PNDI</a>
     */
    public static final IRI H_PNDI;

    /**
     * salt pond
     * <p>
     * {@code http://www.geonames.org/ontology#H.PNDN}
     * <p>
     * a small standing body of salt water often in a marsh or swamp, usually
     * along a seacoast
     *
     * @see <a href="http://www.geonames.org/ontology#H.PNDN">#H.PNDN</a>
     */
    public static final IRI H_PNDN;

    /**
     * intermittent salt pond(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.PNDNI}
     *
     * @see <a href="http://www.geonames.org/ontology#H.PNDNI">#H.PNDNI</a>
     */
    public static final IRI H_PNDNI;

    /**
     * dammar
     * <p>
     * {@code http://www.geonames.org/ontology#H.PNDS}
     * <p>
     * small standing waterbodies
     *
     * @see <a href="http://www.geonames.org/ontology#H.PNDS">#H.PNDS</a>
     */
    public static final IRI H_PNDS;

    /**
     * fishponds
     * <p>
     * {@code http://www.geonames.org/ontology#H.PNDSF}
     * <p>
     * ponds or enclosures in which fish are kept or raised
     *
     * @see <a href="http://www.geonames.org/ontology#H.PNDSF">#H.PNDSF</a>
     */
    public static final IRI H_PNDSF;

    /**
     * intermittent ponds
     * <p>
     * {@code http://www.geonames.org/ontology#H.PNDSI}
     *
     * @see <a href="http://www.geonames.org/ontology#H.PNDSI">#H.PNDSI</a>
     */
    public static final IRI H_PNDSI;

    /**
     * salt ponds
     * <p>
     * {@code http://www.geonames.org/ontology#H.PNDSN}
     * <p>
     * small standing bodies of salt water often in a marsh or swamp, usually
     * along a seacoast
     *
     * @see <a href="http://www.geonames.org/ontology#H.PNDSN">#H.PNDSN</a>
     */
    public static final IRI H_PNDSN;

    /**
     * kulp
     * <p>
     * {@code http://www.geonames.org/ontology#H.POOL}
     * <p>
     * a small and comparatively still, deep part of a larger body of water
     * such as a stream or harbor; or a small body of standing water
     *
     * @see <a href="http://www.geonames.org/ontology#H.POOL">#H.POOL</a>
     */
    public static final IRI H_POOL;

    /**
     * intermittent pool
     * <p>
     * {@code http://www.geonames.org/ontology#H.POOLI}
     *
     * @see <a href="http://www.geonames.org/ontology#H.POOLI">#H.POOLI</a>
     */
    public static final IRI H_POOLI;

    /**
     * reach
     * <p>
     * {@code http://www.geonames.org/ontology#H.RCH}
     * <p>
     * a straight section of a navigable stream or channel between two bends
     *
     * @see <a href="http://www.geonames.org/ontology#H.RCH">#H.RCH</a>
     */
    public static final IRI H_RCH;

    /**
     * icecap ridge
     * <p>
     * {@code http://www.geonames.org/ontology#H.RDGG}
     * <p>
     * a linear elevation on an icecap
     *
     * @see <a href="http://www.geonames.org/ontology#H.RDGG">#H.RDGG</a>
     */
    public static final IRI H_RDGG;

    /**
     * redd
     * <p>
     * {@code http://www.geonames.org/ontology#H.RDST}
     * <p>
     * an open anchorage affording less protection than a harbor
     *
     * @see <a href="http://www.geonames.org/ontology#H.RDST">#H.RDST</a>
     */
    public static final IRI H_RDST;

    /**
     * reef(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.RF}
     * <p>
     * a surface-navigation hazard composed of consolidated material
     *
     * @see <a href="http://www.geonames.org/ontology#H.RF">#H.RF</a>
     */
    public static final IRI H_RF;

    /**
     * coral reef(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.RFC}
     * <p>
     * a surface-navigation hazard composed of coral
     *
     * @see <a href="http://www.geonames.org/ontology#H.RFC">#H.RFC</a>
     */
    public static final IRI H_RFC;

    /**
     * del av rev
     * <p>
     * {@code http://www.geonames.org/ontology#H.RFX}
     *
     * @see <a href="http://www.geonames.org/ontology#H.RFX">#H.RFX</a>
     */
    public static final IRI H_RFX;

    /**
     * forsar
     * <p>
     * {@code http://www.geonames.org/ontology#H.RPDS}
     * <p>
     * a turbulent section of a stream associated with a steep, irregular
     * stream bed
     *
     * @see <a href="http://www.geonames.org/ontology#H.RPDS">#H.RPDS</a>
     */
    public static final IRI H_RPDS;

    /**
     * reservoar
     * <p>
     * {@code http://www.geonames.org/ontology#H.RSV}
     * <p>
     * an artificial pond or lake
     *
     * @see <a href="http://www.geonames.org/ontology#H.RSV">#H.RSV</a>
     */
    public static final IRI H_RSV;

    /**
     * intermittent reservoir
     * <p>
     * {@code http://www.geonames.org/ontology#H.RSVI}
     *
     * @see <a href="http://www.geonames.org/ontology#H.RSVI">#H.RSVI</a>
     */
    public static final IRI H_RSVI;

    /**
     * vanntank
     * <p>
     * {@code http://www.geonames.org/ontology#H.RSVT}
     * <p>
     * a contained pool or tank of water at, below, or above ground level
     *
     * @see <a href="http://www.geonames.org/ontology#H.RSVT">#H.RSVT</a>
     */
    public static final IRI H_RSVT;

    /**
     * ravin(er)
     * <p>
     * {@code http://www.geonames.org/ontology#H.RVN}
     * <p>
     * a small, narrow, deep, steep-sided stream channel, smaller than a
     * gorge
     *
     * @see <a href="http://www.geonames.org/ontology#H.RVN">#H.RVN</a>
     */
    public static final IRI H_RVN;

    /**
     * sabkha (oversvømt område)
     * <p>
     * {@code http://www.geonames.org/ontology#H.SBKH}
     * <p>
     * a salt flat or salt encrusted plain subject to periodic inundation
     * from flooding or high tides
     *
     * @see <a href="http://www.geonames.org/ontology#H.SBKH">#H.SBKH</a>
     */
    public static final IRI H_SBKH;

    /**
     * sound
     * <p>
     * {@code http://www.geonames.org/ontology#H.SD}
     * <p>
     * a long arm of the sea forming a channel between the mainland and an
     * island or islands; or connecting two larger bodies of water
     *
     * @see <a href="http://www.geonames.org/ontology#H.SD">#H.SD</a>
     */
    public static final IRI H_SD;

    /**
     * hav
     * <p>
     * {@code http://www.geonames.org/ontology#H.SEA}
     * <p>
     * a large body of salt water more or less confined by continuous land or
     * chains of islands forming a subdivision of an ocean
     *
     * @see <a href="http://www.geonames.org/ontology#H.SEA">#H.SEA</a>
     */
    public static final IRI H_SEA;

    /**
     * grund, rev
     * <p>
     * {@code http://www.geonames.org/ontology#H.SHOL}
     * <p>
     * a surface-navigation hazard composed of unconsolidated material
     *
     * @see <a href="http://www.geonames.org/ontology#H.SHOL">#H.SHOL</a>
     */
    public static final IRI H_SHOL;

    /**
     * sill
     * <p>
     * {@code http://www.geonames.org/ontology#H.SILL}
     * <p>
     * the low part of an underwater gap or saddle separating basins,
     * including a similar feature at the mouth of a fjord
     *
     * @see <a href="http://www.geonames.org/ontology#H.SILL">#H.SILL</a>
     */
    public static final IRI H_SILL;

    /**
     * kilde
     * <p>
     * {@code http://www.geonames.org/ontology#H.SPNG}
     * <p>
     * a place where ground water flows naturally out of the ground
     *
     * @see <a href="http://www.geonames.org/ontology#H.SPNG">#H.SPNG</a>
     */
    public static final IRI H_SPNG;

    /**
     * sulphur spring(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.SPNS}
     * <p>
     * a place where sulphur ground water flows naturally out of the ground
     *
     * @see <a href="http://www.geonames.org/ontology#H.SPNS">#H.SPNS</a>
     */
    public static final IRI H_SPNS;

    /**
     * hot spring(s)
     * <p>
     * {@code http://www.geonames.org/ontology#H.SPNT}
     * <p>
     * a place where hot ground water flows naturally out of the ground
     *
     * @see <a href="http://www.geonames.org/ontology#H.SPNT">#H.SPNT</a>
     */
    public static final IRI H_SPNT;

    /**
     * bekk
     * <p>
     * {@code http://www.geonames.org/ontology#H.STM}
     * <p>
     * a body of running water moving to a lower level in a channel on land
     *
     * @see <a href="http://www.geonames.org/ontology#H.STM">#H.STM</a>
     */
    public static final IRI H_STM;

    /**
     * anabranch
     * <p>
     * {@code http://www.geonames.org/ontology#H.STMA}
     * <p>
     * a diverging branch flowing out of a main stream and rejoining it
     * downstream
     *
     * @see <a href="http://www.geonames.org/ontology#H.STMA">#H.STMA</a>
     */
    public static final IRI H_STMA;

    /**
     * elvesving
     * <p>
     * {@code http://www.geonames.org/ontology#H.STMB}
     * <p>
     * a conspicuously curved or bent segment of a stream
     *
     * @see <a href="http://www.geonames.org/ontology#H.STMB">#H.STMB</a>
     */
    public static final IRI H_STMB;

    /**
     * canalized stream
     * <p>
     * {@code http://www.geonames.org/ontology#H.STMC}
     * <p>
     * a stream that has been substantially ditched, diked, or straightened
     *
     * @see <a href="http://www.geonames.org/ontology#H.STMC">#H.STMC</a>
     */
    public static final IRI H_STMC;

    /**
     * biflod(er)
     * <p>
     * {@code http://www.geonames.org/ontology#H.STMD}
     * <p>
     * a branch which flows away from the main stream, as in a delta or
     * irrigation canal
     *
     * @see <a href="http://www.geonames.org/ontology#H.STMD">#H.STMD</a>
     */
    public static final IRI H_STMD;

    /**
     * headwaters
     * <p>
     * {@code http://www.geonames.org/ontology#H.STMH}
     * <p>
     * the source and upper part of a stream, including the upper drainage
     * basin
     *
     * @see <a href="http://www.geonames.org/ontology#H.STMH">#H.STMH</a>
     */
    public static final IRI H_STMH;

    /**
     * intermittent stream
     * <p>
     * {@code http://www.geonames.org/ontology#H.STMI}
     *
     * @see <a href="http://www.geonames.org/ontology#H.STMI">#H.STMI</a>
     */
    public static final IRI H_STMI;

    /**
     * del av periodiskt vattendrag
     * <p>
     * {@code http://www.geonames.org/ontology#H.STMIX}
     *
     * @see <a href="http://www.geonames.org/ontology#H.STMIX">#H.STMIX</a>
     */
    public static final IRI H_STMIX;

    /**
     * bekkeutløp
     * <p>
     * {@code http://www.geonames.org/ontology#H.STMM}
     * <p>
     * a place where a stream discharges into a lagoon, lake, or the sea
     *
     * @see <a href="http://www.geonames.org/ontology#H.STMM">#H.STMM</a>
     */
    public static final IRI H_STMM;

    /**
     * abandoned watercourse
     * <p>
     * {@code http://www.geonames.org/ontology#H.STMQ}
     * <p>
     * a former stream or distributary no longer carrying flowing water, but
     * still evident due to lakes, wetland, topographic or vegetation
     * patterns
     *
     * @see <a href="http://www.geonames.org/ontology#H.STMQ">#H.STMQ</a>
     */
    public static final IRI H_STMQ;

    /**
     * bekker
     * <p>
     * {@code http://www.geonames.org/ontology#H.STMS}
     * <p>
     * bodies of running water moving to a lower level in a channel on land
     *
     * @see <a href="http://www.geonames.org/ontology#H.STMS">#H.STMS</a>
     */
    public static final IRI H_STMS;

    /**
     * elv uten utløp
     * <p>
     * {@code http://www.geonames.org/ontology#H.STMSB}
     * <p>
     * a surface stream that disappears into an underground channel, or dries
     * up in an arid area
     *
     * @see <a href="http://www.geonames.org/ontology#H.STMSB">#H.STMSB</a>
     */
    public static final IRI H_STMSB;

    /**
     * del av bekk
     * <p>
     * {@code http://www.geonames.org/ontology#H.STMX}
     *
     * @see <a href="http://www.geonames.org/ontology#H.STMX">#H.STMX</a>
     */
    public static final IRI H_STMX;

    /**
     * strait
     * <p>
     * {@code http://www.geonames.org/ontology#H.STRT}
     * <p>
     * a relatively narrow waterway, usually narrower and less extensive than
     * a sound, connecting two larger bodies of water
     *
     * @see <a href="http://www.geonames.org/ontology#H.STRT">#H.STRT</a>
     */
    public static final IRI H_STRT;

    /**
     * sump
     * <p>
     * {@code http://www.geonames.org/ontology#H.SWMP}
     * <p>
     * a wetland dominated by tree vegetation
     *
     * @see <a href="http://www.geonames.org/ontology#H.SWMP">#H.SWMP</a>
     */
    public static final IRI H_SWMP;

    /**
     * bevattningssystem
     * <p>
     * {@code http://www.geonames.org/ontology#H.SYSI}
     * <p>
     * a network of ditches and one or more of the following elements: water
     * supply, reservoir, canal, pump, well, drain, etc.
     *
     * @see <a href="http://www.geonames.org/ontology#H.SYSI">#H.SYSI</a>
     */
    public static final IRI H_SYSI;

    /**
     * canal tunnel
     * <p>
     * {@code http://www.geonames.org/ontology#H.TNLC}
     * <p>
     * a tunnel through which a canal passes
     *
     * @see <a href="http://www.geonames.org/ontology#H.TNLC">#H.TNLC</a>
     */
    public static final IRI H_TNLC;

    /**
     * flod
     * <p>
     * {@code http://www.geonames.org/ontology#H.WAD}
     * <p>
     * a valley or ravine, bounded by relatively steep banks, which in the
     * rainy season becomes a watercourse; found primarily in North Africa
     * and the Middle East
     *
     * @see <a href="http://www.geonames.org/ontology#H.WAD">#H.WAD</a>
     */
    public static final IRI H_WAD;

    /**
     * flodkrök
     * <p>
     * {@code http://www.geonames.org/ontology#H.WADB}
     * <p>
     * a conspicuously curved or bent segment of a wadi
     *
     * @see <a href="http://www.geonames.org/ontology#H.WADB">#H.WADB</a>
     */
    public static final IRI H_WADB;

    /**
     * flodförbindning
     * <p>
     * {@code http://www.geonames.org/ontology#H.WADJ}
     * <p>
     * a place where two or more wadies join
     *
     * @see <a href="http://www.geonames.org/ontology#H.WADJ">#H.WADJ</a>
     */
    public static final IRI H_WADJ;

    /**
     * flodmynning
     * <p>
     * {@code http://www.geonames.org/ontology#H.WADM}
     * <p>
     * the lower terminus of a wadi where it widens into an adjoining
     * floodplain, depression, or waterbody
     *
     * @see <a href="http://www.geonames.org/ontology#H.WADM">#H.WADM</a>
     */
    public static final IRI H_WADM;

    /**
     * floder
     * <p>
     * {@code http://www.geonames.org/ontology#H.WADS}
     * <p>
     * valleys or ravines, bounded by relatively steep banks, which in the
     * rainy season become watercourses; found primarily in North Africa and
     * the Middle East
     *
     * @see <a href="http://www.geonames.org/ontology#H.WADS">#H.WADS</a>
     */
    public static final IRI H_WADS;

    /**
     * del av flod
     * <p>
     * {@code http://www.geonames.org/ontology#H.WADX}
     *
     * @see <a href="http://www.geonames.org/ontology#H.WADX">#H.WADX</a>
     */
    public static final IRI H_WADX;

    /**
     * strømvirvel
     * <p>
     * {@code http://www.geonames.org/ontology#H.WHRL}
     * <p>
     * a turbulent, rotating movement of water in a stream
     *
     * @see <a href="http://www.geonames.org/ontology#H.WHRL">#H.WHRL</a>
     */
    public static final IRI H_WHRL;

    /**
     * brunn, källa
     * <p>
     * {@code http://www.geonames.org/ontology#H.WLL}
     * <p>
     * a cylindrical hole, pit, or tunnel drilled or dug down to a depth from
     * which water, oil, or gas can be pumped or brought to the surface
     *
     * @see <a href="http://www.geonames.org/ontology#H.WLL">#H.WLL</a>
     */
    public static final IRI H_WLL;

    /**
     * abandoned well
     * <p>
     * {@code http://www.geonames.org/ontology#H.WLLQ}
     *
     * @see <a href="http://www.geonames.org/ontology#H.WLLQ">#H.WLLQ</a>
     */
    public static final IRI H_WLLQ;

    /**
     * brønner
     * <p>
     * {@code http://www.geonames.org/ontology#H.WLLS}
     * <p>
     * cylindrical holes, pits, or tunnels drilled or dug down to a depth
     * from which water, oil, or gas can be pumped or brought to the surface
     *
     * @see <a href="http://www.geonames.org/ontology#H.WLLS">#H.WLLS</a>
     */
    public static final IRI H_WLLS;

    /**
     * våtmark
     * <p>
     * {@code http://www.geonames.org/ontology#H.WTLD}
     * <p>
     * an area subject to inundation, usually characterized by bog, marsh, or
     * swamp vegetation
     *
     * @see <a href="http://www.geonames.org/ontology#H.WTLD">#H.WTLD</a>
     */
    public static final IRI H_WTLD;

    /**
     * intermittent wetland
     * <p>
     * {@code http://www.geonames.org/ontology#H.WTLDI}
     *
     * @see <a href="http://www.geonames.org/ontology#H.WTLDI">#H.WTLDI</a>
     */
    public static final IRI H_WTLDI;

    /**
     * vannløp
     * <p>
     * {@code http://www.geonames.org/ontology#H.WTRC}
     * <p>
     * a natural, well-defined channel produced by flowing water, or an
     * artificial channel designed to carry flowing water
     *
     * @see <a href="http://www.geonames.org/ontology#H.WTRC">#H.WTRC</a>
     */
    public static final IRI H_WTRC;

    /**
     * vannhull
     * <p>
     * {@code http://www.geonames.org/ontology#H.WTRH}
     * <p>
     * a natural hole, hollow, or small depression that contains water, used
     * by man and animals, especially in arid areas
     *
     * @see <a href="http://www.geonames.org/ontology#H.WTRH">#H.WTRH</a>
     */
    public static final IRI H_WTRH;

    /**
     * historical name
     * <p>
     * {@code http://www.geonames.org/ontology#historicalName}
     *
     * @see <a href="http://www.geonames.org/ontology#historicalName">#historicalName</a>
     */
    public static final IRI historicalName;

    /**
     * {@code http://www.geonames.org/ontology#L}
     * <p>
     * parks,area, ...
     *
     * @see <a href="http://www.geonames.org/ontology#L">#L</a>
     */
    public static final IRI L;

    /**
     * agricultural colony
     * <p>
     * {@code http://www.geonames.org/ontology#L.AGRC}
     * <p>
     * a tract of land set aside for agricultural settlement
     *
     * @see <a href="http://www.geonames.org/ontology#L.AGRC">#L.AGRC</a>
     */
    public static final IRI L_AGRC;

    /**
     * amusement park
     * <p>
     * {@code http://www.geonames.org/ontology#L.AMUS}
     * <p>
     * Amusement Park are theme parks, adventure parks offering
     * entertainment, similar to funfairs but with a fix location
     *
     * @see <a href="http://www.geonames.org/ontology#L.AMUS">#L.AMUS</a>
     */
    public static final IRI L_AMUS;

    /**
     * area, område
     * <p>
     * {@code http://www.geonames.org/ontology#L.AREA}
     * <p>
     * a tract of land without homogeneous character or boundaries
     *
     * @see <a href="http://www.geonames.org/ontology#L.AREA">#L.AREA</a>
     */
    public static final IRI L_AREA;

    /**
     * drainage basin
     * <p>
     * {@code http://www.geonames.org/ontology#L.BSND}
     * <p>
     * an area drained by a stream
     *
     * @see <a href="http://www.geonames.org/ontology#L.BSND">#L.BSND</a>
     */
    public static final IRI L_BSND;

    /**
     * petroleum basin
     * <p>
     * {@code http://www.geonames.org/ontology#L.BSNP}
     * <p>
     * an area underlain by an oil-rich structural basin
     *
     * @see <a href="http://www.geonames.org/ontology#L.BSNP">#L.BSNP</a>
     */
    public static final IRI L_BSNP;

    /**
     * battlefield
     * <p>
     * {@code http://www.geonames.org/ontology#L.BTL}
     * <p>
     * a site of a land battle of historical importance
     *
     * @see <a href="http://www.geonames.org/ontology#L.BTL">#L.BTL</a>
     */
    public static final IRI L_BTL;

    /**
     * clearing
     * <p>
     * {@code http://www.geonames.org/ontology#L.CLG}
     * <p>
     * an area in a forest with trees removed
     *
     * @see <a href="http://www.geonames.org/ontology#L.CLG">#L.CLG</a>
     */
    public static final IRI L_CLG;

    /**
     * allmenning
     * <p>
     * {@code http://www.geonames.org/ontology#L.CMN}
     * <p>
     * a park or pasture for community use
     *
     * @see <a href="http://www.geonames.org/ontology#L.CMN">#L.CMN</a>
     */
    public static final IRI L_CMN;

    /**
     * concession area
     * <p>
     * {@code http://www.geonames.org/ontology#L.CNS}
     * <p>
     * a lease of land by a government for economic development, e.g.,
     * mining, forestry
     *
     * @see <a href="http://www.geonames.org/ontology#L.CNS">#L.CNS</a>
     */
    public static final IRI L_CNS;

    /**
     * coalfield
     * <p>
     * {@code http://www.geonames.org/ontology#L.COLF}
     * <p>
     * a region in which coal deposits of possible economic value occur
     *
     * @see <a href="http://www.geonames.org/ontology#L.COLF">#L.COLF</a>
     */
    public static final IRI L_COLF;

    /**
     * continent
     * <p>
     * {@code http://www.geonames.org/ontology#L.CONT}
     * <p>
     * continent : Europe, Africa, Asia, North America, South America,
     * Oceania,Antarctica
     *
     * @see <a href="http://www.geonames.org/ontology#L.CONT">#L.CONT</a>
     */
    public static final IRI L_CONT;

    /**
     * coast
     * <p>
     * {@code http://www.geonames.org/ontology#L.CST}
     * <p>
     * a zone of variable width straddling the shoreline
     *
     * @see <a href="http://www.geonames.org/ontology#L.CST">#L.CST</a>
     */
    public static final IRI L_CST;

    /**
     * affärscenter
     * <p>
     * {@code http://www.geonames.org/ontology#L.CTRB}
     * <p>
     * a place where a number of businesses are located
     *
     * @see <a href="http://www.geonames.org/ontology#L.CTRB">#L.CTRB</a>
     */
    public static final IRI L_CTRB;

    /**
     * boligområde
     * <p>
     * {@code http://www.geonames.org/ontology#L.DEVH}
     * <p>
     * a tract of land on which many houses of similar design are built
     * according to a development plan
     *
     * @see <a href="http://www.geonames.org/ontology#L.DEVH">#L.DEVH</a>
     */
    public static final IRI L_DEVH;

    /**
     * field(s)
     * <p>
     * {@code http://www.geonames.org/ontology#L.FLD}
     * <p>
     * an open as opposed to wooded area
     *
     * @see <a href="http://www.geonames.org/ontology#L.FLD">#L.FLD</a>
     */
    public static final IRI L_FLD;

    /**
     * (konst)bevattnade fält
     * <p>
     * {@code http://www.geonames.org/ontology#L.FLDI}
     * <p>
     * a tract of level or terraced land which is irrigated
     *
     * @see <a href="http://www.geonames.org/ontology#L.FLDI">#L.FLDI</a>
     */
    public static final IRI L_FLDI;

    /**
     * gasfield
     * <p>
     * {@code http://www.geonames.org/ontology#L.GASF}
     * <p>
     * an area containing a subterranean store of natural gas of economic
     * value
     *
     * @see <a href="http://www.geonames.org/ontology#L.GASF">#L.GASF</a>
     */
    public static final IRI L_GASF;

    /**
     * beiteområde
     * <p>
     * {@code http://www.geonames.org/ontology#L.GRAZ}
     * <p>
     * an area of grasses and shrubs used for grazing
     *
     * @see <a href="http://www.geonames.org/ontology#L.GRAZ">#L.GRAZ</a>
     */
    public static final IRI L_GRAZ;

    /**
     * gravel area
     * <p>
     * {@code http://www.geonames.org/ontology#L.GVL}
     * <p>
     * an area covered with gravel
     *
     * @see <a href="http://www.geonames.org/ontology#L.GVL">#L.GVL</a>
     */
    public static final IRI L_GVL;

    /**
     * industrial area
     * <p>
     * {@code http://www.geonames.org/ontology#L.INDS}
     * <p>
     * an area characterized by industrial activity
     *
     * @see <a href="http://www.geonames.org/ontology#L.INDS">#L.INDS</a>
     */
    public static final IRI L_INDS;

    /**
     * arctic land
     * <p>
     * {@code http://www.geonames.org/ontology#L.LAND}
     * <p>
     * a tract of land in the Arctic
     *
     * @see <a href="http://www.geonames.org/ontology#L.LAND">#L.LAND</a>
     */
    public static final IRI L_LAND;

    /**
     * locality
     * <p>
     * {@code http://www.geonames.org/ontology#L.LCTY}
     * <p>
     * a minor area or place of unspecified or mixed character and indefinite
     * boundaries
     *
     * @see <a href="http://www.geonames.org/ontology#L.LCTY">#L.LCTY</a>
     */
    public static final IRI L_LCTY;

    /**
     * military base
     * <p>
     * {@code http://www.geonames.org/ontology#L.MILB}
     * <p>
     * a place used by an army or other armed service for storing arms and
     * supplies, and for accommodating and training troops, a base from which
     * operations can be initiated
     *
     * @see <a href="http://www.geonames.org/ontology#L.MILB">#L.MILB</a>
     */
    public static final IRI L_MILB;

    /**
     * gruveområde
     * <p>
     * {@code http://www.geonames.org/ontology#L.MNA}
     * <p>
     * an area of mine sites where minerals and ores are extracted
     *
     * @see <a href="http://www.geonames.org/ontology#L.MNA">#L.MNA</a>
     */
    public static final IRI L_MNA;

    /**
     * maneuver area
     * <p>
     * {@code http://www.geonames.org/ontology#L.MVA}
     * <p>
     * a tract of land where military field exercises are carried out
     *
     * @see <a href="http://www.geonames.org/ontology#L.MVA">#L.MVA</a>
     */
    public static final IRI L_MVA;

    /**
     * marinbas
     * <p>
     * {@code http://www.geonames.org/ontology#L.NVB}
     * <p>
     * an area used to store supplies, provide barracks for troops and naval
     * personnel, a port for naval vessels, and from which operations are
     * initiated
     *
     * @see <a href="http://www.geonames.org/ontology#L.NVB">#L.NVB</a>
     */
    public static final IRI L_NVB;

    /**
     * oas(er)
     * <p>
     * {@code http://www.geonames.org/ontology#L.OAS}
     * <p>
     * an area in a desert made productive by the availability of water
     *
     * @see <a href="http://www.geonames.org/ontology#L.OAS">#L.OAS</a>
     */
    public static final IRI L_OAS;

    /**
     * oilfield
     * <p>
     * {@code http://www.geonames.org/ontology#L.OILF}
     * <p>
     * an area containing a subterranean store of petroleum of economic value
     *
     * @see <a href="http://www.geonames.org/ontology#L.OILF">#L.OILF</a>
     */
    public static final IRI L_OILF;

    /**
     * peat cutting area
     * <p>
     * {@code http://www.geonames.org/ontology#L.PEAT}
     * <p>
     * an area where peat is harvested
     *
     * @see <a href="http://www.geonames.org/ontology#L.PEAT">#L.PEAT</a>
     */
    public static final IRI L_PEAT;

    /**
     * park
     * <p>
     * {@code http://www.geonames.org/ontology#L.PRK}
     * <p>
     * an area, often of forested land, maintained as a place of beauty, or
     * for recreation
     *
     * @see <a href="http://www.geonames.org/ontology#L.PRK">#L.PRK</a>
     */
    public static final IRI L_PRK;

    /**
     * hamn
     * <p>
     * {@code http://www.geonames.org/ontology#L.PRT}
     * <p>
     * a place provided with terminal and transfer facilities for loading and
     * discharging waterborne cargo or passengers, usually located in a
     * harbor
     *
     * @see <a href="http://www.geonames.org/ontology#L.PRT">#L.PRT</a>
     */
    public static final IRI L_PRT;

    /**
     * kvicksand
     * <p>
     * {@code http://www.geonames.org/ontology#L.QCKS}
     * <p>
     * an area where loose sand with water moving through it may become
     * unstable when heavy objects are placed at the surface, causing them to
     * sink
     *
     * @see <a href="http://www.geonames.org/ontology#L.QCKS">#L.QCKS</a>
     */
    public static final IRI L_QCKS;

    /**
     * republic
     * <p>
     * {@code http://www.geonames.org/ontology#L.REP}
     *
     * @see <a href="http://www.geonames.org/ontology#L.REP">#L.REP</a>
     */
    public static final IRI L_REP;

    /**
     * regulert område
     * <p>
     * {@code http://www.geonames.org/ontology#L.RES}
     * <p>
     * a tract of public land reserved for future use or restricted as to use
     *
     * @see <a href="http://www.geonames.org/ontology#L.RES">#L.RES</a>
     */
    public static final IRI L_RES;

    /**
     * agricultural reserve
     * <p>
     * {@code http://www.geonames.org/ontology#L.RESA}
     * <p>
     * a tract of land reserved for agricultural reclamation and/or
     * development
     *
     * @see <a href="http://www.geonames.org/ontology#L.RESA">#L.RESA</a>
     */
    public static final IRI L_RESA;

    /**
     * forest reserve
     * <p>
     * {@code http://www.geonames.org/ontology#L.RESF}
     * <p>
     * a forested area set aside for preservation or controlled use
     *
     * @see <a href="http://www.geonames.org/ontology#L.RESF">#L.RESF</a>
     */
    public static final IRI L_RESF;

    /**
     * hunting reserve
     * <p>
     * {@code http://www.geonames.org/ontology#L.RESH}
     * <p>
     * a tract of land used primarily for hunting
     *
     * @see <a href="http://www.geonames.org/ontology#L.RESH">#L.RESH</a>
     */
    public static final IRI L_RESH;

    /**
     * nature reserve
     * <p>
     * {@code http://www.geonames.org/ontology#L.RESN}
     * <p>
     * an area reserved for the maintenance of a natural habitat
     *
     * @see <a href="http://www.geonames.org/ontology#L.RESN">#L.RESN</a>
     */
    public static final IRI L_RESN;

    /**
     * palm tree reserve
     * <p>
     * {@code http://www.geonames.org/ontology#L.RESP}
     * <p>
     * an area of palm trees where use is controlled
     *
     * @see <a href="http://www.geonames.org/ontology#L.RESP">#L.RESP</a>
     */
    public static final IRI L_RESP;

    /**
     * reservat
     * <p>
     * {@code http://www.geonames.org/ontology#L.RESV}
     * <p>
     * a tract of land set aside for aboriginal, tribal, or native
     * populations
     *
     * @see <a href="http://www.geonames.org/ontology#L.RESV">#L.RESV</a>
     */
    public static final IRI L_RESV;

    /**
     * viltreservat
     * <p>
     * {@code http://www.geonames.org/ontology#L.RESW}
     * <p>
     * a tract of public land reserved for the preservation of wildlife
     *
     * @see <a href="http://www.geonames.org/ontology#L.RESW">#L.RESW</a>
     */
    public static final IRI L_RESW;

    /**
     * region
     * <p>
     * {@code http://www.geonames.org/ontology#L.RGN}
     * <p>
     * an area distinguished by one or more observable physical or cultural
     * characteristics
     *
     * @see <a href="http://www.geonames.org/ontology#L.RGN">#L.RGN</a>
     */
    public static final IRI L_RGN;

    /**
     * economic region
     * <p>
     * {@code http://www.geonames.org/ontology#L.RGNE}
     * <p>
     * a region of a country established for economic development or for
     * statistical purposes
     *
     * @see <a href="http://www.geonames.org/ontology#L.RGNE">#L.RGNE</a>
     */
    public static final IRI L_RGNE;

    /**
     * historical region
     * <p>
     * {@code http://www.geonames.org/ontology#L.RGNH}
     *
     * @see <a href="http://www.geonames.org/ontology#L.RGNH">#L.RGNH</a>
     */
    public static final IRI L_RGNH;

    /**
     * innsjøområde
     * <p>
     * {@code http://www.geonames.org/ontology#L.RGNL}
     * <p>
     * a tract of land distinguished by numerous lakes
     *
     * @see <a href="http://www.geonames.org/ontology#L.RGNL">#L.RGNL</a>
     */
    public static final IRI L_RGNL;

    /**
     * artillery range
     * <p>
     * {@code http://www.geonames.org/ontology#L.RNGA}
     * <p>
     * a tract of land used for artillery firing practice
     *
     * @see <a href="http://www.geonames.org/ontology#L.RNGA">#L.RNGA</a>
     */
    public static final IRI L_RNGA;

    /**
     * salt area
     * <p>
     * {@code http://www.geonames.org/ontology#L.SALT}
     * <p>
     * a shallow basin or flat where salt accumulates after periodic
     * inundation
     *
     * @see <a href="http://www.geonames.org/ontology#L.SALT">#L.SALT</a>
     */
    public static final IRI L_SALT;

    /**
     * snowfield
     * <p>
     * {@code http://www.geonames.org/ontology#L.SNOW}
     * <p>
     * an area of permanent snow and ice forming the accumulation area of a
     * glacier
     *
     * @see <a href="http://www.geonames.org/ontology#L.SNOW">#L.SNOW</a>
     */
    public static final IRI L_SNOW;

    /**
     * stammeområde
     * <p>
     * {@code http://www.geonames.org/ontology#L.TRB}
     * <p>
     * a tract of land used by nomadic or other tribes
     *
     * @see <a href="http://www.geonames.org/ontology#L.TRB">#L.TRB</a>
     */
    public static final IRI L_TRB;

    /**
     * master source holdings list
     * <p>
     * {@code http://www.geonames.org/ontology#L.ZZZZZ}
     *
     * @see <a href="http://www.geonames.org/ontology#L.ZZZZZ">#L.ZZZZZ</a>
     */
    public static final IRI L_ZZZZZ;

    /**
     * located in
     * <p>
     * {@code http://www.geonames.org/ontology#locatedIn}
     * <p>
     * Indicates that the subject resource is located in the object feature
     *
     * @see <a href="http://www.geonames.org/ontology#locatedIn">#locatedIn</a>
     */
    public static final IRI locatedIn;

    /**
     * map
     * <p>
     * {@code http://www.geonames.org/ontology#locationMap}
     * <p>
     * A geonames map centered on the feature.
     *
     * @see <a href="http://www.geonames.org/ontology#locationMap">#locationMap</a>
     */
    public static final IRI locationMap;

    /**
     * Map
     * <p>
     * {@code http://www.geonames.org/ontology#Map}
     * <p>
     * A Web page displaying a map
     *
     * @see <a href="http://www.geonames.org/ontology#Map">#Map</a>
     */
    public static final IRI Map;

    /**
     * {@code http://www.geonames.org/ontology#Marc-Wick}
     *
     * @see <a href="http://www.geonames.org/ontology#Marc-Wick">#Marc-Wick</a>
     */
    public static final IRI Marc_Wick;

    /**
     * name
     * <p>
     * {@code http://www.geonames.org/ontology#name}
     * <p>
     * The main international name of a feature. The value has no xml:lang
     * tag.
     *
     * @see <a href="http://www.geonames.org/ontology#name">#name</a>
     */
    public static final IRI name;

    /**
     * nearby
     * <p>
     * {@code http://www.geonames.org/ontology#nearby}
     * <p>
     * A feature close to the reference feature
     *
     * @see <a href="http://www.geonames.org/ontology#nearby">#nearby</a>
     */
    public static final IRI nearby;

    /**
     * nearby features
     * <p>
     * {@code http://www.geonames.org/ontology#nearbyFeatures}
     * <p>
     * Links to an RDF document containing the descriptions of nearby
     * features
     *
     * @see <a href="http://www.geonames.org/ontology#nearbyFeatures">#nearbyFeatures</a>
     */
    public static final IRI nearbyFeatures;

    /**
     * neighbour
     * <p>
     * {@code http://www.geonames.org/ontology#neighbour}
     * <p>
     * A feature sharing a common boarder with the reference feature
     *
     * @see <a href="http://www.geonames.org/ontology#neighbour">#neighbour</a>
     */
    public static final IRI neighbour;

    /**
     * neighbouring features
     * <p>
     * {@code http://www.geonames.org/ontology#neighbouringFeatures}
     * <p>
     * Links to an RDF document containing the descriptions of neighbouring
     * features. Applies when the feature has definite boarders.
     *
     * @see <a href="http://www.geonames.org/ontology#neighbouringFeatures">#neighbouringFeatures</a>
     */
    public static final IRI neighbouringFeatures;

    /**
     * official name
     * <p>
     * {@code http://www.geonames.org/ontology#officialName}
     * <p>
     * A name in an official local language
     *
     * @see <a href="http://www.geonames.org/ontology#officialName">#officialName</a>
     */
    public static final IRI officialName;

    /**
     * {@code http://www.geonames.org/ontology#P}
     * <p>
     * city, village,...
     *
     * @see <a href="http://www.geonames.org/ontology#P">#P</a>
     */
    public static final IRI P;

    /**
     * befolkad plats
     * <p>
     * {@code http://www.geonames.org/ontology#P.PPL}
     * <p>
     * a city, town, village, or other agglomeration of buildings where
     * people live and work
     *
     * @see <a href="http://www.geonames.org/ontology#P.PPL">#P.PPL</a>
     */
    public static final IRI P_PPL;

    /**
     * seat of a first-order administrative
     * division
     * <p>
     * {@code http://www.geonames.org/ontology#P.PPLA}
     * <p>
     * seat of a first-order administrative division (PPLC takes precedence
     * over PPLA)
     *
     * @see <a href="http://www.geonames.org/ontology#P.PPLA">#P.PPLA</a>
     */
    public static final IRI P_PPLA;

    /**
     * seat of a second-order administrative division
     * <p>
     * {@code http://www.geonames.org/ontology#P.PPLA2}
     *
     * @see <a href="http://www.geonames.org/ontology#P.PPLA2">#P.PPLA2</a>
     */
    public static final IRI P_PPLA2;

    /**
     * seat of a third-order administrative division
     * <p>
     * {@code http://www.geonames.org/ontology#P.PPLA3}
     *
     * @see <a href="http://www.geonames.org/ontology#P.PPLA3">#P.PPLA3</a>
     */
    public static final IRI P_PPLA3;

    /**
     * seat of a fourth-order administrative division
     * <p>
     * {@code http://www.geonames.org/ontology#P.PPLA4}
     *
     * @see <a href="http://www.geonames.org/ontology#P.PPLA4">#P.PPLA4</a>
     */
    public static final IRI P_PPLA4;

    /**
     * Hovedstad
     * <p>
     * {@code http://www.geonames.org/ontology#P.PPLC}
     *
     * @see <a href="http://www.geonames.org/ontology#P.PPLC">#P.PPLC</a>
     */
    public static final IRI P_PPLC;

    /**
     * farm village
     * <p>
     * {@code http://www.geonames.org/ontology#P.PPLF}
     * <p>
     * a populated place where the population is largely engaged in
     * agricultural activities
     *
     * @see <a href="http://www.geonames.org/ontology#P.PPLF">#P.PPLF</a>
     */
    public static final IRI P_PPLF;

    /**
     * regjeringssete i en politisk enhet
     * <p>
     * {@code http://www.geonames.org/ontology#P.PPLG}
     *
     * @see <a href="http://www.geonames.org/ontology#P.PPLG">#P.PPLG</a>
     */
    public static final IRI P_PPLG;

    /**
     * befolkad ort
     * <p>
     * {@code http://www.geonames.org/ontology#P.PPLL}
     * <p>
     * an area similar to a locality but with a small group of dwellings or
     * other buildings
     *
     * @see <a href="http://www.geonames.org/ontology#P.PPLL">#P.PPLL</a>
     */
    public static final IRI P_PPLL;

    /**
     * abandoned populated place
     * <p>
     * {@code http://www.geonames.org/ontology#P.PPLQ}
     *
     * @see <a href="http://www.geonames.org/ontology#P.PPLQ">#P.PPLQ</a>
     */
    public static final IRI P_PPLQ;

    /**
     * religious populated place
     * <p>
     * {@code http://www.geonames.org/ontology#P.PPLR}
     * <p>
     * a populated place whose population is largely engaged in religious
     * occupations
     *
     * @see <a href="http://www.geonames.org/ontology#P.PPLR">#P.PPLR</a>
     */
    public static final IRI P_PPLR;

    /**
     * befolkade platser
     * <p>
     * {@code http://www.geonames.org/ontology#P.PPLS}
     * <p>
     * cities, towns, villages, or other agglomerations of buildings where
     * people live and work
     *
     * @see <a href="http://www.geonames.org/ontology#P.PPLS">#P.PPLS</a>
     */
    public static final IRI P_PPLS;

    /**
     * destroyed populated place
     * <p>
     * {@code http://www.geonames.org/ontology#P.PPLW}
     * <p>
     * a village, town or city destroyed by a natural disaster, or by war
     *
     * @see <a href="http://www.geonames.org/ontology#P.PPLW">#P.PPLW</a>
     */
    public static final IRI P_PPLW;

    /**
     * del av befolkad plats
     * <p>
     * {@code http://www.geonames.org/ontology#P.PPLX}
     *
     * @see <a href="http://www.geonames.org/ontology#P.PPLX">#P.PPLX</a>
     */
    public static final IRI P_PPLX;

    /**
     * israeli settlement
     * <p>
     * {@code http://www.geonames.org/ontology#P.STLMT}
     *
     * @see <a href="http://www.geonames.org/ontology#P.STLMT">#P.STLMT</a>
     */
    public static final IRI P_STLMT;

    /**
     * level 1 administrative parent
     * <p>
     * {@code http://www.geonames.org/ontology#parentADM1}
     *
     * @see <a href="http://www.geonames.org/ontology#parentADM1">#parentADM1</a>
     */
    public static final IRI parentADM1;

    /**
     * level 2 administrative parent
     * <p>
     * {@code http://www.geonames.org/ontology#parentADM2}
     *
     * @see <a href="http://www.geonames.org/ontology#parentADM2">#parentADM2</a>
     */
    public static final IRI parentADM2;

    /**
     * level 3 administrative parent
     * <p>
     * {@code http://www.geonames.org/ontology#parentADM3}
     *
     * @see <a href="http://www.geonames.org/ontology#parentADM3">#parentADM3</a>
     */
    public static final IRI parentADM3;

    /**
     * level 4 administrative parent
     * <p>
     * {@code http://www.geonames.org/ontology#parentADM4}
     *
     * @see <a href="http://www.geonames.org/ontology#parentADM4">#parentADM4</a>
     */
    public static final IRI parentADM4;

    /**
     * parent country
     * <p>
     * {@code http://www.geonames.org/ontology#parentCountry}
     *
     * @see <a href="http://www.geonames.org/ontology#parentCountry">#parentCountry</a>
     */
    public static final IRI parentCountry;

    /**
     * parent feature
     * <p>
     * {@code http://www.geonames.org/ontology#parentFeature}
     * <p>
     * A feature parent of the current one, in either administrative or
     * physical subdivision.
     *
     * @see <a href="http://www.geonames.org/ontology#parentFeature">#parentFeature</a>
     */
    public static final IRI parentFeature;

    /**
     * population
     * <p>
     * {@code http://www.geonames.org/ontology#population}
     *
     * @see <a href="http://www.geonames.org/ontology#population">#population</a>
     */
    public static final IRI population;

    /**
     * postal code
     * <p>
     * {@code http://www.geonames.org/ontology#postalCode}
     *
     * @see <a href="http://www.geonames.org/ontology#postalCode">#postalCode</a>
     */
    public static final IRI postalCode;

    /**
     * {@code http://www.geonames.org/ontology#R}
     * <p>
     * road, railroad, ...
     *
     * @see <a href="http://www.geonames.org/ontology#R">#R</a>
     */
    public static final IRI R;

    /**
     * broväg, höjd gångbana
     * <p>
     * {@code http://www.geonames.org/ontology#R.CSWY}
     * <p>
     * a raised roadway across wet ground or shallow water
     *
     * @see <a href="http://www.geonames.org/ontology#R.CSWY">#R.CSWY</a>
     */
    public static final IRI R_CSWY;

    /**
     * former causeway
     * <p>
     * {@code http://www.geonames.org/ontology#R.CSWYQ}
     * <p>
     * a causeway no longer used for transportation
     *
     * @see <a href="http://www.geonames.org/ontology#R.CSWYQ">#R.CSWYQ</a>
     */
    public static final IRI R_CSWYQ;

    /**
     * oil pipeline
     * <p>
     * {@code http://www.geonames.org/ontology#R.OILP}
     * <p>
     * a pipeline used for transporting oil
     *
     * @see <a href="http://www.geonames.org/ontology#R.OILP">#R.OILP</a>
     */
    public static final IRI R_OILP;

    /**
     * promenad
     * <p>
     * {@code http://www.geonames.org/ontology#R.PRMN}
     * <p>
     * a place for public walking, usually along a beach front
     *
     * @see <a href="http://www.geonames.org/ontology#R.PRMN">#R.PRMN</a>
     */
    public static final IRI R_PRMN;

    /**
     * eid
     * <p>
     * {@code http://www.geonames.org/ontology#R.PTGE}
     * <p>
     * a place where boats, goods, etc., are carried overland between
     * navigable waters
     *
     * @see <a href="http://www.geonames.org/ontology#R.PTGE">#R.PTGE</a>
     */
    public static final IRI R_PTGE;

    /**
     * road
     * <p>
     * {@code http://www.geonames.org/ontology#R.RD}
     * <p>
     * an open way with improved surface for transportation of animals,
     * people and vehicles
     *
     * @see <a href="http://www.geonames.org/ontology#R.RD">#R.RD</a>
     */
    public static final IRI R_RD;

    /**
     * ancient road
     * <p>
     * {@code http://www.geonames.org/ontology#R.RDA}
     * <p>
     * the remains of a road used by ancient cultures
     *
     * @see <a href="http://www.geonames.org/ontology#R.RDA">#R.RDA</a>
     */
    public static final IRI R_RDA;

    /**
     * road bend
     * <p>
     * {@code http://www.geonames.org/ontology#R.RDB}
     * <p>
     * a conspicuously curved or bent section of a road
     *
     * @see <a href="http://www.geonames.org/ontology#R.RDB">#R.RDB</a>
     */
    public static final IRI R_RDB;

    /**
     * road cut
     * <p>
     * {@code http://www.geonames.org/ontology#R.RDCUT}
     * <p>
     * an excavation cut through a hill or ridge for a road
     *
     * @see <a href="http://www.geonames.org/ontology#R.RDCUT">#R.RDCUT</a>
     */
    public static final IRI R_RDCUT;

    /**
     * road junction
     * <p>
     * {@code http://www.geonames.org/ontology#R.RDJCT}
     * <p>
     * a place where two or more roads join
     *
     * @see <a href="http://www.geonames.org/ontology#R.RDJCT">#R.RDJCT</a>
     */
    public static final IRI R_RDJCT;

    /**
     * jernbanekryss
     * <p>
     * {@code http://www.geonames.org/ontology#R.RJCT}
     * <p>
     * a place where two or more railroad tracks join
     *
     * @see <a href="http://www.geonames.org/ontology#R.RJCT">#R.RJCT</a>
     */
    public static final IRI R_RJCT;

    /**
     * jernbane
     * <p>
     * {@code http://www.geonames.org/ontology#R.RR}
     * <p>
     * a permanent twin steel-rail track on which freight and passenger cars
     * move long distances
     *
     * @see <a href="http://www.geonames.org/ontology#R.RR">#R.RR</a>
     */
    public static final IRI R_RR;

    /**
     * abandoned railroad
     * <p>
     * {@code http://www.geonames.org/ontology#R.RRQ}
     *
     * @see <a href="http://www.geonames.org/ontology#R.RRQ">#R.RRQ</a>
     */
    public static final IRI R_RRQ;

    /**
     * caravan route
     * <p>
     * {@code http://www.geonames.org/ontology#R.RTE}
     * <p>
     * the route taken by caravans
     *
     * @see <a href="http://www.geonames.org/ontology#R.RTE">#R.RTE</a>
     */
    public static final IRI R_RTE;

    /**
     * jernbaneområde
     * <p>
     * {@code http://www.geonames.org/ontology#R.RYD}
     * <p>
     * a system of tracks used for the making up of trains, and switching and
     * storing freight cars
     *
     * @see <a href="http://www.geonames.org/ontology#R.RYD">#R.RYD</a>
     */
    public static final IRI R_RYD;

    /**
     * gate
     * <p>
     * {@code http://www.geonames.org/ontology#R.ST}
     * <p>
     * a paved urban thoroughfare
     *
     * @see <a href="http://www.geonames.org/ontology#R.ST">#R.ST</a>
     */
    public static final IRI R_ST;

    /**
     * boskapsled
     * <p>
     * {@code http://www.geonames.org/ontology#R.STKR}
     * <p>
     * a route taken by livestock herds
     *
     * @see <a href="http://www.geonames.org/ontology#R.STKR">#R.STKR</a>
     */
    public static final IRI R_STKR;

    /**
     * tunnel
     * <p>
     * {@code http://www.geonames.org/ontology#R.TNL}
     * <p>
     * a subterranean passageway for transportation
     *
     * @see <a href="http://www.geonames.org/ontology#R.TNL">#R.TNL</a>
     */
    public static final IRI R_TNL;

    /**
     * natural tunnel
     * <p>
     * {@code http://www.geonames.org/ontology#R.TNLN}
     * <p>
     * a cave that is open at both ends
     *
     * @see <a href="http://www.geonames.org/ontology#R.TNLN">#R.TNLN</a>
     */
    public static final IRI R_TNLN;

    /**
     * road tunnel
     * <p>
     * {@code http://www.geonames.org/ontology#R.TNLRD}
     * <p>
     * a tunnel through which a road passes
     *
     * @see <a href="http://www.geonames.org/ontology#R.TNLRD">#R.TNLRD</a>
     */
    public static final IRI R_TNLRD;

    /**
     * jernbanetunnel
     * <p>
     * {@code http://www.geonames.org/ontology#R.TNLRR}
     * <p>
     * a tunnel through which a railroad passes
     *
     * @see <a href="http://www.geonames.org/ontology#R.TNLRR">#R.TNLRR</a>
     */
    public static final IRI R_TNLRR;

    /**
     * tunneler
     * <p>
     * {@code http://www.geonames.org/ontology#R.TNLS}
     * <p>
     * subterranean passageways for transportation
     *
     * @see <a href="http://www.geonames.org/ontology#R.TNLS">#R.TNLS</a>
     */
    public static final IRI R_TNLS;

    /**
     * spår, stig
     * <p>
     * {@code http://www.geonames.org/ontology#R.TRL}
     * <p>
     * a path, track, or route used by pedestrians, animals, or off-road
     * vehicles
     *
     * @see <a href="http://www.geonames.org/ontology#R.TRL">#R.TRL</a>
     */
    public static final IRI R_TRL;

    /**
     * RDF Data
     * <p>
     * {@code http://www.geonames.org/ontology#RDFData}
     * <p>
     * A Document containing RDF description of one or several features.
     *
     * @see <a href="http://www.geonames.org/ontology#RDFData">#RDFData</a>
     */
    public static final IRI RDFData;

    /**
     * {@code http://www.geonames.org/ontology#S}
     * <p>
     * spot, building, farm, ...
     *
     * @see <a href="http://www.geonames.org/ontology#S">#S</a>
     */
    public static final IRI S;

    /**
     * administrasjonsanlegg
     * <p>
     * {@code http://www.geonames.org/ontology#S.ADMF}
     * <p>
     * a government building
     *
     * @see <a href="http://www.geonames.org/ontology#S.ADMF">#S.ADMF</a>
     */
    public static final IRI S_ADMF;

    /**
     * agricultural facility
     * <p>
     * {@code http://www.geonames.org/ontology#S.AGRF}
     * <p>
     * a building and/or tract of land used for improving agriculture
     *
     * @see <a href="http://www.geonames.org/ontology#S.AGRF">#S.AGRF</a>
     */
    public static final IRI S_AGRF;

    /**
     * airbase
     * <p>
     * {@code http://www.geonames.org/ontology#S.AIRB}
     * <p>
     * an area used to store supplies, provide barracks for air force
     * personnel, hangars and runways for aircraft, and from which operations
     * are initiated
     *
     * @see <a href="http://www.geonames.org/ontology#S.AIRB">#S.AIRB</a>
     */
    public static final IRI S_AIRB;

    /**
     * airfield
     * <p>
     * {@code http://www.geonames.org/ontology#S.AIRF}
     * <p>
     * a place on land where aircraft land and take off; no facilities
     * provided for the commercial handling of passengers and cargo
     *
     * @see <a href="http://www.geonames.org/ontology#S.AIRF">#S.AIRF</a>
     */
    public static final IRI S_AIRF;

    /**
     * heliport
     * <p>
     * {@code http://www.geonames.org/ontology#S.AIRH}
     * <p>
     * a place where helicopters land and take off
     *
     * @see <a href="http://www.geonames.org/ontology#S.AIRH">#S.AIRH</a>
     */
    public static final IRI S_AIRH;

    /**
     * airport
     * <p>
     * {@code http://www.geonames.org/ontology#S.AIRP}
     * <p>
     * a place where aircraft regularly land and take off, with runways,
     * navigational aids, and major facilities for the commercial handling of
     * passengers and cargo
     *
     * @see <a href="http://www.geonames.org/ontology#S.AIRP">#S.AIRP</a>
     */
    public static final IRI S_AIRP;

    /**
     * abandoned airfield
     * <p>
     * {@code http://www.geonames.org/ontology#S.AIRQ}
     *
     * @see <a href="http://www.geonames.org/ontology#S.AIRQ">#S.AIRQ</a>
     */
    public static final IRI S_AIRQ;

    /**
     * amfiteater
     * <p>
     * {@code http://www.geonames.org/ontology#S.AMTH}
     * <p>
     * an oval or circular structure with rising tiers of seats about a stage
     * or open space
     *
     * @see <a href="http://www.geonames.org/ontology#S.AMTH">#S.AMTH</a>
     */
    public static final IRI S_AMTH;

    /**
     * ancient site
     * <p>
     * {@code http://www.geonames.org/ontology#S.ANS}
     * <p>
     * a place where archeological remains, old structures, or cultural
     * artifacts are located
     *
     * @see <a href="http://www.geonames.org/ontology#S.ANS">#S.ANS</a>
     */
    public static final IRI S_ANS;

    /**
     * aquaculture facility
     * <p>
     * {@code http://www.geonames.org/ontology#S.AQC}
     * <p>
     * facility or area for the cultivation of aquatic animals and plants,
     * especially fish, shellfish, and seaweed, in natural or controlled
     * marine or freshwater environments; underwater agriculture
     *
     * @see <a href="http://www.geonames.org/ontology#S.AQC">#S.AQC</a>
     */
    public static final IRI S_AQC;

    /**
     * arch
     * <p>
     * {@code http://www.geonames.org/ontology#S.ARCH}
     * <p>
     * a natural or man-made structure in the form of an arch
     *
     * @see <a href="http://www.geonames.org/ontology#S.ARCH">#S.ARCH</a>
     */
    public static final IRI S_ARCH;

    /**
     * astronomical station
     * <p>
     * {@code http://www.geonames.org/ontology#S.ASTR}
     * <p>
     * a point on the earth whose position has been determined by
     * observations of celestial bodies
     *
     * @see <a href="http://www.geonames.org/ontology#S.ASTR">#S.ASTR</a>
     */
    public static final IRI S_ASTR;

    /**
     * asyl
     * <p>
     * {@code http://www.geonames.org/ontology#S.ASYL}
     * <p>
     * a facility where the insane are cared for and protected
     *
     * @see <a href="http://www.geonames.org/ontology#S.ASYL">#S.ASYL</a>
     */
    public static final IRI S_ASYL;

    /**
     * athletic field
     * <p>
     * {@code http://www.geonames.org/ontology#S.ATHF}
     * <p>
     * a tract of land used for playing team sports, and athletic track and
     * field events
     *
     * @see <a href="http://www.geonames.org/ontology#S.ATHF">#S.ATHF</a>
     */
    public static final IRI S_ATHF;

    /**
     * automatic teller machine
     * <p>
     * {@code http://www.geonames.org/ontology#S.ATM}
     * <p>
     * An unattended electronic machine in a public place, connected to a
     * data system and related equipment and activated by a bank customer to
     * obtain cash withdrawals and other banking services.
     *
     * @see <a href="http://www.geonames.org/ontology#S.ATM">#S.ATM</a>
     */
    public static final IRI S_ATM;

    /**
     * bank
     * <p>
     * {@code http://www.geonames.org/ontology#S.BANK}
     * <p>
     * A business establishment in which money is kept for saving or
     * commercial purposes or is invested, supplied for loans, or exchanged.
     *
     * @see <a href="http://www.geonames.org/ontology#S.BANK">#S.BANK</a>
     */
    public static final IRI S_BANK;

    /**
     * beacon
     * <p>
     * {@code http://www.geonames.org/ontology#S.BCN}
     * <p>
     * a fixed artificial navigation mark
     *
     * @see <a href="http://www.geonames.org/ontology#S.BCN">#S.BCN</a>
     */
    public static final IRI S_BCN;

    /**
     * bridge
     * <p>
     * {@code http://www.geonames.org/ontology#S.BDG}
     * <p>
     * a structure erected across an obstacle such as a stream, road, etc.,
     * in order to carry roads, railroads, and pedestrians across
     *
     * @see <a href="http://www.geonames.org/ontology#S.BDG">#S.BDG</a>
     */
    public static final IRI S_BDG;

    /**
     * raserad bro
     * <p>
     * {@code http://www.geonames.org/ontology#S.BDGQ}
     * <p>
     * a destroyed or decayed bridge which is no longer functional
     *
     * @see <a href="http://www.geonames.org/ontology#S.BDGQ">#S.BDGQ</a>
     */
    public static final IRI S_BDGQ;

    /**
     * building(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.BLDG}
     * <p>
     * a structure built for permanent use, as a house, factory, etc.
     *
     * @see <a href="http://www.geonames.org/ontology#S.BLDG">#S.BLDG</a>
     */
    public static final IRI S_BLDG;

    /**
     * office building
     * <p>
     * {@code http://www.geonames.org/ontology#S.BLDO}
     * <p>
     * commercial building where business and/or services are conducted
     *
     * @see <a href="http://www.geonames.org/ontology#S.BLDO">#S.BLDO</a>
     */
    public static final IRI S_BLDO;

    /**
     * boundary marker
     * <p>
     * {@code http://www.geonames.org/ontology#S.BP}
     * <p>
     * a fixture marking a point along a boundary
     *
     * @see <a href="http://www.geonames.org/ontology#S.BP">#S.BP</a>
     */
    public static final IRI S_BP;

    /**
     * barracks
     * <p>
     * {@code http://www.geonames.org/ontology#S.BRKS}
     * <p>
     * a building for lodging military personnel
     *
     * @see <a href="http://www.geonames.org/ontology#S.BRKS">#S.BRKS</a>
     */
    public static final IRI S_BRKS;

    /**
     * breakwater
     * <p>
     * {@code http://www.geonames.org/ontology#S.BRKW}
     * <p>
     * a structure erected to break the force of waves at the entrance to a
     * harbor or port
     *
     * @see <a href="http://www.geonames.org/ontology#S.BRKW">#S.BRKW</a>
     */
    public static final IRI S_BRKW;

    /**
     * baling station
     * <p>
     * {@code http://www.geonames.org/ontology#S.BSTN}
     * <p>
     * a facility for baling agricultural products
     *
     * @see <a href="http://www.geonames.org/ontology#S.BSTN">#S.BSTN</a>
     */
    public static final IRI S_BSTN;

    /**
     * boatyard
     * <p>
     * {@code http://www.geonames.org/ontology#S.BTYD}
     * <p>
     * a waterside facility for servicing, repairing, and building small
     * vessels
     *
     * @see <a href="http://www.geonames.org/ontology#S.BTYD">#S.BTYD</a>
     */
    public static final IRI S_BTYD;

    /**
     * begravningsgrotta(or)
     * <p>
     * {@code http://www.geonames.org/ontology#S.BUR}
     * <p>
     * a cave used for human burials
     *
     * @see <a href="http://www.geonames.org/ontology#S.BUR">#S.BUR</a>
     */
    public static final IRI S_BUR;

    /**
     * bus station
     * <p>
     * {@code http://www.geonames.org/ontology#S.BUSTN}
     * <p>
     * a facility comprising ticket office, platforms, etc. for loading and
     * unloading passengers
     *
     * @see <a href="http://www.geonames.org/ontology#S.BUSTN">#S.BUSTN</a>
     */
    public static final IRI S_BUSTN;

    /**
     * Busshållplats
     * <p>
     * {@code http://www.geonames.org/ontology#S.BUSTP}
     * <p>
     * a place lacking station facilities
     *
     * @see <a href="http://www.geonames.org/ontology#S.BUSTP">#S.BUSTP</a>
     */
    public static final IRI S_BUSTP;

    /**
     * cairn
     * <p>
     * {@code http://www.geonames.org/ontology#S.CARN}
     * <p>
     * a heap of stones erected as a landmark or for other purposes
     *
     * @see <a href="http://www.geonames.org/ontology#S.CARN">#S.CARN</a>
     */
    public static final IRI S_CARN;

    /**
     * cave(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.CAVE}
     * <p>
     * an underground passageway or chamber, or cavity on the side of a cliff
     *
     * @see <a href="http://www.geonames.org/ontology#S.CAVE">#S.CAVE</a>
     */
    public static final IRI S_CAVE;

    /**
     * Centre Continuous Learning
     * <p>
     * {@code http://www.geonames.org/ontology#S.CCL}
     * <p>
     * Centres for Continuous Learning
     *
     * @see <a href="http://www.geonames.org/ontology#S.CCL">#S.CCL</a>
     */
    public static final IRI S_CCL;

    /**
     * church
     * <p>
     * {@code http://www.geonames.org/ontology#S.CH}
     * <p>
     * a building for public Christian worship
     *
     * @see <a href="http://www.geonames.org/ontology#S.CH">#S.CH</a>
     */
    public static final IRI S_CH;

    /**
     * camp(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.CMP}
     * <p>
     * a site occupied by tents, huts, or other shelters for temporary use
     *
     * @see <a href="http://www.geonames.org/ontology#S.CMP">#S.CMP</a>
     */
    public static final IRI S_CMP;

    /**
     * logging camp
     * <p>
     * {@code http://www.geonames.org/ontology#S.CMPL}
     * <p>
     * a camp used by loggers
     *
     * @see <a href="http://www.geonames.org/ontology#S.CMPL">#S.CMPL</a>
     */
    public static final IRI S_CMPL;

    /**
     * arbeidsleir
     * <p>
     * {@code http://www.geonames.org/ontology#S.CMPLA}
     * <p>
     * a camp used by migrant or temporary laborers
     *
     * @see <a href="http://www.geonames.org/ontology#S.CMPLA">#S.CMPLA</a>
     */
    public static final IRI S_CMPLA;

    /**
     * gruveleir
     * <p>
     * {@code http://www.geonames.org/ontology#S.CMPMN}
     * <p>
     * a camp used by miners
     *
     * @see <a href="http://www.geonames.org/ontology#S.CMPMN">#S.CMPMN</a>
     */
    public static final IRI S_CMPMN;

    /**
     * oil camp
     * <p>
     * {@code http://www.geonames.org/ontology#S.CMPO}
     * <p>
     * a camp used by oilfield workers
     *
     * @see <a href="http://www.geonames.org/ontology#S.CMPO">#S.CMPO</a>
     */
    public static final IRI S_CMPO;

    /**
     * abandoned camp
     * <p>
     * {@code http://www.geonames.org/ontology#S.CMPQ}
     *
     * @see <a href="http://www.geonames.org/ontology#S.CMPQ">#S.CMPQ</a>
     */
    public static final IRI S_CMPQ;

    /**
     * flyktingläger
     * <p>
     * {@code http://www.geonames.org/ontology#S.CMPRF}
     * <p>
     * a camp used by refugees
     *
     * @see <a href="http://www.geonames.org/ontology#S.CMPRF">#S.CMPRF</a>
     */
    public static final IRI S_CMPRF;

    /**
     * cemetery
     * <p>
     * {@code http://www.geonames.org/ontology#S.CMTY}
     * <p>
     * a burial place or ground
     *
     * @see <a href="http://www.geonames.org/ontology#S.CMTY">#S.CMTY</a>
     */
    public static final IRI S_CMTY;

    /**
     * communication center
     * <p>
     * {@code http://www.geonames.org/ontology#S.COMC}
     * <p>
     * a facility, including buildings, antennae, towers and electronic
     * equipment for receiving and transmitting information
     *
     * @see <a href="http://www.geonames.org/ontology#S.COMC">#S.COMC</a>
     */
    public static final IRI S_COMC;

    /**
     * corral(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.CRRL}
     * <p>
     * a pen or enclosure for confining or capturing animals
     *
     * @see <a href="http://www.geonames.org/ontology#S.CRRL">#S.CRRL</a>
     */
    public static final IRI S_CRRL;

    /**
     * casino
     * <p>
     * {@code http://www.geonames.org/ontology#S.CSNO}
     * <p>
     * a building used for entertainment, especially gambling
     *
     * @see <a href="http://www.geonames.org/ontology#S.CSNO">#S.CSNO</a>
     */
    public static final IRI S_CSNO;

    /**
     * castle
     * <p>
     * {@code http://www.geonames.org/ontology#S.CSTL}
     * <p>
     * a large fortified building or set of buildings
     *
     * @see <a href="http://www.geonames.org/ontology#S.CSTL">#S.CSTL</a>
     */
    public static final IRI S_CSTL;

    /**
     * customs house
     * <p>
     * {@code http://www.geonames.org/ontology#S.CSTM}
     * <p>
     * a building in a port where customs and duties are paid, and where
     * vessels are entered and cleared
     *
     * @see <a href="http://www.geonames.org/ontology#S.CSTM">#S.CSTM</a>
     */
    public static final IRI S_CSTM;

    /**
     * courthouse
     * <p>
     * {@code http://www.geonames.org/ontology#S.CTHSE}
     * <p>
     * a building in which courts of law are held
     *
     * @see <a href="http://www.geonames.org/ontology#S.CTHSE">#S.CTHSE</a>
     */
    public static final IRI S_CTHSE;

    /**
     * atomcentrum
     * <p>
     * {@code http://www.geonames.org/ontology#S.CTRA}
     * <p>
     * a facility where atomic research is carried out
     *
     * @see <a href="http://www.geonames.org/ontology#S.CTRA">#S.CTRA</a>
     */
    public static final IRI S_CTRA;

    /**
     * community center
     * <p>
     * {@code http://www.geonames.org/ontology#S.CTRCM}
     * <p>
     * a facility for community recreation and other activities
     *
     * @see <a href="http://www.geonames.org/ontology#S.CTRCM">#S.CTRCM</a>
     */
    public static final IRI S_CTRCM;

    /**
     * facility center
     * <p>
     * {@code http://www.geonames.org/ontology#S.CTRF}
     * <p>
     * a place where more than one facility is situated
     *
     * @see <a href="http://www.geonames.org/ontology#S.CTRF">#S.CTRF</a>
     */
    public static final IRI S_CTRF;

    /**
     * legesenter
     * <p>
     * {@code http://www.geonames.org/ontology#S.CTRM}
     * <p>
     * a complex of health care buildings including two or more of the
     * following: hospital, medical school, clinic, pharmacy, doctor&#39;s
     * offices, etc.
     *
     * @see <a href="http://www.geonames.org/ontology#S.CTRM">#S.CTRM</a>
     */
    public static final IRI S_CTRM;

    /**
     * religious center
     * <p>
     * {@code http://www.geonames.org/ontology#S.CTRR}
     * <p>
     * a facility where more than one religious activity is carried out,
     * e.g., retreat, school, monastery, worship
     *
     * @see <a href="http://www.geonames.org/ontology#S.CTRR">#S.CTRR</a>
     */
    public static final IRI S_CTRR;

    /**
     * romsenter
     * <p>
     * {@code http://www.geonames.org/ontology#S.CTRS}
     * <p>
     * a facility for launching, tracking, or controlling satellites and
     * space vehicles
     *
     * @see <a href="http://www.geonames.org/ontology#S.CTRS">#S.CTRS</a>
     */
    public static final IRI S_CTRS;

    /**
     * convent
     * <p>
     * {@code http://www.geonames.org/ontology#S.CVNT}
     * <p>
     * a building where a community of nuns lives in seclusion
     *
     * @see <a href="http://www.geonames.org/ontology#S.CVNT">#S.CVNT</a>
     */
    public static final IRI S_CVNT;

    /**
     * dam
     * <p>
     * {@code http://www.geonames.org/ontology#S.DAM}
     * <p>
     * a barrier constructed across a stream to impound water
     *
     * @see <a href="http://www.geonames.org/ontology#S.DAM">#S.DAM</a>
     */
    public static final IRI S_DAM;

    /**
     * förstörd damm
     * <p>
     * {@code http://www.geonames.org/ontology#S.DAMQ}
     * <p>
     * a destroyed or decayed dam which is no longer functional
     *
     * @see <a href="http://www.geonames.org/ontology#S.DAMQ">#S.DAMQ</a>
     */
    public static final IRI S_DAMQ;

    /**
     * demning gravd ned til grunnfjellet
     * <p>
     * {@code http://www.geonames.org/ontology#S.DAMSB}
     * <p>
     * a dam put down to bedrock in a sand river
     *
     * @see <a href="http://www.geonames.org/ontology#S.DAMSB">#S.DAMSB</a>
     */
    public static final IRI S_DAMSB;

    /**
     * dairy
     * <p>
     * {@code http://www.geonames.org/ontology#S.DARY}
     * <p>
     * a facility for the processing, sale and distribution of milk or milk
     * products
     *
     * @see <a href="http://www.geonames.org/ontology#S.DARY">#S.DARY</a>
     */
    public static final IRI S_DARY;

    /**
     * demning gravd ned til grunnfjellet
     * <p>
     * {@code http://www.geonames.org/ontology#S.DCKD}
     * <p>
     * a dock providing support for a vessel, and means for removing the
     * water so that the bottom of the vessel can be exposed
     *
     * @see <a href="http://www.geonames.org/ontology#S.DCKD">#S.DCKD</a>
     */
    public static final IRI S_DCKD;

    /**
     * dockyard
     * <p>
     * {@code http://www.geonames.org/ontology#S.DCKY}
     * <p>
     * a facility for servicing, building, or repairing ships
     *
     * @see <a href="http://www.geonames.org/ontology#S.DCKY">#S.DCKY</a>
     */
    public static final IRI S_DCKY;

    /**
     * damm, fördämning, bank
     * <p>
     * {@code http://www.geonames.org/ontology#S.DIKE}
     * <p>
     * an earth or stone embankment usually constructed for flood or stream
     * control
     *
     * @see <a href="http://www.geonames.org/ontology#S.DIKE">#S.DIKE</a>
     */
    public static final IRI S_DIKE;

    /**
     * diplomatic facility
     * <p>
     * {@code http://www.geonames.org/ontology#S.DIP}
     * <p>
     * office, residence, or facility of a foreign government, which may
     * include an embassy, consulate, chancery, office of charge d?affaires,
     * or other diplomatic, economic, military, or cultural mission
     *
     * @see <a href="http://www.geonames.org/ontology#S.DIP">#S.DIP</a>
     */
    public static final IRI S_DIP;

    /**
     * brennstofflager
     * <p>
     * {@code http://www.geonames.org/ontology#S.DPOF}
     * <p>
     * an area where fuel is stored
     *
     * @see <a href="http://www.geonames.org/ontology#S.DPOF">#S.DPOF</a>
     */
    public static final IRI S_DPOF;

    /**
     * egendom(ar)
     * <p>
     * {@code http://www.geonames.org/ontology#S.EST}
     * <p>
     * a large commercialized agricultural landholding with associated
     * buildings and other facilities
     *
     * @see <a href="http://www.geonames.org/ontology#S.EST">#S.EST</a>
     */
    public static final IRI S_EST;

    /**
     * banana plantation
     * <p>
     * {@code http://www.geonames.org/ontology#S.ESTB}
     * <p>
     * an estate that specializes in the growing of bananas
     *
     * @see <a href="http://www.geonames.org/ontology#S.ESTB">#S.ESTB</a>
     */
    public static final IRI S_ESTB;

    /**
     * cotton plantation
     * <p>
     * {@code http://www.geonames.org/ontology#S.ESTC}
     * <p>
     * an estate specializing in the cultivation of cotton
     *
     * @see <a href="http://www.geonames.org/ontology#S.ESTC">#S.ESTC</a>
     */
    public static final IRI S_ESTC;

    /**
     * oil palm plantation
     * <p>
     * {@code http://www.geonames.org/ontology#S.ESTO}
     * <p>
     * an estate specializing in the cultivation of oil palm trees
     *
     * @see <a href="http://www.geonames.org/ontology#S.ESTO">#S.ESTO</a>
     */
    public static final IRI S_ESTO;

    /**
     * gummiplantage
     * <p>
     * {@code http://www.geonames.org/ontology#S.ESTR}
     * <p>
     * an estate which specializes in growing and tapping rubber trees
     *
     * @see <a href="http://www.geonames.org/ontology#S.ESTR">#S.ESTR</a>
     */
    public static final IRI S_ESTR;

    /**
     * sockerplantage
     * <p>
     * {@code http://www.geonames.org/ontology#S.ESTSG}
     * <p>
     * an estate that specializes in growing sugar cane
     *
     * @see <a href="http://www.geonames.org/ontology#S.ESTSG">#S.ESTSG</a>
     */
    public static final IRI S_ESTSG;

    /**
     * sisal plantation
     * <p>
     * {@code http://www.geonames.org/ontology#S.ESTSL}
     * <p>
     * an estate that specializes in growing sisal
     *
     * @see <a href="http://www.geonames.org/ontology#S.ESTSL">#S.ESTSL</a>
     */
    public static final IRI S_ESTSL;

    /**
     * tea plantation
     * <p>
     * {@code http://www.geonames.org/ontology#S.ESTT}
     * <p>
     * an estate which specializes in growing tea bushes
     *
     * @see <a href="http://www.geonames.org/ontology#S.ESTT">#S.ESTT</a>
     */
    public static final IRI S_ESTT;

    /**
     * del av egendom
     * <p>
     * {@code http://www.geonames.org/ontology#S.ESTX}
     *
     * @see <a href="http://www.geonames.org/ontology#S.ESTX">#S.ESTX</a>
     */
    public static final IRI S_ESTX;

    /**
     * anlegg
     * <p>
     * {@code http://www.geonames.org/ontology#S.FCL}
     * <p>
     * a building or buildings housing a center, institute, foundation,
     * hospital, prison, mission, courthouse, etc.
     *
     * @see <a href="http://www.geonames.org/ontology#S.FCL">#S.FCL</a>
     */
    public static final IRI S_FCL;

    /**
     * foundry
     * <p>
     * {@code http://www.geonames.org/ontology#S.FNDY}
     * <p>
     * a building or works where metal casting is carried out
     *
     * @see <a href="http://www.geonames.org/ontology#S.FNDY">#S.FNDY</a>
     */
    public static final IRI S_FNDY;

    /**
     * farm
     * <p>
     * {@code http://www.geonames.org/ontology#S.FRM}
     * <p>
     * a tract of land with associated buildings devoted to agriculture
     *
     * @see <a href="http://www.geonames.org/ontology#S.FRM">#S.FRM</a>
     */
    public static final IRI S_FRM;

    /**
     * abandoned farm
     * <p>
     * {@code http://www.geonames.org/ontology#S.FRMQ}
     *
     * @see <a href="http://www.geonames.org/ontology#S.FRMQ">#S.FRMQ</a>
     */
    public static final IRI S_FRMQ;

    /**
     * farmer
     * <p>
     * {@code http://www.geonames.org/ontology#S.FRMS}
     * <p>
     * tracts of land with associated buildings devoted to agriculture
     *
     * @see <a href="http://www.geonames.org/ontology#S.FRMS">#S.FRMS</a>
     */
    public static final IRI S_FRMS;

    /**
     * bondgård
     * <p>
     * {@code http://www.geonames.org/ontology#S.FRMT}
     * <p>
     * the buildings and adjacent service areas of a farm
     *
     * @see <a href="http://www.geonames.org/ontology#S.FRMT">#S.FRMT</a>
     */
    public static final IRI S_FRMT;

    /**
     * fort
     * <p>
     * {@code http://www.geonames.org/ontology#S.FT}
     * <p>
     * a defensive structure or earthworks
     *
     * @see <a href="http://www.geonames.org/ontology#S.FT">#S.FT</a>
     */
    public static final IRI S_FT;

    /**
     * ferge
     * <p>
     * {@code http://www.geonames.org/ontology#S.FY}
     * <p>
     * a boat or other floating conveyance and terminal facilities regularly
     * used to transport people and vehicles across a waterbody
     *
     * @see <a href="http://www.geonames.org/ontology#S.FY">#S.FY</a>
     */
    public static final IRI S_FY;

    /**
     * gate
     * <p>
     * {@code http://www.geonames.org/ontology#S.GATE}
     * <p>
     * a controlled access entrance or exit
     *
     * @see <a href="http://www.geonames.org/ontology#S.GATE">#S.GATE</a>
     */
    public static final IRI S_GATE;

    /**
     * garden(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.GDN}
     * <p>
     * an enclosure for displaying selected plant or animal life
     *
     * @see <a href="http://www.geonames.org/ontology#S.GDN">#S.GDN</a>
     */
    public static final IRI S_GDN;

    /**
     * ghat
     * <p>
     * {@code http://www.geonames.org/ontology#S.GHAT}
     * <p>
     * a set of steps leading to a river, which are of religious
     * significance, and at their base is usually a platform for bathing
     *
     * @see <a href="http://www.geonames.org/ontology#S.GHAT">#S.GHAT</a>
     */
    public static final IRI S_GHAT;

    /**
     * gjestehus
     * <p>
     * {@code http://www.geonames.org/ontology#S.GHSE}
     * <p>
     * a house used to provide lodging for paying guests
     *
     * @see <a href="http://www.geonames.org/ontology#S.GHSE">#S.GHSE</a>
     */
    public static final IRI S_GHSE;

    /**
     * gas och olje separator
     * <p>
     * {@code http://www.geonames.org/ontology#S.GOSP}
     * <p>
     * a facility for separating gas from oil
     *
     * @see <a href="http://www.geonames.org/ontology#S.GOSP">#S.GOSP</a>
     */
    public static final IRI S_GOSP;

    /**
     * local government office
     * <p>
     * {@code http://www.geonames.org/ontology#S.GOVL}
     * <p>
     * a facility housing local governmental offices, usually a city, town,
     * or village hall
     *
     * @see <a href="http://www.geonames.org/ontology#S.GOVL">#S.GOVL</a>
     */
    public static final IRI S_GOVL;

    /**
     * grav
     * <p>
     * {@code http://www.geonames.org/ontology#S.GRVE}
     * <p>
     * a burial site
     *
     * @see <a href="http://www.geonames.org/ontology#S.GRVE">#S.GRVE</a>
     */
    public static final IRI S_GRVE;

    /**
     * eneboerhytte
     * <p>
     * {@code http://www.geonames.org/ontology#S.HERM}
     * <p>
     * a secluded residence, usually for religious sects
     *
     * @see <a href="http://www.geonames.org/ontology#S.HERM">#S.HERM</a>
     */
    public static final IRI S_HERM;

    /**
     * halting place
     * <p>
     * {@code http://www.geonames.org/ontology#S.HLT}
     * <p>
     * a place where caravans stop for rest
     *
     * @see <a href="http://www.geonames.org/ontology#S.HLT">#S.HLT</a>
     */
    public static final IRI S_HLT;

    /**
     * homestead
     * <p>
     * {@code http://www.geonames.org/ontology#S.HMSD}
     * <p>
     * a residence, owner&#39;s or manager&#39;s, on a sheep or cattle
     * station, woolshed, outcamp, or Aboriginal outstation, specific to
     * Australia and New Zealand
     *
     * @see <a href="http://www.geonames.org/ontology#S.HMSD">#S.HMSD</a>
     */
    public static final IRI S_HMSD;

    /**
     * house(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.HSE}
     * <p>
     * a building used as a human habitation
     *
     * @see <a href="http://www.geonames.org/ontology#S.HSE">#S.HSE</a>
     */
    public static final IRI S_HSE;

    /**
     * country house
     * <p>
     * {@code http://www.geonames.org/ontology#S.HSEC}
     * <p>
     * a large house, mansion, or chateau, on a large estate
     *
     * @see <a href="http://www.geonames.org/ontology#S.HSEC">#S.HSEC</a>
     */
    public static final IRI S_HSEC;

    /**
     * hospital
     * <p>
     * {@code http://www.geonames.org/ontology#S.HSP}
     * <p>
     * a building in which sick or injured, especially those confined to bed,
     * are medically treated
     *
     * @see <a href="http://www.geonames.org/ontology#S.HSP">#S.HSP</a>
     */
    public static final IRI S_HSP;

    /**
     * clinic
     * <p>
     * {@code http://www.geonames.org/ontology#S.HSPC}
     * <p>
     * a medical facility associated with a hospital for outpatients
     *
     * @see <a href="http://www.geonames.org/ontology#S.HSPC">#S.HSPC</a>
     */
    public static final IRI S_HSPC;

    /**
     * apotek
     * <p>
     * {@code http://www.geonames.org/ontology#S.HSPD}
     * <p>
     * a building where medical or dental aid is dispensed
     *
     * @see <a href="http://www.geonames.org/ontology#S.HSPD">#S.HSPD</a>
     */
    public static final IRI S_HSPD;

    /**
     * leprasykehus
     * <p>
     * {@code http://www.geonames.org/ontology#S.HSPL}
     * <p>
     * an asylum or hospital for lepers
     *
     * @see <a href="http://www.geonames.org/ontology#S.HSPL">#S.HSPL</a>
     */
    public static final IRI S_HSPL;

    /**
     * historical site
     * <p>
     * {@code http://www.geonames.org/ontology#S.HSTS}
     * <p>
     * a place of historical importance
     *
     * @see <a href="http://www.geonames.org/ontology#S.HSTS">#S.HSTS</a>
     */
    public static final IRI S_HSTS;

    /**
     * hotel
     * <p>
     * {@code http://www.geonames.org/ontology#S.HTL}
     * <p>
     * a building providing lodging and/or meals for the public
     *
     * @see <a href="http://www.geonames.org/ontology#S.HTL">#S.HTL</a>
     */
    public static final IRI S_HTL;

    /**
     * hut
     * <p>
     * {@code http://www.geonames.org/ontology#S.HUT}
     * <p>
     * a small primitive house
     *
     * @see <a href="http://www.geonames.org/ontology#S.HUT">#S.HUT</a>
     */
    public static final IRI S_HUT;

    /**
     * huts
     * <p>
     * {@code http://www.geonames.org/ontology#S.HUTS}
     * <p>
     * small primitive houses
     *
     * @see <a href="http://www.geonames.org/ontology#S.HUTS">#S.HUTS</a>
     */
    public static final IRI S_HUTS;

    /**
     * military installation
     * <p>
     * {@code http://www.geonames.org/ontology#S.INSM}
     * <p>
     * a facility for use of and control by armed forces
     *
     * @see <a href="http://www.geonames.org/ontology#S.INSM">#S.INSM</a>
     */
    public static final IRI S_INSM;

    /**
     * forskningsinstitut
     * <p>
     * {@code http://www.geonames.org/ontology#S.ITTR}
     * <p>
     * a facility where research is carried out
     *
     * @see <a href="http://www.geonames.org/ontology#S.ITTR">#S.ITTR</a>
     */
    public static final IRI S_ITTR;

    /**
     * jetty
     * <p>
     * {@code http://www.geonames.org/ontology#S.JTY}
     * <p>
     * a structure built out into the water at a river mouth or harbor
     * entrance to regulate currents and silting
     *
     * @see <a href="http://www.geonames.org/ontology#S.JTY">#S.JTY</a>
     */
    public static final IRI S_JTY;

    /**
     * kai
     * <p>
     * {@code http://www.geonames.org/ontology#S.LDNG}
     * <p>
     * a place where boats receive or discharge passengers and freight, but
     * lacking most port facilities
     *
     * @see <a href="http://www.geonames.org/ontology#S.LDNG">#S.LDNG</a>
     */
    public static final IRI S_LDNG;

    /**
     * leper colony
     * <p>
     * {@code http://www.geonames.org/ontology#S.LEPC}
     * <p>
     * a settled area inhabited by lepers in relative isolation
     *
     * @see <a href="http://www.geonames.org/ontology#S.LEPC">#S.LEPC</a>
     */
    public static final IRI S_LEPC;

    /**
     * bibliotek
     * <p>
     * {@code http://www.geonames.org/ontology#S.LIBR}
     * <p>
     * A place in which information resources such as books are kept for
     * reading, reference, or lending.
     *
     * @see <a href="http://www.geonames.org/ontology#S.LIBR">#S.LIBR</a>
     */
    public static final IRI S_LIBR;

    /**
     * landfill
     * <p>
     * {@code http://www.geonames.org/ontology#S.LNDF}
     * <p>
     * a place for trash and garbage disposal in which the waste is buried
     * between layers of earth to build up low-lying land
     *
     * @see <a href="http://www.geonames.org/ontology#S.LNDF">#S.LNDF</a>
     */
    public static final IRI S_LNDF;

    /**
     * lock(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.LOCK}
     * <p>
     * a basin in a waterway with gates at each end by means of which vessels
     * are passed from one water level to another
     *
     * @see <a href="http://www.geonames.org/ontology#S.LOCK">#S.LOCK</a>
     */
    public static final IRI S_LOCK;

    /**
     * fyr
     * <p>
     * {@code http://www.geonames.org/ontology#S.LTHSE}
     * <p>
     * a distinctive structure exhibiting a major navigation light
     *
     * @see <a href="http://www.geonames.org/ontology#S.LTHSE">#S.LTHSE</a>
     */
    public static final IRI S_LTHSE;

    /**
     * kjøpesenter
     * <p>
     * {@code http://www.geonames.org/ontology#S.MALL}
     * <p>
     * A large, often enclosed shopping complex containing various stores,
     * businesses, and restaurants usually accessible by common passageways.
     *
     * @see <a href="http://www.geonames.org/ontology#S.MALL">#S.MALL</a>
     */
    public static final IRI S_MALL;

    /**
     * marina
     * <p>
     * {@code http://www.geonames.org/ontology#S.MAR}
     * <p>
     * a harbor facility for small boats, yachts, etc.
     *
     * @see <a href="http://www.geonames.org/ontology#S.MAR">#S.MAR</a>
     */
    public static final IRI S_MAR;

    /**
     * fabrik
     * <p>
     * {@code http://www.geonames.org/ontology#S.MFG}
     * <p>
     * one or more buildings where goods are manufactured, processed or
     * fabricated
     *
     * @see <a href="http://www.geonames.org/ontology#S.MFG">#S.MFG</a>
     */
    public static final IRI S_MFG;

    /**
     * brewery
     * <p>
     * {@code http://www.geonames.org/ontology#S.MFGB}
     * <p>
     * one or more buildings where beer is brewed
     *
     * @see <a href="http://www.geonames.org/ontology#S.MFGB">#S.MFGB</a>
     */
    public static final IRI S_MFGB;

    /**
     * cannery
     * <p>
     * {@code http://www.geonames.org/ontology#S.MFGC}
     * <p>
     * a building where food items are canned
     *
     * @see <a href="http://www.geonames.org/ontology#S.MFGC">#S.MFGC</a>
     */
    public static final IRI S_MFGC;

    /**
     * copper works
     * <p>
     * {@code http://www.geonames.org/ontology#S.MFGCU}
     * <p>
     * a facility for processing copper ore
     *
     * @see <a href="http://www.geonames.org/ontology#S.MFGCU">#S.MFGCU</a>
     */
    public static final IRI S_MFGCU;

    /**
     * kalkbrenneri
     * <p>
     * {@code http://www.geonames.org/ontology#S.MFGLM}
     * <p>
     * a furnace in which limestone is reduced to lime
     *
     * @see <a href="http://www.geonames.org/ontology#S.MFGLM">#S.MFGLM</a>
     */
    public static final IRI S_MFGLM;

    /**
     * ammunisjonsfabrikk
     * <p>
     * {@code http://www.geonames.org/ontology#S.MFGM}
     * <p>
     * a factory where ammunition is made
     *
     * @see <a href="http://www.geonames.org/ontology#S.MFGM">#S.MFGM</a>
     */
    public static final IRI S_MFGM;

    /**
     * fosfatanlegg
     * <p>
     * {@code http://www.geonames.org/ontology#S.MFGPH}
     * <p>
     * a facility for producing fertilizer
     *
     * @see <a href="http://www.geonames.org/ontology#S.MFGPH">#S.MFGPH</a>
     */
    public static final IRI S_MFGPH;

    /**
     * abandoned factory
     * <p>
     * {@code http://www.geonames.org/ontology#S.MFGQ}
     *
     * @see <a href="http://www.geonames.org/ontology#S.MFGQ">#S.MFGQ</a>
     */
    public static final IRI S_MFGQ;

    /**
     * sockerbruk, sockerraffinaderi
     * <p>
     * {@code http://www.geonames.org/ontology#S.MFGSG}
     * <p>
     * a facility for converting raw sugar into refined sugar
     *
     * @see <a href="http://www.geonames.org/ontology#S.MFGSG">#S.MFGSG</a>
     */
    public static final IRI S_MFGSG;

    /**
     * marked
     * <p>
     * {@code http://www.geonames.org/ontology#S.MKT}
     * <p>
     * a place where goods are bought and sold at regular intervals
     *
     * @see <a href="http://www.geonames.org/ontology#S.MKT">#S.MKT</a>
     */
    public static final IRI S_MKT;

    /**
     * kvarn
     * <p>
     * {@code http://www.geonames.org/ontology#S.ML}
     * <p>
     * a building housing machines for transforming, shaping, finishing,
     * grinding, or extracting products
     *
     * @see <a href="http://www.geonames.org/ontology#S.ML">#S.ML</a>
     */
    public static final IRI S_ML;

    /**
     * malmbehandlingsanlegg
     * <p>
     * {@code http://www.geonames.org/ontology#S.MLM}
     * <p>
     * a facility for improving the metal content of ore by concentration
     *
     * @see <a href="http://www.geonames.org/ontology#S.MLM">#S.MLM</a>
     */
    public static final IRI S_MLM;

    /**
     * olive oil mill
     * <p>
     * {@code http://www.geonames.org/ontology#S.MLO}
     * <p>
     * a mill where oil is extracted from olives
     *
     * @see <a href="http://www.geonames.org/ontology#S.MLO">#S.MLO</a>
     */
    public static final IRI S_MLO;

    /**
     * sockerbruk, sockerraffinaderi
     * <p>
     * {@code http://www.geonames.org/ontology#S.MLSG}
     * <p>
     * a facility where sugar cane is processed into raw sugar
     *
     * @see <a href="http://www.geonames.org/ontology#S.MLSG">#S.MLSG</a>
     */
    public static final IRI S_MLSG;

    /**
     * former sugar mill
     * <p>
     * {@code http://www.geonames.org/ontology#S.MLSGQ}
     * <p>
     * a sugar mill no longer used as a sugar mill
     *
     * @see <a href="http://www.geonames.org/ontology#S.MLSGQ">#S.MLSGQ</a>
     */
    public static final IRI S_MLSGQ;

    /**
     * sagbruk
     * <p>
     * {@code http://www.geonames.org/ontology#S.MLSW}
     * <p>
     * a mill where logs or lumber are sawn to specified shapes and sizes
     *
     * @see <a href="http://www.geonames.org/ontology#S.MLSW">#S.MLSW</a>
     */
    public static final IRI S_MLSW;

    /**
     * vindmølle
     * <p>
     * {@code http://www.geonames.org/ontology#S.MLWND}
     * <p>
     * a mill or water pump powered by wind
     *
     * @see <a href="http://www.geonames.org/ontology#S.MLWND">#S.MLWND</a>
     */
    public static final IRI S_MLWND;

    /**
     * kvernhus
     * <p>
     * {@code http://www.geonames.org/ontology#S.MLWTR}
     * <p>
     * a mill powered by running water
     *
     * @see <a href="http://www.geonames.org/ontology#S.MLWTR">#S.MLWTR</a>
     */
    public static final IRI S_MLWTR;

    /**
     * gruva(or)
     * <p>
     * {@code http://www.geonames.org/ontology#S.MN}
     * <p>
     * a site where mineral ores are extracted from the ground by excavating
     * surface pits and subterranean passages
     *
     * @see <a href="http://www.geonames.org/ontology#S.MN">#S.MN</a>
     */
    public static final IRI S_MN;

    /**
     * gold mine(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.MNAU}
     * <p>
     * a mine where gold ore, or alluvial gold is extracted
     *
     * @see <a href="http://www.geonames.org/ontology#S.MNAU">#S.MNAU</a>
     */
    public static final IRI S_MNAU;

    /**
     * coal mine(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.MNC}
     * <p>
     * a mine where coal is extracted
     *
     * @see <a href="http://www.geonames.org/ontology#S.MNC">#S.MNC</a>
     */
    public static final IRI S_MNC;

    /**
     * chrome mine(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.MNCR}
     * <p>
     * a mine where chrome ore is extracted
     *
     * @see <a href="http://www.geonames.org/ontology#S.MNCR">#S.MNCR</a>
     */
    public static final IRI S_MNCR;

    /**
     * copper mine(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.MNCU}
     * <p>
     * a mine where copper ore is extracted
     *
     * @see <a href="http://www.geonames.org/ontology#S.MNCU">#S.MNCU</a>
     */
    public static final IRI S_MNCU;

    /**
     * diatomite mine(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.MNDT}
     * <p>
     * a place where diatomaceous earth is extracted
     *
     * @see <a href="http://www.geonames.org/ontology#S.MNDT">#S.MNDT</a>
     */
    public static final IRI S_MNDT;

    /**
     * iron mine(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.MNFE}
     * <p>
     * a mine where iron ore is extracted
     *
     * @see <a href="http://www.geonames.org/ontology#S.MNFE">#S.MNFE</a>
     */
    public static final IRI S_MNFE;

    /**
     * monument
     * <p>
     * {@code http://www.geonames.org/ontology#S.MNMT}
     * <p>
     * a commemorative structure or statue
     *
     * @see <a href="http://www.geonames.org/ontology#S.MNMT">#S.MNMT</a>
     */
    public static final IRI S_MNMT;

    /**
     * salt mine(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.MNN}
     * <p>
     * a mine from which salt is extracted
     *
     * @see <a href="http://www.geonames.org/ontology#S.MNN">#S.MNN</a>
     */
    public static final IRI S_MNN;

    /**
     * nickel mine(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.MNNI}
     * <p>
     * a mine where nickel ore is extracted
     *
     * @see <a href="http://www.geonames.org/ontology#S.MNNI">#S.MNNI</a>
     */
    public static final IRI S_MNNI;

    /**
     * lead mine(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.MNPB}
     * <p>
     * a mine where lead ore is extracted
     *
     * @see <a href="http://www.geonames.org/ontology#S.MNPB">#S.MNPB</a>
     */
    public static final IRI S_MNPB;

    /**
     * placer mine(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.MNPL}
     * <p>
     * a place where heavy metals are concentrated and running water is used
     * to extract them from unconsolidated sediments
     *
     * @see <a href="http://www.geonames.org/ontology#S.MNPL">#S.MNPL</a>
     */
    public static final IRI S_MNPL;

    /**
     * abandoned mine
     * <p>
     * {@code http://www.geonames.org/ontology#S.MNQ}
     *
     * @see <a href="http://www.geonames.org/ontology#S.MNQ">#S.MNQ</a>
     */
    public static final IRI S_MNQ;

    /**
     * quarry(-ies)
     * <p>
     * {@code http://www.geonames.org/ontology#S.MNQR}
     * <p>
     * a surface mine where building stone or gravel and sand, etc. are
     * extracted
     *
     * @see <a href="http://www.geonames.org/ontology#S.MNQR">#S.MNQR</a>
     */
    public static final IRI S_MNQR;

    /**
     * tin mine(s)
     * <p>
     * {@code http://www.geonames.org/ontology#S.MNSN}
     * <p>
     * a mine where tin ore is extracted
     *
     * @see <a href="http://www.geonames.org/ontology#S.MNSN">#S.MNSN</a>
     */
    public static final IRI S_MNSN;

    /**
     * mole
     * <p>
     * {@code http://www.geonames.org/ontology#S.MOLE}
     * <p>
     * a massive structure of masonry or large stones serving as a pier or
     * breakwater
     *
     * @see <a href="http://www.geonames.org/ontology#S.MOLE">#S.MOLE</a>
     */
    public static final IRI S_MOLE;

    /**
     * moské
     * <p>
     * {@code http://www.geonames.org/ontology#S.MSQE}
     * <p>
     * a building for public Islamic worship
     *
     * @see <a href="http://www.geonames.org/ontology#S.MSQE">#S.MSQE</a>
     */
    public static final IRI S_MSQE;

    /**
     * beskickning
     * <p>
     * {@code http://www.geonames.org/ontology#S.MSSN}
     * <p>
     * a place characterized by dwellings, school, church, hospital and other
     * facilities operated by a religious group for the purpose of providing
     * charitable services and to propagate religion
     *
     * @see <a href="http://www.geonames.org/ontology#S.MSSN">#S.MSSN</a>
     */
    public static final IRI S_MSSN;

    /**
     * abandoned mission
     * <p>
     * {@code http://www.geonames.org/ontology#S.MSSNQ}
     *
     * @see <a href="http://www.geonames.org/ontology#S.MSSNQ">#S.MSSNQ</a>
     */
    public static final IRI S_MSSNQ;

    /**
     * kloster
     * <p>
     * {@code http://www.geonames.org/ontology#S.MSTY}
     * <p>
     * a building and grounds where a community of monks lives in seclusion
     *
     * @see <a href="http://www.geonames.org/ontology#S.MSTY">#S.MSTY</a>
     */
    public static final IRI S_MSTY;

    /**
     * metro station
     * <p>
     * {@code http://www.geonames.org/ontology#S.MTRO}
     * <p>
     * metro station (Underground, Tube, or Métro)
     *
     * @see <a href="http://www.geonames.org/ontology#S.MTRO">#S.MTRO</a>
     */
    public static final IRI S_MTRO;

    /**
     * museum
     * <p>
     * {@code http://www.geonames.org/ontology#S.MUS}
     * <p>
     * a building where objects of permanent interest in one or more of the
     * arts and sciences are preserved and exhibited
     *
     * @see <a href="http://www.geonames.org/ontology#S.MUS">#S.MUS</a>
     */
    public static final IRI S_MUS;

    /**
     * novisiat
     * <p>
     * {@code http://www.geonames.org/ontology#S.NOV}
     * <p>
     * a religious house or school where novices are trained
     *
     * @see <a href="http://www.geonames.org/ontology#S.NOV">#S.NOV</a>
     */
    public static final IRI S_NOV;

    /**
     * barnehage
     * <p>
     * {@code http://www.geonames.org/ontology#S.NSY}
     * <p>
     * a place where plants are propagated for transplanting or grafting
     *
     * @see <a href="http://www.geonames.org/ontology#S.NSY">#S.NSY</a>
     */
    public static final IRI S_NSY;

    /**
     * observasjonssted
     * <p>
     * {@code http://www.geonames.org/ontology#S.OBPT}
     * <p>
     * a wildlife or scenic observation point
     *
     * @see <a href="http://www.geonames.org/ontology#S.OBPT">#S.OBPT</a>
     */
    public static final IRI S_OBPT;

    /**
     * observatorium
     * <p>
     * {@code http://www.geonames.org/ontology#S.OBS}
     * <p>
     * a facility equipped for observation of atmospheric or space phenomena
     *
     * @see <a href="http://www.geonames.org/ontology#S.OBS">#S.OBS</a>
     */
    public static final IRI S_OBS;

    /**
     * radio observatory
     * <p>
     * {@code http://www.geonames.org/ontology#S.OBSR}
     * <p>
     * a facility equipped with an array of antennae for receiving radio
     * waves from space
     *
     * @see <a href="http://www.geonames.org/ontology#S.OBSR">#S.OBSR</a>
     */
    public static final IRI S_OBSR;

    /**
     * knutpunkt för oljepipeline
     * <p>
     * {@code http://www.geonames.org/ontology#S.OILJ}
     * <p>
     * a section of an oil pipeline where two or more pipes join together
     *
     * @see <a href="http://www.geonames.org/ontology#S.OILJ">#S.OILJ</a>
     */
    public static final IRI S_OILJ;

    /**
     * abandoned oil well
     * <p>
     * {@code http://www.geonames.org/ontology#S.OILQ}
     *
     * @see <a href="http://www.geonames.org/ontology#S.OILQ">#S.OILQ</a>
     */
    public static final IRI S_OILQ;

    /**
     * oil refinery
     * <p>
     * {@code http://www.geonames.org/ontology#S.OILR}
     * <p>
     * a facility for converting crude oil into refined petroleum products
     *
     * @see <a href="http://www.geonames.org/ontology#S.OILR">#S.OILR</a>
     */
    public static final IRI S_OILR;

    /**
     * depå
     * <p>
     * {@code http://www.geonames.org/ontology#S.OILT}
     * <p>
     * a tract of land occupied by large, cylindrical, metal tanks in which
     * oil or liquid petrochemicals are stored
     *
     * @see <a href="http://www.geonames.org/ontology#S.OILT">#S.OILT</a>
     */
    public static final IRI S_OILT;

    /**
     * oil well
     * <p>
     * {@code http://www.geonames.org/ontology#S.OILW}
     * <p>
     * a well from which oil may be pumped
     *
     * @see <a href="http://www.geonames.org/ontology#S.OILW">#S.OILW</a>
     */
    public static final IRI S_OILW;

    /**
     * opera house
     * <p>
     * {@code http://www.geonames.org/ontology#S.OPRA}
     * <p>
     * A theater designed chiefly for the performance of operas.
     *
     * @see <a href="http://www.geonames.org/ontology#S.OPRA">#S.OPRA</a>
     */
    public static final IRI S_OPRA;

    /**
     * palace
     * <p>
     * {@code http://www.geonames.org/ontology#S.PAL}
     * <p>
     * a large stately house, often a royal or presidential residence
     *
     * @see <a href="http://www.geonames.org/ontology#S.PAL">#S.PAL</a>
     */
    public static final IRI S_PAL;

    /**
     * pagod
     * <p>
     * {@code http://www.geonames.org/ontology#S.PGDA}
     * <p>
     * a tower-like storied structure, usually a Buddhist shrine
     *
     * @see <a href="http://www.geonames.org/ontology#S.PGDA">#S.PGDA</a>
     */
    public static final IRI S_PGDA;

    /**
     * pier
     * <p>
     * {@code http://www.geonames.org/ontology#S.PIER}
     * <p>
     * a structure built out into navigable water on piles providing berthing
     * for ships and recreation
     *
     * @see <a href="http://www.geonames.org/ontology#S.PIER">#S.PIER</a>
     */
    public static final IRI S_PIER;

    /**
     * parkerginsplats
     * <p>
     * {@code http://www.geonames.org/ontology#S.PKLT}
     * <p>
     * an area used for parking vehicles
     *
     * @see <a href="http://www.geonames.org/ontology#S.PKLT">#S.PKLT</a>
     */
    public static final IRI S_PKLT;

    /**
     * oil pumping station
     * <p>
     * {@code http://www.geonames.org/ontology#S.PMPO}
     * <p>
     * a facility for pumping oil through a pipeline
     *
     * @see <a href="http://www.geonames.org/ontology#S.PMPO">#S.PMPO</a>
     */
    public static final IRI S_PMPO;

    /**
     * pumpstation för vatten
     * <p>
     * {@code http://www.geonames.org/ontology#S.PMPW}
     * <p>
     * a facility for pumping water from a major well or through a pipeline
     *
     * @see <a href="http://www.geonames.org/ontology#S.PMPW">#S.PMPW</a>
     */
    public static final IRI S_PMPW;

    /**
     * post office
     * <p>
     * {@code http://www.geonames.org/ontology#S.PO}
     * <p>
     * a public building in which mail is received, sorted and distributed
     *
     * @see <a href="http://www.geonames.org/ontology#S.PO">#S.PO</a>
     */
    public static final IRI S_PO;

    /**
     * police post
     * <p>
     * {@code http://www.geonames.org/ontology#S.PP}
     * <p>
     * a building in which police are stationed
     *
     * @see <a href="http://www.geonames.org/ontology#S.PP">#S.PP</a>
     */
    public static final IRI S_PP;

    /**
     * abandoned police post
     * <p>
     * {@code http://www.geonames.org/ontology#S.PPQ}
     *
     * @see <a href="http://www.geonames.org/ontology#S.PPQ">#S.PPQ</a>
     */
    public static final IRI S_PPQ;

    /**
     * inngang til militæranlegg
     * <p>
     * {@code http://www.geonames.org/ontology#S.PRKGT}
     * <p>
     * a controlled access to a park
     *
     * @see <a href="http://www.geonames.org/ontology#S.PRKGT">#S.PRKGT</a>
     */
    public static final IRI S_PRKGT;

    /**
     * hovedkvarter på militæranlegg
     * <p>
     * {@code http://www.geonames.org/ontology#S.PRKHQ}
     * <p>
     * a park administrative facility
     *
     * @see <a href="http://www.geonames.org/ontology#S.PRKHQ">#S.PRKHQ</a>
     */
    public static final IRI S_PRKHQ;

    /**
     * fengsel
     * <p>
     * {@code http://www.geonames.org/ontology#S.PRN}
     * <p>
     * a facility for confining prisoners
     *
     * @see <a href="http://www.geonames.org/ontology#S.PRN">#S.PRN</a>
     */
    public static final IRI S_PRN;

    /**
     * forbedringsanstalt
     * <p>
     * {@code http://www.geonames.org/ontology#S.PRNJ}
     * <p>
     * a facility for confining, training, and reforming young law offenders
     *
     * @see <a href="http://www.geonames.org/ontology#S.PRNJ">#S.PRNJ</a>
     */
    public static final IRI S_PRNJ;

    /**
     * abandoned prison
     * <p>
     * {@code http://www.geonames.org/ontology#S.PRNQ}
     *
     * @see <a href="http://www.geonames.org/ontology#S.PRNQ">#S.PRNQ</a>
     */
    public static final IRI S_PRNQ;

    /**
     * kraftstasjon
     * <p>
     * {@code http://www.geonames.org/ontology#S.PS}
     * <p>
     * a facility for generating electric power
     *
     * @see <a href="http://www.geonames.org/ontology#S.PS">#S.PS</a>
     */
    public static final IRI S_PS;

    /**
     * hydroelectric power station
     * <p>
     * {@code http://www.geonames.org/ontology#S.PSH}
     * <p>
     * a building where electricity is generated from water power
     *
     * @see <a href="http://www.geonames.org/ontology#S.PSH">#S.PSH</a>
     */
    public static final IRI S_PSH;

    /**
     * border post
     * <p>
     * {@code http://www.geonames.org/ontology#S.PSTB}
     * <p>
     * a post or station at an international boundary for the regulation of
     * movement of people and goods
     *
     * @see <a href="http://www.geonames.org/ontology#S.PSTB">#S.PSTB</a>
     */
    public static final IRI S_PSTB;

    /**
     * customs post
     * <p>
     * {@code http://www.geonames.org/ontology#S.PSTC}
     * <p>
     * a building at an international boundary where customs and duties are
     * paid on goods
     *
     * @see <a href="http://www.geonames.org/ontology#S.PSTC">#S.PSTC</a>
     */
    public static final IRI S_PSTC;

    /**
     * patrol post
     * <p>
     * {@code http://www.geonames.org/ontology#S.PSTP}
     * <p>
     * a post from which patrols are sent out
     *
     * @see <a href="http://www.geonames.org/ontology#S.PSTP">#S.PSTP</a>
     */
    public static final IRI S_PSTP;

    /**
     * pyramid
     * <p>
     * {@code http://www.geonames.org/ontology#S.PYR}
     * <p>
     * an ancient massive structure of square ground plan with four
     * triangular faces meeting at a point and used for enclosing tombs
     *
     * @see <a href="http://www.geonames.org/ontology#S.PYR">#S.PYR</a>
     */
    public static final IRI S_PYR;

    /**
     * pyramider
     * <p>
     * {@code http://www.geonames.org/ontology#S.PYRS}
     * <p>
     * ancient massive structures of square ground plan with four triangular
     * faces meeting at a point and used for enclosing tombs
     *
     * @see <a href="http://www.geonames.org/ontology#S.PYRS">#S.PYRS</a>
     */
    public static final IRI S_PYRS;

    /**
     * brygge
     * <p>
     * {@code http://www.geonames.org/ontology#S.QUAY}
     * <p>
     * a structure of solid construction along a shore or bank which provides
     * berthing for ships and which generally provides cargo handling
     * facilities
     *
     * @see <a href="http://www.geonames.org/ontology#S.QUAY">#S.QUAY</a>
     */
    public static final IRI S_QUAY;

    /**
     * traffic circle
     * <p>
     * {@code http://www.geonames.org/ontology#S.RDCR}
     * <p>
     * a road junction formed around a central circle about which traffic
     * moves in one direction only
     *
     * @see <a href="http://www.geonames.org/ontology#S.RDCR">#S.RDCR</a>
     */
    public static final IRI S_RDCR;

    /**
     * golf course
     * <p>
     * {@code http://www.geonames.org/ontology#S.RECG}
     * <p>
     * a recreation field where golf is played
     *
     * @see <a href="http://www.geonames.org/ontology#S.RECG">#S.RECG</a>
     */
    public static final IRI S_RECG;

    /**
     * kapplöpningsbana
     * <p>
     * {@code http://www.geonames.org/ontology#S.RECR}
     * <p>
     * a track where races are held
     *
     * @see <a href="http://www.geonames.org/ontology#S.RECR">#S.RECR</a>
     */
    public static final IRI S_RECR;

    /**
     * restaurang
     * <p>
     * {@code http://www.geonames.org/ontology#S.REST}
     * <p>
     * A place where meals are served to the public
     *
     * @see <a href="http://www.geonames.org/ontology#S.REST">#S.REST</a>
     */
    public static final IRI S_REST;

    /**
     * store
     * <p>
     * {@code http://www.geonames.org/ontology#S.RET}
     * <p>
     * a building where goods and/or services are offered for sale
     *
     * @see <a href="http://www.geonames.org/ontology#S.RET">#S.RET</a>
     */
    public static final IRI S_RET;

    /**
     * hvilehjem
     * <p>
     * {@code http://www.geonames.org/ontology#S.RHSE}
     * <p>
     * a structure maintained for the rest and shelter of travelers
     *
     * @see <a href="http://www.geonames.org/ontology#S.RHSE">#S.RHSE</a>
     */
    public static final IRI S_RHSE;

    /**
     * djurkoloni
     * <p>
     * {@code http://www.geonames.org/ontology#S.RKRY}
     * <p>
     * a breeding place of a colony of birds or seals
     *
     * @see <a href="http://www.geonames.org/ontology#S.RKRY">#S.RKRY</a>
     */
    public static final IRI S_RKRY;

    /**
     * religious site
     * <p>
     * {@code http://www.geonames.org/ontology#S.RLG}
     * <p>
     * an ancient site of significant religious importance
     *
     * @see <a href="http://www.geonames.org/ontology#S.RLG">#S.RLG</a>
     */
    public static final IRI S_RLG;

    /**
     * fristad, tillflyktsort
     * <p>
     * {@code http://www.geonames.org/ontology#S.RLGR}
     * <p>
     * a place of temporary seclusion, especially for religious groups
     *
     * @see <a href="http://www.geonames.org/ontology#S.RLGR">#S.RLGR</a>
     */
    public static final IRI S_RLGR;

    /**
     * ranch(er)
     * <p>
     * {@code http://www.geonames.org/ontology#S.RNCH}
     * <p>
     * a large farm specializing in extensive grazing of livestock
     *
     * @see <a href="http://www.geonames.org/ontology#S.RNCH">#S.RNCH</a>
     */
    public static final IRI S_RNCH;

    /**
     * jernbanesidespor
     * <p>
     * {@code http://www.geonames.org/ontology#S.RSD}
     * <p>
     * a short track parallel to and joining the main track
     *
     * @see <a href="http://www.geonames.org/ontology#S.RSD">#S.RSD</a>
     */
    public static final IRI S_RSD;

    /**
     * jernbanesignal
     * <p>
     * {@code http://www.geonames.org/ontology#S.RSGNL}
     * <p>
     * a signal at the entrance of a particular section of track governing
     * the movement of trains
     *
     * @see <a href="http://www.geonames.org/ontology#S.RSGNL">#S.RSGNL</a>
     */
    public static final IRI S_RSGNL;

    /**
     * feriested
     * <p>
     * {@code http://www.geonames.org/ontology#S.RSRT}
     * <p>
     * a specialized facility for vacation, health, or participation sports
     * activities
     *
     * @see <a href="http://www.geonames.org/ontology#S.RSRT">#S.RSRT</a>
     */
    public static final IRI S_RSRT;

    /**
     * jernbanestasjon
     * <p>
     * {@code http://www.geonames.org/ontology#S.RSTN}
     * <p>
     * a facility comprising ticket office, platforms, etc. for loading and
     * unloading train passengers and freight
     *
     * @see <a href="http://www.geonames.org/ontology#S.RSTN">#S.RSTN</a>
     */
    public static final IRI S_RSTN;

    /**
     * abandoned railroad station
     * <p>
     * {@code http://www.geonames.org/ontology#S.RSTNQ}
     *
     * @see <a href="http://www.geonames.org/ontology#S.RSTNQ">#S.RSTNQ</a>
     */
    public static final IRI S_RSTNQ;

    /**
     * jernbanestoppested
     * <p>
     * {@code http://www.geonames.org/ontology#S.RSTP}
     * <p>
     * a place lacking station facilities where trains stop to pick up and
     * unload passengers and freight
     *
     * @see <a href="http://www.geonames.org/ontology#S.RSTP">#S.RSTP</a>
     */
    public static final IRI S_RSTP;

    /**
     * abandoned railroad stop
     * <p>
     * {@code http://www.geonames.org/ontology#S.RSTPQ}
     *
     * @see <a href="http://www.geonames.org/ontology#S.RSTPQ">#S.RSTPQ</a>
     */
    public static final IRI S_RSTPQ;

    /**
     * ruin(er)
     * <p>
     * {@code http://www.geonames.org/ontology#S.RUIN}
     * <p>
     * a destroyed or decayed structure which is no longer functional
     *
     * @see <a href="http://www.geonames.org/ontology#S.RUIN">#S.RUIN</a>
     */
    public static final IRI S_RUIN;

    /**
     * school
     * <p>
     * {@code http://www.geonames.org/ontology#S.SCH}
     * <p>
     * building(s) where instruction in one or more branches of knowledge
     * takes place
     *
     * @see <a href="http://www.geonames.org/ontology#S.SCH">#S.SCH</a>
     */
    public static final IRI S_SCH;

    /**
     * agricultural school
     * <p>
     * {@code http://www.geonames.org/ontology#S.SCHA}
     * <p>
     * a school with a curriculum focused on agriculture
     *
     * @see <a href="http://www.geonames.org/ontology#S.SCHA">#S.SCHA</a>
     */
    public static final IRI S_SCHA;

    /**
     * college
     * <p>
     * {@code http://www.geonames.org/ontology#S.SCHC}
     * <p>
     * the grounds and buildings of an institution of higher learning
     *
     * @see <a href="http://www.geonames.org/ontology#S.SCHC">#S.SCHC</a>
     */
    public static final IRI S_SCHC;

    /**
     * Driving School
     * <p>
     * {@code http://www.geonames.org/ontology#S.SCHD}
     * <p>
     * Driving School
     *
     * @see <a href="http://www.geonames.org/ontology#S.SCHD">#S.SCHD</a>
     */
    public static final IRI S_SCHD;

    /**
     * Language School
     * <p>
     * {@code http://www.geonames.org/ontology#S.SCHL}
     * <p>
     * Language Schools &amp; Institutions
     *
     * @see <a href="http://www.geonames.org/ontology#S.SCHL">#S.SCHL</a>
     */
    public static final IRI S_SCHL;

    /**
     * military school
     * <p>
     * {@code http://www.geonames.org/ontology#S.SCHM}
     * <p>
     * a school at which military science forms the core of the curriculum
     *
     * @see <a href="http://www.geonames.org/ontology#S.SCHM">#S.SCHM</a>
     */
    public static final IRI S_SCHM;

    /**
     * maritime school
     * <p>
     * {@code http://www.geonames.org/ontology#S.SCHN}
     * <p>
     * a school at which maritime sciences form the core of the curriculum
     *
     * @see <a href="http://www.geonames.org/ontology#S.SCHN">#S.SCHN</a>
     */
    public static final IRI S_SCHN;

    /**
     * technical school
     * <p>
     * {@code http://www.geonames.org/ontology#S.SCHT}
     * <p>
     * post-secondary school with a specifically technical or vocational
     * curriculum
     *
     * @see <a href="http://www.geonames.org/ontology#S.SCHT">#S.SCHT</a>
     */
    public static final IRI S_SCHT;

    /**
     * State Exam Prep Centre
     * <p>
     * {@code http://www.geonames.org/ontology#S.SECP}
     * <p>
     * state exam preparation centres
     *
     * @see <a href="http://www.geonames.org/ontology#S.SECP">#S.SECP</a>
     */
    public static final IRI S_SECP;

    /**
     * fårfälla
     * <p>
     * {@code http://www.geonames.org/ontology#S.SHPF}
     * <p>
     * a fence or wall enclosure for sheep and other small herd animals
     *
     * @see <a href="http://www.geonames.org/ontology#S.SHPF">#S.SHPF</a>
     */
    public static final IRI S_SHPF;

    /**
     * helgedom
     * <p>
     * {@code http://www.geonames.org/ontology#S.SHRN}
     * <p>
     * a structure or place memorializing a person or religious concept
     *
     * @see <a href="http://www.geonames.org/ontology#S.SHRN">#S.SHRN</a>
     */
    public static final IRI S_SHRN;

    /**
     * lagerbygning
     * <p>
     * {@code http://www.geonames.org/ontology#S.SHSE}
     * <p>
     * a building for storing goods, especially provisions
     *
     * @see <a href="http://www.geonames.org/ontology#S.SHSE">#S.SHSE</a>
     */
    public static final IRI S_SHSE;

    /**
     * sluice
     * <p>
     * {@code http://www.geonames.org/ontology#S.SLCE}
     * <p>
     * a conduit or passage for carrying off surplus water from a waterbody,
     * usually regulated by means of a sluice gate
     *
     * @see <a href="http://www.geonames.org/ontology#S.SLCE">#S.SLCE</a>
     */
    public static final IRI S_SLCE;

    /**
     * sanatorium
     * <p>
     * {@code http://www.geonames.org/ontology#S.SNTR}
     * <p>
     * a facility where victims of physical or mental disorders are treated
     *
     * @see <a href="http://www.geonames.org/ontology#S.SNTR">#S.SNTR</a>
     */
    public static final IRI S_SNTR;

    /**
     * bad
     * <p>
     * {@code http://www.geonames.org/ontology#S.SPA}
     * <p>
     * a resort area usually developed around a medicinal spring
     *
     * @see <a href="http://www.geonames.org/ontology#S.SPA">#S.SPA</a>
     */
    public static final IRI S_SPA;

    /**
     * dammavlopp
     * <p>
     * {@code http://www.geonames.org/ontology#S.SPLY}
     * <p>
     * a passage or outlet through which surplus water flows over, around or
     * through a dam
     *
     * @see <a href="http://www.geonames.org/ontology#S.SPLY">#S.SPLY</a>
     */
    public static final IRI S_SPLY;

    /**
     * plass
     * <p>
     * {@code http://www.geonames.org/ontology#S.SQR}
     * <p>
     * a broad, open, public area near the center of a town or city
     *
     * @see <a href="http://www.geonames.org/ontology#S.SQR">#S.SQR</a>
     */
    public static final IRI S_SQR;

    /**
     * stable
     * <p>
     * {@code http://www.geonames.org/ontology#S.STBL}
     * <p>
     * a building for the shelter and feeding of farm animals, especially
     * horses
     *
     * @see <a href="http://www.geonames.org/ontology#S.STBL">#S.STBL</a>
     */
    public static final IRI S_STBL;

    /**
     * stadion
     * <p>
     * {@code http://www.geonames.org/ontology#S.STDM}
     * <p>
     * a structure with an enclosure for athletic games with tiers of seats
     * for spectators
     *
     * @see <a href="http://www.geonames.org/ontology#S.STDM">#S.STDM</a>
     */
    public static final IRI S_STDM;

    /**
     * forskningsbase
     * <p>
     * {@code http://www.geonames.org/ontology#S.STNB}
     * <p>
     * a scientific facility used as a base from which research is carried
     * out or monitored
     *
     * @see <a href="http://www.geonames.org/ontology#S.STNB">#S.STNB</a>
     */
    public static final IRI S_STNB;

    /**
     * coast guard station
     * <p>
     * {@code http://www.geonames.org/ontology#S.STNC}
     * <p>
     * a facility from which the coast is guarded by armed vessels
     *
     * @see <a href="http://www.geonames.org/ontology#S.STNC">#S.STNC</a>
     */
    public static final IRI S_STNC;

    /**
     * eksperimentstasjon
     * <p>
     * {@code http://www.geonames.org/ontology#S.STNE}
     * <p>
     * a facility for carrying out experiments
     *
     * @see <a href="http://www.geonames.org/ontology#S.STNE">#S.STNE</a>
     */
    public static final IRI S_STNE;

    /**
     * forest station
     * <p>
     * {@code http://www.geonames.org/ontology#S.STNF}
     * <p>
     * a collection of buildings and facilities for carrying out forest
     * management
     *
     * @see <a href="http://www.geonames.org/ontology#S.STNF">#S.STNF</a>
     */
    public static final IRI S_STNF;

    /**
     * inspection station
     * <p>
     * {@code http://www.geonames.org/ontology#S.STNI}
     * <p>
     * a station at which vehicles, goods, and people are inspected
     *
     * @see <a href="http://www.geonames.org/ontology#S.STNI">#S.STNI</a>
     */
    public static final IRI S_STNI;

    /**
     * meteorological station
     * <p>
     * {@code http://www.geonames.org/ontology#S.STNM}
     * <p>
     * a station at which weather elements are recorded
     *
     * @see <a href="http://www.geonames.org/ontology#S.STNM">#S.STNM</a>
     */
    public static final IRI S_STNM;

    /**
     * radio station
     * <p>
     * {@code http://www.geonames.org/ontology#S.STNR}
     * <p>
     * a facility for producing and transmitting information by radio waves
     *
     * @see <a href="http://www.geonames.org/ontology#S.STNR">#S.STNR</a>
     */
    public static final IRI S_STNR;

    /**
     * satellite station
     * <p>
     * {@code http://www.geonames.org/ontology#S.STNS}
     * <p>
     * a facility for tracking and communicating with orbiting satellites
     *
     * @see <a href="http://www.geonames.org/ontology#S.STNS">#S.STNS</a>
     */
    public static final IRI S_STNS;

    /**
     * hvalfangststasjon
     * <p>
     * {@code http://www.geonames.org/ontology#S.STNW}
     * <p>
     * a facility for butchering whales and processing train oil
     *
     * @see <a href="http://www.geonames.org/ontology#S.STNW">#S.STNW</a>
     */
    public static final IRI S_STNW;

    /**
     * steps
     * <p>
     * {@code http://www.geonames.org/ontology#S.STPS}
     * <p>
     * stones or slabs placed for ease in ascending or descending a steep
     * slope
     *
     * @see <a href="http://www.geonames.org/ontology#S.STPS">#S.STPS</a>
     */
    public static final IRI S_STPS;

    /**
     * sewage treatment plant
     * <p>
     * {@code http://www.geonames.org/ontology#S.SWT}
     * <p>
     * facility for the processing of sewage and/or wastewater
     *
     * @see <a href="http://www.geonames.org/ontology#S.SWT">#S.SWT</a>
     */
    public static final IRI S_SWT;

    /**
     * teater
     * <p>
     * {@code http://www.geonames.org/ontology#S.THTR}
     * <p>
     * A building, room, or outdoor structure for the presentation of plays,
     * films, or other dramatic performances
     *
     * @see <a href="http://www.geonames.org/ontology#S.THTR">#S.THTR</a>
     */
    public static final IRI S_THTR;

    /**
     * grav(ar)
     * <p>
     * {@code http://www.geonames.org/ontology#S.TMB}
     * <p>
     * a structure for interring bodies
     *
     * @see <a href="http://www.geonames.org/ontology#S.TMB">#S.TMB</a>
     */
    public static final IRI S_TMB;

    /**
     * tempel
     * <p>
     * {@code http://www.geonames.org/ontology#S.TMPL}
     * <p>
     * an edifice dedicated to religious worship
     *
     * @see <a href="http://www.geonames.org/ontology#S.TMPL">#S.TMPL</a>
     */
    public static final IRI S_TMPL;

    /**
     * cattle dipping tank
     * <p>
     * {@code http://www.geonames.org/ontology#S.TNKD}
     * <p>
     * a small artificial pond used for immersing cattle in chemically
     * treated water for disease control
     *
     * @see <a href="http://www.geonames.org/ontology#S.TNKD">#S.TNKD</a>
     */
    public static final IRI S_TNKD;

    /**
     * torn
     * <p>
     * {@code http://www.geonames.org/ontology#S.TOWR}
     * <p>
     * a high conspicuous structure, typically much higher than its diameter
     *
     * @see <a href="http://www.geonames.org/ontology#S.TOWR">#S.TOWR</a>
     */
    public static final IRI S_TOWR;

    /**
     * transit terminal
     * <p>
     * {@code http://www.geonames.org/ontology#S.TRANT}
     * <p>
     * facilities for the handling of vehicular freight and passengers
     *
     * @see <a href="http://www.geonames.org/ontology#S.TRANT">#S.TRANT</a>
     */
    public static final IRI S_TRANT;

    /**
     * triangulation station
     * <p>
     * {@code http://www.geonames.org/ontology#S.TRIG}
     * <p>
     * a point on the earth whose position has been determined by
     * triangulation
     *
     * @see <a href="http://www.geonames.org/ontology#S.TRIG">#S.TRIG</a>
     */
    public static final IRI S_TRIG;

    /**
     * oil pipeline terminal
     * <p>
     * {@code http://www.geonames.org/ontology#S.TRMO}
     * <p>
     * a tank farm or loading facility at the end of an oil pipeline
     *
     * @see <a href="http://www.geonames.org/ontology#S.TRMO">#S.TRMO</a>
     */
    public static final IRI S_TRMO;

    /**
     * Temp Work Office
     * <p>
     * {@code http://www.geonames.org/ontology#S.TWO}
     * <p>
     * Temporary Work Offices
     *
     * @see <a href="http://www.geonames.org/ontology#S.TWO">#S.TWO</a>
     */
    public static final IRI S_TWO;

    /**
     * postgrad &amp; MBA
     * <p>
     * {@code http://www.geonames.org/ontology#S.UNIO}
     * <p>
     * Post Universitary Education Institutes (post graduate studies and
     * highly specialised master programs) &amp; MBA
     *
     * @see <a href="http://www.geonames.org/ontology#S.UNIO">#S.UNIO</a>
     */
    public static final IRI S_UNIO;

    /**
     * University Prep School
     * <p>
     * {@code http://www.geonames.org/ontology#S.UNIP}
     * <p>
     * University Preparation Schools &amp; Institutions
     *
     * @see <a href="http://www.geonames.org/ontology#S.UNIP">#S.UNIP</a>
     */
    public static final IRI S_UNIP;

    /**
     * universitet
     * <p>
     * {@code http://www.geonames.org/ontology#S.UNIV}
     * <p>
     * An institution for higher learning with teaching and research
     * facilities constituting a graduate school and professional schools
     * that award master&#39;s degrees and doctorates and an undergraduate
     * division that awards bachelor&#39;s degrees.
     *
     * @see <a href="http://www.geonames.org/ontology#S.UNIV">#S.UNIV</a>
     */
    public static final IRI S_UNIV;

    /**
     * amerikansk regeringsbyggnad
     * <p>
     * {@code http://www.geonames.org/ontology#S.USGE}
     * <p>
     * a facility operated by the United States Government in Panama
     *
     * @see <a href="http://www.geonames.org/ontology#S.USGE">#S.USGE</a>
     */
    public static final IRI S_USGE;

    /**
     * veterinary facility
     * <p>
     * {@code http://www.geonames.org/ontology#S.VETF}
     * <p>
     * a building or camp at which veterinary services are available
     *
     * @see <a href="http://www.geonames.org/ontology#S.VETF">#S.VETF</a>
     */
    public static final IRI S_VETF;

    /**
     * mur
     * <p>
     * {@code http://www.geonames.org/ontology#S.WALL}
     * <p>
     * a thick masonry structure, usually enclosing a field or building, or
     * forming the side of a structure
     *
     * @see <a href="http://www.geonames.org/ontology#S.WALL">#S.WALL</a>
     */
    public static final IRI S_WALL;

    /**
     * ancient wall
     * <p>
     * {@code http://www.geonames.org/ontology#S.WALLA}
     * <p>
     * the remains of a linear defensive stone structure
     *
     * @see <a href="http://www.geonames.org/ontology#S.WALLA">#S.WALLA</a>
     */
    public static final IRI S_WALLA;

    /**
     * damm, fördämning
     * <p>
     * {@code http://www.geonames.org/ontology#S.WEIR}
     * <p>
     * a small dam in a stream, designed to raise the water level or to
     * divert stream flow through a desired channel
     *
     * @see <a href="http://www.geonames.org/ontology#S.WEIR">#S.WEIR</a>
     */
    public static final IRI S_WEIR;

    /**
     * kai
     * <p>
     * {@code http://www.geonames.org/ontology#S.WHRF}
     * <p>
     * a structure of open rather than solid construction along a shore or a
     * bank which provides berthing for ships and cargo-handling facilities
     *
     * @see <a href="http://www.geonames.org/ontology#S.WHRF">#S.WHRF</a>
     */
    public static final IRI S_WHRF;

    /**
     * vrak
     * <p>
     * {@code http://www.geonames.org/ontology#S.WRCK}
     * <p>
     * the site of the remains of a wrecked vessel
     *
     * @see <a href="http://www.geonames.org/ontology#S.WRCK">#S.WRCK</a>
     */
    public static final IRI S_WRCK;

    /**
     * vannverk
     * <p>
     * {@code http://www.geonames.org/ontology#S.WTRW}
     * <p>
     * a facility for supplying potable water through a water source and a
     * system of pumps and filtration beds
     *
     * @see <a href="http://www.geonames.org/ontology#S.WTRW">#S.WTRW</a>
     */
    public static final IRI S_WTRW;

    /**
     * free trade zone
     * <p>
     * {@code http://www.geonames.org/ontology#S.ZNF}
     * <p>
     * an area, usually a section of a port, where goods may be received and
     * shipped free of customs duty and of most customs regulations
     *
     * @see <a href="http://www.geonames.org/ontology#S.ZNF">#S.ZNF</a>
     */
    public static final IRI S_ZNF;

    /**
     * dyrehage
     * <p>
     * {@code http://www.geonames.org/ontology#S.ZOO}
     * <p>
     * a zoological garden or park where wild animals are kept for exhibition
     *
     * @see <a href="http://www.geonames.org/ontology#S.ZOO">#S.ZOO</a>
     */
    public static final IRI S_ZOO;

    /**
     * short name
     * <p>
     * {@code http://www.geonames.org/ontology#shortName}
     *
     * @see <a href="http://www.geonames.org/ontology#shortName">#shortName</a>
     */
    public static final IRI shortName;

    /**
     * {@code http://www.geonames.org/ontology#T}
     * <p>
     * mountain, hill, rock, ...
     *
     * @see <a href="http://www.geonames.org/ontology#T">#T</a>
     */
    public static final IRI T;

    /**
     * asfaltsjø
     * <p>
     * {@code http://www.geonames.org/ontology#T.ASPH}
     * <p>
     * a small basin containing naturally occurring asphalt
     *
     * @see <a href="http://www.geonames.org/ontology#T.ASPH">#T.ASPH</a>
     */
    public static final IRI T_ASPH;

    /**
     * atoll(er)
     * <p>
     * {@code http://www.geonames.org/ontology#T.ATOL}
     * <p>
     * a ring-shaped coral reef which has closely spaced islands on it
     * encircling a lagoon
     *
     * @see <a href="http://www.geonames.org/ontology#T.ATOL">#T.ATOL</a>
     */
    public static final IRI T_ATOL;

    /**
     * bar
     * <p>
     * {@code http://www.geonames.org/ontology#T.BAR}
     * <p>
     * a shallow ridge or mound of coarse unconsolidated material in a stream
     * channel, at the mouth of a stream, estuary, or lagoon and in the
     * wave-break zone along coasts
     *
     * @see <a href="http://www.geonames.org/ontology#T.BAR">#T.BAR</a>
     */
    public static final IRI T_BAR;

    /**
     * beach
     * <p>
     * {@code http://www.geonames.org/ontology#T.BCH}
     * <p>
     * a shore zone of coarse unconsolidated sediment that extends from the
     * low-water line to the highest reach of storm waves
     *
     * @see <a href="http://www.geonames.org/ontology#T.BCH">#T.BCH</a>
     */
    public static final IRI T_BCH;

    /**
     * beaches
     * <p>
     * {@code http://www.geonames.org/ontology#T.BCHS}
     * <p>
     * a shore zone of coarse unconsolidated sediment that extends from the
     * low-water line to the highest reach of storm waves
     *
     * @see <a href="http://www.geonames.org/ontology#T.BCHS">#T.BCHS</a>
     */
    public static final IRI T_BCHS;

    /**
     * badlands
     * <p>
     * {@code http://www.geonames.org/ontology#T.BDLD}
     * <p>
     * an area characterized by a maze of very closely spaced, deep, narrow,
     * steep-sided ravines, and sharp crests and pinnacles
     *
     * @see <a href="http://www.geonames.org/ontology#T.BDLD">#T.BDLD</a>
     */
    public static final IRI T_BDLD;

    /**
     * boulder field
     * <p>
     * {@code http://www.geonames.org/ontology#T.BLDR}
     * <p>
     * a high altitude or high latitude bare, flat area covered with large
     * angular rocks
     *
     * @see <a href="http://www.geonames.org/ontology#T.BLDR">#T.BLDR</a>
     */
    public static final IRI T_BLDR;

    /**
     * blowhole(s)
     * <p>
     * {@code http://www.geonames.org/ontology#T.BLHL}
     * <p>
     * a hole in coastal rock through which sea water is forced by a rising
     * tide or waves and spurted through an outlet into the air
     *
     * @see <a href="http://www.geonames.org/ontology#T.BLHL">#T.BLHL</a>
     */
    public static final IRI T_BLHL;

    /**
     * blowout(s)
     * <p>
     * {@code http://www.geonames.org/ontology#T.BLOW}
     * <p>
     * a small depression in sandy terrain, caused by wind erosion
     *
     * @see <a href="http://www.geonames.org/ontology#T.BLOW">#T.BLOW</a>
     */
    public static final IRI T_BLOW;

    /**
     * avsats
     * <p>
     * {@code http://www.geonames.org/ontology#T.BNCH}
     * <p>
     * a long, narrow bedrock platform bounded by steeper slopes above and
     * below, usually overlooking a waterbody
     *
     * @see <a href="http://www.geonames.org/ontology#T.BNCH">#T.BNCH</a>
     */
    public static final IRI T_BNCH;

    /**
     * butte(s)
     * <p>
     * {@code http://www.geonames.org/ontology#T.BUTE}
     * <p>
     * a small, isolated, usually flat-topped hill with steep sides
     *
     * @see <a href="http://www.geonames.org/ontology#T.BUTE">#T.BUTE</a>
     */
    public static final IRI T_BUTE;

    /**
     * cape
     * <p>
     * {@code http://www.geonames.org/ontology#T.CAPE}
     * <p>
     * a land area, more prominent than a point, projecting into the sea and
     * marking a notable change in coastal direction
     *
     * @see <a href="http://www.geonames.org/ontology#T.CAPE">#T.CAPE</a>
     */
    public static final IRI T_CAPE;

    /**
     * cleft(s)
     * <p>
     * {@code http://www.geonames.org/ontology#T.CFT}
     * <p>
     * a deep narrow slot, notch, or groove in a coastal cliff
     *
     * @see <a href="http://www.geonames.org/ontology#T.CFT">#T.CFT</a>
     */
    public static final IRI T_CFT;

    /**
     * caldera
     * <p>
     * {@code http://www.geonames.org/ontology#T.CLDA}
     * <p>
     * a depression measuring kilometers across formed by the collapse of a
     * volcanic mountain
     *
     * @see <a href="http://www.geonames.org/ontology#T.CLDA">#T.CLDA</a>
     */
    public static final IRI T_CLDA;

    /**
     * brant klippa, stup
     * <p>
     * {@code http://www.geonames.org/ontology#T.CLF}
     * <p>
     * a high, steep to perpendicular slope overlooking a waterbody or lower
     * area
     *
     * @see <a href="http://www.geonames.org/ontology#T.CLF">#T.CLF</a>
     */
    public static final IRI T_CLF;

    /**
     * canyon
     * <p>
     * {@code http://www.geonames.org/ontology#T.CNYN}
     * <p>
     * a deep, narrow valley with steep sides cutting into a plateau or
     * mountainous area
     *
     * @see <a href="http://www.geonames.org/ontology#T.CNYN">#T.CNYN</a>
     */
    public static final IRI T_CNYN;

    /**
     * cone(s)
     * <p>
     * {@code http://www.geonames.org/ontology#T.CONE}
     * <p>
     * a conical landform composed of mud or volcanic material
     *
     * @see <a href="http://www.geonames.org/ontology#T.CONE">#T.CONE</a>
     */
    public static final IRI T_CONE;

    /**
     * corridor
     * <p>
     * {@code http://www.geonames.org/ontology#T.CRDR}
     * <p>
     * a strip or area of land having significance as an access way
     *
     * @see <a href="http://www.geonames.org/ontology#T.CRDR">#T.CRDR</a>
     */
    public static final IRI T_CRDR;

    /**
     * cirque
     * <p>
     * {@code http://www.geonames.org/ontology#T.CRQ}
     * <p>
     * a bowl-like hollow partially surrounded by cliffs or steep slopes at
     * the head of a glaciated valley
     *
     * @see <a href="http://www.geonames.org/ontology#T.CRQ">#T.CRQ</a>
     */
    public static final IRI T_CRQ;

    /**
     * cirques
     * <p>
     * {@code http://www.geonames.org/ontology#T.CRQS}
     * <p>
     * bowl-like hollows partially surrounded by cliffs or steep slopes at
     * the head of a glaciated valley
     *
     * @see <a href="http://www.geonames.org/ontology#T.CRQS">#T.CRQS</a>
     */
    public static final IRI T_CRQS;

    /**
     * crater(s)
     * <p>
     * {@code http://www.geonames.org/ontology#T.CRTR}
     * <p>
     * a generally circular saucer or bowl-shaped depression caused by
     * volcanic or meteorite explosive action
     *
     * @see <a href="http://www.geonames.org/ontology#T.CRTR">#T.CRTR</a>
     */
    public static final IRI T_CRTR;

    /**
     * backe
     * <p>
     * {@code http://www.geonames.org/ontology#T.CUET}
     * <p>
     * an asymmetric ridge formed on tilted strata
     *
     * @see <a href="http://www.geonames.org/ontology#T.CUET">#T.CUET</a>
     */
    public static final IRI T_CUET;

    /**
     * delta
     * <p>
     * {@code http://www.geonames.org/ontology#T.DLTA}
     * <p>
     * a flat plain formed by alluvial deposits at the mouth of a stream
     *
     * @see <a href="http://www.geonames.org/ontology#T.DLTA">#T.DLTA</a>
     */
    public static final IRI T_DLTA;

    /**
     * depression(er)
     * <p>
     * {@code http://www.geonames.org/ontology#T.DPR}
     * <p>
     * a low area surrounded by higher land and usually characterized by
     * interior drainage
     *
     * @see <a href="http://www.geonames.org/ontology#T.DPR">#T.DPR</a>
     */
    public static final IRI T_DPR;

    /**
     * desert
     * <p>
     * {@code http://www.geonames.org/ontology#T.DSRT}
     * <p>
     * a large area with little or no vegetation due to extreme environmental
     * conditions
     *
     * @see <a href="http://www.geonames.org/ontology#T.DSRT">#T.DSRT</a>
     */
    public static final IRI T_DSRT;

    /**
     * dune(s)
     * <p>
     * {@code http://www.geonames.org/ontology#T.DUNE}
     * <p>
     * a wave form, ridge or star shape feature composed of sand
     *
     * @see <a href="http://www.geonames.org/ontology#T.DUNE">#T.DUNE</a>
     */
    public static final IRI T_DUNE;

    /**
     * divide
     * <p>
     * {@code http://www.geonames.org/ontology#T.DVD}
     * <p>
     * a line separating adjacent drainage basins
     *
     * @see <a href="http://www.geonames.org/ontology#T.DVD">#T.DVD</a>
     */
    public static final IRI T_DVD;

    /**
     * sandy desert
     * <p>
     * {@code http://www.geonames.org/ontology#T.ERG}
     * <p>
     * an extensive tract of shifting sand and sand dunes
     *
     * @see <a href="http://www.geonames.org/ontology#T.ERG">#T.ERG</a>
     */
    public static final IRI T_ERG;

    /**
     * avleiringsvifte
     * <p>
     * {@code http://www.geonames.org/ontology#T.FAN}
     * <p>
     * a fan-shaped wedge of coarse alluvium with apex merging with a
     * mountain stream bed and the fan spreading out at a low angle slope
     * onto an adjacent plain
     *
     * @see <a href="http://www.geonames.org/ontology#T.FAN">#T.FAN</a>
     */
    public static final IRI T_FAN;

    /**
     * ford
     * <p>
     * {@code http://www.geonames.org/ontology#T.FORD}
     * <p>
     * a shallow part of a stream which can be crossed on foot or by land
     * vehicle
     *
     * @see <a href="http://www.geonames.org/ontology#T.FORD">#T.FORD</a>
     */
    public static final IRI T_FORD;

    /**
     * fissure
     * <p>
     * {@code http://www.geonames.org/ontology#T.FSR}
     * <p>
     * a crack associated with volcanism
     *
     * @see <a href="http://www.geonames.org/ontology#T.FSR">#T.FSR</a>
     */
    public static final IRI T_FSR;

    /**
     * gap, öppning, hål, klyfta
     * <p>
     * {@code http://www.geonames.org/ontology#T.GAP}
     * <p>
     * a low place in a ridge, not used for transportation
     *
     * @see <a href="http://www.geonames.org/ontology#T.GAP">#T.GAP</a>
     */
    public static final IRI T_GAP;

    /**
     * gorge(s)
     * <p>
     * {@code http://www.geonames.org/ontology#T.GRGE}
     * <p>
     * a short, narrow, steep-sided section of a stream valley
     *
     * @see <a href="http://www.geonames.org/ontology#T.GRGE">#T.GRGE</a>
     */
    public static final IRI T_GRGE;

    /**
     * halvö,udde
     * <p>
     * {@code http://www.geonames.org/ontology#T.HDLD}
     * <p>
     * a high projection of land extending into a large body of water beyond
     * the line of the coast
     *
     * @see <a href="http://www.geonames.org/ontology#T.HDLD">#T.HDLD</a>
     */
    public static final IRI T_HDLD;

    /**
     * hill
     * <p>
     * {@code http://www.geonames.org/ontology#T.HLL}
     * <p>
     * a rounded elevation of limited extent rising above the surrounding
     * land with local relief of less than 300m
     *
     * @see <a href="http://www.geonames.org/ontology#T.HLL">#T.HLL</a>
     */
    public static final IRI T_HLL;

    /**
     * hills
     * <p>
     * {@code http://www.geonames.org/ontology#T.HLLS}
     * <p>
     * rounded elevations of limited extent rising above the surrounding land
     * with local relief of less than 300m
     *
     * @see <a href="http://www.geonames.org/ontology#T.HLLS">#T.HLLS</a>
     */
    public static final IRI T_HLLS;

    /**
     * hammock (stykker av hevet land)
     * <p>
     * {@code http://www.geonames.org/ontology#T.HMCK}
     * <p>
     * a patch of ground, distinct from and slightly above the surrounding
     * plain or wetland. Often occurs in groups
     *
     * @see <a href="http://www.geonames.org/ontology#T.HMCK">#T.HMCK</a>
     */
    public static final IRI T_HMCK;

    /**
     * klippöken
     * <p>
     * {@code http://www.geonames.org/ontology#T.HMDA}
     * <p>
     * a relatively sand-free, high bedrock plateau in a hot desert, with or
     * without a gravel veneer
     *
     * @see <a href="http://www.geonames.org/ontology#T.HMDA">#T.HMDA</a>
     */
    public static final IRI T_HMDA;

    /**
     * interfluve
     * <p>
     * {@code http://www.geonames.org/ontology#T.INTF}
     * <p>
     * a relatively undissected upland between adjacent stream valleys
     *
     * @see <a href="http://www.geonames.org/ontology#T.INTF">#T.INTF</a>
     */
    public static final IRI T_INTF;

    /**
     * island
     * <p>
     * {@code http://www.geonames.org/ontology#T.ISL}
     * <p>
     * a tract of land, smaller than a continent, surrounded by water at high
     * water
     *
     * @see <a href="http://www.geonames.org/ontology#T.ISL">#T.ISL</a>
     */
    public static final IRI T_ISL;

    /**
     * islet
     * <p>
     * {@code http://www.geonames.org/ontology#T.ISLET}
     * <p>
     * small island, bigger than rock, smaller than island.
     *
     * @see <a href="http://www.geonames.org/ontology#T.ISLET">#T.ISLET</a>
     */
    public static final IRI T_ISLET;

    /**
     * artificial island
     * <p>
     * {@code http://www.geonames.org/ontology#T.ISLF}
     * <p>
     * an island created by landfill or diking and filling in a wetland, bay,
     * or lagoon
     *
     * @see <a href="http://www.geonames.org/ontology#T.ISLF">#T.ISLF</a>
     */
    public static final IRI T_ISLF;

    /**
     * mangrove island
     * <p>
     * {@code http://www.geonames.org/ontology#T.ISLM}
     * <p>
     * a mangrove swamp surrounded by a waterbody
     *
     * @see <a href="http://www.geonames.org/ontology#T.ISLM">#T.ISLM</a>
     */
    public static final IRI T_ISLM;

    /**
     * islands
     * <p>
     * {@code http://www.geonames.org/ontology#T.ISLS}
     * <p>
     * tracts of land, smaller than a continent, surrounded by water at high
     * water
     *
     * @see <a href="http://www.geonames.org/ontology#T.ISLS">#T.ISLS</a>
     */
    public static final IRI T_ISLS;

    /**
     * halvö
     * <p>
     * {@code http://www.geonames.org/ontology#T.ISLT}
     * <p>
     * a coastal island connected to the mainland by barrier beaches, levees
     * or dikes
     *
     * @see <a href="http://www.geonames.org/ontology#T.ISLT">#T.ISLT</a>
     */
    public static final IRI T_ISLT;

    /**
     * del av ö
     * <p>
     * {@code http://www.geonames.org/ontology#T.ISLX}
     *
     * @see <a href="http://www.geonames.org/ontology#T.ISLX">#T.ISLX</a>
     */
    public static final IRI T_ISLX;

    /**
     * isthmus
     * <p>
     * {@code http://www.geonames.org/ontology#T.ISTH}
     * <p>
     * a narrow strip of land connecting two larger land masses and bordered
     * by water
     *
     * @see <a href="http://www.geonames.org/ontology#T.ISTH">#T.ISTH</a>
     */
    public static final IRI T_ISTH;

    /**
     * karst area
     * <p>
     * {@code http://www.geonames.org/ontology#T.KRST}
     * <p>
     * a distinctive landscape developed on soluble rock such as limestone
     * characterized by sinkholes, caves, disappearing streams, and
     * underground drainage
     *
     * @see <a href="http://www.geonames.org/ontology#T.KRST">#T.KRST</a>
     */
    public static final IRI T_KRST;

    /**
     * lava area
     * <p>
     * {@code http://www.geonames.org/ontology#T.LAVA}
     * <p>
     * an area of solidified lava
     *
     * @see <a href="http://www.geonames.org/ontology#T.LAVA">#T.LAVA</a>
     */
    public static final IRI T_LAVA;

    /**
     * demning
     * <p>
     * {@code http://www.geonames.org/ontology#T.LEV}
     * <p>
     * a natural low embankment bordering a distributary or meandering
     * stream; often built up artificially to control floods
     *
     * @see <a href="http://www.geonames.org/ontology#T.LEV">#T.LEV</a>
     */
    public static final IRI T_LEV;

    /**
     * mesa(s)
     * <p>
     * {@code http://www.geonames.org/ontology#T.MESA}
     * <p>
     * a flat-topped, isolated elevation with steep slopes on all sides, less
     * extensive than a plateau
     *
     * @see <a href="http://www.geonames.org/ontology#T.MESA">#T.MESA</a>
     */
    public static final IRI T_MESA;

    /**
     * höjd(er)
     * <p>
     * {@code http://www.geonames.org/ontology#T.MND}
     * <p>
     * a low, isolated, rounded hill
     *
     * @see <a href="http://www.geonames.org/ontology#T.MND">#T.MND</a>
     */
    public static final IRI T_MND;

    /**
     * moraine
     * <p>
     * {@code http://www.geonames.org/ontology#T.MRN}
     * <p>
     * a mound, ridge, or other accumulation of glacial till
     *
     * @see <a href="http://www.geonames.org/ontology#T.MRN">#T.MRN</a>
     */
    public static final IRI T_MRN;

    /**
     * berg
     * <p>
     * {@code http://www.geonames.org/ontology#T.MT}
     * <p>
     * an elevation standing high above the surrounding area with small
     * summit area, steep slopes and local relief of 300m or more
     *
     * @see <a href="http://www.geonames.org/ontology#T.MT">#T.MT</a>
     */
    public static final IRI T_MT;

    /**
     * berg
     * <p>
     * {@code http://www.geonames.org/ontology#T.MTS}
     * <p>
     * a mountain range or a group of mountains or high ridges
     *
     * @see <a href="http://www.geonames.org/ontology#T.MTS">#T.MTS</a>
     */
    public static final IRI T_MTS;

    /**
     * meander neck
     * <p>
     * {@code http://www.geonames.org/ontology#T.NKM}
     * <p>
     * a narrow strip of land between the two limbs of a meander loop at its
     * narrowest point
     *
     * @see <a href="http://www.geonames.org/ontology#T.NKM">#T.NKM</a>
     */
    public static final IRI T_NKM;

    /**
     * nunatak
     * <p>
     * {@code http://www.geonames.org/ontology#T.NTK}
     * <p>
     * a rock or mountain peak protruding through glacial ice
     *
     * @see <a href="http://www.geonames.org/ontology#T.NTK">#T.NTK</a>
     */
    public static final IRI T_NTK;

    /**
     * nunataker
     * <p>
     * {@code http://www.geonames.org/ontology#T.NTKS}
     * <p>
     * rocks or mountain peaks protruding through glacial ice
     *
     * @see <a href="http://www.geonames.org/ontology#T.NTKS">#T.NTKS</a>
     */
    public static final IRI T_NTKS;

    /**
     * aurhelle
     * <p>
     * {@code http://www.geonames.org/ontology#T.PAN}
     * <p>
     * a near-level shallow, natural depression or basin, usually containing
     * an intermittent lake, pond, or pool
     *
     * @see <a href="http://www.geonames.org/ontology#T.PAN">#T.PAN</a>
     */
    public static final IRI T_PAN;

    /**
     * aurheller
     * <p>
     * {@code http://www.geonames.org/ontology#T.PANS}
     * <p>
     * a near-level shallow, natural depression or basin, usually containing
     * an intermittent lake, pond, or pool
     *
     * @see <a href="http://www.geonames.org/ontology#T.PANS">#T.PANS</a>
     */
    public static final IRI T_PANS;

    /**
     * bergspass, trång väg(passage)
     * <p>
     * {@code http://www.geonames.org/ontology#T.PASS}
     * <p>
     * a break in a mountain range or other high obstruction, used for
     * transportation from one side to the other [See also gap]
     *
     * @see <a href="http://www.geonames.org/ontology#T.PASS">#T.PASS</a>
     */
    public static final IRI T_PASS;

    /**
     * halvö
     * <p>
     * {@code http://www.geonames.org/ontology#T.PEN}
     * <p>
     * an elongate area of land projecting into a body of water and nearly
     * surrounded by water
     *
     * @see <a href="http://www.geonames.org/ontology#T.PEN">#T.PEN</a>
     */
    public static final IRI T_PEN;

    /**
     * del av halvö
     * <p>
     * {@code http://www.geonames.org/ontology#T.PENX}
     *
     * @see <a href="http://www.geonames.org/ontology#T.PENX">#T.PENX</a>
     */
    public static final IRI T_PENX;

    /**
     * peak
     * <p>
     * {@code http://www.geonames.org/ontology#T.PK}
     * <p>
     * a pointed elevation atop a mountain, ridge, or other hypsographic
     * feature
     *
     * @see <a href="http://www.geonames.org/ontology#T.PK">#T.PK</a>
     */
    public static final IRI T_PK;

    /**
     * peaks
     * <p>
     * {@code http://www.geonames.org/ontology#T.PKS}
     * <p>
     * pointed elevations atop a mountain, ridge, or other hypsographic
     * features
     *
     * @see <a href="http://www.geonames.org/ontology#T.PKS">#T.PKS</a>
     */
    public static final IRI T_PKS;

    /**
     * plateau
     * <p>
     * {@code http://www.geonames.org/ontology#T.PLAT}
     * <p>
     * an elevated plain with steep slopes on one or more sides, and often
     * with incised streams
     *
     * @see <a href="http://www.geonames.org/ontology#T.PLAT">#T.PLAT</a>
     */
    public static final IRI T_PLAT;

    /**
     * del av platå
     * <p>
     * {@code http://www.geonames.org/ontology#T.PLATX}
     *
     * @see <a href="http://www.geonames.org/ontology#T.PLATX">#T.PLATX</a>
     */
    public static final IRI T_PLATX;

    /**
     * invallat landområde
     * <p>
     * {@code http://www.geonames.org/ontology#T.PLDR}
     * <p>
     * an area reclaimed from the sea by diking and draining
     *
     * @see <a href="http://www.geonames.org/ontology#T.PLDR">#T.PLDR</a>
     */
    public static final IRI T_PLDR;

    /**
     * plain(s)
     * <p>
     * {@code http://www.geonames.org/ontology#T.PLN}
     * <p>
     * an extensive area of comparatively level to gently undulating land,
     * lacking surface irregularities, and usually adjacent to a higher area
     *
     * @see <a href="http://www.geonames.org/ontology#T.PLN">#T.PLN</a>
     */
    public static final IRI T_PLN;

    /**
     * del av slette
     * <p>
     * {@code http://www.geonames.org/ontology#T.PLNX}
     *
     * @see <a href="http://www.geonames.org/ontology#T.PLNX">#T.PLNX</a>
     */
    public static final IRI T_PLNX;

    /**
     * hög udde
     * <p>
     * {@code http://www.geonames.org/ontology#T.PROM}
     * <p>
     * a bluff or prominent hill overlooking or projecting into a lowland
     *
     * @see <a href="http://www.geonames.org/ontology#T.PROM">#T.PROM</a>
     */
    public static final IRI T_PROM;

    /**
     * odde
     * <p>
     * {@code http://www.geonames.org/ontology#T.PT}
     * <p>
     * a tapering piece of land projecting into a body of water, less
     * prominent than a cape
     *
     * @see <a href="http://www.geonames.org/ontology#T.PT">#T.PT</a>
     */
    public static final IRI T_PT;

    /**
     * odder
     * <p>
     * {@code http://www.geonames.org/ontology#T.PTS}
     * <p>
     * tapering pieces of land projecting into a body of water, less
     * prominent than a cape
     *
     * @see <a href="http://www.geonames.org/ontology#T.PTS">#T.PTS</a>
     */
    public static final IRI T_PTS;

    /**
     * beach ridge
     * <p>
     * {@code http://www.geonames.org/ontology#T.RDGB}
     * <p>
     * a ridge of sand just inland and parallel to the beach, usually in
     * series
     *
     * @see <a href="http://www.geonames.org/ontology#T.RDGB">#T.RDGB</a>
     */
    public static final IRI T_RDGB;

    /**
     * ridge(s)
     * <p>
     * {@code http://www.geonames.org/ontology#T.RDGE}
     * <p>
     * a long narrow elevation with steep sides, and a more or less
     * continuous crest
     *
     * @see <a href="http://www.geonames.org/ontology#T.RDGE">#T.RDGE</a>
     */
    public static final IRI T_RDGE;

    /**
     * steinørken
     * <p>
     * {@code http://www.geonames.org/ontology#T.REG}
     * <p>
     * a desert plain characterized by a surface veneer of gravel and stones
     *
     * @see <a href="http://www.geonames.org/ontology#T.REG">#T.REG</a>
     */
    public static final IRI T_REG;

    /**
     * klippa
     * <p>
     * {@code http://www.geonames.org/ontology#T.RK}
     * <p>
     * a conspicuous, isolated rocky mass
     *
     * @see <a href="http://www.geonames.org/ontology#T.RK">#T.RK</a>
     */
    public static final IRI T_RK;

    /**
     * ras
     * <p>
     * {@code http://www.geonames.org/ontology#T.RKFL}
     * <p>
     * an irregular mass of fallen rock at the base of a cliff or steep slope
     *
     * @see <a href="http://www.geonames.org/ontology#T.RKFL">#T.RKFL</a>
     */
    public static final IRI T_RKFL;

    /**
     * klipper
     * <p>
     * {@code http://www.geonames.org/ontology#T.RKS}
     * <p>
     * conspicuous, isolated rocky masses
     *
     * @see <a href="http://www.geonames.org/ontology#T.RKS">#T.RKS</a>
     */
    public static final IRI T_RKS;

    /**
     * sand area
     * <p>
     * {@code http://www.geonames.org/ontology#T.SAND}
     * <p>
     * a tract of land covered with sand
     *
     * @see <a href="http://www.geonames.org/ontology#T.SAND">#T.SAND</a>
     */
    public static final IRI T_SAND;

    /**
     * dry stream bed
     * <p>
     * {@code http://www.geonames.org/ontology#T.SBED}
     * <p>
     * a channel formerly containing the water of a stream
     *
     * @see <a href="http://www.geonames.org/ontology#T.SBED">#T.SBED</a>
     */
    public static final IRI T_SBED;

    /**
     * brant sluttning
     * <p>
     * {@code http://www.geonames.org/ontology#T.SCRP}
     * <p>
     * a long line of cliffs or steep slopes separating level surfaces above
     * and below
     *
     * @see <a href="http://www.geonames.org/ontology#T.SCRP">#T.SCRP</a>
     */
    public static final IRI T_SCRP;

    /**
     * saddle
     * <p>
     * {@code http://www.geonames.org/ontology#T.SDL}
     * <p>
     * a broad, open pass crossing a ridge or between hills or mountains
     *
     * @see <a href="http://www.geonames.org/ontology#T.SDL">#T.SDL</a>
     */
    public static final IRI T_SDL;

    /**
     * bredd
     * <p>
     * {@code http://www.geonames.org/ontology#T.SHOR}
     * <p>
     * a narrow zone bordering a waterbody which covers and uncovers at high
     * and low water, respectively
     *
     * @see <a href="http://www.geonames.org/ontology#T.SHOR">#T.SHOR</a>
     */
    public static final IRI T_SHOR;

    /**
     * jordfallshull
     * <p>
     * {@code http://www.geonames.org/ontology#T.SINK}
     * <p>
     * a small crater-shape depression in a karst area
     *
     * @see <a href="http://www.geonames.org/ontology#T.SINK">#T.SINK</a>
     */
    public static final IRI T_SINK;

    /**
     * kana
     * <p>
     * {@code http://www.geonames.org/ontology#T.SLID}
     * <p>
     * a mound of earth material, at the base of a slope and the associated
     * scoured area
     *
     * @see <a href="http://www.geonames.org/ontology#T.SLID">#T.SLID</a>
     */
    public static final IRI T_SLID;

    /**
     * kontinentalskråning
     * <p>
     * {@code http://www.geonames.org/ontology#T.SLP}
     * <p>
     * a surface with a relatively uniform slope angle
     *
     * @see <a href="http://www.geonames.org/ontology#T.SLP">#T.SLP</a>
     */
    public static final IRI T_SLP;

    /**
     * landtunga
     * <p>
     * {@code http://www.geonames.org/ontology#T.SPIT}
     * <p>
     * a narrow, straight or curved continuation of a beach into a waterbody
     *
     * @see <a href="http://www.geonames.org/ontology#T.SPIT">#T.SPIT</a>
     */
    public static final IRI T_SPIT;

    /**
     * spur(s)
     * <p>
     * {@code http://www.geonames.org/ontology#T.SPUR}
     * <p>
     * a subordinate ridge projecting outward from a hill, mountain or other
     * elevation
     *
     * @see <a href="http://www.geonames.org/ontology#T.SPUR">#T.SPUR</a>
     */
    public static final IRI T_SPUR;

    /**
     * steinur
     * <p>
     * {@code http://www.geonames.org/ontology#T.TAL}
     * <p>
     * a steep concave slope formed by an accumulation of loose rock
     * fragments at the base of a cliff or steep slope
     *
     * @see <a href="http://www.geonames.org/ontology#T.TAL">#T.TAL</a>
     */
    public static final IRI T_TAL;

    /**
     * dal mellom sanddyner
     * <p>
     * {@code http://www.geonames.org/ontology#T.TRGD}
     * <p>
     * a long wind-swept trough between parallel longitudinal dunes
     *
     * @see <a href="http://www.geonames.org/ontology#T.TRGD">#T.TRGD</a>
     */
    public static final IRI T_TRGD;

    /**
     * terass
     * <p>
     * {@code http://www.geonames.org/ontology#T.TRR}
     * <p>
     * a long, narrow alluvial platform bounded by steeper slopes above and
     * below, usually overlooking a waterbody
     *
     * @see <a href="http://www.geonames.org/ontology#T.TRR">#T.TRR</a>
     */
    public static final IRI T_TRR;

    /**
     * högland
     * <p>
     * {@code http://www.geonames.org/ontology#T.UPLD}
     * <p>
     * an extensive interior region of high land with low to moderate surface
     * relief
     *
     * @see <a href="http://www.geonames.org/ontology#T.UPLD">#T.UPLD</a>
     */
    public static final IRI T_UPLD;

    /**
     * dal
     * <p>
     * {@code http://www.geonames.org/ontology#T.VAL}
     * <p>
     * an elongated depression usually traversed by a stream
     *
     * @see <a href="http://www.geonames.org/ontology#T.VAL">#T.VAL</a>
     */
    public static final IRI T_VAL;

    /**
     * hanging valley
     * <p>
     * {@code http://www.geonames.org/ontology#T.VALG}
     * <p>
     * a valley the floor of which is notably higher than the valley or shore
     * to which it leads; most common in areas that have been glaciated
     *
     * @see <a href="http://www.geonames.org/ontology#T.VALG">#T.VALG</a>
     */
    public static final IRI T_VALG;

    /**
     * dalar
     * <p>
     * {@code http://www.geonames.org/ontology#T.VALS}
     * <p>
     * elongated depressions usually traversed by a stream
     *
     * @see <a href="http://www.geonames.org/ontology#T.VALS">#T.VALS</a>
     */
    public static final IRI T_VALS;

    /**
     * del av dal
     * <p>
     * {@code http://www.geonames.org/ontology#T.VALX}
     *
     * @see <a href="http://www.geonames.org/ontology#T.VALX">#T.VALX</a>
     */
    public static final IRI T_VALX;

    /**
     * volcano
     * <p>
     * {@code http://www.geonames.org/ontology#T.VLC}
     * <p>
     * a conical elevation composed of volcanic materials with a crater at
     * the top
     *
     * @see <a href="http://www.geonames.org/ontology#T.VLC">#T.VLC</a>
     */
    public static final IRI T_VLC;

    /**
     * {@code http://www.geonames.org/ontology#U}
     * <p>
     * undersea
     *
     * @see <a href="http://www.geonames.org/ontology#U">#U</a>
     */
    public static final IRI U;

    /**
     * apron
     * <p>
     * {@code http://www.geonames.org/ontology#U.APNU}
     * <p>
     * a gentle slope, with a generally smooth surface, particularly found
     * around groups of islands and seamounts
     *
     * @see <a href="http://www.geonames.org/ontology#U.APNU">#U.APNU</a>
     */
    public static final IRI U_APNU;

    /**
     * arch
     * <p>
     * {@code http://www.geonames.org/ontology#U.ARCU}
     * <p>
     * a low bulge around the southeastern end of the island of Hawaii
     *
     * @see <a href="http://www.geonames.org/ontology#U.ARCU">#U.ARCU</a>
     */
    public static final IRI U_ARCU;

    /**
     * arrugado
     * <p>
     * {@code http://www.geonames.org/ontology#U.ARRU}
     * <p>
     * an area of subdued corrugations off Baja California
     *
     * @see <a href="http://www.geonames.org/ontology#U.ARRU">#U.ARRU</a>
     */
    public static final IRI U_ARRU;

    /**
     * borderland
     * <p>
     * {@code http://www.geonames.org/ontology#U.BDLU}
     * <p>
     * a region adjacent to a continent, normally occupied by or bordering a
     * shelf, that is highly irregular with depths well in excess of those
     * typical of a shelf
     *
     * @see <a href="http://www.geonames.org/ontology#U.BDLU">#U.BDLU</a>
     */
    public static final IRI U_BDLU;

    /**
     * banks
     * <p>
     * {@code http://www.geonames.org/ontology#U.BKSU}
     * <p>
     * elevations, typically located on a shelf, over which the depth of
     * water is relatively shallow but sufficient for safe surface navigation
     *
     * @see <a href="http://www.geonames.org/ontology#U.BKSU">#U.BKSU</a>
     */
    public static final IRI U_BKSU;

    /**
     * bench
     * <p>
     * {@code http://www.geonames.org/ontology#U.BNCU}
     * <p>
     * a small terrace
     *
     * @see <a href="http://www.geonames.org/ontology#U.BNCU">#U.BNCU</a>
     */
    public static final IRI U_BNCU;

    /**
     * bank
     * <p>
     * {@code http://www.geonames.org/ontology#U.BNKU}
     * <p>
     * an elevation, typically located on a shelf, over which the depth of
     * water is relatively shallow but sufficient for safe surface navigation
     *
     * @see <a href="http://www.geonames.org/ontology#U.BNKU">#U.BNKU</a>
     */
    public static final IRI U_BNKU;

    /**
     * basin
     * <p>
     * {@code http://www.geonames.org/ontology#U.BSNU}
     * <p>
     * a depression more or less equidimensional in plan and of variable
     * extent
     *
     * @see <a href="http://www.geonames.org/ontology#U.BSNU">#U.BSNU</a>
     */
    public static final IRI U_BSNU;

    /**
     * bergskedja
     * <p>
     * {@code http://www.geonames.org/ontology#U.CDAU}
     * <p>
     * an entire mountain system including the subordinate ranges, interior
     * plateaus, and basins
     *
     * @see <a href="http://www.geonames.org/ontology#U.CDAU">#U.CDAU</a>
     */
    public static final IRI U_CDAU;

    /**
     * canyoner
     * <p>
     * {@code http://www.geonames.org/ontology#U.CNSU}
     * <p>
     * relatively narrow, deep depressions with steep sides, the bottom of
     * which generally has a continuous slope
     *
     * @see <a href="http://www.geonames.org/ontology#U.CNSU">#U.CNSU</a>
     */
    public static final IRI U_CNSU;

    /**
     * canyon
     * <p>
     * {@code http://www.geonames.org/ontology#U.CNYU}
     * <p>
     * a relatively narrow, deep depression with steep sides, the bottom of
     * which generally has a continuous slope
     *
     * @see <a href="http://www.geonames.org/ontology#U.CNYU">#U.CNYU</a>
     */
    public static final IRI U_CNYU;

    /**
     * continental rise
     * <p>
     * {@code http://www.geonames.org/ontology#U.CRSU}
     * <p>
     * a gentle slope rising from oceanic depths towards the foot of a
     * continental slope
     *
     * @see <a href="http://www.geonames.org/ontology#U.CRSU">#U.CRSU</a>
     */
    public static final IRI U_CRSU;

    /**
     * deep
     * <p>
     * {@code http://www.geonames.org/ontology#U.DEPU}
     * <p>
     * a localized deep area within the confines of a larger feature, such as
     * a trough, basin or trench
     *
     * @see <a href="http://www.geonames.org/ontology#U.DEPU">#U.DEPU</a>
     */
    public static final IRI U_DEPU;

    /**
     * kontinentalsokkelkant
     * <p>
     * {@code http://www.geonames.org/ontology#U.EDGU}
     * <p>
     * a line along which there is a marked increase of slope at the outer
     * margin of a continental shelf or island shelf
     *
     * @see <a href="http://www.geonames.org/ontology#U.EDGU">#U.EDGU</a>
     */
    public static final IRI U_EDGU;

    /**
     * brant sluttning
     * <p>
     * {@code http://www.geonames.org/ontology#U.ESCU}
     * <p>
     * an elongated and comparatively steep slope separating flat or gently
     * sloping areas
     *
     * @see <a href="http://www.geonames.org/ontology#U.ESCU">#U.ESCU</a>
     */
    public static final IRI U_ESCU;

    /**
     * avleiringsvifte
     * <p>
     * {@code http://www.geonames.org/ontology#U.FANU}
     * <p>
     * a relatively smooth feature normally sloping away from the lower
     * termination of a canyon or canyon system
     *
     * @see <a href="http://www.geonames.org/ontology#U.FANU">#U.FANU</a>
     */
    public static final IRI U_FANU;

    /**
     * flat
     * <p>
     * {@code http://www.geonames.org/ontology#U.FLTU}
     * <p>
     * a small level or nearly level area
     *
     * @see <a href="http://www.geonames.org/ontology#U.FLTU">#U.FLTU</a>
     */
    public static final IRI U_FLTU;

    /**
     * fork
     * <p>
     * {@code http://www.geonames.org/ontology#U.FRKU}
     * <p>
     * a branch of a canyon or valley
     *
     * @see <a href="http://www.geonames.org/ontology#U.FRKU">#U.FRKU</a>
     */
    public static final IRI U_FRKU;

    /**
     * forks
     * <p>
     * {@code http://www.geonames.org/ontology#U.FRSU}
     * <p>
     * a branch of a canyon or valley
     *
     * @see <a href="http://www.geonames.org/ontology#U.FRSU">#U.FRSU</a>
     */
    public static final IRI U_FRSU;

    /**
     * bruddsone
     * <p>
     * {@code http://www.geonames.org/ontology#U.FRZU}
     * <p>
     * an extensive linear zone of irregular topography of the sea floor,
     * characterized by steep-sided or asymmetrical ridges, troughs, or
     * escarpments
     *
     * @see <a href="http://www.geonames.org/ontology#U.FRZU">#U.FRZU</a>
     */
    public static final IRI U_FRZU;

    /**
     * fure
     * <p>
     * {@code http://www.geonames.org/ontology#U.FURU}
     * <p>
     * a closed, linear, narrow, shallow depression
     *
     * @see <a href="http://www.geonames.org/ontology#U.FURU">#U.FURU</a>
     */
    public static final IRI U_FURU;

    /**
     * gap
     * <p>
     * {@code http://www.geonames.org/ontology#U.GAPU}
     * <p>
     * a narrow break in a ridge or rise
     *
     * @see <a href="http://www.geonames.org/ontology#U.GAPU">#U.GAPU</a>
     */
    public static final IRI U_GAPU;

    /**
     * gully
     * <p>
     * {@code http://www.geonames.org/ontology#U.GLYU}
     * <p>
     * a small valley-like feature
     *
     * @see <a href="http://www.geonames.org/ontology#U.GLYU">#U.GLYU</a>
     */
    public static final IRI U_GLYU;

    /**
     * hill
     * <p>
     * {@code http://www.geonames.org/ontology#U.HLLU}
     * <p>
     * an elevation rising generally less than 500 meters
     *
     * @see <a href="http://www.geonames.org/ontology#U.HLLU">#U.HLLU</a>
     */
    public static final IRI U_HLLU;

    /**
     * hills
     * <p>
     * {@code http://www.geonames.org/ontology#U.HLSU}
     * <p>
     * elevations rising generally less than 500 meters
     *
     * @see <a href="http://www.geonames.org/ontology#U.HLSU">#U.HLSU</a>
     */
    public static final IRI U_HLSU;

    /**
     * hole
     * <p>
     * {@code http://www.geonames.org/ontology#U.HOLU}
     * <p>
     * a small depression of the sea floor
     *
     * @see <a href="http://www.geonames.org/ontology#U.HOLU">#U.HOLU</a>
     */
    public static final IRI U_HOLU;

    /**
     * knaus
     * <p>
     * {@code http://www.geonames.org/ontology#U.KNLU}
     * <p>
     * an elevation rising generally more than 500 meters and less than 1,000
     * meters and of limited extent across the summit
     *
     * @see <a href="http://www.geonames.org/ontology#U.KNLU">#U.KNLU</a>
     */
    public static final IRI U_KNLU;

    /**
     * knauser
     * <p>
     * {@code http://www.geonames.org/ontology#U.KNSU}
     * <p>
     * elevations rising generally more than 500 meters and less than 1,000
     * meters and of limited extent across the summits
     *
     * @see <a href="http://www.geonames.org/ontology#U.KNSU">#U.KNSU</a>
     */
    public static final IRI U_KNSU;

    /**
     * avsats
     * <p>
     * {@code http://www.geonames.org/ontology#U.LDGU}
     * <p>
     * a rocky projection or outcrop, commonly linear and near shore
     *
     * @see <a href="http://www.geonames.org/ontology#U.LDGU">#U.LDGU</a>
     */
    public static final IRI U_LDGU;

    /**
     * damm
     * <p>
     * {@code http://www.geonames.org/ontology#U.LEVU}
     * <p>
     * an embankment bordering a canyon, valley, or seachannel
     *
     * @see <a href="http://www.geonames.org/ontology#U.LEVU">#U.LEVU</a>
     */
    public static final IRI U_LEVU;

    /**
     * median valley
     * <p>
     * {@code http://www.geonames.org/ontology#U.MDVU}
     * <p>
     * the axial depression of the mid-oceanic ridge system
     *
     * @see <a href="http://www.geonames.org/ontology#U.MDVU">#U.MDVU</a>
     */
    public static final IRI U_MDVU;

    /**
     * högplatå
     * <p>
     * {@code http://www.geonames.org/ontology#U.MESU}
     * <p>
     * an isolated, extensive, flat-topped elevation on the shelf, with
     * relatively steep sides
     *
     * @see <a href="http://www.geonames.org/ontology#U.MESU">#U.MESU</a>
     */
    public static final IRI U_MESU;

    /**
     * gravkulle
     * <p>
     * {@code http://www.geonames.org/ontology#U.MNDU}
     * <p>
     * a low, isolated, rounded hill
     *
     * @see <a href="http://www.geonames.org/ontology#U.MNDU">#U.MNDU</a>
     */
    public static final IRI U_MNDU;

    /**
     * moat
     * <p>
     * {@code http://www.geonames.org/ontology#U.MOTU}
     * <p>
     * an annular depression that may not be continuous, located at the base
     * of many seamounts, islands, and other isolated elevations
     *
     * @see <a href="http://www.geonames.org/ontology#U.MOTU">#U.MOTU</a>
     */
    public static final IRI U_MOTU;

    /**
     * mountains
     * <p>
     * {@code http://www.geonames.org/ontology#U.MTSU}
     * <p>
     * well-delineated subdivisions of a large and complex positive feature
     *
     * @see <a href="http://www.geonames.org/ontology#U.MTSU">#U.MTSU</a>
     */
    public static final IRI U_MTSU;

    /**
     * berg
     * <p>
     * {@code http://www.geonames.org/ontology#U.MTU}
     * <p>
     * a well-delineated subdivision of a large and complex positive feature
     *
     * @see <a href="http://www.geonames.org/ontology#U.MTU">#U.MTU</a>
     */
    public static final IRI U_MTU;

    /**
     * peaks
     * <p>
     * {@code http://www.geonames.org/ontology#U.PKSU}
     * <p>
     * prominent elevations, part of a larger feature, either pointed or of
     * very limited extent across the summit
     *
     * @see <a href="http://www.geonames.org/ontology#U.PKSU">#U.PKSU</a>
     */
    public static final IRI U_PKSU;

    /**
     * peak
     * <p>
     * {@code http://www.geonames.org/ontology#U.PKU}
     * <p>
     * a prominent elevation, part of a larger feature, either pointed or of
     * very limited extent across the summit
     *
     * @see <a href="http://www.geonames.org/ontology#U.PKU">#U.PKU</a>
     */
    public static final IRI U_PKU;

    /**
     * platform
     * <p>
     * {@code http://www.geonames.org/ontology#U.PLFU}
     * <p>
     * a flat or gently sloping underwater surface extending seaward from the
     * shore
     *
     * @see <a href="http://www.geonames.org/ontology#U.PLFU">#U.PLFU</a>
     */
    public static final IRI U_PLFU;

    /**
     * plain
     * <p>
     * {@code http://www.geonames.org/ontology#U.PLNU}
     * <p>
     * a flat, gently sloping or nearly level region
     *
     * @see <a href="http://www.geonames.org/ontology#U.PLNU">#U.PLNU</a>
     */
    public static final IRI U_PLNU;

    /**
     * plateau
     * <p>
     * {@code http://www.geonames.org/ontology#U.PLTU}
     * <p>
     * a comparatively flat-topped feature of considerable extent, dropping
     * off abruptly on one or more sides
     *
     * @see <a href="http://www.geonames.org/ontology#U.PLTU">#U.PLTU</a>
     */
    public static final IRI U_PLTU;

    /**
     * klippa
     * <p>
     * {@code http://www.geonames.org/ontology#U.PNLU}
     * <p>
     * a high tower or spire-shaped pillar of rock or coral, alone or
     * cresting a summit
     *
     * @see <a href="http://www.geonames.org/ontology#U.PNLU">#U.PNLU</a>
     */
    public static final IRI U_PNLU;

    /**
     * province
     * <p>
     * {@code http://www.geonames.org/ontology#U.PRVU}
     * <p>
     * a region identifiable by a group of similar physiographic features
     * whose characteristics are markedly in contrast with surrounding areas
     *
     * @see <a href="http://www.geonames.org/ontology#U.PRVU">#U.PRVU</a>
     */
    public static final IRI U_PRVU;

    /**
     * ravine
     * <p>
     * {@code http://www.geonames.org/ontology#U.RAVU}
     * <p>
     * a small canyon
     *
     * @see <a href="http://www.geonames.org/ontology#U.RAVU">#U.RAVU</a>
     */
    public static final IRI U_RAVU;

    /**
     * ridge
     * <p>
     * {@code http://www.geonames.org/ontology#U.RDGU}
     * <p>
     * a long narrow elevation with steep sides
     *
     * @see <a href="http://www.geonames.org/ontology#U.RDGU">#U.RDGU</a>
     */
    public static final IRI U_RDGU;

    /**
     * ridges
     * <p>
     * {@code http://www.geonames.org/ontology#U.RDSU}
     * <p>
     * long narrow elevations with steep sides
     *
     * @see <a href="http://www.geonames.org/ontology#U.RDSU">#U.RDSU</a>
     */
    public static final IRI U_RDSU;

    /**
     * reefs
     * <p>
     * {@code http://www.geonames.org/ontology#U.RFSU}
     * <p>
     * surface-navigation hazards composed of consolidated material
     *
     * @see <a href="http://www.geonames.org/ontology#U.RFSU">#U.RFSU</a>
     */
    public static final IRI U_RFSU;

    /**
     * reef
     * <p>
     * {@code http://www.geonames.org/ontology#U.RFU}
     * <p>
     * a surface-navigation hazard composed of consolidated material
     *
     * @see <a href="http://www.geonames.org/ontology#U.RFU">#U.RFU</a>
     */
    public static final IRI U_RFU;

    /**
     * höjd
     * <p>
     * {@code http://www.geonames.org/ontology#U.RISU}
     * <p>
     * a broad elevation that rises gently, and generally smoothly, from the
     * sea floor
     *
     * @see <a href="http://www.geonames.org/ontology#U.RISU">#U.RISU</a>
     */
    public static final IRI U_RISU;

    /**
     * ramp
     * <p>
     * {@code http://www.geonames.org/ontology#U.RMPU}
     * <p>
     * a gentle slope connecting areas of different elevations
     *
     * @see <a href="http://www.geonames.org/ontology#U.RMPU">#U.RMPU</a>
     */
    public static final IRI U_RMPU;

    /**
     * range
     * <p>
     * {@code http://www.geonames.org/ontology#U.RNGU}
     * <p>
     * a series of associated ridges or seamounts
     *
     * @see <a href="http://www.geonames.org/ontology#U.RNGU">#U.RNGU</a>
     */
    public static final IRI U_RNGU;

    /**
     * havskanal
     * <p>
     * {@code http://www.geonames.org/ontology#U.SCNU}
     * <p>
     * a continuously sloping, elongated depression commonly found in fans or
     * plains and customarily bordered by levees on one or two sides
     *
     * @see <a href="http://www.geonames.org/ontology#U.SCNU">#U.SCNU</a>
     */
    public static final IRI U_SCNU;

    /**
     * havskanaler
     * <p>
     * {@code http://www.geonames.org/ontology#U.SCSU}
     * <p>
     * continuously sloping, elongated depressions commonly found in fans or
     * plains and customarily bordered by levees on one or two sides
     *
     * @see <a href="http://www.geonames.org/ontology#U.SCSU">#U.SCSU</a>
     */
    public static final IRI U_SCSU;

    /**
     * saddle
     * <p>
     * {@code http://www.geonames.org/ontology#U.SDLU}
     * <p>
     * a low part, resembling in shape a saddle, in a ridge or between
     * contiguous seamounts
     *
     * @see <a href="http://www.geonames.org/ontology#U.SDLU">#U.SDLU</a>
     */
    public static final IRI U_SDLU;

    /**
     * hylle
     * <p>
     * {@code http://www.geonames.org/ontology#U.SHFU}
     * <p>
     * a zone adjacent to a continent (or around an island) that extends from
     * the low water line to a depth at which there is usually a marked
     * increase of slope towards oceanic depths
     *
     * @see <a href="http://www.geonames.org/ontology#U.SHFU">#U.SHFU</a>
     */
    public static final IRI U_SHFU;

    /**
     * grund, sandrev
     * <p>
     * {@code http://www.geonames.org/ontology#U.SHLU}
     * <p>
     * a surface-navigation hazard composed of unconsolidated material
     *
     * @see <a href="http://www.geonames.org/ontology#U.SHLU">#U.SHLU</a>
     */
    public static final IRI U_SHLU;

    /**
     * sandbankar
     * <p>
     * {@code http://www.geonames.org/ontology#U.SHSU}
     * <p>
     * hazards to surface navigation composed of unconsolidated material
     *
     * @see <a href="http://www.geonames.org/ontology#U.SHSU">#U.SHSU</a>
     */
    public static final IRI U_SHSU;

    /**
     * dal gjennom kontinentalhyllen
     * <p>
     * {@code http://www.geonames.org/ontology#U.SHVU}
     * <p>
     * a valley on the shelf, generally the shoreward extension of a canyon
     *
     * @see <a href="http://www.geonames.org/ontology#U.SHVU">#U.SHVU</a>
     */
    public static final IRI U_SHVU;

    /**
     * sill
     * <p>
     * {@code http://www.geonames.org/ontology#U.SILU}
     * <p>
     * the low part of a gap or saddle separating basins
     *
     * @see <a href="http://www.geonames.org/ontology#U.SILU">#U.SILU</a>
     */
    public static final IRI U_SILU;

    /**
     * skråning
     * <p>
     * {@code http://www.geonames.org/ontology#U.SLPU}
     * <p>
     * the slope seaward from the shelf edge to the beginning of a
     * continental rise or the point where there is a general reduction in
     * slope
     *
     * @see <a href="http://www.geonames.org/ontology#U.SLPU">#U.SLPU</a>
     */
    public static final IRI U_SLPU;

    /**
     * seamounts
     * <p>
     * {@code http://www.geonames.org/ontology#U.SMSU}
     * <p>
     * elevations rising generally more than 1,000 meters and of limited
     * extent across the summit
     *
     * @see <a href="http://www.geonames.org/ontology#U.SMSU">#U.SMSU</a>
     */
    public static final IRI U_SMSU;

    /**
     * seamount
     * <p>
     * {@code http://www.geonames.org/ontology#U.SMU}
     * <p>
     * an elevation rising generally more than 1,000 meters and of limited
     * extent across the summit
     *
     * @see <a href="http://www.geonames.org/ontology#U.SMU">#U.SMU</a>
     */
    public static final IRI U_SMU;

    /**
     * spur
     * <p>
     * {@code http://www.geonames.org/ontology#U.SPRU}
     * <p>
     * a subordinate elevation, ridge, or rise projecting outward from a
     * larger feature
     *
     * @see <a href="http://www.geonames.org/ontology#U.SPRU">#U.SPRU</a>
     */
    public static final IRI U_SPRU;

    /**
     * terass
     * <p>
     * {@code http://www.geonames.org/ontology#U.TERU}
     * <p>
     * a relatively flat horizontal or gently inclined surface, sometimes
     * long and narrow, which is bounded by a steeper ascending slope on one
     * side and by a steep descending slope on the opposite side
     *
     * @see <a href="http://www.geonames.org/ontology#U.TERU">#U.TERU</a>
     */
    public static final IRI U_TERU;

    /**
     * guyoter
     * <p>
     * {@code http://www.geonames.org/ontology#U.TMSU}
     * <p>
     * seamounts having a comparatively smooth, flat top
     *
     * @see <a href="http://www.geonames.org/ontology#U.TMSU">#U.TMSU</a>
     */
    public static final IRI U_TMSU;

    /**
     * guyot
     * <p>
     * {@code http://www.geonames.org/ontology#U.TMTU}
     * <p>
     * a seamount having a comparatively smooth, flat top
     *
     * @see <a href="http://www.geonames.org/ontology#U.TMTU">#U.TMTU</a>
     */
    public static final IRI U_TMTU;

    /**
     * landtunga
     * <p>
     * {@code http://www.geonames.org/ontology#U.TNGU}
     * <p>
     * an elongate (tongue-like) extension of a flat sea floor into an
     * adjacent higher feature
     *
     * @see <a href="http://www.geonames.org/ontology#U.TNGU">#U.TNGU</a>
     */
    public static final IRI U_TNGU;

    /**
     * gjennomgang
     * <p>
     * {@code http://www.geonames.org/ontology#U.TRGU}
     * <p>
     * a long depression of the sea floor characteristically flat bottomed
     * and steep sided, and normally shallower than a trench
     *
     * @see <a href="http://www.geonames.org/ontology#U.TRGU">#U.TRGU</a>
     */
    public static final IRI U_TRGU;

    /**
     * dike
     * <p>
     * {@code http://www.geonames.org/ontology#U.TRNU}
     * <p>
     * a long, narrow, characteristically very deep and asymmetrical
     * depression of the sea floor, with relatively steep sides
     *
     * @see <a href="http://www.geonames.org/ontology#U.TRNU">#U.TRNU</a>
     */
    public static final IRI U_TRNU;

    /**
     * dal
     * <p>
     * {@code http://www.geonames.org/ontology#U.VALU}
     * <p>
     * a relatively shallow, wide depression, the bottom of which usually has
     * a continuous gradient
     *
     * @see <a href="http://www.geonames.org/ontology#U.VALU">#U.VALU</a>
     */
    public static final IRI U_VALU;

    /**
     * dalar
     * <p>
     * {@code http://www.geonames.org/ontology#U.VLSU}
     * <p>
     * a relatively shallow, wide depression, the bottom of which usually has
     * a continuous gradient
     *
     * @see <a href="http://www.geonames.org/ontology#U.VLSU">#U.VLSU</a>
     */
    public static final IRI U_VLSU;

    /**
     * {@code http://www.geonames.org/ontology#V}
     * <p>
     * forest, heath, ...
     *
     * @see <a href="http://www.geonames.org/ontology#V">#V</a>
     */
    public static final IRI V;

    /**
     * bush(es)
     * <p>
     * {@code http://www.geonames.org/ontology#V.BUSH}
     * <p>
     * a small clump of conspicuous bushes in an otherwise bare area
     *
     * @see <a href="http://www.geonames.org/ontology#V.BUSH">#V.BUSH</a>
     */
    public static final IRI V_BUSH;

    /**
     * cultivated area
     * <p>
     * {@code http://www.geonames.org/ontology#V.CULT}
     * <p>
     * an area under cultivation
     *
     * @see <a href="http://www.geonames.org/ontology#V.CULT">#V.CULT</a>
     */
    public static final IRI V_CULT;

    /**
     * forest(s)
     * <p>
     * {@code http://www.geonames.org/ontology#V.FRST}
     * <p>
     * an area dominated by tree vegetation
     *
     * @see <a href="http://www.geonames.org/ontology#V.FRST">#V.FRST</a>
     */
    public static final IRI V_FRST;

    /**
     * forsteinet skog
     * <p>
     * {@code http://www.geonames.org/ontology#V.FRSTF}
     * <p>
     * a forest fossilized by geologic processes and now exposed at the
     * earth&#39;s surface
     *
     * @see <a href="http://www.geonames.org/ontology#V.FRSTF">#V.FRSTF</a>
     */
    public static final IRI V_FRSTF;

    /**
     * grassland
     * <p>
     * {@code http://www.geonames.org/ontology#V.GRSLD}
     * <p>
     * an area dominated by grass vegetation
     *
     * @see <a href="http://www.geonames.org/ontology#V.GRSLD">#V.GRSLD</a>
     */
    public static final IRI V_GRSLD;

    /**
     * coconut grove
     * <p>
     * {@code http://www.geonames.org/ontology#V.GRVC}
     * <p>
     * a planting of coconut trees
     *
     * @see <a href="http://www.geonames.org/ontology#V.GRVC">#V.GRVC</a>
     */
    public static final IRI V_GRVC;

    /**
     * olive grove
     * <p>
     * {@code http://www.geonames.org/ontology#V.GRVO}
     * <p>
     * a planting of olive trees
     *
     * @see <a href="http://www.geonames.org/ontology#V.GRVO">#V.GRVO</a>
     */
    public static final IRI V_GRVO;

    /**
     * palm grove
     * <p>
     * {@code http://www.geonames.org/ontology#V.GRVP}
     * <p>
     * a planting of palm trees
     *
     * @see <a href="http://www.geonames.org/ontology#V.GRVP">#V.GRVP</a>
     */
    public static final IRI V_GRVP;

    /**
     * furulund
     * <p>
     * {@code http://www.geonames.org/ontology#V.GRVPN}
     * <p>
     * a planting of pine trees
     *
     * @see <a href="http://www.geonames.org/ontology#V.GRVPN">#V.GRVPN</a>
     */
    public static final IRI V_GRVPN;

    /**
     * heath
     * <p>
     * {@code http://www.geonames.org/ontology#V.HTH}
     * <p>
     * an upland moor or sandy area dominated by low shrubby vegetation
     * including heather
     *
     * @see <a href="http://www.geonames.org/ontology#V.HTH">#V.HTH</a>
     */
    public static final IRI V_HTH;

    /**
     * eng
     * <p>
     * {@code http://www.geonames.org/ontology#V.MDW}
     * <p>
     * a small, poorly drained area dominated by grassy vegetation
     *
     * @see <a href="http://www.geonames.org/ontology#V.MDW">#V.MDW</a>
     */
    public static final IRI V_MDW;

    /**
     * frukthage
     * <p>
     * {@code http://www.geonames.org/ontology#V.OCH}
     * <p>
     * a planting of fruit or nut trees
     *
     * @see <a href="http://www.geonames.org/ontology#V.OCH">#V.OCH</a>
     */
    public static final IRI V_OCH;

    /**
     * buskterräng
     * <p>
     * {@code http://www.geonames.org/ontology#V.SCRB}
     * <p>
     * an area of low trees, bushes, and shrubs stunted by some environmental
     * limitation
     *
     * @see <a href="http://www.geonames.org/ontology#V.SCRB">#V.SCRB</a>
     */
    public static final IRI V_SCRB;

    /**
     * tre
     * <p>
     * {@code http://www.geonames.org/ontology#V.TREE}
     * <p>
     * a conspicuous tree used as a landmark
     *
     * @see <a href="http://www.geonames.org/ontology#V.TREE">#V.TREE</a>
     */
    public static final IRI V_TREE;

    /**
     * tundra
     * <p>
     * {@code http://www.geonames.org/ontology#V.TUND}
     * <p>
     * a marshy, treeless, high latitude plain, dominated by mosses, lichens,
     * and low shrub vegetation under permafrost conditions
     *
     * @see <a href="http://www.geonames.org/ontology#V.TUND">#V.TUND</a>
     */
    public static final IRI V_TUND;

    /**
     * vineyard
     * <p>
     * {@code http://www.geonames.org/ontology#V.VIN}
     * <p>
     * a planting of grapevines
     *
     * @see <a href="http://www.geonames.org/ontology#V.VIN">#V.VIN</a>
     */
    public static final IRI V_VIN;

    /**
     * vineyards
     * <p>
     * {@code http://www.geonames.org/ontology#V.VINS}
     * <p>
     * plantings of grapevines
     *
     * @see <a href="http://www.geonames.org/ontology#V.VINS">#V.VINS</a>
     */
    public static final IRI V_VINS;

    /**
     * Wikipedia Article
     * <p>
     * {@code http://www.geonames.org/ontology#WikipediaArticle}
     * <p>
     * A Wikipedia article
     *
     * @see <a href="http://www.geonames.org/ontology#WikipediaArticle">#WikipediaArticle</a>
     */
    public static final IRI WikipediaArticle;

    /**
     * wikipedia article
     * <p>
     * {@code http://www.geonames.org/ontology#wikipediaArticle}
     * <p>
     * A Wikipedia article of which subject is the resource.
     *
     * @see <a href="http://www.geonames.org/ontology#wikipediaArticle">#wikipediaArticle</a>
     */
    public static final IRI wikipediaArticle;

    private static final Set<IRI> _VALUES;

    /**
     * Static initializer
     */
    static {
        ValueFactory vf = SimpleValueFactory.getInstance();

        NAMESPACE_IRI = vf.createIRI(NAMESPACE);

        /***********************
         * IRI Constant creation
         ***********************/
        A = vf.createIRI("http://www.geonames.org/ontology#A");
        A_ADM1 = vf.createIRI("http://www.geonames.org/ontology#A.ADM1");
        A_ADM1H = vf.createIRI("http://www.geonames.org/ontology#A.ADM1H");
        A_ADM2 = vf.createIRI("http://www.geonames.org/ontology#A.ADM2");
        A_ADM2H = vf.createIRI("http://www.geonames.org/ontology#A.ADM2H");
        A_ADM3 = vf.createIRI("http://www.geonames.org/ontology#A.ADM3");
        A_ADM3H = vf.createIRI("http://www.geonames.org/ontology#A.ADM3H");
        A_ADM4 = vf.createIRI("http://www.geonames.org/ontology#A.ADM4");
        A_ADM4H = vf.createIRI("http://www.geonames.org/ontology#A.ADM4H");
        A_ADM5 = vf.createIRI("http://www.geonames.org/ontology#A.ADM5");
        A_ADMD = vf.createIRI("http://www.geonames.org/ontology#A.ADMD");
        A_ADMH = vf.createIRI("http://www.geonames.org/ontology#A.ADMH");
        A_LTER = vf.createIRI("http://www.geonames.org/ontology#A.LTER");
        A_PCL = vf.createIRI("http://www.geonames.org/ontology#A.PCL");
        A_PCLD = vf.createIRI("http://www.geonames.org/ontology#A.PCLD");
        A_PCLF = vf.createIRI("http://www.geonames.org/ontology#A.PCLF");
        A_PCLH = vf.createIRI("http://www.geonames.org/ontology#A.PCLH");
        A_PCLI = vf.createIRI("http://www.geonames.org/ontology#A.PCLI");
        A_PCLIX = vf.createIRI("http://www.geonames.org/ontology#A.PCLIX");
        A_PCLS = vf.createIRI("http://www.geonames.org/ontology#A.PCLS");
        A_PPCLH = vf.createIRI("http://www.geonames.org/ontology#A.PPCLH");
        A_PPLH = vf.createIRI("http://www.geonames.org/ontology#A.PPLH");
        A_PRSH = vf.createIRI("http://www.geonames.org/ontology#A.PRSH");
        A_TERR = vf.createIRI("http://www.geonames.org/ontology#A.TERR");
        A_ZN = vf.createIRI("http://www.geonames.org/ontology#A.ZN");
        A_ZNB = vf.createIRI("http://www.geonames.org/ontology#A.ZNB");
        alternateName = vf.createIRI("http://www.geonames.org/ontology#alternateName");
        childrenFeatures = vf.createIRI("http://www.geonames.org/ontology#childrenFeatures");
        Class = vf.createIRI("http://www.geonames.org/ontology#Class");
        Code = vf.createIRI("http://www.geonames.org/ontology#Code");
        colloquialName = vf.createIRI("http://www.geonames.org/ontology#colloquialName");
        countryCode = vf.createIRI("http://www.geonames.org/ontology#countryCode");
        Feature = vf.createIRI("http://www.geonames.org/ontology#Feature");
        featureClass = vf.createIRI("http://www.geonames.org/ontology#featureClass");
        featureCode = vf.createIRI("http://www.geonames.org/ontology#featureCode");
        GeonamesFeature = vf.createIRI("http://www.geonames.org/ontology#GeonamesFeature");
        geonamesID = vf.createIRI("http://www.geonames.org/ontology#geonamesID");
        H = vf.createIRI("http://www.geonames.org/ontology#H");
        H_AIRS = vf.createIRI("http://www.geonames.org/ontology#H.AIRS");
        H_ANCH = vf.createIRI("http://www.geonames.org/ontology#H.ANCH");
        H_BAY = vf.createIRI("http://www.geonames.org/ontology#H.BAY");
        H_BAYS = vf.createIRI("http://www.geonames.org/ontology#H.BAYS");
        H_BGHT = vf.createIRI("http://www.geonames.org/ontology#H.BGHT");
        H_BNK = vf.createIRI("http://www.geonames.org/ontology#H.BNK");
        H_BNKR = vf.createIRI("http://www.geonames.org/ontology#H.BNKR");
        H_BNKX = vf.createIRI("http://www.geonames.org/ontology#H.BNKX");
        H_BOG = vf.createIRI("http://www.geonames.org/ontology#H.BOG");
        H_CAPG = vf.createIRI("http://www.geonames.org/ontology#H.CAPG");
        H_CHN = vf.createIRI("http://www.geonames.org/ontology#H.CHN");
        H_CHNL = vf.createIRI("http://www.geonames.org/ontology#H.CHNL");
        H_CHNM = vf.createIRI("http://www.geonames.org/ontology#H.CHNM");
        H_CHNN = vf.createIRI("http://www.geonames.org/ontology#H.CHNN");
        H_CNFL = vf.createIRI("http://www.geonames.org/ontology#H.CNFL");
        H_CNL = vf.createIRI("http://www.geonames.org/ontology#H.CNL");
        H_CNLA = vf.createIRI("http://www.geonames.org/ontology#H.CNLA");
        H_CNLB = vf.createIRI("http://www.geonames.org/ontology#H.CNLB");
        H_CNLD = vf.createIRI("http://www.geonames.org/ontology#H.CNLD");
        H_CNLI = vf.createIRI("http://www.geonames.org/ontology#H.CNLI");
        H_CNLN = vf.createIRI("http://www.geonames.org/ontology#H.CNLN");
        H_CNLQ = vf.createIRI("http://www.geonames.org/ontology#H.CNLQ");
        H_CNLSB = vf.createIRI("http://www.geonames.org/ontology#H.CNLSB");
        H_CNLX = vf.createIRI("http://www.geonames.org/ontology#H.CNLX");
        H_COVE = vf.createIRI("http://www.geonames.org/ontology#H.COVE");
        H_CRKT = vf.createIRI("http://www.geonames.org/ontology#H.CRKT");
        H_CRNT = vf.createIRI("http://www.geonames.org/ontology#H.CRNT");
        H_CUTF = vf.createIRI("http://www.geonames.org/ontology#H.CUTF");
        H_DCK = vf.createIRI("http://www.geonames.org/ontology#H.DCK");
        H_DCKB = vf.createIRI("http://www.geonames.org/ontology#H.DCKB");
        H_DOMG = vf.createIRI("http://www.geonames.org/ontology#H.DOMG");
        H_DPRG = vf.createIRI("http://www.geonames.org/ontology#H.DPRG");
        H_DTCH = vf.createIRI("http://www.geonames.org/ontology#H.DTCH");
        H_DTCHD = vf.createIRI("http://www.geonames.org/ontology#H.DTCHD");
        H_DTCHI = vf.createIRI("http://www.geonames.org/ontology#H.DTCHI");
        H_DTCHM = vf.createIRI("http://www.geonames.org/ontology#H.DTCHM");
        H_ESTY = vf.createIRI("http://www.geonames.org/ontology#H.ESTY");
        H_FISH = vf.createIRI("http://www.geonames.org/ontology#H.FISH");
        H_FJD = vf.createIRI("http://www.geonames.org/ontology#H.FJD");
        H_FJDS = vf.createIRI("http://www.geonames.org/ontology#H.FJDS");
        H_FLLS = vf.createIRI("http://www.geonames.org/ontology#H.FLLS");
        H_FLLSX = vf.createIRI("http://www.geonames.org/ontology#H.FLLSX");
        H_FLTM = vf.createIRI("http://www.geonames.org/ontology#H.FLTM");
        H_FLTT = vf.createIRI("http://www.geonames.org/ontology#H.FLTT");
        H_GLCR = vf.createIRI("http://www.geonames.org/ontology#H.GLCR");
        H_GULF = vf.createIRI("http://www.geonames.org/ontology#H.GULF");
        H_GYSR = vf.createIRI("http://www.geonames.org/ontology#H.GYSR");
        H_HBR = vf.createIRI("http://www.geonames.org/ontology#H.HBR");
        H_HBRX = vf.createIRI("http://www.geonames.org/ontology#H.HBRX");
        H_INLT = vf.createIRI("http://www.geonames.org/ontology#H.INLT");
        H_INLTQ = vf.createIRI("http://www.geonames.org/ontology#H.INLTQ");
        H_LBED = vf.createIRI("http://www.geonames.org/ontology#H.LBED");
        H_LGN = vf.createIRI("http://www.geonames.org/ontology#H.LGN");
        H_LGNS = vf.createIRI("http://www.geonames.org/ontology#H.LGNS");
        H_LGNX = vf.createIRI("http://www.geonames.org/ontology#H.LGNX");
        H_LK = vf.createIRI("http://www.geonames.org/ontology#H.LK");
        H_LKC = vf.createIRI("http://www.geonames.org/ontology#H.LKC");
        H_LKI = vf.createIRI("http://www.geonames.org/ontology#H.LKI");
        H_LKN = vf.createIRI("http://www.geonames.org/ontology#H.LKN");
        H_LKNI = vf.createIRI("http://www.geonames.org/ontology#H.LKNI");
        H_LKO = vf.createIRI("http://www.geonames.org/ontology#H.LKO");
        H_LKOI = vf.createIRI("http://www.geonames.org/ontology#H.LKOI");
        H_LKS = vf.createIRI("http://www.geonames.org/ontology#H.LKS");
        H_LKSB = vf.createIRI("http://www.geonames.org/ontology#H.LKSB");
        H_LKSC = vf.createIRI("http://www.geonames.org/ontology#H.LKSC");
        H_LKSI = vf.createIRI("http://www.geonames.org/ontology#H.LKSI");
        H_LKSN = vf.createIRI("http://www.geonames.org/ontology#H.LKSN");
        H_LKSNI = vf.createIRI("http://www.geonames.org/ontology#H.LKSNI");
        H_LKX = vf.createIRI("http://www.geonames.org/ontology#H.LKX");
        H_MFGN = vf.createIRI("http://www.geonames.org/ontology#H.MFGN");
        H_MGV = vf.createIRI("http://www.geonames.org/ontology#H.MGV");
        H_MOOR = vf.createIRI("http://www.geonames.org/ontology#H.MOOR");
        H_MRSH = vf.createIRI("http://www.geonames.org/ontology#H.MRSH");
        H_MRSHN = vf.createIRI("http://www.geonames.org/ontology#H.MRSHN");
        H_NRWS = vf.createIRI("http://www.geonames.org/ontology#H.NRWS");
        H_OCN = vf.createIRI("http://www.geonames.org/ontology#H.OCN");
        H_OVF = vf.createIRI("http://www.geonames.org/ontology#H.OVF");
        H_PND = vf.createIRI("http://www.geonames.org/ontology#H.PND");
        H_PNDI = vf.createIRI("http://www.geonames.org/ontology#H.PNDI");
        H_PNDN = vf.createIRI("http://www.geonames.org/ontology#H.PNDN");
        H_PNDNI = vf.createIRI("http://www.geonames.org/ontology#H.PNDNI");
        H_PNDS = vf.createIRI("http://www.geonames.org/ontology#H.PNDS");
        H_PNDSF = vf.createIRI("http://www.geonames.org/ontology#H.PNDSF");
        H_PNDSI = vf.createIRI("http://www.geonames.org/ontology#H.PNDSI");
        H_PNDSN = vf.createIRI("http://www.geonames.org/ontology#H.PNDSN");
        H_POOL = vf.createIRI("http://www.geonames.org/ontology#H.POOL");
        H_POOLI = vf.createIRI("http://www.geonames.org/ontology#H.POOLI");
        H_RCH = vf.createIRI("http://www.geonames.org/ontology#H.RCH");
        H_RDGG = vf.createIRI("http://www.geonames.org/ontology#H.RDGG");
        H_RDST = vf.createIRI("http://www.geonames.org/ontology#H.RDST");
        H_RF = vf.createIRI("http://www.geonames.org/ontology#H.RF");
        H_RFC = vf.createIRI("http://www.geonames.org/ontology#H.RFC");
        H_RFX = vf.createIRI("http://www.geonames.org/ontology#H.RFX");
        H_RPDS = vf.createIRI("http://www.geonames.org/ontology#H.RPDS");
        H_RSV = vf.createIRI("http://www.geonames.org/ontology#H.RSV");
        H_RSVI = vf.createIRI("http://www.geonames.org/ontology#H.RSVI");
        H_RSVT = vf.createIRI("http://www.geonames.org/ontology#H.RSVT");
        H_RVN = vf.createIRI("http://www.geonames.org/ontology#H.RVN");
        H_SBKH = vf.createIRI("http://www.geonames.org/ontology#H.SBKH");
        H_SD = vf.createIRI("http://www.geonames.org/ontology#H.SD");
        H_SEA = vf.createIRI("http://www.geonames.org/ontology#H.SEA");
        H_SHOL = vf.createIRI("http://www.geonames.org/ontology#H.SHOL");
        H_SILL = vf.createIRI("http://www.geonames.org/ontology#H.SILL");
        H_SPNG = vf.createIRI("http://www.geonames.org/ontology#H.SPNG");
        H_SPNS = vf.createIRI("http://www.geonames.org/ontology#H.SPNS");
        H_SPNT = vf.createIRI("http://www.geonames.org/ontology#H.SPNT");
        H_STM = vf.createIRI("http://www.geonames.org/ontology#H.STM");
        H_STMA = vf.createIRI("http://www.geonames.org/ontology#H.STMA");
        H_STMB = vf.createIRI("http://www.geonames.org/ontology#H.STMB");
        H_STMC = vf.createIRI("http://www.geonames.org/ontology#H.STMC");
        H_STMD = vf.createIRI("http://www.geonames.org/ontology#H.STMD");
        H_STMH = vf.createIRI("http://www.geonames.org/ontology#H.STMH");
        H_STMI = vf.createIRI("http://www.geonames.org/ontology#H.STMI");
        H_STMIX = vf.createIRI("http://www.geonames.org/ontology#H.STMIX");
        H_STMM = vf.createIRI("http://www.geonames.org/ontology#H.STMM");
        H_STMQ = vf.createIRI("http://www.geonames.org/ontology#H.STMQ");
        H_STMS = vf.createIRI("http://www.geonames.org/ontology#H.STMS");
        H_STMSB = vf.createIRI("http://www.geonames.org/ontology#H.STMSB");
        H_STMX = vf.createIRI("http://www.geonames.org/ontology#H.STMX");
        H_STRT = vf.createIRI("http://www.geonames.org/ontology#H.STRT");
        H_SWMP = vf.createIRI("http://www.geonames.org/ontology#H.SWMP");
        H_SYSI = vf.createIRI("http://www.geonames.org/ontology#H.SYSI");
        H_TNLC = vf.createIRI("http://www.geonames.org/ontology#H.TNLC");
        H_WAD = vf.createIRI("http://www.geonames.org/ontology#H.WAD");
        H_WADB = vf.createIRI("http://www.geonames.org/ontology#H.WADB");
        H_WADJ = vf.createIRI("http://www.geonames.org/ontology#H.WADJ");
        H_WADM = vf.createIRI("http://www.geonames.org/ontology#H.WADM");
        H_WADS = vf.createIRI("http://www.geonames.org/ontology#H.WADS");
        H_WADX = vf.createIRI("http://www.geonames.org/ontology#H.WADX");
        H_WHRL = vf.createIRI("http://www.geonames.org/ontology#H.WHRL");
        H_WLL = vf.createIRI("http://www.geonames.org/ontology#H.WLL");
        H_WLLQ = vf.createIRI("http://www.geonames.org/ontology#H.WLLQ");
        H_WLLS = vf.createIRI("http://www.geonames.org/ontology#H.WLLS");
        H_WTLD = vf.createIRI("http://www.geonames.org/ontology#H.WTLD");
        H_WTLDI = vf.createIRI("http://www.geonames.org/ontology#H.WTLDI");
        H_WTRC = vf.createIRI("http://www.geonames.org/ontology#H.WTRC");
        H_WTRH = vf.createIRI("http://www.geonames.org/ontology#H.WTRH");
        historicalName = vf.createIRI("http://www.geonames.org/ontology#historicalName");
        L = vf.createIRI("http://www.geonames.org/ontology#L");
        L_AGRC = vf.createIRI("http://www.geonames.org/ontology#L.AGRC");
        L_AMUS = vf.createIRI("http://www.geonames.org/ontology#L.AMUS");
        L_AREA = vf.createIRI("http://www.geonames.org/ontology#L.AREA");
        L_BSND = vf.createIRI("http://www.geonames.org/ontology#L.BSND");
        L_BSNP = vf.createIRI("http://www.geonames.org/ontology#L.BSNP");
        L_BTL = vf.createIRI("http://www.geonames.org/ontology#L.BTL");
        L_CLG = vf.createIRI("http://www.geonames.org/ontology#L.CLG");
        L_CMN = vf.createIRI("http://www.geonames.org/ontology#L.CMN");
        L_CNS = vf.createIRI("http://www.geonames.org/ontology#L.CNS");
        L_COLF = vf.createIRI("http://www.geonames.org/ontology#L.COLF");
        L_CONT = vf.createIRI("http://www.geonames.org/ontology#L.CONT");
        L_CST = vf.createIRI("http://www.geonames.org/ontology#L.CST");
        L_CTRB = vf.createIRI("http://www.geonames.org/ontology#L.CTRB");
        L_DEVH = vf.createIRI("http://www.geonames.org/ontology#L.DEVH");
        L_FLD = vf.createIRI("http://www.geonames.org/ontology#L.FLD");
        L_FLDI = vf.createIRI("http://www.geonames.org/ontology#L.FLDI");
        L_GASF = vf.createIRI("http://www.geonames.org/ontology#L.GASF");
        L_GRAZ = vf.createIRI("http://www.geonames.org/ontology#L.GRAZ");
        L_GVL = vf.createIRI("http://www.geonames.org/ontology#L.GVL");
        L_INDS = vf.createIRI("http://www.geonames.org/ontology#L.INDS");
        L_LAND = vf.createIRI("http://www.geonames.org/ontology#L.LAND");
        L_LCTY = vf.createIRI("http://www.geonames.org/ontology#L.LCTY");
        L_MILB = vf.createIRI("http://www.geonames.org/ontology#L.MILB");
        L_MNA = vf.createIRI("http://www.geonames.org/ontology#L.MNA");
        L_MVA = vf.createIRI("http://www.geonames.org/ontology#L.MVA");
        L_NVB = vf.createIRI("http://www.geonames.org/ontology#L.NVB");
        L_OAS = vf.createIRI("http://www.geonames.org/ontology#L.OAS");
        L_OILF = vf.createIRI("http://www.geonames.org/ontology#L.OILF");
        L_PEAT = vf.createIRI("http://www.geonames.org/ontology#L.PEAT");
        L_PRK = vf.createIRI("http://www.geonames.org/ontology#L.PRK");
        L_PRT = vf.createIRI("http://www.geonames.org/ontology#L.PRT");
        L_QCKS = vf.createIRI("http://www.geonames.org/ontology#L.QCKS");
        L_REP = vf.createIRI("http://www.geonames.org/ontology#L.REP");
        L_RES = vf.createIRI("http://www.geonames.org/ontology#L.RES");
        L_RESA = vf.createIRI("http://www.geonames.org/ontology#L.RESA");
        L_RESF = vf.createIRI("http://www.geonames.org/ontology#L.RESF");
        L_RESH = vf.createIRI("http://www.geonames.org/ontology#L.RESH");
        L_RESN = vf.createIRI("http://www.geonames.org/ontology#L.RESN");
        L_RESP = vf.createIRI("http://www.geonames.org/ontology#L.RESP");
        L_RESV = vf.createIRI("http://www.geonames.org/ontology#L.RESV");
        L_RESW = vf.createIRI("http://www.geonames.org/ontology#L.RESW");
        L_RGN = vf.createIRI("http://www.geonames.org/ontology#L.RGN");
        L_RGNE = vf.createIRI("http://www.geonames.org/ontology#L.RGNE");
        L_RGNH = vf.createIRI("http://www.geonames.org/ontology#L.RGNH");
        L_RGNL = vf.createIRI("http://www.geonames.org/ontology#L.RGNL");
        L_RNGA = vf.createIRI("http://www.geonames.org/ontology#L.RNGA");
        L_SALT = vf.createIRI("http://www.geonames.org/ontology#L.SALT");
        L_SNOW = vf.createIRI("http://www.geonames.org/ontology#L.SNOW");
        L_TRB = vf.createIRI("http://www.geonames.org/ontology#L.TRB");
        L_ZZZZZ = vf.createIRI("http://www.geonames.org/ontology#L.ZZZZZ");
        locatedIn = vf.createIRI("http://www.geonames.org/ontology#locatedIn");
        locationMap = vf.createIRI("http://www.geonames.org/ontology#locationMap");
        Map = vf.createIRI("http://www.geonames.org/ontology#Map");
        Marc_Wick = vf.createIRI("http://www.geonames.org/ontology#Marc-Wick");
        name = vf.createIRI("http://www.geonames.org/ontology#name");
        nearby = vf.createIRI("http://www.geonames.org/ontology#nearby");
        nearbyFeatures = vf.createIRI("http://www.geonames.org/ontology#nearbyFeatures");
        neighbour = vf.createIRI("http://www.geonames.org/ontology#neighbour");
        neighbouringFeatures = vf.createIRI("http://www.geonames.org/ontology#neighbouringFeatures");
        officialName = vf.createIRI("http://www.geonames.org/ontology#officialName");
        P = vf.createIRI("http://www.geonames.org/ontology#P");
        P_PPL = vf.createIRI("http://www.geonames.org/ontology#P.PPL");
        P_PPLA = vf.createIRI("http://www.geonames.org/ontology#P.PPLA");
        P_PPLA2 = vf.createIRI("http://www.geonames.org/ontology#P.PPLA2");
        P_PPLA3 = vf.createIRI("http://www.geonames.org/ontology#P.PPLA3");
        P_PPLA4 = vf.createIRI("http://www.geonames.org/ontology#P.PPLA4");
        P_PPLC = vf.createIRI("http://www.geonames.org/ontology#P.PPLC");
        P_PPLF = vf.createIRI("http://www.geonames.org/ontology#P.PPLF");
        P_PPLG = vf.createIRI("http://www.geonames.org/ontology#P.PPLG");
        P_PPLL = vf.createIRI("http://www.geonames.org/ontology#P.PPLL");
        P_PPLQ = vf.createIRI("http://www.geonames.org/ontology#P.PPLQ");
        P_PPLR = vf.createIRI("http://www.geonames.org/ontology#P.PPLR");
        P_PPLS = vf.createIRI("http://www.geonames.org/ontology#P.PPLS");
        P_PPLW = vf.createIRI("http://www.geonames.org/ontology#P.PPLW");
        P_PPLX = vf.createIRI("http://www.geonames.org/ontology#P.PPLX");
        P_STLMT = vf.createIRI("http://www.geonames.org/ontology#P.STLMT");
        parentADM1 = vf.createIRI("http://www.geonames.org/ontology#parentADM1");
        parentADM2 = vf.createIRI("http://www.geonames.org/ontology#parentADM2");
        parentADM3 = vf.createIRI("http://www.geonames.org/ontology#parentADM3");
        parentADM4 = vf.createIRI("http://www.geonames.org/ontology#parentADM4");
        parentCountry = vf.createIRI("http://www.geonames.org/ontology#parentCountry");
        parentFeature = vf.createIRI("http://www.geonames.org/ontology#parentFeature");
        population = vf.createIRI("http://www.geonames.org/ontology#population");
        postalCode = vf.createIRI("http://www.geonames.org/ontology#postalCode");
        R = vf.createIRI("http://www.geonames.org/ontology#R");
        R_CSWY = vf.createIRI("http://www.geonames.org/ontology#R.CSWY");
        R_CSWYQ = vf.createIRI("http://www.geonames.org/ontology#R.CSWYQ");
        R_OILP = vf.createIRI("http://www.geonames.org/ontology#R.OILP");
        R_PRMN = vf.createIRI("http://www.geonames.org/ontology#R.PRMN");
        R_PTGE = vf.createIRI("http://www.geonames.org/ontology#R.PTGE");
        R_RD = vf.createIRI("http://www.geonames.org/ontology#R.RD");
        R_RDA = vf.createIRI("http://www.geonames.org/ontology#R.RDA");
        R_RDB = vf.createIRI("http://www.geonames.org/ontology#R.RDB");
        R_RDCUT = vf.createIRI("http://www.geonames.org/ontology#R.RDCUT");
        R_RDJCT = vf.createIRI("http://www.geonames.org/ontology#R.RDJCT");
        R_RJCT = vf.createIRI("http://www.geonames.org/ontology#R.RJCT");
        R_RR = vf.createIRI("http://www.geonames.org/ontology#R.RR");
        R_RRQ = vf.createIRI("http://www.geonames.org/ontology#R.RRQ");
        R_RTE = vf.createIRI("http://www.geonames.org/ontology#R.RTE");
        R_RYD = vf.createIRI("http://www.geonames.org/ontology#R.RYD");
        R_ST = vf.createIRI("http://www.geonames.org/ontology#R.ST");
        R_STKR = vf.createIRI("http://www.geonames.org/ontology#R.STKR");
        R_TNL = vf.createIRI("http://www.geonames.org/ontology#R.TNL");
        R_TNLN = vf.createIRI("http://www.geonames.org/ontology#R.TNLN");
        R_TNLRD = vf.createIRI("http://www.geonames.org/ontology#R.TNLRD");
        R_TNLRR = vf.createIRI("http://www.geonames.org/ontology#R.TNLRR");
        R_TNLS = vf.createIRI("http://www.geonames.org/ontology#R.TNLS");
        R_TRL = vf.createIRI("http://www.geonames.org/ontology#R.TRL");
        RDFData = vf.createIRI("http://www.geonames.org/ontology#RDFData");
        S = vf.createIRI("http://www.geonames.org/ontology#S");
        S_ADMF = vf.createIRI("http://www.geonames.org/ontology#S.ADMF");
        S_AGRF = vf.createIRI("http://www.geonames.org/ontology#S.AGRF");
        S_AIRB = vf.createIRI("http://www.geonames.org/ontology#S.AIRB");
        S_AIRF = vf.createIRI("http://www.geonames.org/ontology#S.AIRF");
        S_AIRH = vf.createIRI("http://www.geonames.org/ontology#S.AIRH");
        S_AIRP = vf.createIRI("http://www.geonames.org/ontology#S.AIRP");
        S_AIRQ = vf.createIRI("http://www.geonames.org/ontology#S.AIRQ");
        S_AMTH = vf.createIRI("http://www.geonames.org/ontology#S.AMTH");
        S_ANS = vf.createIRI("http://www.geonames.org/ontology#S.ANS");
        S_AQC = vf.createIRI("http://www.geonames.org/ontology#S.AQC");
        S_ARCH = vf.createIRI("http://www.geonames.org/ontology#S.ARCH");
        S_ASTR = vf.createIRI("http://www.geonames.org/ontology#S.ASTR");
        S_ASYL = vf.createIRI("http://www.geonames.org/ontology#S.ASYL");
        S_ATHF = vf.createIRI("http://www.geonames.org/ontology#S.ATHF");
        S_ATM = vf.createIRI("http://www.geonames.org/ontology#S.ATM");
        S_BANK = vf.createIRI("http://www.geonames.org/ontology#S.BANK");
        S_BCN = vf.createIRI("http://www.geonames.org/ontology#S.BCN");
        S_BDG = vf.createIRI("http://www.geonames.org/ontology#S.BDG");
        S_BDGQ = vf.createIRI("http://www.geonames.org/ontology#S.BDGQ");
        S_BLDG = vf.createIRI("http://www.geonames.org/ontology#S.BLDG");
        S_BLDO = vf.createIRI("http://www.geonames.org/ontology#S.BLDO");
        S_BP = vf.createIRI("http://www.geonames.org/ontology#S.BP");
        S_BRKS = vf.createIRI("http://www.geonames.org/ontology#S.BRKS");
        S_BRKW = vf.createIRI("http://www.geonames.org/ontology#S.BRKW");
        S_BSTN = vf.createIRI("http://www.geonames.org/ontology#S.BSTN");
        S_BTYD = vf.createIRI("http://www.geonames.org/ontology#S.BTYD");
        S_BUR = vf.createIRI("http://www.geonames.org/ontology#S.BUR");
        S_BUSTN = vf.createIRI("http://www.geonames.org/ontology#S.BUSTN");
        S_BUSTP = vf.createIRI("http://www.geonames.org/ontology#S.BUSTP");
        S_CARN = vf.createIRI("http://www.geonames.org/ontology#S.CARN");
        S_CAVE = vf.createIRI("http://www.geonames.org/ontology#S.CAVE");
        S_CCL = vf.createIRI("http://www.geonames.org/ontology#S.CCL");
        S_CH = vf.createIRI("http://www.geonames.org/ontology#S.CH");
        S_CMP = vf.createIRI("http://www.geonames.org/ontology#S.CMP");
        S_CMPL = vf.createIRI("http://www.geonames.org/ontology#S.CMPL");
        S_CMPLA = vf.createIRI("http://www.geonames.org/ontology#S.CMPLA");
        S_CMPMN = vf.createIRI("http://www.geonames.org/ontology#S.CMPMN");
        S_CMPO = vf.createIRI("http://www.geonames.org/ontology#S.CMPO");
        S_CMPQ = vf.createIRI("http://www.geonames.org/ontology#S.CMPQ");
        S_CMPRF = vf.createIRI("http://www.geonames.org/ontology#S.CMPRF");
        S_CMTY = vf.createIRI("http://www.geonames.org/ontology#S.CMTY");
        S_COMC = vf.createIRI("http://www.geonames.org/ontology#S.COMC");
        S_CRRL = vf.createIRI("http://www.geonames.org/ontology#S.CRRL");
        S_CSNO = vf.createIRI("http://www.geonames.org/ontology#S.CSNO");
        S_CSTL = vf.createIRI("http://www.geonames.org/ontology#S.CSTL");
        S_CSTM = vf.createIRI("http://www.geonames.org/ontology#S.CSTM");
        S_CTHSE = vf.createIRI("http://www.geonames.org/ontology#S.CTHSE");
        S_CTRA = vf.createIRI("http://www.geonames.org/ontology#S.CTRA");
        S_CTRCM = vf.createIRI("http://www.geonames.org/ontology#S.CTRCM");
        S_CTRF = vf.createIRI("http://www.geonames.org/ontology#S.CTRF");
        S_CTRM = vf.createIRI("http://www.geonames.org/ontology#S.CTRM");
        S_CTRR = vf.createIRI("http://www.geonames.org/ontology#S.CTRR");
        S_CTRS = vf.createIRI("http://www.geonames.org/ontology#S.CTRS");
        S_CVNT = vf.createIRI("http://www.geonames.org/ontology#S.CVNT");
        S_DAM = vf.createIRI("http://www.geonames.org/ontology#S.DAM");
        S_DAMQ = vf.createIRI("http://www.geonames.org/ontology#S.DAMQ");
        S_DAMSB = vf.createIRI("http://www.geonames.org/ontology#S.DAMSB");
        S_DARY = vf.createIRI("http://www.geonames.org/ontology#S.DARY");
        S_DCKD = vf.createIRI("http://www.geonames.org/ontology#S.DCKD");
        S_DCKY = vf.createIRI("http://www.geonames.org/ontology#S.DCKY");
        S_DIKE = vf.createIRI("http://www.geonames.org/ontology#S.DIKE");
        S_DIP = vf.createIRI("http://www.geonames.org/ontology#S.DIP");
        S_DPOF = vf.createIRI("http://www.geonames.org/ontology#S.DPOF");
        S_EST = vf.createIRI("http://www.geonames.org/ontology#S.EST");
        S_ESTB = vf.createIRI("http://www.geonames.org/ontology#S.ESTB");
        S_ESTC = vf.createIRI("http://www.geonames.org/ontology#S.ESTC");
        S_ESTO = vf.createIRI("http://www.geonames.org/ontology#S.ESTO");
        S_ESTR = vf.createIRI("http://www.geonames.org/ontology#S.ESTR");
        S_ESTSG = vf.createIRI("http://www.geonames.org/ontology#S.ESTSG");
        S_ESTSL = vf.createIRI("http://www.geonames.org/ontology#S.ESTSL");
        S_ESTT = vf.createIRI("http://www.geonames.org/ontology#S.ESTT");
        S_ESTX = vf.createIRI("http://www.geonames.org/ontology#S.ESTX");
        S_FCL = vf.createIRI("http://www.geonames.org/ontology#S.FCL");
        S_FNDY = vf.createIRI("http://www.geonames.org/ontology#S.FNDY");
        S_FRM = vf.createIRI("http://www.geonames.org/ontology#S.FRM");
        S_FRMQ = vf.createIRI("http://www.geonames.org/ontology#S.FRMQ");
        S_FRMS = vf.createIRI("http://www.geonames.org/ontology#S.FRMS");
        S_FRMT = vf.createIRI("http://www.geonames.org/ontology#S.FRMT");
        S_FT = vf.createIRI("http://www.geonames.org/ontology#S.FT");
        S_FY = vf.createIRI("http://www.geonames.org/ontology#S.FY");
        S_GATE = vf.createIRI("http://www.geonames.org/ontology#S.GATE");
        S_GDN = vf.createIRI("http://www.geonames.org/ontology#S.GDN");
        S_GHAT = vf.createIRI("http://www.geonames.org/ontology#S.GHAT");
        S_GHSE = vf.createIRI("http://www.geonames.org/ontology#S.GHSE");
        S_GOSP = vf.createIRI("http://www.geonames.org/ontology#S.GOSP");
        S_GOVL = vf.createIRI("http://www.geonames.org/ontology#S.GOVL");
        S_GRVE = vf.createIRI("http://www.geonames.org/ontology#S.GRVE");
        S_HERM = vf.createIRI("http://www.geonames.org/ontology#S.HERM");
        S_HLT = vf.createIRI("http://www.geonames.org/ontology#S.HLT");
        S_HMSD = vf.createIRI("http://www.geonames.org/ontology#S.HMSD");
        S_HSE = vf.createIRI("http://www.geonames.org/ontology#S.HSE");
        S_HSEC = vf.createIRI("http://www.geonames.org/ontology#S.HSEC");
        S_HSP = vf.createIRI("http://www.geonames.org/ontology#S.HSP");
        S_HSPC = vf.createIRI("http://www.geonames.org/ontology#S.HSPC");
        S_HSPD = vf.createIRI("http://www.geonames.org/ontology#S.HSPD");
        S_HSPL = vf.createIRI("http://www.geonames.org/ontology#S.HSPL");
        S_HSTS = vf.createIRI("http://www.geonames.org/ontology#S.HSTS");
        S_HTL = vf.createIRI("http://www.geonames.org/ontology#S.HTL");
        S_HUT = vf.createIRI("http://www.geonames.org/ontology#S.HUT");
        S_HUTS = vf.createIRI("http://www.geonames.org/ontology#S.HUTS");
        S_INSM = vf.createIRI("http://www.geonames.org/ontology#S.INSM");
        S_ITTR = vf.createIRI("http://www.geonames.org/ontology#S.ITTR");
        S_JTY = vf.createIRI("http://www.geonames.org/ontology#S.JTY");
        S_LDNG = vf.createIRI("http://www.geonames.org/ontology#S.LDNG");
        S_LEPC = vf.createIRI("http://www.geonames.org/ontology#S.LEPC");
        S_LIBR = vf.createIRI("http://www.geonames.org/ontology#S.LIBR");
        S_LNDF = vf.createIRI("http://www.geonames.org/ontology#S.LNDF");
        S_LOCK = vf.createIRI("http://www.geonames.org/ontology#S.LOCK");
        S_LTHSE = vf.createIRI("http://www.geonames.org/ontology#S.LTHSE");
        S_MALL = vf.createIRI("http://www.geonames.org/ontology#S.MALL");
        S_MAR = vf.createIRI("http://www.geonames.org/ontology#S.MAR");
        S_MFG = vf.createIRI("http://www.geonames.org/ontology#S.MFG");
        S_MFGB = vf.createIRI("http://www.geonames.org/ontology#S.MFGB");
        S_MFGC = vf.createIRI("http://www.geonames.org/ontology#S.MFGC");
        S_MFGCU = vf.createIRI("http://www.geonames.org/ontology#S.MFGCU");
        S_MFGLM = vf.createIRI("http://www.geonames.org/ontology#S.MFGLM");
        S_MFGM = vf.createIRI("http://www.geonames.org/ontology#S.MFGM");
        S_MFGPH = vf.createIRI("http://www.geonames.org/ontology#S.MFGPH");
        S_MFGQ = vf.createIRI("http://www.geonames.org/ontology#S.MFGQ");
        S_MFGSG = vf.createIRI("http://www.geonames.org/ontology#S.MFGSG");
        S_MKT = vf.createIRI("http://www.geonames.org/ontology#S.MKT");
        S_ML = vf.createIRI("http://www.geonames.org/ontology#S.ML");
        S_MLM = vf.createIRI("http://www.geonames.org/ontology#S.MLM");
        S_MLO = vf.createIRI("http://www.geonames.org/ontology#S.MLO");
        S_MLSG = vf.createIRI("http://www.geonames.org/ontology#S.MLSG");
        S_MLSGQ = vf.createIRI("http://www.geonames.org/ontology#S.MLSGQ");
        S_MLSW = vf.createIRI("http://www.geonames.org/ontology#S.MLSW");
        S_MLWND = vf.createIRI("http://www.geonames.org/ontology#S.MLWND");
        S_MLWTR = vf.createIRI("http://www.geonames.org/ontology#S.MLWTR");
        S_MN = vf.createIRI("http://www.geonames.org/ontology#S.MN");
        S_MNAU = vf.createIRI("http://www.geonames.org/ontology#S.MNAU");
        S_MNC = vf.createIRI("http://www.geonames.org/ontology#S.MNC");
        S_MNCR = vf.createIRI("http://www.geonames.org/ontology#S.MNCR");
        S_MNCU = vf.createIRI("http://www.geonames.org/ontology#S.MNCU");
        S_MNDT = vf.createIRI("http://www.geonames.org/ontology#S.MNDT");
        S_MNFE = vf.createIRI("http://www.geonames.org/ontology#S.MNFE");
        S_MNMT = vf.createIRI("http://www.geonames.org/ontology#S.MNMT");
        S_MNN = vf.createIRI("http://www.geonames.org/ontology#S.MNN");
        S_MNNI = vf.createIRI("http://www.geonames.org/ontology#S.MNNI");
        S_MNPB = vf.createIRI("http://www.geonames.org/ontology#S.MNPB");
        S_MNPL = vf.createIRI("http://www.geonames.org/ontology#S.MNPL");
        S_MNQ = vf.createIRI("http://www.geonames.org/ontology#S.MNQ");
        S_MNQR = vf.createIRI("http://www.geonames.org/ontology#S.MNQR");
        S_MNSN = vf.createIRI("http://www.geonames.org/ontology#S.MNSN");
        S_MOLE = vf.createIRI("http://www.geonames.org/ontology#S.MOLE");
        S_MSQE = vf.createIRI("http://www.geonames.org/ontology#S.MSQE");
        S_MSSN = vf.createIRI("http://www.geonames.org/ontology#S.MSSN");
        S_MSSNQ = vf.createIRI("http://www.geonames.org/ontology#S.MSSNQ");
        S_MSTY = vf.createIRI("http://www.geonames.org/ontology#S.MSTY");
        S_MTRO = vf.createIRI("http://www.geonames.org/ontology#S.MTRO");
        S_MUS = vf.createIRI("http://www.geonames.org/ontology#S.MUS");
        S_NOV = vf.createIRI("http://www.geonames.org/ontology#S.NOV");
        S_NSY = vf.createIRI("http://www.geonames.org/ontology#S.NSY");
        S_OBPT = vf.createIRI("http://www.geonames.org/ontology#S.OBPT");
        S_OBS = vf.createIRI("http://www.geonames.org/ontology#S.OBS");
        S_OBSR = vf.createIRI("http://www.geonames.org/ontology#S.OBSR");
        S_OILJ = vf.createIRI("http://www.geonames.org/ontology#S.OILJ");
        S_OILQ = vf.createIRI("http://www.geonames.org/ontology#S.OILQ");
        S_OILR = vf.createIRI("http://www.geonames.org/ontology#S.OILR");
        S_OILT = vf.createIRI("http://www.geonames.org/ontology#S.OILT");
        S_OILW = vf.createIRI("http://www.geonames.org/ontology#S.OILW");
        S_OPRA = vf.createIRI("http://www.geonames.org/ontology#S.OPRA");
        S_PAL = vf.createIRI("http://www.geonames.org/ontology#S.PAL");
        S_PGDA = vf.createIRI("http://www.geonames.org/ontology#S.PGDA");
        S_PIER = vf.createIRI("http://www.geonames.org/ontology#S.PIER");
        S_PKLT = vf.createIRI("http://www.geonames.org/ontology#S.PKLT");
        S_PMPO = vf.createIRI("http://www.geonames.org/ontology#S.PMPO");
        S_PMPW = vf.createIRI("http://www.geonames.org/ontology#S.PMPW");
        S_PO = vf.createIRI("http://www.geonames.org/ontology#S.PO");
        S_PP = vf.createIRI("http://www.geonames.org/ontology#S.PP");
        S_PPQ = vf.createIRI("http://www.geonames.org/ontology#S.PPQ");
        S_PRKGT = vf.createIRI("http://www.geonames.org/ontology#S.PRKGT");
        S_PRKHQ = vf.createIRI("http://www.geonames.org/ontology#S.PRKHQ");
        S_PRN = vf.createIRI("http://www.geonames.org/ontology#S.PRN");
        S_PRNJ = vf.createIRI("http://www.geonames.org/ontology#S.PRNJ");
        S_PRNQ = vf.createIRI("http://www.geonames.org/ontology#S.PRNQ");
        S_PS = vf.createIRI("http://www.geonames.org/ontology#S.PS");
        S_PSH = vf.createIRI("http://www.geonames.org/ontology#S.PSH");
        S_PSTB = vf.createIRI("http://www.geonames.org/ontology#S.PSTB");
        S_PSTC = vf.createIRI("http://www.geonames.org/ontology#S.PSTC");
        S_PSTP = vf.createIRI("http://www.geonames.org/ontology#S.PSTP");
        S_PYR = vf.createIRI("http://www.geonames.org/ontology#S.PYR");
        S_PYRS = vf.createIRI("http://www.geonames.org/ontology#S.PYRS");
        S_QUAY = vf.createIRI("http://www.geonames.org/ontology#S.QUAY");
        S_RDCR = vf.createIRI("http://www.geonames.org/ontology#S.RDCR");
        S_RECG = vf.createIRI("http://www.geonames.org/ontology#S.RECG");
        S_RECR = vf.createIRI("http://www.geonames.org/ontology#S.RECR");
        S_REST = vf.createIRI("http://www.geonames.org/ontology#S.REST");
        S_RET = vf.createIRI("http://www.geonames.org/ontology#S.RET");
        S_RHSE = vf.createIRI("http://www.geonames.org/ontology#S.RHSE");
        S_RKRY = vf.createIRI("http://www.geonames.org/ontology#S.RKRY");
        S_RLG = vf.createIRI("http://www.geonames.org/ontology#S.RLG");
        S_RLGR = vf.createIRI("http://www.geonames.org/ontology#S.RLGR");
        S_RNCH = vf.createIRI("http://www.geonames.org/ontology#S.RNCH");
        S_RSD = vf.createIRI("http://www.geonames.org/ontology#S.RSD");
        S_RSGNL = vf.createIRI("http://www.geonames.org/ontology#S.RSGNL");
        S_RSRT = vf.createIRI("http://www.geonames.org/ontology#S.RSRT");
        S_RSTN = vf.createIRI("http://www.geonames.org/ontology#S.RSTN");
        S_RSTNQ = vf.createIRI("http://www.geonames.org/ontology#S.RSTNQ");
        S_RSTP = vf.createIRI("http://www.geonames.org/ontology#S.RSTP");
        S_RSTPQ = vf.createIRI("http://www.geonames.org/ontology#S.RSTPQ");
        S_RUIN = vf.createIRI("http://www.geonames.org/ontology#S.RUIN");
        S_SCH = vf.createIRI("http://www.geonames.org/ontology#S.SCH");
        S_SCHA = vf.createIRI("http://www.geonames.org/ontology#S.SCHA");
        S_SCHC = vf.createIRI("http://www.geonames.org/ontology#S.SCHC");
        S_SCHD = vf.createIRI("http://www.geonames.org/ontology#S.SCHD");
        S_SCHL = vf.createIRI("http://www.geonames.org/ontology#S.SCHL");
        S_SCHM = vf.createIRI("http://www.geonames.org/ontology#S.SCHM");
        S_SCHN = vf.createIRI("http://www.geonames.org/ontology#S.SCHN");
        S_SCHT = vf.createIRI("http://www.geonames.org/ontology#S.SCHT");
        S_SECP = vf.createIRI("http://www.geonames.org/ontology#S.SECP");
        S_SHPF = vf.createIRI("http://www.geonames.org/ontology#S.SHPF");
        S_SHRN = vf.createIRI("http://www.geonames.org/ontology#S.SHRN");
        S_SHSE = vf.createIRI("http://www.geonames.org/ontology#S.SHSE");
        S_SLCE = vf.createIRI("http://www.geonames.org/ontology#S.SLCE");
        S_SNTR = vf.createIRI("http://www.geonames.org/ontology#S.SNTR");
        S_SPA = vf.createIRI("http://www.geonames.org/ontology#S.SPA");
        S_SPLY = vf.createIRI("http://www.geonames.org/ontology#S.SPLY");
        S_SQR = vf.createIRI("http://www.geonames.org/ontology#S.SQR");
        S_STBL = vf.createIRI("http://www.geonames.org/ontology#S.STBL");
        S_STDM = vf.createIRI("http://www.geonames.org/ontology#S.STDM");
        S_STNB = vf.createIRI("http://www.geonames.org/ontology#S.STNB");
        S_STNC = vf.createIRI("http://www.geonames.org/ontology#S.STNC");
        S_STNE = vf.createIRI("http://www.geonames.org/ontology#S.STNE");
        S_STNF = vf.createIRI("http://www.geonames.org/ontology#S.STNF");
        S_STNI = vf.createIRI("http://www.geonames.org/ontology#S.STNI");
        S_STNM = vf.createIRI("http://www.geonames.org/ontology#S.STNM");
        S_STNR = vf.createIRI("http://www.geonames.org/ontology#S.STNR");
        S_STNS = vf.createIRI("http://www.geonames.org/ontology#S.STNS");
        S_STNW = vf.createIRI("http://www.geonames.org/ontology#S.STNW");
        S_STPS = vf.createIRI("http://www.geonames.org/ontology#S.STPS");
        S_SWT = vf.createIRI("http://www.geonames.org/ontology#S.SWT");
        S_THTR = vf.createIRI("http://www.geonames.org/ontology#S.THTR");
        S_TMB = vf.createIRI("http://www.geonames.org/ontology#S.TMB");
        S_TMPL = vf.createIRI("http://www.geonames.org/ontology#S.TMPL");
        S_TNKD = vf.createIRI("http://www.geonames.org/ontology#S.TNKD");
        S_TOWR = vf.createIRI("http://www.geonames.org/ontology#S.TOWR");
        S_TRANT = vf.createIRI("http://www.geonames.org/ontology#S.TRANT");
        S_TRIG = vf.createIRI("http://www.geonames.org/ontology#S.TRIG");
        S_TRMO = vf.createIRI("http://www.geonames.org/ontology#S.TRMO");
        S_TWO = vf.createIRI("http://www.geonames.org/ontology#S.TWO");
        S_UNIO = vf.createIRI("http://www.geonames.org/ontology#S.UNIO");
        S_UNIP = vf.createIRI("http://www.geonames.org/ontology#S.UNIP");
        S_UNIV = vf.createIRI("http://www.geonames.org/ontology#S.UNIV");
        S_USGE = vf.createIRI("http://www.geonames.org/ontology#S.USGE");
        S_VETF = vf.createIRI("http://www.geonames.org/ontology#S.VETF");
        S_WALL = vf.createIRI("http://www.geonames.org/ontology#S.WALL");
        S_WALLA = vf.createIRI("http://www.geonames.org/ontology#S.WALLA");
        S_WEIR = vf.createIRI("http://www.geonames.org/ontology#S.WEIR");
        S_WHRF = vf.createIRI("http://www.geonames.org/ontology#S.WHRF");
        S_WRCK = vf.createIRI("http://www.geonames.org/ontology#S.WRCK");
        S_WTRW = vf.createIRI("http://www.geonames.org/ontology#S.WTRW");
        S_ZNF = vf.createIRI("http://www.geonames.org/ontology#S.ZNF");
        S_ZOO = vf.createIRI("http://www.geonames.org/ontology#S.ZOO");
        shortName = vf.createIRI("http://www.geonames.org/ontology#shortName");
        T = vf.createIRI("http://www.geonames.org/ontology#T");
        T_ASPH = vf.createIRI("http://www.geonames.org/ontology#T.ASPH");
        T_ATOL = vf.createIRI("http://www.geonames.org/ontology#T.ATOL");
        T_BAR = vf.createIRI("http://www.geonames.org/ontology#T.BAR");
        T_BCH = vf.createIRI("http://www.geonames.org/ontology#T.BCH");
        T_BCHS = vf.createIRI("http://www.geonames.org/ontology#T.BCHS");
        T_BDLD = vf.createIRI("http://www.geonames.org/ontology#T.BDLD");
        T_BLDR = vf.createIRI("http://www.geonames.org/ontology#T.BLDR");
        T_BLHL = vf.createIRI("http://www.geonames.org/ontology#T.BLHL");
        T_BLOW = vf.createIRI("http://www.geonames.org/ontology#T.BLOW");
        T_BNCH = vf.createIRI("http://www.geonames.org/ontology#T.BNCH");
        T_BUTE = vf.createIRI("http://www.geonames.org/ontology#T.BUTE");
        T_CAPE = vf.createIRI("http://www.geonames.org/ontology#T.CAPE");
        T_CFT = vf.createIRI("http://www.geonames.org/ontology#T.CFT");
        T_CLDA = vf.createIRI("http://www.geonames.org/ontology#T.CLDA");
        T_CLF = vf.createIRI("http://www.geonames.org/ontology#T.CLF");
        T_CNYN = vf.createIRI("http://www.geonames.org/ontology#T.CNYN");
        T_CONE = vf.createIRI("http://www.geonames.org/ontology#T.CONE");
        T_CRDR = vf.createIRI("http://www.geonames.org/ontology#T.CRDR");
        T_CRQ = vf.createIRI("http://www.geonames.org/ontology#T.CRQ");
        T_CRQS = vf.createIRI("http://www.geonames.org/ontology#T.CRQS");
        T_CRTR = vf.createIRI("http://www.geonames.org/ontology#T.CRTR");
        T_CUET = vf.createIRI("http://www.geonames.org/ontology#T.CUET");
        T_DLTA = vf.createIRI("http://www.geonames.org/ontology#T.DLTA");
        T_DPR = vf.createIRI("http://www.geonames.org/ontology#T.DPR");
        T_DSRT = vf.createIRI("http://www.geonames.org/ontology#T.DSRT");
        T_DUNE = vf.createIRI("http://www.geonames.org/ontology#T.DUNE");
        T_DVD = vf.createIRI("http://www.geonames.org/ontology#T.DVD");
        T_ERG = vf.createIRI("http://www.geonames.org/ontology#T.ERG");
        T_FAN = vf.createIRI("http://www.geonames.org/ontology#T.FAN");
        T_FORD = vf.createIRI("http://www.geonames.org/ontology#T.FORD");
        T_FSR = vf.createIRI("http://www.geonames.org/ontology#T.FSR");
        T_GAP = vf.createIRI("http://www.geonames.org/ontology#T.GAP");
        T_GRGE = vf.createIRI("http://www.geonames.org/ontology#T.GRGE");
        T_HDLD = vf.createIRI("http://www.geonames.org/ontology#T.HDLD");
        T_HLL = vf.createIRI("http://www.geonames.org/ontology#T.HLL");
        T_HLLS = vf.createIRI("http://www.geonames.org/ontology#T.HLLS");
        T_HMCK = vf.createIRI("http://www.geonames.org/ontology#T.HMCK");
        T_HMDA = vf.createIRI("http://www.geonames.org/ontology#T.HMDA");
        T_INTF = vf.createIRI("http://www.geonames.org/ontology#T.INTF");
        T_ISL = vf.createIRI("http://www.geonames.org/ontology#T.ISL");
        T_ISLET = vf.createIRI("http://www.geonames.org/ontology#T.ISLET");
        T_ISLF = vf.createIRI("http://www.geonames.org/ontology#T.ISLF");
        T_ISLM = vf.createIRI("http://www.geonames.org/ontology#T.ISLM");
        T_ISLS = vf.createIRI("http://www.geonames.org/ontology#T.ISLS");
        T_ISLT = vf.createIRI("http://www.geonames.org/ontology#T.ISLT");
        T_ISLX = vf.createIRI("http://www.geonames.org/ontology#T.ISLX");
        T_ISTH = vf.createIRI("http://www.geonames.org/ontology#T.ISTH");
        T_KRST = vf.createIRI("http://www.geonames.org/ontology#T.KRST");
        T_LAVA = vf.createIRI("http://www.geonames.org/ontology#T.LAVA");
        T_LEV = vf.createIRI("http://www.geonames.org/ontology#T.LEV");
        T_MESA = vf.createIRI("http://www.geonames.org/ontology#T.MESA");
        T_MND = vf.createIRI("http://www.geonames.org/ontology#T.MND");
        T_MRN = vf.createIRI("http://www.geonames.org/ontology#T.MRN");
        T_MT = vf.createIRI("http://www.geonames.org/ontology#T.MT");
        T_MTS = vf.createIRI("http://www.geonames.org/ontology#T.MTS");
        T_NKM = vf.createIRI("http://www.geonames.org/ontology#T.NKM");
        T_NTK = vf.createIRI("http://www.geonames.org/ontology#T.NTK");
        T_NTKS = vf.createIRI("http://www.geonames.org/ontology#T.NTKS");
        T_PAN = vf.createIRI("http://www.geonames.org/ontology#T.PAN");
        T_PANS = vf.createIRI("http://www.geonames.org/ontology#T.PANS");
        T_PASS = vf.createIRI("http://www.geonames.org/ontology#T.PASS");
        T_PEN = vf.createIRI("http://www.geonames.org/ontology#T.PEN");
        T_PENX = vf.createIRI("http://www.geonames.org/ontology#T.PENX");
        T_PK = vf.createIRI("http://www.geonames.org/ontology#T.PK");
        T_PKS = vf.createIRI("http://www.geonames.org/ontology#T.PKS");
        T_PLAT = vf.createIRI("http://www.geonames.org/ontology#T.PLAT");
        T_PLATX = vf.createIRI("http://www.geonames.org/ontology#T.PLATX");
        T_PLDR = vf.createIRI("http://www.geonames.org/ontology#T.PLDR");
        T_PLN = vf.createIRI("http://www.geonames.org/ontology#T.PLN");
        T_PLNX = vf.createIRI("http://www.geonames.org/ontology#T.PLNX");
        T_PROM = vf.createIRI("http://www.geonames.org/ontology#T.PROM");
        T_PT = vf.createIRI("http://www.geonames.org/ontology#T.PT");
        T_PTS = vf.createIRI("http://www.geonames.org/ontology#T.PTS");
        T_RDGB = vf.createIRI("http://www.geonames.org/ontology#T.RDGB");
        T_RDGE = vf.createIRI("http://www.geonames.org/ontology#T.RDGE");
        T_REG = vf.createIRI("http://www.geonames.org/ontology#T.REG");
        T_RK = vf.createIRI("http://www.geonames.org/ontology#T.RK");
        T_RKFL = vf.createIRI("http://www.geonames.org/ontology#T.RKFL");
        T_RKS = vf.createIRI("http://www.geonames.org/ontology#T.RKS");
        T_SAND = vf.createIRI("http://www.geonames.org/ontology#T.SAND");
        T_SBED = vf.createIRI("http://www.geonames.org/ontology#T.SBED");
        T_SCRP = vf.createIRI("http://www.geonames.org/ontology#T.SCRP");
        T_SDL = vf.createIRI("http://www.geonames.org/ontology#T.SDL");
        T_SHOR = vf.createIRI("http://www.geonames.org/ontology#T.SHOR");
        T_SINK = vf.createIRI("http://www.geonames.org/ontology#T.SINK");
        T_SLID = vf.createIRI("http://www.geonames.org/ontology#T.SLID");
        T_SLP = vf.createIRI("http://www.geonames.org/ontology#T.SLP");
        T_SPIT = vf.createIRI("http://www.geonames.org/ontology#T.SPIT");
        T_SPUR = vf.createIRI("http://www.geonames.org/ontology#T.SPUR");
        T_TAL = vf.createIRI("http://www.geonames.org/ontology#T.TAL");
        T_TRGD = vf.createIRI("http://www.geonames.org/ontology#T.TRGD");
        T_TRR = vf.createIRI("http://www.geonames.org/ontology#T.TRR");
        T_UPLD = vf.createIRI("http://www.geonames.org/ontology#T.UPLD");
        T_VAL = vf.createIRI("http://www.geonames.org/ontology#T.VAL");
        T_VALG = vf.createIRI("http://www.geonames.org/ontology#T.VALG");
        T_VALS = vf.createIRI("http://www.geonames.org/ontology#T.VALS");
        T_VALX = vf.createIRI("http://www.geonames.org/ontology#T.VALX");
        T_VLC = vf.createIRI("http://www.geonames.org/ontology#T.VLC");
        U = vf.createIRI("http://www.geonames.org/ontology#U");
        U_APNU = vf.createIRI("http://www.geonames.org/ontology#U.APNU");
        U_ARCU = vf.createIRI("http://www.geonames.org/ontology#U.ARCU");
        U_ARRU = vf.createIRI("http://www.geonames.org/ontology#U.ARRU");
        U_BDLU = vf.createIRI("http://www.geonames.org/ontology#U.BDLU");
        U_BKSU = vf.createIRI("http://www.geonames.org/ontology#U.BKSU");
        U_BNCU = vf.createIRI("http://www.geonames.org/ontology#U.BNCU");
        U_BNKU = vf.createIRI("http://www.geonames.org/ontology#U.BNKU");
        U_BSNU = vf.createIRI("http://www.geonames.org/ontology#U.BSNU");
        U_CDAU = vf.createIRI("http://www.geonames.org/ontology#U.CDAU");
        U_CNSU = vf.createIRI("http://www.geonames.org/ontology#U.CNSU");
        U_CNYU = vf.createIRI("http://www.geonames.org/ontology#U.CNYU");
        U_CRSU = vf.createIRI("http://www.geonames.org/ontology#U.CRSU");
        U_DEPU = vf.createIRI("http://www.geonames.org/ontology#U.DEPU");
        U_EDGU = vf.createIRI("http://www.geonames.org/ontology#U.EDGU");
        U_ESCU = vf.createIRI("http://www.geonames.org/ontology#U.ESCU");
        U_FANU = vf.createIRI("http://www.geonames.org/ontology#U.FANU");
        U_FLTU = vf.createIRI("http://www.geonames.org/ontology#U.FLTU");
        U_FRKU = vf.createIRI("http://www.geonames.org/ontology#U.FRKU");
        U_FRSU = vf.createIRI("http://www.geonames.org/ontology#U.FRSU");
        U_FRZU = vf.createIRI("http://www.geonames.org/ontology#U.FRZU");
        U_FURU = vf.createIRI("http://www.geonames.org/ontology#U.FURU");
        U_GAPU = vf.createIRI("http://www.geonames.org/ontology#U.GAPU");
        U_GLYU = vf.createIRI("http://www.geonames.org/ontology#U.GLYU");
        U_HLLU = vf.createIRI("http://www.geonames.org/ontology#U.HLLU");
        U_HLSU = vf.createIRI("http://www.geonames.org/ontology#U.HLSU");
        U_HOLU = vf.createIRI("http://www.geonames.org/ontology#U.HOLU");
        U_KNLU = vf.createIRI("http://www.geonames.org/ontology#U.KNLU");
        U_KNSU = vf.createIRI("http://www.geonames.org/ontology#U.KNSU");
        U_LDGU = vf.createIRI("http://www.geonames.org/ontology#U.LDGU");
        U_LEVU = vf.createIRI("http://www.geonames.org/ontology#U.LEVU");
        U_MDVU = vf.createIRI("http://www.geonames.org/ontology#U.MDVU");
        U_MESU = vf.createIRI("http://www.geonames.org/ontology#U.MESU");
        U_MNDU = vf.createIRI("http://www.geonames.org/ontology#U.MNDU");
        U_MOTU = vf.createIRI("http://www.geonames.org/ontology#U.MOTU");
        U_MTSU = vf.createIRI("http://www.geonames.org/ontology#U.MTSU");
        U_MTU = vf.createIRI("http://www.geonames.org/ontology#U.MTU");
        U_PKSU = vf.createIRI("http://www.geonames.org/ontology#U.PKSU");
        U_PKU = vf.createIRI("http://www.geonames.org/ontology#U.PKU");
        U_PLFU = vf.createIRI("http://www.geonames.org/ontology#U.PLFU");
        U_PLNU = vf.createIRI("http://www.geonames.org/ontology#U.PLNU");
        U_PLTU = vf.createIRI("http://www.geonames.org/ontology#U.PLTU");
        U_PNLU = vf.createIRI("http://www.geonames.org/ontology#U.PNLU");
        U_PRVU = vf.createIRI("http://www.geonames.org/ontology#U.PRVU");
        U_RAVU = vf.createIRI("http://www.geonames.org/ontology#U.RAVU");
        U_RDGU = vf.createIRI("http://www.geonames.org/ontology#U.RDGU");
        U_RDSU = vf.createIRI("http://www.geonames.org/ontology#U.RDSU");
        U_RFSU = vf.createIRI("http://www.geonames.org/ontology#U.RFSU");
        U_RFU = vf.createIRI("http://www.geonames.org/ontology#U.RFU");
        U_RISU = vf.createIRI("http://www.geonames.org/ontology#U.RISU");
        U_RMPU = vf.createIRI("http://www.geonames.org/ontology#U.RMPU");
        U_RNGU = vf.createIRI("http://www.geonames.org/ontology#U.RNGU");
        U_SCNU = vf.createIRI("http://www.geonames.org/ontology#U.SCNU");
        U_SCSU = vf.createIRI("http://www.geonames.org/ontology#U.SCSU");
        U_SDLU = vf.createIRI("http://www.geonames.org/ontology#U.SDLU");
        U_SHFU = vf.createIRI("http://www.geonames.org/ontology#U.SHFU");
        U_SHLU = vf.createIRI("http://www.geonames.org/ontology#U.SHLU");
        U_SHSU = vf.createIRI("http://www.geonames.org/ontology#U.SHSU");
        U_SHVU = vf.createIRI("http://www.geonames.org/ontology#U.SHVU");
        U_SILU = vf.createIRI("http://www.geonames.org/ontology#U.SILU");
        U_SLPU = vf.createIRI("http://www.geonames.org/ontology#U.SLPU");
        U_SMSU = vf.createIRI("http://www.geonames.org/ontology#U.SMSU");
        U_SMU = vf.createIRI("http://www.geonames.org/ontology#U.SMU");
        U_SPRU = vf.createIRI("http://www.geonames.org/ontology#U.SPRU");
        U_TERU = vf.createIRI("http://www.geonames.org/ontology#U.TERU");
        U_TMSU = vf.createIRI("http://www.geonames.org/ontology#U.TMSU");
        U_TMTU = vf.createIRI("http://www.geonames.org/ontology#U.TMTU");
        U_TNGU = vf.createIRI("http://www.geonames.org/ontology#U.TNGU");
        U_TRGU = vf.createIRI("http://www.geonames.org/ontology#U.TRGU");
        U_TRNU = vf.createIRI("http://www.geonames.org/ontology#U.TRNU");
        U_VALU = vf.createIRI("http://www.geonames.org/ontology#U.VALU");
        U_VLSU = vf.createIRI("http://www.geonames.org/ontology#U.VLSU");
        V = vf.createIRI("http://www.geonames.org/ontology#V");
        V_BUSH = vf.createIRI("http://www.geonames.org/ontology#V.BUSH");
        V_CULT = vf.createIRI("http://www.geonames.org/ontology#V.CULT");
        V_FRST = vf.createIRI("http://www.geonames.org/ontology#V.FRST");
        V_FRSTF = vf.createIRI("http://www.geonames.org/ontology#V.FRSTF");
        V_GRSLD = vf.createIRI("http://www.geonames.org/ontology#V.GRSLD");
        V_GRVC = vf.createIRI("http://www.geonames.org/ontology#V.GRVC");
        V_GRVO = vf.createIRI("http://www.geonames.org/ontology#V.GRVO");
        V_GRVP = vf.createIRI("http://www.geonames.org/ontology#V.GRVP");
        V_GRVPN = vf.createIRI("http://www.geonames.org/ontology#V.GRVPN");
        V_HTH = vf.createIRI("http://www.geonames.org/ontology#V.HTH");
        V_MDW = vf.createIRI("http://www.geonames.org/ontology#V.MDW");
        V_OCH = vf.createIRI("http://www.geonames.org/ontology#V.OCH");
        V_SCRB = vf.createIRI("http://www.geonames.org/ontology#V.SCRB");
        V_TREE = vf.createIRI("http://www.geonames.org/ontology#V.TREE");
        V_TUND = vf.createIRI("http://www.geonames.org/ontology#V.TUND");
        V_VIN = vf.createIRI("http://www.geonames.org/ontology#V.VIN");
        V_VINS = vf.createIRI("http://www.geonames.org/ontology#V.VINS");
        WikipediaArticle = vf.createIRI("http://www.geonames.org/ontology#WikipediaArticle");
        wikipediaArticle = vf.createIRI("http://www.geonames.org/ontology#wikipediaArticle");

        _VALUES = Vocabularies.getIRIs(GeoNamesVocabulary.class);
    }

    public GeoNamesVocabulary() {
        // To enable service discovery to succeed, even though this is a static class
    }

    @NotNull
    @Override
    public String getNamespace() {
        return NAMESPACE;
    }

    @NotNull
    @Override
    public Iterator<IRI> getValues() {
        return _VALUES.iterator();
    }
}