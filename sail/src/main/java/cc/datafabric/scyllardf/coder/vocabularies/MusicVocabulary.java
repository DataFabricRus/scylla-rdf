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
 * "The Music Ontology"
 * <p>
 * The Music Ontology Specification provides main concepts and
 * properties fo describing music (i.e. artists, albums and tracks)
 * on the Semantic Web.
 * <p>
 * <p>
 * Namespace MusicVocabulary
 * Prefix: {@code <http://purl.org/ontology/mo/>}
 */
public class MusicVocabulary implements IVocabulary {

    /**
     * {@code <http://purl.org/ontology/mo/>}
     */
    public static final String NAMESPACE = "http://purl.org/ontology/mo/";

    /**
     * {@code <http://purl.org/ontology/mo/>}
     */
    public static final IRI NAMESPACE_IRI;

    /**
     * {@code <MusicVocabulary>}
     */
    public static final String PREFIX = "MusicVocabulary";

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
     * activity
     * <p>
     * {@code http://purl.org/ontology/mo/Activity}
     * <p>
     * <p>
     * An activity period, defining when an artist was musically
     * active.
     *
     * @see <a href="http://purl.org/ontology/mo/Activity">Activity</a>
     */
    public static final IRI Activity;

    /**
     * activity
     * <p>
     * {@code http://purl.org/ontology/mo/activity}
     * <p>
     * Relates an artist to an activity period
     *
     * @see <a href="http://purl.org/ontology/mo/activity">activity</a>
     */
    public static final IRI activity;

    /**
     * activity end
     * <p>
     * {@code http://purl.org/ontology/mo/activity_end}
     * <p>
     * Relates an artist to a date at which its activity ended
     *
     * @see <a href="http://purl.org/ontology/mo/activity_end">activity_end</a>
     */
    public static final IRI activity_end;

    /**
     * activity start
     * <p>
     * {@code http://purl.org/ontology/mo/activity_start}
     * <p>
     * Relates an artist to a date at which its activity started
     *
     * @see <a href="http://purl.org/ontology/mo/activity_start">activity_start</a>
     */
    public static final IRI activity_start;

    /**
     * album
     * <p>
     * {@code http://purl.org/ontology/mo/album}
     * <p>
     * <p>
     * One or more track issued together.
     * This is a type
     * of MusicalManifestation defined by the musical industry.
     *
     * @see <a href="http://purl.org/ontology/mo/album">album</a>
     */
    public static final IRI album;

    /**
     * amazon_asin
     * <p>
     * {@code http://purl.org/ontology/mo/amazon_asin}
     * <p>
     * Used to link a work or the expression of a work to its corresponding
     * Amazon ASINs page.
     *
     * @see <a href="http://purl.org/ontology/mo/amazon_asin">amazon_asin</a>
     */
    public static final IRI amazon_asin;

    /**
     * analogue signal
     * <p>
     * {@code http://purl.org/ontology/mo/AnalogSignal}
     * <p>
     * <p>
     * An analog signal.
     *
     * @see <a href="http://purl.org/ontology/mo/AnalogSignal">AnalogSignal</a>
     */
    public static final IRI AnalogSignal;

    /**
     * arranged in
     * <p>
     * {@code http://purl.org/ontology/mo/arranged_in}
     * <p>
     * <p>
     * Associates a work to an arrangement event where it was
     * arranged
     *
     * @see <a href="http://purl.org/ontology/mo/arranged_in">arranged_in</a>
     */
    public static final IRI arranged_in;

    /**
     * arrangement
     * <p>
     * {@code http://purl.org/ontology/mo/Arrangement}
     * <p>
     * <p>
     * An arrangement event.
     * Takes as agent the arranger,
     * and produces a score (informational object, not the actually published
     * score).
     *
     * @see <a href="http://purl.org/ontology/mo/Arrangement">Arrangement</a>
     */
    public static final IRI Arrangement;

    /**
     * arrangement of
     * <p>
     * {@code http://purl.org/ontology/mo/arrangement_of}
     * <p>
     * <p>
     * Associates an arrangement event to a work
     *
     * @see <a href="http://purl.org/ontology/mo/arrangement_of">arrangement_of</a>
     */
    public static final IRI arrangement_of;

    /**
     * arranger
     * <p>
     * {@code http://purl.org/ontology/mo/Arranger}
     *
     * @see <a href="http://purl.org/ontology/mo/Arranger">Arranger</a>
     */
    public static final IRI Arranger;

    /**
     * artist
     * <p>
     * {@code http://purl.org/ontology/mo/artist}
     * <p>
     * Relates a membership event with the corresponding artist
     *
     * @see <a href="http://purl.org/ontology/mo/artist">artist</a>
     */
    public static final IRI artist;

    /**
     * audio book
     * <p>
     * {@code http://purl.org/ontology/mo/audiobook}
     * <p>
     * <p>
     * Book read by a narrator without music.
     * This is a type
     * of MusicalManifestation defined by the musical industry.
     *
     * @see <a href="http://purl.org/ontology/mo/audiobook">audiobook</a>
     */
    public static final IRI audiobook;

    /**
     * audio file
     * <p>
     * {@code http://purl.org/ontology/mo/AudioFile}
     * <p>
     * An audio file, which may be available on a local file system or
     * through http, ftp, etc.
     *
     * @see <a href="http://purl.org/ontology/mo/AudioFile">AudioFile</a>
     */
    public static final IRI AudioFile;

    /**
     * {@code http://purl.org/ontology/mo/available_as}
     * <p>
     * <p>
     * Relates a musical manifestation to a musical item (this
     * album, and my particular cd). By using
     * this property, there is
     * no assumption on wether the full content is available on the linked
     * item.
     * To be explicit about this, you can use a sub-property,
     * such as mo:item (the full manifestation
     * is available on that
     * item) or mo:preview (only a part of the manifestation is available on
     * <p>
     * that item).
     * <p>
     * This is a subproperty of frbr:examplar.
     *
     * @see <a href="http://purl.org/ontology/mo/available_as">available_as</a>
     */
    public static final IRI available_as;

    /**
     * {@code http://purl.org/ontology/mo/availableAs}
     *
     * @see <a href="http://purl.org/ontology/mo/availableAs">availableAs</a>
     */
    public static final IRI availableAs;

    /**
     * biography
     * <p>
     * {@code http://purl.org/ontology/mo/biography}
     * <p>
     * Used to link an artist to their online biography.
     *
     * @see <a href="http://purl.org/ontology/mo/biography">biography</a>
     */
    public static final IRI biography;

    /**
     * {@code http://purl.org/ontology/mo/bitsPerSample}
     * <p>
     * <p>
     * Associates a digital signal to the number a bits used to
     * encode one sample. Range is xsd:int.
     *
     * @see <a href="http://purl.org/ontology/mo/bitsPerSample">bitsPerSample</a>
     */
    public static final IRI bitsPerSample;

    /**
     * bootleg
     * <p>
     * {@code http://purl.org/ontology/mo/bootleg}
     * <p>
     * An unofficial/underground musical work or the expression of a musical
     * work that was not sanctioned by the artist and/or the corporate body.
     *
     * @see <a href="http://purl.org/ontology/mo/bootleg">bootleg</a>
     */
    public static final IRI bootleg;

    /**
     * bpm
     * <p>
     * {@code http://purl.org/ontology/mo/bpm}
     * <p>
     * <p>
     * Indicates the BPM of a MusicalWork or a particular
     * Performance
     * Beats per minute: the pace of music measured by
     * the number of beats occurring in 60 seconds.
     *
     * @see <a href="http://purl.org/ontology/mo/bpm">bpm</a>
     */
    public static final IRI bpm;

    /**
     * catalogue number
     * <p>
     * {@code http://purl.org/ontology/mo/catalogue_number}
     * <p>
     * Links a release with the corresponding catalogue number
     *
     * @see <a href="http://purl.org/ontology/mo/catalogue_number">catalogue_number</a>
     */
    public static final IRI catalogue_number;

    /**
     * CD
     * <p>
     * {@code http://purl.org/ontology/mo/CD}
     * <p>
     * Compact Disc used as medium to record a musical manifestation.
     *
     * @see <a href="http://purl.org/ontology/mo/CD">CD</a>
     */
    public static final IRI CD;

    /**
     * {@code http://purl.org/ontology/mo/channels}
     * <p>
     * <p>
     * Associates a signal to the number of channels it holds (mono
     * --&gt; 1, stereo --&gt; 2). Range is xsd:int.
     *
     * @see <a href="http://purl.org/ontology/mo/channels">channels</a>
     */
    public static final IRI channels;

    /**
     * collaborated_with
     * <p>
     * {@code http://purl.org/ontology/mo/collaborated_with}
     * <p>
     * Used to relate two collaborating people on a work.
     *
     * @see <a href="http://purl.org/ontology/mo/collaborated_with">collaborated_with</a>
     */
    public static final IRI collaborated_with;

    /**
     * compilation
     * <p>
     * {@code http://purl.org/ontology/mo/compilation}
     * <p>
     * <p>
     * Collection of previously released manifestations of a musical
     * expression by one or more artists.
     * This is a type of
     * MusicalManifestation defined by the musical industry.
     *
     * @see <a href="http://purl.org/ontology/mo/compilation">compilation</a>
     */
    public static final IRI compilation;

    /**
     * compilation_of
     * <p>
     * {@code http://purl.org/ontology/mo/compilation_of}
     * <p>
     * Indicates that a musical manifestation is a compilation of several
     * Signals.
     *
     * @see <a href="http://purl.org/ontology/mo/compilation_of">compilation_of</a>
     */
    public static final IRI compilation_of;

    /**
     * compiled
     * <p>
     * {@code http://purl.org/ontology/mo/compiled}
     * <p>
     * Used to relate an person or a group of person who compiled the
     * manifestation of a musical work.
     *
     * @see <a href="http://purl.org/ontology/mo/compiled">compiled</a>
     */
    public static final IRI compiled;

    /**
     * compiler
     * <p>
     * {@code http://purl.org/ontology/mo/compiler}
     * <p>
     * Used to relate the manifestation of a musical work to a person or a
     * group of person who compiled it.
     *
     * @see <a href="http://purl.org/ontology/mo/compiler">compiler</a>
     */
    public static final IRI compiler;

    /**
     * composed in
     * <p>
     * {@code http://purl.org/ontology/mo/composed_in}
     * <p>
     * <p>
     * Associates a MusicalWork to the Composition event pertaining
     * <p>
     * to its creation. For example, I might use this property to associate
     * <p>
     * the Magic Flute to its composition event, occuring during 1782 and
     * having as
     * a mo:composer Mozart.
     *
     * @see <a href="http://purl.org/ontology/mo/composed_in">composed_in</a>
     */
    public static final IRI composed_in;

    /**
     * composer
     * <p>
     * {@code http://purl.org/ontology/mo/Composer}
     *
     * @see <a href="http://purl.org/ontology/mo/Composer">Composer</a>
     */
    public static final IRI Composer;

    /**
     * composer
     * <p>
     * {@code http://purl.org/ontology/mo/composer}
     * <p>
     * <p>
     * Associates a composition event to the actual composer. For
     * example,
     * this property could link the event corresponding to
     * the composition of the
     * Magic Flute in 1782 to Mozart himself
     * (who obviously has a FOAF profile:-) ).
     *
     * @see <a href="http://purl.org/ontology/mo/composer">composer</a>
     */
    public static final IRI composer;

    /**
     * composition
     * <p>
     * {@code http://purl.org/ontology/mo/Composition}
     * <p>
     * <p>
     * A composition event.
     * Takes as agent the composer
     * himself.
     * It produces a MusicalWork, or a MusicalExpression
     * (when the initial &quot;product&quot; is a score, for example), or
     * both...
     *
     * @see <a href="http://purl.org/ontology/mo/Composition">Composition</a>
     */
    public static final IRI Composition;

    /**
     * conducted
     * <p>
     * {@code http://purl.org/ontology/mo/conducted}
     * <p>
     * Relates agents to the performances they were conducting
     *
     * @see <a href="http://purl.org/ontology/mo/conducted">conducted</a>
     */
    public static final IRI conducted;

    /**
     * conductor
     * <p>
     * {@code http://purl.org/ontology/mo/Conductor}
     *
     * @see <a href="http://purl.org/ontology/mo/Conductor">Conductor</a>
     */
    public static final IRI Conductor;

    /**
     * {@code http://purl.org/ontology/mo/conductor}
     * <p>
     * Relates a performance to the conductor involved
     *
     * @see <a href="http://purl.org/ontology/mo/conductor">conductor</a>
     */
    public static final IRI conductor;

    /**
     * contains_sample_from
     * <p>
     * {@code http://purl.org/ontology/mo/contains_sample_from}
     * <p>
     * <p>
     * Relates a signal to another signal, which has been sampled.
     *
     * @see <a href="http://purl.org/ontology/mo/contains_sample_from">contains_sample_from</a>
     */
    public static final IRI contains_sample_from;

    /**
     * corporate body
     * <p>
     * {@code http://purl.org/ontology/mo/CorporateBody}
     * <p>
     * Organization or group of individuals and/or other organizations
     * involved in the music market.
     *
     * @see <a href="http://purl.org/ontology/mo/CorporateBody">CorporateBody</a>
     */
    public static final IRI CorporateBody;

    /**
     * DAT
     * <p>
     * {@code http://purl.org/ontology/mo/DAT}
     * <p>
     * Digital Audio Tape used as medium to record a musical manifestation.
     *
     * @see <a href="http://purl.org/ontology/mo/DAT">DAT</a>
     */
    public static final IRI DAT;

    /**
     * DCC
     * <p>
     * {@code http://purl.org/ontology/mo/DCC}
     * <p>
     * Digital Compact Cassette used as medium to record a musical
     * manifestation.
     *
     * @see <a href="http://purl.org/ontology/mo/DCC">DCC</a>
     */
    public static final IRI DCC;

    /**
     * derived from
     * <p>
     * {@code http://purl.org/ontology/mo/derived_from}
     * <p>
     * A related signal from which the described signal is derived.
     *
     * @see <a href="http://purl.org/ontology/mo/derived_from">derived_from</a>
     */
    public static final IRI derived_from;

    /**
     * digital signal
     * <p>
     * {@code http://purl.org/ontology/mo/DigitalSignal}
     * <p>
     * <p>
     * A digital signal
     *
     * @see <a href="http://purl.org/ontology/mo/DigitalSignal">DigitalSignal</a>
     */
    public static final IRI DigitalSignal;

    /**
     * discography
     * <p>
     * {@code http://purl.org/ontology/mo/discography}
     * <p>
     * Used to links an artist to an online discography of their musical
     * works. The discography should provide a summary of each released
     * musical work of the artist.
     *
     * @see <a href="http://purl.org/ontology/mo/discography">discography</a>
     */
    public static final IRI discography;

    /**
     * discogs
     * <p>
     * {@code http://purl.org/ontology/mo/discogs}
     * <p>
     * Used to link a musical work or the expression of a musical work, an
     * artist or a corporate body to to its corresponding Discogs page.
     *
     * @see <a href="http://purl.org/ontology/mo/discogs">discogs</a>
     */
    public static final IRI discogs;

    /**
     * djmix_of
     * <p>
     * {@code http://purl.org/ontology/mo/djmix_of}
     * <p>
     * Indicates that all (or most of) the tracks of a musical work or the
     * expression of a musical work were mixed together from all (or most of)
     * the tracks from another musical work or the expression of a musical
     * work to form a so called DJ-Mix.
     * <p>
     * The tracks might have been
     * altered by pitching (so that the tempo of one track matches the tempo
     * of the following track) and fading (so that one track blends in
     * smoothly with the other). If the tracks have been more substantially
     * altered, the &quot;mo:remix&quot; relationship type is more
     * appropriate.
     *
     * @see <a href="http://purl.org/ontology/mo/djmix_of">djmix_of</a>
     */
    public static final IRI djmix_of;

    /**
     * djmixed
     * <p>
     * {@code http://purl.org/ontology/mo/djmixed}
     * <p>
     * Used to relate an artist who djmixed a musical work or the expression
     * of a musical work.
     * <p>
     * The artist usually selected the tracks, chose
     * their sequence, and slightly changed them by fading (so that one track
     * blends in smoothly with the other) or pitching (so that the tempo of
     * one track matches the tempo of the following track). This applies to a
     * &#39;Mixtape&#39; in which all tracks were DJ-mixed together into one
     * single long track.
     *
     * @see <a href="http://purl.org/ontology/mo/djmixed">djmixed</a>
     */
    public static final IRI djmixed;

    /**
     * djmixed_by
     * <p>
     * {@code http://purl.org/ontology/mo/djmixed_by}
     * <p>
     * Used to relate a work or the expression of a work to an artist who
     * djmixed it.
     * <p>
     * The artist usually selected the tracks, chose their
     * sequence, and slightly changed them by fading (so that one track
     * blends in smoothly with the other) or pitching (so that the tempo of
     * one track matches the tempo of the following track). This applies to a
     * &#39;Mixtape&#39; in which all tracks were DJ-mixed together into one
     * single long track.
     *
     * @see <a href="http://purl.org/ontology/mo/djmixed_by">djmixed_by</a>
     */
    public static final IRI djmixed_by;

    /**
     * download
     * <p>
     * {@code http://purl.org/ontology/mo/download}
     * <p>
     * <p>
     * This property can be used to link from a person to
     * the website where they make their works available, or from
     * <p>
     * a manifestation (a track or an album, for example) to a web page where
     * it is available for
     * download.
     * <p>
     * It is
     * better to use one of the three sub-properties instead of this one in
     * order to specify wether the
     * content can be accessed for free
     * (mo:freedownload), if it is just free preview material
     * (mo:previewdownload), or
     * if it can be accessed for some money
     * (mo:paiddownload) (this includes links to the Amazon store, for
     * example).
     * <p>
     * This property MUST be used only if the
     * content is just available through a web page (holding, for example
     * <p>
     * a Flash application) - it is better to link to actual content directly
     * through the use of mo:available_as and
     * mo:Stream,
     * mo:Torrent or mo:ED2K, etc. Therefore, Semantic Web user agents that
     * don&#39;t know how to read HTML and even
     * less to rip
     * streams from Flash applications can still access the audio content.
     *
     * @see <a href="http://purl.org/ontology/mo/download">download</a>
     */
    public static final IRI download;

    /**
     * {@code http://purl.org/ontology/mo/duration}
     * <p>
     * The duration of a track or a signal in ms
     *
     * @see <a href="http://purl.org/ontology/mo/duration">duration</a>
     */
    public static final IRI duration;

    /**
     * DVDA
     * <p>
     * {@code http://purl.org/ontology/mo/DVDA}
     * <p>
     * DVD-Audio used as medium to record a musical manifestation.
     *
     * @see <a href="http://purl.org/ontology/mo/DVDA">DVDA</a>
     */
    public static final IRI DVDA;

    /**
     * ean
     * <p>
     * {@code http://purl.org/ontology/mo/ean}
     * <p>
     * The European Article Number (EAN) is a universal identifier for
     * products, commonly printed in form of barcodes on them. The numbers
     * represented by those codes can either be 8 or 13 digits long, with the
     * 13-digit-version being most common. EANs form a superset of the North
     * American Universal Product Code (UPC) as every UPC can be made an EAN
     * by adding a leading zero to it. Additionally every EAN is also a
     * Japanese Article Number (JAN). The identifiers were formerly assigned
     * by EAN International which merged with Uniform Code Council (UCC, the
     * guys behind the UPCs) and Electronic Commerce Council of Canada (ECCC)
     * to become GS1.
     *
     * @see <a href="http://purl.org/ontology/mo/ean">ean</a>
     */
    public static final IRI ean;

    /**
     * ED2K
     * <p>
     * {@code http://purl.org/ontology/mo/ED2K}
     * <p>
     * Something available on the E-Donkey peer-2-peer filesharing network
     *
     * @see <a href="http://purl.org/ontology/mo/ED2K">ED2K</a>
     */
    public static final IRI ED2K;

    /**
     * encodes
     * <p>
     * {@code http://purl.org/ontology/mo/encodes}
     * <p>
     * <p>
     * Relates a MusicalItem (a track on a particular CD, an audio
     * file, a stream somewhere) to the signal it encodes.
     * <p>
     * This is
     * usually a lower-resolution version of the master signal (issued from a
     * Recording event).
     *
     * @see <a href="http://purl.org/ontology/mo/encodes">encodes</a>
     */
    public static final IRI encodes;

    /**
     * encoding
     * <p>
     * {@code http://purl.org/ontology/mo/encoding}
     * <p>
     * Method used to convert analog electronic signals into digital format
     * such as &quot;MP3 CBR @ 128kbps&quot;, &quot;OGG @ 160kbps&quot;,
     * &quot;FLAC&quot;, etc.
     *
     * @see <a href="http://purl.org/ontology/mo/encoding">encoding</a>
     */
    public static final IRI encoding;

    /**
     * {@code http://purl.org/ontology/mo/engineer}
     * <p>
     * Relates a performance or a recording to the engineer involved
     *
     * @see <a href="http://purl.org/ontology/mo/engineer">engineer</a>
     */
    public static final IRI engineer;

    /**
     * engineered
     * <p>
     * {@code http://purl.org/ontology/mo/engineered}
     * <p>
     * Relates agents to the performances/recordings they were engineering in
     *
     * @see <a href="http://purl.org/ontology/mo/engineered">engineered</a>
     */
    public static final IRI engineered;

    /**
     * ep
     * <p>
     * {@code http://purl.org/ontology/mo/ep}
     * <p>
     * <p>
     * An EP
     *
     * @see <a href="http://purl.org/ontology/mo/ep">ep</a>
     */
    public static final IRI ep;

    /**
     * event homepage
     * <p>
     * {@code http://purl.org/ontology/mo/event_homepage}
     * <p>
     * Links a particular event to a web page
     *
     * @see <a href="http://purl.org/ontology/mo/event_homepage">event_homepage</a>
     */
    public static final IRI event_homepage;

    /**
     * {@code http://purl.org/ontology/mo/eventHomePage}
     *
     * @see <a href="http://purl.org/ontology/mo/eventHomePage">eventHomePage</a>
     */
    public static final IRI eventHomePage;

    /**
     * exchange_item
     * <p>
     * {@code http://purl.org/ontology/mo/exchange_item}
     * <p>
     * A person, a group of person or an organization exchanging an exemplar
     * of a single manifestation.
     *
     * @see <a href="http://purl.org/ontology/mo/exchange_item">exchange_item</a>
     */
    public static final IRI exchange_item;

    /**
     * fanpage
     * <p>
     * {@code http://purl.org/ontology/mo/fanpage}
     * <p>
     * Used to link an artist to a fan-created webpage devoted to that
     * artist.
     *
     * @see <a href="http://purl.org/ontology/mo/fanpage">fanpage</a>
     */
    public static final IRI fanpage;

    /**
     * Festival
     * <p>
     * {@code http://purl.org/ontology/mo/Festival}
     * <p>
     * <p>
     * A festival - musical/artistic event lasting several days,
     * like Glastonbury, Rock Am Ring...
     * We migth decompose this
     * event (which is in fact just a classification of the space/time region
     * related to
     * a particular festival) using hasSubEvent in
     * several performances at different space/time.
     *
     * @see <a href="http://purl.org/ontology/mo/Festival">Festival</a>
     */
    public static final IRI Festival;

    /**
     * free download
     * <p>
     * {@code http://purl.org/ontology/mo/free_download}
     * <p>
     * <p>
     * This property can be used to link from a person to the
     * website where they make their works available, or from
     * a
     * manifestation (a track or an album, for example) to a web page where
     * it is available for free
     * download.
     * <p>
     * This property
     * MUST be used only if the content is just available through a web page
     * (holding, for example
     * a Flash application) - it is better to
     * link to actual content directly through the use of mo:available_as and
     * <p>
     * mo:Stream, mo:Torrent or mo:ED2K, etc. Therefore, Semantic
     * Web user agents that don&#39;t know how to read HTML and even
     * <p>
     * less to rip streams from Flash applications can still access the audio
     * content.
     *
     * @see <a href="http://purl.org/ontology/mo/free_download">free_download</a>
     */
    public static final IRI free_download;

    /**
     * {@code http://purl.org/ontology/mo/freedownload}
     *
     * @see <a href="http://purl.org/ontology/mo/freedownload">freedownload</a>
     */
    public static final IRI freedownload;

    /**
     * genre
     * <p>
     * {@code http://purl.org/ontology/mo/genre}
     * <p>
     * <p>
     * Associates an event (like a performance or a recording) to a
     * particular musical genre.
     * Further version of this property may
     * also include works and scores in the domain.
     *
     * @see <a href="http://purl.org/ontology/mo/genre">genre</a>
     */
    public static final IRI genre;

    /**
     * Genre
     * <p>
     * {@code http://purl.org/ontology/mo/Genre}
     * <p>
     * <p>
     * An expressive style of music.
     * <p>
     * Any taxonomy
     * can be plug-in here. You can either define a genre by yourself, like
     * this:
     * <p>
     * :mygenre a mo:Genre; dc:title &quot;electro
     * rock&quot;.
     * <p>
     * Or you can refer to a DBPedia genre (such as
     * http://dbpedia.org/resource/Baroque_music), allowing semantic web
     * <p>
     * clients to access easily really detailed structured information about
     * the genre you are refering to.
     *
     * @see <a href="http://purl.org/ontology/mo/Genre">Genre</a>
     */
    public static final IRI Genre;

    /**
     * GRid
     * <p>
     * {@code http://purl.org/ontology/mo/grid}
     * <p>
     * The Global Release Identifier (GRid) is a system for uniquely
     * identifying Releases of music over electronic networks (that is,
     * online stores where you can buy music as digital files). As that it
     * can be seen as the equivalent of the BarCode (or more correctly the
     * GTIN) as found on physical releases of music. Like the ISRC (a code
     * for identifying single recordings as found on releases) it was
     * developed by the IFPI but it does not appear to be a standard of the
     * ISO.
     *
     * @see <a href="http://purl.org/ontology/mo/grid">grid</a>
     */
    public static final IRI grid;

    /**
     * group
     * <p>
     * {@code http://purl.org/ontology/mo/group}
     * <p>
     * Relates a membership event with the corresponding group
     *
     * @see <a href="http://purl.org/ontology/mo/group">group</a>
     */
    public static final IRI group;

    /**
     * gtin
     * <p>
     * {@code http://purl.org/ontology/mo/gtin}
     * <p>
     * GTIN is a grouping term for EANs and UPCs. In common speech those are
     * called barcodes although the barcodes are just a representation of
     * those identifying numbers.
     *
     * @see <a href="http://purl.org/ontology/mo/gtin">gtin</a>
     */
    public static final IRI gtin;

    /**
     * {@code http://purl.org/ontology/mo/has_track}
     *
     * @see <a href="http://purl.org/ontology/mo/has_track">has_track</a>
     */
    public static final IRI has_track;

    /**
     * headliner
     * <p>
     * {@code http://purl.org/ontology/mo/headliner}
     * <p>
     * Relates a performance to the headliner(s) involved
     *
     * @see <a href="http://purl.org/ontology/mo/headliner">headliner</a>
     */
    public static final IRI headliner;

    /**
     * homepage
     * <p>
     * {@code http://purl.org/ontology/mo/homepage}
     * <p>
     * Links an artist, a record, etc. to a corresponding web page
     *
     * @see <a href="http://purl.org/ontology/mo/homepage">homepage</a>
     */
    public static final IRI homepage;

    /**
     * image
     * <p>
     * {@code http://purl.org/ontology/mo/image}
     * <p>
     * Indicates a pictorial image (JPEG, GIF, PNG, Etc.) of a musical work,
     * the expression of a musical work, the manifestation of a work or the
     * examplar of a manifestation.
     *
     * @see <a href="http://purl.org/ontology/mo/image">image</a>
     */
    public static final IRI image;

    /**
     * imdb
     * <p>
     * {@code http://purl.org/ontology/mo/imdb}
     * <p>
     * Used to link an artist, a musical work or the expression of a musical
     * work to their equivalent page on IMDb, the InternetMovieDatabase.
     *
     * @see <a href="http://purl.org/ontology/mo/imdb">imdb</a>
     */
    public static final IRI imdb;

    /**
     * {@code http://purl.org/ontology/mo/instrument}
     * <p>
     * Relates a performance to a musical instrument involved
     *
     * @see <a href="http://purl.org/ontology/mo/instrument">instrument</a>
     */
    public static final IRI instrument;

    /**
     * Instrument
     * <p>
     * {@code http://purl.org/ontology/mo/Instrument}
     * <p>
     * <p>
     * Any of various devices or contrivances that can be used to
     * produce musical tones or sound.
     * <p>
     * Any taxonomy can be
     * used to subsume this concept. The default one is one extracted by Ivan
     * Herman
     * from the Musicbrainz instrument taxonomy, conforming to
     * SKOS. This concept holds a seeAlso link
     * towards this
     * taxonomy.
     *
     * @see <a href="http://purl.org/ontology/mo/Instrument">Instrument</a>
     */
    public static final IRI Instrument;

    /**
     * instrumentation
     * <p>
     * {@code http://purl.org/ontology/mo/Instrumentation}
     * <p>
     * <p>
     * Instrumentation deals with the techniques of writing music
     * for a specific instrument,
     * including the limitations of the
     * instrument, playing techniques and idiomatic handling of the
     * instrument.
     *
     * @see <a href="http://purl.org/ontology/mo/Instrumentation">Instrumentation</a>
     */
    public static final IRI Instrumentation;

    /**
     * has interpeter
     * <p>
     * {@code http://purl.org/ontology/mo/interpreter}
     * <p>
     * Adds an involved music artist, who interpreted, remixed, or otherwise
     * modified an existing signal, which resulted in the signal that is here
     * the subject of this relation.
     *
     * @see <a href="http://purl.org/ontology/mo/interpreter">interpreter</a>
     */
    public static final IRI interpreter;

    /**
     * interview
     * <p>
     * {@code http://purl.org/ontology/mo/interview}
     * <p>
     * <p>
     * Recording of the questioning of a person.
     * This is a
     * type of MusicalManifestation defined by the musical industry.
     *
     * @see <a href="http://purl.org/ontology/mo/interview">interview</a>
     */
    public static final IRI interview;

    /**
     * ipi
     * <p>
     * {@code http://purl.org/ontology/mo/ipi}
     * <p>
     * The Interested Parties Information Code (IPI) is an ISO standard
     * similar to ISBNs for identifying the people or groups with some
     * involvement with a particular musical work / compositions.
     *
     * @see <a href="http://purl.org/ontology/mo/ipi">ipi</a>
     */
    public static final IRI ipi;

    /**
     * ismn
     * <p>
     * {@code http://purl.org/ontology/mo/ismn}
     * <p>
     * The International Standard Music Number (ISMN) is an ISO standard
     * similar to ISBNs for identifying printed music publications
     *
     * @see <a href="http://purl.org/ontology/mo/ismn">ismn</a>
     */
    public static final IRI ismn;

    /**
     * isrc
     * <p>
     * {@code http://purl.org/ontology/mo/isrc}
     * <p>
     * <p>
     * The ISRC (International Standard Recording Code) is the
     * international identification system for sound recordings and music
     * videorecordings.
     * Each ISRC is a unique and permanent identifier
     * for a specific recording which can be permanently encoded into a
     * product as its digital fingerprint.
     * Encoded ISRC provide the
     * means to automatically identify recordings for royalty payments.
     *
     * @see <a href="http://purl.org/ontology/mo/isrc">isrc</a>
     */
    public static final IRI isrc;

    /**
     * iswc
     * <p>
     * {@code http://purl.org/ontology/mo/iswc}
     * <p>
     * Links a musical work to the corresponding ISWC number
     *
     * @see <a href="http://purl.org/ontology/mo/iswc">iswc</a>
     */
    public static final IRI iswc;

    /**
     * {@code http://purl.org/ontology/mo/item}
     * <p>
     * <p>
     * Relates a musical manifestation to a musical item
     * (this album, and my particular cd) holding the
     * entire
     * manifestation, and not just a part of it.
     *
     * @see <a href="http://purl.org/ontology/mo/item">item</a>
     */
    public static final IRI item;

    /**
     * key
     * <p>
     * {@code http://purl.org/ontology/mo/key}
     * <p>
     * <p>
     * Indicated the key used by the musicians during a performance,
     * or the key of a MusicalWork.
     * Any of 24 major or minor diatonic
     * scales that provide the tonal framework for a piece of music.
     *
     * @see <a href="http://purl.org/ontology/mo/key">key</a>
     */
    public static final IRI key;

    /**
     * label
     * <p>
     * {@code http://purl.org/ontology/mo/Label}
     * <p>
     * Trade name of a company that produces musical works or expression of
     * musical works.
     *
     * @see <a href="http://purl.org/ontology/mo/Label">Label</a>
     */
    public static final IRI Label;

    /**
     * label
     * <p>
     * {@code http://purl.org/ontology/mo/label}
     * <p>
     * Associates a release event with the label releasing the record
     *
     * @see <a href="http://purl.org/ontology/mo/label">label</a>
     */
    public static final IRI label;

    /**
     * lc
     * <p>
     * {@code http://purl.org/ontology/mo/lc}
     * <p>
     * The Label Code (LC) was introduced in 1977 by the IFPI (International
     * Federation of Phonogram and Videogram Industries) in order to
     * unmistakably identify the different record labels (see Introduction,
     * Record labels) for rights purposes. The Label Code consists
     * historically of 4 figures, presently being extended to 5 figures,
     * preceded by LC and a dash (e.g. LC-0193 = Electrola; LC-0233 = His
     * Master&#39;s Voice). Note that the number of countries using the LC is
     * limited, and that the code given on the item is not always accurate.
     *
     * @see <a href="http://purl.org/ontology/mo/lc">lc</a>
     */
    public static final IRI lc;

    /**
     * level
     * <p>
     * {@code http://purl.org/ontology/mo/level}
     * <p>
     * <p>
     * This annotation property associates to a particular Music
     * Ontology term the corresponding
     * expressiveness level. These
     * levels can be:
     * <p>
     * - 1: Only editorial/Musicbrainz type
     * information
     * - 2: Workflow information
     * - 3:
     * Even decomposition
     * <p>
     * This property is mainly used for
     * specification generation.
     *
     * @see <a href="http://purl.org/ontology/mo/level">level</a>
     */
    public static final IRI level;

    /**
     * libretto
     * <p>
     * {@code http://purl.org/ontology/mo/Libretto}
     * <p>
     * <p>
     * Libretto
     *
     * @see <a href="http://purl.org/ontology/mo/Libretto">Libretto</a>
     */
    public static final IRI Libretto;

    /**
     * licence
     * <p>
     * {@code http://purl.org/ontology/mo/licence}
     * <p>
     * Used to link a work or the expression of a work to the license under
     * which they can be manipulated (downloaded, modified, etc).
     * <p>
     * This
     * is usually used to link to a Creative Commons licence.
     *
     * @see <a href="http://purl.org/ontology/mo/licence">licence</a>
     */
    public static final IRI licence;

    /**
     * listened
     * <p>
     * {@code http://purl.org/ontology/mo/listened}
     * <p>
     * Relates agents to the performances they were listening in
     *
     * @see <a href="http://purl.org/ontology/mo/listened">listened</a>
     */
    public static final IRI listened;

    /**
     * {@code http://purl.org/ontology/mo/listener}
     * <p>
     * Relates a performance to the listener involved
     *
     * @see <a href="http://purl.org/ontology/mo/listener">listener</a>
     */
    public static final IRI listener;

    /**
     * listened
     * <p>
     * {@code http://purl.org/ontology/mo/Listener}
     *
     * @see <a href="http://purl.org/ontology/mo/Listener">Listener</a>
     */
    public static final IRI Listener;

    /**
     * live
     * <p>
     * {@code http://purl.org/ontology/mo/live}
     * <p>
     * <p>
     * A musical manifestation that was recorded live.
     * This
     * is a type of MusicalManifestation defined by the musical industry.
     *
     * @see <a href="http://purl.org/ontology/mo/live">live</a>
     */
    public static final IRI live;

    /**
     * lyrics
     * <p>
     * {@code http://purl.org/ontology/mo/Lyrics}
     * <p>
     * <p>
     * Lyrics
     *
     * @see <a href="http://purl.org/ontology/mo/Lyrics">Lyrics</a>
     */
    public static final IRI Lyrics;

    /**
     * lyrics
     * <p>
     * {@code http://purl.org/ontology/mo/lyrics}
     * <p>
     * Associates lyrics with a musical work
     *
     * @see <a href="http://purl.org/ontology/mo/lyrics">lyrics</a>
     */
    public static final IRI lyrics;

    /**
     * MagneticTape
     * <p>
     * {@code http://purl.org/ontology/mo/MagneticTape}
     * <p>
     * Magnetic analogue tape used as medium to record a musical
     * manifestation.
     *
     * @see <a href="http://purl.org/ontology/mo/MagneticTape">MagneticTape</a>
     */
    public static final IRI MagneticTape;

    /**
     * mailorder
     * <p>
     * {@code http://purl.org/ontology/mo/mailorder}
     * <p>
     * Used to link a musical work or the expression of a musical work to a
     * website where people can buy a copy of the musical manifestation.
     *
     * @see <a href="http://purl.org/ontology/mo/mailorder">mailorder</a>
     */
    public static final IRI mailorder;

    /**
     * mashup_of
     * <p>
     * {@code http://purl.org/ontology/mo/mashup_of}
     * <p>
     * Indicates that musical works or the expressions of a musical work were
     * mashed up on this album or track.
     * <p>
     * This means that two musical
     * works or the expressions of a musical work by different artists are
     * mixed together, over each other, or otherwise combined into a single
     * musical work (usually by a third artist, the remixer).
     *
     * @see <a href="http://purl.org/ontology/mo/mashup_of">mashup_of</a>
     */
    public static final IRI mashup_of;

    /**
     * MD
     * <p>
     * {@code http://purl.org/ontology/mo/MD}
     * <p>
     * Mini Disc used as medium to record a musical manifestation.
     *
     * @see <a href="http://purl.org/ontology/mo/MD">MD</a>
     */
    public static final IRI MD;

    /**
     * has media type
     * <p>
     * {@code http://purl.org/ontology/mo/media_type}
     * <p>
     * The mediatype (file format or MIME type, or physical medium) of a
     * musical manifestation, e.g. a MP3, CD or vinyl.
     *
     * @see <a href="http://purl.org/ontology/mo/media_type">media_type</a>
     */
    public static final IRI media_type;

    /**
     * Medium
     * <p>
     * {@code http://purl.org/ontology/mo/Medium}
     * <p>
     * A means or instrumentality for storing or communicating musical
     * manifestation.
     *
     * @see <a href="http://purl.org/ontology/mo/Medium">Medium</a>
     */
    public static final IRI Medium;

    /**
     * medley_of
     * <p>
     * {@code http://purl.org/ontology/mo/medley_of}
     * <p>
     * Indicates that a musical expression is a medley of several other
     * musical expressions.
     * <p>
     * This means that the orignial musical
     * expression were rearranged to create a new musical expression in the
     * form of a medley.
     *
     * @see <a href="http://purl.org/ontology/mo/medley_of">medley_of</a>
     */
    public static final IRI medley_of;

    /**
     * member
     * <p>
     * {@code http://purl.org/ontology/mo/member}
     * <p>
     * <p>
     * Indicates a member of a musical group
     *
     * @see <a href="http://purl.org/ontology/mo/member">member</a>
     */
    public static final IRI member;

    /**
     * member_of
     * <p>
     * {@code http://purl.org/ontology/mo/member_of}
     * <p>
     * Inverse of the foaf:member property
     *
     * @see <a href="http://purl.org/ontology/mo/member_of">member_of</a>
     */
    public static final IRI member_of;

    /**
     * membership
     * <p>
     * {@code http://purl.org/ontology/mo/Membership}
     * <p>
     * A membership event, where one or several people belongs to a group
     * during a particular time period.
     *
     * @see <a href="http://purl.org/ontology/mo/Membership">Membership</a>
     */
    public static final IRI Membership;

    /**
     * membership
     * <p>
     * {@code http://purl.org/ontology/mo/membership}
     * <p>
     * Relates an agent with related membership events
     *
     * @see <a href="http://purl.org/ontology/mo/membership">membership</a>
     */
    public static final IRI membership;

    /**
     * meter
     * <p>
     * {@code http://purl.org/ontology/mo/meter}
     * <p>
     * Associates a musical work or a score with its meter
     *
     * @see <a href="http://purl.org/ontology/mo/meter">meter</a>
     */
    public static final IRI meter;

    /**
     * movement
     * <p>
     * {@code http://purl.org/ontology/mo/Movement}
     * <p>
     * A movement is a self-contained part of a musical work. While
     * individual or selected movements from a composition are sometimes
     * performed separately, a performance of the complete work requires all
     * the movements to be performed in succession.
     * <p>
     * Often a composer
     * attempts to interrelate the movements thematically, or sometimes in
     * more subtle ways, in order that the individual
     * movements exert a
     * cumulative effect. In some forms, composers sometimes link the
     * movements, or ask for them to be played without a
     * pause between them.
     *
     * @see <a href="http://purl.org/ontology/mo/Movement">Movement</a>
     */
    public static final IRI Movement;

    /**
     * has_movement
     * <p>
     * {@code http://purl.org/ontology/mo/movement}
     * <p>
     * Indicates that a musical work has movements
     *
     * @see <a href="http://purl.org/ontology/mo/movement">movement</a>
     */
    public static final IRI movement;

    /**
     * movement number
     * <p>
     * {@code http://purl.org/ontology/mo/movement_number}
     * <p>
     * Indicates the position of a movement in a musical work.
     *
     * @see <a href="http://purl.org/ontology/mo/movement_number">movement_number</a>
     */
    public static final IRI movement_number;

    /**
     * {@code http://purl.org/ontology/mo/movementNum}
     *
     * @see <a href="http://purl.org/ontology/mo/movementNum">movementNum</a>
     */
    public static final IRI movementNum;

    /**
     * musical expression
     * <p>
     * {@code http://purl.org/ontology/mo/MusicalExpression}
     * <p>
     * <p>
     * The intellectual or artistic realization of a work in the form of
     * alpha-numeric, musical, or choreographic notation, sound, etc., or any
     * combination of such forms.
     * <p>
     * <p>
     * For example:
     * <p>
     * Work #1 Franz
     * Schubert&#39;s Trout quintet
     * <p>
     * Expression #1 the composer&#39;s
     * score
     * Expression #2 sound issued from the performance by the
     * Amadeus Quartet and Hephzibah Menuhin on piano
     * Expression #3
     * sound issued from the performance by the Cleveland Quartet and Yo-Yo
     * Ma on the cello
     * . . . .
     * <p>
     * The Music Ontology defines the
     * following sub-concepts of a MusicalExpression, which should be used
     * instead of MusicalExpression itself: Score (the
     * result of an
     * arrangement), Sound (produced during a performance), Signal. However,
     * it is possible to stick to FRBR and bypass the worflow
     * mechanism this
     * ontology defines by using the core FRBR properties on such objects.
     * But it is often better to use events to interconnect such
     * expressions
     * (allowing to go deeply into the production process - `this performer
     * was playing this particular instrument at that
     * particular time&#39;).
     *
     * @see <a href="http://purl.org/ontology/mo/MusicalExpression">MusicalExpression</a>
     */
    public static final IRI MusicalExpression;

    /**
     * MusicalItem
     * <p>
     * {@code http://purl.org/ontology/mo/MusicalItem}
     * <p>
     * A single exemplar of a musical expression.
     * <p>
     * For example, it could
     * be a single exemplar of a CD. This is normally an single object (a CD)
     * possessed by somebody.
     * <p>
     * From the FRBR final report: The entity defined
     * as item is a concrete entity. It is in many instances a single
     * physical object (e.g., a copy of a one-volume monograph, a single
     * audio cassette, etc.). There are instances, however, where the entity
     * defined as item comprises more than one physical object (e.g., a
     * monograph issued as two separately bound volumes, a recording issued
     * on three separate compact discs, etc.).
     * <p>
     * In terms of intellectual
     * content and physical form, an item exemplifying a manifestation is
     * normally the same as the manifestation itself. However, variations may
     * occur from one item to another, even when the items exemplify the same
     * manifestation, where those variations are the result of actions
     * external to the intent of the producer of the manifestation (e.g.,
     * damage occurring after the item was produced, binding performed by a
     * library, etc.).
     *
     * @see <a href="http://purl.org/ontology/mo/MusicalItem">MusicalItem</a>
     */
    public static final IRI MusicalItem;

    /**
     * musical manifestation
     * <p>
     * {@code http://purl.org/ontology/mo/MusicalManifestation}
     * <p>
     * <p>
     * <p>
     * This entity is related to the edition/production/publication of a
     * musical expression (musical manifestation are closely related with the
     * music industry (their terms, concepts, definitions, methods
     * (production, publication, etc.), etc.)
     * <p>
     * From the FRBR final
     * report: The entity defined as manifestation encompasses a wide range
     * of materials, including manuscripts, books, periodicals, maps,
     * posters, sound recordings, films, video recordings, CD-ROMs,
     * multimedia kits, etc. As an entity, manifestation represents all the
     * physical objects that bear the same characteristics, in respect to
     * both intellectual content and physical form.
     * <p>
     * <p>
     * Work #1 J. S.
     * Bach&#39;s Six suites for unaccompanied cello
     * <p>
     * Expression #1
     * sound issued during the performance by Janos Starker recorded in 1963
     * and 1965
     * o Manifestation #1 recordings released on 33 1/3
     * rpm sound discs in 1965 by Mercury
     * o Manifestation #2
     * recordings re-released on compact disc in 1991 by Mercury
     * <p>
     * Expression #2 sound issued during the performances by Yo-Yo Ma
     * recorded in 1983
     * o Manifestation #1 recordings released on
     * 33 1/3 rpm sound discs in 1983 by CBS Records
     * o
     * Manifestation #2 recordings re-released on compact disc in 1992 by CBS
     * Records
     * <p>
     * <p>
     * Changes that occur deliberately or even
     * inadvertently in the production process that affect the copies result,
     * strictly speaking, in a new manifestation. A manifestation resulting
     * from such a change may be identified as a particular &quot;state&quot;
     * or &quot;issue&quot; of the publication.
     * <p>
     * Changes that occur to an
     * individual copy after the production process is complete (e.g., the
     * loss of a page, rebinding, etc.) are not considered to result in a new
     * manifestation. That copy is simply considered to be an exemplar (or
     * item) of the manifestation that deviates from the copy as
     * produced.
     * <p>
     * With the entity defined as manifestation we can describe
     * the physical characteristics of a set of items and the characteristics
     * associated with the production and distribution of that set of items
     * that may be important factors in enabling users to choose a
     * manifestation appropriate to their physical needs and constraints, and
     * to identify and acquire a copy of that manifestation.
     * <p>
     * Defining
     * manifestation as an entity also enables us to draw relationships
     * between specific manifestations of a work. We can use the
     * relationships between manifestations to identify, for example, the
     * specific publication that was used to create a microreproduction.
     *
     * @see <a href="http://purl.org/ontology/mo/MusicalManifestation">MusicalManifestation</a>
     */
    public static final IRI MusicalManifestation;

    /**
     * musical work
     * <p>
     * {@code http://purl.org/ontology/mo/MusicalWork}
     * <p>
     * <p>
     * Distinct intellectual or artistic musical creation.
     * <p>
     * From the
     * FRBR final report: A work is an abstract entity; there is no single
     * material object one can point to as the work. We recognize the work
     * through individual realizations or expressions of the work, but the
     * work itself exists only in the commonality of
     * content between and
     * among the various expressions of the work. When we speak of
     * Homer&#39;s Iliad as a work, our point of reference is not a
     * particular recitation or text of the work, but the intellectual
     * creation that lies behind all the various expressions of the work.
     * <p>
     * <p>
     * For example:
     * <p>
     * work #1 J. S. Bach&#39;s The art of the fugue
     *
     * @see <a href="http://purl.org/ontology/mo/MusicalWork">MusicalWork</a>
     */
    public static final IRI MusicalWork;

    /**
     * music artist
     * <p>
     * {@code http://purl.org/ontology/mo/MusicArtist}
     * <p>
     * <p>
     * A person or a group of people (or a computer :-) ), whose
     * musical
     * creative work shows sensitivity and imagination
     *
     * @see <a href="http://purl.org/ontology/mo/MusicArtist">MusicArtist</a>
     */
    public static final IRI MusicArtist;

    /**
     * musicbrainz
     * <p>
     * {@code http://purl.org/ontology/mo/musicbrainz}
     * <p>
     * <p>
     * Linking an agent, a track or a record to its corresponding
     * Musicbrainz page.
     *
     * @see <a href="http://purl.org/ontology/mo/musicbrainz">musicbrainz</a>
     */
    public static final IRI musicbrainz;

    /**
     * Musicbrainz GUID
     * <p>
     * {@code http://purl.org/ontology/mo/musicbrainz_guid}
     * <p>
     * Links an object to the corresponding Musicbrainz identifier
     *
     * @see <a href="http://purl.org/ontology/mo/musicbrainz_guid">musicbrainz_guid</a>
     */
    public static final IRI musicbrainz_guid;

    /**
     * music group
     * <p>
     * {@code http://purl.org/ontology/mo/MusicGroup}
     * <p>
     * Group of musicians, or musical ensemble, usually popular or folk,
     * playing parts of or improvising off of a musical arrangement.
     *
     * @see <a href="http://purl.org/ontology/mo/MusicGroup">MusicGroup</a>
     */
    public static final IRI MusicGroup;

    /**
     * musicmoz
     * <p>
     * {@code http://purl.org/ontology/mo/musicmoz}
     * <p>
     * Used to link an artist, a musical work or the expression of a musical
     * work to its corresponding MusicMoz page.
     *
     * @see <a href="http://purl.org/ontology/mo/musicmoz">musicmoz</a>
     */
    public static final IRI musicmoz;

    /**
     * myspace
     * <p>
     * {@code http://purl.org/ontology/mo/myspace}
     * <p>
     * Used to link a person to its corresponding MySpace page.
     *
     * @see <a href="http://purl.org/ontology/mo/myspace">myspace</a>
     */
    public static final IRI myspace;

    /**
     * official
     * <p>
     * {@code http://purl.org/ontology/mo/official}
     * <p>
     * Any musical work or the expression of a musical work officially
     * sanctioned by the artist and/or their corporate body.
     *
     * @see <a href="http://purl.org/ontology/mo/official">official</a>
     */
    public static final IRI official;

    /**
     * olga
     * <p>
     * {@code http://purl.org/ontology/mo/olga}
     * <p>
     * Used to link a track to a tabulature file for track in the On-Line
     * Guitar Archive.
     *
     * @see <a href="http://purl.org/ontology/mo/olga">olga</a>
     */
    public static final IRI olga;

    /**
     * onlinecommunity
     * <p>
     * {@code http://purl.org/ontology/mo/onlinecommunity}
     * <p>
     * Used to link a person with an online community web page like a blog, a
     * wiki, a forum, a livejournal page, Etc.
     *
     * @see <a href="http://purl.org/ontology/mo/onlinecommunity">onlinecommunity</a>
     */
    public static final IRI onlinecommunity;

    /**
     * opus
     * <p>
     * {@code http://purl.org/ontology/mo/opus}
     * <p>
     * <p>
     * Used to define a creative work, especially a musical
     * composition numbered to designate the order of a composer&#39;s
     * works.
     *
     * @see <a href="http://purl.org/ontology/mo/opus">opus</a>
     */
    public static final IRI opus;

    /**
     * orchestration
     * <p>
     * {@code http://purl.org/ontology/mo/Orchestration}
     * <p>
     * <p>
     * Orchestration includes, in addition to instrumentation,
     * the handling of groups of instruments and their balance and
     * interaction.
     *
     * @see <a href="http://purl.org/ontology/mo/Orchestration">Orchestration</a>
     */
    public static final IRI Orchestration;

    /**
     * origin
     * <p>
     * {@code http://purl.org/ontology/mo/origin}
     * <p>
     * Relates an artist to its geographic origin
     *
     * @see <a href="http://purl.org/ontology/mo/origin">origin</a>
     */
    public static final IRI origin;

    /**
     * other_release_of
     * <p>
     * {@code http://purl.org/ontology/mo/other_release_of}
     * <p>
     * Indicates that two musical manifestations are essentially the same.
     *
     * @see <a href="http://purl.org/ontology/mo/other_release_of">other_release_of</a>
     */
    public static final IRI other_release_of;

    /**
     * paid download
     * <p>
     * {@code http://purl.org/ontology/mo/paid_download}
     * <p>
     * <p>
     * Provide a link from an artist to a web page where all
     * of that artist&#39;s musical work is available for some money,
     * <p>
     * or a link from a manifestation (record/track, for example) to a web
     * page providing a paid access to this manifestation.
     *
     * @see <a href="http://purl.org/ontology/mo/paid_download">paid_download</a>
     */
    public static final IRI paid_download;

    /**
     * {@code http://purl.org/ontology/mo/paiddownload}
     *
     * @see <a href="http://purl.org/ontology/mo/paiddownload">paiddownload</a>
     */
    public static final IRI paiddownload;

    /**
     * performance
     * <p>
     * {@code http://purl.org/ontology/mo/Performance}
     * <p>
     * <p>
     * A performance event.
     * It might include as agents
     * performers, engineers, conductors, or even listeners.
     * It might
     * include as factors a score, a MusicalWork, musical instruments.
     * <p>
     * It might produce a sound:-)
     *
     * @see <a href="http://purl.org/ontology/mo/Performance">Performance</a>
     */
    public static final IRI Performance;

    /**
     * performance of
     * <p>
     * {@code http://purl.org/ontology/mo/performance_of}
     * <p>
     * <p>
     * Associates a Performance to a musical work or an arrangement
     * that is being used as a factor in it.
     * For example, I might use
     * this property to attach the Magic Flute musical work to
     * a
     * particular Performance.
     *
     * @see <a href="http://purl.org/ontology/mo/performance_of">performance_of</a>
     */
    public static final IRI performance_of;

    /**
     * performed
     * <p>
     * {@code http://purl.org/ontology/mo/performed}
     * <p>
     * Relates agents to the performances they were performing in
     *
     * @see <a href="http://purl.org/ontology/mo/performed">performed</a>
     */
    public static final IRI performed;

    /**
     * performed in
     * <p>
     * {@code http://purl.org/ontology/mo/performed_in}
     * <p>
     * <p>
     * Associates a Musical Work or an Score to Performances in
     * which they were
     * a factor. For example, I might use this
     * property in order to
     * associate the Magic Flute to a
     * particular performance at the Opera
     * Bastille last year.
     *
     * @see <a href="http://purl.org/ontology/mo/performed_in">performed_in</a>
     */
    public static final IRI performed_in;

    /**
     * {@code http://purl.org/ontology/mo/performer}
     * <p>
     * Relates a performance to the performers involved
     *
     * @see <a href="http://purl.org/ontology/mo/performer">performer</a>
     */
    public static final IRI performer;

    /**
     * performer
     * <p>
     * {@code http://purl.org/ontology/mo/Performer}
     *
     * @see <a href="http://purl.org/ontology/mo/Performer">Performer</a>
     */
    public static final IRI Performer;

    /**
     * possess_item
     * <p>
     * {@code http://purl.org/ontology/mo/possess_item}
     * <p>
     * A person, a group of person or an organization possessing an exemplar
     * of a single manifestation.
     *
     * @see <a href="http://purl.org/ontology/mo/possess_item">possess_item</a>
     */
    public static final IRI possess_item;

    /**
     * {@code http://purl.org/ontology/mo/preview}
     * <p>
     * <p>
     * Relates a musical manifestation to a musical item
     * (this album, and my particular cd), which holds
     * a
     * preview of the manifestation (eg. one track for an album, or a snippet
     * for a track)
     *
     * @see <a href="http://purl.org/ontology/mo/preview">preview</a>
     */
    public static final IRI preview;

    /**
     * preview download
     * <p>
     * {@code http://purl.org/ontology/mo/preview_download}
     * <p>
     * <p>
     * This property can be used to link from a person to
     * the website where they make previews of their works available, or
     * from
     * a manifestation (a track or an album, for
     * example) to a web page where a preview download is available.
     * <p>
     * <p>
     * This property MUST be used only if the content is just available
     * through a web page (holding, for example
     * a Flash
     * application) - it is better to link to actual content directly through
     * the use of mo:available_as and
     * mo:Stream, mo:Torrent
     * or mo:ED2K, etc. Therefore, Semantic Web user agents that don&#39;t
     * know how to read HTML and even
     * less to rip streams
     * from Flash applications can still access the audio content.
     *
     * @see <a href="http://purl.org/ontology/mo/preview_download">preview_download</a>
     */
    public static final IRI preview_download;

    /**
     * primary instrument
     * <p>
     * {@code http://purl.org/ontology/mo/primary_instrument}
     * <p>
     * Indicates that an artist primarily plays an instrument, or that a
     * member was primarily playing a particular instrument during his
     * membership
     *
     * @see <a href="http://purl.org/ontology/mo/primary_instrument">primary_instrument</a>
     */
    public static final IRI primary_instrument;

    /**
     * produced
     * <p>
     * {@code http://purl.org/ontology/mo/produced}
     * <p>
     * Used to relate an person or a group of person who produced the
     * manifestation of a work.
     *
     * @see <a href="http://purl.org/ontology/mo/produced">produced</a>
     */
    public static final IRI produced;

    /**
     * produced score
     * <p>
     * {@code http://purl.org/ontology/mo/produced_score}
     * <p>
     * <p>
     * Associates an arrangement or a composition event to a score
     * product (score here does not refer to a published score, but more
     * <p>
     * an abstract arrangement of a particular work).
     *
     * @see <a href="http://purl.org/ontology/mo/produced_score">produced_score</a>
     */
    public static final IRI produced_score;

    /**
     * produced signal
     * <p>
     * {@code http://purl.org/ontology/mo/produced_signal}
     * <p>
     * <p>
     * Associates a Recording to the outputted signal.
     *
     * @see <a href="http://purl.org/ontology/mo/produced_signal">produced_signal</a>
     */
    public static final IRI produced_signal;

    /**
     * produced signal group
     * <p>
     * {@code http://purl.org/ontology/mo/produced_signal_group}
     * <p>
     * Associates a recording session with a group of master signals produced
     * by it.
     *
     * @see <a href="http://purl.org/ontology/mo/produced_signal_group">produced_signal_group</a>
     */
    public static final IRI produced_signal_group;

    /**
     * produced sound
     * <p>
     * {@code http://purl.org/ontology/mo/produced_sound}
     * <p>
     * <p>
     * Associates a Performance to a physical Sound that is
     * being produced by it.
     *
     * @see <a href="http://purl.org/ontology/mo/produced_sound">produced_sound</a>
     */
    public static final IRI produced_sound;

    /**
     * produced work
     * <p>
     * {@code http://purl.org/ontology/mo/produced_work}
     * <p>
     * <p>
     * Associates a composition event to the produced
     * MusicalWork. For example,
     * this property could link the
     * event corresponding to the composition of the
     * Magic
     * Flute in 1782 to the Magic Flute musical work itself. This musical
     * work
     * can then be used in particular performances.
     *
     * @see <a href="http://purl.org/ontology/mo/produced_work">produced_work</a>
     */
    public static final IRI produced_work;

    /**
     * producer
     * <p>
     * {@code http://purl.org/ontology/mo/producer}
     * <p>
     * Used to relate the manifestation of a work to a person or a group of
     * person who produced it.
     *
     * @see <a href="http://purl.org/ontology/mo/producer">producer</a>
     */
    public static final IRI producer;

    /**
     * {@code http://purl.org/ontology/mo/producesSignal}
     *
     * @see <a href="http://purl.org/ontology/mo/producesSignal">producesSignal</a>
     */
    public static final IRI producesSignal;

    /**
     * {@code http://purl.org/ontology/mo/producesSound}
     *
     * @see <a href="http://purl.org/ontology/mo/producesSound">producesSound</a>
     */
    public static final IRI producesSound;

    /**
     * {@code http://purl.org/ontology/mo/producesWork}
     *
     * @see <a href="http://purl.org/ontology/mo/producesWork">producesWork</a>
     */
    public static final IRI producesWork;

    /**
     * {@code http://purl.org/ontology/mo/productOfComposition}
     *
     * @see <a href="http://purl.org/ontology/mo/productOfComposition">productOfComposition</a>
     */
    public static final IRI productOfComposition;

    /**
     * promotion
     * <p>
     * {@code http://purl.org/ontology/mo/promotion}
     * <p>
     * A giveaway musical work or the expression of a musical work intended
     * to promote an upcoming official musical work or the expression of a
     * musical work.
     *
     * @see <a href="http://purl.org/ontology/mo/promotion">promotion</a>
     */
    public static final IRI promotion;

    /**
     * publication of
     * <p>
     * {@code http://purl.org/ontology/mo/publication_of}
     * <p>
     * Link a particular manifestation to the related signal, score,
     * libretto, or lyrics
     *
     * @see <a href="http://purl.org/ontology/mo/publication_of">publication_of</a>
     */
    public static final IRI publication_of;

    /**
     * {@code http://purl.org/ontology/mo/publicationOf}
     *
     * @see <a href="http://purl.org/ontology/mo/publicationOf">publicationOf</a>
     */
    public static final IRI publicationOf;

    /**
     * published
     * <p>
     * {@code http://purl.org/ontology/mo/published}
     * <p>
     * Used to relate an person or a group of person who published the
     * manifestation of a work.
     *
     * @see <a href="http://purl.org/ontology/mo/published">published</a>
     */
    public static final IRI published;

    /**
     * published as
     * <p>
     * {@code http://purl.org/ontology/mo/published_as}
     * <p>
     * <p>
     * Links a musical expression (e.g. a signal or a score) to one
     * of its manifestations (e.g. a track on a particular record or a
     * published score).
     *
     * @see <a href="http://purl.org/ontology/mo/published_as">published_as</a>
     */
    public static final IRI published_as;

    /**
     * {@code http://purl.org/ontology/mo/publishedAs}
     *
     * @see <a href="http://purl.org/ontology/mo/publishedAs">publishedAs</a>
     */
    public static final IRI publishedAs;

    /**
     * published libretto
     * <p>
     * {@code http://purl.org/ontology/mo/PublishedLibretto}
     * <p>
     * A published libretto
     *
     * @see <a href="http://purl.org/ontology/mo/PublishedLibretto">PublishedLibretto</a>
     */
    public static final IRI PublishedLibretto;

    /**
     * published lyrics
     * <p>
     * {@code http://purl.org/ontology/mo/PublishedLyrics}
     * <p>
     * Published lyrics, as a book or as a text file, for example
     *
     * @see <a href="http://purl.org/ontology/mo/PublishedLyrics">PublishedLyrics</a>
     */
    public static final IRI PublishedLyrics;

    /**
     * published score
     * <p>
     * {@code http://purl.org/ontology/mo/PublishedScore}
     * <p>
     * A published score (subclass of MusicalManifestation)
     *
     * @see <a href="http://purl.org/ontology/mo/PublishedScore">PublishedScore</a>
     */
    public static final IRI PublishedScore;

    /**
     * publisher
     * <p>
     * {@code http://purl.org/ontology/mo/publisher}
     * <p>
     * Used to relate a musical manifestation to a person or a group of
     * person who published it.
     *
     * @see <a href="http://purl.org/ontology/mo/publisher">publisher</a>
     */
    public static final IRI publisher;

    /**
     * publishingLocation
     * <p>
     * {@code http://purl.org/ontology/mo/publishing_location}
     * <p>
     * <p>
     * Relates a musical manifestation to its publication location.
     *
     * @see <a href="http://purl.org/ontology/mo/publishing_location">publishing_location</a>
     */
    public static final IRI publishing_location;

    /**
     * {@code http://purl.org/ontology/mo/publishingLocation}
     *
     * @see <a href="http://purl.org/ontology/mo/publishingLocation">publishingLocation</a>
     */
    public static final IRI publishingLocation;

    /**
     * puid
     * <p>
     * {@code http://purl.org/ontology/mo/puid}
     * <p>
     * <p>
     * Link a signal to the PUIDs associated with it, that is, PUID
     * computed from MusicalItems (mo:AudioFile)
     * derived from this
     * signal.
     * PUIDs (Portable Unique IDentifier) are the IDs used in
     * the
     * proprietary MusicDNS AudioFingerprinting system which is
     * operated by MusicIP.
     * <p>
     * Using PUIDs, one (with some luck) can
     * identify the Signal object associated with a particular audio file,
     * therefore allowing
     * to access further information (on which
     * release this track is featured? etc.). Using some more metadata one
     * can identify
     * the particular Track corresponding to the audio
     * file (a track on a particular release).
     *
     * @see <a href="http://purl.org/ontology/mo/puid">puid</a>
     */
    public static final IRI puid;

    /**
     * released record
     * <p>
     * {@code http://purl.org/ontology/mo/record}
     * <p>
     * Associates a release with the records it contains. A single release
     * can be associated with multiple records, for example for a multi-disc
     * release.
     *
     * @see <a href="http://purl.org/ontology/mo/record">record</a>
     */
    public static final IRI record;

    /**
     * record
     * <p>
     * {@code http://purl.org/ontology/mo/Record}
     * <p>
     * A published record (manifestation which first aim is to render the
     * product of a recording)
     *
     * @see <a href="http://purl.org/ontology/mo/Record">Record</a>
     */
    public static final IRI Record;

    /**
     * record count
     * <p>
     * {@code http://purl.org/ontology/mo/record_count}
     * <p>
     * Associates a release with the number of records it contains, e.g. the
     * number of discs it contains in the case of a multi-disc release.
     *
     * @see <a href="http://purl.org/ontology/mo/record_count">record_count</a>
     */
    public static final IRI record_count;

    /**
     * has record number
     * <p>
     * {@code http://purl.org/ontology/mo/record_number}
     * <p>
     * Indicates the position of a record in a release (e.g. a 2xLP, etc.).
     *
     * @see <a href="http://purl.org/ontology/mo/record_number">record_number</a>
     */
    public static final IRI record_number;

    /**
     * has record side
     * <p>
     * {@code http://purl.org/ontology/mo/record_side}
     * <p>
     * Associates the side on a vinyl record, where a track is located, e.g.
     * A, B, C, etc. This property can then also be used
     * in conjunction with
     * mo:track_number, so that one can infer e.g. &quot;A1&quot;, that
     * means, track number 1 on side A.
     *
     * @see <a href="http://purl.org/ontology/mo/record_side">record_side</a>
     */
    public static final IRI record_side;

    /**
     * recorded as
     * <p>
     * {@code http://purl.org/ontology/mo/recorded_as}
     * <p>
     * <p>
     * This is a shortcut property, allowing to bypass all the
     * Sound/Recording steps. This property
     * allows to directly link a
     * Performance to the recorded Signal. This is recommended for
     * &quot;normal&quot;
     * users. However, advanced users wanting to
     * express things such as the location of the microphone will
     * <p>
     * have to create this shortcut as well as the whole workflow, in order
     * to let the &quot;normal&quot; users access
     * simply the, well,
     * simple information:-) .
     *
     * @see <a href="http://purl.org/ontology/mo/recorded_as">recorded_as</a>
     */
    public static final IRI recorded_as;

    /**
     * recorded in
     * <p>
     * {@code http://purl.org/ontology/mo/recorded_in}
     * <p>
     * <p>
     * Associates a physical Sound to a Recording event where it
     * is being used
     * in order to produce a signal. For example, I
     * might use this property to
     * associate the sound produced by a
     * particular performance of the magic flute
     * to a given
     * recording, done using my cell-phone.
     *
     * @see <a href="http://purl.org/ontology/mo/recorded_in">recorded_in</a>
     */
    public static final IRI recorded_in;

    /**
     * {@code http://purl.org/ontology/mo/recordedAs}
     *
     * @see <a href="http://purl.org/ontology/mo/recordedAs">recordedAs</a>
     */
    public static final IRI recordedAs;

    /**
     * recording
     * <p>
     * {@code http://purl.org/ontology/mo/Recording}
     * <p>
     * <p>
     * A recording event.
     * Takes a sound as a factor to
     * produce a signal (analog or digital).
     * The location of such
     * events (if any) is the actual location of the corresponding
     * <p>
     * microphone or the &quot;recording device&quot;.
     *
     * @see <a href="http://purl.org/ontology/mo/Recording">Recording</a>
     */
    public static final IRI Recording;

    /**
     * recorded sound
     * <p>
     * {@code http://purl.org/ontology/mo/recording_of}
     * <p>
     * <p>
     * Associates a Recording event to a physical Sound being
     * recorded.
     * For example, I might use this property to
     * <p>
     * associate a given recording, done using my cell phone, to the
     * <p>
     * sound produced by a particular performance of the magic flute.
     *
     * @see <a href="http://purl.org/ontology/mo/recording_of">recording_of</a>
     */
    public static final IRI recording_of;

    /**
     * recording session
     * <p>
     * {@code http://purl.org/ontology/mo/RecordingSession}
     * <p>
     * A set of performances/recordings/mastering events. This event can be
     * decomposed in its constituent events using event:sub_event
     *
     * @see <a href="http://purl.org/ontology/mo/RecordingSession">RecordingSession</a>
     */
    public static final IRI RecordingSession;

    /**
     * records
     * <p>
     * {@code http://purl.org/ontology/mo/records}
     * <p>
     * <p>
     * This is the inverse of the shortcut property recordedAs,
     * allowing to relate directly a performance
     * to a signal.
     *
     * @see <a href="http://purl.org/ontology/mo/records">records</a>
     */
    public static final IRI records;

    /**
     * release
     * <p>
     * {@code http://purl.org/ontology/mo/release}
     * <p>
     * Associates a release with the corresponding release event
     *
     * @see <a href="http://purl.org/ontology/mo/release">release</a>
     */
    public static final IRI release;

    /**
     * release
     * <p>
     * {@code http://purl.org/ontology/mo/Release}
     * <p>
     * A specific release, with barcode, box, liner notes, cover art, and a
     * number of records
     *
     * @see <a href="http://purl.org/ontology/mo/Release">Release</a>
     */
    public static final IRI Release;

    /**
     * {@code http://purl.org/ontology/mo/release_status}
     * <p>
     * <p>
     * Relates a musical manifestation to its release status
     * (bootleg, ...)
     *
     * @see <a href="http://purl.org/ontology/mo/release_status">release_status</a>
     */
    public static final IRI release_status;

    /**
     * {@code http://purl.org/ontology/mo/release_type}
     * <p>
     * <p>
     * Relates a musical manifestation to its release type
     * (interview, spoken word, album, ...)
     *
     * @see <a href="http://purl.org/ontology/mo/release_type">release_type</a>
     */
    public static final IRI release_type;

    /**
     * release event
     * <p>
     * {@code http://purl.org/ontology/mo/ReleaseEvent}
     * <p>
     * A release event, in a particular place (e.g. a country) at a
     * particular time. Other factors of this event might include cover art,
     * liner notes, box, etc. or a release grouping all these.
     *
     * @see <a href="http://purl.org/ontology/mo/ReleaseEvent">ReleaseEvent</a>
     */
    public static final IRI ReleaseEvent;

    /**
     * {@code http://purl.org/ontology/mo/releaseStatus}
     *
     * @see <a href="http://purl.org/ontology/mo/releaseStatus">releaseStatus</a>
     */
    public static final IRI releaseStatus;

    /**
     * release status
     * <p>
     * {@code http://purl.org/ontology/mo/ReleaseStatus}
     * <p>
     * Musical manifestation release status.
     *
     * @see <a href="http://purl.org/ontology/mo/ReleaseStatus">ReleaseStatus</a>
     */
    public static final IRI ReleaseStatus;

    /**
     * {@code http://purl.org/ontology/mo/releaseType}
     *
     * @see <a href="http://purl.org/ontology/mo/releaseType">releaseType</a>
     */
    public static final IRI releaseType;

    /**
     * Release type
     * <p>
     * {@code http://purl.org/ontology/mo/ReleaseType}
     * <p>
     * <p>
     * Release type of a particular manifestation, such as
     * &quot;album&quot; or &quot;interview&quot;...
     *
     * @see <a href="http://purl.org/ontology/mo/ReleaseType">ReleaseType</a>
     */
    public static final IRI ReleaseType;

    /**
     * remaster_of
     * <p>
     * {@code http://purl.org/ontology/mo/remaster_of}
     * <p>
     * This relates two musical work or the expression of a musical work,
     * where one is a remaster of the other.
     * <p>
     * A remaster is a new
     * version made for release from source recordings that were earlier
     * released separately. This is usually done to improve the audio quality
     * or adjust for more modern playback equipment. The process generally
     * doesn&#39;t involve changing the music in any artistically important
     * way. It may, however, result in tracks that are a few seconds longer
     * or shorter.
     *
     * @see <a href="http://purl.org/ontology/mo/remaster_of">remaster_of</a>
     */
    public static final IRI remaster_of;

    /**
     * remix
     * <p>
     * {@code http://purl.org/ontology/mo/remix}
     * <p>
     * <p>
     * Musical manifestation that primarily contains remixed
     * material.
     * This is a type of MusicalManifestation defined by
     * the musical industry.
     *
     * @see <a href="http://purl.org/ontology/mo/remix">remix</a>
     */
    public static final IRI remix;

    /**
     * remix_of
     * <p>
     * {@code http://purl.org/ontology/mo/remix_of}
     * <p>
     * Used to relate the remix of a musical work in a substantially altered
     * version produced by mixing together individual tracks or segments of
     * an original musical source work.
     *
     * @see <a href="http://purl.org/ontology/mo/remix_of">remix_of</a>
     */
    public static final IRI remix_of;

    /**
     * remixed
     * <p>
     * {@code http://purl.org/ontology/mo/remixed}
     * <p>
     * Used to relate an artist who remixed a musical work or the expression
     * of a musical work.
     * <p>
     * This involves taking just one other musical
     * work and using audio editing to make it sound like a significantly
     * different, but usually still recognisable, song. It can be used to
     * link an artist to a single song that they remixed, or, if they remixed
     * an entire musical work.
     *
     * @see <a href="http://purl.org/ontology/mo/remixed">remixed</a>
     */
    public static final IRI remixed;

    /**
     * remixer
     * <p>
     * {@code http://purl.org/ontology/mo/remixer}
     * <p>
     * Used to relate a musical work or the expression of a musical work to
     * an artist who remixed it.
     * <p>
     * This involves taking just one other
     * musical work and using audio editing to make it sound like a
     * significantly different, but usually still recognisable, song. It can
     * be used to link an artist to a single song that they remixed, or, if
     * they remixed an entire musical work.
     *
     * @see <a href="http://purl.org/ontology/mo/remixer">remixer</a>
     */
    public static final IRI remixer;

    /**
     * review
     * <p>
     * {@code http://purl.org/ontology/mo/review}
     * <p>
     * Used to link a work or the expression of a work to a review.
     * <p>
     * The
     * review does not have to be open content, as long as it is accessible
     * to the general internet population.
     *
     * @see <a href="http://purl.org/ontology/mo/review">review</a>
     */
    public static final IRI review;

    /**
     * SACD
     * <p>
     * {@code http://purl.org/ontology/mo/SACD}
     * <p>
     * Super Audio Compact Disc used as medium to record a musical
     * manifestation.
     *
     * @see <a href="http://purl.org/ontology/mo/SACD">SACD</a>
     */
    public static final IRI SACD;

    /**
     * {@code http://purl.org/ontology/mo/sample_rate}
     * <p>
     * <p>
     * Associates a digital signal to its sample rate. It might be
     * easier to express it this way instead of
     * defining a timeline
     * map:-) Range is xsd:float.
     *
     * @see <a href="http://purl.org/ontology/mo/sample_rate">sample_rate</a>
     */
    public static final IRI sample_rate;

    /**
     * sampled
     * <p>
     * {@code http://purl.org/ontology/mo/sampled}
     * <p>
     * Used to relate an artist who sampled a Signal.
     *
     * @see <a href="http://purl.org/ontology/mo/sampled">sampled</a>
     */
    public static final IRI sampled;

    /**
     * sampled version
     * <p>
     * {@code http://purl.org/ontology/mo/sampled_version}
     * <p>
     * <p>
     * Associates an analog signal with a sampled version of it
     *
     * @see <a href="http://purl.org/ontology/mo/sampled_version">sampled_version</a>
     */
    public static final IRI sampled_version;

    /**
     * sampled version of
     * <p>
     * {@code http://purl.org/ontology/mo/sampled_version_of}
     * <p>
     * <p>
     * Associates a digital signal with the analog version of it
     *
     * @see <a href="http://purl.org/ontology/mo/sampled_version_of">sampled_version_of</a>
     */
    public static final IRI sampled_version_of;

    /**
     * {@code http://purl.org/ontology/mo/sampledVersionOf}
     *
     * @see <a href="http://purl.org/ontology/mo/sampledVersionOf">sampledVersionOf</a>
     */
    public static final IRI sampledVersionOf;

    /**
     * sampler
     * <p>
     * {@code http://purl.org/ontology/mo/sampler}
     * <p>
     * Used to relate the signal of a musical work to an artist who sampled
     * it.
     *
     * @see <a href="http://purl.org/ontology/mo/sampler">sampler</a>
     */
    public static final IRI sampler;

    /**
     * {@code http://purl.org/ontology/mo/sampleRate}
     *
     * @see <a href="http://purl.org/ontology/mo/sampleRate">sampleRate</a>
     */
    public static final IRI sampleRate;

    /**
     * score
     * <p>
     * {@code http://purl.org/ontology/mo/Score}
     * <p>
     * <p>
     * Here, we are dealing with the informational object (the
     * MusicalExpression), not the actually &quot;published&quot; score.
     * <p>
     * This may be, for example, the product of an arrangement process.
     *
     * @see <a href="http://purl.org/ontology/mo/Score">Score</a>
     */
    public static final IRI Score;

    /**
     * sell_item
     * <p>
     * {@code http://purl.org/ontology/mo/sell_item}
     * <p>
     * A person, a group of person or an organization selling an exemplar of
     * a single manifestation.
     *
     * @see <a href="http://purl.org/ontology/mo/sell_item">sell_item</a>
     */
    public static final IRI sell_item;

    /**
     * Show
     * <p>
     * {@code http://purl.org/ontology/mo/Show}
     * <p>
     * <p>
     * A show - a musical event lasting several days, in a
     * particular venue. Examples can be
     * &quot;The Magic Flute&quot;
     * at the Opera Bastille, August 2005, or a musical in the west end...
     *
     * @see <a href="http://purl.org/ontology/mo/Show">Show</a>
     */
    public static final IRI Show;

    /**
     * signal
     * <p>
     * {@code http://purl.org/ontology/mo/signal}
     * <p>
     * Associates a group of signals with one of the signals it contains
     *
     * @see <a href="http://purl.org/ontology/mo/signal">signal</a>
     */
    public static final IRI signal;

    /**
     * signal
     * <p>
     * {@code http://purl.org/ontology/mo/Signal}
     * <p>
     * <p>
     * A subclass of MusicalExpression, representing a signal, for
     * example a master signal produced by a performance and a recording.
     *
     * @see <a href="http://purl.org/ontology/mo/Signal">Signal</a>
     */
    public static final IRI Signal;

    /**
     * signal group
     * <p>
     * {@code http://purl.org/ontology/mo/SignalGroup}
     * <p>
     * <p>
     * A musical expression representing a group of signals, for
     * example a set of masters resulting from a whole recording/mastering
     * session.
     *
     * @see <a href="http://purl.org/ontology/mo/SignalGroup">SignalGroup</a>
     */
    public static final IRI SignalGroup;

    /**
     * {@code http://purl.org/ontology/mo/signalTime}
     *
     * @see <a href="http://purl.org/ontology/mo/signalTime">signalTime</a>
     */
    public static final IRI signalTime;

    /**
     * similar_to
     * <p>
     * {@code http://purl.org/ontology/mo/similar_to}
     * <p>
     * <p>
     * A similarity relationships between two objects (so far,
     * either an agent, a signal or a genre, but
     * this could grow).
     * <p>
     * This relationship is pretty general and doesn&#39;t make any
     * assumptions on how the similarity claim
     * was derived.
     * <p>
     * Such similarity statements can come from a range of different sources
     * (Musicbrainz similarities between
     * artists, or coming from some
     * automatic content analysis).
     * However, the origin of such
     * statements should be kept using a named graph approach - and
     * ultimately, the
     * documents providing such statements should
     * attach some metadata to themselves (confidence of the claim, etc.).
     *
     * @see <a href="http://purl.org/ontology/mo/similar_to">similar_to</a>
     */
    public static final IRI similar_to;

    /**
     * {@code http://purl.org/ontology/mo/singer}
     * <p>
     * Relates a performance to an involved singer
     *
     * @see <a href="http://purl.org/ontology/mo/singer">singer</a>
     */
    public static final IRI singer;

    /**
     * single
     * <p>
     * {@code http://purl.org/ontology/mo/single}
     * <p>
     * A single or record single is a type of release, typically a recording
     * of two tracks. In most cases, the single is a song that is released
     * separately from an album, but it can still appear on an album.
     *
     * @see <a href="http://purl.org/ontology/mo/single">single</a>
     */
    public static final IRI single;

    /**
     * solo music artist
     * <p>
     * {@code http://purl.org/ontology/mo/SoloMusicArtist}
     * <p>
     * Single person whose musical creative work shows sensitivity and
     * imagination.
     *
     * @see <a href="http://purl.org/ontology/mo/SoloMusicArtist">SoloMusicArtist</a>
     */
    public static final IRI SoloMusicArtist;

    /**
     * sound
     * <p>
     * {@code http://purl.org/ontology/mo/Sound}
     * <p>
     * <p>
     * A subclass of MusicalExpression, representing a sound.
     * Realisation of a MusicalWork during a musical Performance.
     *
     * @see <a href="http://purl.org/ontology/mo/Sound">Sound</a>
     */
    public static final IRI Sound;

    /**
     * sound engineer
     * <p>
     * {@code http://purl.org/ontology/mo/SoundEngineer}
     *
     * @see <a href="http://purl.org/ontology/mo/SoundEngineer">SoundEngineer</a>
     */
    public static final IRI SoundEngineer;

    /**
     * soundtrack
     * <p>
     * {@code http://purl.org/ontology/mo/soundtrack}
     * <p>
     * <p>
     * Sound recording on a narrow strip of a motion picture film.
     * <p>
     * This is a type of MusicalManifestation defined by the musical
     * industry.
     *
     * @see <a href="http://purl.org/ontology/mo/soundtrack">soundtrack</a>
     */
    public static final IRI soundtrack;

    /**
     * spoken word
     * <p>
     * {@code http://purl.org/ontology/mo/spokenword}
     * <p>
     * <p>
     * Spoken word is a form of music or artistic performance in
     * which lyrics, poetry, or stories are spoken rather than sung.
     * <p>
     * Spoken-word is often done with a musical background, but emphasis is
     * kept on the speaker.
     * This is a type of MusicalManifestation
     * defined by the musical industry.
     *
     * @see <a href="http://purl.org/ontology/mo/spokenword">spokenword</a>
     */
    public static final IRI spokenword;

    /**
     * Stream
     * <p>
     * {@code http://purl.org/ontology/mo/Stream}
     * <p>
     * Transmission over a network  used as medium to broadcast a musical
     * manifestation
     *
     * @see <a href="http://purl.org/ontology/mo/Stream">Stream</a>
     */
    public static final IRI Stream;

    /**
     * supporting_musician
     * <p>
     * {@code http://purl.org/ontology/mo/supporting_musician}
     * <p>
     * Used to relate an artist doing long-time instrumental or vocal support
     * for another artist.
     *
     * @see <a href="http://purl.org/ontology/mo/supporting_musician">supporting_musician</a>
     */
    public static final IRI supporting_musician;

    /**
     * tempo
     * <p>
     * {@code http://purl.org/ontology/mo/tempo}
     * <p>
     * <p>
     * Rate of speed or pace of music. Tempo markings are
     * traditionally given in Italian;
     * common markings include:
     * grave (solemn; very, very slow); largo (broad; very slow);
     * <p>
     * adagio (quite slow); andante (a walking pace); moderato (moderate);
     * allegro (fast; cheerful);
     * vivace (lively); presto (very
     * fast); accelerando (getting faster); ritardando (getting slower);
     * <p>
     * and a tempo (in time; returning to the original pace).
     *
     * @see <a href="http://purl.org/ontology/mo/tempo">tempo</a>
     */
    public static final IRI tempo;

    /**
     * text
     * <p>
     * {@code http://purl.org/ontology/mo/text}
     * <p>
     * Associates lyrics with their text.
     *
     * @see <a href="http://purl.org/ontology/mo/text">text</a>
     */
    public static final IRI text;

    /**
     * time
     * <p>
     * {@code http://purl.org/ontology/mo/time}
     * <p>
     * <p>
     * Associates a Signal to a time object - its actual domain
     *
     * @see <a href="http://purl.org/ontology/mo/time">time</a>
     */
    public static final IRI time;

    /**
     * Torrent
     * <p>
     * {@code http://purl.org/ontology/mo/Torrent}
     * <p>
     * Something available on the Bittorrent peer-2-peer filesharing network
     *
     * @see <a href="http://purl.org/ontology/mo/Torrent">Torrent</a>
     */
    public static final IRI Torrent;

    /**
     * track
     * <p>
     * {@code http://purl.org/ontology/mo/track}
     * <p>
     * Indicates a part of a musical manifestation - in this particular case,
     * a track.
     *
     * @see <a href="http://purl.org/ontology/mo/track">track</a>
     */
    public static final IRI track;

    /**
     * track
     * <p>
     * {@code http://purl.org/ontology/mo/Track}
     * <p>
     * A track on a particular record
     *
     * @see <a href="http://purl.org/ontology/mo/Track">Track</a>
     */
    public static final IRI Track;

    /**
     * track count
     * <p>
     * {@code http://purl.org/ontology/mo/track_count}
     * <p>
     * The track count of a record
     *
     * @see <a href="http://purl.org/ontology/mo/track_count">track_count</a>
     */
    public static final IRI track_count;

    /**
     * track number
     * <p>
     * {@code http://purl.org/ontology/mo/track_number}
     * <p>
     * Indicates the position of a track on a record medium (a CD, etc.).
     *
     * @see <a href="http://purl.org/ontology/mo/track_number">track_number</a>
     */
    public static final IRI track_number;

    /**
     * {@code http://purl.org/ontology/mo/trackNum}
     *
     * @see <a href="http://purl.org/ontology/mo/trackNum">trackNum</a>
     */
    public static final IRI trackNum;

    /**
     * transcription
     * <p>
     * {@code http://purl.org/ontology/mo/Transcription}
     * <p>
     * Transcription event
     *
     * @see <a href="http://purl.org/ontology/mo/Transcription">Transcription</a>
     */
    public static final IRI Transcription;

    /**
     * translation_of
     * <p>
     * {@code http://purl.org/ontology/mo/translation_of}
     * <p>
     * Indicates that a work or the expression of a work has translated or
     * transliterated into another expression of a work.
     *
     * @see <a href="http://purl.org/ontology/mo/translation_of">translation_of</a>
     */
    public static final IRI translation_of;

    /**
     * tribute_to
     * <p>
     * {@code http://purl.org/ontology/mo/tribute_to}
     * <p>
     * Indicates a musical work or the expression of a musical work that is a
     * tribute to an artist - normally consisting of music being composed by
     * the artist but performed by other artists.
     *
     * @see <a href="http://purl.org/ontology/mo/tribute_to">tribute_to</a>
     */
    public static final IRI tribute_to;

    /**
     * trmid
     * <p>
     * {@code http://purl.org/ontology/mo/trmid}
     * <p>
     * <p>
     * Indicates the TRMID of a track.
     * TRM IDs are
     * MusicBrainz&#39; old AudioFingerprinting system.
     * TRM (TRM
     * Recognizes Music) IDs are (somewhat) unique ids that represent
     * <p>
     * the audio signature of a musical piece (see AudioFingerprint).
     *
     * @see <a href="http://purl.org/ontology/mo/trmid">trmid</a>
     */
    public static final IRI trmid;

    /**
     * upc
     * <p>
     * {@code http://purl.org/ontology/mo/upc}
     * <p>
     * UPC stands for &quot;Universal Product Code&quot;, which was the
     * original barcode used in the United States and Canada. The UPC (now
     * officially EAN.UCC-12 is a numerical method of identifying products
     * without redundancy worldwide for all types of products in the retail
     * sector. The EAN is a superset of the original UPC increasing the
     * digits to 13 with the prefix 0 reserved for UPC. As of 2005,
     * manufacturers are only allowed to use the new 13-digit codes on their
     * items, rather than having two separate numbers.
     *
     * @see <a href="http://purl.org/ontology/mo/upc">upc</a>
     */
    public static final IRI upc;

    /**
     * {@code http://purl.org/ontology/mo/usedInPerformance}
     *
     * @see <a href="http://purl.org/ontology/mo/usedInPerformance">usedInPerformance</a>
     */
    public static final IRI usedInPerformance;

    /**
     * {@code http://purl.org/ontology/mo/usedInRecording}
     *
     * @see <a href="http://purl.org/ontology/mo/usedInRecording">usedInRecording</a>
     */
    public static final IRI usedInRecording;

    /**
     * {@code http://purl.org/ontology/mo/usesSound}
     *
     * @see <a href="http://purl.org/ontology/mo/usesSound">usesSound</a>
     */
    public static final IRI usesSound;

    /**
     * {@code http://purl.org/ontology/mo/usesWork}
     *
     * @see <a href="http://purl.org/ontology/mo/usesWork">usesWork</a>
     */
    public static final IRI usesWork;

    /**
     * universally unique identifier
     * <p>
     * {@code http://purl.org/ontology/mo/uuid}
     * <p>
     * <p>
     * Links an object to an universally unique identifier for
     * it.
     *
     * @see <a href="http://purl.org/ontology/mo/uuid">uuid</a>
     */
    public static final IRI uuid;

    /**
     * Vinyl
     * <p>
     * {@code http://purl.org/ontology/mo/Vinyl}
     * <p>
     * Vinyl used as medium to record a musical manifestation
     *
     * @see <a href="http://purl.org/ontology/mo/Vinyl">Vinyl</a>
     */
    public static final IRI Vinyl;

    /**
     * want_item
     * <p>
     * {@code http://purl.org/ontology/mo/want_item}
     * <p>
     * A person, a group of person or an organization wanting an exemplar of
     * a single manifestation.
     *
     * @see <a href="http://purl.org/ontology/mo/want_item">want_item</a>
     */
    public static final IRI want_item;

    /**
     * wikipedia
     * <p>
     * {@code http://purl.org/ontology/mo/wikipedia}
     * <p>
     * <p>
     * Used to link an work, an expression of a work, a
     * manifestation of a work,
     * a person, an instrument or a musical
     * genre to its corresponding WikiPedia page.
     * The full URL
     * should be used, not just the WikiName.
     *
     * @see <a href="http://purl.org/ontology/mo/wikipedia">wikipedia</a>
     */
    public static final IRI wikipedia;

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
        Activity = vf.createIRI("http://purl.org/ontology/mo/Activity");
        activity = vf.createIRI("http://purl.org/ontology/mo/activity");
        activity_end = vf.createIRI("http://purl.org/ontology/mo/activity_end");
        activity_start = vf.createIRI("http://purl.org/ontology/mo/activity_start");
        album = vf.createIRI("http://purl.org/ontology/mo/album");
        amazon_asin = vf.createIRI("http://purl.org/ontology/mo/amazon_asin");
        AnalogSignal = vf.createIRI("http://purl.org/ontology/mo/AnalogSignal");
        arranged_in = vf.createIRI("http://purl.org/ontology/mo/arranged_in");
        Arrangement = vf.createIRI("http://purl.org/ontology/mo/Arrangement");
        arrangement_of = vf.createIRI("http://purl.org/ontology/mo/arrangement_of");
        Arranger = vf.createIRI("http://purl.org/ontology/mo/Arranger");
        artist = vf.createIRI("http://purl.org/ontology/mo/artist");
        audiobook = vf.createIRI("http://purl.org/ontology/mo/audiobook");
        AudioFile = vf.createIRI("http://purl.org/ontology/mo/AudioFile");
        available_as = vf.createIRI("http://purl.org/ontology/mo/available_as");
        availableAs = vf.createIRI("http://purl.org/ontology/mo/availableAs");
        biography = vf.createIRI("http://purl.org/ontology/mo/biography");
        bitsPerSample = vf.createIRI("http://purl.org/ontology/mo/bitsPerSample");
        bootleg = vf.createIRI("http://purl.org/ontology/mo/bootleg");
        bpm = vf.createIRI("http://purl.org/ontology/mo/bpm");
        catalogue_number = vf.createIRI("http://purl.org/ontology/mo/catalogue_number");
        CD = vf.createIRI("http://purl.org/ontology/mo/CD");
        channels = vf.createIRI("http://purl.org/ontology/mo/channels");
        collaborated_with = vf.createIRI("http://purl.org/ontology/mo/collaborated_with");
        compilation = vf.createIRI("http://purl.org/ontology/mo/compilation");
        compilation_of = vf.createIRI("http://purl.org/ontology/mo/compilation_of");
        compiled = vf.createIRI("http://purl.org/ontology/mo/compiled");
        compiler = vf.createIRI("http://purl.org/ontology/mo/compiler");
        composed_in = vf.createIRI("http://purl.org/ontology/mo/composed_in");
        Composer = vf.createIRI("http://purl.org/ontology/mo/Composer");
        composer = vf.createIRI("http://purl.org/ontology/mo/composer");
        Composition = vf.createIRI("http://purl.org/ontology/mo/Composition");
        conducted = vf.createIRI("http://purl.org/ontology/mo/conducted");
        Conductor = vf.createIRI("http://purl.org/ontology/mo/Conductor");
        conductor = vf.createIRI("http://purl.org/ontology/mo/conductor");
        contains_sample_from = vf.createIRI("http://purl.org/ontology/mo/contains_sample_from");
        CorporateBody = vf.createIRI("http://purl.org/ontology/mo/CorporateBody");
        DAT = vf.createIRI("http://purl.org/ontology/mo/DAT");
        DCC = vf.createIRI("http://purl.org/ontology/mo/DCC");
        derived_from = vf.createIRI("http://purl.org/ontology/mo/derived_from");
        DigitalSignal = vf.createIRI("http://purl.org/ontology/mo/DigitalSignal");
        discography = vf.createIRI("http://purl.org/ontology/mo/discography");
        discogs = vf.createIRI("http://purl.org/ontology/mo/discogs");
        djmix_of = vf.createIRI("http://purl.org/ontology/mo/djmix_of");
        djmixed = vf.createIRI("http://purl.org/ontology/mo/djmixed");
        djmixed_by = vf.createIRI("http://purl.org/ontology/mo/djmixed_by");
        download = vf.createIRI("http://purl.org/ontology/mo/download");
        duration = vf.createIRI("http://purl.org/ontology/mo/duration");
        DVDA = vf.createIRI("http://purl.org/ontology/mo/DVDA");
        ean = vf.createIRI("http://purl.org/ontology/mo/ean");
        ED2K = vf.createIRI("http://purl.org/ontology/mo/ED2K");
        encodes = vf.createIRI("http://purl.org/ontology/mo/encodes");
        encoding = vf.createIRI("http://purl.org/ontology/mo/encoding");
        engineer = vf.createIRI("http://purl.org/ontology/mo/engineer");
        engineered = vf.createIRI("http://purl.org/ontology/mo/engineered");
        ep = vf.createIRI("http://purl.org/ontology/mo/ep");
        event_homepage = vf.createIRI("http://purl.org/ontology/mo/event_homepage");
        eventHomePage = vf.createIRI("http://purl.org/ontology/mo/eventHomePage");
        exchange_item = vf.createIRI("http://purl.org/ontology/mo/exchange_item");
        fanpage = vf.createIRI("http://purl.org/ontology/mo/fanpage");
        Festival = vf.createIRI("http://purl.org/ontology/mo/Festival");
        free_download = vf.createIRI("http://purl.org/ontology/mo/free_download");
        freedownload = vf.createIRI("http://purl.org/ontology/mo/freedownload");
        genre = vf.createIRI("http://purl.org/ontology/mo/genre");
        Genre = vf.createIRI("http://purl.org/ontology/mo/Genre");
        grid = vf.createIRI("http://purl.org/ontology/mo/grid");
        group = vf.createIRI("http://purl.org/ontology/mo/group");
        gtin = vf.createIRI("http://purl.org/ontology/mo/gtin");
        has_track = vf.createIRI("http://purl.org/ontology/mo/has_track");
        headliner = vf.createIRI("http://purl.org/ontology/mo/headliner");
        homepage = vf.createIRI("http://purl.org/ontology/mo/homepage");
        image = vf.createIRI("http://purl.org/ontology/mo/image");
        imdb = vf.createIRI("http://purl.org/ontology/mo/imdb");
        instrument = vf.createIRI("http://purl.org/ontology/mo/instrument");
        Instrument = vf.createIRI("http://purl.org/ontology/mo/Instrument");
        Instrumentation = vf.createIRI("http://purl.org/ontology/mo/Instrumentation");
        interpreter = vf.createIRI("http://purl.org/ontology/mo/interpreter");
        interview = vf.createIRI("http://purl.org/ontology/mo/interview");
        ipi = vf.createIRI("http://purl.org/ontology/mo/ipi");
        ismn = vf.createIRI("http://purl.org/ontology/mo/ismn");
        isrc = vf.createIRI("http://purl.org/ontology/mo/isrc");
        iswc = vf.createIRI("http://purl.org/ontology/mo/iswc");
        item = vf.createIRI("http://purl.org/ontology/mo/item");
        key = vf.createIRI("http://purl.org/ontology/mo/key");
        Label = vf.createIRI("http://purl.org/ontology/mo/Label");
        label = vf.createIRI("http://purl.org/ontology/mo/label");
        lc = vf.createIRI("http://purl.org/ontology/mo/lc");
        level = vf.createIRI("http://purl.org/ontology/mo/level");
        Libretto = vf.createIRI("http://purl.org/ontology/mo/Libretto");
        licence = vf.createIRI("http://purl.org/ontology/mo/licence");
        listened = vf.createIRI("http://purl.org/ontology/mo/listened");
        listener = vf.createIRI("http://purl.org/ontology/mo/listener");
        Listener = vf.createIRI("http://purl.org/ontology/mo/Listener");
        live = vf.createIRI("http://purl.org/ontology/mo/live");
        Lyrics = vf.createIRI("http://purl.org/ontology/mo/Lyrics");
        lyrics = vf.createIRI("http://purl.org/ontology/mo/lyrics");
        MagneticTape = vf.createIRI("http://purl.org/ontology/mo/MagneticTape");
        mailorder = vf.createIRI("http://purl.org/ontology/mo/mailorder");
        mashup_of = vf.createIRI("http://purl.org/ontology/mo/mashup_of");
        MD = vf.createIRI("http://purl.org/ontology/mo/MD");
        media_type = vf.createIRI("http://purl.org/ontology/mo/media_type");
        Medium = vf.createIRI("http://purl.org/ontology/mo/Medium");
        medley_of = vf.createIRI("http://purl.org/ontology/mo/medley_of");
        member = vf.createIRI("http://purl.org/ontology/mo/member");
        member_of = vf.createIRI("http://purl.org/ontology/mo/member_of");
        Membership = vf.createIRI("http://purl.org/ontology/mo/Membership");
        membership = vf.createIRI("http://purl.org/ontology/mo/membership");
        meter = vf.createIRI("http://purl.org/ontology/mo/meter");
        Movement = vf.createIRI("http://purl.org/ontology/mo/Movement");
        movement = vf.createIRI("http://purl.org/ontology/mo/movement");
        movement_number = vf.createIRI("http://purl.org/ontology/mo/movement_number");
        movementNum = vf.createIRI("http://purl.org/ontology/mo/movementNum");
        MusicalExpression = vf.createIRI("http://purl.org/ontology/mo/MusicalExpression");
        MusicalItem = vf.createIRI("http://purl.org/ontology/mo/MusicalItem");
        MusicalManifestation = vf.createIRI("http://purl.org/ontology/mo/MusicalManifestation");
        MusicalWork = vf.createIRI("http://purl.org/ontology/mo/MusicalWork");
        MusicArtist = vf.createIRI("http://purl.org/ontology/mo/MusicArtist");
        musicbrainz = vf.createIRI("http://purl.org/ontology/mo/musicbrainz");
        musicbrainz_guid = vf.createIRI("http://purl.org/ontology/mo/musicbrainz_guid");
        MusicGroup = vf.createIRI("http://purl.org/ontology/mo/MusicGroup");
        musicmoz = vf.createIRI("http://purl.org/ontology/mo/musicmoz");
        myspace = vf.createIRI("http://purl.org/ontology/mo/myspace");
        official = vf.createIRI("http://purl.org/ontology/mo/official");
        olga = vf.createIRI("http://purl.org/ontology/mo/olga");
        onlinecommunity = vf.createIRI("http://purl.org/ontology/mo/onlinecommunity");
        opus = vf.createIRI("http://purl.org/ontology/mo/opus");
        Orchestration = vf.createIRI("http://purl.org/ontology/mo/Orchestration");
        origin = vf.createIRI("http://purl.org/ontology/mo/origin");
        other_release_of = vf.createIRI("http://purl.org/ontology/mo/other_release_of");
        paid_download = vf.createIRI("http://purl.org/ontology/mo/paid_download");
        paiddownload = vf.createIRI("http://purl.org/ontology/mo/paiddownload");
        Performance = vf.createIRI("http://purl.org/ontology/mo/Performance");
        performance_of = vf.createIRI("http://purl.org/ontology/mo/performance_of");
        performed = vf.createIRI("http://purl.org/ontology/mo/performed");
        performed_in = vf.createIRI("http://purl.org/ontology/mo/performed_in");
        performer = vf.createIRI("http://purl.org/ontology/mo/performer");
        Performer = vf.createIRI("http://purl.org/ontology/mo/Performer");
        possess_item = vf.createIRI("http://purl.org/ontology/mo/possess_item");
        preview = vf.createIRI("http://purl.org/ontology/mo/preview");
        preview_download = vf.createIRI("http://purl.org/ontology/mo/preview_download");
        primary_instrument = vf.createIRI("http://purl.org/ontology/mo/primary_instrument");
        produced = vf.createIRI("http://purl.org/ontology/mo/produced");
        produced_score = vf.createIRI("http://purl.org/ontology/mo/produced_score");
        produced_signal = vf.createIRI("http://purl.org/ontology/mo/produced_signal");
        produced_signal_group = vf.createIRI("http://purl.org/ontology/mo/produced_signal_group");
        produced_sound = vf.createIRI("http://purl.org/ontology/mo/produced_sound");
        produced_work = vf.createIRI("http://purl.org/ontology/mo/produced_work");
        producer = vf.createIRI("http://purl.org/ontology/mo/producer");
        producesSignal = vf.createIRI("http://purl.org/ontology/mo/producesSignal");
        producesSound = vf.createIRI("http://purl.org/ontology/mo/producesSound");
        producesWork = vf.createIRI("http://purl.org/ontology/mo/producesWork");
        productOfComposition = vf.createIRI("http://purl.org/ontology/mo/productOfComposition");
        promotion = vf.createIRI("http://purl.org/ontology/mo/promotion");
        publication_of = vf.createIRI("http://purl.org/ontology/mo/publication_of");
        publicationOf = vf.createIRI("http://purl.org/ontology/mo/publicationOf");
        published = vf.createIRI("http://purl.org/ontology/mo/published");
        published_as = vf.createIRI("http://purl.org/ontology/mo/published_as");
        publishedAs = vf.createIRI("http://purl.org/ontology/mo/publishedAs");
        PublishedLibretto = vf.createIRI("http://purl.org/ontology/mo/PublishedLibretto");
        PublishedLyrics = vf.createIRI("http://purl.org/ontology/mo/PublishedLyrics");
        PublishedScore = vf.createIRI("http://purl.org/ontology/mo/PublishedScore");
        publisher = vf.createIRI("http://purl.org/ontology/mo/publisher");
        publishing_location = vf.createIRI("http://purl.org/ontology/mo/publishing_location");
        publishingLocation = vf.createIRI("http://purl.org/ontology/mo/publishingLocation");
        puid = vf.createIRI("http://purl.org/ontology/mo/puid");
        record = vf.createIRI("http://purl.org/ontology/mo/record");
        Record = vf.createIRI("http://purl.org/ontology/mo/Record");
        record_count = vf.createIRI("http://purl.org/ontology/mo/record_count");
        record_number = vf.createIRI("http://purl.org/ontology/mo/record_number");
        record_side = vf.createIRI("http://purl.org/ontology/mo/record_side");
        recorded_as = vf.createIRI("http://purl.org/ontology/mo/recorded_as");
        recorded_in = vf.createIRI("http://purl.org/ontology/mo/recorded_in");
        recordedAs = vf.createIRI("http://purl.org/ontology/mo/recordedAs");
        Recording = vf.createIRI("http://purl.org/ontology/mo/Recording");
        recording_of = vf.createIRI("http://purl.org/ontology/mo/recording_of");
        RecordingSession = vf.createIRI("http://purl.org/ontology/mo/RecordingSession");
        records = vf.createIRI("http://purl.org/ontology/mo/records");
        release = vf.createIRI("http://purl.org/ontology/mo/release");
        Release = vf.createIRI("http://purl.org/ontology/mo/Release");
        release_status = vf.createIRI("http://purl.org/ontology/mo/release_status");
        release_type = vf.createIRI("http://purl.org/ontology/mo/release_type");
        ReleaseEvent = vf.createIRI("http://purl.org/ontology/mo/ReleaseEvent");
        releaseStatus = vf.createIRI("http://purl.org/ontology/mo/releaseStatus");
        ReleaseStatus = vf.createIRI("http://purl.org/ontology/mo/ReleaseStatus");
        releaseType = vf.createIRI("http://purl.org/ontology/mo/releaseType");
        ReleaseType = vf.createIRI("http://purl.org/ontology/mo/ReleaseType");
        remaster_of = vf.createIRI("http://purl.org/ontology/mo/remaster_of");
        remix = vf.createIRI("http://purl.org/ontology/mo/remix");
        remix_of = vf.createIRI("http://purl.org/ontology/mo/remix_of");
        remixed = vf.createIRI("http://purl.org/ontology/mo/remixed");
        remixer = vf.createIRI("http://purl.org/ontology/mo/remixer");
        review = vf.createIRI("http://purl.org/ontology/mo/review");
        SACD = vf.createIRI("http://purl.org/ontology/mo/SACD");
        sample_rate = vf.createIRI("http://purl.org/ontology/mo/sample_rate");
        sampled = vf.createIRI("http://purl.org/ontology/mo/sampled");
        sampled_version = vf.createIRI("http://purl.org/ontology/mo/sampled_version");
        sampled_version_of = vf.createIRI("http://purl.org/ontology/mo/sampled_version_of");
        sampledVersionOf = vf.createIRI("http://purl.org/ontology/mo/sampledVersionOf");
        sampler = vf.createIRI("http://purl.org/ontology/mo/sampler");
        sampleRate = vf.createIRI("http://purl.org/ontology/mo/sampleRate");
        Score = vf.createIRI("http://purl.org/ontology/mo/Score");
        sell_item = vf.createIRI("http://purl.org/ontology/mo/sell_item");
        Show = vf.createIRI("http://purl.org/ontology/mo/Show");
        signal = vf.createIRI("http://purl.org/ontology/mo/signal");
        Signal = vf.createIRI("http://purl.org/ontology/mo/Signal");
        SignalGroup = vf.createIRI("http://purl.org/ontology/mo/SignalGroup");
        signalTime = vf.createIRI("http://purl.org/ontology/mo/signalTime");
        similar_to = vf.createIRI("http://purl.org/ontology/mo/similar_to");
        singer = vf.createIRI("http://purl.org/ontology/mo/singer");
        single = vf.createIRI("http://purl.org/ontology/mo/single");
        SoloMusicArtist = vf.createIRI("http://purl.org/ontology/mo/SoloMusicArtist");
        Sound = vf.createIRI("http://purl.org/ontology/mo/Sound");
        SoundEngineer = vf.createIRI("http://purl.org/ontology/mo/SoundEngineer");
        soundtrack = vf.createIRI("http://purl.org/ontology/mo/soundtrack");
        spokenword = vf.createIRI("http://purl.org/ontology/mo/spokenword");
        Stream = vf.createIRI("http://purl.org/ontology/mo/Stream");
        supporting_musician = vf.createIRI("http://purl.org/ontology/mo/supporting_musician");
        tempo = vf.createIRI("http://purl.org/ontology/mo/tempo");
        text = vf.createIRI("http://purl.org/ontology/mo/text");
        time = vf.createIRI("http://purl.org/ontology/mo/time");
        Torrent = vf.createIRI("http://purl.org/ontology/mo/Torrent");
        track = vf.createIRI("http://purl.org/ontology/mo/track");
        Track = vf.createIRI("http://purl.org/ontology/mo/Track");
        track_count = vf.createIRI("http://purl.org/ontology/mo/track_count");
        track_number = vf.createIRI("http://purl.org/ontology/mo/track_number");
        trackNum = vf.createIRI("http://purl.org/ontology/mo/trackNum");
        Transcription = vf.createIRI("http://purl.org/ontology/mo/Transcription");
        translation_of = vf.createIRI("http://purl.org/ontology/mo/translation_of");
        tribute_to = vf.createIRI("http://purl.org/ontology/mo/tribute_to");
        trmid = vf.createIRI("http://purl.org/ontology/mo/trmid");
        upc = vf.createIRI("http://purl.org/ontology/mo/upc");
        usedInPerformance = vf.createIRI("http://purl.org/ontology/mo/usedInPerformance");
        usedInRecording = vf.createIRI("http://purl.org/ontology/mo/usedInRecording");
        usesSound = vf.createIRI("http://purl.org/ontology/mo/usesSound");
        usesWork = vf.createIRI("http://purl.org/ontology/mo/usesWork");
        uuid = vf.createIRI("http://purl.org/ontology/mo/uuid");
        Vinyl = vf.createIRI("http://purl.org/ontology/mo/Vinyl");
        want_item = vf.createIRI("http://purl.org/ontology/mo/want_item");
        wikipedia = vf.createIRI("http://purl.org/ontology/mo/wikipedia");

        _VALUES = Vocabularies.getIRIs(MusicVocabulary.class);
    }

    public MusicVocabulary() {
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