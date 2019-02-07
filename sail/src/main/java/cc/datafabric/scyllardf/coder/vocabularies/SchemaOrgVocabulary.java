package cc.datafabric.scyllardf.coder.vocabularies;

import cc.datafabric.scyllardf.coder.IVocabulary;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.jetbrains.annotations.NotNull;
import org.eclipse.rdf4j.model.util.Vocabularies;

import java.util.Iterator;
import java.util.Set;

public class SchemaOrgVocabulary implements IVocabulary {

    /**
     * {@code <http://schema.org/>}
     */
    public static final String NAMESPACE = "http://schema.org/";

    /**
     * {@code <http://schema.org/>}
     */
    public static final IRI NAMESPACE_IRI;

    /**
     * {@code <SchemaOrgVocabulary>}
     */
    public static final String PREFIX = "SchemaOrgVocabulary";

    /***************
     * IRI Constants
     ***************/

    /**
     * about
     * <p>
     * {@code http://schema.org/about}
     * <p>
     * The subject matter of the content.
     *
     * @see <a href="http://schema.org/about">about</a>
     */
    public static final IRI about;

    /**
     * AboutPage
     * <p>
     * {@code http://schema.org/AboutPage}
     * <p>
     * Web page type: About page.
     *
     * @see <a href="http://schema.org/AboutPage">AboutPage</a>
     */
    public static final IRI AboutPage;

    /**
     * abridged
     * <p>
     * {@code http://schema.org/abridged}
     * <p>
     * Indicates whether the book is an abridged edition.
     *
     * @see <a href="http://schema.org/abridged">abridged</a>
     */
    public static final IRI abridged;

    /**
     * accelerationTime
     * <p>
     * {@code http://schema.org/accelerationTime}
     * <p>
     * The time needed to accelerate the vehicle from a given start velocity
     * to a given target velocity.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit
     * code(s): SEC for
     * seconds&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;Note: There are
     * unfortunately no standard unit codes for seconds/0..100 km/h or
     * seconds/0..60 mph. Simply use &quot;SEC&quot; for seconds and indicate
     * the velocities in the &lt;a
     * href=&quot;http://schema.org/name&quot;&gt;name&lt;/a&gt; of the &lt;a
     * href=&quot;http://schema.org/QuantitativeValue&quot;&gt;QuantitativeValue&lt;/a&gt;,
     * or use &lt;a
     * href=&quot;http://schema.org/valueReference&quot;&gt;valueReference&lt;/a&gt;
     * with a &lt;a
     * href=&quot;http://schema.org/QuantitativeValue&quot;&gt;QuantitativeValue&lt;/a&gt;
     * of 0..60 mph or 0..100 km/h to specify the reference
     * speeds.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/accelerationTime">accelerationTime</a>
     */
    public static final IRI accelerationTime;

    /**
     * AcceptAction
     * <p>
     * {@code http://schema.org/AcceptAction}
     * <p>
     * The act of committing to/adopting an
     * object.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/RejectAction&quot;&gt;RejectAction&lt;/a&gt;:
     * The antonym of AcceptAction.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/AcceptAction">AcceptAction</a>
     */
    public static final IRI AcceptAction;

    /**
     * acceptedAnswer
     * <p>
     * {@code http://schema.org/acceptedAnswer}
     * <p>
     * The answer(s) that has been accepted as best, typically on a
     * Question/Answer site. Sites vary in their selection mechanisms, e.g.
     * drawing on community opinion and/or the view of the Question author.
     *
     * @see <a href="http://schema.org/acceptedAnswer">acceptedAnswer</a>
     */
    public static final IRI acceptedAnswer;

    /**
     * acceptedOffer
     * <p>
     * {@code http://schema.org/acceptedOffer}
     * <p>
     * The offer(s) -- e.g., product, quantity and price combinations --
     * included in the order.
     *
     * @see <a href="http://schema.org/acceptedOffer">acceptedOffer</a>
     */
    public static final IRI acceptedOffer;

    /**
     * acceptedPaymentMethod
     * <p>
     * {@code http://schema.org/acceptedPaymentMethod}
     * <p>
     * The payment method(s) accepted by seller for this offer.
     *
     * @see <a href="http://schema.org/acceptedPaymentMethod">acceptedPaymentMethod</a>
     */
    public static final IRI acceptedPaymentMethod;

    /**
     * acceptsReservations
     * <p>
     * {@code http://schema.org/acceptsReservations}
     * <p>
     * Indicates whether a FoodEstablishment accepts reservations. Values can
     * be Boolean, an URL at which reservations can be made or (for backwards
     * compatibility) the strings &lt;code&gt;Yes&lt;/code&gt; or
     * &lt;code&gt;No&lt;/code&gt;.
     *
     * @see <a href="http://schema.org/acceptsReservations">acceptsReservations</a>
     */
    public static final IRI acceptsReservations;

    /**
     * accessCode
     * <p>
     * {@code http://schema.org/accessCode}
     * <p>
     * Password, PIN, or access code needed for delivery (e.g. from a
     * locker).
     *
     * @see <a href="http://schema.org/accessCode">accessCode</a>
     */
    public static final IRI accessCode;

    /**
     * accessibilityAPI
     * <p>
     * {@code http://schema.org/accessibilityAPI}
     * <p>
     * Indicates that the resource is compatible with the referenced
     * accessibility API (&lt;a
     * href=&quot;http://www.w3.org/wiki/WebSchemas/Accessibility&quot;&gt;WebSchemas
     * wiki lists possible values&lt;/a&gt;).
     *
     * @see <a href="http://schema.org/accessibilityAPI">accessibilityAPI</a>
     */
    public static final IRI accessibilityAPI;

    /**
     * accessibilityControl
     * <p>
     * {@code http://schema.org/accessibilityControl}
     * <p>
     * Identifies input methods that are sufficient to fully control the
     * described resource (&lt;a
     * href=&quot;http://www.w3.org/wiki/WebSchemas/Accessibility&quot;&gt;WebSchemas
     * wiki lists possible values&lt;/a&gt;).
     *
     * @see <a href="http://schema.org/accessibilityControl">accessibilityControl</a>
     */
    public static final IRI accessibilityControl;

    /**
     * accessibilityFeature
     * <p>
     * {@code http://schema.org/accessibilityFeature}
     * <p>
     * Content features of the resource, such as accessible media,
     * alternatives and supported enhancements for accessibility (&lt;a
     * href=&quot;http://www.w3.org/wiki/WebSchemas/Accessibility&quot;&gt;WebSchemas
     * wiki lists possible values&lt;/a&gt;).
     *
     * @see <a href="http://schema.org/accessibilityFeature">accessibilityFeature</a>
     */
    public static final IRI accessibilityFeature;

    /**
     * accessibilityHazard
     * <p>
     * {@code http://schema.org/accessibilityHazard}
     * <p>
     * A characteristic of the described resource that is physiologically
     * dangerous to some users. Related to WCAG 2.0 guideline 2.3 (&lt;a
     * href=&quot;http://www.w3.org/wiki/WebSchemas/Accessibility&quot;&gt;WebSchemas
     * wiki lists possible values&lt;/a&gt;).
     *
     * @see <a href="http://schema.org/accessibilityHazard">accessibilityHazard</a>
     */
    public static final IRI accessibilityHazard;

    /**
     * accessibilitySummary
     * <p>
     * {@code http://schema.org/accessibilitySummary}
     * <p>
     * A human-readable summary of specific accessibility features or
     * deficiencies, consistent with the other accessibility metadata but
     * expressing subtleties such as &quot;short descriptions are present but
     * long descriptions will be needed for non-visual users&quot; or
     * &quot;short descriptions are present and no long descriptions are
     * needed.&quot;
     *
     * @see <a href="http://schema.org/accessibilitySummary">accessibilitySummary</a>
     */
    public static final IRI accessibilitySummary;

    /**
     * accessMode
     * <p>
     * {@code http://schema.org/accessMode}
     * <p>
     * The human sensory perceptual system or cognitive faculty through which
     * a person may process or perceive information. Expected values include:
     * auditory, tactile, textual, visual, colorDependent, chartOnVisual,
     * chemOnVisual, diagramOnVisual, mathOnVisual, musicOnVisual,
     * textOnVisual.
     *
     * @see <a href="http://schema.org/accessMode">accessMode</a>
     */
    public static final IRI accessMode;

    /**
     * accessModeSufficient
     * <p>
     * {@code http://schema.org/accessModeSufficient}
     * <p>
     * A list of single or combined accessModes that are sufficient to
     * understand all the intellectual content of a resource. Expected values
     * include:  auditory, tactile, textual, visual.
     *
     * @see <a href="http://schema.org/accessModeSufficient">accessModeSufficient</a>
     */
    public static final IRI accessModeSufficient;

    /**
     * Accommodation
     * <p>
     * {@code http://schema.org/Accommodation}
     * <p>
     * An accommodation is a place that can accommodate human beings, e.g. a
     * hotel room, a camping pitch, or a meeting room. Many accommodations
     * are for overnight stays, but this is not a mandatory requirement.
     * For
     * more specific types of accommodations not defined in schema.org, one
     * can use additionalType with external vocabularies.
     * &lt;br /&gt;&lt;br
     * /&gt;
     * See also the &lt;a
     * href=&quot;/docs/hotels.html&quot;&gt;dedicated document on the use of
     * schema.org for marking up hotels and other forms of
     * accommodations&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Accommodation">Accommodation</a>
     */
    public static final IRI Accommodation;

    /**
     * accountablePerson
     * <p>
     * {@code http://schema.org/accountablePerson}
     * <p>
     * Specifies the Person that is legally accountable for the CreativeWork.
     *
     * @see <a href="http://schema.org/accountablePerson">accountablePerson</a>
     */
    public static final IRI accountablePerson;

    /**
     * accountId
     * <p>
     * {@code http://schema.org/accountId}
     * <p>
     * The identifier for the account the payment will be applied to.
     *
     * @see <a href="http://schema.org/accountId">accountId</a>
     */
    public static final IRI accountId;

    /**
     * AccountingService
     * <p>
     * {@code http://schema.org/AccountingService}
     * <p>
     * Accountancy business.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * As a &lt;a
     * href=&quot;http://schema.org/LocalBusiness&quot;&gt;LocalBusiness&lt;/a&gt;
     * it can be described as a &lt;a
     * href=&quot;http://schema.org/provider&quot;&gt;provider&lt;/a&gt; of
     * one or more &lt;a
     * href=&quot;http://schema.org/Service&quot;&gt;Service&lt;/a&gt;(s).
     *
     * @see <a href="http://schema.org/AccountingService">AccountingService</a>
     */
    public static final IRI AccountingService;

    /**
     * accountMinimumInflow
     * <p>
     * {@code http://schema.org/accountMinimumInflow}
     * <p>
     * A minimum amount that has to be paid in every month.
     *
     * @see <a href="http://schema.org/accountMinimumInflow">accountMinimumInflow</a>
     */
    public static final IRI accountMinimumInflow;

    /**
     * accountOverdraftLimit
     * <p>
     * {@code http://schema.org/accountOverdraftLimit}
     * <p>
     * An overdraft is an extension of credit from a lending institution when
     * an account reaches zero. An overdraft allows the individual to
     * continue withdrawing money even if the account has no funds in it.
     * Basically the bank allows people to borrow a set amount of money.
     *
     * @see <a href="http://schema.org/accountOverdraftLimit">accountOverdraftLimit</a>
     */
    public static final IRI accountOverdraftLimit;

    /**
     * AchieveAction
     * <p>
     * {@code http://schema.org/AchieveAction}
     * <p>
     * The act of accomplishing something via previous efforts. It is an
     * instantaneous action rather than an ongoing process.
     *
     * @see <a href="http://schema.org/AchieveAction">AchieveAction</a>
     */
    public static final IRI AchieveAction;

    /**
     * acquiredFrom
     * <p>
     * {@code http://schema.org/acquiredFrom}
     * <p>
     * The organization or person from which the product was acquired.
     *
     * @see <a href="http://schema.org/acquiredFrom">acquiredFrom</a>
     */
    public static final IRI acquiredFrom;

    /**
     * acrissCode
     * <p>
     * {@code http://schema.org/acrissCode}
     * <p>
     * The ACRISS Car Classification Code is a code used by many car rental
     * companies, for classifying vehicles. ACRISS stands for Association of
     * Car Rental Industry Systems and Standards.
     *
     * @see <a href="http://schema.org/acrissCode">acrissCode</a>
     */
    public static final IRI acrissCode;

    /**
     * action
     * <p>
     * {@code http://schema.org/action}
     * <p>
     * Obsolete term for &lt;a
     * href=&quot;http://schema.org/muscleAction&quot;&gt;muscleAction&lt;/a&gt;.
     * Not to be confused with &lt;a
     * href=&quot;http://schema.org/potentialAction&quot;&gt;potentialAction&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/action">action</a>
     */
    public static final IRI action;

    /**
     * Action
     * <p>
     * {@code http://schema.org/Action}
     * <p>
     * An action performed by a direct agent and indirect participants upon a
     * direct object. Optionally happens at a location with the help of an
     * inanimate instrument. The execution of the action may produce a
     * result. Specific action sub-type documentation specifies the exact
     * expectation of each argument/role.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * See also
     * &lt;a
     * href=&quot;http://blog.schema.org/2014/04/announcing-schemaorg-actions.html&quot;&gt;blog
     * post&lt;/a&gt; and &lt;a
     * href=&quot;http://schema.org/docs/actions.html&quot;&gt;Actions
     * overview document&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Action">Action</a>
     */
    public static final IRI Action;

    /**
     * actionableFeedbackPolicy
     * <p>
     * {@code http://schema.org/actionableFeedbackPolicy}
     * <p>
     * For a &lt;a
     * href=&quot;http://schema.org/NewsMediaOrganization&quot;&gt;NewsMediaOrganization&lt;/a&gt;
     * or other news-related &lt;a
     * href=&quot;http://schema.org/Organization&quot;&gt;Organization&lt;/a&gt;,
     * a statement about public engagement activities (for news media, the
     * newsroom’s), including involving the public - digitally or otherwise
     * -- in coverage decisions, reporting and activities after publication.
     *
     * @see <a href="http://schema.org/actionableFeedbackPolicy">actionableFeedbackPolicy</a>
     */
    public static final IRI actionableFeedbackPolicy;

    /**
     * actionAccessibilityRequirement
     * <p>
     * {@code http://schema.org/actionAccessibilityRequirement}
     * <p>
     * A set of requirements that a must be fulfilled in order to perform an
     * Action. If more than one value is specied, fulfilling one set of
     * requirements will allow the Action to be performed.
     *
     * @see <a href="http://schema.org/actionAccessibilityRequirement">actionAccessibilityRequirement</a>
     */
    public static final IRI actionAccessibilityRequirement;

    /**
     * ActionAccessSpecification
     * <p>
     * {@code http://schema.org/ActionAccessSpecification}
     * <p>
     * A set of requirements that a must be fulfilled in order to perform an
     * Action.
     *
     * @see <a href="http://schema.org/ActionAccessSpecification">ActionAccessSpecification</a>
     */
    public static final IRI ActionAccessSpecification;

    /**
     * actionApplication
     * <p>
     * {@code http://schema.org/actionApplication}
     * <p>
     * An application that can complete the request.
     *
     * @see <a href="http://schema.org/actionApplication">actionApplication</a>
     */
    public static final IRI actionApplication;

    /**
     * actionOption
     * <p>
     * {@code http://schema.org/actionOption}
     * <p>
     * A sub property of object. The options subject to this action.
     *
     * @see <a href="http://schema.org/actionOption">actionOption</a>
     */
    public static final IRI actionOption;

    /**
     * actionPlatform
     * <p>
     * {@code http://schema.org/actionPlatform}
     * <p>
     * The high level platform(s) where the Action can be performed for the
     * given URL. To specify a specific application or operating system
     * instance, use actionApplication.
     *
     * @see <a href="http://schema.org/actionPlatform">actionPlatform</a>
     */
    public static final IRI actionPlatform;

    /**
     * actionStatus
     * <p>
     * {@code http://schema.org/actionStatus}
     * <p>
     * Indicates the current disposition of the Action.
     *
     * @see <a href="http://schema.org/actionStatus">actionStatus</a>
     */
    public static final IRI actionStatus;

    /**
     * ActionStatusType
     * <p>
     * {@code http://schema.org/ActionStatusType}
     * <p>
     * The status of an Action.
     *
     * @see <a href="http://schema.org/ActionStatusType">ActionStatusType</a>
     */
    public static final IRI ActionStatusType;

    /**
     * ActivateAction
     * <p>
     * {@code http://schema.org/ActivateAction}
     * <p>
     * The act of starting or activating a device or application (e.g.
     * starting a timer or turning on a flashlight).
     *
     * @see <a href="http://schema.org/ActivateAction">ActivateAction</a>
     */
    public static final IRI ActivateAction;

    /**
     * activeIngredient
     * <p>
     * {@code http://schema.org/activeIngredient}
     * <p>
     * An active ingredient, typically chemical compounds and/or biologic
     * substances.
     *
     * @see <a href="http://schema.org/activeIngredient">activeIngredient</a>
     */
    public static final IRI activeIngredient;

    /**
     * activityDuration
     * <p>
     * {@code http://schema.org/activityDuration}
     * <p>
     * Length of time to engage in the activity.
     *
     * @see <a href="http://schema.org/activityDuration">activityDuration</a>
     */
    public static final IRI activityDuration;

    /**
     * activityFrequency
     * <p>
     * {@code http://schema.org/activityFrequency}
     * <p>
     * How often one should engage in the activity.
     *
     * @see <a href="http://schema.org/activityFrequency">activityFrequency</a>
     */
    public static final IRI activityFrequency;

    /**
     * actor
     * <p>
     * {@code http://schema.org/actor}
     * <p>
     * An actor, e.g. in tv, radio, movie, video games etc., or in an event.
     * Actors can be associated with individual items or with a series,
     * episode, clip.
     *
     * @see <a href="http://schema.org/actor">actor</a>
     */
    public static final IRI actor;

    /**
     * actors
     * <p>
     * {@code http://schema.org/actors}
     * <p>
     * An actor, e.g. in tv, radio, movie, video games etc. Actors can be
     * associated with individual items or with a series, episode, clip.
     *
     * @see <a href="http://schema.org/actors">actors</a>
     */
    public static final IRI actors;

    /**
     * AddAction
     * <p>
     * {@code http://schema.org/AddAction}
     * <p>
     * The act of editing by adding an object to a collection.
     *
     * @see <a href="http://schema.org/AddAction">AddAction</a>
     */
    public static final IRI AddAction;

    /**
     * additionalName
     * <p>
     * {@code http://schema.org/additionalName}
     * <p>
     * An additional name for a Person, can be used for a middle name.
     *
     * @see <a href="http://schema.org/additionalName">additionalName</a>
     */
    public static final IRI additionalName;

    /**
     * additionalNumberOfGuests
     * <p>
     * {@code http://schema.org/additionalNumberOfGuests}
     * <p>
     * If responding yes, the number of guests who will attend in addition to
     * the invitee.
     *
     * @see <a href="http://schema.org/additionalNumberOfGuests">additionalNumberOfGuests</a>
     */
    public static final IRI additionalNumberOfGuests;

    /**
     * additionalProperty
     * <p>
     * {@code http://schema.org/additionalProperty}
     * <p>
     * A property-value pair representing an additional characteristics of
     * the entitity, e.g. a product feature or another characteristic for
     * which there is no matching property in
     * schema.org.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Note: Publishers should be aware
     * that applications designed to use specific schema.org properties (e.g.
     * http://schema.org/width, http://schema.org/color,
     * http://schema.org/gtin13, ...) will typically expect such data to be
     * provided using those properties, rather than using the generic
     * property/value mechanism.
     *
     * @see <a href="http://schema.org/additionalProperty">additionalProperty</a>
     */
    public static final IRI additionalProperty;

    /**
     * additionalType
     * <p>
     * {@code http://schema.org/additionalType}
     * <p>
     * An additional type for the item, typically used for adding more
     * specific types from external vocabularies in microdata syntax. This is
     * a relationship between something and a class that the thing is in. In
     * RDFa syntax, it is better to use the native RDFa syntax - the
     * &#39;typeof&#39; attribute - for multiple types. Schema.org tools may
     * have only weaker understanding of extra types, in particular those
     * defined externally.
     *
     * @see <a href="http://schema.org/additionalType">additionalType</a>
     */
    public static final IRI additionalType;

    /**
     * additionalVariable
     * <p>
     * {@code http://schema.org/additionalVariable}
     * <p>
     * Any additional component of the exercise prescription that may need to
     * be articulated to the patient. This may include the order of
     * exercises, the number of repetitions of movement, quantitative
     * distance, progressions over time, etc.
     *
     * @see <a href="http://schema.org/additionalVariable">additionalVariable</a>
     */
    public static final IRI additionalVariable;

    /**
     * addOn
     * <p>
     * {@code http://schema.org/addOn}
     * <p>
     * An additional offer that can only be obtained in combination with the
     * first base offer (e.g. supplements and extensions that are available
     * for a surcharge).
     *
     * @see <a href="http://schema.org/addOn">addOn</a>
     */
    public static final IRI addOn;

    /**
     * address
     * <p>
     * {@code http://schema.org/address}
     * <p>
     * Physical address of the item.
     *
     * @see <a href="http://schema.org/address">address</a>
     */
    public static final IRI address;

    /**
     * addressCountry
     * <p>
     * {@code http://schema.org/addressCountry}
     * <p>
     * The country. For example, USA. You can also provide the two-letter
     * &lt;a href=&quot;http://en.wikipedia.org/wiki/ISO_3166-1&quot;&gt;ISO
     * 3166-1 alpha-2 country code&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/addressCountry">addressCountry</a>
     */
    public static final IRI addressCountry;

    /**
     * addressLocality
     * <p>
     * {@code http://schema.org/addressLocality}
     * <p>
     * The locality. For example, Mountain View.
     *
     * @see <a href="http://schema.org/addressLocality">addressLocality</a>
     */
    public static final IRI addressLocality;

    /**
     * addressRegion
     * <p>
     * {@code http://schema.org/addressRegion}
     * <p>
     * The region. For example, CA.
     *
     * @see <a href="http://schema.org/addressRegion">addressRegion</a>
     */
    public static final IRI addressRegion;

    /**
     * administrationRoute
     * <p>
     * {@code http://schema.org/administrationRoute}
     * <p>
     * A route by which this drug may be administered, e.g. &#39;oral&#39;.
     *
     * @see <a href="http://schema.org/administrationRoute">administrationRoute</a>
     */
    public static final IRI administrationRoute;

    /**
     * AdministrativeArea
     * <p>
     * {@code http://schema.org/AdministrativeArea}
     * <p>
     * A geographical region, typically under the jurisdiction of a
     * particular government.
     *
     * @see <a href="http://schema.org/AdministrativeArea">AdministrativeArea</a>
     */
    public static final IRI AdministrativeArea;

    /**
     * AdultEntertainment
     * <p>
     * {@code http://schema.org/AdultEntertainment}
     * <p>
     * An adult entertainment establishment.
     *
     * @see <a href="http://schema.org/AdultEntertainment">AdultEntertainment</a>
     */
    public static final IRI AdultEntertainment;

    /**
     * advanceBookingRequirement
     * <p>
     * {@code http://schema.org/advanceBookingRequirement}
     * <p>
     * The amount of time that is required between accepting the offer and
     * the actual usage of the resource or service.
     *
     * @see <a href="http://schema.org/advanceBookingRequirement">advanceBookingRequirement</a>
     */
    public static final IRI advanceBookingRequirement;

    /**
     * adverseOutcome
     * <p>
     * {@code http://schema.org/adverseOutcome}
     * <p>
     * A possible complication and/or side effect of this therapy. If it is
     * known that an adverse outcome is serious (resulting in death,
     * disability, or permanent damage; requiring hospitalization; or is
     * otherwise life-threatening or requires immediate medical attention),
     * tag it as a seriouseAdverseOutcome instead.
     *
     * @see <a href="http://schema.org/adverseOutcome">adverseOutcome</a>
     */
    public static final IRI adverseOutcome;

    /**
     * AdvertiserContentArticle
     * <p>
     * {@code http://schema.org/AdvertiserContentArticle}
     * <p>
     * An &lt;a
     * href=&quot;http://schema.org/Article&quot;&gt;Article&lt;/a&gt; that
     * an external entity has paid to place or to produce to its
     * specifications. Includes &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/Advertorial&quot;&gt;advertorials&lt;/a&gt;,
     * sponsored content, native advertising and other paid content.
     *
     * @see <a href="http://schema.org/AdvertiserContentArticle">AdvertiserContentArticle</a>
     */
    public static final IRI AdvertiserContentArticle;

    /**
     * affectedBy
     * <p>
     * {@code http://schema.org/affectedBy}
     * <p>
     * Drugs that affect the test&#39;s results.
     *
     * @see <a href="http://schema.org/affectedBy">affectedBy</a>
     */
    public static final IRI affectedBy;

    /**
     * affiliation
     * <p>
     * {@code http://schema.org/affiliation}
     * <p>
     * An organization that this person is affiliated with. For example, a
     * school/university, a club, or a team.
     *
     * @see <a href="http://schema.org/affiliation">affiliation</a>
     */
    public static final IRI affiliation;

    /**
     * afterMedia
     * <p>
     * {@code http://schema.org/afterMedia}
     * <p>
     * A media object representing the circumstances after performing this
     * direction.
     *
     * @see <a href="http://schema.org/afterMedia">afterMedia</a>
     */
    public static final IRI afterMedia;

    /**
     * agent
     * <p>
     * {@code http://schema.org/agent}
     * <p>
     * The direct performer or driver of the action (animate or inanimate).
     * e.g. &lt;em&gt;John&lt;/em&gt; wrote a book.
     *
     * @see <a href="http://schema.org/agent">agent</a>
     */
    public static final IRI agent;

    /**
     * AggregateOffer
     * <p>
     * {@code http://schema.org/AggregateOffer}
     * <p>
     * When a single product is associated with multiple offers (for example,
     * the same pair of shoes is offered by different merchants), then
     * AggregateOffer can be used.
     *
     * @see <a href="http://schema.org/AggregateOffer">AggregateOffer</a>
     */
    public static final IRI AggregateOffer;

    /**
     * AggregateRating
     * <p>
     * {@code http://schema.org/AggregateRating}
     * <p>
     * The average rating based on multiple ratings or reviews.
     *
     * @see <a href="http://schema.org/AggregateRating">AggregateRating</a>
     */
    public static final IRI AggregateRating;

    /**
     * aggregateRating
     * <p>
     * {@code http://schema.org/aggregateRating}
     * <p>
     * The overall rating, based on a collection of reviews or ratings, of
     * the item.
     *
     * @see <a href="http://schema.org/aggregateRating">aggregateRating</a>
     */
    public static final IRI aggregateRating;

    /**
     * AgreeAction
     * <p>
     * {@code http://schema.org/AgreeAction}
     * <p>
     * The act of expressing a consistency of opinion with the object. An
     * agent agrees to/about an object (a proposition, topic or theme) with
     * participants.
     *
     * @see <a href="http://schema.org/AgreeAction">AgreeAction</a>
     */
    public static final IRI AgreeAction;

    /**
     * aircraft
     * <p>
     * {@code http://schema.org/aircraft}
     * <p>
     * The kind of aircraft (e.g., &quot;Boeing 747&quot;).
     *
     * @see <a href="http://schema.org/aircraft">aircraft</a>
     */
    public static final IRI aircraft;

    /**
     * Airline
     * <p>
     * {@code http://schema.org/Airline}
     * <p>
     * An organization that provides flights for passengers.
     *
     * @see <a href="http://schema.org/Airline">Airline</a>
     */
    public static final IRI Airline;

    /**
     * Airport
     * <p>
     * {@code http://schema.org/Airport}
     * <p>
     * An airport.
     *
     * @see <a href="http://schema.org/Airport">Airport</a>
     */
    public static final IRI Airport;

    /**
     * album
     * <p>
     * {@code http://schema.org/album}
     * <p>
     * A music album.
     *
     * @see <a href="http://schema.org/album">album</a>
     */
    public static final IRI album;

    /**
     * albumProductionType
     * <p>
     * {@code http://schema.org/albumProductionType}
     * <p>
     * Classification of the album by it&#39;s type of content: soundtrack,
     * live album, studio album, etc.
     *
     * @see <a href="http://schema.org/albumProductionType">albumProductionType</a>
     */
    public static final IRI albumProductionType;

    /**
     * albumRelease
     * <p>
     * {@code http://schema.org/albumRelease}
     * <p>
     * A release of this album.
     *
     * @see <a href="http://schema.org/albumRelease">albumRelease</a>
     */
    public static final IRI albumRelease;

    /**
     * albumReleaseType
     * <p>
     * {@code http://schema.org/albumReleaseType}
     * <p>
     * The kind of release which this album is: single, EP or album.
     *
     * @see <a href="http://schema.org/albumReleaseType">albumReleaseType</a>
     */
    public static final IRI albumReleaseType;

    /**
     * albums
     * <p>
     * {@code http://schema.org/albums}
     * <p>
     * A collection of music albums.
     *
     * @see <a href="http://schema.org/albums">albums</a>
     */
    public static final IRI albums;

    /**
     * alcoholWarning
     * <p>
     * {@code http://schema.org/alcoholWarning}
     * <p>
     * Any precaution, guidance, contraindication, etc. related to
     * consumption of alcohol while taking this drug.
     *
     * @see <a href="http://schema.org/alcoholWarning">alcoholWarning</a>
     */
    public static final IRI alcoholWarning;

    /**
     * algorithm
     * <p>
     * {@code http://schema.org/algorithm}
     * <p>
     * The algorithm or rules to follow to compute the score.
     *
     * @see <a href="http://schema.org/algorithm">algorithm</a>
     */
    public static final IRI algorithm;

    /**
     * AlignmentObject
     * <p>
     * {@code http://schema.org/AlignmentObject}
     * <p>
     * An intangible item that describes an alignment between a learning
     * resource and a node in an educational framework.
     *
     * @see <a href="http://schema.org/AlignmentObject">AlignmentObject</a>
     */
    public static final IRI AlignmentObject;

    /**
     * alignmentType
     * <p>
     * {@code http://schema.org/alignmentType}
     * <p>
     * A category of alignment between the learning resource and the
     * framework node. Recommended values include: &#39;assesses&#39;,
     * &#39;teaches&#39;, &#39;requires&#39;, &#39;textComplexity&#39;,
     * &#39;readingLevel&#39;, &#39;educationalSubject&#39;, and
     * &#39;educationalLevel&#39;.
     *
     * @see <a href="http://schema.org/alignmentType">alignmentType</a>
     */
    public static final IRI alignmentType;

    /**
     * AllocateAction
     * <p>
     * {@code http://schema.org/AllocateAction}
     * <p>
     * The act of organizing tasks/objects/events by associating resources to
     * it.
     *
     * @see <a href="http://schema.org/AllocateAction">AllocateAction</a>
     */
    public static final IRI AllocateAction;

    /**
     * alternateName
     * <p>
     * {@code http://schema.org/alternateName}
     * <p>
     * An alias for the item.
     *
     * @see <a href="http://schema.org/alternateName">alternateName</a>
     */
    public static final IRI alternateName;

    /**
     * alternativeHeadline
     * <p>
     * {@code http://schema.org/alternativeHeadline}
     * <p>
     * A secondary title of the CreativeWork.
     *
     * @see <a href="http://schema.org/alternativeHeadline">alternativeHeadline</a>
     */
    public static final IRI alternativeHeadline;

    /**
     * alumni
     * <p>
     * {@code http://schema.org/alumni}
     * <p>
     * Alumni of an organization.
     *
     * @see <a href="http://schema.org/alumni">alumni</a>
     */
    public static final IRI alumni;

    /**
     * alumniOf
     * <p>
     * {@code http://schema.org/alumniOf}
     * <p>
     * An organization that the person is an alumni of.
     *
     * @see <a href="http://schema.org/alumniOf">alumniOf</a>
     */
    public static final IRI alumniOf;

    /**
     * amenityFeature
     * <p>
     * {@code http://schema.org/amenityFeature}
     * <p>
     * An amenity feature (e.g. a characteristic or service) of the
     * Accommodation. This generic property does not make a statement about
     * whether the feature is included in an offer for the main accommodation
     * or available at extra costs.
     *
     * @see <a href="http://schema.org/amenityFeature">amenityFeature</a>
     */
    public static final IRI amenityFeature;

    /**
     * amount
     * <p>
     * {@code http://schema.org/amount}
     * <p>
     * The amount of money.
     *
     * @see <a href="http://schema.org/amount">amount</a>
     */
    public static final IRI amount;

    /**
     * amountOfThisGood
     * <p>
     * {@code http://schema.org/amountOfThisGood}
     * <p>
     * The quantity of the goods included in the offer.
     *
     * @see <a href="http://schema.org/amountOfThisGood">amountOfThisGood</a>
     */
    public static final IRI amountOfThisGood;

    /**
     * AMRadioChannel
     * <p>
     * {@code http://schema.org/AMRadioChannel}
     * <p>
     * A radio channel that uses AM.
     *
     * @see <a href="http://schema.org/AMRadioChannel">AMRadioChannel</a>
     */
    public static final IRI AMRadioChannel;

    /**
     * AmusementPark
     * <p>
     * {@code http://schema.org/AmusementPark}
     * <p>
     * An amusement park.
     *
     * @see <a href="http://schema.org/AmusementPark">AmusementPark</a>
     */
    public static final IRI AmusementPark;

    /**
     * AnalysisNewsArticle
     * <p>
     * {@code http://schema.org/AnalysisNewsArticle}
     * <p>
     * An AnalysisNewsArticle is a &lt;a
     * href=&quot;http://schema.org/NewsArticle&quot;&gt;NewsArticle&lt;/a&gt;
     * that, while based on factual reporting, incorporates the expertise of
     * the author/producer, offering interpretations and conclusions.
     *
     * @see <a href="http://schema.org/AnalysisNewsArticle">AnalysisNewsArticle</a>
     */
    public static final IRI AnalysisNewsArticle;

    /**
     * AnatomicalStructure
     * <p>
     * {@code http://schema.org/AnatomicalStructure}
     * <p>
     * Any part of the human body, typically a component of an anatomical
     * system. Organs, tissues, and cells are all anatomical structures.
     *
     * @see <a href="http://schema.org/AnatomicalStructure">AnatomicalStructure</a>
     */
    public static final IRI AnatomicalStructure;

    /**
     * AnatomicalSystem
     * <p>
     * {@code http://schema.org/AnatomicalSystem}
     * <p>
     * An anatomical system is a group of anatomical structures that work
     * together to perform a certain task. Anatomical systems, such as organ
     * systems, are one organizing principle of anatomy, and can includes
     * circulatory, digestive, endocrine, integumentary, immune, lymphatic,
     * muscular, nervous, reproductive, respiratory, skeletal, urinary,
     * vestibular, and other systems.
     *
     * @see <a href="http://schema.org/AnatomicalSystem">AnatomicalSystem</a>
     */
    public static final IRI AnatomicalSystem;

    /**
     * AnimalShelter
     * <p>
     * {@code http://schema.org/AnimalShelter}
     * <p>
     * Animal shelter.
     *
     * @see <a href="http://schema.org/AnimalShelter">AnimalShelter</a>
     */
    public static final IRI AnimalShelter;

    /**
     * annualPercentageRate
     * <p>
     * {@code http://schema.org/annualPercentageRate}
     * <p>
     * The annual rate that is charged for borrowing (or made by investing),
     * expressed as a single percentage number that represents the actual
     * yearly cost of funds over the term of a loan. This includes any fees
     * or additional costs associated with the transaction.
     *
     * @see <a href="http://schema.org/annualPercentageRate">annualPercentageRate</a>
     */
    public static final IRI annualPercentageRate;

    /**
     * Answer
     * <p>
     * {@code http://schema.org/Answer}
     * <p>
     * An answer offered to a question; perhaps correct, perhaps opinionated
     * or wrong.
     *
     * @see <a href="http://schema.org/Answer">Answer</a>
     */
    public static final IRI Answer;

    /**
     * answerCount
     * <p>
     * {@code http://schema.org/answerCount}
     * <p>
     * The number of answers this question has received.
     *
     * @see <a href="http://schema.org/answerCount">answerCount</a>
     */
    public static final IRI answerCount;

    /**
     * antagonist
     * <p>
     * {@code http://schema.org/antagonist}
     * <p>
     * The muscle whose action counteracts the specified muscle.
     *
     * @see <a href="http://schema.org/antagonist">antagonist</a>
     */
    public static final IRI antagonist;

    /**
     * Apartment
     * <p>
     * {@code http://schema.org/Apartment}
     * <p>
     * An apartment (in American English) or flat (in British English) is a
     * self-contained housing unit (a type of residential real estate) that
     * occupies only part of a building (Source: Wikipedia, the free
     * encyclopedia, see &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/Apartment&quot;&gt;http://en.wikipedia.org/wiki/Apartment&lt;/a&gt;).
     *
     * @see <a href="http://schema.org/Apartment">Apartment</a>
     */
    public static final IRI Apartment;

    /**
     * ApartmentComplex
     * <p>
     * {@code http://schema.org/ApartmentComplex}
     * <p>
     * Residence type: Apartment complex.
     *
     * @see <a href="http://schema.org/ApartmentComplex">ApartmentComplex</a>
     */
    public static final IRI ApartmentComplex;

    /**
     * APIReference
     * <p>
     * {@code http://schema.org/APIReference}
     * <p>
     * Reference documentation for application programming interfaces (APIs).
     *
     * @see <a href="http://schema.org/APIReference">APIReference</a>
     */
    public static final IRI APIReference;

    /**
     * appearance
     * <p>
     * {@code http://schema.org/appearance}
     * <p>
     * Indicates an occurence of a &lt;a
     * href=&quot;http://schema.org/Claim&quot;&gt;Claim&lt;/a&gt; in some
     * &lt;a
     * href=&quot;http://schema.org/CreativeWork&quot;&gt;CreativeWork&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/appearance">appearance</a>
     */
    public static final IRI appearance;

    /**
     * AppendAction
     * <p>
     * {@code http://schema.org/AppendAction}
     * <p>
     * The act of inserting at the end if an ordered collection.
     *
     * @see <a href="http://schema.org/AppendAction">AppendAction</a>
     */
    public static final IRI AppendAction;

    /**
     * applicableLocation
     * <p>
     * {@code http://schema.org/applicableLocation}
     * <p>
     * The location in which the status applies.
     *
     * @see <a href="http://schema.org/applicableLocation">applicableLocation</a>
     */
    public static final IRI applicableLocation;

    /**
     * application
     * <p>
     * {@code http://schema.org/application}
     * <p>
     * An application that can complete the request.
     *
     * @see <a href="http://schema.org/application">application</a>
     */
    public static final IRI application;

    /**
     * applicationCategory
     * <p>
     * {@code http://schema.org/applicationCategory}
     * <p>
     * Type of software application, e.g. &#39;Game, Multimedia&#39;.
     *
     * @see <a href="http://schema.org/applicationCategory">applicationCategory</a>
     */
    public static final IRI applicationCategory;

    /**
     * applicationSubCategory
     * <p>
     * {@code http://schema.org/applicationSubCategory}
     * <p>
     * Subcategory of the application, e.g. &#39;Arcade Game&#39;.
     *
     * @see <a href="http://schema.org/applicationSubCategory">applicationSubCategory</a>
     */
    public static final IRI applicationSubCategory;

    /**
     * applicationSuite
     * <p>
     * {@code http://schema.org/applicationSuite}
     * <p>
     * The name of the application suite to which the application belongs
     * (e.g. Excel belongs to Office).
     *
     * @see <a href="http://schema.org/applicationSuite">applicationSuite</a>
     */
    public static final IRI applicationSuite;

    /**
     * appliesToDeliveryMethod
     * <p>
     * {@code http://schema.org/appliesToDeliveryMethod}
     * <p>
     * The delivery method(s) to which the delivery charge or payment charge
     * specification applies.
     *
     * @see <a href="http://schema.org/appliesToDeliveryMethod">appliesToDeliveryMethod</a>
     */
    public static final IRI appliesToDeliveryMethod;

    /**
     * appliesToPaymentMethod
     * <p>
     * {@code http://schema.org/appliesToPaymentMethod}
     * <p>
     * The payment method(s) to which the payment charge specification
     * applies.
     *
     * @see <a href="http://schema.org/appliesToPaymentMethod">appliesToPaymentMethod</a>
     */
    public static final IRI appliesToPaymentMethod;

    /**
     * ApplyAction
     * <p>
     * {@code http://schema.org/ApplyAction}
     * <p>
     * The act of registering to an organization/service without the
     * guarantee to receive it.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/RegisterAction&quot;&gt;RegisterAction&lt;/a&gt;:
     * Unlike RegisterAction, ApplyAction has no guarantees that the
     * application will be accepted.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/ApplyAction">ApplyAction</a>
     */
    public static final IRI ApplyAction;

    /**
     * ApprovedIndication
     * <p>
     * {@code http://schema.org/ApprovedIndication}
     * <p>
     * An indication for a medical therapy that has been formally specified
     * or approved by a regulatory body that regulates use of the therapy;
     * for example, the US FDA approves indications for most drugs in the US.
     *
     * @see <a href="http://schema.org/ApprovedIndication">ApprovedIndication</a>
     */
    public static final IRI ApprovedIndication;

    /**
     * Aquarium
     * <p>
     * {@code http://schema.org/Aquarium}
     * <p>
     * Aquarium.
     *
     * @see <a href="http://schema.org/Aquarium">Aquarium</a>
     */
    public static final IRI Aquarium;

    /**
     * area
     * <p>
     * {@code http://schema.org/area}
     * <p>
     * The area within which users can expect to reach the broadcast service.
     *
     * @see <a href="http://schema.org/area">area</a>
     */
    public static final IRI area;

    /**
     * areaServed
     * <p>
     * {@code http://schema.org/areaServed}
     * <p>
     * The geographic area where a service or offered item is provided.
     *
     * @see <a href="http://schema.org/areaServed">areaServed</a>
     */
    public static final IRI areaServed;

    /**
     * arrivalAirport
     * <p>
     * {@code http://schema.org/arrivalAirport}
     * <p>
     * The airport where the flight terminates.
     *
     * @see <a href="http://schema.org/arrivalAirport">arrivalAirport</a>
     */
    public static final IRI arrivalAirport;

    /**
     * arrivalBusStop
     * <p>
     * {@code http://schema.org/arrivalBusStop}
     * <p>
     * The stop or station from which the bus arrives.
     *
     * @see <a href="http://schema.org/arrivalBusStop">arrivalBusStop</a>
     */
    public static final IRI arrivalBusStop;

    /**
     * arrivalGate
     * <p>
     * {@code http://schema.org/arrivalGate}
     * <p>
     * Identifier of the flight&#39;s arrival gate.
     *
     * @see <a href="http://schema.org/arrivalGate">arrivalGate</a>
     */
    public static final IRI arrivalGate;

    /**
     * arrivalPlatform
     * <p>
     * {@code http://schema.org/arrivalPlatform}
     * <p>
     * The platform where the train arrives.
     *
     * @see <a href="http://schema.org/arrivalPlatform">arrivalPlatform</a>
     */
    public static final IRI arrivalPlatform;

    /**
     * arrivalStation
     * <p>
     * {@code http://schema.org/arrivalStation}
     * <p>
     * The station where the train trip ends.
     *
     * @see <a href="http://schema.org/arrivalStation">arrivalStation</a>
     */
    public static final IRI arrivalStation;

    /**
     * arrivalTerminal
     * <p>
     * {@code http://schema.org/arrivalTerminal}
     * <p>
     * Identifier of the flight&#39;s arrival terminal.
     *
     * @see <a href="http://schema.org/arrivalTerminal">arrivalTerminal</a>
     */
    public static final IRI arrivalTerminal;

    /**
     * arrivalTime
     * <p>
     * {@code http://schema.org/arrivalTime}
     * <p>
     * The expected arrival time.
     *
     * @see <a href="http://schema.org/arrivalTime">arrivalTime</a>
     */
    public static final IRI arrivalTime;

    /**
     * ArriveAction
     * <p>
     * {@code http://schema.org/ArriveAction}
     * <p>
     * The act of arriving at a place. An agent arrives at a destination from
     * a fromLocation, optionally with participants.
     *
     * @see <a href="http://schema.org/ArriveAction">ArriveAction</a>
     */
    public static final IRI ArriveAction;

    /**
     * artEdition
     * <p>
     * {@code http://schema.org/artEdition}
     * <p>
     * The number of copies when multiple copies of a piece of artwork are
     * produced - e.g. for a limited edition of 20 prints,
     * &#39;artEdition&#39; refers to the total number of copies (in this
     * example &quot;20&quot;).
     *
     * @see <a href="http://schema.org/artEdition">artEdition</a>
     */
    public static final IRI artEdition;

    /**
     * arterialBranch
     * <p>
     * {@code http://schema.org/arterialBranch}
     * <p>
     * The branches that comprise the arterial structure.
     *
     * @see <a href="http://schema.org/arterialBranch">arterialBranch</a>
     */
    public static final IRI arterialBranch;

    /**
     * Artery
     * <p>
     * {@code http://schema.org/Artery}
     * <p>
     * A type of blood vessel that specifically carries blood away from the
     * heart.
     *
     * @see <a href="http://schema.org/Artery">Artery</a>
     */
    public static final IRI Artery;

    /**
     * artform
     * <p>
     * {@code http://schema.org/artform}
     * <p>
     * e.g. Painting, Drawing, Sculpture, Print, Photograph, Assemblage,
     * Collage, etc.
     *
     * @see <a href="http://schema.org/artform">artform</a>
     */
    public static final IRI artform;

    /**
     * ArtGallery
     * <p>
     * {@code http://schema.org/ArtGallery}
     * <p>
     * An art gallery.
     *
     * @see <a href="http://schema.org/ArtGallery">ArtGallery</a>
     */
    public static final IRI ArtGallery;

    /**
     * Article
     * <p>
     * {@code http://schema.org/Article}
     * <p>
     * An article, such as a news article or piece of investigative report.
     * Newspapers and magazines have articles of many different types and
     * this is intended to cover them all.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * See also
     * &lt;a
     * href=&quot;http://blog.schema.org/2014/09/schemaorg-support-for-bibliographic_2.html&quot;&gt;blog
     * post&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Article">Article</a>
     */
    public static final IRI Article;

    /**
     * articleBody
     * <p>
     * {@code http://schema.org/articleBody}
     * <p>
     * The actual body of the article.
     *
     * @see <a href="http://schema.org/articleBody">articleBody</a>
     */
    public static final IRI articleBody;

    /**
     * articleSection
     * <p>
     * {@code http://schema.org/articleSection}
     * <p>
     * Articles may belong to one or more &#39;sections&#39; in a magazine or
     * newspaper, such as Sports, Lifestyle, etc.
     *
     * @see <a href="http://schema.org/articleSection">articleSection</a>
     */
    public static final IRI articleSection;

    /**
     * artist
     * <p>
     * {@code http://schema.org/artist}
     * <p>
     * The primary artist for a work
     * in a medium other than pencils or
     * digital line art--for example, if the
     * primary artwork is done in
     * watercolors or digital paints.
     *
     * @see <a href="http://schema.org/artist">artist</a>
     */
    public static final IRI artist;

    /**
     * artMedium
     * <p>
     * {@code http://schema.org/artMedium}
     * <p>
     * The material used. (e.g. Oil, Watercolour, Acrylic, Linoprint, Marble,
     * Cyanotype, Digital, Lithograph, DryPoint, Intaglio, Pastel, Woodcut,
     * Pencil, Mixed Media, etc.)
     *
     * @see <a href="http://schema.org/artMedium">artMedium</a>
     */
    public static final IRI artMedium;

    /**
     * artworkSurface
     * <p>
     * {@code http://schema.org/artworkSurface}
     * <p>
     * The supporting materials for the artwork, e.g. Canvas, Paper, Wood,
     * Board, etc.
     *
     * @see <a href="http://schema.org/artworkSurface">artworkSurface</a>
     */
    public static final IRI artworkSurface;

    /**
     * AskAction
     * <p>
     * {@code http://schema.org/AskAction}
     * <p>
     * The act of posing a question / favor to
     * someone.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/ReplyAction&quot;&gt;ReplyAction&lt;/a&gt;:
     * Appears generally as a response to AskAction.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/AskAction">AskAction</a>
     */
    public static final IRI AskAction;

    /**
     * AskPublicNewsArticle
     * <p>
     * {@code http://schema.org/AskPublicNewsArticle}
     * <p>
     * A &lt;a
     * href=&quot;http://schema.org/NewsArticle&quot;&gt;NewsArticle&lt;/a&gt;
     * expressing an open call by a &lt;a
     * href=&quot;http://schema.org/NewsMediaOrganization&quot;&gt;NewsMediaOrganization&lt;/a&gt;
     * asking the public for input, insights, clarifications, anecdotes,
     * documentation, etc., on an issue, for reporting purposes.
     *
     * @see <a href="http://schema.org/AskPublicNewsArticle">AskPublicNewsArticle</a>
     */
    public static final IRI AskPublicNewsArticle;

    /**
     * aspect
     * <p>
     * {@code http://schema.org/aspect}
     * <p>
     * An aspect of medical practice that is considered on the page, such as
     * &#39;diagnosis&#39;, &#39;treatment&#39;, &#39;causes&#39;,
     * &#39;prognosis&#39;, &#39;etiology&#39;, &#39;epidemiology&#39;, etc.
     *
     * @see <a href="http://schema.org/aspect">aspect</a>
     */
    public static final IRI aspect;

    /**
     * assembly
     * <p>
     * {@code http://schema.org/assembly}
     * <p>
     * Library file name e.g., mscorlib.dll, system.web.dll.
     *
     * @see <a href="http://schema.org/assembly">assembly</a>
     */
    public static final IRI assembly;

    /**
     * assemblyVersion
     * <p>
     * {@code http://schema.org/assemblyVersion}
     * <p>
     * Associated product/technology version. e.g., .NET Framework 4.5.
     *
     * @see <a href="http://schema.org/assemblyVersion">assemblyVersion</a>
     */
    public static final IRI assemblyVersion;

    /**
     * AssessAction
     * <p>
     * {@code http://schema.org/AssessAction}
     * <p>
     * The act of forming one&#39;s opinion, reaction or sentiment.
     *
     * @see <a href="http://schema.org/AssessAction">AssessAction</a>
     */
    public static final IRI AssessAction;

    /**
     * AssignAction
     * <p>
     * {@code http://schema.org/AssignAction}
     * <p>
     * The act of allocating an action/event/task to some destination
     * (someone or something).
     *
     * @see <a href="http://schema.org/AssignAction">AssignAction</a>
     */
    public static final IRI AssignAction;

    /**
     * associatedAnatomy
     * <p>
     * {@code http://schema.org/associatedAnatomy}
     * <p>
     * The anatomy of the underlying organ system or structures associated
     * with this entity.
     *
     * @see <a href="http://schema.org/associatedAnatomy">associatedAnatomy</a>
     */
    public static final IRI associatedAnatomy;

    /**
     * associatedArticle
     * <p>
     * {@code http://schema.org/associatedArticle}
     * <p>
     * A NewsArticle associated with the Media Object.
     *
     * @see <a href="http://schema.org/associatedArticle">associatedArticle</a>
     */
    public static final IRI associatedArticle;

    /**
     * associatedMedia
     * <p>
     * {@code http://schema.org/associatedMedia}
     * <p>
     * A media object that encodes this CreativeWork. This property is a
     * synonym for encoding.
     *
     * @see <a href="http://schema.org/associatedMedia">associatedMedia</a>
     */
    public static final IRI associatedMedia;

    /**
     * associatedPathophysiology
     * <p>
     * {@code http://schema.org/associatedPathophysiology}
     * <p>
     * If applicable, a description of the pathophysiology associated with
     * the anatomical system, including potential abnormal changes in the
     * mechanical, physical, and biochemical functions of the system.
     *
     * @see <a href="http://schema.org/associatedPathophysiology">associatedPathophysiology</a>
     */
    public static final IRI associatedPathophysiology;

    /**
     * athlete
     * <p>
     * {@code http://schema.org/athlete}
     * <p>
     * A person that acts as performing member of a sports team; a player as
     * opposed to a coach.
     *
     * @see <a href="http://schema.org/athlete">athlete</a>
     */
    public static final IRI athlete;

    /**
     * Atlas
     * <p>
     * {@code http://schema.org/Atlas}
     * <p>
     * A collection or bound volume of maps, charts, plates or tables,
     * physical or in media form illustrating any subject.
     *
     * @see <a href="http://schema.org/Atlas">Atlas</a>
     */
    public static final IRI Atlas;

    /**
     * attendee
     * <p>
     * {@code http://schema.org/attendee}
     * <p>
     * A person or organization attending the event.
     *
     * @see <a href="http://schema.org/attendee">attendee</a>
     */
    public static final IRI attendee;

    /**
     * attendees
     * <p>
     * {@code http://schema.org/attendees}
     * <p>
     * A person attending the event.
     *
     * @see <a href="http://schema.org/attendees">attendees</a>
     */
    public static final IRI attendees;

    /**
     * Attorney
     * <p>
     * {@code http://schema.org/Attorney}
     * <p>
     * Professional service: Attorney. &lt;br/&gt;&lt;br/&gt;
     * <p>
     * This type is
     * deprecated - &lt;a
     * href=&quot;http://schema.org/LegalService&quot;&gt;LegalService&lt;/a&gt;
     * is more inclusive and less ambiguous.
     *
     * @see <a href="http://schema.org/Attorney">Attorney</a>
     */
    public static final IRI Attorney;

    /**
     * audience
     * <p>
     * {@code http://schema.org/audience}
     * <p>
     * An intended audience, i.e. a group for whom something was created.
     *
     * @see <a href="http://schema.org/audience">audience</a>
     */
    public static final IRI audience;

    /**
     * Audience
     * <p>
     * {@code http://schema.org/Audience}
     * <p>
     * Intended audience for an item, i.e. the group for whom the item was
     * created.
     *
     * @see <a href="http://schema.org/Audience">Audience</a>
     */
    public static final IRI Audience;

    /**
     * audienceType
     * <p>
     * {@code http://schema.org/audienceType}
     * <p>
     * The target group associated with a given audience (e.g. veterans, car
     * owners, musicians, etc.).
     *
     * @see <a href="http://schema.org/audienceType">audienceType</a>
     */
    public static final IRI audienceType;

    /**
     * audio
     * <p>
     * {@code http://schema.org/audio}
     * <p>
     * An embedded audio object.
     *
     * @see <a href="http://schema.org/audio">audio</a>
     */
    public static final IRI audio;

    /**
     * Audiobook
     * <p>
     * {@code http://schema.org/Audiobook}
     * <p>
     * An audiobook.
     *
     * @see <a href="http://schema.org/Audiobook">Audiobook</a>
     */
    public static final IRI Audiobook;

    /**
     * AudioObject
     * <p>
     * {@code http://schema.org/AudioObject}
     * <p>
     * An audio file.
     *
     * @see <a href="http://schema.org/AudioObject">AudioObject</a>
     */
    public static final IRI AudioObject;

    /**
     * authenticator
     * <p>
     * {@code http://schema.org/authenticator}
     * <p>
     * The Organization responsible for authenticating the user&#39;s
     * subscription. For example, many media apps require a cable/satellite
     * provider to authenticate your subscription before playing media.
     *
     * @see <a href="http://schema.org/authenticator">authenticator</a>
     */
    public static final IRI authenticator;

    /**
     * author
     * <p>
     * {@code http://schema.org/author}
     * <p>
     * The author of this content or rating. Please note that author is
     * special in that HTML 5 provides a special mechanism for indicating
     * authorship via the rel tag. That is equivalent to this and may be used
     * interchangeably.
     *
     * @see <a href="http://schema.org/author">author</a>
     */
    public static final IRI author;

    /**
     * AuthorizeAction
     * <p>
     * {@code http://schema.org/AuthorizeAction}
     * <p>
     * The act of granting permission to an object.
     *
     * @see <a href="http://schema.org/AuthorizeAction">AuthorizeAction</a>
     */
    public static final IRI AuthorizeAction;

    /**
     * AutoBodyShop
     * <p>
     * {@code http://schema.org/AutoBodyShop}
     * <p>
     * Auto body shop.
     *
     * @see <a href="http://schema.org/AutoBodyShop">AutoBodyShop</a>
     */
    public static final IRI AutoBodyShop;

    /**
     * AutoDealer
     * <p>
     * {@code http://schema.org/AutoDealer}
     * <p>
     * An car dealership.
     *
     * @see <a href="http://schema.org/AutoDealer">AutoDealer</a>
     */
    public static final IRI AutoDealer;

    /**
     * AutomatedTeller
     * <p>
     * {@code http://schema.org/AutomatedTeller}
     * <p>
     * ATM/cash machine.
     *
     * @see <a href="http://schema.org/AutomatedTeller">AutomatedTeller</a>
     */
    public static final IRI AutomatedTeller;

    /**
     * AutomotiveBusiness
     * <p>
     * {@code http://schema.org/AutomotiveBusiness}
     * <p>
     * Car repair, sales, or parts.
     *
     * @see <a href="http://schema.org/AutomotiveBusiness">AutomotiveBusiness</a>
     */
    public static final IRI AutomotiveBusiness;

    /**
     * AutoPartsStore
     * <p>
     * {@code http://schema.org/AutoPartsStore}
     * <p>
     * An auto parts store.
     *
     * @see <a href="http://schema.org/AutoPartsStore">AutoPartsStore</a>
     */
    public static final IRI AutoPartsStore;

    /**
     * AutoRental
     * <p>
     * {@code http://schema.org/AutoRental}
     * <p>
     * A car rental business.
     *
     * @see <a href="http://schema.org/AutoRental">AutoRental</a>
     */
    public static final IRI AutoRental;

    /**
     * AutoRepair
     * <p>
     * {@code http://schema.org/AutoRepair}
     * <p>
     * Car repair business.
     *
     * @see <a href="http://schema.org/AutoRepair">AutoRepair</a>
     */
    public static final IRI AutoRepair;

    /**
     * AutoWash
     * <p>
     * {@code http://schema.org/AutoWash}
     * <p>
     * A car wash business.
     *
     * @see <a href="http://schema.org/AutoWash">AutoWash</a>
     */
    public static final IRI AutoWash;

    /**
     * availability
     * <p>
     * {@code http://schema.org/availability}
     * <p>
     * The availability of this item&amp;#x2014;for example In stock, Out of
     * stock, Pre-order, etc.
     *
     * @see <a href="http://schema.org/availability">availability</a>
     */
    public static final IRI availability;

    /**
     * availabilityEnds
     * <p>
     * {@code http://schema.org/availabilityEnds}
     * <p>
     * The end of the availability of the product or service included in the
     * offer.
     *
     * @see <a href="http://schema.org/availabilityEnds">availabilityEnds</a>
     */
    public static final IRI availabilityEnds;

    /**
     * availabilityStarts
     * <p>
     * {@code http://schema.org/availabilityStarts}
     * <p>
     * The beginning of the availability of the product or service included
     * in the offer.
     *
     * @see <a href="http://schema.org/availabilityStarts">availabilityStarts</a>
     */
    public static final IRI availabilityStarts;

    /**
     * availableAtOrFrom
     * <p>
     * {@code http://schema.org/availableAtOrFrom}
     * <p>
     * The place(s) from which the offer can be obtained (e.g. store
     * locations).
     *
     * @see <a href="http://schema.org/availableAtOrFrom">availableAtOrFrom</a>
     */
    public static final IRI availableAtOrFrom;

    /**
     * availableChannel
     * <p>
     * {@code http://schema.org/availableChannel}
     * <p>
     * A means of accessing the service (e.g. a phone bank, a web site, a
     * location, etc.).
     *
     * @see <a href="http://schema.org/availableChannel">availableChannel</a>
     */
    public static final IRI availableChannel;

    /**
     * availableDeliveryMethod
     * <p>
     * {@code http://schema.org/availableDeliveryMethod}
     * <p>
     * The delivery method(s) available for this offer.
     *
     * @see <a href="http://schema.org/availableDeliveryMethod">availableDeliveryMethod</a>
     */
    public static final IRI availableDeliveryMethod;

    /**
     * availableFrom
     * <p>
     * {@code http://schema.org/availableFrom}
     * <p>
     * When the item is available for pickup from the store, locker, etc.
     *
     * @see <a href="http://schema.org/availableFrom">availableFrom</a>
     */
    public static final IRI availableFrom;

    /**
     * availableIn
     * <p>
     * {@code http://schema.org/availableIn}
     * <p>
     * The location in which the strength is available.
     *
     * @see <a href="http://schema.org/availableIn">availableIn</a>
     */
    public static final IRI availableIn;

    /**
     * availableLanguage
     * <p>
     * {@code http://schema.org/availableLanguage}
     * <p>
     * A language someone may use with or at the item, service or place.
     * Please use one of the language codes from the &lt;a
     * href=&quot;http://tools.ietf.org/html/bcp47&quot;&gt;IETF BCP 47
     * standard&lt;/a&gt;. See also &lt;a
     * href=&quot;http://schema.org/inLanguage&quot;&gt;inLanguage&lt;/a&gt;
     *
     * @see <a href="http://schema.org/availableLanguage">availableLanguage</a>
     */
    public static final IRI availableLanguage;

    /**
     * availableOnDevice
     * <p>
     * {@code http://schema.org/availableOnDevice}
     * <p>
     * Device required to run the application. Used in cases where a specific
     * make/model is required to run the application.
     *
     * @see <a href="http://schema.org/availableOnDevice">availableOnDevice</a>
     */
    public static final IRI availableOnDevice;

    /**
     * availableService
     * <p>
     * {@code http://schema.org/availableService}
     * <p>
     * A medical service available from this provider.
     *
     * @see <a href="http://schema.org/availableService">availableService</a>
     */
    public static final IRI availableService;

    /**
     * availableStrength
     * <p>
     * {@code http://schema.org/availableStrength}
     * <p>
     * An available dosage strength for the drug.
     *
     * @see <a href="http://schema.org/availableStrength">availableStrength</a>
     */
    public static final IRI availableStrength;

    /**
     * availableTest
     * <p>
     * {@code http://schema.org/availableTest}
     * <p>
     * A diagnostic test or procedure offered by this lab.
     *
     * @see <a href="http://schema.org/availableTest">availableTest</a>
     */
    public static final IRI availableTest;

    /**
     * availableThrough
     * <p>
     * {@code http://schema.org/availableThrough}
     * <p>
     * After this date, the item will no longer be available for pickup.
     *
     * @see <a href="http://schema.org/availableThrough">availableThrough</a>
     */
    public static final IRI availableThrough;

    /**
     * award
     * <p>
     * {@code http://schema.org/award}
     * <p>
     * An award won by or for this item.
     *
     * @see <a href="http://schema.org/award">award</a>
     */
    public static final IRI award;

    /**
     * awards
     * <p>
     * {@code http://schema.org/awards}
     * <p>
     * Awards won by or for this item.
     *
     * @see <a href="http://schema.org/awards">awards</a>
     */
    public static final IRI awards;

    /**
     * awayTeam
     * <p>
     * {@code http://schema.org/awayTeam}
     * <p>
     * The away team in a sports event.
     *
     * @see <a href="http://schema.org/awayTeam">awayTeam</a>
     */
    public static final IRI awayTeam;

    /**
     * background
     * <p>
     * {@code http://schema.org/background}
     * <p>
     * Descriptive information establishing a historical perspective on the
     * supplement. May include the rationale for the name, the population
     * where the supplement first came to prominence, etc.
     *
     * @see <a href="http://schema.org/background">background</a>
     */
    public static final IRI background;

    /**
     * BackgroundNewsArticle
     * <p>
     * {@code http://schema.org/BackgroundNewsArticle}
     * <p>
     * A &lt;a
     * href=&quot;http://schema.org/NewsArticle&quot;&gt;NewsArticle&lt;/a&gt;
     * providing historical context, definition and detail on a specific
     * topic (aka &quot;explainer&quot; or &quot;backgrounder&quot;). For
     * example, an in-depth article or frequently-asked-questions (&lt;a
     * href=&quot;https://en.wikipedia.org/wiki/FAQ&quot;&gt;FAQ&lt;/a&gt;)
     * document on topics such as Climate Change or the European Union. Other
     * kinds of background material from a non-news setting are often
     * described using &lt;a
     * href=&quot;http://schema.org/Book&quot;&gt;Book&lt;/a&gt; or &lt;a
     * href=&quot;http://schema.org/Article&quot;&gt;Article&lt;/a&gt;, in
     * particular &lt;a
     * href=&quot;http://schema.org/ScholarlyArticle&quot;&gt;ScholarlyArticle&lt;/a&gt;.
     * See also &lt;a
     * href=&quot;http://schema.org/NewsArticle&quot;&gt;NewsArticle&lt;/a&gt;
     * for related vocabulary from a learning/education perspective.
     *
     * @see <a href="http://schema.org/BackgroundNewsArticle">BackgroundNewsArticle</a>
     */
    public static final IRI BackgroundNewsArticle;

    /**
     * backstory
     * <p>
     * {@code http://schema.org/backstory}
     * <p>
     * For an &lt;a
     * href=&quot;http://schema.org/Article&quot;&gt;Article&lt;/a&gt;,
     * typically a &lt;a
     * href=&quot;http://schema.org/NewsArticle&quot;&gt;NewsArticle&lt;/a&gt;,
     * the backstory property provides a textual summary giving a brief
     * explanation of why and how an article was created. In a journalistic
     * setting this could include information about reporting process,
     * methods, interviews, data sources, etc.
     *
     * @see <a href="http://schema.org/backstory">backstory</a>
     */
    public static final IRI backstory;

    /**
     * Bakery
     * <p>
     * {@code http://schema.org/Bakery}
     * <p>
     * A bakery.
     *
     * @see <a href="http://schema.org/Bakery">Bakery</a>
     */
    public static final IRI Bakery;

    /**
     * BankAccount
     * <p>
     * {@code http://schema.org/BankAccount}
     * <p>
     * A product or service offered by a bank whereby one may deposit,
     * withdraw or transfer money and in some cases be paid interest.
     *
     * @see <a href="http://schema.org/BankAccount">BankAccount</a>
     */
    public static final IRI BankAccount;

    /**
     * bankAccountType
     * <p>
     * {@code http://schema.org/bankAccountType}
     * <p>
     * The type of a bank account.
     *
     * @see <a href="http://schema.org/bankAccountType">bankAccountType</a>
     */
    public static final IRI bankAccountType;

    /**
     * BankOrCreditUnion
     * <p>
     * {@code http://schema.org/BankOrCreditUnion}
     * <p>
     * Bank or credit union.
     *
     * @see <a href="http://schema.org/BankOrCreditUnion">BankOrCreditUnion</a>
     */
    public static final IRI BankOrCreditUnion;

    /**
     * Barcode
     * <p>
     * {@code http://schema.org/Barcode}
     * <p>
     * An image of a visual machine-readable code such as a barcode or QR
     * code.
     *
     * @see <a href="http://schema.org/Barcode">Barcode</a>
     */
    public static final IRI Barcode;

    /**
     * BarOrPub
     * <p>
     * {@code http://schema.org/BarOrPub}
     * <p>
     * A bar or pub.
     *
     * @see <a href="http://schema.org/BarOrPub">BarOrPub</a>
     */
    public static final IRI BarOrPub;

    /**
     * baseSalary
     * <p>
     * {@code http://schema.org/baseSalary}
     * <p>
     * The base salary of the job or of an employee in an EmployeeRole.
     *
     * @see <a href="http://schema.org/baseSalary">baseSalary</a>
     */
    public static final IRI baseSalary;

    /**
     * bccRecipient
     * <p>
     * {@code http://schema.org/bccRecipient}
     * <p>
     * A sub property of recipient. The recipient blind copied on a message.
     *
     * @see <a href="http://schema.org/bccRecipient">bccRecipient</a>
     */
    public static final IRI bccRecipient;

    /**
     * Beach
     * <p>
     * {@code http://schema.org/Beach}
     * <p>
     * Beach.
     *
     * @see <a href="http://schema.org/Beach">Beach</a>
     */
    public static final IRI Beach;

    /**
     * BeautySalon
     * <p>
     * {@code http://schema.org/BeautySalon}
     * <p>
     * Beauty salon.
     *
     * @see <a href="http://schema.org/BeautySalon">BeautySalon</a>
     */
    public static final IRI BeautySalon;

    /**
     * bed
     * <p>
     * {@code http://schema.org/bed}
     * <p>
     * The type of bed or beds included in the accommodation. For the single
     * case of just one bed of a certain type, you use bed directly with a
     * text.
     * If you want to indicate the quantity of a certain kind of
     * bed, use an instance of BedDetails. For more detailed information, use
     * the amenityFeature property.
     *
     * @see <a href="http://schema.org/bed">bed</a>
     */
    public static final IRI bed;

    /**
     * BedAndBreakfast
     * <p>
     * {@code http://schema.org/BedAndBreakfast}
     * <p>
     * Bed and breakfast.
     * &lt;br /&gt;&lt;br /&gt;
     * See also the &lt;a
     * href=&quot;/docs/hotels.html&quot;&gt;dedicated document on the use of
     * schema.org for marking up hotels and other forms of
     * accommodations&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/BedAndBreakfast">BedAndBreakfast</a>
     */
    public static final IRI BedAndBreakfast;

    /**
     * BedDetails
     * <p>
     * {@code http://schema.org/BedDetails}
     * <p>
     * An entity holding detailed information about the available bed types,
     * e.g. the quantity of twin beds for a hotel room. For the single case
     * of just one bed of a certain type, you can use bed directly with a
     * text. See also &lt;a
     * href=&quot;http://schema.org/BedType&quot;&gt;BedType&lt;/a&gt; (under
     * development).
     *
     * @see <a href="http://schema.org/BedDetails">BedDetails</a>
     */
    public static final IRI BedDetails;

    /**
     * BedType
     * <p>
     * {@code http://schema.org/BedType}
     * <p>
     * A type of bed. This is used for indicating the bed or beds available
     * in an accommodation.
     *
     * @see <a href="http://schema.org/BedType">BedType</a>
     */
    public static final IRI BedType;

    /**
     * beforeMedia
     * <p>
     * {@code http://schema.org/beforeMedia}
     * <p>
     * A media object representing the circumstances before performing this
     * direction.
     *
     * @see <a href="http://schema.org/beforeMedia">beforeMedia</a>
     */
    public static final IRI beforeMedia;

    /**
     * BefriendAction
     * <p>
     * {@code http://schema.org/BefriendAction}
     * <p>
     * The act of forming a personal connection with someone (object)
     * mutually/bidirectionally/symmetrically.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/FollowAction&quot;&gt;FollowAction&lt;/a&gt;:
     * Unlike FollowAction, BefriendAction implies that the connection is
     * reciprocal.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/BefriendAction">BefriendAction</a>
     */
    public static final IRI BefriendAction;

    /**
     * beneficiaryBank
     * <p>
     * {@code http://schema.org/beneficiaryBank}
     * <p>
     * A bank or bank’s branch, financial institution or international
     * financial institution operating the beneficiary’s bank account or
     * releasing funds for the beneficiary
     *
     * @see <a href="http://schema.org/beneficiaryBank">beneficiaryBank</a>
     */
    public static final IRI beneficiaryBank;

    /**
     * benefits
     * <p>
     * {@code http://schema.org/benefits}
     * <p>
     * Description of benefits associated with the job.
     *
     * @see <a href="http://schema.org/benefits">benefits</a>
     */
    public static final IRI benefits;

    /**
     * benefitsSummaryUrl
     * <p>
     * {@code http://schema.org/benefitsSummaryUrl}
     * <p>
     * The URL that goes directly to the summary of benefits and coverage for
     * the specific standard plan or plan variation.
     *
     * @see <a href="http://schema.org/benefitsSummaryUrl">benefitsSummaryUrl</a>
     */
    public static final IRI benefitsSummaryUrl;

    /**
     * bestRating
     * <p>
     * {@code http://schema.org/bestRating}
     * <p>
     * The highest value allowed in this rating system. If bestRating is
     * omitted, 5 is assumed.
     *
     * @see <a href="http://schema.org/bestRating">bestRating</a>
     */
    public static final IRI bestRating;

    /**
     * BikeStore
     * <p>
     * {@code http://schema.org/BikeStore}
     * <p>
     * A bike store.
     *
     * @see <a href="http://schema.org/BikeStore">BikeStore</a>
     */
    public static final IRI BikeStore;

    /**
     * billingAddress
     * <p>
     * {@code http://schema.org/billingAddress}
     * <p>
     * The billing address for the order.
     *
     * @see <a href="http://schema.org/billingAddress">billingAddress</a>
     */
    public static final IRI billingAddress;

    /**
     * billingIncrement
     * <p>
     * {@code http://schema.org/billingIncrement}
     * <p>
     * This property specifies the minimal quantity and rounding increment
     * that will be the basis for the billing. The unit of measurement is
     * specified by the unitCode property.
     *
     * @see <a href="http://schema.org/billingIncrement">billingIncrement</a>
     */
    public static final IRI billingIncrement;

    /**
     * billingPeriod
     * <p>
     * {@code http://schema.org/billingPeriod}
     * <p>
     * The time interval used to compute the invoice.
     *
     * @see <a href="http://schema.org/billingPeriod">billingPeriod</a>
     */
    public static final IRI billingPeriod;

    /**
     * biomechnicalClass
     * <p>
     * {@code http://schema.org/biomechnicalClass}
     * <p>
     * The biomechanical properties of the bone.
     *
     * @see <a href="http://schema.org/biomechnicalClass">biomechnicalClass</a>
     */
    public static final IRI biomechnicalClass;

    /**
     * birthDate
     * <p>
     * {@code http://schema.org/birthDate}
     * <p>
     * Date of birth.
     *
     * @see <a href="http://schema.org/birthDate">birthDate</a>
     */
    public static final IRI birthDate;

    /**
     * birthPlace
     * <p>
     * {@code http://schema.org/birthPlace}
     * <p>
     * The place where the person was born.
     *
     * @see <a href="http://schema.org/birthPlace">birthPlace</a>
     */
    public static final IRI birthPlace;

    /**
     * bitrate
     * <p>
     * {@code http://schema.org/bitrate}
     * <p>
     * The bitrate of the media object.
     *
     * @see <a href="http://schema.org/bitrate">bitrate</a>
     */
    public static final IRI bitrate;

    /**
     * Blog
     * <p>
     * {@code http://schema.org/Blog}
     * <p>
     * A blog.
     *
     * @see <a href="http://schema.org/Blog">Blog</a>
     */
    public static final IRI Blog;

    /**
     * blogPost
     * <p>
     * {@code http://schema.org/blogPost}
     * <p>
     * A posting that is part of this blog.
     *
     * @see <a href="http://schema.org/blogPost">blogPost</a>
     */
    public static final IRI blogPost;

    /**
     * BlogPosting
     * <p>
     * {@code http://schema.org/BlogPosting}
     * <p>
     * A blog post.
     *
     * @see <a href="http://schema.org/BlogPosting">BlogPosting</a>
     */
    public static final IRI BlogPosting;

    /**
     * blogPosts
     * <p>
     * {@code http://schema.org/blogPosts}
     * <p>
     * The postings that are part of this blog.
     *
     * @see <a href="http://schema.org/blogPosts">blogPosts</a>
     */
    public static final IRI blogPosts;

    /**
     * bloodSupply
     * <p>
     * {@code http://schema.org/bloodSupply}
     * <p>
     * The blood vessel that carries blood from the heart to the muscle.
     *
     * @see <a href="http://schema.org/bloodSupply">bloodSupply</a>
     */
    public static final IRI bloodSupply;

    /**
     * BloodTest
     * <p>
     * {@code http://schema.org/BloodTest}
     * <p>
     * A medical test performed on a sample of a patient&#39;s blood.
     *
     * @see <a href="http://schema.org/BloodTest">BloodTest</a>
     */
    public static final IRI BloodTest;

    /**
     * boardingGroup
     * <p>
     * {@code http://schema.org/boardingGroup}
     * <p>
     * The airline-specific indicator of boarding order / preference.
     *
     * @see <a href="http://schema.org/boardingGroup">boardingGroup</a>
     */
    public static final IRI boardingGroup;

    /**
     * boardingPolicy
     * <p>
     * {@code http://schema.org/boardingPolicy}
     * <p>
     * The type of boarding policy used by the airline (e.g. zone-based or
     * group-based).
     *
     * @see <a href="http://schema.org/boardingPolicy">boardingPolicy</a>
     */
    public static final IRI boardingPolicy;

    /**
     * BoardingPolicyType
     * <p>
     * {@code http://schema.org/BoardingPolicyType}
     * <p>
     * A type of boarding policy used by an airline.
     *
     * @see <a href="http://schema.org/BoardingPolicyType">BoardingPolicyType</a>
     */
    public static final IRI BoardingPolicyType;

    /**
     * bodyLocation
     * <p>
     * {@code http://schema.org/bodyLocation}
     * <p>
     * Location in the body of the anatomical structure.
     *
     * @see <a href="http://schema.org/bodyLocation">bodyLocation</a>
     */
    public static final IRI bodyLocation;

    /**
     * BodyOfWater
     * <p>
     * {@code http://schema.org/BodyOfWater}
     * <p>
     * A body of water, such as a sea, ocean, or lake.
     *
     * @see <a href="http://schema.org/BodyOfWater">BodyOfWater</a>
     */
    public static final IRI BodyOfWater;

    /**
     * bodyType
     * <p>
     * {@code http://schema.org/bodyType}
     * <p>
     * Indicates the design and body style of the vehicle (e.g. station
     * wagon, hatchback, etc.).
     *
     * @see <a href="http://schema.org/bodyType">bodyType</a>
     */
    public static final IRI bodyType;

    /**
     * Bone
     * <p>
     * {@code http://schema.org/Bone}
     * <p>
     * Rigid connective tissue that comprises up the skeletal structure of
     * the human body.
     *
     * @see <a href="http://schema.org/Bone">Bone</a>
     */
    public static final IRI Bone;

    /**
     * Book
     * <p>
     * {@code http://schema.org/Book}
     * <p>
     * A book.
     *
     * @see <a href="http://schema.org/Book">Book</a>
     */
    public static final IRI Book;

    /**
     * bookEdition
     * <p>
     * {@code http://schema.org/bookEdition}
     * <p>
     * The edition of the book.
     *
     * @see <a href="http://schema.org/bookEdition">bookEdition</a>
     */
    public static final IRI bookEdition;

    /**
     * bookFormat
     * <p>
     * {@code http://schema.org/bookFormat}
     * <p>
     * The format of the book.
     *
     * @see <a href="http://schema.org/bookFormat">bookFormat</a>
     */
    public static final IRI bookFormat;

    /**
     * BookFormatType
     * <p>
     * {@code http://schema.org/BookFormatType}
     * <p>
     * The publication format of the book.
     *
     * @see <a href="http://schema.org/BookFormatType">BookFormatType</a>
     */
    public static final IRI BookFormatType;

    /**
     * bookingAgent
     * <p>
     * {@code http://schema.org/bookingAgent}
     * <p>
     * &#39;bookingAgent&#39; is an out-dated term indicating a
     * &#39;broker&#39; that serves as a booking agent.
     *
     * @see <a href="http://schema.org/bookingAgent">bookingAgent</a>
     */
    public static final IRI bookingAgent;

    /**
     * bookingTime
     * <p>
     * {@code http://schema.org/bookingTime}
     * <p>
     * The date and time the reservation was booked.
     *
     * @see <a href="http://schema.org/bookingTime">bookingTime</a>
     */
    public static final IRI bookingTime;

    /**
     * BookmarkAction
     * <p>
     * {@code http://schema.org/BookmarkAction}
     * <p>
     * An agent bookmarks/flags/labels/tags/marks an object.
     *
     * @see <a href="http://schema.org/BookmarkAction">BookmarkAction</a>
     */
    public static final IRI BookmarkAction;

    /**
     * BookSeries
     * <p>
     * {@code http://schema.org/BookSeries}
     * <p>
     * A series of books. Included books can be indicated with the hasPart
     * property.
     *
     * @see <a href="http://schema.org/BookSeries">BookSeries</a>
     */
    public static final IRI BookSeries;

    /**
     * BookStore
     * <p>
     * {@code http://schema.org/BookStore}
     * <p>
     * A bookstore.
     *
     * @see <a href="http://schema.org/BookStore">BookStore</a>
     */
    public static final IRI BookStore;

    /**
     * Boolean
     * <p>
     * {@code http://schema.org/Boolean}
     * <p>
     * Boolean: True or False.
     *
     * @see <a href="http://schema.org/Boolean">Boolean</a>
     */
    public static final IRI Boolean;

    /**
     * BorrowAction
     * <p>
     * {@code http://schema.org/BorrowAction}
     * <p>
     * The act of obtaining an object under an agreement to return it at a
     * later date. Reciprocal of LendAction.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/LendAction&quot;&gt;LendAction&lt;/a&gt;:
     * Reciprocal of BorrowAction.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/BorrowAction">BorrowAction</a>
     */
    public static final IRI BorrowAction;

    /**
     * borrower
     * <p>
     * {@code http://schema.org/borrower}
     * <p>
     * A sub property of participant. The person that borrows the object
     * being lent.
     *
     * @see <a href="http://schema.org/borrower">borrower</a>
     */
    public static final IRI borrower;

    /**
     * BowlingAlley
     * <p>
     * {@code http://schema.org/BowlingAlley}
     * <p>
     * A bowling alley.
     *
     * @see <a href="http://schema.org/BowlingAlley">BowlingAlley</a>
     */
    public static final IRI BowlingAlley;

    /**
     * box
     * <p>
     * {@code http://schema.org/box}
     * <p>
     * A box is the area enclosed by the rectangle formed by two points. The
     * first point is the lower corner, the second point is the upper corner.
     * A box is expressed as two points separated by a space character.
     *
     * @see <a href="http://schema.org/box">box</a>
     */
    public static final IRI box;

    /**
     * BrainStructure
     * <p>
     * {@code http://schema.org/BrainStructure}
     * <p>
     * Any anatomical structure which pertains to the soft nervous tissue
     * functioning as the coordinating center of sensation and intellectual
     * and nervous activity.
     *
     * @see <a href="http://schema.org/BrainStructure">BrainStructure</a>
     */
    public static final IRI BrainStructure;

    /**
     * branch
     * <p>
     * {@code http://schema.org/branch}
     * <p>
     * The branches that delineate from the nerve bundle. Not to be confused
     * with &lt;a
     * href=&quot;http://schema.org/branchOf&quot;&gt;branchOf&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/branch">branch</a>
     */
    public static final IRI branch;

    /**
     * branchCode
     * <p>
     * {@code http://schema.org/branchCode}
     * <p>
     * A short textual code (also called &quot;store code&quot;) that
     * uniquely identifies a place of business. The code is typically
     * assigned by the parentOrganization and used in structured
     * URLs.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * For example, in the URL
     * http://www.starbucks.co.uk/store-locator/etc/detail/3047 the code
     * &quot;3047&quot; is a branchCode for a particular branch.
     *
     * @see <a href="http://schema.org/branchCode">branchCode</a>
     */
    public static final IRI branchCode;

    /**
     * branchOf
     * <p>
     * {@code http://schema.org/branchOf}
     * <p>
     * The larger organization that this local business is a branch of, if
     * any. Not to be confused with (anatomical)&lt;a
     * href=&quot;http://schema.org/branch&quot;&gt;branch&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/branchOf">branchOf</a>
     */
    public static final IRI branchOf;

    /**
     * Brand
     * <p>
     * {@code http://schema.org/Brand}
     * <p>
     * A brand is a name used by an organization or business person for
     * labeling a product, product group, or similar.
     *
     * @see <a href="http://schema.org/Brand">Brand</a>
     */
    public static final IRI Brand;

    /**
     * brand
     * <p>
     * {@code http://schema.org/brand}
     * <p>
     * The brand(s) associated with a product or service, or the brand(s)
     * maintained by an organization or business person.
     *
     * @see <a href="http://schema.org/brand">brand</a>
     */
    public static final IRI brand;

    /**
     * breadcrumb
     * <p>
     * {@code http://schema.org/breadcrumb}
     * <p>
     * A set of links that can help a user understand and navigate a website
     * hierarchy.
     *
     * @see <a href="http://schema.org/breadcrumb">breadcrumb</a>
     */
    public static final IRI breadcrumb;

    /**
     * BreadcrumbList
     * <p>
     * {@code http://schema.org/BreadcrumbList}
     * <p>
     * A BreadcrumbList is an ItemList consisting of a chain of linked Web
     * pages, typically described using at least their URL and their name,
     * and typically ending with the current page.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * The
     * &lt;a
     * href=&quot;http://schema.org/position&quot;&gt;position&lt;/a&gt;
     * property is used to reconstruct the order of the items in a
     * BreadcrumbList The convention is that a breadcrumb list has an &lt;a
     * href=&quot;http://schema.org/itemListOrder&quot;&gt;itemListOrder&lt;/a&gt;
     * of &lt;a
     * href=&quot;http://schema.org/ItemListOrderAscending&quot;&gt;ItemListOrderAscending&lt;/a&gt;
     * (lower values listed first), and that the first items in this list
     * correspond to the &quot;top&quot; or beginning of the breadcrumb
     * trail, e.g. with a site or section homepage. The specific values of
     * &#39;position&#39; are not assigned meaning for a BreadcrumbList, but
     * they should be integers, e.g. beginning with &#39;1&#39; for the first
     * item in the list.
     *
     * @see <a href="http://schema.org/BreadcrumbList">BreadcrumbList</a>
     */
    public static final IRI BreadcrumbList;

    /**
     * breastfeedingWarning
     * <p>
     * {@code http://schema.org/breastfeedingWarning}
     * <p>
     * Any precaution, guidance, contraindication, etc. related to this
     * drug&#39;s use by breastfeeding mothers.
     *
     * @see <a href="http://schema.org/breastfeedingWarning">breastfeedingWarning</a>
     */
    public static final IRI breastfeedingWarning;

    /**
     * Brewery
     * <p>
     * {@code http://schema.org/Brewery}
     * <p>
     * Brewery.
     *
     * @see <a href="http://schema.org/Brewery">Brewery</a>
     */
    public static final IRI Brewery;

    /**
     * Bridge
     * <p>
     * {@code http://schema.org/Bridge}
     * <p>
     * A bridge.
     *
     * @see <a href="http://schema.org/Bridge">Bridge</a>
     */
    public static final IRI Bridge;

    /**
     * broadcastAffiliateOf
     * <p>
     * {@code http://schema.org/broadcastAffiliateOf}
     * <p>
     * The media network(s) whose content is broadcast on this station.
     *
     * @see <a href="http://schema.org/broadcastAffiliateOf">broadcastAffiliateOf</a>
     */
    public static final IRI broadcastAffiliateOf;

    /**
     * BroadcastChannel
     * <p>
     * {@code http://schema.org/BroadcastChannel}
     * <p>
     * A unique instance of a BroadcastService on a CableOrSatelliteService
     * lineup.
     *
     * @see <a href="http://schema.org/BroadcastChannel">BroadcastChannel</a>
     */
    public static final IRI BroadcastChannel;

    /**
     * broadcastChannelId
     * <p>
     * {@code http://schema.org/broadcastChannelId}
     * <p>
     * The unique address by which the BroadcastService can be identified in
     * a provider lineup. In US, this is typically a number.
     *
     * @see <a href="http://schema.org/broadcastChannelId">broadcastChannelId</a>
     */
    public static final IRI broadcastChannelId;

    /**
     * broadcastDisplayName
     * <p>
     * {@code http://schema.org/broadcastDisplayName}
     * <p>
     * The name displayed in the channel guide. For many US affiliates, it is
     * the network name.
     *
     * @see <a href="http://schema.org/broadcastDisplayName">broadcastDisplayName</a>
     */
    public static final IRI broadcastDisplayName;

    /**
     * broadcaster
     * <p>
     * {@code http://schema.org/broadcaster}
     * <p>
     * The organization owning or operating the broadcast service.
     *
     * @see <a href="http://schema.org/broadcaster">broadcaster</a>
     */
    public static final IRI broadcaster;

    /**
     * BroadcastEvent
     * <p>
     * {@code http://schema.org/BroadcastEvent}
     * <p>
     * An over the air or online broadcast event.
     *
     * @see <a href="http://schema.org/BroadcastEvent">BroadcastEvent</a>
     */
    public static final IRI BroadcastEvent;

    /**
     * broadcastFrequency
     * <p>
     * {@code http://schema.org/broadcastFrequency}
     * <p>
     * The frequency used for over-the-air broadcasts. Numeric values or
     * simple ranges e.g. 87-99. In addition a shortcut idiom is supported
     * for frequences of AM and FM radio channels, e.g. &quot;87 FM&quot;.
     *
     * @see <a href="http://schema.org/broadcastFrequency">broadcastFrequency</a>
     */
    public static final IRI broadcastFrequency;

    /**
     * BroadcastFrequencySpecification
     * <p>
     * {@code http://schema.org/BroadcastFrequencySpecification}
     * <p>
     * The frequency in MHz and the modulation used for a particular
     * BroadcastService.
     *
     * @see <a href="http://schema.org/BroadcastFrequencySpecification">BroadcastFrequencySpecification</a>
     */
    public static final IRI BroadcastFrequencySpecification;

    /**
     * broadcastFrequencyValue
     * <p>
     * {@code http://schema.org/broadcastFrequencyValue}
     * <p>
     * The frequency in MHz for a particular broadcast.
     *
     * @see <a href="http://schema.org/broadcastFrequencyValue">broadcastFrequencyValue</a>
     */
    public static final IRI broadcastFrequencyValue;

    /**
     * broadcastOfEvent
     * <p>
     * {@code http://schema.org/broadcastOfEvent}
     * <p>
     * The event being broadcast such as a sporting event or awards ceremony.
     *
     * @see <a href="http://schema.org/broadcastOfEvent">broadcastOfEvent</a>
     */
    public static final IRI broadcastOfEvent;

    /**
     * BroadcastService
     * <p>
     * {@code http://schema.org/BroadcastService}
     * <p>
     * A delivery service through which content is provided via broadcast
     * over the air or online.
     *
     * @see <a href="http://schema.org/BroadcastService">BroadcastService</a>
     */
    public static final IRI BroadcastService;

    /**
     * broadcastServiceTier
     * <p>
     * {@code http://schema.org/broadcastServiceTier}
     * <p>
     * The type of service required to have access to the channel (e.g.
     * Standard or Premium).
     *
     * @see <a href="http://schema.org/broadcastServiceTier">broadcastServiceTier</a>
     */
    public static final IRI broadcastServiceTier;

    /**
     * broadcastTimezone
     * <p>
     * {@code http://schema.org/broadcastTimezone}
     * <p>
     * The timezone in &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/ISO_8601&quot;&gt;ISO 8601
     * format&lt;/a&gt; for which the service bases its broadcasts
     *
     * @see <a href="http://schema.org/broadcastTimezone">broadcastTimezone</a>
     */
    public static final IRI broadcastTimezone;

    /**
     * broker
     * <p>
     * {@code http://schema.org/broker}
     * <p>
     * An entity that arranges for an exchange between a buyer and a seller.
     * In most cases a broker never acquires or releases ownership of a
     * product or service involved in an exchange.  If it is not clear
     * whether an entity is a broker, seller, or buyer, the latter two terms
     * are preferred.
     *
     * @see <a href="http://schema.org/broker">broker</a>
     */
    public static final IRI broker;

    /**
     * BrokerageAccount
     * <p>
     * {@code http://schema.org/BrokerageAccount}
     * <p>
     * An account that allows an investor to deposit funds and place
     * investment orders with a licensed broker or brokerage firm.
     *
     * @see <a href="http://schema.org/BrokerageAccount">BrokerageAccount</a>
     */
    public static final IRI BrokerageAccount;

    /**
     * browserRequirements
     * <p>
     * {@code http://schema.org/browserRequirements}
     * <p>
     * Specifies browser requirements in human-readable text. For example,
     * &#39;requires HTML5 support&#39;.
     *
     * @see <a href="http://schema.org/browserRequirements">browserRequirements</a>
     */
    public static final IRI browserRequirements;

    /**
     * BuddhistTemple
     * <p>
     * {@code http://schema.org/BuddhistTemple}
     * <p>
     * A Buddhist temple.
     *
     * @see <a href="http://schema.org/BuddhistTemple">BuddhistTemple</a>
     */
    public static final IRI BuddhistTemple;

    /**
     * BusinessAudience
     * <p>
     * {@code http://schema.org/BusinessAudience}
     * <p>
     * A set of characteristics belonging to businesses, e.g. who compose an
     * item&#39;s target audience.
     *
     * @see <a href="http://schema.org/BusinessAudience">BusinessAudience</a>
     */
    public static final IRI BusinessAudience;

    /**
     * BusinessEntityType
     * <p>
     * {@code http://schema.org/BusinessEntityType}
     * <p>
     * A business entity type is a conceptual entity representing the legal
     * form, the size, the main line of business, the position in the value
     * chain, or any combination thereof, of an organization or business
     * person.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Commonly used
     * values:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#Business&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#Enduser&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#PublicInstitution&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#Reseller&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/BusinessEntityType">BusinessEntityType</a>
     */
    public static final IRI BusinessEntityType;

    /**
     * BusinessEvent
     * <p>
     * {@code http://schema.org/BusinessEvent}
     * <p>
     * Event type: Business event.
     *
     * @see <a href="http://schema.org/BusinessEvent">BusinessEvent</a>
     */
    public static final IRI BusinessEvent;

    /**
     * BusinessFunction
     * <p>
     * {@code http://schema.org/BusinessFunction}
     * <p>
     * The business function specifies the type of activity or access (i.e.,
     * the bundle of rights) offered by the organization or business person
     * through the offer. Typical are sell, rental or lease, maintenance or
     * repair, manufacture / produce, recycle / dispose, engineering /
     * construction, or installation. Proprietary specifications of access
     * rights are also instances of this
     * class.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Commonly used
     * values:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#ConstructionInstallation&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#Dispose&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#LeaseOut&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#Maintain&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#ProvideService&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#Repair&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#Sell&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#Buy&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/BusinessFunction">BusinessFunction</a>
     */
    public static final IRI BusinessFunction;

    /**
     * businessFunction
     * <p>
     * {@code http://schema.org/businessFunction}
     * <p>
     * The business function (e.g. sell, lease, repair, dispose) of the offer
     * or component of a bundle (TypeAndQuantityNode). The default is
     * http://purl.org/goodrelations/v1#Sell.
     *
     * @see <a href="http://schema.org/businessFunction">businessFunction</a>
     */
    public static final IRI businessFunction;

    /**
     * busName
     * <p>
     * {@code http://schema.org/busName}
     * <p>
     * The name of the bus (e.g. Bolt Express).
     *
     * @see <a href="http://schema.org/busName">busName</a>
     */
    public static final IRI busName;

    /**
     * busNumber
     * <p>
     * {@code http://schema.org/busNumber}
     * <p>
     * The unique identifier for the bus.
     *
     * @see <a href="http://schema.org/busNumber">busNumber</a>
     */
    public static final IRI busNumber;

    /**
     * BusOrCoach
     * <p>
     * {@code http://schema.org/BusOrCoach}
     * <p>
     * A bus (also omnibus or autobus) is a road vehicle designed to carry
     * passengers. Coaches are luxury busses, usually in service for long
     * distance travel.
     *
     * @see <a href="http://schema.org/BusOrCoach">BusOrCoach</a>
     */
    public static final IRI BusOrCoach;

    /**
     * BusReservation
     * <p>
     * {@code http://schema.org/BusReservation}
     * <p>
     * A reservation for bus travel. &lt;br/&gt;&lt;br/&gt;
     * <p>
     * Note: This type
     * is for information about actual reservations, e.g. in confirmation
     * emails or HTML pages with individual confirmations of reservations.
     * For offers of tickets, use &lt;a
     * href=&quot;http://schema.org/Offer&quot;&gt;Offer&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/BusReservation">BusReservation</a>
     */
    public static final IRI BusReservation;

    /**
     * BusStation
     * <p>
     * {@code http://schema.org/BusStation}
     * <p>
     * A bus station.
     *
     * @see <a href="http://schema.org/BusStation">BusStation</a>
     */
    public static final IRI BusStation;

    /**
     * BusStop
     * <p>
     * {@code http://schema.org/BusStop}
     * <p>
     * A bus stop.
     *
     * @see <a href="http://schema.org/BusStop">BusStop</a>
     */
    public static final IRI BusStop;

    /**
     * BusTrip
     * <p>
     * {@code http://schema.org/BusTrip}
     * <p>
     * A trip on a commercial bus line.
     *
     * @see <a href="http://schema.org/BusTrip">BusTrip</a>
     */
    public static final IRI BusTrip;

    /**
     * BuyAction
     * <p>
     * {@code http://schema.org/BuyAction}
     * <p>
     * The act of giving money to a seller in exchange for goods or services
     * rendered. An agent buys an object, product, or service from a seller
     * for a price. Reciprocal of SellAction.
     *
     * @see <a href="http://schema.org/BuyAction">BuyAction</a>
     */
    public static final IRI BuyAction;

    /**
     * buyer
     * <p>
     * {@code http://schema.org/buyer}
     * <p>
     * A sub property of participant. The participant/person/organization
     * that bought the object.
     *
     * @see <a href="http://schema.org/buyer">buyer</a>
     */
    public static final IRI buyer;

    /**
     * byArtist
     * <p>
     * {@code http://schema.org/byArtist}
     * <p>
     * The artist that performed this album or recording.
     *
     * @see <a href="http://schema.org/byArtist">byArtist</a>
     */
    public static final IRI byArtist;

    /**
     * byDay
     * <p>
     * {@code http://schema.org/byDay}
     * <p>
     * Defines the day(s) of the week on which a recurring &lt;a
     * href=&quot;http://schema.org/Event&quot;&gt;Event&lt;/a&gt; takes
     * place
     *
     * @see <a href="http://schema.org/byDay">byDay</a>
     */
    public static final IRI byDay;

    /**
     * byMonth
     * <p>
     * {@code http://schema.org/byMonth}
     * <p>
     * Defines the month(s) of the year on which a recurring &lt;a
     * href=&quot;http://schema.org/Event&quot;&gt;Event&lt;/a&gt; takes
     * place. Specified as an &lt;a
     * href=&quot;http://schema.org/Integer&quot;&gt;Integer&lt;/a&gt;
     * between 1-12. January is 1.
     *
     * @see <a href="http://schema.org/byMonth">byMonth</a>
     */
    public static final IRI byMonth;

    /**
     * byMonthDay
     * <p>
     * {@code http://schema.org/byMonthDay}
     * <p>
     * Defines the day(s) of the month on which a recurring &lt;a
     * href=&quot;http://schema.org/Event&quot;&gt;Event&lt;/a&gt; takes
     * place. Specified as an &lt;a
     * href=&quot;http://schema.org/Integer&quot;&gt;Integer&lt;/a&gt;
     * between 1-31.
     *
     * @see <a href="http://schema.org/byMonthDay">byMonthDay</a>
     */
    public static final IRI byMonthDay;

    /**
     * CableOrSatelliteService
     * <p>
     * {@code http://schema.org/CableOrSatelliteService}
     * <p>
     * A service which provides access to media programming like TV or radio.
     * Access may be via cable or satellite.
     *
     * @see <a href="http://schema.org/CableOrSatelliteService">CableOrSatelliteService</a>
     */
    public static final IRI CableOrSatelliteService;

    /**
     * CafeOrCoffeeShop
     * <p>
     * {@code http://schema.org/CafeOrCoffeeShop}
     * <p>
     * A cafe or coffee shop.
     *
     * @see <a href="http://schema.org/CafeOrCoffeeShop">CafeOrCoffeeShop</a>
     */
    public static final IRI CafeOrCoffeeShop;

    /**
     * calories
     * <p>
     * {@code http://schema.org/calories}
     * <p>
     * The number of calories.
     *
     * @see <a href="http://schema.org/calories">calories</a>
     */
    public static final IRI calories;

    /**
     * Campground
     * <p>
     * {@code http://schema.org/Campground}
     * <p>
     * A camping site, campsite, or campground is a place used for overnight
     * stay in the outdoors. In British English a campsite is an area,
     * usually divided into a number of pitches, where people can camp
     * overnight using tents or camper vans or caravans; this British English
     * use of the word is synonymous with the American English expression
     * campground. In American English the term campsite generally means an
     * area where an individual, family, group, or military unit can pitch a
     * tent or parks a camper; a campground may contain many campsites
     * (Source: Wikipedia, the free encyclopedia, see &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/Campsite&quot;&gt;http://en.wikipedia.org/wiki/Campsite&lt;/a&gt;).
     * &lt;br
     * /&gt;&lt;br /&gt;
     * See also the &lt;a
     * href=&quot;/docs/hotels.html&quot;&gt;dedicated document on the use of
     * schema.org for marking up hotels and other forms of
     * accommodations&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Campground">Campground</a>
     */
    public static final IRI Campground;

    /**
     * CampingPitch
     * <p>
     * {@code http://schema.org/CampingPitch}
     * <p>
     * A camping pitch is an individual place for overnight stay in the
     * outdoors, typically being part of a larger camping site.
     * &lt;br
     * /&gt;&lt;br /&gt;
     * See also the &lt;a
     * href=&quot;/docs/hotels.html&quot;&gt;dedicated document on the use of
     * schema.org for marking up hotels and other forms of
     * accommodations&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/CampingPitch">CampingPitch</a>
     */
    public static final IRI CampingPitch;

    /**
     * Canal
     * <p>
     * {@code http://schema.org/Canal}
     * <p>
     * A canal, like the Panama Canal.
     *
     * @see <a href="http://schema.org/Canal">Canal</a>
     */
    public static final IRI Canal;

    /**
     * CancelAction
     * <p>
     * {@code http://schema.org/CancelAction}
     * <p>
     * The act of asserting that a future event/action is no longer going to
     * happen.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/ConfirmAction&quot;&gt;ConfirmAction&lt;/a&gt;:
     * The antonym of CancelAction.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/CancelAction">CancelAction</a>
     */
    public static final IRI CancelAction;

    /**
     * candidate
     * <p>
     * {@code http://schema.org/candidate}
     * <p>
     * A sub property of object. The candidate subject of this action.
     *
     * @see <a href="http://schema.org/candidate">candidate</a>
     */
    public static final IRI candidate;

    /**
     * caption
     * <p>
     * {@code http://schema.org/caption}
     * <p>
     * The caption for this object.
     *
     * @see <a href="http://schema.org/caption">caption</a>
     */
    public static final IRI caption;

    /**
     * Car
     * <p>
     * {@code http://schema.org/Car}
     * <p>
     * A car is a wheeled, self-powered motor vehicle used for
     * transportation.
     *
     * @see <a href="http://schema.org/Car">Car</a>
     */
    public static final IRI Car;

    /**
     * carbohydrateContent
     * <p>
     * {@code http://schema.org/carbohydrateContent}
     * <p>
     * The number of grams of carbohydrates.
     *
     * @see <a href="http://schema.org/carbohydrateContent">carbohydrateContent</a>
     */
    public static final IRI carbohydrateContent;

    /**
     * cargoVolume
     * <p>
     * {@code http://schema.org/cargoVolume}
     * <p>
     * The available volume for cargo or luggage. For automobiles, this is
     * usually the trunk volume.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s):
     * LTR for liters, FTQ for cubic foot/feet&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Note:
     * You can use &lt;a
     * href=&quot;http://schema.org/minValue&quot;&gt;minValue&lt;/a&gt; and
     * &lt;a
     * href=&quot;http://schema.org/maxValue&quot;&gt;maxValue&lt;/a&gt; to
     * indicate ranges.
     *
     * @see <a href="http://schema.org/cargoVolume">cargoVolume</a>
     */
    public static final IRI cargoVolume;

    /**
     * carrier
     * <p>
     * {@code http://schema.org/carrier}
     * <p>
     * &#39;carrier&#39; is an out-dated term indicating the
     * &#39;provider&#39; for parcel delivery and flights.
     *
     * @see <a href="http://schema.org/carrier">carrier</a>
     */
    public static final IRI carrier;

    /**
     * carrierRequirements
     * <p>
     * {@code http://schema.org/carrierRequirements}
     * <p>
     * Specifies specific carrier(s) requirements for the application (e.g.
     * an application may only work on a specific carrier network).
     *
     * @see <a href="http://schema.org/carrierRequirements">carrierRequirements</a>
     */
    public static final IRI carrierRequirements;

    /**
     * CarUsageType
     * <p>
     * {@code http://schema.org/CarUsageType}
     * <p>
     * A value indicating a special usage of a car, e.g. commercial rental,
     * driving school, or as a taxi.
     *
     * @see <a href="http://schema.org/CarUsageType">CarUsageType</a>
     */
    public static final IRI CarUsageType;

    /**
     * cashBack
     * <p>
     * {@code http://schema.org/cashBack}
     * <p>
     * A cardholder benefit that pays the cardholder a small percentage of
     * their net expenditures.
     *
     * @see <a href="http://schema.org/cashBack">cashBack</a>
     */
    public static final IRI cashBack;

    /**
     * Casino
     * <p>
     * {@code http://schema.org/Casino}
     * <p>
     * A casino.
     *
     * @see <a href="http://schema.org/Casino">Casino</a>
     */
    public static final IRI Casino;

    /**
     * catalog
     * <p>
     * {@code http://schema.org/catalog}
     * <p>
     * A data catalog which contains this dataset.
     *
     * @see <a href="http://schema.org/catalog">catalog</a>
     */
    public static final IRI catalog;

    /**
     * catalogNumber
     * <p>
     * {@code http://schema.org/catalogNumber}
     * <p>
     * The catalog number for the release.
     *
     * @see <a href="http://schema.org/catalogNumber">catalogNumber</a>
     */
    public static final IRI catalogNumber;

    /**
     * category
     * <p>
     * {@code http://schema.org/category}
     * <p>
     * A category for the item. Greater signs or slashes can be used to
     * informally indicate a category hierarchy.
     *
     * @see <a href="http://schema.org/category">category</a>
     */
    public static final IRI category;

    /**
     * CategoryCode
     * <p>
     * {@code http://schema.org/CategoryCode}
     * <p>
     * A Category Code.
     *
     * @see <a href="http://schema.org/CategoryCode">CategoryCode</a>
     */
    public static final IRI CategoryCode;

    /**
     * CategoryCodeSet
     * <p>
     * {@code http://schema.org/CategoryCodeSet}
     * <p>
     * A set of Category Code values.
     *
     * @see <a href="http://schema.org/CategoryCodeSet">CategoryCodeSet</a>
     */
    public static final IRI CategoryCodeSet;

    /**
     * CatholicChurch
     * <p>
     * {@code http://schema.org/CatholicChurch}
     * <p>
     * A Catholic church.
     *
     * @see <a href="http://schema.org/CatholicChurch">CatholicChurch</a>
     */
    public static final IRI CatholicChurch;

    /**
     * cause
     * <p>
     * {@code http://schema.org/cause}
     * <p>
     * Specifying a cause of something in general. e.g in medicine , one of
     * the causative agent(s) that are most directly responsible for the
     * pathophysiologic process that eventually results in the occurrence.
     *
     * @see <a href="http://schema.org/cause">cause</a>
     */
    public static final IRI cause;

    /**
     * causeOf
     * <p>
     * {@code http://schema.org/causeOf}
     * <p>
     * The condition, complication, symptom, sign, etc. caused.
     *
     * @see <a href="http://schema.org/causeOf">causeOf</a>
     */
    public static final IRI causeOf;

    /**
     * ccRecipient
     * <p>
     * {@code http://schema.org/ccRecipient}
     * <p>
     * A sub property of recipient. The recipient copied on a message.
     *
     * @see <a href="http://schema.org/ccRecipient">ccRecipient</a>
     */
    public static final IRI ccRecipient;

    /**
     * Cemetery
     * <p>
     * {@code http://schema.org/Cemetery}
     * <p>
     * A graveyard.
     *
     * @see <a href="http://schema.org/Cemetery">Cemetery</a>
     */
    public static final IRI Cemetery;

    /**
     * Chapter
     * <p>
     * {@code http://schema.org/Chapter}
     * <p>
     * One of the sections into which a book is divided. A chapter usually
     * has a section number or a name.
     *
     * @see <a href="http://schema.org/Chapter">Chapter</a>
     */
    public static final IRI Chapter;

    /**
     * character
     * <p>
     * {@code http://schema.org/character}
     * <p>
     * Fictional person connected with a creative work.
     *
     * @see <a href="http://schema.org/character">character</a>
     */
    public static final IRI character;

    /**
     * characterAttribute
     * <p>
     * {@code http://schema.org/characterAttribute}
     * <p>
     * A piece of data that represents a particular aspect of a fictional
     * character (skill, power, character points, advantage, disadvantage).
     *
     * @see <a href="http://schema.org/characterAttribute">characterAttribute</a>
     */
    public static final IRI characterAttribute;

    /**
     * characterName
     * <p>
     * {@code http://schema.org/characterName}
     * <p>
     * The name of a character played in some acting or performing role, i.e.
     * in a PerformanceRole.
     *
     * @see <a href="http://schema.org/characterName">characterName</a>
     */
    public static final IRI characterName;

    /**
     * cheatCode
     * <p>
     * {@code http://schema.org/cheatCode}
     * <p>
     * Cheat codes to the game.
     *
     * @see <a href="http://schema.org/cheatCode">cheatCode</a>
     */
    public static final IRI cheatCode;

    /**
     * CheckAction
     * <p>
     * {@code http://schema.org/CheckAction}
     * <p>
     * An agent inspects, determines, investigates, inquires, or examines an
     * object&#39;s accuracy, quality, condition, or state.
     *
     * @see <a href="http://schema.org/CheckAction">CheckAction</a>
     */
    public static final IRI CheckAction;

    /**
     * CheckInAction
     * <p>
     * {@code http://schema.org/CheckInAction}
     * <p>
     * The act of an agent communicating (service provider, social media,
     * etc) their arrival by registering/confirming for a previously reserved
     * service (e.g. flight check in) or at a place (e.g. hotel), possibly
     * resulting in a result (boarding pass,
     * etc).&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/CheckOutAction&quot;&gt;CheckOutAction&lt;/a&gt;:
     * The antonym of CheckInAction.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/ArriveAction&quot;&gt;ArriveAction&lt;/a&gt;:
     * Unlike ArriveAction, CheckInAction implies that the agent is
     * informing/confirming the start of a previously reserved
     * service.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/ConfirmAction&quot;&gt;ConfirmAction&lt;/a&gt;:
     * Unlike ConfirmAction, CheckInAction implies that the agent is
     * informing/confirming the &lt;em&gt;start&lt;/em&gt; of a previously
     * reserved service rather than its
     * validity/existence.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/CheckInAction">CheckInAction</a>
     */
    public static final IRI CheckInAction;

    /**
     * checkinTime
     * <p>
     * {@code http://schema.org/checkinTime}
     * <p>
     * The earliest someone may check into a lodging establishment.
     *
     * @see <a href="http://schema.org/checkinTime">checkinTime</a>
     */
    public static final IRI checkinTime;

    /**
     * CheckOutAction
     * <p>
     * {@code http://schema.org/CheckOutAction}
     * <p>
     * The act of an agent communicating (service provider, social media,
     * etc) their departure of a previously reserved service (e.g. flight
     * check in) or place (e.g. hotel).&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/CheckInAction&quot;&gt;CheckInAction&lt;/a&gt;:
     * The antonym of CheckOutAction.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/DepartAction&quot;&gt;DepartAction&lt;/a&gt;:
     * Unlike DepartAction, CheckOutAction implies that the agent is
     * informing/confirming the end of a previously reserved
     * service.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/CancelAction&quot;&gt;CancelAction&lt;/a&gt;:
     * Unlike CancelAction, CheckOutAction implies that the agent is
     * informing/confirming the end of a previously reserved
     * service.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/CheckOutAction">CheckOutAction</a>
     */
    public static final IRI CheckOutAction;

    /**
     * CheckoutPage
     * <p>
     * {@code http://schema.org/CheckoutPage}
     * <p>
     * Web page type: Checkout page.
     *
     * @see <a href="http://schema.org/CheckoutPage">CheckoutPage</a>
     */
    public static final IRI CheckoutPage;

    /**
     * checkoutTime
     * <p>
     * {@code http://schema.org/checkoutTime}
     * <p>
     * The latest someone may check out of a lodging establishment.
     *
     * @see <a href="http://schema.org/checkoutTime">checkoutTime</a>
     */
    public static final IRI checkoutTime;

    /**
     * ChildCare
     * <p>
     * {@code http://schema.org/ChildCare}
     * <p>
     * A Childcare center.
     *
     * @see <a href="http://schema.org/ChildCare">ChildCare</a>
     */
    public static final IRI ChildCare;

    /**
     * childMaxAge
     * <p>
     * {@code http://schema.org/childMaxAge}
     * <p>
     * Maximal age of the child.
     *
     * @see <a href="http://schema.org/childMaxAge">childMaxAge</a>
     */
    public static final IRI childMaxAge;

    /**
     * childMinAge
     * <p>
     * {@code http://schema.org/childMinAge}
     * <p>
     * Minimal age of the child.
     *
     * @see <a href="http://schema.org/childMinAge">childMinAge</a>
     */
    public static final IRI childMinAge;

    /**
     * children
     * <p>
     * {@code http://schema.org/children}
     * <p>
     * A child of the person.
     *
     * @see <a href="http://schema.org/children">children</a>
     */
    public static final IRI children;

    /**
     * ChildrensEvent
     * <p>
     * {@code http://schema.org/ChildrensEvent}
     * <p>
     * Event type: Children&#39;s event.
     *
     * @see <a href="http://schema.org/ChildrensEvent">ChildrensEvent</a>
     */
    public static final IRI ChildrensEvent;

    /**
     * cholesterolContent
     * <p>
     * {@code http://schema.org/cholesterolContent}
     * <p>
     * The number of milligrams of cholesterol.
     *
     * @see <a href="http://schema.org/cholesterolContent">cholesterolContent</a>
     */
    public static final IRI cholesterolContent;

    /**
     * ChooseAction
     * <p>
     * {@code http://schema.org/ChooseAction}
     * <p>
     * The act of expressing a preference from a set of options or a large or
     * unbounded set of choices/options.
     *
     * @see <a href="http://schema.org/ChooseAction">ChooseAction</a>
     */
    public static final IRI ChooseAction;

    /**
     * Church
     * <p>
     * {@code http://schema.org/Church}
     * <p>
     * A church.
     *
     * @see <a href="http://schema.org/Church">Church</a>
     */
    public static final IRI Church;

    /**
     * circle
     * <p>
     * {@code http://schema.org/circle}
     * <p>
     * A circle is the circular region of a specified radius centered at a
     * specified latitude and longitude. A circle is expressed as a pair
     * followed by a radius in meters.
     *
     * @see <a href="http://schema.org/circle">circle</a>
     */
    public static final IRI circle;

    /**
     * citation
     * <p>
     * {@code http://schema.org/citation}
     * <p>
     * A citation or reference to another creative work, such as another
     * publication, web page, scholarly article, etc.
     *
     * @see <a href="http://schema.org/citation">citation</a>
     */
    public static final IRI citation;

    /**
     * City
     * <p>
     * {@code http://schema.org/City}
     * <p>
     * A city or town.
     *
     * @see <a href="http://schema.org/City">City</a>
     */
    public static final IRI City;

    /**
     * CityHall
     * <p>
     * {@code http://schema.org/CityHall}
     * <p>
     * A city hall.
     *
     * @see <a href="http://schema.org/CityHall">CityHall</a>
     */
    public static final IRI CityHall;

    /**
     * CivicStructure
     * <p>
     * {@code http://schema.org/CivicStructure}
     * <p>
     * A public structure, such as a town hall or concert hall.
     *
     * @see <a href="http://schema.org/CivicStructure">CivicStructure</a>
     */
    public static final IRI CivicStructure;

    /**
     * Claim
     * <p>
     * {@code http://schema.org/Claim}
     * <p>
     * A &lt;a href=&quot;http://schema.org/Claim&quot;&gt;Claim&lt;/a&gt; in
     * Schema.org represents a specific, factually-oriented claim that could
     * be the &lt;a
     * href=&quot;http://schema.org/itemReviewed&quot;&gt;itemReviewed&lt;/a&gt;
     * in a &lt;a
     * href=&quot;http://schema.org/ClaimReview&quot;&gt;ClaimReview&lt;/a&gt;.
     * The content of a claim can be summarized with the &lt;a
     * href=&quot;http://schema.org/text&quot;&gt;text&lt;/a&gt; property.
     * Variations on well known claims can have their common identity
     * indicated via &lt;a
     * href=&quot;http://schema.org/sameAs&quot;&gt;sameAs&lt;/a&gt; links,
     * and summarized with a &lt;a
     * href=&quot;http://schema.org/name&quot;&gt;name&lt;/a&gt;. Ideally, a
     * &lt;a href=&quot;http://schema.org/Claim&quot;&gt;Claim&lt;/a&gt;
     * description includes enough contextual information to minimize the
     * risk of ambiguity or inclarity. In practice, many claims are better
     * understood in the context in which they appear or the interpretations
     * provided by claim reviews.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Beyond &lt;a
     * href=&quot;http://schema.org/ClaimReview&quot;&gt;ClaimReview&lt;/a&gt;,
     * the Claim type can be associated with related creative works - for
     * example a &lt;a
     * href=&quot;http://schema.org/ScholaryArticle&quot;&gt;ScholaryArticle&lt;/a&gt;
     * or &lt;a
     * href=&quot;http://schema.org/Question&quot;&gt;Question&lt;/a&gt;
     * might be &lt;a
     * href=&quot;http://schema.org/about&quot;&gt;about&lt;/a&gt; some &lt;a
     * href=&quot;http://schema.org/Claim&quot;&gt;Claim&lt;/a&gt;.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * At
     * this time, Schema.org does not define any types of relationship
     * between claims. This is a natural area for future exploration.
     *
     * @see <a href="http://schema.org/Claim">Claim</a>
     */
    public static final IRI Claim;

    /**
     * ClaimReview
     * <p>
     * {@code http://schema.org/ClaimReview}
     * <p>
     * A fact-checking review of claims made (or reported) in some creative
     * work (referenced via itemReviewed).
     *
     * @see <a href="http://schema.org/ClaimReview">ClaimReview</a>
     */
    public static final IRI ClaimReview;

    /**
     * claimReviewed
     * <p>
     * {@code http://schema.org/claimReviewed}
     * <p>
     * A short summary of the specific claims reviewed in a ClaimReview.
     *
     * @see <a href="http://schema.org/claimReviewed">claimReviewed</a>
     */
    public static final IRI claimReviewed;

    /**
     * Class
     * <p>
     * {@code http://schema.org/Class}
     * <p>
     * A class, also often called a &#39;Type&#39;; equivalent to rdfs:Class.
     *
     * @see <a href="http://schema.org/Class">Class</a>
     */
    public static final IRI Class;

    /**
     * clincalPharmacology
     * <p>
     * {@code http://schema.org/clincalPharmacology}
     * <p>
     * Description of the absorption and elimination of drugs, including
     * their concentration (pharmacokinetics, pK) and biological effects
     * (pharmacodynamics, pD).
     *
     * @see <a href="http://schema.org/clincalPharmacology">clincalPharmacology</a>
     */
    public static final IRI clincalPharmacology;

    /**
     * clinicalPharmacology
     * <p>
     * {@code http://schema.org/clinicalPharmacology}
     * <p>
     * Description of the absorption and elimination of drugs, including
     * their concentration (pharmacokinetics, pK) and biological effects
     * (pharmacodynamics, pD).
     *
     * @see <a href="http://schema.org/clinicalPharmacology">clinicalPharmacology</a>
     */
    public static final IRI clinicalPharmacology;

    /**
     * Clip
     * <p>
     * {@code http://schema.org/Clip}
     * <p>
     * A short TV or radio program or a segment/part of a program.
     *
     * @see <a href="http://schema.org/Clip">Clip</a>
     */
    public static final IRI Clip;

    /**
     * clipNumber
     * <p>
     * {@code http://schema.org/clipNumber}
     * <p>
     * Position of the clip within an ordered group of clips.
     *
     * @see <a href="http://schema.org/clipNumber">clipNumber</a>
     */
    public static final IRI clipNumber;

    /**
     * closes
     * <p>
     * {@code http://schema.org/closes}
     * <p>
     * The closing hour of the place or service on the given day(s) of the
     * week.
     *
     * @see <a href="http://schema.org/closes">closes</a>
     */
    public static final IRI closes;

    /**
     * ClothingStore
     * <p>
     * {@code http://schema.org/ClothingStore}
     * <p>
     * A clothing store.
     *
     * @see <a href="http://schema.org/ClothingStore">ClothingStore</a>
     */
    public static final IRI ClothingStore;

    /**
     * coach
     * <p>
     * {@code http://schema.org/coach}
     * <p>
     * A person that acts in a coaching role for a sports team.
     *
     * @see <a href="http://schema.org/coach">coach</a>
     */
    public static final IRI coach;

    /**
     * Code
     * <p>
     * {@code http://schema.org/Code}
     * <p>
     * Computer programming source code. Example: Full (compile ready)
     * solutions, code snippet samples, scripts, templates.
     *
     * @see <a href="http://schema.org/Code">Code</a>
     */
    public static final IRI Code;

    /**
     * code
     * <p>
     * {@code http://schema.org/code}
     * <p>
     * A medical code for the entity, taken from a controlled vocabulary or
     * ontology such as ICD-9, DiseasesDB, MeSH, SNOMED-CT, RxNorm, etc.
     *
     * @see <a href="http://schema.org/code">code</a>
     */
    public static final IRI code;

    /**
     * codeRepository
     * <p>
     * {@code http://schema.org/codeRepository}
     * <p>
     * Link to the repository where the un-compiled, human readable code and
     * related code is located (SVN, github, CodePlex).
     *
     * @see <a href="http://schema.org/codeRepository">codeRepository</a>
     */
    public static final IRI codeRepository;

    /**
     * codeSampleType
     * <p>
     * {@code http://schema.org/codeSampleType}
     * <p>
     * What type of code sample: full (compile ready) solution, code snippet,
     * inline code, scripts, template.
     *
     * @see <a href="http://schema.org/codeSampleType">codeSampleType</a>
     */
    public static final IRI codeSampleType;

    /**
     * codeValue
     * <p>
     * {@code http://schema.org/codeValue}
     * <p>
     * A short textual code that uniquely identifies the value.
     *
     * @see <a href="http://schema.org/codeValue">codeValue</a>
     */
    public static final IRI codeValue;

    /**
     * codingSystem
     * <p>
     * {@code http://schema.org/codingSystem}
     * <p>
     * The coding system, e.g. &#39;ICD-10&#39;.
     *
     * @see <a href="http://schema.org/codingSystem">codingSystem</a>
     */
    public static final IRI codingSystem;

    /**
     * colleague
     * <p>
     * {@code http://schema.org/colleague}
     * <p>
     * A colleague of the person.
     *
     * @see <a href="http://schema.org/colleague">colleague</a>
     */
    public static final IRI colleague;

    /**
     * colleagues
     * <p>
     * {@code http://schema.org/colleagues}
     * <p>
     * A colleague of the person.
     *
     * @see <a href="http://schema.org/colleagues">colleagues</a>
     */
    public static final IRI colleagues;

    /**
     * Collection
     * <p>
     * {@code http://schema.org/Collection}
     * <p>
     * A created collection of Creative Works or other artefacts.
     *
     * @see <a href="http://schema.org/Collection">Collection</a>
     */
    public static final IRI Collection;

    /**
     * collection
     * <p>
     * {@code http://schema.org/collection}
     * <p>
     * A sub property of object. The collection target of the action.
     *
     * @see <a href="http://schema.org/collection">collection</a>
     */
    public static final IRI collection;

    /**
     * CollectionPage
     * <p>
     * {@code http://schema.org/CollectionPage}
     * <p>
     * Web page type: Collection page.
     *
     * @see <a href="http://schema.org/CollectionPage">CollectionPage</a>
     */
    public static final IRI CollectionPage;

    /**
     * CollegeOrUniversity
     * <p>
     * {@code http://schema.org/CollegeOrUniversity}
     * <p>
     * A college, university, or other third-level educational institution.
     *
     * @see <a href="http://schema.org/CollegeOrUniversity">CollegeOrUniversity</a>
     */
    public static final IRI CollegeOrUniversity;

    /**
     * color
     * <p>
     * {@code http://schema.org/color}
     * <p>
     * The color of the product.
     *
     * @see <a href="http://schema.org/color">color</a>
     */
    public static final IRI color;

    /**
     * colorist
     * <p>
     * {@code http://schema.org/colorist}
     * <p>
     * The individual who adds color to inked drawings.
     *
     * @see <a href="http://schema.org/colorist">colorist</a>
     */
    public static final IRI colorist;

    /**
     * ComedyClub
     * <p>
     * {@code http://schema.org/ComedyClub}
     * <p>
     * A comedy club.
     *
     * @see <a href="http://schema.org/ComedyClub">ComedyClub</a>
     */
    public static final IRI ComedyClub;

    /**
     * ComedyEvent
     * <p>
     * {@code http://schema.org/ComedyEvent}
     * <p>
     * Event type: Comedy event.
     *
     * @see <a href="http://schema.org/ComedyEvent">ComedyEvent</a>
     */
    public static final IRI ComedyEvent;

    /**
     * ComicCoverArt
     * <p>
     * {@code http://schema.org/ComicCoverArt}
     * <p>
     * The artwork on the cover of a comic.
     *
     * @see <a href="http://schema.org/ComicCoverArt">ComicCoverArt</a>
     */
    public static final IRI ComicCoverArt;

    /**
     * ComicIssue
     * <p>
     * {@code http://schema.org/ComicIssue}
     * <p>
     * Individual comic issues are serially published as
     * part of a larger
     * series. For the sake of consistency, even one-shot issues
     * belong
     * to a series comprised of a single issue. All comic issues can be
     * <p>
     * uniquely identified by: the combination of the name and volume number
     * of the
     * series to which the issue belongs; the issue number; and
     * the variant
     * description of the issue (if any).
     *
     * @see <a href="http://schema.org/ComicIssue">ComicIssue</a>
     */
    public static final IRI ComicIssue;

    /**
     * ComicSeries
     * <p>
     * {@code http://schema.org/ComicSeries}
     * <p>
     * A sequential publication of comic stories under a
     * unifying title,
     * for example &quot;The Amazing Spider-Man&quot; or &quot;Groo the
     * <p>
     * Wanderer&quot;.
     *
     * @see <a href="http://schema.org/ComicSeries">ComicSeries</a>
     */
    public static final IRI ComicSeries;

    /**
     * ComicStory
     * <p>
     * {@code http://schema.org/ComicStory}
     * <p>
     * The term &quot;story&quot; is any indivisible, re-printable
     * unit
     * of a comic, including the interior stories, covers, and backmatter.
     * Most
     * comics have at least two stories: a cover (ComicCoverArt) and
     * an interior story.
     *
     * @see <a href="http://schema.org/ComicStory">ComicStory</a>
     */
    public static final IRI ComicStory;

    /**
     * comment
     * <p>
     * {@code http://schema.org/comment}
     * <p>
     * Comments, typically from users.
     *
     * @see <a href="http://schema.org/comment">comment</a>
     */
    public static final IRI comment;

    /**
     * Comment
     * <p>
     * {@code http://schema.org/Comment}
     * <p>
     * A comment on an item - for example, a comment on a blog post. The
     * comment&#39;s content is expressed via the &lt;a
     * href=&quot;http://schema.org/text&quot;&gt;text&lt;/a&gt; property,
     * and its topic via &lt;a
     * href=&quot;http://schema.org/about&quot;&gt;about&lt;/a&gt;,
     * properties shared with all CreativeWorks.
     *
     * @see <a href="http://schema.org/Comment">Comment</a>
     */
    public static final IRI Comment;

    /**
     * CommentAction
     * <p>
     * {@code http://schema.org/CommentAction}
     * <p>
     * The act of generating a comment about a subject.
     *
     * @see <a href="http://schema.org/CommentAction">CommentAction</a>
     */
    public static final IRI CommentAction;

    /**
     * commentCount
     * <p>
     * {@code http://schema.org/commentCount}
     * <p>
     * The number of comments this CreativeWork (e.g. Article, Question or
     * Answer) has received. This is most applicable to works published in
     * Web sites with commenting system; additional comments may exist
     * elsewhere.
     *
     * @see <a href="http://schema.org/commentCount">commentCount</a>
     */
    public static final IRI commentCount;

    /**
     * commentText
     * <p>
     * {@code http://schema.org/commentText}
     * <p>
     * The text of the UserComment.
     *
     * @see <a href="http://schema.org/commentText">commentText</a>
     */
    public static final IRI commentText;

    /**
     * commentTime
     * <p>
     * {@code http://schema.org/commentTime}
     * <p>
     * The time at which the UserComment was made.
     *
     * @see <a href="http://schema.org/commentTime">commentTime</a>
     */
    public static final IRI commentTime;

    /**
     * CommunicateAction
     * <p>
     * {@code http://schema.org/CommunicateAction}
     * <p>
     * The act of conveying information to another person via a communication
     * medium (instrument) such as speech, email, or telephone conversation.
     *
     * @see <a href="http://schema.org/CommunicateAction">CommunicateAction</a>
     */
    public static final IRI CommunicateAction;

    /**
     * competitor
     * <p>
     * {@code http://schema.org/competitor}
     * <p>
     * A competitor in a sports event.
     *
     * @see <a href="http://schema.org/competitor">competitor</a>
     */
    public static final IRI competitor;

    /**
     * CompleteDataFeed
     * <p>
     * {@code http://schema.org/CompleteDataFeed}
     * <p>
     * A &lt;a
     * href=&quot;http://schema.org/CompleteDataFeed&quot;&gt;CompleteDataFeed&lt;/a&gt;
     * is a &lt;a
     * href=&quot;http://schema.org/DataFeed&quot;&gt;DataFeed&lt;/a&gt;
     * whose standard representation includes content for every item
     * currently in the feed.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * This is the equivalent
     * of Atom&#39;s element as defined in Feed Paging and Archiving &lt;a
     * href=&quot;https://tools.ietf.org/html/rfc5005&quot;&gt;RFC
     * 5005&lt;/a&gt;, For example (and as defined for Atom), when using data
     * from a feed that represents a collection of items that varies over
     * time (e.g. &quot;Top Twenty Records&quot;) there is no need to have
     * newer entries mixed in alongside older, obsolete entries. By marking
     * this feed as a CompleteDataFeed, old entries can be safely discarded
     * when the feed is refreshed, since we can assume the feed has provided
     * descriptions for all current items.
     *
     * @see <a href="http://schema.org/CompleteDataFeed">CompleteDataFeed</a>
     */
    public static final IRI CompleteDataFeed;

    /**
     * composer
     * <p>
     * {@code http://schema.org/composer}
     * <p>
     * The person or organization who wrote a composition, or who is the
     * composer of a work performed at some event.
     *
     * @see <a href="http://schema.org/composer">composer</a>
     */
    public static final IRI composer;

    /**
     * CompoundPriceSpecification
     * <p>
     * {@code http://schema.org/CompoundPriceSpecification}
     * <p>
     * A compound price specification is one that bundles multiple prices
     * that all apply in combination for different dimensions of consumption.
     * Use the name property of the attached unit price specification for
     * indicating the dimension of a price component (e.g.
     * &quot;electricity&quot; or &quot;final cleaning&quot;).
     *
     * @see <a href="http://schema.org/CompoundPriceSpecification">CompoundPriceSpecification</a>
     */
    public static final IRI CompoundPriceSpecification;

    /**
     * comprisedOf
     * <p>
     * {@code http://schema.org/comprisedOf}
     * <p>
     * Specifying something physically contained by something else. Typically
     * used here for the underlying anatomical structures, such as organs,
     * that comprise the anatomical system.
     *
     * @see <a href="http://schema.org/comprisedOf">comprisedOf</a>
     */
    public static final IRI comprisedOf;

    /**
     * ComputerLanguage
     * <p>
     * {@code http://schema.org/ComputerLanguage}
     * <p>
     * This type covers computer programming languages such as Scheme and
     * Lisp, as well as other language-like computer representations. Natural
     * languages are best represented with the &lt;a
     * href=&quot;http://schema.org/Language&quot;&gt;Language&lt;/a&gt;
     * type.
     *
     * @see <a href="http://schema.org/ComputerLanguage">ComputerLanguage</a>
     */
    public static final IRI ComputerLanguage;

    /**
     * ComputerStore
     * <p>
     * {@code http://schema.org/ComputerStore}
     * <p>
     * A computer store.
     *
     * @see <a href="http://schema.org/ComputerStore">ComputerStore</a>
     */
    public static final IRI ComputerStore;

    /**
     * ConfirmAction
     * <p>
     * {@code http://schema.org/ConfirmAction}
     * <p>
     * The act of notifying someone that a future event/action is going to
     * happen as expected.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/CancelAction&quot;&gt;CancelAction&lt;/a&gt;:
     * The antonym of ConfirmAction.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/ConfirmAction">ConfirmAction</a>
     */
    public static final IRI ConfirmAction;

    /**
     * confirmationNumber
     * <p>
     * {@code http://schema.org/confirmationNumber}
     * <p>
     * A number that confirms the given order or payment has been received.
     *
     * @see <a href="http://schema.org/confirmationNumber">confirmationNumber</a>
     */
    public static final IRI confirmationNumber;

    /**
     * connectedTo
     * <p>
     * {@code http://schema.org/connectedTo}
     * <p>
     * Other anatomical structures to which this structure is connected.
     *
     * @see <a href="http://schema.org/connectedTo">connectedTo</a>
     */
    public static final IRI connectedTo;

    /**
     * Consortium
     * <p>
     * {@code http://schema.org/Consortium}
     * <p>
     * A Consortium is a membership &lt;a
     * href=&quot;http://schema.org/Organization&quot;&gt;Organization&lt;/a&gt;
     * whose members are typically Organizations.
     *
     * @see <a href="http://schema.org/Consortium">Consortium</a>
     */
    public static final IRI Consortium;

    /**
     * ConsumeAction
     * <p>
     * {@code http://schema.org/ConsumeAction}
     * <p>
     * The act of ingesting information/resources/food.
     *
     * @see <a href="http://schema.org/ConsumeAction">ConsumeAction</a>
     */
    public static final IRI ConsumeAction;

    /**
     * contactlessPayment
     * <p>
     * {@code http://schema.org/contactlessPayment}
     * <p>
     * A secure method for consumers to purchase products or services via
     * debit, credit or smartcards by using RFID or NFC technology.
     *
     * @see <a href="http://schema.org/contactlessPayment">contactlessPayment</a>
     */
    public static final IRI contactlessPayment;

    /**
     * contactOption
     * <p>
     * {@code http://schema.org/contactOption}
     * <p>
     * An option available on this contact point (e.g. a toll-free number or
     * support for hearing-impaired callers).
     *
     * @see <a href="http://schema.org/contactOption">contactOption</a>
     */
    public static final IRI contactOption;

    /**
     * ContactPage
     * <p>
     * {@code http://schema.org/ContactPage}
     * <p>
     * Web page type: Contact page.
     *
     * @see <a href="http://schema.org/ContactPage">ContactPage</a>
     */
    public static final IRI ContactPage;

    /**
     * ContactPoint
     * <p>
     * {@code http://schema.org/ContactPoint}
     * <p>
     * A contact point&amp;#x2014;for example, a Customer Complaints
     * department.
     *
     * @see <a href="http://schema.org/ContactPoint">ContactPoint</a>
     */
    public static final IRI ContactPoint;

    /**
     * contactPoint
     * <p>
     * {@code http://schema.org/contactPoint}
     * <p>
     * A contact point for a person or organization.
     *
     * @see <a href="http://schema.org/contactPoint">contactPoint</a>
     */
    public static final IRI contactPoint;

    /**
     * ContactPointOption
     * <p>
     * {@code http://schema.org/ContactPointOption}
     * <p>
     * Enumerated options related to a ContactPoint.
     *
     * @see <a href="http://schema.org/ContactPointOption">ContactPointOption</a>
     */
    public static final IRI ContactPointOption;

    /**
     * contactPoints
     * <p>
     * {@code http://schema.org/contactPoints}
     * <p>
     * A contact point for a person or organization.
     *
     * @see <a href="http://schema.org/contactPoints">contactPoints</a>
     */
    public static final IRI contactPoints;

    /**
     * contactType
     * <p>
     * {@code http://schema.org/contactType}
     * <p>
     * A person or organization can have different contact points, for
     * different purposes. For example, a sales contact point, a PR contact
     * point and so on. This property is used to specify the kind of contact
     * point.
     *
     * @see <a href="http://schema.org/contactType">contactType</a>
     */
    public static final IRI contactType;

    /**
     * containedIn
     * <p>
     * {@code http://schema.org/containedIn}
     * <p>
     * The basic containment relation between a place and one that contains
     * it.
     *
     * @see <a href="http://schema.org/containedIn">containedIn</a>
     */
    public static final IRI containedIn;

    /**
     * containedInPlace
     * <p>
     * {@code http://schema.org/containedInPlace}
     * <p>
     * The basic containment relation between a place and one that contains
     * it.
     *
     * @see <a href="http://schema.org/containedInPlace">containedInPlace</a>
     */
    public static final IRI containedInPlace;

    /**
     * containsPlace
     * <p>
     * {@code http://schema.org/containsPlace}
     * <p>
     * The basic containment relation between a place and another that it
     * contains.
     *
     * @see <a href="http://schema.org/containsPlace">containsPlace</a>
     */
    public static final IRI containsPlace;

    /**
     * containsSeason
     * <p>
     * {@code http://schema.org/containsSeason}
     * <p>
     * A season that is part of the media series.
     *
     * @see <a href="http://schema.org/containsSeason">containsSeason</a>
     */
    public static final IRI containsSeason;

    /**
     * contentLocation
     * <p>
     * {@code http://schema.org/contentLocation}
     * <p>
     * The location depicted or described in the content. For example, the
     * location in a photograph or painting.
     *
     * @see <a href="http://schema.org/contentLocation">contentLocation</a>
     */
    public static final IRI contentLocation;

    /**
     * contentRating
     * <p>
     * {@code http://schema.org/contentRating}
     * <p>
     * Official rating of a piece of content&amp;#x2014;for example,&#39;MPAA
     * PG-13&#39;.
     *
     * @see <a href="http://schema.org/contentRating">contentRating</a>
     */
    public static final IRI contentRating;

    /**
     * contentReferenceTime
     * <p>
     * {@code http://schema.org/contentReferenceTime}
     * <p>
     * The specific time described by a creative work, for works (e.g.
     * articles, video objects etc.) that emphasise a particular moment
     * within an Event.
     *
     * @see <a href="http://schema.org/contentReferenceTime">contentReferenceTime</a>
     */
    public static final IRI contentReferenceTime;

    /**
     * contentSize
     * <p>
     * {@code http://schema.org/contentSize}
     * <p>
     * File size in (mega/kilo) bytes.
     *
     * @see <a href="http://schema.org/contentSize">contentSize</a>
     */
    public static final IRI contentSize;

    /**
     * contentType
     * <p>
     * {@code http://schema.org/contentType}
     * <p>
     * The supported content type(s) for an EntryPoint response.
     *
     * @see <a href="http://schema.org/contentType">contentType</a>
     */
    public static final IRI contentType;

    /**
     * contentUrl
     * <p>
     * {@code http://schema.org/contentUrl}
     * <p>
     * Actual bytes of the media object, for example the image file or video
     * file.
     *
     * @see <a href="http://schema.org/contentUrl">contentUrl</a>
     */
    public static final IRI contentUrl;

    /**
     * Continent
     * <p>
     * {@code http://schema.org/Continent}
     * <p>
     * One of the continents (for example, Europe or Africa).
     *
     * @see <a href="http://schema.org/Continent">Continent</a>
     */
    public static final IRI Continent;

    /**
     * contraindication
     * <p>
     * {@code http://schema.org/contraindication}
     * <p>
     * A contraindication for this therapy.
     *
     * @see <a href="http://schema.org/contraindication">contraindication</a>
     */
    public static final IRI contraindication;

    /**
     * contributor
     * <p>
     * {@code http://schema.org/contributor}
     * <p>
     * A secondary contributor to the CreativeWork or Event.
     *
     * @see <a href="http://schema.org/contributor">contributor</a>
     */
    public static final IRI contributor;

    /**
     * ControlAction
     * <p>
     * {@code http://schema.org/ControlAction}
     * <p>
     * An agent controls a device or application.
     *
     * @see <a href="http://schema.org/ControlAction">ControlAction</a>
     */
    public static final IRI ControlAction;

    /**
     * ConvenienceStore
     * <p>
     * {@code http://schema.org/ConvenienceStore}
     * <p>
     * A convenience store.
     *
     * @see <a href="http://schema.org/ConvenienceStore">ConvenienceStore</a>
     */
    public static final IRI ConvenienceStore;

    /**
     * Conversation
     * <p>
     * {@code http://schema.org/Conversation}
     * <p>
     * One or more messages between organizations or people on a particular
     * topic. Individual messages can be linked to the conversation with
     * isPartOf or hasPart properties.
     *
     * @see <a href="http://schema.org/Conversation">Conversation</a>
     */
    public static final IRI Conversation;

    /**
     * CookAction
     * <p>
     * {@code http://schema.org/CookAction}
     * <p>
     * The act of producing/preparing food.
     *
     * @see <a href="http://schema.org/CookAction">CookAction</a>
     */
    public static final IRI CookAction;

    /**
     * cookingMethod
     * <p>
     * {@code http://schema.org/cookingMethod}
     * <p>
     * The method of cooking, such as Frying, Steaming, ...
     *
     * @see <a href="http://schema.org/cookingMethod">cookingMethod</a>
     */
    public static final IRI cookingMethod;

    /**
     * cookTime
     * <p>
     * {@code http://schema.org/cookTime}
     * <p>
     * The time it takes to actually cook the dish, in &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/ISO_8601&quot;&gt;ISO 8601
     * duration format&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/cookTime">cookTime</a>
     */
    public static final IRI cookTime;

    /**
     * copyrightHolder
     * <p>
     * {@code http://schema.org/copyrightHolder}
     * <p>
     * The party holding the legal copyright to the CreativeWork.
     *
     * @see <a href="http://schema.org/copyrightHolder">copyrightHolder</a>
     */
    public static final IRI copyrightHolder;

    /**
     * copyrightYear
     * <p>
     * {@code http://schema.org/copyrightYear}
     * <p>
     * The year during which the claimed copyright for the CreativeWork was
     * first asserted.
     *
     * @see <a href="http://schema.org/copyrightYear">copyrightYear</a>
     */
    public static final IRI copyrightYear;

    /**
     * Corporation
     * <p>
     * {@code http://schema.org/Corporation}
     * <p>
     * Organization: A business corporation.
     *
     * @see <a href="http://schema.org/Corporation">Corporation</a>
     */
    public static final IRI Corporation;

    /**
     * correctionsPolicy
     * <p>
     * {@code http://schema.org/correctionsPolicy}
     * <p>
     * For an &lt;a
     * href=&quot;http://schema.org/Organization&quot;&gt;Organization&lt;/a&gt;
     * (e.g. &lt;a
     * href=&quot;http://schema.org/NewsMediaOrganization&quot;&gt;NewsMediaOrganization&lt;/a&gt;),
     * a statement describing (in news media, the newsroom’s) disclosure and
     * correction policy for errors.
     *
     * @see <a href="http://schema.org/correctionsPolicy">correctionsPolicy</a>
     */
    public static final IRI correctionsPolicy;

    /**
     * cost
     * <p>
     * {@code http://schema.org/cost}
     * <p>
     * Cost per unit of the drug, as reported by the source being tagged.
     *
     * @see <a href="http://schema.org/cost">cost</a>
     */
    public static final IRI cost;

    /**
     * costCategory
     * <p>
     * {@code http://schema.org/costCategory}
     * <p>
     * The category of cost, such as wholesale, retail, reimbursement cap,
     * etc.
     *
     * @see <a href="http://schema.org/costCategory">costCategory</a>
     */
    public static final IRI costCategory;

    /**
     * costCurrency
     * <p>
     * {@code http://schema.org/costCurrency}
     * <p>
     * The currency (in 3-letter of the drug cost. See:
     * http://en.wikipedia.org/wiki/ISO_4217
     *
     * @see <a href="http://schema.org/costCurrency">costCurrency</a>
     */
    public static final IRI costCurrency;

    /**
     * costOrigin
     * <p>
     * {@code http://schema.org/costOrigin}
     * <p>
     * Additional details to capture the origin of the cost data. For
     * example, &#39;Medicare Part B&#39;.
     *
     * @see <a href="http://schema.org/costOrigin">costOrigin</a>
     */
    public static final IRI costOrigin;

    /**
     * costPerUnit
     * <p>
     * {@code http://schema.org/costPerUnit}
     * <p>
     * The cost per unit of the drug.
     *
     * @see <a href="http://schema.org/costPerUnit">costPerUnit</a>
     */
    public static final IRI costPerUnit;

    /**
     * countriesNotSupported
     * <p>
     * {@code http://schema.org/countriesNotSupported}
     * <p>
     * Countries for which the application is not supported. You can also
     * provide the two-letter ISO 3166-1 alpha-2 country code.
     *
     * @see <a href="http://schema.org/countriesNotSupported">countriesNotSupported</a>
     */
    public static final IRI countriesNotSupported;

    /**
     * countriesSupported
     * <p>
     * {@code http://schema.org/countriesSupported}
     * <p>
     * Countries for which the application is supported. You can also provide
     * the two-letter ISO 3166-1 alpha-2 country code.
     *
     * @see <a href="http://schema.org/countriesSupported">countriesSupported</a>
     */
    public static final IRI countriesSupported;

    /**
     * Country
     * <p>
     * {@code http://schema.org/Country}
     * <p>
     * A country.
     *
     * @see <a href="http://schema.org/Country">Country</a>
     */
    public static final IRI Country;

    /**
     * countryOfOrigin
     * <p>
     * {@code http://schema.org/countryOfOrigin}
     * <p>
     * The country of the principal offices of the production company or
     * individual responsible for the movie or program.
     *
     * @see <a href="http://schema.org/countryOfOrigin">countryOfOrigin</a>
     */
    public static final IRI countryOfOrigin;

    /**
     * Course
     * <p>
     * {@code http://schema.org/Course}
     * <p>
     * A description of an educational course which may be offered as
     * distinct instances at which take place at different times or take
     * place at different locations, or be offered through different media or
     * modes of study. An educational course is a sequence of one or more
     * educational events and/or creative works which aims to build
     * knowledge, competence or ability of learners.
     *
     * @see <a href="http://schema.org/Course">Course</a>
     */
    public static final IRI Course;

    /**
     * course
     * <p>
     * {@code http://schema.org/course}
     * <p>
     * A sub property of location. The course where this action was taken.
     *
     * @see <a href="http://schema.org/course">course</a>
     */
    public static final IRI course;

    /**
     * courseCode
     * <p>
     * {@code http://schema.org/courseCode}
     * <p>
     * The identifier for the &lt;a
     * href=&quot;http://schema.org/Course&quot;&gt;Course&lt;/a&gt; used by
     * the course &lt;a
     * href=&quot;http://schema.org/provider&quot;&gt;provider&lt;/a&gt;
     * (e.g. CS101 or 6.001).
     *
     * @see <a href="http://schema.org/courseCode">courseCode</a>
     */
    public static final IRI courseCode;

    /**
     * CourseInstance
     * <p>
     * {@code http://schema.org/CourseInstance}
     * <p>
     * An instance of a &lt;a
     * href=&quot;http://schema.org/Course&quot;&gt;Course&lt;/a&gt; which is
     * distinct from other instances because it is offered at a different
     * time or location or through different media or modes of study or to a
     * specific section of students.
     *
     * @see <a href="http://schema.org/CourseInstance">CourseInstance</a>
     */
    public static final IRI CourseInstance;

    /**
     * courseMode
     * <p>
     * {@code http://schema.org/courseMode}
     * <p>
     * The medium or means of delivery of the course instance or the mode of
     * study, either as a text label (e.g. &quot;online&quot;,
     * &quot;onsite&quot; or &quot;blended&quot;; &quot;synchronous&quot; or
     * &quot;asynchronous&quot;; &quot;full-time&quot; or
     * &quot;part-time&quot;) or as a URL reference to a term from a
     * controlled vocabulary (e.g.
     * https://ceds.ed.gov/element/001311#Asynchronous ).
     *
     * @see <a href="http://schema.org/courseMode">courseMode</a>
     */
    public static final IRI courseMode;

    /**
     * coursePrerequisites
     * <p>
     * {@code http://schema.org/coursePrerequisites}
     * <p>
     * Requirements for taking the Course. May be completion of another &lt;a
     * href=&quot;http://schema.org/Course&quot;&gt;Course&lt;/a&gt; or a
     * textual description like &quot;permission of instructor&quot;.
     * Requirements may be a pre-requisite competency, referenced using &lt;a
     * href=&quot;http://schema.org/AlignmentObject&quot;&gt;AlignmentObject&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/coursePrerequisites">coursePrerequisites</a>
     */
    public static final IRI coursePrerequisites;

    /**
     * Courthouse
     * <p>
     * {@code http://schema.org/Courthouse}
     * <p>
     * A courthouse.
     *
     * @see <a href="http://schema.org/Courthouse">Courthouse</a>
     */
    public static final IRI Courthouse;

    /**
     * coverageEndTime
     * <p>
     * {@code http://schema.org/coverageEndTime}
     * <p>
     * The time when the live blog will stop covering the Event. Note that
     * coverage may continue after the Event concludes.
     *
     * @see <a href="http://schema.org/coverageEndTime">coverageEndTime</a>
     */
    public static final IRI coverageEndTime;

    /**
     * coverageStartTime
     * <p>
     * {@code http://schema.org/coverageStartTime}
     * <p>
     * The time when the live blog will begin covering the Event. Note that
     * coverage may begin before the Event&#39;s start time. The
     * LiveBlogPosting may also be created before coverage begins.
     *
     * @see <a href="http://schema.org/coverageStartTime">coverageStartTime</a>
     */
    public static final IRI coverageStartTime;

    /**
     * CoverArt
     * <p>
     * {@code http://schema.org/CoverArt}
     * <p>
     * The artwork on the outer surface of a CreativeWork.
     *
     * @see <a href="http://schema.org/CoverArt">CoverArt</a>
     */
    public static final IRI CoverArt;

    /**
     * CreateAction
     * <p>
     * {@code http://schema.org/CreateAction}
     * <p>
     * The act of deliberately creating/producing/generating/building a
     * result out of the agent.
     *
     * @see <a href="http://schema.org/CreateAction">CreateAction</a>
     */
    public static final IRI CreateAction;

    /**
     * CreativeWork
     * <p>
     * {@code http://schema.org/CreativeWork}
     * <p>
     * The most generic kind of creative work, including books, movies,
     * photographs, software programs, etc.
     *
     * @see <a href="http://schema.org/CreativeWork">CreativeWork</a>
     */
    public static final IRI CreativeWork;

    /**
     * CreativeWorkSeason
     * <p>
     * {@code http://schema.org/CreativeWorkSeason}
     * <p>
     * A media season e.g. tv, radio, video game etc.
     *
     * @see <a href="http://schema.org/CreativeWorkSeason">CreativeWorkSeason</a>
     */
    public static final IRI CreativeWorkSeason;

    /**
     * CreativeWorkSeries
     * <p>
     * {@code http://schema.org/CreativeWorkSeries}
     * <p>
     * A CreativeWorkSeries in schema.org is a group of related items,
     * typically but not necessarily of the same kind. CreativeWorkSeries are
     * usually organized into some order, often chronological. Unlike &lt;a
     * href=&quot;http://schema.org/ItemList&quot;&gt;ItemList&lt;/a&gt;
     * which is a general purpose data structure for lists of things, the
     * emphasis with CreativeWorkSeries is on published materials (written
     * e.g. books and periodicals, or media such as tv, radio and
     * games).&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Specific subtypes are available for
     * describing &lt;a
     * href=&quot;http://schema.org/TVSeries&quot;&gt;TVSeries&lt;/a&gt;,
     * &lt;a
     * href=&quot;http://schema.org/RadioSeries&quot;&gt;RadioSeries&lt;/a&gt;,
     * &lt;a
     * href=&quot;http://schema.org/MovieSeries&quot;&gt;MovieSeries&lt;/a&gt;,
     * &lt;a
     * href=&quot;http://schema.org/BookSeries&quot;&gt;BookSeries&lt;/a&gt;,
     * &lt;a
     * href=&quot;http://schema.org/Periodical&quot;&gt;Periodical&lt;/a&gt;
     * and &lt;a
     * href=&quot;http://schema.org/VideoGameSeries&quot;&gt;VideoGameSeries&lt;/a&gt;.
     * In each case, the &lt;a
     * href=&quot;http://schema.org/hasPart&quot;&gt;hasPart&lt;/a&gt; /
     * &lt;a
     * href=&quot;http://schema.org/isPartOf&quot;&gt;isPartOf&lt;/a&gt;
     * properties can be used to relate the CreativeWorkSeries to its parts.
     * The general CreativeWorkSeries type serves largely just to organize
     * these more specific and practical subtypes.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * It
     * is common for properties applicable to an item from the series to be
     * usefully applied to the containing group. Schema.org attempts to
     * anticipate some of these cases, but publishers should be free to apply
     * properties of the series parts to the series as a whole wherever they
     * seem appropriate.
     *
     * @see <a href="http://schema.org/CreativeWorkSeries">CreativeWorkSeries</a>
     */
    public static final IRI CreativeWorkSeries;

    /**
     * creator
     * <p>
     * {@code http://schema.org/creator}
     * <p>
     * The creator/author of this CreativeWork. This is the same as the
     * Author property for CreativeWork.
     *
     * @see <a href="http://schema.org/creator">creator</a>
     */
    public static final IRI creator;

    /**
     * CreditCard
     * <p>
     * {@code http://schema.org/CreditCard}
     * <p>
     * A card payment method of a particular brand or name.  Used to mark up
     * a particular payment method and/or the financial product/service that
     * supplies the card account.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Commonly used
     * values:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#AmericanExpress&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#DinersClub&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#Discover&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#JCB&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#MasterCard&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#VISA&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/CreditCard">CreditCard</a>
     */
    public static final IRI CreditCard;

    /**
     * creditedTo
     * <p>
     * {@code http://schema.org/creditedTo}
     * <p>
     * The group the release is credited to if different than the byArtist.
     * For example, Red and Blue is credited to &quot;Stefani Germanotta
     * Band&quot;, but by Lady Gaga.
     *
     * @see <a href="http://schema.org/creditedTo">creditedTo</a>
     */
    public static final IRI creditedTo;

    /**
     * Crematorium
     * <p>
     * {@code http://schema.org/Crematorium}
     * <p>
     * A crematorium.
     *
     * @see <a href="http://schema.org/Crematorium">Crematorium</a>
     */
    public static final IRI Crematorium;

    /**
     * CriticReview
     * <p>
     * {@code http://schema.org/CriticReview}
     * <p>
     * A &lt;a
     * href=&quot;http://schema.org/CriticReview&quot;&gt;CriticReview&lt;/a&gt;
     * is a more specialized form of Review written or published by a source
     * that is recognized for its reviewing activities. These can include
     * online columns, travel and food guides, TV and radio shows, blogs and
     * other independent Web sites. &lt;a
     * href=&quot;http://schema.org/CriticReview&quot;&gt;CriticReview&lt;/a&gt;s
     * are typically more in-depth and professionally written. For simpler,
     * casually written user/visitor/viewer/customer reviews, it is more
     * appropriate to use the &lt;a
     * href=&quot;http://schema.org/UserReview&quot;&gt;UserReview&lt;/a&gt;
     * type. Review aggregator sites such as Metacritic already separate out
     * the site&#39;s user reviews from selected critic reviews that
     * originate from third-party sources.
     *
     * @see <a href="http://schema.org/CriticReview">CriticReview</a>
     */
    public static final IRI CriticReview;

    /**
     * cssSelector
     * <p>
     * {@code http://schema.org/cssSelector}
     * <p>
     * A CSS selector, e.g. of a &lt;a
     * href=&quot;http://schema.org/SpeakableSpecification&quot;&gt;SpeakableSpecification&lt;/a&gt;
     * or &lt;a
     * href=&quot;http://schema.org/WebPageElement&quot;&gt;WebPageElement&lt;/a&gt;.
     * In the latter case, multiple matches within a page can constitute a
     * single conceptual &quot;Web page element&quot;.
     *
     * @see <a href="http://schema.org/cssSelector">cssSelector</a>
     */
    public static final IRI cssSelector;

    /**
     * CssSelectorType
     * <p>
     * {@code http://schema.org/CssSelectorType}
     * <p>
     * Text representing a CSS selector.
     *
     * @see <a href="http://schema.org/CssSelectorType">CssSelectorType</a>
     */
    public static final IRI CssSelectorType;

    /**
     * currenciesAccepted
     * <p>
     * {@code http://schema.org/currenciesAccepted}
     * <p>
     * The currency accepted.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Use standard formats:
     * &lt;a href=&quot;http://en.wikipedia.org/wiki/ISO_4217&quot;&gt;ISO
     * 4217 currency format&lt;/a&gt; e.g. &quot;USD&quot;; &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/List_of_cryptocurrencies&quot;&gt;Ticker
     * symbol&lt;/a&gt; for cryptocurrencies e.g. &quot;BTC&quot;; well known
     * names for &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/Local_exchange_trading_system&quot;&gt;Local
     * Exchange Tradings Systems&lt;/a&gt; (LETS) and other currency types
     * e.g. &quot;Ithaca HOUR&quot;.
     *
     * @see <a href="http://schema.org/currenciesAccepted">currenciesAccepted</a>
     */
    public static final IRI currenciesAccepted;

    /**
     * currency
     * <p>
     * {@code http://schema.org/currency}
     * <p>
     * The currency in which the monetary amount is expressed (in 3-letter
     * &lt;a href=&quot;http://en.wikipedia.org/wiki/ISO_4217&quot;&gt;ISO
     * 4217&lt;/a&gt; format).
     *
     * @see <a href="http://schema.org/currency">currency</a>
     */
    public static final IRI currency;

    /**
     * CurrencyConversionService
     * <p>
     * {@code http://schema.org/CurrencyConversionService}
     * <p>
     * A service to convert funds from one currency to another currency.
     *
     * @see <a href="http://schema.org/CurrencyConversionService">CurrencyConversionService</a>
     */
    public static final IRI CurrencyConversionService;

    /**
     * currentExchangeRate
     * <p>
     * {@code http://schema.org/currentExchangeRate}
     * <p>
     * The current price of a currency.
     *
     * @see <a href="http://schema.org/currentExchangeRate">currentExchangeRate</a>
     */
    public static final IRI currentExchangeRate;

    /**
     * customer
     * <p>
     * {@code http://schema.org/customer}
     * <p>
     * Party placing the order or paying the invoice.
     *
     * @see <a href="http://schema.org/customer">customer</a>
     */
    public static final IRI customer;

    /**
     * DanceEvent
     * <p>
     * {@code http://schema.org/DanceEvent}
     * <p>
     * Event type: A social dance.
     *
     * @see <a href="http://schema.org/DanceEvent">DanceEvent</a>
     */
    public static final IRI DanceEvent;

    /**
     * DanceGroup
     * <p>
     * {@code http://schema.org/DanceGroup}
     * <p>
     * A dance group&amp;#x2014;for example, the Alvin Ailey Dance Theater or
     * Riverdance.
     *
     * @see <a href="http://schema.org/DanceGroup">DanceGroup</a>
     */
    public static final IRI DanceGroup;

    /**
     * DataCatalog
     * <p>
     * {@code http://schema.org/DataCatalog}
     * <p>
     * A collection of datasets.
     *
     * @see <a href="http://schema.org/DataCatalog">DataCatalog</a>
     */
    public static final IRI DataCatalog;

    /**
     * DataDownload
     * <p>
     * {@code http://schema.org/DataDownload}
     * <p>
     * A dataset in downloadable form.
     *
     * @see <a href="http://schema.org/DataDownload">DataDownload</a>
     */
    public static final IRI DataDownload;

    /**
     * DataFeed
     * <p>
     * {@code http://schema.org/DataFeed}
     * <p>
     * A single feed providing structured information about one or more
     * entities or topics.
     *
     * @see <a href="http://schema.org/DataFeed">DataFeed</a>
     */
    public static final IRI DataFeed;

    /**
     * dataFeedElement
     * <p>
     * {@code http://schema.org/dataFeedElement}
     * <p>
     * An item within in a data feed. Data feeds may have many elements.
     *
     * @see <a href="http://schema.org/dataFeedElement">dataFeedElement</a>
     */
    public static final IRI dataFeedElement;

    /**
     * DataFeedItem
     * <p>
     * {@code http://schema.org/DataFeedItem}
     * <p>
     * A single item within a larger data feed.
     *
     * @see <a href="http://schema.org/DataFeedItem">DataFeedItem</a>
     */
    public static final IRI DataFeedItem;

    /**
     * dataset
     * <p>
     * {@code http://schema.org/dataset}
     * <p>
     * A dataset contained in this catalog.
     *
     * @see <a href="http://schema.org/dataset">dataset</a>
     */
    public static final IRI dataset;

    /**
     * Dataset
     * <p>
     * {@code http://schema.org/Dataset}
     * <p>
     * A body of structured information describing some topic(s) of interest.
     *
     * @see <a href="http://schema.org/Dataset">Dataset</a>
     */
    public static final IRI Dataset;

    /**
     * datasetTimeInterval
     * <p>
     * {@code http://schema.org/datasetTimeInterval}
     * <p>
     * The range of temporal applicability of a dataset, e.g. for a 2011
     * census dataset, the year 2011 (in ISO 8601 time interval format).
     *
     * @see <a href="http://schema.org/datasetTimeInterval">datasetTimeInterval</a>
     */
    public static final IRI datasetTimeInterval;

    /**
     * DataType
     * <p>
     * {@code http://schema.org/DataType}
     * <p>
     * The basic data types such as Integers, Strings, etc.
     *
     * @see <a href="http://schema.org/DataType">DataType</a>
     */
    public static final IRI DataType;

    /**
     * Date
     * <p>
     * {@code http://schema.org/Date}
     * <p>
     * A date value in &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/ISO_8601&quot;&gt;ISO 8601
     * date format&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Date">Date</a>
     */
    public static final IRI Date;

    /**
     * dateCreated
     * <p>
     * {@code http://schema.org/dateCreated}
     * <p>
     * The date on which the CreativeWork was created or the item was added
     * to a DataFeed.
     *
     * @see <a href="http://schema.org/dateCreated">dateCreated</a>
     */
    public static final IRI dateCreated;

    /**
     * dateDeleted
     * <p>
     * {@code http://schema.org/dateDeleted}
     * <p>
     * The datetime the item was removed from the DataFeed.
     *
     * @see <a href="http://schema.org/dateDeleted">dateDeleted</a>
     */
    public static final IRI dateDeleted;

    /**
     * DatedMoneySpecification
     * <p>
     * {@code http://schema.org/DatedMoneySpecification}
     * <p>
     * A DatedMoneySpecification represents monetary values with optional
     * start and end dates. For example, this could represent an
     * employee&#39;s salary over a specific period of time.
     * &lt;strong&gt;Note:&lt;/strong&gt; This type has been superseded by
     * &lt;a
     * href=&quot;http://schema.org/MonetaryAmount&quot;&gt;MonetaryAmount&lt;/a&gt;
     * use of that type is recommended
     *
     * @see <a href="http://schema.org/DatedMoneySpecification">DatedMoneySpecification</a>
     */
    public static final IRI DatedMoneySpecification;

    /**
     * dateIssued
     * <p>
     * {@code http://schema.org/dateIssued}
     * <p>
     * The date the ticket was issued.
     *
     * @see <a href="http://schema.org/dateIssued">dateIssued</a>
     */
    public static final IRI dateIssued;

    /**
     * dateline
     * <p>
     * {@code http://schema.org/dateline}
     * <p>
     * A &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/Dateline&quot;&gt;dateline&lt;/a&gt;
     * is a brief piece of text included in news articles that describes
     * where and when the story was written or filed though the date is often
     * omitted. Sometimes only a placename is
     * provided.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Structured representations of
     * dateline-related information can also be expressed more explicitly
     * using &lt;a
     * href=&quot;http://schema.org/locationCreated&quot;&gt;locationCreated&lt;/a&gt;
     * (which represents where a work was created e.g. where a news report
     * was written).  For location depicted or described in the content, use
     * &lt;a
     * href=&quot;http://schema.org/contentLocation&quot;&gt;contentLocation&lt;/a&gt;.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Dateline
     * summaries are oriented more towards human readers than towards
     * automated processing, and can vary substantially. Some examples:
     * &quot;BEIRUT, Lebanon, June 2.&quot;, &quot;Paris, France&quot;,
     * &quot;December 19, 2017 11:43AM Reporting from Washington&quot;,
     * &quot;Beijing/Moscow&quot;, &quot;QUEZON CITY, Philippines&quot;.
     *
     * @see <a href="http://schema.org/dateline">dateline</a>
     */
    public static final IRI dateline;

    /**
     * dateModified
     * <p>
     * {@code http://schema.org/dateModified}
     * <p>
     * The date on which the CreativeWork was most recently modified or when
     * the item&#39;s entry was modified within a DataFeed.
     *
     * @see <a href="http://schema.org/dateModified">dateModified</a>
     */
    public static final IRI dateModified;

    /**
     * datePosted
     * <p>
     * {@code http://schema.org/datePosted}
     * <p>
     * Publication date for the job posting.
     *
     * @see <a href="http://schema.org/datePosted">datePosted</a>
     */
    public static final IRI datePosted;

    /**
     * datePublished
     * <p>
     * {@code http://schema.org/datePublished}
     * <p>
     * Date of first broadcast/publication.
     *
     * @see <a href="http://schema.org/datePublished">datePublished</a>
     */
    public static final IRI datePublished;

    /**
     * dateRead
     * <p>
     * {@code http://schema.org/dateRead}
     * <p>
     * The date/time at which the message has been read by the recipient if a
     * single recipient exists.
     *
     * @see <a href="http://schema.org/dateRead">dateRead</a>
     */
    public static final IRI dateRead;

    /**
     * dateReceived
     * <p>
     * {@code http://schema.org/dateReceived}
     * <p>
     * The date/time the message was received if a single recipient exists.
     *
     * @see <a href="http://schema.org/dateReceived">dateReceived</a>
     */
    public static final IRI dateReceived;

    /**
     * dateSent
     * <p>
     * {@code http://schema.org/dateSent}
     * <p>
     * The date/time at which the message was sent.
     *
     * @see <a href="http://schema.org/dateSent">dateSent</a>
     */
    public static final IRI dateSent;

    /**
     * DateTime
     * <p>
     * {@code http://schema.org/DateTime}
     * <p>
     * A combination of date and time of day in the form
     * [-]CCYY-MM-DDThh:mm:ss[Z|(+|-)hh:mm] (see Chapter 5.4 of ISO 8601).
     *
     * @see <a href="http://schema.org/DateTime">DateTime</a>
     */
    public static final IRI DateTime;

    /**
     * dateVehicleFirstRegistered
     * <p>
     * {@code http://schema.org/dateVehicleFirstRegistered}
     * <p>
     * The date of the first registration of the vehicle with the respective
     * public authorities.
     *
     * @see <a href="http://schema.org/dateVehicleFirstRegistered">dateVehicleFirstRegistered</a>
     */
    public static final IRI dateVehicleFirstRegistered;

    /**
     * DayOfWeek
     * <p>
     * {@code http://schema.org/DayOfWeek}
     * <p>
     * The day of the week, e.g. used to specify to which day the opening
     * hours of an OpeningHoursSpecification
     * refer.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Originally, URLs from &lt;a
     * href=&quot;http://purl.org/goodrelations/v1&quot;&gt;GoodRelations&lt;/a&gt;
     * were used (for &lt;a
     * href=&quot;http://schema.org/Monday&quot;&gt;Monday&lt;/a&gt;, &lt;a
     * href=&quot;http://schema.org/Tuesday&quot;&gt;Tuesday&lt;/a&gt;, &lt;a
     * href=&quot;http://schema.org/Wednesday&quot;&gt;Wednesday&lt;/a&gt;,
     * &lt;a
     * href=&quot;http://schema.org/Thursday&quot;&gt;Thursday&lt;/a&gt;,
     * &lt;a href=&quot;http://schema.org/Friday&quot;&gt;Friday&lt;/a&gt;,
     * &lt;a
     * href=&quot;http://schema.org/Saturday&quot;&gt;Saturday&lt;/a&gt;,
     * &lt;a href=&quot;http://schema.org/Sunday&quot;&gt;Sunday&lt;/a&gt;
     * plus a special entry for &lt;a
     * href=&quot;http://schema.org/PublicHolidays&quot;&gt;PublicHolidays&lt;/a&gt;);
     * these have now been integrated directly into schema.org.
     *
     * @see <a href="http://schema.org/DayOfWeek">DayOfWeek</a>
     */
    public static final IRI DayOfWeek;

    /**
     * dayOfWeek
     * <p>
     * {@code http://schema.org/dayOfWeek}
     * <p>
     * The day of the week for which these opening hours are valid.
     *
     * @see <a href="http://schema.org/dayOfWeek">dayOfWeek</a>
     */
    public static final IRI dayOfWeek;

    /**
     * DaySpa
     * <p>
     * {@code http://schema.org/DaySpa}
     * <p>
     * A day spa.
     *
     * @see <a href="http://schema.org/DaySpa">DaySpa</a>
     */
    public static final IRI DaySpa;

    /**
     * DDxElement
     * <p>
     * {@code http://schema.org/DDxElement}
     * <p>
     * An alternative, closely-related condition typically considered later
     * in the differential diagnosis process along with the signs that are
     * used to distinguish it.
     *
     * @see <a href="http://schema.org/DDxElement">DDxElement</a>
     */
    public static final IRI DDxElement;

    /**
     * DeactivateAction
     * <p>
     * {@code http://schema.org/DeactivateAction}
     * <p>
     * The act of stopping or deactivating a device or application (e.g.
     * stopping a timer or turning off a flashlight).
     *
     * @see <a href="http://schema.org/DeactivateAction">DeactivateAction</a>
     */
    public static final IRI DeactivateAction;

    /**
     * deathDate
     * <p>
     * {@code http://schema.org/deathDate}
     * <p>
     * Date of death.
     *
     * @see <a href="http://schema.org/deathDate">deathDate</a>
     */
    public static final IRI deathDate;

    /**
     * deathPlace
     * <p>
     * {@code http://schema.org/deathPlace}
     * <p>
     * The place where the person died.
     *
     * @see <a href="http://schema.org/deathPlace">deathPlace</a>
     */
    public static final IRI deathPlace;

    /**
     * defaultValue
     * <p>
     * {@code http://schema.org/defaultValue}
     * <p>
     * The default value of the input.  For properties that expect a literal,
     * the default is a literal value, for properties that expect an object,
     * it&#39;s an ID reference to one of the current values.
     *
     * @see <a href="http://schema.org/defaultValue">defaultValue</a>
     */
    public static final IRI defaultValue;

    /**
     * DefenceEstablishment
     * <p>
     * {@code http://schema.org/DefenceEstablishment}
     * <p>
     * A defence establishment, such as an army or navy base.
     *
     * @see <a href="http://schema.org/DefenceEstablishment">DefenceEstablishment</a>
     */
    public static final IRI DefenceEstablishment;

    /**
     * DefinedTerm
     * <p>
     * {@code http://schema.org/DefinedTerm}
     * <p>
     * A word, name, acronym, phrase, etc. with a formal definition. Often
     * used in the context of category or subject classification, glossaries
     * or dictionaries, product or creative work types, etc. Use the name
     * property for the term being defined, use termCode if the term has an
     * alpha-numeric code allocated, use description to provide the
     * definition of the term.
     *
     * @see <a href="http://schema.org/DefinedTerm">DefinedTerm</a>
     */
    public static final IRI DefinedTerm;

    /**
     * DefinedTermSet
     * <p>
     * {@code http://schema.org/DefinedTermSet}
     * <p>
     * A set of defined terms for example a set of categories or a
     * classification scheme, a glossary, dictionary or enumeration.
     *
     * @see <a href="http://schema.org/DefinedTermSet">DefinedTermSet</a>
     */
    public static final IRI DefinedTermSet;

    /**
     * DeleteAction
     * <p>
     * {@code http://schema.org/DeleteAction}
     * <p>
     * The act of editing a recipient by removing one of its objects.
     *
     * @see <a href="http://schema.org/DeleteAction">DeleteAction</a>
     */
    public static final IRI DeleteAction;

    /**
     * deliveryAddress
     * <p>
     * {@code http://schema.org/deliveryAddress}
     * <p>
     * Destination address.
     *
     * @see <a href="http://schema.org/deliveryAddress">deliveryAddress</a>
     */
    public static final IRI deliveryAddress;

    /**
     * DeliveryChargeSpecification
     * <p>
     * {@code http://schema.org/DeliveryChargeSpecification}
     * <p>
     * The price for the delivery of an offer using a particular delivery
     * method.
     *
     * @see <a href="http://schema.org/DeliveryChargeSpecification">DeliveryChargeSpecification</a>
     */
    public static final IRI DeliveryChargeSpecification;

    /**
     * DeliveryEvent
     * <p>
     * {@code http://schema.org/DeliveryEvent}
     * <p>
     * An event involving the delivery of an item.
     *
     * @see <a href="http://schema.org/DeliveryEvent">DeliveryEvent</a>
     */
    public static final IRI DeliveryEvent;

    /**
     * deliveryLeadTime
     * <p>
     * {@code http://schema.org/deliveryLeadTime}
     * <p>
     * The typical delay between the receipt of the order and the goods
     * either leaving the warehouse or being prepared for pickup, in case the
     * delivery method is on site pickup.
     *
     * @see <a href="http://schema.org/deliveryLeadTime">deliveryLeadTime</a>
     */
    public static final IRI deliveryLeadTime;

    /**
     * DeliveryMethod
     * <p>
     * {@code http://schema.org/DeliveryMethod}
     * <p>
     * A delivery method is a standardized procedure for transferring the
     * product or service to the destination of fulfillment chosen by the
     * customer. Delivery methods are characterized by the means of
     * transportation used, and by the organization or group that is the
     * contracting party for the sending organization or
     * person.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Commonly used
     * values:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#DeliveryModeDirectDownload&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#DeliveryModeFreight&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#DeliveryModeMail&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#DeliveryModeOwnFleet&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#DeliveryModePickUp&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#DHL&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#FederalExpress&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#UPS&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/DeliveryMethod">DeliveryMethod</a>
     */
    public static final IRI DeliveryMethod;

    /**
     * deliveryMethod
     * <p>
     * {@code http://schema.org/deliveryMethod}
     * <p>
     * A sub property of instrument. The method of delivery.
     *
     * @see <a href="http://schema.org/deliveryMethod">deliveryMethod</a>
     */
    public static final IRI deliveryMethod;

    /**
     * deliveryStatus
     * <p>
     * {@code http://schema.org/deliveryStatus}
     * <p>
     * New entry added as the package passes through each leg of its journey
     * (from shipment to final delivery).
     *
     * @see <a href="http://schema.org/deliveryStatus">deliveryStatus</a>
     */
    public static final IRI deliveryStatus;

    /**
     * Demand
     * <p>
     * {@code http://schema.org/Demand}
     * <p>
     * A demand entity represents the public, not necessarily binding, not
     * necessarily exclusive, announcement by an organization or person to
     * seek a certain type of goods or services. For describing demand using
     * this type, the very same properties used for Offer apply.
     *
     * @see <a href="http://schema.org/Demand">Demand</a>
     */
    public static final IRI Demand;

    /**
     * Dentist
     * <p>
     * {@code http://schema.org/Dentist}
     * <p>
     * A dentist.
     *
     * @see <a href="http://schema.org/Dentist">Dentist</a>
     */
    public static final IRI Dentist;

    /**
     * DepartAction
     * <p>
     * {@code http://schema.org/DepartAction}
     * <p>
     * The act of  departing from a place. An agent departs from an
     * fromLocation for a destination, optionally with participants.
     *
     * @see <a href="http://schema.org/DepartAction">DepartAction</a>
     */
    public static final IRI DepartAction;

    /**
     * department
     * <p>
     * {@code http://schema.org/department}
     * <p>
     * A relationship between an organization and a department of that
     * organization, also described as an organization (allowing different
     * urls, logos, opening hours). For example: a store with a pharmacy, or
     * a bakery with a cafe.
     *
     * @see <a href="http://schema.org/department">department</a>
     */
    public static final IRI department;

    /**
     * DepartmentStore
     * <p>
     * {@code http://schema.org/DepartmentStore}
     * <p>
     * A department store.
     *
     * @see <a href="http://schema.org/DepartmentStore">DepartmentStore</a>
     */
    public static final IRI DepartmentStore;

    /**
     * departureAirport
     * <p>
     * {@code http://schema.org/departureAirport}
     * <p>
     * The airport where the flight originates.
     *
     * @see <a href="http://schema.org/departureAirport">departureAirport</a>
     */
    public static final IRI departureAirport;

    /**
     * departureBusStop
     * <p>
     * {@code http://schema.org/departureBusStop}
     * <p>
     * The stop or station from which the bus departs.
     *
     * @see <a href="http://schema.org/departureBusStop">departureBusStop</a>
     */
    public static final IRI departureBusStop;

    /**
     * departureGate
     * <p>
     * {@code http://schema.org/departureGate}
     * <p>
     * Identifier of the flight&#39;s departure gate.
     *
     * @see <a href="http://schema.org/departureGate">departureGate</a>
     */
    public static final IRI departureGate;

    /**
     * departurePlatform
     * <p>
     * {@code http://schema.org/departurePlatform}
     * <p>
     * The platform from which the train departs.
     *
     * @see <a href="http://schema.org/departurePlatform">departurePlatform</a>
     */
    public static final IRI departurePlatform;

    /**
     * departureStation
     * <p>
     * {@code http://schema.org/departureStation}
     * <p>
     * The station from which the train departs.
     *
     * @see <a href="http://schema.org/departureStation">departureStation</a>
     */
    public static final IRI departureStation;

    /**
     * departureTerminal
     * <p>
     * {@code http://schema.org/departureTerminal}
     * <p>
     * Identifier of the flight&#39;s departure terminal.
     *
     * @see <a href="http://schema.org/departureTerminal">departureTerminal</a>
     */
    public static final IRI departureTerminal;

    /**
     * departureTime
     * <p>
     * {@code http://schema.org/departureTime}
     * <p>
     * The expected departure time.
     *
     * @see <a href="http://schema.org/departureTime">departureTime</a>
     */
    public static final IRI departureTime;

    /**
     * dependencies
     * <p>
     * {@code http://schema.org/dependencies}
     * <p>
     * Prerequisites needed to fulfill steps in article.
     *
     * @see <a href="http://schema.org/dependencies">dependencies</a>
     */
    public static final IRI dependencies;

    /**
     * DepositAccount
     * <p>
     * {@code http://schema.org/DepositAccount}
     * <p>
     * A type of Bank Account with a main purpose of depositing funds to gain
     * interest or other benefits.
     *
     * @see <a href="http://schema.org/DepositAccount">DepositAccount</a>
     */
    public static final IRI DepositAccount;

    /**
     * depth
     * <p>
     * {@code http://schema.org/depth}
     * <p>
     * The depth of the item.
     *
     * @see <a href="http://schema.org/depth">depth</a>
     */
    public static final IRI depth;

    /**
     * description
     * <p>
     * {@code http://schema.org/description}
     * <p>
     * A description of the item.
     *
     * @see <a href="http://schema.org/description">description</a>
     */
    public static final IRI description;

    /**
     * device
     * <p>
     * {@code http://schema.org/device}
     * <p>
     * Device required to run the application. Used in cases where a specific
     * make/model is required to run the application.
     *
     * @see <a href="http://schema.org/device">device</a>
     */
    public static final IRI device;

    /**
     * diagnosis
     * <p>
     * {@code http://schema.org/diagnosis}
     * <p>
     * One or more alternative conditions considered in the differential
     * diagnosis process as output of a diagnosis process.
     *
     * @see <a href="http://schema.org/diagnosis">diagnosis</a>
     */
    public static final IRI diagnosis;

    /**
     * DiagnosticLab
     * <p>
     * {@code http://schema.org/DiagnosticLab}
     * <p>
     * A medical laboratory that offers on-site or off-site diagnostic
     * services.
     *
     * @see <a href="http://schema.org/DiagnosticLab">DiagnosticLab</a>
     */
    public static final IRI DiagnosticLab;

    /**
     * DiagnosticProcedure
     * <p>
     * {@code http://schema.org/DiagnosticProcedure}
     * <p>
     * A medical procedure intended primarily for diagnostic, as opposed to
     * therapeutic, purposes.
     *
     * @see <a href="http://schema.org/DiagnosticProcedure">DiagnosticProcedure</a>
     */
    public static final IRI DiagnosticProcedure;

    /**
     * diagram
     * <p>
     * {@code http://schema.org/diagram}
     * <p>
     * An image containing a diagram that illustrates the structure and/or
     * its component substructures and/or connections with other structures.
     *
     * @see <a href="http://schema.org/diagram">diagram</a>
     */
    public static final IRI diagram;

    /**
     * Diet
     * <p>
     * {@code http://schema.org/Diet}
     * <p>
     * A strategy of regulating the intake of food to achieve or maintain a
     * specific health-related goal.
     *
     * @see <a href="http://schema.org/Diet">Diet</a>
     */
    public static final IRI Diet;

    /**
     * diet
     * <p>
     * {@code http://schema.org/diet}
     * <p>
     * A sub property of instrument. The diet used in this action.
     *
     * @see <a href="http://schema.org/diet">diet</a>
     */
    public static final IRI diet;

    /**
     * DietarySupplement
     * <p>
     * {@code http://schema.org/DietarySupplement}
     * <p>
     * A product taken by mouth that contains a dietary ingredient intended
     * to supplement the diet. Dietary ingredients may include vitamins,
     * minerals, herbs or other botanicals, amino acids, and substances such
     * as enzymes, organ tissues, glandulars and metabolites.
     *
     * @see <a href="http://schema.org/DietarySupplement">DietarySupplement</a>
     */
    public static final IRI DietarySupplement;

    /**
     * dietFeatures
     * <p>
     * {@code http://schema.org/dietFeatures}
     * <p>
     * Nutritional information specific to the dietary plan. May include
     * dietary recommendations on what foods to avoid, what foods to consume,
     * and specific alterations/deviations from the USDA or other regulatory
     * body&#39;s approved dietary guidelines.
     *
     * @see <a href="http://schema.org/dietFeatures">dietFeatures</a>
     */
    public static final IRI dietFeatures;

    /**
     * differentialDiagnosis
     * <p>
     * {@code http://schema.org/differentialDiagnosis}
     * <p>
     * One of a set of differential diagnoses for the condition.
     * Specifically, a closely-related or competing diagnosis typically
     * considered later in the cognitive process whereby this medical
     * condition is distinguished from others most likely responsible for a
     * similar collection of signs and symptoms to reach the most
     * parsimonious diagnosis or diagnoses in a patient.
     *
     * @see <a href="http://schema.org/differentialDiagnosis">differentialDiagnosis</a>
     */
    public static final IRI differentialDiagnosis;

    /**
     * DigitalDocument
     * <p>
     * {@code http://schema.org/DigitalDocument}
     * <p>
     * An electronic file or document.
     *
     * @see <a href="http://schema.org/DigitalDocument">DigitalDocument</a>
     */
    public static final IRI DigitalDocument;

    /**
     * DigitalDocumentPermission
     * <p>
     * {@code http://schema.org/DigitalDocumentPermission}
     * <p>
     * A permission for a particular person or group to access a particular
     * file.
     *
     * @see <a href="http://schema.org/DigitalDocumentPermission">DigitalDocumentPermission</a>
     */
    public static final IRI DigitalDocumentPermission;

    /**
     * DigitalDocumentPermissionType
     * <p>
     * {@code http://schema.org/DigitalDocumentPermissionType}
     * <p>
     * A type of permission which can be granted for accessing a digital
     * document.
     *
     * @see <a href="http://schema.org/DigitalDocumentPermissionType">DigitalDocumentPermissionType</a>
     */
    public static final IRI DigitalDocumentPermissionType;

    /**
     * director
     * <p>
     * {@code http://schema.org/director}
     * <p>
     * A director of e.g. tv, radio, movie, video gaming etc. content, or of
     * an event. Directors can be associated with individual items or with a
     * series, episode, clip.
     *
     * @see <a href="http://schema.org/director">director</a>
     */
    public static final IRI director;

    /**
     * directors
     * <p>
     * {@code http://schema.org/directors}
     * <p>
     * A director of e.g. tv, radio, movie, video games etc. content.
     * Directors can be associated with individual items or with a series,
     * episode, clip.
     *
     * @see <a href="http://schema.org/directors">directors</a>
     */
    public static final IRI directors;

    /**
     * DisagreeAction
     * <p>
     * {@code http://schema.org/DisagreeAction}
     * <p>
     * The act of expressing a difference of opinion with the object. An
     * agent disagrees to/about an object (a proposition, topic or theme)
     * with participants.
     *
     * @see <a href="http://schema.org/DisagreeAction">DisagreeAction</a>
     */
    public static final IRI DisagreeAction;

    /**
     * disambiguatingDescription
     * <p>
     * {@code http://schema.org/disambiguatingDescription}
     * <p>
     * A sub property of description. A short description of the item used to
     * disambiguate from other, similar items. Information from other
     * properties (in particular, name) may be necessary for the description
     * to be useful for disambiguation.
     *
     * @see <a href="http://schema.org/disambiguatingDescription">disambiguatingDescription</a>
     */
    public static final IRI disambiguatingDescription;

    /**
     * discount
     * <p>
     * {@code http://schema.org/discount}
     * <p>
     * Any discount applied (to an Order).
     *
     * @see <a href="http://schema.org/discount">discount</a>
     */
    public static final IRI discount;

    /**
     * discountCode
     * <p>
     * {@code http://schema.org/discountCode}
     * <p>
     * Code used to redeem a discount.
     *
     * @see <a href="http://schema.org/discountCode">discountCode</a>
     */
    public static final IRI discountCode;

    /**
     * discountCurrency
     * <p>
     * {@code http://schema.org/discountCurrency}
     * <p>
     * The currency of the discount.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Use standard
     * formats: &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/ISO_4217&quot;&gt;ISO 4217
     * currency format&lt;/a&gt; e.g. &quot;USD&quot;; &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/List_of_cryptocurrencies&quot;&gt;Ticker
     * symbol&lt;/a&gt; for cryptocurrencies e.g. &quot;BTC&quot;; well known
     * names for &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/Local_exchange_trading_system&quot;&gt;Local
     * Exchange Tradings Systems&lt;/a&gt; (LETS) and other currency types
     * e.g. &quot;Ithaca HOUR&quot;.
     *
     * @see <a href="http://schema.org/discountCurrency">discountCurrency</a>
     */
    public static final IRI discountCurrency;

    /**
     * DiscoverAction
     * <p>
     * {@code http://schema.org/DiscoverAction}
     * <p>
     * The act of discovering/finding an object.
     *
     * @see <a href="http://schema.org/DiscoverAction">DiscoverAction</a>
     */
    public static final IRI DiscoverAction;

    /**
     * discusses
     * <p>
     * {@code http://schema.org/discusses}
     * <p>
     * Specifies the CreativeWork associated with the UserComment.
     *
     * @see <a href="http://schema.org/discusses">discusses</a>
     */
    public static final IRI discusses;

    /**
     * DiscussionForumPosting
     * <p>
     * {@code http://schema.org/DiscussionForumPosting}
     * <p>
     * A posting to a discussion forum.
     *
     * @see <a href="http://schema.org/DiscussionForumPosting">DiscussionForumPosting</a>
     */
    public static final IRI DiscussionForumPosting;

    /**
     * discussionUrl
     * <p>
     * {@code http://schema.org/discussionUrl}
     * <p>
     * A link to the page containing the comments of the CreativeWork.
     *
     * @see <a href="http://schema.org/discussionUrl">discussionUrl</a>
     */
    public static final IRI discussionUrl;

    /**
     * DislikeAction
     * <p>
     * {@code http://schema.org/DislikeAction}
     * <p>
     * The act of expressing a negative sentiment about the object. An agent
     * dislikes an object (a proposition, topic or theme) with participants.
     *
     * @see <a href="http://schema.org/DislikeAction">DislikeAction</a>
     */
    public static final IRI DislikeAction;

    /**
     * dissolutionDate
     * <p>
     * {@code http://schema.org/dissolutionDate}
     * <p>
     * The date that this organization was dissolved.
     *
     * @see <a href="http://schema.org/dissolutionDate">dissolutionDate</a>
     */
    public static final IRI dissolutionDate;

    /**
     * Distance
     * <p>
     * {@code http://schema.org/Distance}
     * <p>
     * Properties that take Distances as values are of the form
     * &#39;&amp;lt;Number&amp;gt; &amp;lt;Length unit of
     * measure&amp;gt;&#39;. E.g., &#39;7 ft&#39;.
     *
     * @see <a href="http://schema.org/Distance">Distance</a>
     */
    public static final IRI Distance;

    /**
     * distance
     * <p>
     * {@code http://schema.org/distance}
     * <p>
     * The distance travelled, e.g. exercising or travelling.
     *
     * @see <a href="http://schema.org/distance">distance</a>
     */
    public static final IRI distance;

    /**
     * Distillery
     * <p>
     * {@code http://schema.org/Distillery}
     * <p>
     * A distillery.
     *
     * @see <a href="http://schema.org/Distillery">Distillery</a>
     */
    public static final IRI Distillery;

    /**
     * distinguishingSign
     * <p>
     * {@code http://schema.org/distinguishingSign}
     * <p>
     * One of a set of signs and symptoms that can be used to distinguish
     * this diagnosis from others in the differential diagnosis.
     *
     * @see <a href="http://schema.org/distinguishingSign">distinguishingSign</a>
     */
    public static final IRI distinguishingSign;

    /**
     * distribution
     * <p>
     * {@code http://schema.org/distribution}
     * <p>
     * A downloadable form of this dataset, at a specific location, in a
     * specific format.
     *
     * @see <a href="http://schema.org/distribution">distribution</a>
     */
    public static final IRI distribution;

    /**
     * diversityPolicy
     * <p>
     * {@code http://schema.org/diversityPolicy}
     * <p>
     * Statement on diversity policy by an &lt;a
     * href=&quot;http://schema.org/Organization&quot;&gt;Organization&lt;/a&gt;
     * e.g. a &lt;a
     * href=&quot;http://schema.org/NewsMediaOrganization&quot;&gt;NewsMediaOrganization&lt;/a&gt;.
     * For a &lt;a
     * href=&quot;http://schema.org/NewsMediaOrganization&quot;&gt;NewsMediaOrganization&lt;/a&gt;,
     * a statement describing the newsroom’s diversity policy on both
     * staffing and sources, typically providing staffing data.
     *
     * @see <a href="http://schema.org/diversityPolicy">diversityPolicy</a>
     */
    public static final IRI diversityPolicy;

    /**
     * diversityStaffingReport
     * <p>
     * {@code http://schema.org/diversityStaffingReport}
     * <p>
     * For an &lt;a
     * href=&quot;http://schema.org/Organization&quot;&gt;Organization&lt;/a&gt;
     * (often but not necessarily a &lt;a
     * href=&quot;http://schema.org/NewsMediaOrganization&quot;&gt;NewsMediaOrganization&lt;/a&gt;),
     * a report on staffing diversity issues. In a news context this might be
     * for example ASNE or RTDNA (US) reports, or self-reported.
     *
     * @see <a href="http://schema.org/diversityStaffingReport">diversityStaffingReport</a>
     */
    public static final IRI diversityStaffingReport;

    /**
     * documentation
     * <p>
     * {@code http://schema.org/documentation}
     * <p>
     * Further documentation describing the Web API in more detail.
     *
     * @see <a href="http://schema.org/documentation">documentation</a>
     */
    public static final IRI documentation;

    /**
     * domainIncludes
     * <p>
     * {@code http://schema.org/domainIncludes}
     * <p>
     * Relates a property to a class that is (one of) the type(s) the
     * property is expected to be used on.
     *
     * @see <a href="http://schema.org/domainIncludes">domainIncludes</a>
     */
    public static final IRI domainIncludes;

    /**
     * domiciledMortgage
     * <p>
     * {@code http://schema.org/domiciledMortgage}
     * <p>
     * Whether borrower is a resident of the jurisdiction where the property
     * is located.
     *
     * @see <a href="http://schema.org/domiciledMortgage">domiciledMortgage</a>
     */
    public static final IRI domiciledMortgage;

    /**
     * DonateAction
     * <p>
     * {@code http://schema.org/DonateAction}
     * <p>
     * The act of providing goods, services, or money without compensation,
     * often for philanthropic reasons.
     *
     * @see <a href="http://schema.org/DonateAction">DonateAction</a>
     */
    public static final IRI DonateAction;

    /**
     * doorTime
     * <p>
     * {@code http://schema.org/doorTime}
     * <p>
     * The time admission will commence.
     *
     * @see <a href="http://schema.org/doorTime">doorTime</a>
     */
    public static final IRI doorTime;

    /**
     * dosageForm
     * <p>
     * {@code http://schema.org/dosageForm}
     * <p>
     * A dosage form in which this drug/supplement is available, e.g.
     * &#39;tablet&#39;, &#39;suspension&#39;, &#39;injection&#39;.
     *
     * @see <a href="http://schema.org/dosageForm">dosageForm</a>
     */
    public static final IRI dosageForm;

    /**
     * DoseSchedule
     * <p>
     * {@code http://schema.org/DoseSchedule}
     * <p>
     * A specific dosing schedule for a drug or supplement.
     *
     * @see <a href="http://schema.org/DoseSchedule">DoseSchedule</a>
     */
    public static final IRI DoseSchedule;

    /**
     * doseSchedule
     * <p>
     * {@code http://schema.org/doseSchedule}
     * <p>
     * A dosing schedule for the drug for a given population, either
     * observed, recommended, or maximum dose based on the type used.
     *
     * @see <a href="http://schema.org/doseSchedule">doseSchedule</a>
     */
    public static final IRI doseSchedule;

    /**
     * doseUnit
     * <p>
     * {@code http://schema.org/doseUnit}
     * <p>
     * The unit of the dose, e.g. &#39;mg&#39;.
     *
     * @see <a href="http://schema.org/doseUnit">doseUnit</a>
     */
    public static final IRI doseUnit;

    /**
     * doseValue
     * <p>
     * {@code http://schema.org/doseValue}
     * <p>
     * The value of the dose, e.g. 500.
     *
     * @see <a href="http://schema.org/doseValue">doseValue</a>
     */
    public static final IRI doseValue;

    /**
     * DownloadAction
     * <p>
     * {@code http://schema.org/DownloadAction}
     * <p>
     * The act of downloading an object.
     *
     * @see <a href="http://schema.org/DownloadAction">DownloadAction</a>
     */
    public static final IRI DownloadAction;

    /**
     * downloadUrl
     * <p>
     * {@code http://schema.org/downloadUrl}
     * <p>
     * If the file can be downloaded, URL to download the binary.
     *
     * @see <a href="http://schema.org/downloadUrl">downloadUrl</a>
     */
    public static final IRI downloadUrl;

    /**
     * downPayment
     * <p>
     * {@code http://schema.org/downPayment}
     * <p>
     * a type of payment made in cash during the onset of the purchase of an
     * expensive good/service. The payment typically represents only a
     * percentage of the full purchase price.
     *
     * @see <a href="http://schema.org/downPayment">downPayment</a>
     */
    public static final IRI downPayment;

    /**
     * downvoteCount
     * <p>
     * {@code http://schema.org/downvoteCount}
     * <p>
     * The number of downvotes this question, answer or comment has received
     * from the community.
     *
     * @see <a href="http://schema.org/downvoteCount">downvoteCount</a>
     */
    public static final IRI downvoteCount;

    /**
     * drainsTo
     * <p>
     * {@code http://schema.org/drainsTo}
     * <p>
     * The vasculature that the vein drains into.
     *
     * @see <a href="http://schema.org/drainsTo">drainsTo</a>
     */
    public static final IRI drainsTo;

    /**
     * DrawAction
     * <p>
     * {@code http://schema.org/DrawAction}
     * <p>
     * The act of producing a visual/graphical representation of an object,
     * typically with a pen/pencil and paper as instruments.
     *
     * @see <a href="http://schema.org/DrawAction">DrawAction</a>
     */
    public static final IRI DrawAction;

    /**
     * DrinkAction
     * <p>
     * {@code http://schema.org/DrinkAction}
     * <p>
     * The act of swallowing liquids.
     *
     * @see <a href="http://schema.org/DrinkAction">DrinkAction</a>
     */
    public static final IRI DrinkAction;

    /**
     * driveWheelConfiguration
     * <p>
     * {@code http://schema.org/driveWheelConfiguration}
     * <p>
     * The drive wheel configuration, i.e. which roadwheels will receive
     * torque from the vehicle&#39;s engine via the drivetrain.
     *
     * @see <a href="http://schema.org/driveWheelConfiguration">driveWheelConfiguration</a>
     */
    public static final IRI driveWheelConfiguration;

    /**
     * DriveWheelConfigurationValue
     * <p>
     * {@code http://schema.org/DriveWheelConfigurationValue}
     * <p>
     * A value indicating which roadwheels will receive torque.
     *
     * @see <a href="http://schema.org/DriveWheelConfigurationValue">DriveWheelConfigurationValue</a>
     */
    public static final IRI DriveWheelConfigurationValue;

    /**
     * dropoffLocation
     * <p>
     * {@code http://schema.org/dropoffLocation}
     * <p>
     * Where a rental car can be dropped off.
     *
     * @see <a href="http://schema.org/dropoffLocation">dropoffLocation</a>
     */
    public static final IRI dropoffLocation;

    /**
     * dropoffTime
     * <p>
     * {@code http://schema.org/dropoffTime}
     * <p>
     * When a rental car can be dropped off.
     *
     * @see <a href="http://schema.org/dropoffTime">dropoffTime</a>
     */
    public static final IRI dropoffTime;

    /**
     * Drug
     * <p>
     * {@code http://schema.org/Drug}
     * <p>
     * A chemical or biologic substance, used as a medical therapy, that has
     * a physiological effect on an organism. Here the term drug is used
     * interchangeably with the term medicine although clinical knowledge
     * make a clear difference between them.
     *
     * @see <a href="http://schema.org/Drug">Drug</a>
     */
    public static final IRI Drug;

    /**
     * drug
     * <p>
     * {@code http://schema.org/drug}
     * <p>
     * Specifying a drug or medicine used in a medication procedure
     *
     * @see <a href="http://schema.org/drug">drug</a>
     */
    public static final IRI drug;

    /**
     * drugClass
     * <p>
     * {@code http://schema.org/drugClass}
     * <p>
     * The class of drug this belongs to (e.g., statins).
     *
     * @see <a href="http://schema.org/drugClass">drugClass</a>
     */
    public static final IRI drugClass;

    /**
     * DrugClass
     * <p>
     * {@code http://schema.org/DrugClass}
     * <p>
     * A class of medical drugs, e.g., statins. Classes can represent general
     * pharmacological class, common mechanisms of action, common
     * physiological effects, etc.
     *
     * @see <a href="http://schema.org/DrugClass">DrugClass</a>
     */
    public static final IRI DrugClass;

    /**
     * DrugCost
     * <p>
     * {@code http://schema.org/DrugCost}
     * <p>
     * The cost per unit of a medical drug. Note that this type is not meant
     * to represent the price in an offer of a drug for sale; see the Offer
     * type for that. This type will typically be used to tag wholesale or
     * average retail cost of a drug, or maximum reimbursable cost. Costs of
     * medical drugs vary widely depending on how and where they are paid
     * for, so while this type captures some of the variables, costs should
     * be used with caution by consumers of this schema&#39;s markup.
     *
     * @see <a href="http://schema.org/DrugCost">DrugCost</a>
     */
    public static final IRI DrugCost;

    /**
     * DrugCostCategory
     * <p>
     * {@code http://schema.org/DrugCostCategory}
     * <p>
     * Enumerated categories of medical drug costs.
     *
     * @see <a href="http://schema.org/DrugCostCategory">DrugCostCategory</a>
     */
    public static final IRI DrugCostCategory;

    /**
     * DrugLegalStatus
     * <p>
     * {@code http://schema.org/DrugLegalStatus}
     * <p>
     * The legal availability status of a medical drug.
     *
     * @see <a href="http://schema.org/DrugLegalStatus">DrugLegalStatus</a>
     */
    public static final IRI DrugLegalStatus;

    /**
     * DrugPregnancyCategory
     * <p>
     * {@code http://schema.org/DrugPregnancyCategory}
     * <p>
     * Categories that represent an assessment of the risk of fetal injury
     * due to a drug or pharmaceutical used as directed by the mother during
     * pregnancy.
     *
     * @see <a href="http://schema.org/DrugPregnancyCategory">DrugPregnancyCategory</a>
     */
    public static final IRI DrugPregnancyCategory;

    /**
     * DrugPrescriptionStatus
     * <p>
     * {@code http://schema.org/DrugPrescriptionStatus}
     * <p>
     * Indicates whether this drug is available by prescription or
     * over-the-counter.
     *
     * @see <a href="http://schema.org/DrugPrescriptionStatus">DrugPrescriptionStatus</a>
     */
    public static final IRI DrugPrescriptionStatus;

    /**
     * DrugStrength
     * <p>
     * {@code http://schema.org/DrugStrength}
     * <p>
     * A specific strength in which a medical drug is available in a specific
     * country.
     *
     * @see <a href="http://schema.org/DrugStrength">DrugStrength</a>
     */
    public static final IRI DrugStrength;

    /**
     * drugUnit
     * <p>
     * {@code http://schema.org/drugUnit}
     * <p>
     * The unit in which the drug is measured, e.g. &#39;5 mg tablet&#39;.
     *
     * @see <a href="http://schema.org/drugUnit">drugUnit</a>
     */
    public static final IRI drugUnit;

    /**
     * DryCleaningOrLaundry
     * <p>
     * {@code http://schema.org/DryCleaningOrLaundry}
     * <p>
     * A dry-cleaning business.
     *
     * @see <a href="http://schema.org/DryCleaningOrLaundry">DryCleaningOrLaundry</a>
     */
    public static final IRI DryCleaningOrLaundry;

    /**
     * duns
     * <p>
     * {@code http://schema.org/duns}
     * <p>
     * The Dun &amp;amp; Bradstreet DUNS number for identifying an
     * organization or business person.
     *
     * @see <a href="http://schema.org/duns">duns</a>
     */
    public static final IRI duns;

    /**
     * duplicateTherapy
     * <p>
     * {@code http://schema.org/duplicateTherapy}
     * <p>
     * A therapy that duplicates or overlaps this one.
     *
     * @see <a href="http://schema.org/duplicateTherapy">duplicateTherapy</a>
     */
    public static final IRI duplicateTherapy;

    /**
     * duration
     * <p>
     * {@code http://schema.org/duration}
     * <p>
     * The duration of the item (movie, audio recording, event, etc.) in
     * &lt;a href=&quot;http://en.wikipedia.org/wiki/ISO_8601&quot;&gt;ISO
     * 8601 date format&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/duration">duration</a>
     */
    public static final IRI duration;

    /**
     * Duration
     * <p>
     * {@code http://schema.org/Duration}
     * <p>
     * Quantity: Duration (use &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/ISO_8601&quot;&gt;ISO 8601
     * duration format&lt;/a&gt;).
     *
     * @see <a href="http://schema.org/Duration">Duration</a>
     */
    public static final IRI Duration;

    /**
     * durationOfWarranty
     * <p>
     * {@code http://schema.org/durationOfWarranty}
     * <p>
     * The duration of the warranty promise. Common unitCode values are ANN
     * for year, MON for months, or DAY for days.
     *
     * @see <a href="http://schema.org/durationOfWarranty">durationOfWarranty</a>
     */
    public static final IRI durationOfWarranty;

    /**
     * duringMedia
     * <p>
     * {@code http://schema.org/duringMedia}
     * <p>
     * A media object representing the circumstances while performing this
     * direction.
     *
     * @see <a href="http://schema.org/duringMedia">duringMedia</a>
     */
    public static final IRI duringMedia;

    /**
     * earlyPrepaymentPenalty
     * <p>
     * {@code http://schema.org/earlyPrepaymentPenalty}
     * <p>
     * The amount to be paid as a penalty in the event of early payment of
     * the loan.
     *
     * @see <a href="http://schema.org/earlyPrepaymentPenalty">earlyPrepaymentPenalty</a>
     */
    public static final IRI earlyPrepaymentPenalty;

    /**
     * EatAction
     * <p>
     * {@code http://schema.org/EatAction}
     * <p>
     * The act of swallowing solid objects.
     *
     * @see <a href="http://schema.org/EatAction">EatAction</a>
     */
    public static final IRI EatAction;

    /**
     * editor
     * <p>
     * {@code http://schema.org/editor}
     * <p>
     * Specifies the Person who edited the CreativeWork.
     *
     * @see <a href="http://schema.org/editor">editor</a>
     */
    public static final IRI editor;

    /**
     * educationalAlignment
     * <p>
     * {@code http://schema.org/educationalAlignment}
     * <p>
     * An alignment to an established educational framework.
     *
     * @see <a href="http://schema.org/educationalAlignment">educationalAlignment</a>
     */
    public static final IRI educationalAlignment;

    /**
     * EducationalAudience
     * <p>
     * {@code http://schema.org/EducationalAudience}
     * <p>
     * An EducationalAudience.
     *
     * @see <a href="http://schema.org/EducationalAudience">EducationalAudience</a>
     */
    public static final IRI EducationalAudience;

    /**
     * educationalCredentialAwarded
     * <p>
     * {@code http://schema.org/educationalCredentialAwarded}
     * <p>
     * A description of the qualification, award, certificate, diploma or
     * other educational credential awarded as a consequence of successful
     * completion of this course.
     *
     * @see <a href="http://schema.org/educationalCredentialAwarded">educationalCredentialAwarded</a>
     */
    public static final IRI educationalCredentialAwarded;

    /**
     * educationalFramework
     * <p>
     * {@code http://schema.org/educationalFramework}
     * <p>
     * The framework to which the resource being described is aligned.
     *
     * @see <a href="http://schema.org/educationalFramework">educationalFramework</a>
     */
    public static final IRI educationalFramework;

    /**
     * EducationalOrganization
     * <p>
     * {@code http://schema.org/EducationalOrganization}
     * <p>
     * An educational organization.
     *
     * @see <a href="http://schema.org/EducationalOrganization">EducationalOrganization</a>
     */
    public static final IRI EducationalOrganization;

    /**
     * educationalRole
     * <p>
     * {@code http://schema.org/educationalRole}
     * <p>
     * An educationalRole of an EducationalAudience.
     *
     * @see <a href="http://schema.org/educationalRole">educationalRole</a>
     */
    public static final IRI educationalRole;

    /**
     * educationalUse
     * <p>
     * {@code http://schema.org/educationalUse}
     * <p>
     * The purpose of a work in the context of education; for example,
     * &#39;assignment&#39;, &#39;group work&#39;.
     *
     * @see <a href="http://schema.org/educationalUse">educationalUse</a>
     */
    public static final IRI educationalUse;

    /**
     * EducationEvent
     * <p>
     * {@code http://schema.org/EducationEvent}
     * <p>
     * Event type: Education event.
     *
     * @see <a href="http://schema.org/EducationEvent">EducationEvent</a>
     */
    public static final IRI EducationEvent;

    /**
     * educationRequirements
     * <p>
     * {@code http://schema.org/educationRequirements}
     * <p>
     * Educational background needed for the position.
     *
     * @see <a href="http://schema.org/educationRequirements">educationRequirements</a>
     */
    public static final IRI educationRequirements;

    /**
     * Electrician
     * <p>
     * {@code http://schema.org/Electrician}
     * <p>
     * An electrician.
     *
     * @see <a href="http://schema.org/Electrician">Electrician</a>
     */
    public static final IRI Electrician;

    /**
     * ElectronicsStore
     * <p>
     * {@code http://schema.org/ElectronicsStore}
     * <p>
     * An electronics store.
     *
     * @see <a href="http://schema.org/ElectronicsStore">ElectronicsStore</a>
     */
    public static final IRI ElectronicsStore;

    /**
     * ElementarySchool
     * <p>
     * {@code http://schema.org/ElementarySchool}
     * <p>
     * An elementary school.
     *
     * @see <a href="http://schema.org/ElementarySchool">ElementarySchool</a>
     */
    public static final IRI ElementarySchool;

    /**
     * elevation
     * <p>
     * {@code http://schema.org/elevation}
     * <p>
     * The elevation of a location (&lt;a
     * href=&quot;https://en.wikipedia.org/wiki/World_Geodetic_System&quot;&gt;WGS
     * 84&lt;/a&gt;).
     *
     * @see <a href="http://schema.org/elevation">elevation</a>
     */
    public static final IRI elevation;

    /**
     * eligibleCustomerType
     * <p>
     * {@code http://schema.org/eligibleCustomerType}
     * <p>
     * The type(s) of customers for which the given offer is valid.
     *
     * @see <a href="http://schema.org/eligibleCustomerType">eligibleCustomerType</a>
     */
    public static final IRI eligibleCustomerType;

    /**
     * eligibleDuration
     * <p>
     * {@code http://schema.org/eligibleDuration}
     * <p>
     * The duration for which the given offer is valid.
     *
     * @see <a href="http://schema.org/eligibleDuration">eligibleDuration</a>
     */
    public static final IRI eligibleDuration;

    /**
     * eligibleQuantity
     * <p>
     * {@code http://schema.org/eligibleQuantity}
     * <p>
     * The interval and unit of measurement of ordering quantities for which
     * the offer or price specification is valid. This allows e.g. specifying
     * that a certain freight charge is valid only for a certain quantity.
     *
     * @see <a href="http://schema.org/eligibleQuantity">eligibleQuantity</a>
     */
    public static final IRI eligibleQuantity;

    /**
     * eligibleRegion
     * <p>
     * {@code http://schema.org/eligibleRegion}
     * <p>
     * The ISO 3166-1 (ISO 3166-1 alpha-2) or ISO 3166-2 code, the place, or
     * the GeoShape for the geo-political region(s) for which the offer or
     * delivery charge specification is valid.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * See
     * also &lt;a
     * href=&quot;http://schema.org/ineligibleRegion&quot;&gt;ineligibleRegion&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/eligibleRegion">eligibleRegion</a>
     */
    public static final IRI eligibleRegion;

    /**
     * eligibleTransactionVolume
     * <p>
     * {@code http://schema.org/eligibleTransactionVolume}
     * <p>
     * The transaction volume, in a monetary unit, for which the offer or
     * price specification is valid, e.g. for indicating a minimal purchasing
     * volume, to express free shipping above a certain order volume, or to
     * limit the acceptance of credit cards to purchases to a certain minimal
     * amount.
     *
     * @see <a href="http://schema.org/eligibleTransactionVolume">eligibleTransactionVolume</a>
     */
    public static final IRI eligibleTransactionVolume;

    /**
     * email
     * <p>
     * {@code http://schema.org/email}
     * <p>
     * Email address.
     *
     * @see <a href="http://schema.org/email">email</a>
     */
    public static final IRI email;

    /**
     * EmailMessage
     * <p>
     * {@code http://schema.org/EmailMessage}
     * <p>
     * An email message.
     *
     * @see <a href="http://schema.org/EmailMessage">EmailMessage</a>
     */
    public static final IRI EmailMessage;

    /**
     * Embassy
     * <p>
     * {@code http://schema.org/Embassy}
     * <p>
     * An embassy.
     *
     * @see <a href="http://schema.org/Embassy">Embassy</a>
     */
    public static final IRI Embassy;

    /**
     * embedUrl
     * <p>
     * {@code http://schema.org/embedUrl}
     * <p>
     * A URL pointing to a player for a specific video. In general, this is
     * the information in the &lt;code&gt;src&lt;/code&gt; element of an
     * &lt;code&gt;embed&lt;/code&gt; tag and should not be the same as the
     * content of the &lt;code&gt;loc&lt;/code&gt; tag.
     *
     * @see <a href="http://schema.org/embedUrl">embedUrl</a>
     */
    public static final IRI embedUrl;

    /**
     * EmergencyService
     * <p>
     * {@code http://schema.org/EmergencyService}
     * <p>
     * An emergency service, such as a fire station or ER.
     *
     * @see <a href="http://schema.org/EmergencyService">EmergencyService</a>
     */
    public static final IRI EmergencyService;

    /**
     * emissionsCO2
     * <p>
     * {@code http://schema.org/emissionsCO2}
     * <p>
     * The CO2 emissions in g/km. When used in combination with a
     * QuantitativeValue, put &quot;g/km&quot; into the unitText property of
     * that value, since there is no UN/CEFACT Common Code for
     * &quot;g/km&quot;.
     *
     * @see <a href="http://schema.org/emissionsCO2">emissionsCO2</a>
     */
    public static final IRI emissionsCO2;

    /**
     * employee
     * <p>
     * {@code http://schema.org/employee}
     * <p>
     * Someone working for this organization.
     *
     * @see <a href="http://schema.org/employee">employee</a>
     */
    public static final IRI employee;

    /**
     * EmployeeRole
     * <p>
     * {@code http://schema.org/EmployeeRole}
     * <p>
     * A subclass of OrganizationRole used to describe employee
     * relationships.
     *
     * @see <a href="http://schema.org/EmployeeRole">EmployeeRole</a>
     */
    public static final IRI EmployeeRole;

    /**
     * employees
     * <p>
     * {@code http://schema.org/employees}
     * <p>
     * People working for this organization.
     *
     * @see <a href="http://schema.org/employees">employees</a>
     */
    public static final IRI employees;

    /**
     * EmployerAggregateRating
     * <p>
     * {@code http://schema.org/EmployerAggregateRating}
     * <p>
     * An aggregate rating of an Organization related to its role as an
     * employer.
     *
     * @see <a href="http://schema.org/EmployerAggregateRating">EmployerAggregateRating</a>
     */
    public static final IRI EmployerAggregateRating;

    /**
     * EmployerReview
     * <p>
     * {@code http://schema.org/EmployerReview}
     * <p>
     * An &lt;a
     * href=&quot;http://schema.org/EmployerReview&quot;&gt;EmployerReview&lt;/a&gt;
     * is a review of an &lt;a
     * href=&quot;http://schema.org/Organization&quot;&gt;Organization&lt;/a&gt;
     * regarding its role as an employer, written by a current or former
     * employee of that organization.
     *
     * @see <a href="http://schema.org/EmployerReview">EmployerReview</a>
     */
    public static final IRI EmployerReview;

    /**
     * EmploymentAgency
     * <p>
     * {@code http://schema.org/EmploymentAgency}
     * <p>
     * An employment agency.
     *
     * @see <a href="http://schema.org/EmploymentAgency">EmploymentAgency</a>
     */
    public static final IRI EmploymentAgency;

    /**
     * employmentType
     * <p>
     * {@code http://schema.org/employmentType}
     * <p>
     * Type of employment (e.g. full-time, part-time, contract, temporary,
     * seasonal, internship).
     *
     * @see <a href="http://schema.org/employmentType">employmentType</a>
     */
    public static final IRI employmentType;

    /**
     * encodesCreativeWork
     * <p>
     * {@code http://schema.org/encodesCreativeWork}
     * <p>
     * The CreativeWork encoded by this media object.
     *
     * @see <a href="http://schema.org/encodesCreativeWork">encodesCreativeWork</a>
     */
    public static final IRI encodesCreativeWork;

    /**
     * encoding
     * <p>
     * {@code http://schema.org/encoding}
     * <p>
     * A media object that encodes this CreativeWork. This property is a
     * synonym for associatedMedia.
     *
     * @see <a href="http://schema.org/encoding">encoding</a>
     */
    public static final IRI encoding;

    /**
     * encodingFormat
     * <p>
     * {@code http://schema.org/encodingFormat}
     * <p>
     * Media type typically expressed using a MIME format (see &lt;a
     * href=&quot;http://www.iana.org/assignments/media-types/media-types.xhtml&quot;&gt;IANA
     * site&lt;/a&gt; and &lt;a
     * href=&quot;https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types&quot;&gt;MDN
     * reference&lt;/a&gt;) e.g. application/zip for a SoftwareApplication
     * binary, audio/mpeg for .mp3 etc.).&lt;br/&gt;&lt;br/&gt;
     * <p>
     * In cases
     * where a &lt;a
     * href=&quot;http://schema.org/CreativeWork&quot;&gt;CreativeWork&lt;/a&gt;
     * has several media type representations, &lt;a
     * href=&quot;http://schema.org/encoding&quot;&gt;encoding&lt;/a&gt; can
     * be used to indicate each &lt;a
     * href=&quot;http://schema.org/MediaObject&quot;&gt;MediaObject&lt;/a&gt;
     * alongside particular &lt;a
     * href=&quot;http://schema.org/encodingFormat&quot;&gt;encodingFormat&lt;/a&gt;
     * information.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Unregistered or niche encoding and
     * file formats can be indicated instead via the most appropriate URL,
     * e.g. defining Web page or a Wikipedia/Wikidata entry.
     *
     * @see <a href="http://schema.org/encodingFormat">encodingFormat</a>
     */
    public static final IRI encodingFormat;

    /**
     * encodings
     * <p>
     * {@code http://schema.org/encodings}
     * <p>
     * A media object that encodes this CreativeWork.
     *
     * @see <a href="http://schema.org/encodings">encodings</a>
     */
    public static final IRI encodings;

    /**
     * encodingType
     * <p>
     * {@code http://schema.org/encodingType}
     * <p>
     * The supported encoding type(s) for an EntryPoint request.
     *
     * @see <a href="http://schema.org/encodingType">encodingType</a>
     */
    public static final IRI encodingType;

    /**
     * endDate
     * <p>
     * {@code http://schema.org/endDate}
     * <p>
     * The end date and time of the item (in &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/ISO_8601&quot;&gt;ISO 8601
     * date format&lt;/a&gt;).
     *
     * @see <a href="http://schema.org/endDate">endDate</a>
     */
    public static final IRI endDate;

    /**
     * EndorseAction
     * <p>
     * {@code http://schema.org/EndorseAction}
     * <p>
     * An agent approves/certifies/likes/supports/sanction an object.
     *
     * @see <a href="http://schema.org/EndorseAction">EndorseAction</a>
     */
    public static final IRI EndorseAction;

    /**
     * endorsee
     * <p>
     * {@code http://schema.org/endorsee}
     * <p>
     * A sub property of participant. The person/organization being
     * supported.
     *
     * @see <a href="http://schema.org/endorsee">endorsee</a>
     */
    public static final IRI endorsee;

    /**
     * EndorsementRating
     * <p>
     * {@code http://schema.org/EndorsementRating}
     * <p>
     * An EndorsementRating is a rating that expresses some level of
     * endorsement, for example inclusion in a &quot;critic&#39;s pick&quot;
     * blog, a
     * &quot;Like&quot; or &quot;+1&quot; on a social network. It
     * can be considered the &lt;a
     * href=&quot;http://schema.org/result&quot;&gt;result&lt;/a&gt; of an
     * &lt;a
     * href=&quot;http://schema.org/EndorseAction&quot;&gt;EndorseAction&lt;/a&gt;
     * in which the &lt;a
     * href=&quot;http://schema.org/object&quot;&gt;object&lt;/a&gt; of the
     * action is rated positively by
     * some &lt;a
     * href=&quot;http://schema.org/agent&quot;&gt;agent&lt;/a&gt;. As is
     * common elsewhere in schema.org, it is sometimes more useful to
     * describe the results of such an action without explicitly describing
     * the &lt;a
     * href=&quot;http://schema.org/Action&quot;&gt;Action&lt;/a&gt;.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * An
     * &lt;a
     * href=&quot;http://schema.org/EndorsementRating&quot;&gt;EndorsementRating&lt;/a&gt;
     * may be part of a numeric scale or organized system, but this is not
     * required: having an explicit type for indicating a positive,
     * <p>
     * endorsement rating is particularly useful in the absence of numeric
     * scales as it helps consumers understand that the rating is broadly
     * positive.
     *
     * @see <a href="http://schema.org/EndorsementRating">EndorsementRating</a>
     */
    public static final IRI EndorsementRating;

    /**
     * endorsers
     * <p>
     * {@code http://schema.org/endorsers}
     * <p>
     * People or organizations that endorse the plan.
     *
     * @see <a href="http://schema.org/endorsers">endorsers</a>
     */
    public static final IRI endorsers;

    /**
     * endTime
     * <p>
     * {@code http://schema.org/endTime}
     * <p>
     * The endTime of something. For a reserved event or service (e.g.
     * FoodEstablishmentReservation), the time that it is expected to end.
     * For actions that span a period of time, when the action was performed.
     * e.g. John wrote a book from January to
     * &lt;em&gt;December&lt;/em&gt;.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Note that Event
     * uses startDate/endDate instead of startTime/endTime, even when
     * describing dates with times. This situation may be clarified in future
     * revisions.
     *
     * @see <a href="http://schema.org/endTime">endTime</a>
     */
    public static final IRI endTime;

    /**
     * Energy
     * <p>
     * {@code http://schema.org/Energy}
     * <p>
     * Properties that take Energy as values are of the form
     * &#39;&amp;lt;Number&amp;gt; &amp;lt;Energy unit of
     * measure&amp;gt;&#39;.
     *
     * @see <a href="http://schema.org/Energy">Energy</a>
     */
    public static final IRI Energy;

    /**
     * engineDisplacement
     * <p>
     * {@code http://schema.org/engineDisplacement}
     * <p>
     * The volume swept by all of the pistons inside the cylinders of an
     * internal combustion engine in a single movement.
     * &lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s): CMQ for cubic
     * centimeter, LTR for liters, INQ for cubic inches
     * Note 1: You can
     * link to information about how the given value has been determined
     * using the &lt;a
     * href=&quot;http://schema.org/valueReference&quot;&gt;valueReference&lt;/a&gt;
     * property.
     * Note 2: You can use &lt;a
     * href=&quot;http://schema.org/minValue&quot;&gt;minValue&lt;/a&gt; and
     * &lt;a
     * href=&quot;http://schema.org/maxValue&quot;&gt;maxValue&lt;/a&gt; to
     * indicate ranges.
     *
     * @see <a href="http://schema.org/engineDisplacement">engineDisplacement</a>
     */
    public static final IRI engineDisplacement;

    /**
     * enginePower
     * <p>
     * {@code http://schema.org/enginePower}
     * <p>
     * The power of the vehicle&#39;s engine.
     * Typical unit code(s): KWT
     * for kilowatt, BHP for brake horsepower, N12 for metric horsepower (PS,
     * with 1 PS = 735,49875
     * W)&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;Note 1: There are many
     * different ways of measuring an engine&#39;s power. For an overview,
     * see  &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/Horsepower#Engine_power_test_codes&quot;&gt;http://en.wikipedia.org/wiki/Horsepower#Engine&lt;em&gt;power&lt;/em&gt;test_codes&lt;/a&gt;.&lt;/li&gt;
     * &lt;li&gt;Note
     * 2: You can link to information about how the given value has been
     * determined using the &lt;a
     * href=&quot;http://schema.org/valueReference&quot;&gt;valueReference&lt;/a&gt;
     * property.&lt;/li&gt;
     * &lt;li&gt;Note 3: You can use &lt;a
     * href=&quot;http://schema.org/minValue&quot;&gt;minValue&lt;/a&gt; and
     * &lt;a
     * href=&quot;http://schema.org/maxValue&quot;&gt;maxValue&lt;/a&gt; to
     * indicate ranges.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/enginePower">enginePower</a>
     */
    public static final IRI enginePower;

    /**
     * EngineSpecification
     * <p>
     * {@code http://schema.org/EngineSpecification}
     * <p>
     * Information about the engine of the vehicle. A vehicle can have
     * multiple engines represented by multiple engine specification
     * entities.
     *
     * @see <a href="http://schema.org/EngineSpecification">EngineSpecification</a>
     */
    public static final IRI EngineSpecification;

    /**
     * engineType
     * <p>
     * {@code http://schema.org/engineType}
     * <p>
     * The type of engine or engines powering the vehicle.
     *
     * @see <a href="http://schema.org/engineType">engineType</a>
     */
    public static final IRI engineType;

    /**
     * entertainmentBusiness
     * <p>
     * {@code http://schema.org/entertainmentBusiness}
     * <p>
     * A sub property of location. The entertainment business where the
     * action occurred.
     *
     * @see <a href="http://schema.org/entertainmentBusiness">entertainmentBusiness</a>
     */
    public static final IRI entertainmentBusiness;

    /**
     * EntertainmentBusiness
     * <p>
     * {@code http://schema.org/EntertainmentBusiness}
     * <p>
     * A business providing entertainment.
     *
     * @see <a href="http://schema.org/EntertainmentBusiness">EntertainmentBusiness</a>
     */
    public static final IRI EntertainmentBusiness;

    /**
     * EntryPoint
     * <p>
     * {@code http://schema.org/EntryPoint}
     * <p>
     * An entry point, within some Web-based protocol.
     *
     * @see <a href="http://schema.org/EntryPoint">EntryPoint</a>
     */
    public static final IRI EntryPoint;

    /**
     * Enumeration
     * <p>
     * {@code http://schema.org/Enumeration}
     * <p>
     * Lists or enumerations—for example, a list of cuisines or music genres,
     * etc.
     *
     * @see <a href="http://schema.org/Enumeration">Enumeration</a>
     */
    public static final IRI Enumeration;

    /**
     * epidemiology
     * <p>
     * {@code http://schema.org/epidemiology}
     * <p>
     * The characteristics of associated patients, such as age, gender, race
     * etc.
     *
     * @see <a href="http://schema.org/epidemiology">epidemiology</a>
     */
    public static final IRI epidemiology;

    /**
     * Episode
     * <p>
     * {@code http://schema.org/Episode}
     * <p>
     * A media episode (e.g. TV, radio, video game) which can be part of a
     * series or season.
     *
     * @see <a href="http://schema.org/Episode">Episode</a>
     */
    public static final IRI Episode;

    /**
     * episode
     * <p>
     * {@code http://schema.org/episode}
     * <p>
     * An episode of a tv, radio or game media within a series or season.
     *
     * @see <a href="http://schema.org/episode">episode</a>
     */
    public static final IRI episode;

    /**
     * episodeNumber
     * <p>
     * {@code http://schema.org/episodeNumber}
     * <p>
     * Position of the episode within an ordered group of episodes.
     *
     * @see <a href="http://schema.org/episodeNumber">episodeNumber</a>
     */
    public static final IRI episodeNumber;

    /**
     * episodes
     * <p>
     * {@code http://schema.org/episodes}
     * <p>
     * An episode of a TV/radio series or season.
     *
     * @see <a href="http://schema.org/episodes">episodes</a>
     */
    public static final IRI episodes;

    /**
     * equal
     * <p>
     * {@code http://schema.org/equal}
     * <p>
     * This ordering relation for qualitative values indicates that the
     * subject is equal to the object.
     *
     * @see <a href="http://schema.org/equal">equal</a>
     */
    public static final IRI equal;

    /**
     * error
     * <p>
     * {@code http://schema.org/error}
     * <p>
     * For failed actions, more information on the cause of the failure.
     *
     * @see <a href="http://schema.org/error">error</a>
     */
    public static final IRI error;

    /**
     * estimatedCost
     * <p>
     * {@code http://schema.org/estimatedCost}
     * <p>
     * The estimated cost of the supply or supplies consumed when performing
     * instructions.
     *
     * @see <a href="http://schema.org/estimatedCost">estimatedCost</a>
     */
    public static final IRI estimatedCost;

    /**
     * estimatedFlightDuration
     * <p>
     * {@code http://schema.org/estimatedFlightDuration}
     * <p>
     * The estimated time the flight will take.
     *
     * @see <a href="http://schema.org/estimatedFlightDuration">estimatedFlightDuration</a>
     */
    public static final IRI estimatedFlightDuration;

    /**
     * estimatedSalary
     * <p>
     * {@code http://schema.org/estimatedSalary}
     * <p>
     * A property describing the estimated salary for a job posting based on
     * a variety of variables including, but not limited to industry, job
     * title, and location. The estimated salary is usually computed by
     * outside organizations and therefore the hiring organization is not
     * bound to this estimated salary.
     *
     * @see <a href="http://schema.org/estimatedSalary">estimatedSalary</a>
     */
    public static final IRI estimatedSalary;

    /**
     * estimatesRiskOf
     * <p>
     * {@code http://schema.org/estimatesRiskOf}
     * <p>
     * The condition, complication, or symptom whose risk is being estimated.
     *
     * @see <a href="http://schema.org/estimatesRiskOf">estimatesRiskOf</a>
     */
    public static final IRI estimatesRiskOf;

    /**
     * ethicsPolicy
     * <p>
     * {@code http://schema.org/ethicsPolicy}
     * <p>
     * Statement about ethics policy, e.g. of a &lt;a
     * href=&quot;http://schema.org/NewsMediaOrganization&quot;&gt;NewsMediaOrganization&lt;/a&gt;
     * regarding journalistic and publishing practices, or of a &lt;a
     * href=&quot;http://schema.org/Restaurant&quot;&gt;Restaurant&lt;/a&gt;,
     * a page describing food source policies. In the case of a &lt;a
     * href=&quot;http://schema.org/NewsMediaOrganization&quot;&gt;NewsMediaOrganization&lt;/a&gt;,
     * an ethicsPolicy is typically a statement describing the personal,
     * organizational, and corporate standards of behavior expected by the
     * organization.
     *
     * @see <a href="http://schema.org/ethicsPolicy">ethicsPolicy</a>
     */
    public static final IRI ethicsPolicy;

    /**
     * Event
     * <p>
     * {@code http://schema.org/Event}
     * <p>
     * An event happening at a certain time and location, such as a concert,
     * lecture, or festival. Ticketing information may be added via the &lt;a
     * href=&quot;http://schema.org/offers&quot;&gt;offers&lt;/a&gt;
     * property. Repeated events may be structured as separate Event objects.
     *
     * @see <a href="http://schema.org/Event">Event</a>
     */
    public static final IRI Event;

    /**
     * event
     * <p>
     * {@code http://schema.org/event}
     * <p>
     * Upcoming or past event associated with this place, organization, or
     * action.
     *
     * @see <a href="http://schema.org/event">event</a>
     */
    public static final IRI event;

    /**
     * EventReservation
     * <p>
     * {@code http://schema.org/EventReservation}
     * <p>
     * A reservation for an event like a concert, sporting event, or
     * lecture.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Note: This type is for information
     * about actual reservations, e.g. in confirmation emails or HTML pages
     * with individual confirmations of reservations. For offers of tickets,
     * use &lt;a href=&quot;http://schema.org/Offer&quot;&gt;Offer&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/EventReservation">EventReservation</a>
     */
    public static final IRI EventReservation;

    /**
     * events
     * <p>
     * {@code http://schema.org/events}
     * <p>
     * Upcoming or past events associated with this place or organization.
     *
     * @see <a href="http://schema.org/events">events</a>
     */
    public static final IRI events;

    /**
     * eventSchedule
     * <p>
     * {@code http://schema.org/eventSchedule}
     * <p>
     * Associates an &lt;a
     * href=&quot;http://schema.org/Event&quot;&gt;Event&lt;/a&gt; with a
     * &lt;a
     * href=&quot;http://schema.org/Schedule&quot;&gt;Schedule&lt;/a&gt;.
     * There are circumstances where it is preferable to share a schedule for
     * a series of
     * repeating events rather than data on the individual
     * events themselves. For example, a website or application might prefer
     * to publish a schedule for a weekly
     * gym class rather than provide
     * data on every event. A schedule could be processed by applications to
     * add forthcoming events to a calendar. An &lt;a
     * href=&quot;http://schema.org/Event&quot;&gt;Event&lt;/a&gt; that
     * <p>
     * is associated with a &lt;a
     * href=&quot;http://schema.org/Schedule&quot;&gt;Schedule&lt;/a&gt;
     * using this property should not have &lt;a
     * href=&quot;http://schema.org/startDate&quot;&gt;startDate&lt;/a&gt; or
     * &lt;a href=&quot;http://schema.org/endDate&quot;&gt;endDate&lt;/a&gt;
     * properties. These are instead defined within the associated
     * <p>
     * &lt;a
     * href=&quot;http://schema.org/Schedule&quot;&gt;Schedule&lt;/a&gt;,
     * this avoids any ambiguity for clients using the data. The propery
     * might have repeated values to specify different schedules, e.g. for
     * different months
     * or seasons.
     *
     * @see <a href="http://schema.org/eventSchedule">eventSchedule</a>
     */
    public static final IRI eventSchedule;

    /**
     * EventSeries
     * <p>
     * {@code http://schema.org/EventSeries}
     * <p>
     * A series of &lt;a
     * href=&quot;http://schema.org/Event&quot;&gt;Event&lt;/a&gt;s. Included
     * events can relate with the series using the &lt;a
     * href=&quot;http://schema.org/superEvent&quot;&gt;superEvent&lt;/a&gt;
     * property.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * An EventSeries is a collection of
     * events that share some unifying characteristic. For example, &quot;The
     * Olympic Games&quot; is a series, which
     * is repeated regularly. The
     * &quot;2012 London Olympics&quot; can be presented both as an &lt;a
     * href=&quot;http://schema.org/Event&quot;&gt;Event&lt;/a&gt; in the
     * series &quot;Olympic Games&quot;, and as an
     * &lt;a
     * href=&quot;http://schema.org/EventSeries&quot;&gt;EventSeries&lt;/a&gt;
     * that included a number of sporting competitions as
     * Events.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * The nature of the association between
     * the events in an &lt;a
     * href=&quot;http://schema.org/EventSeries&quot;&gt;EventSeries&lt;/a&gt;
     * can vary, but typical examples could
     * include a thematic event series
     * (e.g. topical meetups or classes), or a series of regular events that
     * share a location, attendee group and/or
     * organizers.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * EventSeries has been defined as a
     * kind of Event to make it easy for publishers to use it in an Event
     * context without
     * worrying about which kinds of series are really
     * event-like enough to call an Event. In general an EventSeries
     * may seem
     * more Event-like when the period of time is compact and when aspects
     * such as location are fixed, but
     * it may also sometimes prove useful to
     * describe a longer-term series as an Event.
     *
     * @see <a href="http://schema.org/EventSeries">EventSeries</a>
     */
    public static final IRI EventSeries;

    /**
     * eventStatus
     * <p>
     * {@code http://schema.org/eventStatus}
     * <p>
     * An eventStatus of an event represents its status; particularly useful
     * when an event is cancelled or rescheduled.
     *
     * @see <a href="http://schema.org/eventStatus">eventStatus</a>
     */
    public static final IRI eventStatus;

    /**
     * EventStatusType
     * <p>
     * {@code http://schema.org/EventStatusType}
     * <p>
     * EventStatusType is an enumeration type whose instances represent
     * several states that an Event may be in.
     *
     * @see <a href="http://schema.org/EventStatusType">EventStatusType</a>
     */
    public static final IRI EventStatusType;

    /**
     * EventVenue
     * <p>
     * {@code http://schema.org/EventVenue}
     * <p>
     * An event venue.
     *
     * @see <a href="http://schema.org/EventVenue">EventVenue</a>
     */
    public static final IRI EventVenue;

    /**
     * evidenceLevel
     * <p>
     * {@code http://schema.org/evidenceLevel}
     * <p>
     * Strength of evidence of the data used to formulate the guideline
     * (enumerated).
     *
     * @see <a href="http://schema.org/evidenceLevel">evidenceLevel</a>
     */
    public static final IRI evidenceLevel;

    /**
     * evidenceOrigin
     * <p>
     * {@code http://schema.org/evidenceOrigin}
     * <p>
     * Source of the data used to formulate the guidance, e.g. RCT, consensus
     * opinion, etc.
     *
     * @see <a href="http://schema.org/evidenceOrigin">evidenceOrigin</a>
     */
    public static final IRI evidenceOrigin;

    /**
     * exampleOfWork
     * <p>
     * {@code http://schema.org/exampleOfWork}
     * <p>
     * A creative work that this work is an
     * example/instance/realization/derivation of.
     *
     * @see <a href="http://schema.org/exampleOfWork">exampleOfWork</a>
     */
    public static final IRI exampleOfWork;

    /**
     * exceptDate
     * <p>
     * {@code http://schema.org/exceptDate}
     * <p>
     * Defines a &lt;a
     * href=&quot;http://schema.org/Date&quot;&gt;Date&lt;/a&gt; or &lt;a
     * href=&quot;http://schema.org/DateTime&quot;&gt;DateTime&lt;/a&gt;
     * during which a scheduled &lt;a
     * href=&quot;http://schema.org/Event&quot;&gt;Event&lt;/a&gt; will not
     * take place. The property allows exceptions to
     * a &lt;a
     * href=&quot;http://schema.org/Schedule&quot;&gt;Schedule&lt;/a&gt; to
     * be specified. If an exception is specified as a &lt;a
     * href=&quot;http://schema.org/DateTime&quot;&gt;DateTime&lt;/a&gt; then
     * only the event that would have started at that specific date and time
     * <p>
     * should be excluded from the schedule. If an exception is specified as
     * a &lt;a href=&quot;http://schema.org/Date&quot;&gt;Date&lt;/a&gt; then
     * any event that is scheduled for that 24 hour period should be
     * <p>
     * excluded from the schedule. This allows a whole day to be excluded
     * from the schedule without having to itemise every scheduled event.
     *
     * @see <a href="http://schema.org/exceptDate">exceptDate</a>
     */
    public static final IRI exceptDate;

    /**
     * ExchangeRateSpecification
     * <p>
     * {@code http://schema.org/ExchangeRateSpecification}
     * <p>
     * A structured value representing exchange rate.
     *
     * @see <a href="http://schema.org/ExchangeRateSpecification">ExchangeRateSpecification</a>
     */
    public static final IRI ExchangeRateSpecification;

    /**
     * exchangeRateSpread
     * <p>
     * {@code http://schema.org/exchangeRateSpread}
     * <p>
     * The difference between the price at which a broker or other
     * intermediary buys and sells foreign currency.
     *
     * @see <a href="http://schema.org/exchangeRateSpread">exchangeRateSpread</a>
     */
    public static final IRI exchangeRateSpread;

    /**
     * executableLibraryName
     * <p>
     * {@code http://schema.org/executableLibraryName}
     * <p>
     * Library file name e.g., mscorlib.dll, system.web.dll.
     *
     * @see <a href="http://schema.org/executableLibraryName">executableLibraryName</a>
     */
    public static final IRI executableLibraryName;

    /**
     * ExerciseAction
     * <p>
     * {@code http://schema.org/ExerciseAction}
     * <p>
     * The act of participating in exertive activity for the purposes of
     * improving health and fitness.
     *
     * @see <a href="http://schema.org/ExerciseAction">ExerciseAction</a>
     */
    public static final IRI ExerciseAction;

    /**
     * exerciseCourse
     * <p>
     * {@code http://schema.org/exerciseCourse}
     * <p>
     * A sub property of location. The course where this action was taken.
     *
     * @see <a href="http://schema.org/exerciseCourse">exerciseCourse</a>
     */
    public static final IRI exerciseCourse;

    /**
     * ExerciseGym
     * <p>
     * {@code http://schema.org/ExerciseGym}
     * <p>
     * A gym.
     *
     * @see <a href="http://schema.org/ExerciseGym">ExerciseGym</a>
     */
    public static final IRI ExerciseGym;

    /**
     * exercisePlan
     * <p>
     * {@code http://schema.org/exercisePlan}
     * <p>
     * A sub property of instrument. The exercise plan used on this action.
     *
     * @see <a href="http://schema.org/exercisePlan">exercisePlan</a>
     */
    public static final IRI exercisePlan;

    /**
     * ExercisePlan
     * <p>
     * {@code http://schema.org/ExercisePlan}
     * <p>
     * Fitness-related activity designed for a specific health-related
     * purpose, including defined exercise routines as well as activity
     * prescribed by a clinician.
     *
     * @see <a href="http://schema.org/ExercisePlan">ExercisePlan</a>
     */
    public static final IRI ExercisePlan;

    /**
     * exerciseRelatedDiet
     * <p>
     * {@code http://schema.org/exerciseRelatedDiet}
     * <p>
     * A sub property of instrument. The diet used in this action.
     *
     * @see <a href="http://schema.org/exerciseRelatedDiet">exerciseRelatedDiet</a>
     */
    public static final IRI exerciseRelatedDiet;

    /**
     * exerciseType
     * <p>
     * {@code http://schema.org/exerciseType}
     * <p>
     * Type(s) of exercise or activity, such as strength training,
     * flexibility training, aerobics, cardiac rehabilitation, etc.
     *
     * @see <a href="http://schema.org/exerciseType">exerciseType</a>
     */
    public static final IRI exerciseType;

    /**
     * ExhibitionEvent
     * <p>
     * {@code http://schema.org/ExhibitionEvent}
     * <p>
     * Event type: Exhibition event, e.g. at a museum, library, archive,
     * tradeshow, ...
     *
     * @see <a href="http://schema.org/ExhibitionEvent">ExhibitionEvent</a>
     */
    public static final IRI ExhibitionEvent;

    /**
     * exifData
     * <p>
     * {@code http://schema.org/exifData}
     * <p>
     * exif data for this object.
     *
     * @see <a href="http://schema.org/exifData">exifData</a>
     */
    public static final IRI exifData;

    /**
     * expectedArrivalFrom
     * <p>
     * {@code http://schema.org/expectedArrivalFrom}
     * <p>
     * The earliest date the package may arrive.
     *
     * @see <a href="http://schema.org/expectedArrivalFrom">expectedArrivalFrom</a>
     */
    public static final IRI expectedArrivalFrom;

    /**
     * expectedArrivalUntil
     * <p>
     * {@code http://schema.org/expectedArrivalUntil}
     * <p>
     * The latest date the package may arrive.
     *
     * @see <a href="http://schema.org/expectedArrivalUntil">expectedArrivalUntil</a>
     */
    public static final IRI expectedArrivalUntil;

    /**
     * expectedPrognosis
     * <p>
     * {@code http://schema.org/expectedPrognosis}
     * <p>
     * The likely outcome in either the short term or long term of the
     * medical condition.
     *
     * @see <a href="http://schema.org/expectedPrognosis">expectedPrognosis</a>
     */
    public static final IRI expectedPrognosis;

    /**
     * expectsAcceptanceOf
     * <p>
     * {@code http://schema.org/expectsAcceptanceOf}
     * <p>
     * An Offer which must be accepted before the user can perform the
     * Action. For example, the user may need to buy a movie before being
     * able to watch it.
     *
     * @see <a href="http://schema.org/expectsAcceptanceOf">expectsAcceptanceOf</a>
     */
    public static final IRI expectsAcceptanceOf;

    /**
     * experienceRequirements
     * <p>
     * {@code http://schema.org/experienceRequirements}
     * <p>
     * Description of skills and experience needed for the position.
     *
     * @see <a href="http://schema.org/experienceRequirements">experienceRequirements</a>
     */
    public static final IRI experienceRequirements;

    /**
     * expertConsiderations
     * <p>
     * {@code http://schema.org/expertConsiderations}
     * <p>
     * Medical expert advice related to the plan.
     *
     * @see <a href="http://schema.org/expertConsiderations">expertConsiderations</a>
     */
    public static final IRI expertConsiderations;

    /**
     * expires
     * <p>
     * {@code http://schema.org/expires}
     * <p>
     * Date the content expires and is no longer useful or available. For
     * example a &lt;a
     * href=&quot;http://schema.org/VideoObject&quot;&gt;VideoObject&lt;/a&gt;
     * or &lt;a
     * href=&quot;http://schema.org/NewsArticle&quot;&gt;NewsArticle&lt;/a&gt;
     * whose availability or relevance is time-limited, or a &lt;a
     * href=&quot;http://schema.org/ClaimReview&quot;&gt;ClaimReview&lt;/a&gt;
     * fact check whose publisher wants to indicate that it may no longer be
     * relevant (or helpful to highlight) after some date.
     *
     * @see <a href="http://schema.org/expires">expires</a>
     */
    public static final IRI expires;

    /**
     * False
     * <p>
     * {@code http://schema.org/False}
     * <p>
     * The boolean value false.
     *
     * @see <a href="http://schema.org/False">False</a>
     */
    public static final IRI False;

    /**
     * familyName
     * <p>
     * {@code http://schema.org/familyName}
     * <p>
     * Family name. In the U.S., the last name of an Person. This can be used
     * along with givenName instead of the name property.
     *
     * @see <a href="http://schema.org/familyName">familyName</a>
     */
    public static final IRI familyName;

    /**
     * FAQPage
     * <p>
     * {@code http://schema.org/FAQPage}
     * <p>
     * A &lt;a
     * href=&quot;http://schema.org/FAQPage&quot;&gt;FAQPage&lt;/a&gt; is a
     * &lt;a href=&quot;http://schema.org/WebPage&quot;&gt;WebPage&lt;/a&gt;
     * presenting one or more &quot;&lt;a
     * href=&quot;https://en.wikipedia.org/wiki/FAQ&quot;&gt;Frequently asked
     * questions&lt;/a&gt;&quot; (see also &lt;a
     * href=&quot;http://schema.org/QAPage&quot;&gt;QAPage&lt;/a&gt;).
     *
     * @see <a href="http://schema.org/FAQPage">FAQPage</a>
     */
    public static final IRI FAQPage;

    /**
     * FastFoodRestaurant
     * <p>
     * {@code http://schema.org/FastFoodRestaurant}
     * <p>
     * A fast-food restaurant.
     *
     * @see <a href="http://schema.org/FastFoodRestaurant">FastFoodRestaurant</a>
     */
    public static final IRI FastFoodRestaurant;

    /**
     * fatContent
     * <p>
     * {@code http://schema.org/fatContent}
     * <p>
     * The number of grams of fat.
     *
     * @see <a href="http://schema.org/fatContent">fatContent</a>
     */
    public static final IRI fatContent;

    /**
     * faxNumber
     * <p>
     * {@code http://schema.org/faxNumber}
     * <p>
     * The fax number.
     *
     * @see <a href="http://schema.org/faxNumber">faxNumber</a>
     */
    public static final IRI faxNumber;

    /**
     * featureList
     * <p>
     * {@code http://schema.org/featureList}
     * <p>
     * Features or modules provided by this application (and possibly
     * required by other applications).
     *
     * @see <a href="http://schema.org/featureList">featureList</a>
     */
    public static final IRI featureList;

    /**
     * feesAndCommissionsSpecification
     * <p>
     * {@code http://schema.org/feesAndCommissionsSpecification}
     * <p>
     * Description of fees, commissions, and other terms applied either to a
     * class of financial product, or by a financial service organization.
     *
     * @see <a href="http://schema.org/feesAndCommissionsSpecification">feesAndCommissionsSpecification</a>
     */
    public static final IRI feesAndCommissionsSpecification;

    /**
     * Festival
     * <p>
     * {@code http://schema.org/Festival}
     * <p>
     * Event type: Festival.
     *
     * @see <a href="http://schema.org/Festival">Festival</a>
     */
    public static final IRI Festival;

    /**
     * fiberContent
     * <p>
     * {@code http://schema.org/fiberContent}
     * <p>
     * The number of grams of fiber.
     *
     * @see <a href="http://schema.org/fiberContent">fiberContent</a>
     */
    public static final IRI fiberContent;

    /**
     * fileFormat
     * <p>
     * {@code http://schema.org/fileFormat}
     * <p>
     * Media type, typically MIME format (see &lt;a
     * href=&quot;http://www.iana.org/assignments/media-types/media-types.xhtml&quot;&gt;IANA
     * site&lt;/a&gt;) of the content e.g. application/zip of a
     * SoftwareApplication binary. In cases where a CreativeWork has several
     * media type representations, &#39;encoding&#39; can be used to indicate
     * each MediaObject alongside particular fileFormat information.
     * Unregistered or niche file formats can be indicated instead via the
     * most appropriate URL, e.g. defining Web page or a Wikipedia entry.
     *
     * @see <a href="http://schema.org/fileFormat">fileFormat</a>
     */
    public static final IRI fileFormat;

    /**
     * fileSize
     * <p>
     * {@code http://schema.org/fileSize}
     * <p>
     * Size of the application / package (e.g. 18MB). In the absence of a
     * unit (MB, KB etc.), KB will be assumed.
     *
     * @see <a href="http://schema.org/fileSize">fileSize</a>
     */
    public static final IRI fileSize;

    /**
     * FilmAction
     * <p>
     * {@code http://schema.org/FilmAction}
     * <p>
     * The act of capturing sound and moving images on film, video, or
     * digitally.
     *
     * @see <a href="http://schema.org/FilmAction">FilmAction</a>
     */
    public static final IRI FilmAction;

    /**
     * FinancialProduct
     * <p>
     * {@code http://schema.org/FinancialProduct}
     * <p>
     * A product provided to consumers and businesses by financial
     * institutions such as banks, insurance companies, brokerage firms,
     * consumer finance companies, and investment companies which comprise
     * the financial services industry.
     *
     * @see <a href="http://schema.org/FinancialProduct">FinancialProduct</a>
     */
    public static final IRI FinancialProduct;

    /**
     * FinancialService
     * <p>
     * {@code http://schema.org/FinancialService}
     * <p>
     * Financial services business.
     *
     * @see <a href="http://schema.org/FinancialService">FinancialService</a>
     */
    public static final IRI FinancialService;

    /**
     * FindAction
     * <p>
     * {@code http://schema.org/FindAction}
     * <p>
     * The act of finding an object.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/SearchAction&quot;&gt;SearchAction&lt;/a&gt;:
     * FindAction is generally lead by a SearchAction, but not
     * necessarily.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/FindAction">FindAction</a>
     */
    public static final IRI FindAction;

    /**
     * FireStation
     * <p>
     * {@code http://schema.org/FireStation}
     * <p>
     * A fire station. With firemen.
     *
     * @see <a href="http://schema.org/FireStation">FireStation</a>
     */
    public static final IRI FireStation;

    /**
     * firstAppearance
     * <p>
     * {@code http://schema.org/firstAppearance}
     * <p>
     * Indicates the first known occurence of a &lt;a
     * href=&quot;http://schema.org/Claim&quot;&gt;Claim&lt;/a&gt; in some
     * &lt;a
     * href=&quot;http://schema.org/CreativeWork&quot;&gt;CreativeWork&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/firstAppearance">firstAppearance</a>
     */
    public static final IRI firstAppearance;

    /**
     * firstPerformance
     * <p>
     * {@code http://schema.org/firstPerformance}
     * <p>
     * The date and place the work was first performed.
     *
     * @see <a href="http://schema.org/firstPerformance">firstPerformance</a>
     */
    public static final IRI firstPerformance;

    /**
     * Flight
     * <p>
     * {@code http://schema.org/Flight}
     * <p>
     * An airline flight.
     *
     * @see <a href="http://schema.org/Flight">Flight</a>
     */
    public static final IRI Flight;

    /**
     * flightDistance
     * <p>
     * {@code http://schema.org/flightDistance}
     * <p>
     * The distance of the flight.
     *
     * @see <a href="http://schema.org/flightDistance">flightDistance</a>
     */
    public static final IRI flightDistance;

    /**
     * flightNumber
     * <p>
     * {@code http://schema.org/flightNumber}
     * <p>
     * The unique identifier for a flight including the airline IATA code.
     * For example, if describing United flight 110, where the IATA code for
     * United is &#39;UA&#39;, the flightNumber is &#39;UA110&#39;.
     *
     * @see <a href="http://schema.org/flightNumber">flightNumber</a>
     */
    public static final IRI flightNumber;

    /**
     * FlightReservation
     * <p>
     * {@code http://schema.org/FlightReservation}
     * <p>
     * A reservation for air travel.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Note: This type
     * is for information about actual reservations, e.g. in confirmation
     * emails or HTML pages with individual confirmations of reservations.
     * For offers of tickets, use &lt;a
     * href=&quot;http://schema.org/Offer&quot;&gt;Offer&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/FlightReservation">FlightReservation</a>
     */
    public static final IRI FlightReservation;

    /**
     * Float
     * <p>
     * {@code http://schema.org/Float}
     * <p>
     * Data type: Floating number.
     *
     * @see <a href="http://schema.org/Float">Float</a>
     */
    public static final IRI Float;

    /**
     * floorLimit
     * <p>
     * {@code http://schema.org/floorLimit}
     * <p>
     * A floor limit is the amount of money above which credit card
     * transactions must be authorized.
     *
     * @see <a href="http://schema.org/floorLimit">floorLimit</a>
     */
    public static final IRI floorLimit;

    /**
     * floorSize
     * <p>
     * {@code http://schema.org/floorSize}
     * <p>
     * The size of the accommodation, e.g. in square meter or
     * squarefoot.
     * Typical unit code(s): MTK for square meter, FTK for square
     * foot, or YDK for square yard
     *
     * @see <a href="http://schema.org/floorSize">floorSize</a>
     */
    public static final IRI floorSize;

    /**
     * Florist
     * <p>
     * {@code http://schema.org/Florist}
     * <p>
     * A florist.
     *
     * @see <a href="http://schema.org/Florist">Florist</a>
     */
    public static final IRI Florist;

    /**
     * FMRadioChannel
     * <p>
     * {@code http://schema.org/FMRadioChannel}
     * <p>
     * A radio channel that uses FM.
     *
     * @see <a href="http://schema.org/FMRadioChannel">FMRadioChannel</a>
     */
    public static final IRI FMRadioChannel;

    /**
     * FollowAction
     * <p>
     * {@code http://schema.org/FollowAction}
     * <p>
     * The act of forming a personal connection with someone/something
     * (object) unidirectionally/asymmetrically to get updates polled
     * from.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/BefriendAction&quot;&gt;BefriendAction&lt;/a&gt;:
     * Unlike BefriendAction, FollowAction implies that the connection is
     * &lt;em&gt;not&lt;/em&gt; necessarily
     * reciprocal.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/SubscribeAction&quot;&gt;SubscribeAction&lt;/a&gt;:
     * Unlike SubscribeAction, FollowAction implies that the follower acts as
     * an active agent constantly/actively polling for
     * updates.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/RegisterAction&quot;&gt;RegisterAction&lt;/a&gt;:
     * Unlike RegisterAction, FollowAction implies that the agent is
     * interested in continuing receiving updates from the
     * object.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/JoinAction&quot;&gt;JoinAction&lt;/a&gt;:
     * Unlike JoinAction, FollowAction implies that the agent is interested
     * in getting updates from the object.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/TrackAction&quot;&gt;TrackAction&lt;/a&gt;:
     * Unlike TrackAction, FollowAction refers to the polling of updates of
     * all aspects of animate objects rather than the location of inanimate
     * objects (e.g. you track a package, but you don&#39;t follow
     * it).&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/FollowAction">FollowAction</a>
     */
    public static final IRI FollowAction;

    /**
     * followee
     * <p>
     * {@code http://schema.org/followee}
     * <p>
     * A sub property of object. The person or organization being followed.
     *
     * @see <a href="http://schema.org/followee">followee</a>
     */
    public static final IRI followee;

    /**
     * follows
     * <p>
     * {@code http://schema.org/follows}
     * <p>
     * The most generic uni-directional social relation.
     *
     * @see <a href="http://schema.org/follows">follows</a>
     */
    public static final IRI follows;

    /**
     * followup
     * <p>
     * {@code http://schema.org/followup}
     * <p>
     * Typical or recommended followup care after the procedure is performed.
     *
     * @see <a href="http://schema.org/followup">followup</a>
     */
    public static final IRI followup;

    /**
     * foodEstablishment
     * <p>
     * {@code http://schema.org/foodEstablishment}
     * <p>
     * A sub property of location. The specific food establishment where the
     * action occurred.
     *
     * @see <a href="http://schema.org/foodEstablishment">foodEstablishment</a>
     */
    public static final IRI foodEstablishment;

    /**
     * FoodEstablishment
     * <p>
     * {@code http://schema.org/FoodEstablishment}
     * <p>
     * A food-related business.
     *
     * @see <a href="http://schema.org/FoodEstablishment">FoodEstablishment</a>
     */
    public static final IRI FoodEstablishment;

    /**
     * FoodEstablishmentReservation
     * <p>
     * {@code http://schema.org/FoodEstablishmentReservation}
     * <p>
     * A reservation to dine at a food-related
     * business.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Note: This type is for information
     * about actual reservations, e.g. in confirmation emails or HTML pages
     * with individual confirmations of reservations.
     *
     * @see <a href="http://schema.org/FoodEstablishmentReservation">FoodEstablishmentReservation</a>
     */
    public static final IRI FoodEstablishmentReservation;

    /**
     * FoodEvent
     * <p>
     * {@code http://schema.org/FoodEvent}
     * <p>
     * Event type: Food event.
     *
     * @see <a href="http://schema.org/FoodEvent">FoodEvent</a>
     */
    public static final IRI FoodEvent;

    /**
     * foodEvent
     * <p>
     * {@code http://schema.org/foodEvent}
     * <p>
     * A sub property of location. The specific food event where the action
     * occurred.
     *
     * @see <a href="http://schema.org/foodEvent">foodEvent</a>
     */
    public static final IRI foodEvent;

    /**
     * FoodService
     * <p>
     * {@code http://schema.org/FoodService}
     * <p>
     * A food service, like breakfast, lunch, or dinner.
     *
     * @see <a href="http://schema.org/FoodService">FoodService</a>
     */
    public static final IRI FoodService;

    /**
     * foodWarning
     * <p>
     * {@code http://schema.org/foodWarning}
     * <p>
     * Any precaution, guidance, contraindication, etc. related to
     * consumption of specific foods while taking this drug.
     *
     * @see <a href="http://schema.org/foodWarning">foodWarning</a>
     */
    public static final IRI foodWarning;

    /**
     * founder
     * <p>
     * {@code http://schema.org/founder}
     * <p>
     * A person who founded this organization.
     *
     * @see <a href="http://schema.org/founder">founder</a>
     */
    public static final IRI founder;

    /**
     * founders
     * <p>
     * {@code http://schema.org/founders}
     * <p>
     * A person who founded this organization.
     *
     * @see <a href="http://schema.org/founders">founders</a>
     */
    public static final IRI founders;

    /**
     * foundingDate
     * <p>
     * {@code http://schema.org/foundingDate}
     * <p>
     * The date that this organization was founded.
     *
     * @see <a href="http://schema.org/foundingDate">foundingDate</a>
     */
    public static final IRI foundingDate;

    /**
     * foundingLocation
     * <p>
     * {@code http://schema.org/foundingLocation}
     * <p>
     * The place where the Organization was founded.
     *
     * @see <a href="http://schema.org/foundingLocation">foundingLocation</a>
     */
    public static final IRI foundingLocation;

    /**
     * free
     * <p>
     * {@code http://schema.org/free}
     * <p>
     * A flag to signal that the item, event, or place is accessible for
     * free.
     *
     * @see <a href="http://schema.org/free">free</a>
     */
    public static final IRI free;

    /**
     * frequency
     * <p>
     * {@code http://schema.org/frequency}
     * <p>
     * How often the dose is taken, e.g. &#39;daily&#39;.
     *
     * @see <a href="http://schema.org/frequency">frequency</a>
     */
    public static final IRI frequency;

    /**
     * fromLocation
     * <p>
     * {@code http://schema.org/fromLocation}
     * <p>
     * A sub property of location. The original location of the object or the
     * agent before the action.
     *
     * @see <a href="http://schema.org/fromLocation">fromLocation</a>
     */
    public static final IRI fromLocation;

    /**
     * fuelCapacity
     * <p>
     * {@code http://schema.org/fuelCapacity}
     * <p>
     * The capacity of the fuel tank or in the case of electric cars, the
     * battery. If there are multiple components for storage, this should
     * indicate the total of all storage of the same
     * type.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s): LTR for liters, GLL
     * of US gallons, GLI for UK / imperial gallons, AMH for ampere-hours
     * (for electrical vehicles).
     *
     * @see <a href="http://schema.org/fuelCapacity">fuelCapacity</a>
     */
    public static final IRI fuelCapacity;

    /**
     * fuelConsumption
     * <p>
     * {@code http://schema.org/fuelConsumption}
     * <p>
     * The amount of fuel consumed for traveling a particular distance or
     * temporal duration with the given vehicle (e.g. liters per 100
     * km).&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;Note 1: There are
     * unfortunately no standard unit codes for liters per 100 km.  Use &lt;a
     * href=&quot;http://schema.org/unitText&quot;&gt;unitText&lt;/a&gt; to
     * indicate the unit of measurement, e.g. L/100
     * km.&lt;/li&gt;
     * &lt;li&gt;Note 2: There are two ways of indicating the
     * fuel consumption, &lt;a
     * href=&quot;http://schema.org/fuelConsumption&quot;&gt;fuelConsumption&lt;/a&gt;
     * (e.g. 8 liters per 100 km) and &lt;a
     * href=&quot;http://schema.org/fuelEfficiency&quot;&gt;fuelEfficiency&lt;/a&gt;
     * (e.g. 30 miles per gallon). They are
     * reciprocal.&lt;/li&gt;
     * &lt;li&gt;Note 3: Often, the absolute value is
     * useful only when related to driving speed (&quot;at 80 km/h&quot;) or
     * usage pattern (&quot;city traffic&quot;). You can use &lt;a
     * href=&quot;http://schema.org/valueReference&quot;&gt;valueReference&lt;/a&gt;
     * to link the value for the fuel consumption to another
     * value.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/fuelConsumption">fuelConsumption</a>
     */
    public static final IRI fuelConsumption;

    /**
     * fuelEfficiency
     * <p>
     * {@code http://schema.org/fuelEfficiency}
     * <p>
     * The distance traveled per unit of fuel used; most commonly miles per
     * gallon (mpg) or kilometers per liter
     * (km/L).&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;Note 1: There are
     * unfortunately no standard unit codes for miles per gallon or
     * kilometers per liter. Use &lt;a
     * href=&quot;http://schema.org/unitText&quot;&gt;unitText&lt;/a&gt; to
     * indicate the unit of measurement, e.g. mpg or
     * km/L.&lt;/li&gt;
     * &lt;li&gt;Note 2: There are two ways of indicating
     * the fuel consumption, &lt;a
     * href=&quot;http://schema.org/fuelConsumption&quot;&gt;fuelConsumption&lt;/a&gt;
     * (e.g. 8 liters per 100 km) and &lt;a
     * href=&quot;http://schema.org/fuelEfficiency&quot;&gt;fuelEfficiency&lt;/a&gt;
     * (e.g. 30 miles per gallon). They are
     * reciprocal.&lt;/li&gt;
     * &lt;li&gt;Note 3: Often, the absolute value is
     * useful only when related to driving speed (&quot;at 80 km/h&quot;) or
     * usage pattern (&quot;city traffic&quot;). You can use &lt;a
     * href=&quot;http://schema.org/valueReference&quot;&gt;valueReference&lt;/a&gt;
     * to link the value for the fuel economy to another
     * value.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/fuelEfficiency">fuelEfficiency</a>
     */
    public static final IRI fuelEfficiency;

    /**
     * fuelType
     * <p>
     * {@code http://schema.org/fuelType}
     * <p>
     * The type of fuel suitable for the engine or engines of the vehicle. If
     * the vehicle has only one engine, this property can be attached
     * directly to the vehicle.
     *
     * @see <a href="http://schema.org/fuelType">fuelType</a>
     */
    public static final IRI fuelType;

    /**
     * function
     * <p>
     * {@code http://schema.org/function}
     * <p>
     * Function of the anatomical structure.
     *
     * @see <a href="http://schema.org/function">function</a>
     */
    public static final IRI function;

    /**
     * functionalClass
     * <p>
     * {@code http://schema.org/functionalClass}
     * <p>
     * The degree of mobility the joint allows.
     *
     * @see <a href="http://schema.org/functionalClass">functionalClass</a>
     */
    public static final IRI functionalClass;

    /**
     * funder
     * <p>
     * {@code http://schema.org/funder}
     * <p>
     * A person or organization that supports (sponsors) something through
     * some kind of financial contribution.
     *
     * @see <a href="http://schema.org/funder">funder</a>
     */
    public static final IRI funder;

    /**
     * FurnitureStore
     * <p>
     * {@code http://schema.org/FurnitureStore}
     * <p>
     * A furniture store.
     *
     * @see <a href="http://schema.org/FurnitureStore">FurnitureStore</a>
     */
    public static final IRI FurnitureStore;

    /**
     * Game
     * <p>
     * {@code http://schema.org/Game}
     * <p>
     * The Game type represents things which are games. These are typically
     * rule-governed recreational activities, e.g. role-playing games in
     * which players assume the role of characters in a fictional setting.
     *
     * @see <a href="http://schema.org/Game">Game</a>
     */
    public static final IRI Game;

    /**
     * game
     * <p>
     * {@code http://schema.org/game}
     * <p>
     * Video game which is played on this server.
     *
     * @see <a href="http://schema.org/game">game</a>
     */
    public static final IRI game;

    /**
     * gameItem
     * <p>
     * {@code http://schema.org/gameItem}
     * <p>
     * An item is an object within the game world that can be collected by a
     * player or, occasionally, a non-player character.
     *
     * @see <a href="http://schema.org/gameItem">gameItem</a>
     */
    public static final IRI gameItem;

    /**
     * gameLocation
     * <p>
     * {@code http://schema.org/gameLocation}
     * <p>
     * Real or fictional location of the game (or part of game).
     *
     * @see <a href="http://schema.org/gameLocation">gameLocation</a>
     */
    public static final IRI gameLocation;

    /**
     * gamePlatform
     * <p>
     * {@code http://schema.org/gamePlatform}
     * <p>
     * The electronic systems used to play &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/Category:Video_game_platforms&quot;&gt;video
     * games&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/gamePlatform">gamePlatform</a>
     */
    public static final IRI gamePlatform;

    /**
     * GamePlayMode
     * <p>
     * {@code http://schema.org/GamePlayMode}
     * <p>
     * Indicates whether this game is multi-player, co-op or single-player.
     *
     * @see <a href="http://schema.org/GamePlayMode">GamePlayMode</a>
     */
    public static final IRI GamePlayMode;

    /**
     * gameServer
     * <p>
     * {@code http://schema.org/gameServer}
     * <p>
     * The server on which  it is possible to play the game.
     *
     * @see <a href="http://schema.org/gameServer">gameServer</a>
     */
    public static final IRI gameServer;

    /**
     * GameServer
     * <p>
     * {@code http://schema.org/GameServer}
     * <p>
     * Server that provides game interaction in a multiplayer game.
     *
     * @see <a href="http://schema.org/GameServer">GameServer</a>
     */
    public static final IRI GameServer;

    /**
     * GameServerStatus
     * <p>
     * {@code http://schema.org/GameServerStatus}
     * <p>
     * Status of a game server.
     *
     * @see <a href="http://schema.org/GameServerStatus">GameServerStatus</a>
     */
    public static final IRI GameServerStatus;

    /**
     * gameTip
     * <p>
     * {@code http://schema.org/gameTip}
     * <p>
     * Links to tips, tactics, etc.
     *
     * @see <a href="http://schema.org/gameTip">gameTip</a>
     */
    public static final IRI gameTip;

    /**
     * GardenStore
     * <p>
     * {@code http://schema.org/GardenStore}
     * <p>
     * A garden store.
     *
     * @see <a href="http://schema.org/GardenStore">GardenStore</a>
     */
    public static final IRI GardenStore;

    /**
     * GasStation
     * <p>
     * {@code http://schema.org/GasStation}
     * <p>
     * A gas station.
     *
     * @see <a href="http://schema.org/GasStation">GasStation</a>
     */
    public static final IRI GasStation;

    /**
     * GatedResidenceCommunity
     * <p>
     * {@code http://schema.org/GatedResidenceCommunity}
     * <p>
     * Residence type: Gated community.
     *
     * @see <a href="http://schema.org/GatedResidenceCommunity">GatedResidenceCommunity</a>
     */
    public static final IRI GatedResidenceCommunity;

    /**
     * gender
     * <p>
     * {@code http://schema.org/gender}
     * <p>
     * Gender of the person. While http://schema.org/Male and
     * http://schema.org/Female may be used, text strings are also acceptable
     * for people who do not identify as a binary gender.
     *
     * @see <a href="http://schema.org/gender">gender</a>
     */
    public static final IRI gender;

    /**
     * GenderType
     * <p>
     * {@code http://schema.org/GenderType}
     * <p>
     * An enumeration of genders.
     *
     * @see <a href="http://schema.org/GenderType">GenderType</a>
     */
    public static final IRI GenderType;

    /**
     * GeneralContractor
     * <p>
     * {@code http://schema.org/GeneralContractor}
     * <p>
     * A general contractor.
     *
     * @see <a href="http://schema.org/GeneralContractor">GeneralContractor</a>
     */
    public static final IRI GeneralContractor;

    /**
     * genre
     * <p>
     * {@code http://schema.org/genre}
     * <p>
     * Genre of the creative work, broadcast channel or group.
     *
     * @see <a href="http://schema.org/genre">genre</a>
     */
    public static final IRI genre;

    /**
     * geo
     * <p>
     * {@code http://schema.org/geo}
     * <p>
     * The geo coordinates of the place.
     *
     * @see <a href="http://schema.org/geo">geo</a>
     */
    public static final IRI geo;

    /**
     * GeoCircle
     * <p>
     * {@code http://schema.org/GeoCircle}
     * <p>
     * A GeoCircle is a GeoShape representing a circular geographic area. As
     * it is a GeoShape
     * it provides the simple textual property
     * &#39;circle&#39;, but also allows the combination of postalCode
     * alongside geoRadius.
     * The center of the circle can be
     * indicated via the &#39;geoMidpoint&#39; property, or more
     * approximately using &#39;address&#39;, &#39;postalCode&#39;.
     *
     * @see <a href="http://schema.org/GeoCircle">GeoCircle</a>
     */
    public static final IRI GeoCircle;

    /**
     * GeoCoordinates
     * <p>
     * {@code http://schema.org/GeoCoordinates}
     * <p>
     * The geographic coordinates of a place or event.
     *
     * @see <a href="http://schema.org/GeoCoordinates">GeoCoordinates</a>
     */
    public static final IRI GeoCoordinates;

    /**
     * geographicArea
     * <p>
     * {@code http://schema.org/geographicArea}
     * <p>
     * The geographic area associated with the audience.
     *
     * @see <a href="http://schema.org/geographicArea">geographicArea</a>
     */
    public static final IRI geographicArea;

    /**
     * geoMidpoint
     * <p>
     * {@code http://schema.org/geoMidpoint}
     * <p>
     * Indicates the GeoCoordinates at the centre of a GeoShape e.g.
     * GeoCircle.
     *
     * @see <a href="http://schema.org/geoMidpoint">geoMidpoint</a>
     */
    public static final IRI geoMidpoint;

    /**
     * geoRadius
     * <p>
     * {@code http://schema.org/geoRadius}
     * <p>
     * Indicates the approximate radius of a GeoCircle (metres unless
     * indicated otherwise via Distance notation).
     *
     * @see <a href="http://schema.org/geoRadius">geoRadius</a>
     */
    public static final IRI geoRadius;

    /**
     * GeoShape
     * <p>
     * {@code http://schema.org/GeoShape}
     * <p>
     * The geographic shape of a place. A GeoShape can be described using
     * several properties whose values are based on latitude/longitude pairs.
     * Either whitespace or commas can be used to separate latitude and
     * longitude; whitespace should be used when writing a list of several
     * such points.
     *
     * @see <a href="http://schema.org/GeoShape">GeoShape</a>
     */
    public static final IRI GeoShape;

    /**
     * GeospatialGeometry
     * <p>
     * {@code http://schema.org/GeospatialGeometry}
     * <p>
     * (Eventually to be defined as) a supertype of GeoShape designed to
     * accommodate definitions from Geo-Spatial best practices.
     *
     * @see <a href="http://schema.org/GeospatialGeometry">GeospatialGeometry</a>
     */
    public static final IRI GeospatialGeometry;

    /**
     * geospatiallyContains
     * <p>
     * {@code http://schema.org/geospatiallyContains}
     * <p>
     * Represents a relationship between two geometries (or the places they
     * represent), relating a containing geometry to a contained geometry.
     * &quot;a contains b iff no points of b lie in the exterior of a, and at
     * least one point of the interior of b lies in the interior of a&quot;.
     * As defined in &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/DE-9IM&quot;&gt;DE-9IM&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/geospatiallyContains">geospatiallyContains</a>
     */
    public static final IRI geospatiallyContains;

    /**
     * geospatiallyCoveredBy
     * <p>
     * {@code http://schema.org/geospatiallyCoveredBy}
     * <p>
     * Represents a relationship between two geometries (or the places they
     * represent), relating a geometry to another that covers it. As defined
     * in &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/DE-9IM&quot;&gt;DE-9IM&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/geospatiallyCoveredBy">geospatiallyCoveredBy</a>
     */
    public static final IRI geospatiallyCoveredBy;

    /**
     * geospatiallyCovers
     * <p>
     * {@code http://schema.org/geospatiallyCovers}
     * <p>
     * Represents a relationship between two geometries (or the places they
     * represent), relating a covering geometry to a covered geometry.
     * &quot;Every point of b is a point of (the interior or boundary of)
     * a&quot;. As defined in &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/DE-9IM&quot;&gt;DE-9IM&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/geospatiallyCovers">geospatiallyCovers</a>
     */
    public static final IRI geospatiallyCovers;

    /**
     * geospatiallyCrosses
     * <p>
     * {@code http://schema.org/geospatiallyCrosses}
     * <p>
     * Represents a relationship between two geometries (or the places they
     * represent), relating a geometry to another that crosses it: &quot;a
     * crosses b: they have some but not all interior points in common, and
     * the dimension of the intersection is less than that of at least one of
     * them&quot;. As defined in &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/DE-9IM&quot;&gt;DE-9IM&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/geospatiallyCrosses">geospatiallyCrosses</a>
     */
    public static final IRI geospatiallyCrosses;

    /**
     * geospatiallyDisjoint
     * <p>
     * {@code http://schema.org/geospatiallyDisjoint}
     * <p>
     * Represents spatial relations in which two geometries (or the places
     * they represent) are topologically disjoint: they have no point in
     * common. They form a set of disconnected geometries.&quot; (a symmetric
     * relationship, as defined in &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/DE-9IM&quot;&gt;DE-9IM&lt;/a&gt;)
     *
     * @see <a href="http://schema.org/geospatiallyDisjoint">geospatiallyDisjoint</a>
     */
    public static final IRI geospatiallyDisjoint;

    /**
     * geospatiallyEquals
     * <p>
     * {@code http://schema.org/geospatiallyEquals}
     * <p>
     * Represents spatial relations in which two geometries (or the places
     * they represent) are topologically equal, as defined in &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/DE-9IM&quot;&gt;DE-9IM&lt;/a&gt;.
     * &quot;Two geometries are topologically equal if their interiors
     * intersect and no part of the interior or boundary of one geometry
     * intersects the exterior of the other&quot; (a symmetric relationship)
     *
     * @see <a href="http://schema.org/geospatiallyEquals">geospatiallyEquals</a>
     */
    public static final IRI geospatiallyEquals;

    /**
     * geospatiallyIntersects
     * <p>
     * {@code http://schema.org/geospatiallyIntersects}
     * <p>
     * Represents spatial relations in which two geometries (or the places
     * they represent) have at least one point in common. As defined in &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/DE-9IM&quot;&gt;DE-9IM&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/geospatiallyIntersects">geospatiallyIntersects</a>
     */
    public static final IRI geospatiallyIntersects;

    /**
     * geospatiallyOverlaps
     * <p>
     * {@code http://schema.org/geospatiallyOverlaps}
     * <p>
     * Represents a relationship between two geometries (or the places they
     * represent), relating a geometry to another that geospatially overlaps
     * it, i.e. they have some but not all points in common. As defined in
     * &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/DE-9IM&quot;&gt;DE-9IM&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/geospatiallyOverlaps">geospatiallyOverlaps</a>
     */
    public static final IRI geospatiallyOverlaps;

    /**
     * geospatiallyTouches
     * <p>
     * {@code http://schema.org/geospatiallyTouches}
     * <p>
     * Represents spatial relations in which two geometries (or the places
     * they represent) touch: they have at least one boundary point in
     * common, but no interior points.&quot; (a symmetric relationship, as
     * defined in &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/DE-9IM&quot;&gt;DE-9IM&lt;/a&gt;
     * )
     *
     * @see <a href="http://schema.org/geospatiallyTouches">geospatiallyTouches</a>
     */
    public static final IRI geospatiallyTouches;

    /**
     * geospatiallyWithin
     * <p>
     * {@code http://schema.org/geospatiallyWithin}
     * <p>
     * Represents a relationship between two geometries (or the places they
     * represent), relating a geometry to one that contains it, i.e. it is
     * inside (i.e. within) its interior. As defined in &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/DE-9IM&quot;&gt;DE-9IM&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/geospatiallyWithin">geospatiallyWithin</a>
     */
    public static final IRI geospatiallyWithin;

    /**
     * GiveAction
     * <p>
     * {@code http://schema.org/GiveAction}
     * <p>
     * The act of transferring ownership of an object to a destination.
     * Reciprocal of TakeAction.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/TakeAction&quot;&gt;TakeAction&lt;/a&gt;:
     * Reciprocal of GiveAction.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/SendAction&quot;&gt;SendAction&lt;/a&gt;:
     * Unlike SendAction, GiveAction implies that ownership is being
     * transferred (e.g. I may send my laptop to you, but that doesn&#39;t
     * mean I&#39;m giving it to you).&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/GiveAction">GiveAction</a>
     */
    public static final IRI GiveAction;

    /**
     * givenName
     * <p>
     * {@code http://schema.org/givenName}
     * <p>
     * Given name. In the U.S., the first name of a Person. This can be used
     * along with familyName instead of the name property.
     *
     * @see <a href="http://schema.org/givenName">givenName</a>
     */
    public static final IRI givenName;

    /**
     * globalLocationNumber
     * <p>
     * {@code http://schema.org/globalLocationNumber}
     * <p>
     * The &lt;a href=&quot;http://www.gs1.org/gln&quot;&gt;Global Location
     * Number&lt;/a&gt; (GLN, sometimes also referred to as International
     * Location Number or ILN) of the respective organization, person, or
     * place. The GLN is a 13-digit number used to identify parties and
     * physical locations.
     *
     * @see <a href="http://schema.org/globalLocationNumber">globalLocationNumber</a>
     */
    public static final IRI globalLocationNumber;

    /**
     * GolfCourse
     * <p>
     * {@code http://schema.org/GolfCourse}
     * <p>
     * A golf course.
     *
     * @see <a href="http://schema.org/GolfCourse">GolfCourse</a>
     */
    public static final IRI GolfCourse;

    /**
     * GovernmentBuilding
     * <p>
     * {@code http://schema.org/GovernmentBuilding}
     * <p>
     * A government building.
     *
     * @see <a href="http://schema.org/GovernmentBuilding">GovernmentBuilding</a>
     */
    public static final IRI GovernmentBuilding;

    /**
     * GovernmentOffice
     * <p>
     * {@code http://schema.org/GovernmentOffice}
     * <p>
     * A government office&amp;#x2014;for example, an IRS or DMV office.
     *
     * @see <a href="http://schema.org/GovernmentOffice">GovernmentOffice</a>
     */
    public static final IRI GovernmentOffice;

    /**
     * GovernmentOrganization
     * <p>
     * {@code http://schema.org/GovernmentOrganization}
     * <p>
     * A governmental organization or agency.
     *
     * @see <a href="http://schema.org/GovernmentOrganization">GovernmentOrganization</a>
     */
    public static final IRI GovernmentOrganization;

    /**
     * GovernmentPermit
     * <p>
     * {@code http://schema.org/GovernmentPermit}
     * <p>
     * A permit issued by a government agency.
     *
     * @see <a href="http://schema.org/GovernmentPermit">GovernmentPermit</a>
     */
    public static final IRI GovernmentPermit;

    /**
     * GovernmentService
     * <p>
     * {@code http://schema.org/GovernmentService}
     * <p>
     * A service provided by a government organization, e.g. food stamps,
     * veterans benefits, etc.
     *
     * @see <a href="http://schema.org/GovernmentService">GovernmentService</a>
     */
    public static final IRI GovernmentService;

    /**
     * gracePeriod
     * <p>
     * {@code http://schema.org/gracePeriod}
     * <p>
     * The period of time after any due date that the borrower has to fulfil
     * its obligations before a default (failure to pay) is deemed to have
     * occurred.
     *
     * @see <a href="http://schema.org/gracePeriod">gracePeriod</a>
     */
    public static final IRI gracePeriod;

    /**
     * grantee
     * <p>
     * {@code http://schema.org/grantee}
     * <p>
     * The person, organization, contact point, or audience that has been
     * granted this permission.
     *
     * @see <a href="http://schema.org/grantee">grantee</a>
     */
    public static final IRI grantee;

    /**
     * greater
     * <p>
     * {@code http://schema.org/greater}
     * <p>
     * This ordering relation for qualitative values indicates that the
     * subject is greater than the object.
     *
     * @see <a href="http://schema.org/greater">greater</a>
     */
    public static final IRI greater;

    /**
     * greaterOrEqual
     * <p>
     * {@code http://schema.org/greaterOrEqual}
     * <p>
     * This ordering relation for qualitative values indicates that the
     * subject is greater than or equal to the object.
     *
     * @see <a href="http://schema.org/greaterOrEqual">greaterOrEqual</a>
     */
    public static final IRI greaterOrEqual;

    /**
     * GroceryStore
     * <p>
     * {@code http://schema.org/GroceryStore}
     * <p>
     * A grocery store.
     *
     * @see <a href="http://schema.org/GroceryStore">GroceryStore</a>
     */
    public static final IRI GroceryStore;

    /**
     * gtin12
     * <p>
     * {@code http://schema.org/gtin12}
     * <p>
     * The &lt;a
     * href=&quot;http://apps.gs1.org/GDD/glossary/Pages/GTIN-12.aspx&quot;&gt;GTIN-12&lt;/a&gt;
     * code of the product, or the product to which the offer refers. The
     * GTIN-12 is the 12-digit GS1 Identification Key composed of a U.P.C.
     * Company Prefix, Item Reference, and Check Digit used to identify trade
     * items. See &lt;a
     * href=&quot;http://www.gs1.org/barcodes/technical/idkeys/gtin&quot;&gt;GS1
     * GTIN Summary&lt;/a&gt; for more details.
     *
     * @see <a href="http://schema.org/gtin12">gtin12</a>
     */
    public static final IRI gtin12;

    /**
     * gtin13
     * <p>
     * {@code http://schema.org/gtin13}
     * <p>
     * The &lt;a
     * href=&quot;http://apps.gs1.org/GDD/glossary/Pages/GTIN-13.aspx&quot;&gt;GTIN-13&lt;/a&gt;
     * code of the product, or the product to which the offer refers. This is
     * equivalent to 13-digit ISBN codes and EAN UCC-13. Former 12-digit UPC
     * codes can be converted into a GTIN-13 code by simply adding a
     * preceeding zero. See &lt;a
     * href=&quot;http://www.gs1.org/barcodes/technical/idkeys/gtin&quot;&gt;GS1
     * GTIN Summary&lt;/a&gt; for more details.
     *
     * @see <a href="http://schema.org/gtin13">gtin13</a>
     */
    public static final IRI gtin13;

    /**
     * gtin14
     * <p>
     * {@code http://schema.org/gtin14}
     * <p>
     * The &lt;a
     * href=&quot;http://apps.gs1.org/GDD/glossary/Pages/GTIN-14.aspx&quot;&gt;GTIN-14&lt;/a&gt;
     * code of the product, or the product to which the offer refers. See
     * &lt;a
     * href=&quot;http://www.gs1.org/barcodes/technical/idkeys/gtin&quot;&gt;GS1
     * GTIN Summary&lt;/a&gt; for more details.
     *
     * @see <a href="http://schema.org/gtin14">gtin14</a>
     */
    public static final IRI gtin14;

    /**
     * gtin8
     * <p>
     * {@code http://schema.org/gtin8}
     * <p>
     * The &lt;a
     * href=&quot;http://apps.gs1.org/GDD/glossary/Pages/GTIN-8.aspx&quot;&gt;GTIN-8&lt;/a&gt;
     * code of the product, or the product to which the offer refers. This
     * code is also known as EAN/UCC-8 or 8-digit EAN. See &lt;a
     * href=&quot;http://www.gs1.org/barcodes/technical/idkeys/gtin&quot;&gt;GS1
     * GTIN Summary&lt;/a&gt; for more details.
     *
     * @see <a href="http://schema.org/gtin8">gtin8</a>
     */
    public static final IRI gtin8;

    /**
     * guideline
     * <p>
     * {@code http://schema.org/guideline}
     * <p>
     * A medical guideline related to this entity.
     *
     * @see <a href="http://schema.org/guideline">guideline</a>
     */
    public static final IRI guideline;

    /**
     * guidelineDate
     * <p>
     * {@code http://schema.org/guidelineDate}
     * <p>
     * Date on which this guideline&#39;s recommendation was made.
     *
     * @see <a href="http://schema.org/guidelineDate">guidelineDate</a>
     */
    public static final IRI guidelineDate;

    /**
     * guidelineSubject
     * <p>
     * {@code http://schema.org/guidelineSubject}
     * <p>
     * The medical conditions, treatments, etc. that are the subject of the
     * guideline.
     *
     * @see <a href="http://schema.org/guidelineSubject">guidelineSubject</a>
     */
    public static final IRI guidelineSubject;

    /**
     * HairSalon
     * <p>
     * {@code http://schema.org/HairSalon}
     * <p>
     * A hair salon.
     *
     * @see <a href="http://schema.org/HairSalon">HairSalon</a>
     */
    public static final IRI HairSalon;

    /**
     * HardwareStore
     * <p>
     * {@code http://schema.org/HardwareStore}
     * <p>
     * A hardware store.
     *
     * @see <a href="http://schema.org/HardwareStore">HardwareStore</a>
     */
    public static final IRI HardwareStore;

    /**
     * hasBroadcastChannel
     * <p>
     * {@code http://schema.org/hasBroadcastChannel}
     * <p>
     * A broadcast channel of a broadcast service.
     *
     * @see <a href="http://schema.org/hasBroadcastChannel">hasBroadcastChannel</a>
     */
    public static final IRI hasBroadcastChannel;

    /**
     * hasCategoryCode
     * <p>
     * {@code http://schema.org/hasCategoryCode}
     * <p>
     * A Category code contained in this code set.
     *
     * @see <a href="http://schema.org/hasCategoryCode">hasCategoryCode</a>
     */
    public static final IRI hasCategoryCode;

    /**
     * hasCourseInstance
     * <p>
     * {@code http://schema.org/hasCourseInstance}
     * <p>
     * An offering of the course at a specific time and place or through
     * specific media or mode of study or to a specific section of students.
     *
     * @see <a href="http://schema.org/hasCourseInstance">hasCourseInstance</a>
     */
    public static final IRI hasCourseInstance;

    /**
     * hasDefinedTerm
     * <p>
     * {@code http://schema.org/hasDefinedTerm}
     * <p>
     * A Defined Term contained in this term set.
     *
     * @see <a href="http://schema.org/hasDefinedTerm">hasDefinedTerm</a>
     */
    public static final IRI hasDefinedTerm;

    /**
     * hasDeliveryMethod
     * <p>
     * {@code http://schema.org/hasDeliveryMethod}
     * <p>
     * Method used for delivery or shipping.
     *
     * @see <a href="http://schema.org/hasDeliveryMethod">hasDeliveryMethod</a>
     */
    public static final IRI hasDeliveryMethod;

    /**
     * hasDigitalDocumentPermission
     * <p>
     * {@code http://schema.org/hasDigitalDocumentPermission}
     * <p>
     * A permission related to the access to this document (e.g. permission
     * to read or write an electronic document). For a public document,
     * specify a grantee with an Audience with audienceType equal to
     * &quot;public&quot;.
     *
     * @see <a href="http://schema.org/hasDigitalDocumentPermission">hasDigitalDocumentPermission</a>
     */
    public static final IRI hasDigitalDocumentPermission;

    /**
     * hasMap
     * <p>
     * {@code http://schema.org/hasMap}
     * <p>
     * A URL to a map of the place.
     *
     * @see <a href="http://schema.org/hasMap">hasMap</a>
     */
    public static final IRI hasMap;

    /**
     * hasMenu
     * <p>
     * {@code http://schema.org/hasMenu}
     * <p>
     * Either the actual menu as a structured representation, as text, or a
     * URL of the menu.
     *
     * @see <a href="http://schema.org/hasMenu">hasMenu</a>
     */
    public static final IRI hasMenu;

    /**
     * hasMenuItem
     * <p>
     * {@code http://schema.org/hasMenuItem}
     * <p>
     * A food or drink item contained in a menu or menu section.
     *
     * @see <a href="http://schema.org/hasMenuItem">hasMenuItem</a>
     */
    public static final IRI hasMenuItem;

    /**
     * hasMenuSection
     * <p>
     * {@code http://schema.org/hasMenuSection}
     * <p>
     * A subgrouping of the menu (by dishes, course, serving time period,
     * etc.).
     *
     * @see <a href="http://schema.org/hasMenuSection">hasMenuSection</a>
     */
    public static final IRI hasMenuSection;

    /**
     * hasOccupation
     * <p>
     * {@code http://schema.org/hasOccupation}
     * <p>
     * The Person&#39;s occupation. For past professions, use Role for
     * expressing dates.
     *
     * @see <a href="http://schema.org/hasOccupation">hasOccupation</a>
     */
    public static final IRI hasOccupation;

    /**
     * hasOfferCatalog
     * <p>
     * {@code http://schema.org/hasOfferCatalog}
     * <p>
     * Indicates an OfferCatalog listing for this Organization, Person, or
     * Service.
     *
     * @see <a href="http://schema.org/hasOfferCatalog">hasOfferCatalog</a>
     */
    public static final IRI hasOfferCatalog;

    /**
     * hasPart
     * <p>
     * {@code http://schema.org/hasPart}
     * <p>
     * Indicates an item or CreativeWork that is part of this item, or
     * CreativeWork (in some sense).
     *
     * @see <a href="http://schema.org/hasPart">hasPart</a>
     */
    public static final IRI hasPart;

    /**
     * hasPOS
     * <p>
     * {@code http://schema.org/hasPOS}
     * <p>
     * Points-of-Sales operated by the organization or person.
     *
     * @see <a href="http://schema.org/hasPOS">hasPOS</a>
     */
    public static final IRI hasPOS;

    /**
     * headline
     * <p>
     * {@code http://schema.org/headline}
     * <p>
     * Headline of the article.
     *
     * @see <a href="http://schema.org/headline">headline</a>
     */
    public static final IRI headline;

    /**
     * HealthAndBeautyBusiness
     * <p>
     * {@code http://schema.org/HealthAndBeautyBusiness}
     * <p>
     * Health and beauty.
     *
     * @see <a href="http://schema.org/HealthAndBeautyBusiness">HealthAndBeautyBusiness</a>
     */
    public static final IRI HealthAndBeautyBusiness;

    /**
     * HealthClub
     * <p>
     * {@code http://schema.org/HealthClub}
     * <p>
     * A health club.
     *
     * @see <a href="http://schema.org/HealthClub">HealthClub</a>
     */
    public static final IRI HealthClub;

    /**
     * healthCondition
     * <p>
     * {@code http://schema.org/healthCondition}
     * <p>
     * Specifying the health condition(s) of a patient, medical study, or
     * other target audience.
     *
     * @see <a href="http://schema.org/healthCondition">healthCondition</a>
     */
    public static final IRI healthCondition;

    /**
     * HealthInsurancePlan
     * <p>
     * {@code http://schema.org/HealthInsurancePlan}
     * <p>
     * A US-style health insurance plan, including PPOs, EPOs, and HMOs.
     *
     * @see <a href="http://schema.org/HealthInsurancePlan">HealthInsurancePlan</a>
     */
    public static final IRI HealthInsurancePlan;

    /**
     * healthPlanCoinsuranceOption
     * <p>
     * {@code http://schema.org/healthPlanCoinsuranceOption}
     * <p>
     * Whether the coinsurance applies before or after deductible, etc. TODO:
     * Is this a closed set?
     *
     * @see <a href="http://schema.org/healthPlanCoinsuranceOption">healthPlanCoinsuranceOption</a>
     */
    public static final IRI healthPlanCoinsuranceOption;

    /**
     * healthPlanCoinsuranceRate
     * <p>
     * {@code http://schema.org/healthPlanCoinsuranceRate}
     * <p>
     * Whether The rate of coinsurance expressed as a number between 0.0 and
     * 1.0.
     *
     * @see <a href="http://schema.org/healthPlanCoinsuranceRate">healthPlanCoinsuranceRate</a>
     */
    public static final IRI healthPlanCoinsuranceRate;

    /**
     * healthPlanCopay
     * <p>
     * {@code http://schema.org/healthPlanCopay}
     * <p>
     * Whether The copay amount.
     *
     * @see <a href="http://schema.org/healthPlanCopay">healthPlanCopay</a>
     */
    public static final IRI healthPlanCopay;

    /**
     * healthPlanCopayOption
     * <p>
     * {@code http://schema.org/healthPlanCopayOption}
     * <p>
     * Whether the copay is before or after deductible, etc. TODO: Is this a
     * closed set?
     *
     * @see <a href="http://schema.org/healthPlanCopayOption">healthPlanCopayOption</a>
     */
    public static final IRI healthPlanCopayOption;

    /**
     * healthPlanCostSharing
     * <p>
     * {@code http://schema.org/healthPlanCostSharing}
     * <p>
     * Whether The costs to the patient for services under this network or
     * formulary.
     *
     * @see <a href="http://schema.org/healthPlanCostSharing">healthPlanCostSharing</a>
     */
    public static final IRI healthPlanCostSharing;

    /**
     * HealthPlanCostSharingSpecification
     * <p>
     * {@code http://schema.org/HealthPlanCostSharingSpecification}
     * <p>
     * A description of costs to the patient under a given network or
     * formulary.
     *
     * @see <a href="http://schema.org/HealthPlanCostSharingSpecification">HealthPlanCostSharingSpecification</a>
     */
    public static final IRI HealthPlanCostSharingSpecification;

    /**
     * healthPlanDrugOption
     * <p>
     * {@code http://schema.org/healthPlanDrugOption}
     * <p>
     * TODO.
     *
     * @see <a href="http://schema.org/healthPlanDrugOption">healthPlanDrugOption</a>
     */
    public static final IRI healthPlanDrugOption;

    /**
     * healthPlanDrugTier
     * <p>
     * {@code http://schema.org/healthPlanDrugTier}
     * <p>
     * The tier(s) of drugs offered by this formulary or insurance plan.
     *
     * @see <a href="http://schema.org/healthPlanDrugTier">healthPlanDrugTier</a>
     */
    public static final IRI healthPlanDrugTier;

    /**
     * HealthPlanFormulary
     * <p>
     * {@code http://schema.org/HealthPlanFormulary}
     * <p>
     * For a given health insurance plan, the specification for costs and
     * coverage of prescription drugs.
     *
     * @see <a href="http://schema.org/HealthPlanFormulary">HealthPlanFormulary</a>
     */
    public static final IRI HealthPlanFormulary;

    /**
     * healthPlanId
     * <p>
     * {@code http://schema.org/healthPlanId}
     * <p>
     * The 14-character, HIOS-generated Plan ID number. (Plan IDs must be
     * unique, even across different markets.)
     *
     * @see <a href="http://schema.org/healthPlanId">healthPlanId</a>
     */
    public static final IRI healthPlanId;

    /**
     * healthPlanMarketingUrl
     * <p>
     * {@code http://schema.org/healthPlanMarketingUrl}
     * <p>
     * The URL that goes directly to the plan brochure for the specific
     * standard plan or plan variation.
     *
     * @see <a href="http://schema.org/healthPlanMarketingUrl">healthPlanMarketingUrl</a>
     */
    public static final IRI healthPlanMarketingUrl;

    /**
     * HealthPlanNetwork
     * <p>
     * {@code http://schema.org/HealthPlanNetwork}
     * <p>
     * A US-style health insurance plan network.
     *
     * @see <a href="http://schema.org/HealthPlanNetwork">HealthPlanNetwork</a>
     */
    public static final IRI HealthPlanNetwork;

    /**
     * healthPlanNetworkId
     * <p>
     * {@code http://schema.org/healthPlanNetworkId}
     * <p>
     * Name or unique ID of network. (Networks are often reused across
     * different insurance plans).
     *
     * @see <a href="http://schema.org/healthPlanNetworkId">healthPlanNetworkId</a>
     */
    public static final IRI healthPlanNetworkId;

    /**
     * healthPlanNetworkTier
     * <p>
     * {@code http://schema.org/healthPlanNetworkTier}
     * <p>
     * The tier(s) for this network.
     *
     * @see <a href="http://schema.org/healthPlanNetworkTier">healthPlanNetworkTier</a>
     */
    public static final IRI healthPlanNetworkTier;

    /**
     * healthPlanPharmacyCategory
     * <p>
     * {@code http://schema.org/healthPlanPharmacyCategory}
     * <p>
     * The category or type of pharmacy associated with this cost sharing.
     *
     * @see <a href="http://schema.org/healthPlanPharmacyCategory">healthPlanPharmacyCategory</a>
     */
    public static final IRI healthPlanPharmacyCategory;

    /**
     * height
     * <p>
     * {@code http://schema.org/height}
     * <p>
     * The height of the item.
     *
     * @see <a href="http://schema.org/height">height</a>
     */
    public static final IRI height;

    /**
     * highPrice
     * <p>
     * {@code http://schema.org/highPrice}
     * <p>
     * The highest price of all offers available.
     *
     * @see <a href="http://schema.org/highPrice">highPrice</a>
     */
    public static final IRI highPrice;

    /**
     * HighSchool
     * <p>
     * {@code http://schema.org/HighSchool}
     * <p>
     * A high school.
     *
     * @see <a href="http://schema.org/HighSchool">HighSchool</a>
     */
    public static final IRI HighSchool;

    /**
     * HinduTemple
     * <p>
     * {@code http://schema.org/HinduTemple}
     * <p>
     * A Hindu temple.
     *
     * @see <a href="http://schema.org/HinduTemple">HinduTemple</a>
     */
    public static final IRI HinduTemple;

    /**
     * hiringOrganization
     * <p>
     * {@code http://schema.org/hiringOrganization}
     * <p>
     * Organization offering the job position.
     *
     * @see <a href="http://schema.org/hiringOrganization">hiringOrganization</a>
     */
    public static final IRI hiringOrganization;

    /**
     * HobbyShop
     * <p>
     * {@code http://schema.org/HobbyShop}
     * <p>
     * A store that sells materials useful or necessary for various hobbies.
     *
     * @see <a href="http://schema.org/HobbyShop">HobbyShop</a>
     */
    public static final IRI HobbyShop;

    /**
     * HomeAndConstructionBusiness
     * <p>
     * {@code http://schema.org/HomeAndConstructionBusiness}
     * <p>
     * A construction business.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * A
     * HomeAndConstructionBusiness is a &lt;a
     * href=&quot;http://schema.org/LocalBusiness&quot;&gt;LocalBusiness&lt;/a&gt;
     * that provides services around homes and
     * buildings.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * As a &lt;a
     * href=&quot;http://schema.org/LocalBusiness&quot;&gt;LocalBusiness&lt;/a&gt;
     * it can be described as a &lt;a
     * href=&quot;http://schema.org/provider&quot;&gt;provider&lt;/a&gt; of
     * one or more &lt;a
     * href=&quot;http://schema.org/Service&quot;&gt;Service&lt;/a&gt;(s).
     *
     * @see <a href="http://schema.org/HomeAndConstructionBusiness">HomeAndConstructionBusiness</a>
     */
    public static final IRI HomeAndConstructionBusiness;

    /**
     * HomeGoodsStore
     * <p>
     * {@code http://schema.org/HomeGoodsStore}
     * <p>
     * A home goods store.
     *
     * @see <a href="http://schema.org/HomeGoodsStore">HomeGoodsStore</a>
     */
    public static final IRI HomeGoodsStore;

    /**
     * homeLocation
     * <p>
     * {@code http://schema.org/homeLocation}
     * <p>
     * A contact location for a person&#39;s residence.
     *
     * @see <a href="http://schema.org/homeLocation">homeLocation</a>
     */
    public static final IRI homeLocation;

    /**
     * homeTeam
     * <p>
     * {@code http://schema.org/homeTeam}
     * <p>
     * The home team in a sports event.
     *
     * @see <a href="http://schema.org/homeTeam">homeTeam</a>
     */
    public static final IRI homeTeam;

    /**
     * honorificPrefix
     * <p>
     * {@code http://schema.org/honorificPrefix}
     * <p>
     * An honorific prefix preceding a Person&#39;s name such as Dr/Mrs/Mr.
     *
     * @see <a href="http://schema.org/honorificPrefix">honorificPrefix</a>
     */
    public static final IRI honorificPrefix;

    /**
     * honorificSuffix
     * <p>
     * {@code http://schema.org/honorificSuffix}
     * <p>
     * An honorific suffix preceding a Person&#39;s name such as M.D.
     * /PhD/MSCSW.
     *
     * @see <a href="http://schema.org/honorificSuffix">honorificSuffix</a>
     */
    public static final IRI honorificSuffix;

    /**
     * Hospital
     * <p>
     * {@code http://schema.org/Hospital}
     * <p>
     * A hospital.
     *
     * @see <a href="http://schema.org/Hospital">Hospital</a>
     */
    public static final IRI Hospital;

    /**
     * hospitalAffiliation
     * <p>
     * {@code http://schema.org/hospitalAffiliation}
     * <p>
     * A hospital with which the physician or office is affiliated.
     *
     * @see <a href="http://schema.org/hospitalAffiliation">hospitalAffiliation</a>
     */
    public static final IRI hospitalAffiliation;

    /**
     * Hostel
     * <p>
     * {@code http://schema.org/Hostel}
     * <p>
     * A hostel - cheap accommodation, often in shared dormitories.
     * &lt;br
     * /&gt;&lt;br /&gt;
     * See also the &lt;a
     * href=&quot;/docs/hotels.html&quot;&gt;dedicated document on the use of
     * schema.org for marking up hotels and other forms of
     * accommodations&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Hostel">Hostel</a>
     */
    public static final IRI Hostel;

    /**
     * hostingOrganization
     * <p>
     * {@code http://schema.org/hostingOrganization}
     * <p>
     * The organization (airline, travelers&#39; club, etc.) the membership
     * is made with.
     *
     * @see <a href="http://schema.org/hostingOrganization">hostingOrganization</a>
     */
    public static final IRI hostingOrganization;

    /**
     * Hotel
     * <p>
     * {@code http://schema.org/Hotel}
     * <p>
     * A hotel is an establishment that provides lodging paid on a short-term
     * basis (Source: Wikipedia, the free encyclopedia, see
     * http://en.wikipedia.org/wiki/Hotel).
     * &lt;br /&gt;&lt;br /&gt;
     * See also
     * the &lt;a href=&quot;/docs/hotels.html&quot;&gt;dedicated document on
     * the use of schema.org for marking up hotels and other forms of
     * accommodations&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Hotel">Hotel</a>
     */
    public static final IRI Hotel;

    /**
     * HotelRoom
     * <p>
     * {@code http://schema.org/HotelRoom}
     * <p>
     * A hotel room is a single room in a hotel.
     * &lt;br /&gt;&lt;br /&gt;
     * See
     * also the &lt;a href=&quot;/docs/hotels.html&quot;&gt;dedicated
     * document on the use of schema.org for marking up hotels and other
     * forms of accommodations&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/HotelRoom">HotelRoom</a>
     */
    public static final IRI HotelRoom;

    /**
     * hoursAvailable
     * <p>
     * {@code http://schema.org/hoursAvailable}
     * <p>
     * The hours during which this service or contact is available.
     *
     * @see <a href="http://schema.org/hoursAvailable">hoursAvailable</a>
     */
    public static final IRI hoursAvailable;

    /**
     * House
     * <p>
     * {@code http://schema.org/House}
     * <p>
     * A house is a building or structure that has the ability to be occupied
     * for habitation by humans or other creatures (Source: Wikipedia, the
     * free encyclopedia, see &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/House&quot;&gt;http://en.wikipedia.org/wiki/House&lt;/a&gt;).
     *
     * @see <a href="http://schema.org/House">House</a>
     */
    public static final IRI House;

    /**
     * HousePainter
     * <p>
     * {@code http://schema.org/HousePainter}
     * <p>
     * A house painting service.
     *
     * @see <a href="http://schema.org/HousePainter">HousePainter</a>
     */
    public static final IRI HousePainter;

    /**
     * howPerformed
     * <p>
     * {@code http://schema.org/howPerformed}
     * <p>
     * How the procedure is performed.
     *
     * @see <a href="http://schema.org/howPerformed">howPerformed</a>
     */
    public static final IRI howPerformed;

    /**
     * HowTo
     * <p>
     * {@code http://schema.org/HowTo}
     * <p>
     * Instructions that explain how to achieve a result by performing a
     * sequence of steps.
     *
     * @see <a href="http://schema.org/HowTo">HowTo</a>
     */
    public static final IRI HowTo;

    /**
     * HowToDirection
     * <p>
     * {@code http://schema.org/HowToDirection}
     * <p>
     * A direction indicating a single action to do in the instructions for
     * how to achieve a result.
     *
     * @see <a href="http://schema.org/HowToDirection">HowToDirection</a>
     */
    public static final IRI HowToDirection;

    /**
     * HowToItem
     * <p>
     * {@code http://schema.org/HowToItem}
     * <p>
     * An item used as either a tool or supply when performing the
     * instructions for how to to achieve a result.
     *
     * @see <a href="http://schema.org/HowToItem">HowToItem</a>
     */
    public static final IRI HowToItem;

    /**
     * HowToSection
     * <p>
     * {@code http://schema.org/HowToSection}
     * <p>
     * A sub-grouping of steps in the instructions for how to achieve a
     * result (e.g. steps for making a pie crust within a pie recipe).
     *
     * @see <a href="http://schema.org/HowToSection">HowToSection</a>
     */
    public static final IRI HowToSection;

    /**
     * HowToStep
     * <p>
     * {@code http://schema.org/HowToStep}
     * <p>
     * A step in the instructions for how to achieve a result. It is an
     * ordered list with HowToDirection and/or HowToTip items.
     *
     * @see <a href="http://schema.org/HowToStep">HowToStep</a>
     */
    public static final IRI HowToStep;

    /**
     * HowToSupply
     * <p>
     * {@code http://schema.org/HowToSupply}
     * <p>
     * A supply consumed when performing the instructions for how to achieve
     * a result.
     *
     * @see <a href="http://schema.org/HowToSupply">HowToSupply</a>
     */
    public static final IRI HowToSupply;

    /**
     * HowToTip
     * <p>
     * {@code http://schema.org/HowToTip}
     * <p>
     * An explanation in the instructions for how to achieve a result. It
     * provides supplementary information about a technique, supply,
     * author&#39;s preference, etc. It can explain what could be done, or
     * what should not be done, but doesn&#39;t specify what should be done
     * (see HowToDirection).
     *
     * @see <a href="http://schema.org/HowToTip">HowToTip</a>
     */
    public static final IRI HowToTip;

    /**
     * HowToTool
     * <p>
     * {@code http://schema.org/HowToTool}
     * <p>
     * A tool used (but not consumed) when performing instructions for how to
     * achieve a result.
     *
     * @see <a href="http://schema.org/HowToTool">HowToTool</a>
     */
    public static final IRI HowToTool;

    /**
     * httpMethod
     * <p>
     * {@code http://schema.org/httpMethod}
     * <p>
     * An HTTP method that specifies the appropriate HTTP method for a
     * request to an HTTP EntryPoint. Values are capitalized strings as used
     * in HTTP.
     *
     * @see <a href="http://schema.org/httpMethod">httpMethod</a>
     */
    public static final IRI httpMethod;

    /**
     * HVACBusiness
     * <p>
     * {@code http://schema.org/HVACBusiness}
     * <p>
     * A business that provide Heating, Ventilation and Air Conditioning
     * services.
     *
     * @see <a href="http://schema.org/HVACBusiness">HVACBusiness</a>
     */
    public static final IRI HVACBusiness;

    /**
     * iataCode
     * <p>
     * {@code http://schema.org/iataCode}
     * <p>
     * IATA identifier for an airline or airport.
     *
     * @see <a href="http://schema.org/iataCode">iataCode</a>
     */
    public static final IRI iataCode;

    /**
     * icaoCode
     * <p>
     * {@code http://schema.org/icaoCode}
     * <p>
     * ICAO identifier for an airport.
     *
     * @see <a href="http://schema.org/icaoCode">icaoCode</a>
     */
    public static final IRI icaoCode;

    /**
     * IceCreamShop
     * <p>
     * {@code http://schema.org/IceCreamShop}
     * <p>
     * An ice cream shop.
     *
     * @see <a href="http://schema.org/IceCreamShop">IceCreamShop</a>
     */
    public static final IRI IceCreamShop;

    /**
     * identifier
     * <p>
     * {@code http://schema.org/identifier}
     * <p>
     * The identifier property represents any kind of identifier for any kind
     * of &lt;a href=&quot;http://schema.org/Thing&quot;&gt;Thing&lt;/a&gt;,
     * such as ISBNs, GTIN codes, UUIDs etc. Schema.org provides dedicated
     * properties for representing many of these, either as textual strings
     * or as URL (URI) links. See &lt;a
     * href=&quot;/docs/datamodel.html#identifierBg&quot;&gt;background
     * notes&lt;/a&gt; for more details.
     *
     * @see <a href="http://schema.org/identifier">identifier</a>
     */
    public static final IRI identifier;

    /**
     * identifyingExam
     * <p>
     * {@code http://schema.org/identifyingExam}
     * <p>
     * A physical examination that can identify this sign.
     *
     * @see <a href="http://schema.org/identifyingExam">identifyingExam</a>
     */
    public static final IRI identifyingExam;

    /**
     * identifyingTest
     * <p>
     * {@code http://schema.org/identifyingTest}
     * <p>
     * A diagnostic test that can identify this sign.
     *
     * @see <a href="http://schema.org/identifyingTest">identifyingTest</a>
     */
    public static final IRI identifyingTest;

    /**
     * IgnoreAction
     * <p>
     * {@code http://schema.org/IgnoreAction}
     * <p>
     * The act of intentionally disregarding the object. An agent ignores an
     * object.
     *
     * @see <a href="http://schema.org/IgnoreAction">IgnoreAction</a>
     */
    public static final IRI IgnoreAction;

    /**
     * illustrator
     * <p>
     * {@code http://schema.org/illustrator}
     * <p>
     * The illustrator of the book.
     *
     * @see <a href="http://schema.org/illustrator">illustrator</a>
     */
    public static final IRI illustrator;

    /**
     * image
     * <p>
     * {@code http://schema.org/image}
     * <p>
     * An image of the item. This can be a &lt;a
     * href=&quot;http://schema.org/URL&quot;&gt;URL&lt;/a&gt; or a fully
     * described &lt;a
     * href=&quot;http://schema.org/ImageObject&quot;&gt;ImageObject&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/image">image</a>
     */
    public static final IRI image;

    /**
     * ImageGallery
     * <p>
     * {@code http://schema.org/ImageGallery}
     * <p>
     * Web page type: Image gallery page.
     *
     * @see <a href="http://schema.org/ImageGallery">ImageGallery</a>
     */
    public static final IRI ImageGallery;

    /**
     * ImageObject
     * <p>
     * {@code http://schema.org/ImageObject}
     * <p>
     * An image file.
     *
     * @see <a href="http://schema.org/ImageObject">ImageObject</a>
     */
    public static final IRI ImageObject;

    /**
     * imagingTechnique
     * <p>
     * {@code http://schema.org/imagingTechnique}
     * <p>
     * Imaging technique used.
     *
     * @see <a href="http://schema.org/imagingTechnique">imagingTechnique</a>
     */
    public static final IRI imagingTechnique;

    /**
     * ImagingTest
     * <p>
     * {@code http://schema.org/ImagingTest}
     * <p>
     * Any medical imaging modality typically used for diagnostic purposes.
     *
     * @see <a href="http://schema.org/ImagingTest">ImagingTest</a>
     */
    public static final IRI ImagingTest;

    /**
     * inAlbum
     * <p>
     * {@code http://schema.org/inAlbum}
     * <p>
     * The album to which this recording belongs.
     *
     * @see <a href="http://schema.org/inAlbum">inAlbum</a>
     */
    public static final IRI inAlbum;

    /**
     * inBroadcastLineup
     * <p>
     * {@code http://schema.org/inBroadcastLineup}
     * <p>
     * The CableOrSatelliteService offering the channel.
     *
     * @see <a href="http://schema.org/inBroadcastLineup">inBroadcastLineup</a>
     */
    public static final IRI inBroadcastLineup;

    /**
     * incentiveCompensation
     * <p>
     * {@code http://schema.org/incentiveCompensation}
     * <p>
     * Description of bonus and commission compensation aspects of the job.
     *
     * @see <a href="http://schema.org/incentiveCompensation">incentiveCompensation</a>
     */
    public static final IRI incentiveCompensation;

    /**
     * incentives
     * <p>
     * {@code http://schema.org/incentives}
     * <p>
     * Description of bonus and commission compensation aspects of the job.
     *
     * @see <a href="http://schema.org/incentives">incentives</a>
     */
    public static final IRI incentives;

    /**
     * includedComposition
     * <p>
     * {@code http://schema.org/includedComposition}
     * <p>
     * Smaller compositions included in this work (e.g. a movement in a
     * symphony).
     *
     * @see <a href="http://schema.org/includedComposition">includedComposition</a>
     */
    public static final IRI includedComposition;

    /**
     * includedDataCatalog
     * <p>
     * {@code http://schema.org/includedDataCatalog}
     * <p>
     * A data catalog which contains this dataset (this property was
     * previously &#39;catalog&#39;, preferred name is now
     * &#39;includedInDataCatalog&#39;).
     *
     * @see <a href="http://schema.org/includedDataCatalog">includedDataCatalog</a>
     */
    public static final IRI includedDataCatalog;

    /**
     * includedInDataCatalog
     * <p>
     * {@code http://schema.org/includedInDataCatalog}
     * <p>
     * A data catalog which contains this dataset.
     *
     * @see <a href="http://schema.org/includedInDataCatalog">includedInDataCatalog</a>
     */
    public static final IRI includedInDataCatalog;

    /**
     * includedInHealthInsurancePlan
     * <p>
     * {@code http://schema.org/includedInHealthInsurancePlan}
     * <p>
     * The insurance plans that cover this drug.
     *
     * @see <a href="http://schema.org/includedInHealthInsurancePlan">includedInHealthInsurancePlan</a>
     */
    public static final IRI includedInHealthInsurancePlan;

    /**
     * includedRiskFactor
     * <p>
     * {@code http://schema.org/includedRiskFactor}
     * <p>
     * A modifiable or non-modifiable risk factor included in the
     * calculation, e.g. age, coexisting condition.
     *
     * @see <a href="http://schema.org/includedRiskFactor">includedRiskFactor</a>
     */
    public static final IRI includedRiskFactor;

    /**
     * includesAttraction
     * <p>
     * {@code http://schema.org/includesAttraction}
     * <p>
     * Attraction located at destination.
     *
     * @see <a href="http://schema.org/includesAttraction">includesAttraction</a>
     */
    public static final IRI includesAttraction;

    /**
     * includesHealthPlanFormulary
     * <p>
     * {@code http://schema.org/includesHealthPlanFormulary}
     * <p>
     * Formularies covered by this plan.
     *
     * @see <a href="http://schema.org/includesHealthPlanFormulary">includesHealthPlanFormulary</a>
     */
    public static final IRI includesHealthPlanFormulary;

    /**
     * includesHealthPlanNetwork
     * <p>
     * {@code http://schema.org/includesHealthPlanNetwork}
     * <p>
     * Networks covered by this plan.
     *
     * @see <a href="http://schema.org/includesHealthPlanNetwork">includesHealthPlanNetwork</a>
     */
    public static final IRI includesHealthPlanNetwork;

    /**
     * includesObject
     * <p>
     * {@code http://schema.org/includesObject}
     * <p>
     * This links to a node or nodes indicating the exact quantity of the
     * products included in the offer.
     *
     * @see <a href="http://schema.org/includesObject">includesObject</a>
     */
    public static final IRI includesObject;

    /**
     * inCodeSet
     * <p>
     * {@code http://schema.org/inCodeSet}
     * <p>
     * A &lt;a
     * href=&quot;http://schema.org/CategoryCodeSet&quot;&gt;CategoryCodeSet&lt;/a&gt;
     * that contains this catagory code.
     *
     * @see <a href="http://schema.org/inCodeSet">inCodeSet</a>
     */
    public static final IRI inCodeSet;

    /**
     * increasesRiskOf
     * <p>
     * {@code http://schema.org/increasesRiskOf}
     * <p>
     * The condition, complication, etc. influenced by this factor.
     *
     * @see <a href="http://schema.org/increasesRiskOf">increasesRiskOf</a>
     */
    public static final IRI increasesRiskOf;

    /**
     * inDefinedTermSet
     * <p>
     * {@code http://schema.org/inDefinedTermSet}
     * <p>
     * A &lt;a
     * href=&quot;http://schema.org/DefinedTermSet&quot;&gt;DefinedTermSet&lt;/a&gt;
     * that contains this term.
     *
     * @see <a href="http://schema.org/inDefinedTermSet">inDefinedTermSet</a>
     */
    public static final IRI inDefinedTermSet;

    /**
     * indication
     * <p>
     * {@code http://schema.org/indication}
     * <p>
     * A factor that indicates use of this therapy for treatment and/or
     * prevention of a condition, symptom, etc. For therapies such as drugs,
     * indications can include both officially-approved indications as well
     * as off-label uses. These can be distinguished by using the
     * ApprovedIndication subtype of MedicalIndication.
     *
     * @see <a href="http://schema.org/indication">indication</a>
     */
    public static final IRI indication;

    /**
     * IndividualProduct
     * <p>
     * {@code http://schema.org/IndividualProduct}
     * <p>
     * A single, identifiable product instance (e.g. a laptop with a
     * particular serial number).
     *
     * @see <a href="http://schema.org/IndividualProduct">IndividualProduct</a>
     */
    public static final IRI IndividualProduct;

    /**
     * industry
     * <p>
     * {@code http://schema.org/industry}
     * <p>
     * The industry associated with the job position.
     *
     * @see <a href="http://schema.org/industry">industry</a>
     */
    public static final IRI industry;

    /**
     * ineligibleRegion
     * <p>
     * {@code http://schema.org/ineligibleRegion}
     * <p>
     * The ISO 3166-1 (ISO 3166-1 alpha-2) or ISO 3166-2 code, the place, or
     * the GeoShape for the geo-political region(s) for which the offer or
     * delivery charge specification is not valid, e.g. a region where the
     * transaction is not allowed.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * See also &lt;a
     * href=&quot;http://schema.org/eligibleRegion&quot;&gt;eligibleRegion&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/ineligibleRegion">ineligibleRegion</a>
     */
    public static final IRI ineligibleRegion;

    /**
     * infectiousAgent
     * <p>
     * {@code http://schema.org/infectiousAgent}
     * <p>
     * The actual infectious agent, such as a specific bacterium.
     *
     * @see <a href="http://schema.org/infectiousAgent">infectiousAgent</a>
     */
    public static final IRI infectiousAgent;

    /**
     * InfectiousAgentClass
     * <p>
     * {@code http://schema.org/InfectiousAgentClass}
     * <p>
     * Classes of agents or pathogens that transmit infectious diseases.
     * Enumerated type.
     *
     * @see <a href="http://schema.org/InfectiousAgentClass">InfectiousAgentClass</a>
     */
    public static final IRI InfectiousAgentClass;

    /**
     * infectiousAgentClass
     * <p>
     * {@code http://schema.org/infectiousAgentClass}
     * <p>
     * The class of infectious agent (bacteria, prion, etc.) that causes the
     * disease.
     *
     * @see <a href="http://schema.org/infectiousAgentClass">infectiousAgentClass</a>
     */
    public static final IRI infectiousAgentClass;

    /**
     * InfectiousDisease
     * <p>
     * {@code http://schema.org/InfectiousDisease}
     * <p>
     * An infectious disease is a clinically evident human disease resulting
     * from the presence of pathogenic microbial agents, like pathogenic
     * viruses, pathogenic bacteria, fungi, protozoa, multicellular
     * parasites, and prions. To be considered an infectious disease, such
     * pathogens are known to be able to cause this disease.
     *
     * @see <a href="http://schema.org/InfectiousDisease">InfectiousDisease</a>
     */
    public static final IRI InfectiousDisease;

    /**
     * InformAction
     * <p>
     * {@code http://schema.org/InformAction}
     * <p>
     * The act of notifying someone of information pertinent to them, with no
     * expectation of a response.
     *
     * @see <a href="http://schema.org/InformAction">InformAction</a>
     */
    public static final IRI InformAction;

    /**
     * ingredients
     * <p>
     * {@code http://schema.org/ingredients}
     * <p>
     * A single ingredient used in the recipe, e.g. sugar, flour or garlic.
     *
     * @see <a href="http://schema.org/ingredients">ingredients</a>
     */
    public static final IRI ingredients;

    /**
     * inker
     * <p>
     * {@code http://schema.org/inker}
     * <p>
     * The individual who traces over the pencil drawings in ink after
     * pencils are complete.
     *
     * @see <a href="http://schema.org/inker">inker</a>
     */
    public static final IRI inker;

    /**
     * inLanguage
     * <p>
     * {@code http://schema.org/inLanguage}
     * <p>
     * The language of the content or performance or used in an action.
     * Please use one of the language codes from the &lt;a
     * href=&quot;http://tools.ietf.org/html/bcp47&quot;&gt;IETF BCP 47
     * standard&lt;/a&gt;. See also &lt;a
     * href=&quot;http://schema.org/availableLanguage&quot;&gt;availableLanguage&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/inLanguage">inLanguage</a>
     */
    public static final IRI inLanguage;

    /**
     * inPlaylist
     * <p>
     * {@code http://schema.org/inPlaylist}
     * <p>
     * The playlist to which this recording belongs.
     *
     * @see <a href="http://schema.org/inPlaylist">inPlaylist</a>
     */
    public static final IRI inPlaylist;

    /**
     * InsertAction
     * <p>
     * {@code http://schema.org/InsertAction}
     * <p>
     * The act of adding at a specific location in an ordered collection.
     *
     * @see <a href="http://schema.org/InsertAction">InsertAction</a>
     */
    public static final IRI InsertAction;

    /**
     * insertion
     * <p>
     * {@code http://schema.org/insertion}
     * <p>
     * The place of attachment of a muscle, or what the muscle moves.
     *
     * @see <a href="http://schema.org/insertion">insertion</a>
     */
    public static final IRI insertion;

    /**
     * InstallAction
     * <p>
     * {@code http://schema.org/InstallAction}
     * <p>
     * The act of installing an application.
     *
     * @see <a href="http://schema.org/InstallAction">InstallAction</a>
     */
    public static final IRI InstallAction;

    /**
     * installUrl
     * <p>
     * {@code http://schema.org/installUrl}
     * <p>
     * URL at which the app may be installed, if different from the URL of
     * the item.
     *
     * @see <a href="http://schema.org/installUrl">installUrl</a>
     */
    public static final IRI installUrl;

    /**
     * instructor
     * <p>
     * {@code http://schema.org/instructor}
     * <p>
     * A person assigned to instruct or provide instructional assistance for
     * the &lt;a
     * href=&quot;http://schema.org/CourseInstance&quot;&gt;CourseInstance&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/instructor">instructor</a>
     */
    public static final IRI instructor;

    /**
     * instrument
     * <p>
     * {@code http://schema.org/instrument}
     * <p>
     * The object that helped the agent perform the action. e.g. John wrote a
     * book with &lt;em&gt;a pen&lt;/em&gt;.
     *
     * @see <a href="http://schema.org/instrument">instrument</a>
     */
    public static final IRI instrument;

    /**
     * inSupportOf
     * <p>
     * {@code http://schema.org/inSupportOf}
     * <p>
     * Qualification, candidature, degree, application that Thesis supports.
     *
     * @see <a href="http://schema.org/inSupportOf">inSupportOf</a>
     */
    public static final IRI inSupportOf;

    /**
     * InsuranceAgency
     * <p>
     * {@code http://schema.org/InsuranceAgency}
     * <p>
     * An Insurance agency.
     *
     * @see <a href="http://schema.org/InsuranceAgency">InsuranceAgency</a>
     */
    public static final IRI InsuranceAgency;

    /**
     * Intangible
     * <p>
     * {@code http://schema.org/Intangible}
     * <p>
     * A utility class that serves as the umbrella for a number of
     * &#39;intangible&#39; things such as quantities, structured values,
     * etc.
     *
     * @see <a href="http://schema.org/Intangible">Intangible</a>
     */
    public static final IRI Intangible;

    /**
     * Integer
     * <p>
     * {@code http://schema.org/Integer}
     * <p>
     * Data type: Integer.
     *
     * @see <a href="http://schema.org/Integer">Integer</a>
     */
    public static final IRI Integer;

    /**
     * intensity
     * <p>
     * {@code http://schema.org/intensity}
     * <p>
     * Quantitative measure gauging the degree of force involved in the
     * exercise, for example, heartbeats per minute. May include the velocity
     * of the movement.
     *
     * @see <a href="http://schema.org/intensity">intensity</a>
     */
    public static final IRI intensity;

    /**
     * InteractAction
     * <p>
     * {@code http://schema.org/InteractAction}
     * <p>
     * The act of interacting with another person or organization.
     *
     * @see <a href="http://schema.org/InteractAction">InteractAction</a>
     */
    public static final IRI InteractAction;

    /**
     * interactingDrug
     * <p>
     * {@code http://schema.org/interactingDrug}
     * <p>
     * Another drug that is known to interact with this drug in a way that
     * impacts the effect of this drug or causes a risk to the patient. Note:
     * disease interactions are typically captured as contraindications.
     *
     * @see <a href="http://schema.org/interactingDrug">interactingDrug</a>
     */
    public static final IRI interactingDrug;

    /**
     * interactionCount
     * <p>
     * {@code http://schema.org/interactionCount}
     * <p>
     * This property is deprecated, alongside the UserInteraction types on
     * which it depended.
     *
     * @see <a href="http://schema.org/interactionCount">interactionCount</a>
     */
    public static final IRI interactionCount;

    /**
     * InteractionCounter
     * <p>
     * {@code http://schema.org/InteractionCounter}
     * <p>
     * A summary of how users have interacted with this CreativeWork. In most
     * cases, authors will use a subtype to specify the specific type of
     * interaction.
     *
     * @see <a href="http://schema.org/InteractionCounter">InteractionCounter</a>
     */
    public static final IRI InteractionCounter;

    /**
     * interactionService
     * <p>
     * {@code http://schema.org/interactionService}
     * <p>
     * The WebSite or SoftwareApplication where the interactions took place.
     *
     * @see <a href="http://schema.org/interactionService">interactionService</a>
     */
    public static final IRI interactionService;

    /**
     * interactionStatistic
     * <p>
     * {@code http://schema.org/interactionStatistic}
     * <p>
     * The number of interactions for the CreativeWork using the WebSite or
     * SoftwareApplication. The most specific child type of
     * InteractionCounter should be used.
     *
     * @see <a href="http://schema.org/interactionStatistic">interactionStatistic</a>
     */
    public static final IRI interactionStatistic;

    /**
     * interactionType
     * <p>
     * {@code http://schema.org/interactionType}
     * <p>
     * The Action representing the type of interaction. For up votes, +1s,
     * etc. use &lt;a
     * href=&quot;http://schema.org/LikeAction&quot;&gt;LikeAction&lt;/a&gt;.
     * For down votes use &lt;a
     * href=&quot;http://schema.org/DislikeAction&quot;&gt;DislikeAction&lt;/a&gt;.
     * Otherwise, use the most specific Action.
     *
     * @see <a href="http://schema.org/interactionType">interactionType</a>
     */
    public static final IRI interactionType;

    /**
     * interactivityType
     * <p>
     * {@code http://schema.org/interactivityType}
     * <p>
     * The predominant mode of learning supported by the learning resource.
     * Acceptable values are &#39;active&#39;, &#39;expositive&#39;, or
     * &#39;mixed&#39;.
     *
     * @see <a href="http://schema.org/interactivityType">interactivityType</a>
     */
    public static final IRI interactivityType;

    /**
     * interestRate
     * <p>
     * {@code http://schema.org/interestRate}
     * <p>
     * The interest rate, charged or paid, applicable to the financial
     * product. Note: This is different from the calculated
     * annualPercentageRate.
     *
     * @see <a href="http://schema.org/interestRate">interestRate</a>
     */
    public static final IRI interestRate;

    /**
     * InternetCafe
     * <p>
     * {@code http://schema.org/InternetCafe}
     * <p>
     * An internet cafe.
     *
     * @see <a href="http://schema.org/InternetCafe">InternetCafe</a>
     */
    public static final IRI InternetCafe;

    /**
     * inventoryLevel
     * <p>
     * {@code http://schema.org/inventoryLevel}
     * <p>
     * The current approximate inventory level for the item or items.
     *
     * @see <a href="http://schema.org/inventoryLevel">inventoryLevel</a>
     */
    public static final IRI inventoryLevel;

    /**
     * inverseOf
     * <p>
     * {@code http://schema.org/inverseOf}
     * <p>
     * Relates a property to a property that is its inverse. Inverse
     * properties relate the same pairs of items to each other, but in
     * reversed direction. For example, the &#39;alumni&#39; and
     * &#39;alumniOf&#39; properties are inverseOf each other. Some
     * properties don&#39;t have explicit inverses; in these situations RDFa
     * and JSON-LD syntax for reverse properties can be used.
     *
     * @see <a href="http://schema.org/inverseOf">inverseOf</a>
     */
    public static final IRI inverseOf;

    /**
     * InvestmentFund
     * <p>
     * {@code http://schema.org/InvestmentFund}
     * <p>
     * A company or fund that gathers capital from a number of investors to
     * create a pool of money that is then re-invested into stocks, bonds and
     * other assets.
     *
     * @see <a href="http://schema.org/InvestmentFund">InvestmentFund</a>
     */
    public static final IRI InvestmentFund;

    /**
     * InvestmentOrDeposit
     * <p>
     * {@code http://schema.org/InvestmentOrDeposit}
     * <p>
     * A type of financial product that typically requires the client to
     * transfer funds to a financial service in return for potential
     * beneficial financial return.
     *
     * @see <a href="http://schema.org/InvestmentOrDeposit">InvestmentOrDeposit</a>
     */
    public static final IRI InvestmentOrDeposit;

    /**
     * InviteAction
     * <p>
     * {@code http://schema.org/InviteAction}
     * <p>
     * The act of asking someone to attend an event. Reciprocal of
     * RsvpAction.
     *
     * @see <a href="http://schema.org/InviteAction">InviteAction</a>
     */
    public static final IRI InviteAction;

    /**
     * Invoice
     * <p>
     * {@code http://schema.org/Invoice}
     * <p>
     * A statement of the money due for goods or services; a bill.
     *
     * @see <a href="http://schema.org/Invoice">Invoice</a>
     */
    public static final IRI Invoice;

    /**
     * isAcceptingNewPatients
     * <p>
     * {@code http://schema.org/isAcceptingNewPatients}
     * <p>
     * Whether the provider is accepting new patients.
     *
     * @see <a href="http://schema.org/isAcceptingNewPatients">isAcceptingNewPatients</a>
     */
    public static final IRI isAcceptingNewPatients;

    /**
     * isAccessibleForFree
     * <p>
     * {@code http://schema.org/isAccessibleForFree}
     * <p>
     * A flag to signal that the item, event, or place is accessible for
     * free.
     *
     * @see <a href="http://schema.org/isAccessibleForFree">isAccessibleForFree</a>
     */
    public static final IRI isAccessibleForFree;

    /**
     * isAccessoryOrSparePartFor
     * <p>
     * {@code http://schema.org/isAccessoryOrSparePartFor}
     * <p>
     * A pointer to another product (or multiple products) for which this
     * product is an accessory or spare part.
     *
     * @see <a href="http://schema.org/isAccessoryOrSparePartFor">isAccessoryOrSparePartFor</a>
     */
    public static final IRI isAccessoryOrSparePartFor;

    /**
     * isAvailableGenerically
     * <p>
     * {@code http://schema.org/isAvailableGenerically}
     * <p>
     * True if the drug is available in a generic form (regardless of name).
     *
     * @see <a href="http://schema.org/isAvailableGenerically">isAvailableGenerically</a>
     */
    public static final IRI isAvailableGenerically;

    /**
     * isBasedOn
     * <p>
     * {@code http://schema.org/isBasedOn}
     * <p>
     * A resource that was used in the creation of this resource. This term
     * can be repeated for multiple sources. For example,
     * http://example.com/great-multiplication-intro.html.
     *
     * @see <a href="http://schema.org/isBasedOn">isBasedOn</a>
     */
    public static final IRI isBasedOn;

    /**
     * isBasedOnUrl
     * <p>
     * {@code http://schema.org/isBasedOnUrl}
     * <p>
     * A resource that was used in the creation of this resource. This term
     * can be repeated for multiple sources. For example,
     * http://example.com/great-multiplication-intro.html.
     *
     * @see <a href="http://schema.org/isBasedOnUrl">isBasedOnUrl</a>
     */
    public static final IRI isBasedOnUrl;

    /**
     * isbn
     * <p>
     * {@code http://schema.org/isbn}
     * <p>
     * The ISBN of the book.
     *
     * @see <a href="http://schema.org/isbn">isbn</a>
     */
    public static final IRI isbn;

    /**
     * isConsumableFor
     * <p>
     * {@code http://schema.org/isConsumableFor}
     * <p>
     * A pointer to another product (or multiple products) for which this
     * product is a consumable.
     *
     * @see <a href="http://schema.org/isConsumableFor">isConsumableFor</a>
     */
    public static final IRI isConsumableFor;

    /**
     * isFamilyFriendly
     * <p>
     * {@code http://schema.org/isFamilyFriendly}
     * <p>
     * Indicates whether this content is family friendly.
     *
     * @see <a href="http://schema.org/isFamilyFriendly">isFamilyFriendly</a>
     */
    public static final IRI isFamilyFriendly;

    /**
     * isGift
     * <p>
     * {@code http://schema.org/isGift}
     * <p>
     * Was the offer accepted as a gift for someone other than the buyer.
     *
     * @see <a href="http://schema.org/isGift">isGift</a>
     */
    public static final IRI isGift;

    /**
     * isicV4
     * <p>
     * {@code http://schema.org/isicV4}
     * <p>
     * The International Standard of Industrial Classification of All
     * Economic Activities (ISIC), Revision 4 code for a particular
     * organization, business person, or place.
     *
     * @see <a href="http://schema.org/isicV4">isicV4</a>
     */
    public static final IRI isicV4;

    /**
     * isLiveBroadcast
     * <p>
     * {@code http://schema.org/isLiveBroadcast}
     * <p>
     * True is the broadcast is of a live event.
     *
     * @see <a href="http://schema.org/isLiveBroadcast">isLiveBroadcast</a>
     */
    public static final IRI isLiveBroadcast;

    /**
     * isPartOf
     * <p>
     * {@code http://schema.org/isPartOf}
     * <p>
     * Indicates an item or CreativeWork that this item, or CreativeWork (in
     * some sense), is part of.
     *
     * @see <a href="http://schema.org/isPartOf">isPartOf</a>
     */
    public static final IRI isPartOf;

    /**
     * isProprietary
     * <p>
     * {@code http://schema.org/isProprietary}
     * <p>
     * True if this item&#39;s name is a proprietary/brand name (vs. generic
     * name).
     *
     * @see <a href="http://schema.org/isProprietary">isProprietary</a>
     */
    public static final IRI isProprietary;

    /**
     * isrcCode
     * <p>
     * {@code http://schema.org/isrcCode}
     * <p>
     * The International Standard Recording Code for the recording.
     *
     * @see <a href="http://schema.org/isrcCode">isrcCode</a>
     */
    public static final IRI isrcCode;

    /**
     * isRelatedTo
     * <p>
     * {@code http://schema.org/isRelatedTo}
     * <p>
     * A pointer to another, somehow related product (or multiple products).
     *
     * @see <a href="http://schema.org/isRelatedTo">isRelatedTo</a>
     */
    public static final IRI isRelatedTo;

    /**
     * isSimilarTo
     * <p>
     * {@code http://schema.org/isSimilarTo}
     * <p>
     * A pointer to another, functionally similar product (or multiple
     * products).
     *
     * @see <a href="http://schema.org/isSimilarTo">isSimilarTo</a>
     */
    public static final IRI isSimilarTo;

    /**
     * issn
     * <p>
     * {@code http://schema.org/issn}
     * <p>
     * The International Standard Serial Number (ISSN) that identifies this
     * serial publication. You can repeat this property to identify different
     * formats of, or the linking ISSN (ISSN-L) for, this serial publication.
     *
     * @see <a href="http://schema.org/issn">issn</a>
     */
    public static final IRI issn;

    /**
     * issuedBy
     * <p>
     * {@code http://schema.org/issuedBy}
     * <p>
     * The organization issuing the ticket or permit.
     *
     * @see <a href="http://schema.org/issuedBy">issuedBy</a>
     */
    public static final IRI issuedBy;

    /**
     * issuedThrough
     * <p>
     * {@code http://schema.org/issuedThrough}
     * <p>
     * The service through with the permit was granted.
     *
     * @see <a href="http://schema.org/issuedThrough">issuedThrough</a>
     */
    public static final IRI issuedThrough;

    /**
     * issueNumber
     * <p>
     * {@code http://schema.org/issueNumber}
     * <p>
     * Identifies the issue of publication; for example, &quot;iii&quot; or
     * &quot;2&quot;.
     *
     * @see <a href="http://schema.org/issueNumber">issueNumber</a>
     */
    public static final IRI issueNumber;

    /**
     * isVariantOf
     * <p>
     * {@code http://schema.org/isVariantOf}
     * <p>
     * A pointer to a base product from which this product is a variant. It
     * is safe to infer that the variant inherits all product features from
     * the base model, unless defined locally. This is not transitive.
     *
     * @see <a href="http://schema.org/isVariantOf">isVariantOf</a>
     */
    public static final IRI isVariantOf;

    /**
     * iswcCode
     * <p>
     * {@code http://schema.org/iswcCode}
     * <p>
     * The International Standard Musical Work Code for the composition.
     *
     * @see <a href="http://schema.org/iswcCode">iswcCode</a>
     */
    public static final IRI iswcCode;

    /**
     * item
     * <p>
     * {@code http://schema.org/item}
     * <p>
     * An entity represented by an entry in a list or data feed (e.g. an
     * &#39;artist&#39; in a list of &#39;artists&#39;)’.
     *
     * @see <a href="http://schema.org/item">item</a>
     */
    public static final IRI item;

    /**
     * ItemAvailability
     * <p>
     * {@code http://schema.org/ItemAvailability}
     * <p>
     * A list of possible product availability options.
     *
     * @see <a href="http://schema.org/ItemAvailability">ItemAvailability</a>
     */
    public static final IRI ItemAvailability;

    /**
     * itemCondition
     * <p>
     * {@code http://schema.org/itemCondition}
     * <p>
     * A predefined value from OfferItemCondition or a textual description of
     * the condition of the product or service, or the products or services
     * included in the offer.
     *
     * @see <a href="http://schema.org/itemCondition">itemCondition</a>
     */
    public static final IRI itemCondition;

    /**
     * ItemList
     * <p>
     * {@code http://schema.org/ItemList}
     * <p>
     * A list of items of any sort&amp;#x2014;for example, Top 10 Movies
     * About Weathermen, or Top 100 Party Songs. Not to be confused with HTML
     * lists, which are often used only for formatting.
     *
     * @see <a href="http://schema.org/ItemList">ItemList</a>
     */
    public static final IRI ItemList;

    /**
     * itemListElement
     * <p>
     * {@code http://schema.org/itemListElement}
     * <p>
     * For itemListElement values, you can use simple strings (e.g.
     * &quot;Peter&quot;, &quot;Paul&quot;, &quot;Mary&quot;), existing
     * entities, or use ListItem.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Text values are best
     * if the elements in the list are plain strings. Existing entities are
     * best for a simple, unordered list of existing things in your data.
     * ListItem is used with ordered lists when you want to provide
     * additional context about the element in that list or when the same
     * item might be in different places in different
     * lists.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Note: The order of elements in your
     * mark-up is not sufficient for indicating the order or elements.  Use
     * ListItem with a &#39;position&#39; property in such cases.
     *
     * @see <a href="http://schema.org/itemListElement">itemListElement</a>
     */
    public static final IRI itemListElement;

    /**
     * itemListOrder
     * <p>
     * {@code http://schema.org/itemListOrder}
     * <p>
     * Type of ordering (e.g. Ascending, Descending, Unordered).
     *
     * @see <a href="http://schema.org/itemListOrder">itemListOrder</a>
     */
    public static final IRI itemListOrder;

    /**
     * ItemListOrderType
     * <p>
     * {@code http://schema.org/ItemListOrderType}
     * <p>
     * Enumerated for values for itemListOrder for indicating how an ordered
     * ItemList is organized.
     *
     * @see <a href="http://schema.org/ItemListOrderType">ItemListOrderType</a>
     */
    public static final IRI ItemListOrderType;

    /**
     * itemOffered
     * <p>
     * {@code http://schema.org/itemOffered}
     * <p>
     * The item being offered.
     *
     * @see <a href="http://schema.org/itemOffered">itemOffered</a>
     */
    public static final IRI itemOffered;

    /**
     * ItemPage
     * <p>
     * {@code http://schema.org/ItemPage}
     * <p>
     * A page devoted to a single item, such as a particular product or
     * hotel.
     *
     * @see <a href="http://schema.org/ItemPage">ItemPage</a>
     */
    public static final IRI ItemPage;

    /**
     * itemReviewed
     * <p>
     * {@code http://schema.org/itemReviewed}
     * <p>
     * The item that is being reviewed/rated.
     *
     * @see <a href="http://schema.org/itemReviewed">itemReviewed</a>
     */
    public static final IRI itemReviewed;

    /**
     * itemShipped
     * <p>
     * {@code http://schema.org/itemShipped}
     * <p>
     * Item(s) being shipped.
     *
     * @see <a href="http://schema.org/itemShipped">itemShipped</a>
     */
    public static final IRI itemShipped;

    /**
     * itinerary
     * <p>
     * {@code http://schema.org/itinerary}
     * <p>
     * Destination(s) ( &lt;a
     * href=&quot;http://schema.org/Place&quot;&gt;Place&lt;/a&gt; ) that
     * make up a trip. For a trip where destination order is important use
     * &lt;a
     * href=&quot;http://schema.org/ItemList&quot;&gt;ItemList&lt;/a&gt; to
     * specify that order (see examples).
     *
     * @see <a href="http://schema.org/itinerary">itinerary</a>
     */
    public static final IRI itinerary;

    /**
     * JewelryStore
     * <p>
     * {@code http://schema.org/JewelryStore}
     * <p>
     * A jewelry store.
     *
     * @see <a href="http://schema.org/JewelryStore">JewelryStore</a>
     */
    public static final IRI JewelryStore;

    /**
     * jobBenefits
     * <p>
     * {@code http://schema.org/jobBenefits}
     * <p>
     * Description of benefits associated with the job.
     *
     * @see <a href="http://schema.org/jobBenefits">jobBenefits</a>
     */
    public static final IRI jobBenefits;

    /**
     * jobLocation
     * <p>
     * {@code http://schema.org/jobLocation}
     * <p>
     * A (typically single) geographic location associated with the job
     * position.
     *
     * @see <a href="http://schema.org/jobLocation">jobLocation</a>
     */
    public static final IRI jobLocation;

    /**
     * JobPosting
     * <p>
     * {@code http://schema.org/JobPosting}
     * <p>
     * A listing that describes a job opening in a certain organization.
     *
     * @see <a href="http://schema.org/JobPosting">JobPosting</a>
     */
    public static final IRI JobPosting;

    /**
     * jobTitle
     * <p>
     * {@code http://schema.org/jobTitle}
     * <p>
     * The job title of the person (for example, Financial Manager).
     *
     * @see <a href="http://schema.org/jobTitle">jobTitle</a>
     */
    public static final IRI jobTitle;

    /**
     * JoinAction
     * <p>
     * {@code http://schema.org/JoinAction}
     * <p>
     * An agent joins an event/group with participants/friends at a
     * location.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/RegisterAction&quot;&gt;RegisterAction&lt;/a&gt;:
     * Unlike RegisterAction, JoinAction refers to joining a group/team of
     * people.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/SubscribeAction&quot;&gt;SubscribeAction&lt;/a&gt;:
     * Unlike SubscribeAction, JoinAction does not imply that you&#39;ll be
     * receiving updates.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/FollowAction&quot;&gt;FollowAction&lt;/a&gt;:
     * Unlike FollowAction, JoinAction does not imply that you&#39;ll be
     * polling for updates.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/JoinAction">JoinAction</a>
     */
    public static final IRI JoinAction;

    /**
     * Joint
     * <p>
     * {@code http://schema.org/Joint}
     * <p>
     * The anatomical location at which two or more bones make contact.
     *
     * @see <a href="http://schema.org/Joint">Joint</a>
     */
    public static final IRI Joint;

    /**
     * keywords
     * <p>
     * {@code http://schema.org/keywords}
     * <p>
     * Keywords or tags used to describe this content. Multiple entries in a
     * keywords list are typically delimited by commas.
     *
     * @see <a href="http://schema.org/keywords">keywords</a>
     */
    public static final IRI keywords;

    /**
     * knownVehicleDamages
     * <p>
     * {@code http://schema.org/knownVehicleDamages}
     * <p>
     * A textual description of known damages, both repaired and unrepaired.
     *
     * @see <a href="http://schema.org/knownVehicleDamages">knownVehicleDamages</a>
     */
    public static final IRI knownVehicleDamages;

    /**
     * knows
     * <p>
     * {@code http://schema.org/knows}
     * <p>
     * The most generic bi-directional social/work relation.
     *
     * @see <a href="http://schema.org/knows">knows</a>
     */
    public static final IRI knows;

    /**
     * knowsAbout
     * <p>
     * {@code http://schema.org/knowsAbout}
     * <p>
     * Of a &lt;a
     * href=&quot;http://schema.org/Person&quot;&gt;Person&lt;/a&gt;, and
     * less typically of an &lt;a
     * href=&quot;http://schema.org/Organization&quot;&gt;Organization&lt;/a&gt;,
     * to indicate a topic that is known about - suggesting possible
     * expertise but not implying it. We do not distinguish skill levels
     * here, or yet relate this to educational content, events, objectives or
     * &lt;a
     * href=&quot;http://schema.org/JobPosting&quot;&gt;JobPosting&lt;/a&gt;
     * descriptions.
     *
     * @see <a href="http://schema.org/knowsAbout">knowsAbout</a>
     */
    public static final IRI knowsAbout;

    /**
     * knowsLanguage
     * <p>
     * {@code http://schema.org/knowsLanguage}
     * <p>
     * Of a &lt;a
     * href=&quot;http://schema.org/Person&quot;&gt;Person&lt;/a&gt;, and
     * less typically of an &lt;a
     * href=&quot;http://schema.org/Organization&quot;&gt;Organization&lt;/a&gt;,
     * to indicate a known language. We do not distinguish skill levels or
     * reading/writing/speaking/signing here. Use language codes from the
     * &lt;a href=&quot;http://tools.ietf.org/html/bcp47&quot;&gt;IETF BCP 47
     * standard&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/knowsLanguage">knowsLanguage</a>
     */
    public static final IRI knowsLanguage;

    /**
     * labelDetails
     * <p>
     * {@code http://schema.org/labelDetails}
     * <p>
     * Link to the drug&#39;s label details.
     *
     * @see <a href="http://schema.org/labelDetails">labelDetails</a>
     */
    public static final IRI labelDetails;

    /**
     * LakeBodyOfWater
     * <p>
     * {@code http://schema.org/LakeBodyOfWater}
     * <p>
     * A lake (for example, Lake Pontrachain).
     *
     * @see <a href="http://schema.org/LakeBodyOfWater">LakeBodyOfWater</a>
     */
    public static final IRI LakeBodyOfWater;

    /**
     * Landform
     * <p>
     * {@code http://schema.org/Landform}
     * <p>
     * A landform or physical feature.  Landform elements include mountains,
     * plains, lakes, rivers, seascape and oceanic waterbody interface
     * features such as bays, peninsulas, seas and so forth, including
     * sub-aqueous terrain features such as submersed mountain ranges,
     * volcanoes, and the great ocean basins.
     *
     * @see <a href="http://schema.org/Landform">Landform</a>
     */
    public static final IRI Landform;

    /**
     * landlord
     * <p>
     * {@code http://schema.org/landlord}
     * <p>
     * A sub property of participant. The owner of the real estate property.
     *
     * @see <a href="http://schema.org/landlord">landlord</a>
     */
    public static final IRI landlord;

    /**
     * LandmarksOrHistoricalBuildings
     * <p>
     * {@code http://schema.org/LandmarksOrHistoricalBuildings}
     * <p>
     * An historical landmark or building.
     *
     * @see <a href="http://schema.org/LandmarksOrHistoricalBuildings">LandmarksOrHistoricalBuildings</a>
     */
    public static final IRI LandmarksOrHistoricalBuildings;

    /**
     * Language
     * <p>
     * {@code http://schema.org/Language}
     * <p>
     * Natural languages such as Spanish, Tamil, Hindi, English, etc. Formal
     * language code tags expressed in &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/IETF_language_tag&quot;&gt;BCP
     * 47&lt;/a&gt; can be used via the &lt;a
     * href=&quot;http://schema.org/alternateName&quot;&gt;alternateName&lt;/a&gt;
     * property. The Language type previously also covered programming
     * languages such as Scheme and Lisp, which are now best represented
     * using &lt;a
     * href=&quot;http://schema.org/ComputerLanguage&quot;&gt;ComputerLanguage&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Language">Language</a>
     */
    public static final IRI Language;

    /**
     * language
     * <p>
     * {@code http://schema.org/language}
     * <p>
     * A sub property of instrument. The language used on this action.
     *
     * @see <a href="http://schema.org/language">language</a>
     */
    public static final IRI language;

    /**
     * lastReviewed
     * <p>
     * {@code http://schema.org/lastReviewed}
     * <p>
     * Date on which the content on this web page was last reviewed for
     * accuracy and/or completeness.
     *
     * @see <a href="http://schema.org/lastReviewed">lastReviewed</a>
     */
    public static final IRI lastReviewed;

    /**
     * latitude
     * <p>
     * {@code http://schema.org/latitude}
     * <p>
     * The latitude of a location. For example
     * &lt;code&gt;37.42242&lt;/code&gt; (&lt;a
     * href=&quot;https://en.wikipedia.org/wiki/World_Geodetic_System&quot;&gt;WGS
     * 84&lt;/a&gt;).
     *
     * @see <a href="http://schema.org/latitude">latitude</a>
     */
    public static final IRI latitude;

    /**
     * learningResourceType
     * <p>
     * {@code http://schema.org/learningResourceType}
     * <p>
     * The predominant type or kind characterizing the learning resource. For
     * example, &#39;presentation&#39;, &#39;handout&#39;.
     *
     * @see <a href="http://schema.org/learningResourceType">learningResourceType</a>
     */
    public static final IRI learningResourceType;

    /**
     * LeaveAction
     * <p>
     * {@code http://schema.org/LeaveAction}
     * <p>
     * An agent leaves an event / group with participants/friends at a
     * location.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/JoinAction&quot;&gt;JoinAction&lt;/a&gt;:
     * The antonym of LeaveAction.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/UnRegisterAction&quot;&gt;UnRegisterAction&lt;/a&gt;:
     * Unlike UnRegisterAction, LeaveAction implies leaving a group/team of
     * people rather than a service.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/LeaveAction">LeaveAction</a>
     */
    public static final IRI LeaveAction;

    /**
     * LegalForceStatus
     * <p>
     * {@code http://schema.org/LegalForceStatus}
     * <p>
     * A list of possible statuses for the legal force of a legislation.
     *
     * @see <a href="http://schema.org/LegalForceStatus">LegalForceStatus</a>
     */
    public static final IRI LegalForceStatus;

    /**
     * legalName
     * <p>
     * {@code http://schema.org/legalName}
     * <p>
     * The official name of the organization, e.g. the registered company
     * name.
     *
     * @see <a href="http://schema.org/legalName">legalName</a>
     */
    public static final IRI legalName;

    /**
     * LegalService
     * <p>
     * {@code http://schema.org/LegalService}
     * <p>
     * A LegalService is a business that provides legally-oriented services,
     * advice and representation, e.g. law firms.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * As a
     * &lt;a
     * href=&quot;http://schema.org/LocalBusiness&quot;&gt;LocalBusiness&lt;/a&gt;
     * it can be described as a &lt;a
     * href=&quot;http://schema.org/provider&quot;&gt;provider&lt;/a&gt; of
     * one or more &lt;a
     * href=&quot;http://schema.org/Service&quot;&gt;Service&lt;/a&gt;(s).
     *
     * @see <a href="http://schema.org/LegalService">LegalService</a>
     */
    public static final IRI LegalService;

    /**
     * legalStatus
     * <p>
     * {@code http://schema.org/legalStatus}
     * <p>
     * The drug or supplement&#39;s legal status, including any controlled
     * substance schedules that apply.
     *
     * @see <a href="http://schema.org/legalStatus">legalStatus</a>
     */
    public static final IRI legalStatus;

    /**
     * LegalValueLevel
     * <p>
     * {@code http://schema.org/LegalValueLevel}
     * <p>
     * A list of possible levels for the legal validity of a legislation.
     *
     * @see <a href="http://schema.org/LegalValueLevel">LegalValueLevel</a>
     */
    public static final IRI LegalValueLevel;

    /**
     * Legislation
     * <p>
     * {@code http://schema.org/Legislation}
     * <p>
     * A legal document such as an act, decree, bill, etc. (enforceable or
     * not) or a component of a legal act (like an article).
     *
     * @see <a href="http://schema.org/Legislation">Legislation</a>
     */
    public static final IRI Legislation;

    /**
     * legislationApplies
     * <p>
     * {@code http://schema.org/legislationApplies}
     * <p>
     * Indicates that this legislation (or part of a legislation) somehow
     * transfers another legislation in a different legislative context. This
     * is an informative link, and it has no legal value. For legally-binding
     * links of transposition, use the &lt;a
     * href=&quot;/legislationTransposes&quot;&gt;legislationTransposes&lt;/a&gt;
     * property. For example an informative consolidated law of a European
     * Union&#39;s member state &quot;applies&quot; the consolidated version
     * of the European Directive implemented in it.
     *
     * @see <a href="http://schema.org/legislationApplies">legislationApplies</a>
     */
    public static final IRI legislationApplies;

    /**
     * legislationChanges
     * <p>
     * {@code http://schema.org/legislationChanges}
     * <p>
     * Another legislation that this legislation changes. This encompasses
     * the notions of amendment, replacement, correction, repeal, or other
     * types of change. This may be a direct change (textual or non-textual
     * amendment) or a consequential or indirect change. The property is to
     * be used to express the existence of a change relationship between two
     * acts rather than the existence of a consolidated version of the text
     * that shows the result of the change. For consolidation relationships,
     * use the &lt;a
     * href=&quot;/legislationConsolidates&quot;&gt;legislationConsolidates&lt;/a&gt;
     * property.
     *
     * @see <a href="http://schema.org/legislationChanges">legislationChanges</a>
     */
    public static final IRI legislationChanges;

    /**
     * legislationConsolidates
     * <p>
     * {@code http://schema.org/legislationConsolidates}
     * <p>
     * Indicates another legislation taken into account in this consolidated
     * legislation (which is usually the product of an editorial process that
     * revises the legislation). This property should be used multiple times
     * to refer to both the original version or the previous consolidated
     * version, and to the legislations making the change.
     *
     * @see <a href="http://schema.org/legislationConsolidates">legislationConsolidates</a>
     */
    public static final IRI legislationConsolidates;

    /**
     * legislationDate
     * <p>
     * {@code http://schema.org/legislationDate}
     * <p>
     * The date of adoption or signature of the legislation. This is the date
     * at which the text is officially aknowledged to be a legislation, even
     * though it might not even be published or in force.
     *
     * @see <a href="http://schema.org/legislationDate">legislationDate</a>
     */
    public static final IRI legislationDate;

    /**
     * legislationDateVersion
     * <p>
     * {@code http://schema.org/legislationDateVersion}
     * <p>
     * The point-in-time at which the provided description of the legislation
     * is valid (e.g. : when looking at the law on the 2016-04-07 (=
     * dateVersion), I get the consolidation of 2015-04-12 of the
     * &quot;National Insurance Contributions Act 2015&quot;)
     *
     * @see <a href="http://schema.org/legislationDateVersion">legislationDateVersion</a>
     */
    public static final IRI legislationDateVersion;

    /**
     * legislationIdentifier
     * <p>
     * {@code http://schema.org/legislationIdentifier}
     * <p>
     * An identifier for the legislation. This can be either a string-based
     * identifier, like the CELEX at EU level or the NOR in France, or a
     * web-based, URL/URI identifier, like an ELI (European Legislation
     * Identifier) or an URN-Lex.
     *
     * @see <a href="http://schema.org/legislationIdentifier">legislationIdentifier</a>
     */
    public static final IRI legislationIdentifier;

    /**
     * legislationJurisdiction
     * <p>
     * {@code http://schema.org/legislationJurisdiction}
     * <p>
     * The jurisdiction from which the legislation originates.
     *
     * @see <a href="http://schema.org/legislationJurisdiction">legislationJurisdiction</a>
     */
    public static final IRI legislationJurisdiction;

    /**
     * legislationLegalForce
     * <p>
     * {@code http://schema.org/legislationLegalForce}
     * <p>
     * Whether the legislation is currently in force, not in force, or
     * partially in force.
     *
     * @see <a href="http://schema.org/legislationLegalForce">legislationLegalForce</a>
     */
    public static final IRI legislationLegalForce;

    /**
     * legislationLegalValue
     * <p>
     * {@code http://schema.org/legislationLegalValue}
     * <p>
     * The legal value of this legislation file. The same legislation can be
     * written in multiple files with different legal values. Typically a
     * digitally signed PDF have a &quot;stronger&quot; legal value than the
     * HTML file of the same act.
     *
     * @see <a href="http://schema.org/legislationLegalValue">legislationLegalValue</a>
     */
    public static final IRI legislationLegalValue;

    /**
     * LegislationObject
     * <p>
     * {@code http://schema.org/LegislationObject}
     * <p>
     * A specific object or file containing a Legislation. Note that the same
     * Legislation can be published in multiple files. For example, a
     * digitally signed PDF, a plain PDF and an HTML version.
     *
     * @see <a href="http://schema.org/LegislationObject">LegislationObject</a>
     */
    public static final IRI LegislationObject;

    /**
     * legislationPassedBy
     * <p>
     * {@code http://schema.org/legislationPassedBy}
     * <p>
     * The person or organization that originally passed or made the law :
     * typically parliament (for primary legislation) or government (for
     * secondary legislation). This indicates the &quot;legal author&quot; of
     * the law, as opposed to its physical author.
     *
     * @see <a href="http://schema.org/legislationPassedBy">legislationPassedBy</a>
     */
    public static final IRI legislationPassedBy;

    /**
     * legislationResponsible
     * <p>
     * {@code http://schema.org/legislationResponsible}
     * <p>
     * An individual or organization that has some kind of responsibility for
     * the legislation. Typically the ministry who is/was in charge of
     * elaborating the legislation, or the adressee for potential questions
     * about the legislation once it is published.
     *
     * @see <a href="http://schema.org/legislationResponsible">legislationResponsible</a>
     */
    public static final IRI legislationResponsible;

    /**
     * legislationTransposes
     * <p>
     * {@code http://schema.org/legislationTransposes}
     * <p>
     * Indicates that this legislation (or part of legislation) fulfills the
     * objectives set by another legislation, by passing appropriate
     * implementation measures. Typically, some legislations of European
     * Union&#39;s member states or regions transpose European Directives.
     * This indicates a legally binding link between the 2 legislations.
     *
     * @see <a href="http://schema.org/legislationTransposes">legislationTransposes</a>
     */
    public static final IRI legislationTransposes;

    /**
     * legislationType
     * <p>
     * {@code http://schema.org/legislationType}
     * <p>
     * The type of the legislation. Examples of values are &quot;law&quot;,
     * &quot;act&quot;, &quot;directive&quot;, &quot;decree&quot;,
     * &quot;regulation&quot;, &quot;statutory instrument&quot;, &quot;loi
     * organique&quot;, &quot;règlement grand-ducal&quot;, etc., depending on
     * the country.
     *
     * @see <a href="http://schema.org/legislationType">legislationType</a>
     */
    public static final IRI legislationType;

    /**
     * LegislativeBuilding
     * <p>
     * {@code http://schema.org/LegislativeBuilding}
     * <p>
     * A legislative building&amp;#x2014;for example, the state capitol.
     *
     * @see <a href="http://schema.org/LegislativeBuilding">LegislativeBuilding</a>
     */
    public static final IRI LegislativeBuilding;

    /**
     * leiCode
     * <p>
     * {@code http://schema.org/leiCode}
     * <p>
     * An organization identifier that uniquely identifies a legal entity as
     * defined in ISO 17442.
     *
     * @see <a href="http://schema.org/leiCode">leiCode</a>
     */
    public static final IRI leiCode;

    /**
     * LendAction
     * <p>
     * {@code http://schema.org/LendAction}
     * <p>
     * The act of providing an object under an agreement that it will be
     * returned at a later date. Reciprocal of
     * BorrowAction.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/BorrowAction&quot;&gt;BorrowAction&lt;/a&gt;:
     * Reciprocal of LendAction.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/LendAction">LendAction</a>
     */
    public static final IRI LendAction;

    /**
     * lender
     * <p>
     * {@code http://schema.org/lender}
     * <p>
     * A sub property of participant. The person that lends the object being
     * borrowed.
     *
     * @see <a href="http://schema.org/lender">lender</a>
     */
    public static final IRI lender;

    /**
     * lesser
     * <p>
     * {@code http://schema.org/lesser}
     * <p>
     * This ordering relation for qualitative values indicates that the
     * subject is lesser than the object.
     *
     * @see <a href="http://schema.org/lesser">lesser</a>
     */
    public static final IRI lesser;

    /**
     * lesserOrEqual
     * <p>
     * {@code http://schema.org/lesserOrEqual}
     * <p>
     * This ordering relation for qualitative values indicates that the
     * subject is lesser than or equal to the object.
     *
     * @see <a href="http://schema.org/lesserOrEqual">lesserOrEqual</a>
     */
    public static final IRI lesserOrEqual;

    /**
     * letterer
     * <p>
     * {@code http://schema.org/letterer}
     * <p>
     * The individual who adds lettering, including speech balloons and sound
     * effects, to artwork.
     *
     * @see <a href="http://schema.org/letterer">letterer</a>
     */
    public static final IRI letterer;

    /**
     * Library
     * <p>
     * {@code http://schema.org/Library}
     * <p>
     * A library.
     *
     * @see <a href="http://schema.org/Library">Library</a>
     */
    public static final IRI Library;

    /**
     * LibrarySystem
     * <p>
     * {@code http://schema.org/LibrarySystem}
     * <p>
     * A &lt;a
     * href=&quot;http://schema.org/LibrarySystem&quot;&gt;LibrarySystem&lt;/a&gt;
     * is a collaborative system amongst several libraries.
     *
     * @see <a href="http://schema.org/LibrarySystem">LibrarySystem</a>
     */
    public static final IRI LibrarySystem;

    /**
     * license
     * <p>
     * {@code http://schema.org/license}
     * <p>
     * A license document that applies to this content, typically indicated
     * by URL.
     *
     * @see <a href="http://schema.org/license">license</a>
     */
    public static final IRI license;

    /**
     * LifestyleModification
     * <p>
     * {@code http://schema.org/LifestyleModification}
     * <p>
     * A process of care involving exercise, changes to diet, fitness
     * routines, and other lifestyle changes aimed at improving a health
     * condition.
     *
     * @see <a href="http://schema.org/LifestyleModification">LifestyleModification</a>
     */
    public static final IRI LifestyleModification;

    /**
     * Ligament
     * <p>
     * {@code http://schema.org/Ligament}
     * <p>
     * A short band of tough, flexible, fibrous connective tissue that
     * functions to connect multiple bones, cartilages, and structurally
     * support joints.
     *
     * @see <a href="http://schema.org/Ligament">Ligament</a>
     */
    public static final IRI Ligament;

    /**
     * LikeAction
     * <p>
     * {@code http://schema.org/LikeAction}
     * <p>
     * The act of expressing a positive sentiment about the object. An agent
     * likes an object (a proposition, topic or theme) with participants.
     *
     * @see <a href="http://schema.org/LikeAction">LikeAction</a>
     */
    public static final IRI LikeAction;

    /**
     * line
     * <p>
     * {@code http://schema.org/line}
     * <p>
     * A line is a point-to-point path consisting of two or more points. A
     * line is expressed as a series of two or more point objects separated
     * by space.
     *
     * @see <a href="http://schema.org/line">line</a>
     */
    public static final IRI line;

    /**
     * linkRelationship
     * <p>
     * {@code http://schema.org/linkRelationship}
     * <p>
     * Indicates the relationship type of a Web link.
     *
     * @see <a href="http://schema.org/linkRelationship">linkRelationship</a>
     */
    public static final IRI linkRelationship;

    /**
     * LinkRole
     * <p>
     * {@code http://schema.org/LinkRole}
     * <p>
     * A Role that represents a Web link e.g. as expressed via the
     * &#39;url&#39; property. Its linkRelationship property can indicate
     * URL-based and plain textual link types e.g. those in IANA link
     * registry or others such as &#39;amphtml&#39;. This structure provides
     * a placeholder where details from HTML&#39;s link element can be
     * represented outside of HTML, e.g. in JSON-LD feeds.
     *
     * @see <a href="http://schema.org/LinkRole">LinkRole</a>
     */
    public static final IRI LinkRole;

    /**
     * LiquorStore
     * <p>
     * {@code http://schema.org/LiquorStore}
     * <p>
     * A shop that sells alcoholic drinks such as wine, beer, whisky and
     * other spirits.
     *
     * @see <a href="http://schema.org/LiquorStore">LiquorStore</a>
     */
    public static final IRI LiquorStore;

    /**
     * ListenAction
     * <p>
     * {@code http://schema.org/ListenAction}
     * <p>
     * The act of consuming audio content.
     *
     * @see <a href="http://schema.org/ListenAction">ListenAction</a>
     */
    public static final IRI ListenAction;

    /**
     * ListItem
     * <p>
     * {@code http://schema.org/ListItem}
     * <p>
     * An list item, e.g. a step in a checklist or how-to description.
     *
     * @see <a href="http://schema.org/ListItem">ListItem</a>
     */
    public static final IRI ListItem;

    /**
     * LiteraryEvent
     * <p>
     * {@code http://schema.org/LiteraryEvent}
     * <p>
     * Event type: Literary event.
     *
     * @see <a href="http://schema.org/LiteraryEvent">LiteraryEvent</a>
     */
    public static final IRI LiteraryEvent;

    /**
     * LiveBlogPosting
     * <p>
     * {@code http://schema.org/LiveBlogPosting}
     * <p>
     * A blog post intended to provide a rolling textual coverage of an
     * ongoing event through continuous updates.
     *
     * @see <a href="http://schema.org/LiveBlogPosting">LiveBlogPosting</a>
     */
    public static final IRI LiveBlogPosting;

    /**
     * liveBlogUpdate
     * <p>
     * {@code http://schema.org/liveBlogUpdate}
     * <p>
     * An update to the LiveBlog.
     *
     * @see <a href="http://schema.org/liveBlogUpdate">liveBlogUpdate</a>
     */
    public static final IRI liveBlogUpdate;

    /**
     * loanMortgageMandateAmount
     * <p>
     * {@code http://schema.org/loanMortgageMandateAmount}
     * <p>
     * Amount of mortgage mandate that can be converted into a proper
     * mortgage at a later stage.
     *
     * @see <a href="http://schema.org/loanMortgageMandateAmount">loanMortgageMandateAmount</a>
     */
    public static final IRI loanMortgageMandateAmount;

    /**
     * LoanOrCredit
     * <p>
     * {@code http://schema.org/LoanOrCredit}
     * <p>
     * A financial product for the loaning of an amount of money under agreed
     * terms and charges.
     *
     * @see <a href="http://schema.org/LoanOrCredit">LoanOrCredit</a>
     */
    public static final IRI LoanOrCredit;

    /**
     * loanPaymentAmount
     * <p>
     * {@code http://schema.org/loanPaymentAmount}
     * <p>
     * The amount of money to pay in a single payment.
     *
     * @see <a href="http://schema.org/loanPaymentAmount">loanPaymentAmount</a>
     */
    public static final IRI loanPaymentAmount;

    /**
     * loanPaymentFrequency
     * <p>
     * {@code http://schema.org/loanPaymentFrequency}
     * <p>
     * Frequency of payments due, i.e. number of months between payments.
     * This is defined as a frequency, i.e. the reciprocal of a period of
     * time.
     *
     * @see <a href="http://schema.org/loanPaymentFrequency">loanPaymentFrequency</a>
     */
    public static final IRI loanPaymentFrequency;

    /**
     * loanRepaymentForm
     * <p>
     * {@code http://schema.org/loanRepaymentForm}
     * <p>
     * A form of paying back money previously borrowed from a lender.
     * Repayment usually takes the form of periodic payments that normally
     * include part principal plus interest in each payment.
     *
     * @see <a href="http://schema.org/loanRepaymentForm">loanRepaymentForm</a>
     */
    public static final IRI loanRepaymentForm;

    /**
     * loanTerm
     * <p>
     * {@code http://schema.org/loanTerm}
     * <p>
     * The duration of the loan or credit agreement.
     *
     * @see <a href="http://schema.org/loanTerm">loanTerm</a>
     */
    public static final IRI loanTerm;

    /**
     * loanType
     * <p>
     * {@code http://schema.org/loanType}
     * <p>
     * The type of a loan or credit.
     *
     * @see <a href="http://schema.org/loanType">loanType</a>
     */
    public static final IRI loanType;

    /**
     * LocalBusiness
     * <p>
     * {@code http://schema.org/LocalBusiness}
     * <p>
     * A particular physical business or branch of an organization. Examples
     * of LocalBusiness include a restaurant, a particular branch of a
     * restaurant chain, a branch of a bank, a medical practice, a club, a
     * bowling alley, etc.
     *
     * @see <a href="http://schema.org/LocalBusiness">LocalBusiness</a>
     */
    public static final IRI LocalBusiness;

    /**
     * location
     * <p>
     * {@code http://schema.org/location}
     * <p>
     * The location of for example where the event is happening, an
     * organization is located, or where an action takes place.
     *
     * @see <a href="http://schema.org/location">location</a>
     */
    public static final IRI location;

    /**
     * locationCreated
     * <p>
     * {@code http://schema.org/locationCreated}
     * <p>
     * The location where the CreativeWork was created, which may not be the
     * same as the location depicted in the CreativeWork.
     *
     * @see <a href="http://schema.org/locationCreated">locationCreated</a>
     */
    public static final IRI locationCreated;

    /**
     * LocationFeatureSpecification
     * <p>
     * {@code http://schema.org/LocationFeatureSpecification}
     * <p>
     * Specifies a location feature by providing a structured value
     * representing a feature of an accommodation as a property-value pair of
     * varying degrees of formality.
     *
     * @see <a href="http://schema.org/LocationFeatureSpecification">LocationFeatureSpecification</a>
     */
    public static final IRI LocationFeatureSpecification;

    /**
     * LockerDelivery
     * <p>
     * {@code http://schema.org/LockerDelivery}
     * <p>
     * A DeliveryMethod in which an item is made available via locker.
     *
     * @see <a href="http://schema.org/LockerDelivery">LockerDelivery</a>
     */
    public static final IRI LockerDelivery;

    /**
     * Locksmith
     * <p>
     * {@code http://schema.org/Locksmith}
     * <p>
     * A locksmith.
     *
     * @see <a href="http://schema.org/Locksmith">Locksmith</a>
     */
    public static final IRI Locksmith;

    /**
     * LodgingBusiness
     * <p>
     * {@code http://schema.org/LodgingBusiness}
     * <p>
     * A lodging business, such as a motel, hotel, or inn.
     *
     * @see <a href="http://schema.org/LodgingBusiness">LodgingBusiness</a>
     */
    public static final IRI LodgingBusiness;

    /**
     * LodgingReservation
     * <p>
     * {@code http://schema.org/LodgingReservation}
     * <p>
     * A reservation for lodging at a hotel, motel, inn,
     * etc.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Note: This type is for information about
     * actual reservations, e.g. in confirmation emails or HTML pages with
     * individual confirmations of reservations.
     *
     * @see <a href="http://schema.org/LodgingReservation">LodgingReservation</a>
     */
    public static final IRI LodgingReservation;

    /**
     * lodgingUnitDescription
     * <p>
     * {@code http://schema.org/lodgingUnitDescription}
     * <p>
     * A full description of the lodging unit.
     *
     * @see <a href="http://schema.org/lodgingUnitDescription">lodgingUnitDescription</a>
     */
    public static final IRI lodgingUnitDescription;

    /**
     * lodgingUnitType
     * <p>
     * {@code http://schema.org/lodgingUnitType}
     * <p>
     * Textual description of the unit type (including suite vs. room, size
     * of bed, etc.).
     *
     * @see <a href="http://schema.org/lodgingUnitType">lodgingUnitType</a>
     */
    public static final IRI lodgingUnitType;

    /**
     * logo
     * <p>
     * {@code http://schema.org/logo}
     * <p>
     * An associated logo.
     *
     * @see <a href="http://schema.org/logo">logo</a>
     */
    public static final IRI logo;

    /**
     * longitude
     * <p>
     * {@code http://schema.org/longitude}
     * <p>
     * The longitude of a location. For example
     * &lt;code&gt;-122.08585&lt;/code&gt; (&lt;a
     * href=&quot;https://en.wikipedia.org/wiki/World_Geodetic_System&quot;&gt;WGS
     * 84&lt;/a&gt;).
     *
     * @see <a href="http://schema.org/longitude">longitude</a>
     */
    public static final IRI longitude;

    /**
     * LoseAction
     * <p>
     * {@code http://schema.org/LoseAction}
     * <p>
     * The act of being defeated in a competitive activity.
     *
     * @see <a href="http://schema.org/LoseAction">LoseAction</a>
     */
    public static final IRI LoseAction;

    /**
     * loser
     * <p>
     * {@code http://schema.org/loser}
     * <p>
     * A sub property of participant. The loser of the action.
     *
     * @see <a href="http://schema.org/loser">loser</a>
     */
    public static final IRI loser;

    /**
     * lowPrice
     * <p>
     * {@code http://schema.org/lowPrice}
     * <p>
     * The lowest price of all offers available.
     *
     * @see <a href="http://schema.org/lowPrice">lowPrice</a>
     */
    public static final IRI lowPrice;

    /**
     * LymphaticVessel
     * <p>
     * {@code http://schema.org/LymphaticVessel}
     * <p>
     * A type of blood vessel that specifically carries lymph fluid
     * unidirectionally toward the heart.
     *
     * @see <a href="http://schema.org/LymphaticVessel">LymphaticVessel</a>
     */
    public static final IRI LymphaticVessel;

    /**
     * lyricist
     * <p>
     * {@code http://schema.org/lyricist}
     * <p>
     * The person who wrote the words.
     *
     * @see <a href="http://schema.org/lyricist">lyricist</a>
     */
    public static final IRI lyricist;

    /**
     * lyrics
     * <p>
     * {@code http://schema.org/lyrics}
     * <p>
     * The words in the song.
     *
     * @see <a href="http://schema.org/lyrics">lyrics</a>
     */
    public static final IRI lyrics;

    /**
     * mainContentOfPage
     * <p>
     * {@code http://schema.org/mainContentOfPage}
     * <p>
     * Indicates if this web page element is the main subject of the page.
     *
     * @see <a href="http://schema.org/mainContentOfPage">mainContentOfPage</a>
     */
    public static final IRI mainContentOfPage;

    /**
     * mainEntity
     * <p>
     * {@code http://schema.org/mainEntity}
     * <p>
     * Indicates the primary entity described in some page or other
     * CreativeWork.
     *
     * @see <a href="http://schema.org/mainEntity">mainEntity</a>
     */
    public static final IRI mainEntity;

    /**
     * mainEntityOfPage
     * <p>
     * {@code http://schema.org/mainEntityOfPage}
     * <p>
     * Indicates a page (or other CreativeWork) for which this thing is the
     * main entity being described. See &lt;a
     * href=&quot;/docs/datamodel.html#mainEntityBackground&quot;&gt;background
     * notes&lt;/a&gt; for details.
     *
     * @see <a href="http://schema.org/mainEntityOfPage">mainEntityOfPage</a>
     */
    public static final IRI mainEntityOfPage;

    /**
     * makesOffer
     * <p>
     * {@code http://schema.org/makesOffer}
     * <p>
     * A pointer to products or services offered by the organization or
     * person.
     *
     * @see <a href="http://schema.org/makesOffer">makesOffer</a>
     */
    public static final IRI makesOffer;

    /**
     * manufacturer
     * <p>
     * {@code http://schema.org/manufacturer}
     * <p>
     * The manufacturer of the product.
     *
     * @see <a href="http://schema.org/manufacturer">manufacturer</a>
     */
    public static final IRI manufacturer;

    /**
     * map
     * <p>
     * {@code http://schema.org/map}
     * <p>
     * A URL to a map of the place.
     *
     * @see <a href="http://schema.org/map">map</a>
     */
    public static final IRI map;

    /**
     * Map
     * <p>
     * {@code http://schema.org/Map}
     * <p>
     * A map.
     *
     * @see <a href="http://schema.org/Map">Map</a>
     */
    public static final IRI Map;

    /**
     * MapCategoryType
     * <p>
     * {@code http://schema.org/MapCategoryType}
     * <p>
     * An enumeration of several kinds of Map.
     *
     * @see <a href="http://schema.org/MapCategoryType">MapCategoryType</a>
     */
    public static final IRI MapCategoryType;

    /**
     * maps
     * <p>
     * {@code http://schema.org/maps}
     * <p>
     * A URL to a map of the place.
     *
     * @see <a href="http://schema.org/maps">maps</a>
     */
    public static final IRI maps;

    /**
     * mapType
     * <p>
     * {@code http://schema.org/mapType}
     * <p>
     * Indicates the kind of Map, from the MapCategoryType Enumeration.
     *
     * @see <a href="http://schema.org/mapType">mapType</a>
     */
    public static final IRI mapType;

    /**
     * MarryAction
     * <p>
     * {@code http://schema.org/MarryAction}
     * <p>
     * The act of marrying a person.
     *
     * @see <a href="http://schema.org/MarryAction">MarryAction</a>
     */
    public static final IRI MarryAction;

    /**
     * Mass
     * <p>
     * {@code http://schema.org/Mass}
     * <p>
     * Properties that take Mass as values are of the form
     * &#39;&amp;lt;Number&amp;gt; &amp;lt;Mass unit of measure&amp;gt;&#39;.
     * E.g., &#39;7 kg&#39;.
     *
     * @see <a href="http://schema.org/Mass">Mass</a>
     */
    public static final IRI Mass;

    /**
     * masthead
     * <p>
     * {@code http://schema.org/masthead}
     * <p>
     * For a &lt;a
     * href=&quot;http://schema.org/NewsMediaOrganization&quot;&gt;NewsMediaOrganization&lt;/a&gt;,
     * a link to the masthead page or a page listing top editorial
     * management.
     *
     * @see <a href="http://schema.org/masthead">masthead</a>
     */
    public static final IRI masthead;

    /**
     * material
     * <p>
     * {@code http://schema.org/material}
     * <p>
     * A material that something is made from, e.g. leather, wool, cotton,
     * paper.
     *
     * @see <a href="http://schema.org/material">material</a>
     */
    public static final IRI material;

    /**
     * maximumAttendeeCapacity
     * <p>
     * {@code http://schema.org/maximumAttendeeCapacity}
     * <p>
     * The total number of individuals that may attend an event or venue.
     *
     * @see <a href="http://schema.org/maximumAttendeeCapacity">maximumAttendeeCapacity</a>
     */
    public static final IRI maximumAttendeeCapacity;

    /**
     * MaximumDoseSchedule
     * <p>
     * {@code http://schema.org/MaximumDoseSchedule}
     * <p>
     * The maximum dosing schedule considered safe for a drug or supplement
     * as recommended by an authority or by the drug/supplement&#39;s
     * manufacturer. Capture the recommending authority in the
     * recognizingAuthority property of MedicalEntity.
     *
     * @see <a href="http://schema.org/MaximumDoseSchedule">MaximumDoseSchedule</a>
     */
    public static final IRI MaximumDoseSchedule;

    /**
     * maximumIntake
     * <p>
     * {@code http://schema.org/maximumIntake}
     * <p>
     * Recommended intake of this supplement for a given population as
     * defined by a specific recommending authority.
     *
     * @see <a href="http://schema.org/maximumIntake">maximumIntake</a>
     */
    public static final IRI maximumIntake;

    /**
     * maxPrice
     * <p>
     * {@code http://schema.org/maxPrice}
     * <p>
     * The highest price if the price is a range.
     *
     * @see <a href="http://schema.org/maxPrice">maxPrice</a>
     */
    public static final IRI maxPrice;

    /**
     * maxValue
     * <p>
     * {@code http://schema.org/maxValue}
     * <p>
     * The upper value of some characteristic or property.
     *
     * @see <a href="http://schema.org/maxValue">maxValue</a>
     */
    public static final IRI maxValue;

    /**
     * mealService
     * <p>
     * {@code http://schema.org/mealService}
     * <p>
     * Description of the meals that will be provided or available for
     * purchase.
     *
     * @see <a href="http://schema.org/mealService">mealService</a>
     */
    public static final IRI mealService;

    /**
     * measurementTechnique
     * <p>
     * {@code http://schema.org/measurementTechnique}
     * <p>
     * A technique or technology used in a &lt;a
     * href=&quot;http://schema.org/Dataset&quot;&gt;Dataset&lt;/a&gt; (or
     * &lt;a
     * href=&quot;http://schema.org/DataDownload&quot;&gt;DataDownload&lt;/a&gt;,
     * &lt;a
     * href=&quot;http://schema.org/DataCatalog&quot;&gt;DataCatalog&lt;/a&gt;),
     * corresponding
     * to the method used for measuring the corresponding variable(s)
     * (described using &lt;a
     * href=&quot;http://schema.org/variableMeasured&quot;&gt;variableMeasured&lt;/a&gt;).
     * This is oriented towards scientific and scholarly dataset publication
     * but may have broader applicability; it is not intended as a full
     * representation of measurement, but rather as a high level summary for
     * dataset discovery.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * For example, if &lt;a
     * href=&quot;http://schema.org/variableMeasured&quot;&gt;variableMeasured&lt;/a&gt;
     * is: molecule concentration, &lt;a
     * href=&quot;http://schema.org/measurementTechnique&quot;&gt;measurementTechnique&lt;/a&gt;
     * could be: &quot;mass spectrometry&quot; or &quot;nmr
     * spectroscopy&quot; or &quot;colorimetry&quot; or
     * &quot;immunofluorescence&quot;.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * If the &lt;a
     * href=&quot;http://schema.org/variableMeasured&quot;&gt;variableMeasured&lt;/a&gt;
     * is &quot;depression rating&quot;, the &lt;a
     * href=&quot;http://schema.org/measurementTechnique&quot;&gt;measurementTechnique&lt;/a&gt;
     * could be &quot;Zung Scale&quot; or &quot;HAM-D&quot; or &quot;Beck
     * Depression Inventory&quot;.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * If there are
     * several &lt;a
     * href=&quot;http://schema.org/variableMeasured&quot;&gt;variableMeasured&lt;/a&gt;
     * properties recorded for some given data object, use a &lt;a
     * href=&quot;http://schema.org/PropertyValue&quot;&gt;PropertyValue&lt;/a&gt;
     * for each &lt;a
     * href=&quot;http://schema.org/variableMeasured&quot;&gt;variableMeasured&lt;/a&gt;
     * and attach the corresponding &lt;a
     * href=&quot;http://schema.org/measurementTechnique&quot;&gt;measurementTechnique&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/measurementTechnique">measurementTechnique</a>
     */
    public static final IRI measurementTechnique;

    /**
     * mechanismOfAction
     * <p>
     * {@code http://schema.org/mechanismOfAction}
     * <p>
     * The specific biochemical interaction through which this drug or
     * supplement produces its pharmacological effect.
     *
     * @see <a href="http://schema.org/mechanismOfAction">mechanismOfAction</a>
     */
    public static final IRI mechanismOfAction;

    /**
     * median
     * <p>
     * {@code http://schema.org/median}
     * <p>
     * The median value.
     *
     * @see <a href="http://schema.org/median">median</a>
     */
    public static final IRI median;

    /**
     * MediaObject
     * <p>
     * {@code http://schema.org/MediaObject}
     * <p>
     * A media object, such as an image, video, or audio object embedded in a
     * web page or a downloadable dataset i.e. DataDownload. Note that a
     * creative work may have many media objects associated with it on the
     * same web page. For example, a page about a single song
     * (MusicRecording) may have a music video (VideoObject), and a high and
     * low bandwidth audio stream (2 AudioObject&#39;s).
     *
     * @see <a href="http://schema.org/MediaObject">MediaObject</a>
     */
    public static final IRI MediaObject;

    /**
     * MediaSubscription
     * <p>
     * {@code http://schema.org/MediaSubscription}
     * <p>
     * A subscription which allows a user to access media including audio,
     * video, books, etc.
     *
     * @see <a href="http://schema.org/MediaSubscription">MediaSubscription</a>
     */
    public static final IRI MediaSubscription;

    /**
     * MedicalAudience
     * <p>
     * {@code http://schema.org/MedicalAudience}
     * <p>
     * Target audiences for medical web pages. Enumerated type.
     *
     * @see <a href="http://schema.org/MedicalAudience">MedicalAudience</a>
     */
    public static final IRI MedicalAudience;

    /**
     * MedicalBusiness
     * <p>
     * {@code http://schema.org/MedicalBusiness}
     * <p>
     * A particular physical or virtual business of an organization for
     * medical purposes. Examples of MedicalBusiness include differents
     * business run by health professionals.
     *
     * @see <a href="http://schema.org/MedicalBusiness">MedicalBusiness</a>
     */
    public static final IRI MedicalBusiness;

    /**
     * MedicalCause
     * <p>
     * {@code http://schema.org/MedicalCause}
     * <p>
     * The causative agent(s) that are responsible for the pathophysiologic
     * process that eventually results in a medical condition, symptom or
     * sign. In this schema, unless otherwise specified this is meant to be
     * the proximate cause of the medical condition, symptom or sign. The
     * proximate cause is defined as the causative agent that most directly
     * results in the medical condition, symptom or sign. For example, the
     * HIV virus could be considered a cause of AIDS. Or in a diagnostic
     * context, if a patient fell and sustained a hip fracture and two days
     * later sustained a pulmonary embolism which eventuated in a cardiac
     * arrest, the cause of the cardiac arrest (the proximate cause) would be
     * the pulmonary embolism and not the fall. Medical causes can include
     * cardiovascular, chemical, dermatologic, endocrine, environmental,
     * gastroenterologic, genetic, hematologic, gynecologic, iatrogenic,
     * infectious, musculoskeletal, neurologic, nutritional, obstetric,
     * oncologic, otolaryngologic, pharmacologic, psychiatric, pulmonary,
     * renal, rheumatologic, toxic, traumatic, or urologic causes; medical
     * conditions can be causes as well.
     *
     * @see <a href="http://schema.org/MedicalCause">MedicalCause</a>
     */
    public static final IRI MedicalCause;

    /**
     * MedicalClinic
     * <p>
     * {@code http://schema.org/MedicalClinic}
     * <p>
     * A facility, often associated with a hospital or medical school, that
     * is devoted to the specific diagnosis and/or healthcare. Previously
     * limited to outpatients but with evolution it may be open to inpatients
     * as well.
     *
     * @see <a href="http://schema.org/MedicalClinic">MedicalClinic</a>
     */
    public static final IRI MedicalClinic;

    /**
     * MedicalCode
     * <p>
     * {@code http://schema.org/MedicalCode}
     * <p>
     * A code for a medical entity.
     *
     * @see <a href="http://schema.org/MedicalCode">MedicalCode</a>
     */
    public static final IRI MedicalCode;

    /**
     * MedicalCondition
     * <p>
     * {@code http://schema.org/MedicalCondition}
     * <p>
     * Any condition of the human body that affects the normal functioning of
     * a person, whether physically or mentally. Includes diseases, injuries,
     * disabilities, disorders, syndromes, etc.
     *
     * @see <a href="http://schema.org/MedicalCondition">MedicalCondition</a>
     */
    public static final IRI MedicalCondition;

    /**
     * MedicalConditionStage
     * <p>
     * {@code http://schema.org/MedicalConditionStage}
     * <p>
     * A stage of a medical condition, such as &#39;Stage IIIa&#39;.
     *
     * @see <a href="http://schema.org/MedicalConditionStage">MedicalConditionStage</a>
     */
    public static final IRI MedicalConditionStage;

    /**
     * MedicalContraindication
     * <p>
     * {@code http://schema.org/MedicalContraindication}
     * <p>
     * A condition or factor that serves as a reason to withhold a certain
     * medical therapy. Contraindications can be absolute (there are no
     * reasonable circumstances for undertaking a course of action) or
     * relative (the patient is at higher risk of complications, but that
     * these risks may be outweighed by other considerations or mitigated by
     * other measures).
     *
     * @see <a href="http://schema.org/MedicalContraindication">MedicalContraindication</a>
     */
    public static final IRI MedicalContraindication;

    /**
     * MedicalDevice
     * <p>
     * {@code http://schema.org/MedicalDevice}
     * <p>
     * Any object used in a medical capacity, such as to diagnose or treat a
     * patient.
     *
     * @see <a href="http://schema.org/MedicalDevice">MedicalDevice</a>
     */
    public static final IRI MedicalDevice;

    /**
     * MedicalDevicePurpose
     * <p>
     * {@code http://schema.org/MedicalDevicePurpose}
     * <p>
     * Categories of medical devices, organized by the purpose or intended
     * use of the device.
     *
     * @see <a href="http://schema.org/MedicalDevicePurpose">MedicalDevicePurpose</a>
     */
    public static final IRI MedicalDevicePurpose;

    /**
     * MedicalEntity
     * <p>
     * {@code http://schema.org/MedicalEntity}
     * <p>
     * The most generic type of entity related to health and the practice of
     * medicine.
     *
     * @see <a href="http://schema.org/MedicalEntity">MedicalEntity</a>
     */
    public static final IRI MedicalEntity;

    /**
     * MedicalEnumeration
     * <p>
     * {@code http://schema.org/MedicalEnumeration}
     * <p>
     * Enumerations related to health and the practice of medicine: A concept
     * that is used to attribute a quality to another concept, as a
     * qualifier, a collection of items or a listing of all of the elements
     * of a set in medicine practice.
     *
     * @see <a href="http://schema.org/MedicalEnumeration">MedicalEnumeration</a>
     */
    public static final IRI MedicalEnumeration;

    /**
     * MedicalEvidenceLevel
     * <p>
     * {@code http://schema.org/MedicalEvidenceLevel}
     * <p>
     * Level of evidence for a medical guideline. Enumerated type.
     *
     * @see <a href="http://schema.org/MedicalEvidenceLevel">MedicalEvidenceLevel</a>
     */
    public static final IRI MedicalEvidenceLevel;

    /**
     * MedicalGuideline
     * <p>
     * {@code http://schema.org/MedicalGuideline}
     * <p>
     * Any recommendation made by a standard society (e.g. ACC/AHA) or
     * consensus statement that denotes how to diagnose and treat a
     * particular condition. Note: this type should be used to tag the actual
     * guideline recommendation; if the guideline recommendation occurs in a
     * larger scholarly article, use MedicalScholarlyArticle to tag the
     * overall article, not this type. Note also: the organization making the
     * recommendation should be captured in the recognizingAuthority base
     * property of MedicalEntity.
     *
     * @see <a href="http://schema.org/MedicalGuideline">MedicalGuideline</a>
     */
    public static final IRI MedicalGuideline;

    /**
     * MedicalGuidelineContraindication
     * <p>
     * {@code http://schema.org/MedicalGuidelineContraindication}
     * <p>
     * A guideline contraindication that designates a process as harmful and
     * where quality of the data supporting the contraindication is sound.
     *
     * @see <a href="http://schema.org/MedicalGuidelineContraindication">MedicalGuidelineContraindication</a>
     */
    public static final IRI MedicalGuidelineContraindication;

    /**
     * MedicalGuidelineRecommendation
     * <p>
     * {@code http://schema.org/MedicalGuidelineRecommendation}
     * <p>
     * A guideline recommendation that is regarded as efficacious and where
     * quality of the data supporting the recommendation is sound.
     *
     * @see <a href="http://schema.org/MedicalGuidelineRecommendation">MedicalGuidelineRecommendation</a>
     */
    public static final IRI MedicalGuidelineRecommendation;

    /**
     * MedicalImagingTechnique
     * <p>
     * {@code http://schema.org/MedicalImagingTechnique}
     * <p>
     * Any medical imaging modality typically used for diagnostic purposes.
     * Enumerated type.
     *
     * @see <a href="http://schema.org/MedicalImagingTechnique">MedicalImagingTechnique</a>
     */
    public static final IRI MedicalImagingTechnique;

    /**
     * MedicalIndication
     * <p>
     * {@code http://schema.org/MedicalIndication}
     * <p>
     * A condition or factor that indicates use of a medical therapy,
     * including signs, symptoms, risk factors, anatomical states, etc.
     *
     * @see <a href="http://schema.org/MedicalIndication">MedicalIndication</a>
     */
    public static final IRI MedicalIndication;

    /**
     * MedicalIntangible
     * <p>
     * {@code http://schema.org/MedicalIntangible}
     * <p>
     * A utility class that serves as the umbrella for a number of
     * &#39;intangible&#39; things in the medical space.
     *
     * @see <a href="http://schema.org/MedicalIntangible">MedicalIntangible</a>
     */
    public static final IRI MedicalIntangible;

    /**
     * MedicalObservationalStudy
     * <p>
     * {@code http://schema.org/MedicalObservationalStudy}
     * <p>
     * An observational study is a type of medical study that attempts to
     * infer the possible effect of a treatment through observation of a
     * cohort of subjects over a period of time. In an observational study,
     * the assignment of subjects into treatment groups versus control groups
     * is outside the control of the investigator. This is in contrast with
     * controlled studies, such as the randomized controlled trials
     * represented by MedicalTrial, where each subject is randomly assigned
     * to a treatment group or a control group before the start of the
     * treatment.
     *
     * @see <a href="http://schema.org/MedicalObservationalStudy">MedicalObservationalStudy</a>
     */
    public static final IRI MedicalObservationalStudy;

    /**
     * MedicalObservationalStudyDesign
     * <p>
     * {@code http://schema.org/MedicalObservationalStudyDesign}
     * <p>
     * Design models for observational medical studies. Enumerated type.
     *
     * @see <a href="http://schema.org/MedicalObservationalStudyDesign">MedicalObservationalStudyDesign</a>
     */
    public static final IRI MedicalObservationalStudyDesign;

    /**
     * MedicalOrganization
     * <p>
     * {@code http://schema.org/MedicalOrganization}
     * <p>
     * A medical organization (physical or not), such as hospital,
     * institution or clinic.
     *
     * @see <a href="http://schema.org/MedicalOrganization">MedicalOrganization</a>
     */
    public static final IRI MedicalOrganization;

    /**
     * MedicalProcedure
     * <p>
     * {@code http://schema.org/MedicalProcedure}
     * <p>
     * A process of care used in either a diagnostic, therapeutic, preventive
     * or palliative capacity that relies on invasive (surgical),
     * non-invasive, or other techniques.
     *
     * @see <a href="http://schema.org/MedicalProcedure">MedicalProcedure</a>
     */
    public static final IRI MedicalProcedure;

    /**
     * MedicalProcedureType
     * <p>
     * {@code http://schema.org/MedicalProcedureType}
     * <p>
     * An enumeration that describes different types of medical procedures.
     *
     * @see <a href="http://schema.org/MedicalProcedureType">MedicalProcedureType</a>
     */
    public static final IRI MedicalProcedureType;

    /**
     * MedicalRiskCalculator
     * <p>
     * {@code http://schema.org/MedicalRiskCalculator}
     * <p>
     * A complex mathematical calculation requiring an online calculator,
     * used to assess prognosis. Note: use the url property of Thing to
     * record any URLs for online calculators.
     *
     * @see <a href="http://schema.org/MedicalRiskCalculator">MedicalRiskCalculator</a>
     */
    public static final IRI MedicalRiskCalculator;

    /**
     * MedicalRiskEstimator
     * <p>
     * {@code http://schema.org/MedicalRiskEstimator}
     * <p>
     * Any rule set or interactive tool for estimating the risk of developing
     * a complication or condition.
     *
     * @see <a href="http://schema.org/MedicalRiskEstimator">MedicalRiskEstimator</a>
     */
    public static final IRI MedicalRiskEstimator;

    /**
     * MedicalRiskFactor
     * <p>
     * {@code http://schema.org/MedicalRiskFactor}
     * <p>
     * A risk factor is anything that increases a person&#39;s likelihood of
     * developing or contracting a disease, medical condition, or
     * complication.
     *
     * @see <a href="http://schema.org/MedicalRiskFactor">MedicalRiskFactor</a>
     */
    public static final IRI MedicalRiskFactor;

    /**
     * MedicalRiskScore
     * <p>
     * {@code http://schema.org/MedicalRiskScore}
     * <p>
     * A simple system that adds up the number of risk factors to yield a
     * score that is associated with prognosis, e.g. CHAD score, TIMI risk
     * score.
     *
     * @see <a href="http://schema.org/MedicalRiskScore">MedicalRiskScore</a>
     */
    public static final IRI MedicalRiskScore;

    /**
     * MedicalScholarlyArticle
     * <p>
     * {@code http://schema.org/MedicalScholarlyArticle}
     * <p>
     * A scholarly article in the medical domain.
     *
     * @see <a href="http://schema.org/MedicalScholarlyArticle">MedicalScholarlyArticle</a>
     */
    public static final IRI MedicalScholarlyArticle;

    /**
     * MedicalSign
     * <p>
     * {@code http://schema.org/MedicalSign}
     * <p>
     * Any physical manifestation of a person&#39;s medical condition
     * discoverable by objective diagnostic tests or physical examination.
     *
     * @see <a href="http://schema.org/MedicalSign">MedicalSign</a>
     */
    public static final IRI MedicalSign;

    /**
     * MedicalSignOrSymptom
     * <p>
     * {@code http://schema.org/MedicalSignOrSymptom}
     * <p>
     * Any feature associated or not with a medical condition. In medicine a
     * symptom is generally subjective while a sign is objective.
     *
     * @see <a href="http://schema.org/MedicalSignOrSymptom">MedicalSignOrSymptom</a>
     */
    public static final IRI MedicalSignOrSymptom;

    /**
     * MedicalSpecialty
     * <p>
     * {@code http://schema.org/MedicalSpecialty}
     * <p>
     * Any specific branch of medical science or practice. Medical
     * specialities include clinical specialties that pertain to particular
     * organ systems and their respective disease states, as well as allied
     * health specialties. Enumerated type.
     *
     * @see <a href="http://schema.org/MedicalSpecialty">MedicalSpecialty</a>
     */
    public static final IRI MedicalSpecialty;

    /**
     * medicalSpecialty
     * <p>
     * {@code http://schema.org/medicalSpecialty}
     * <p>
     * A medical specialty of the provider.
     *
     * @see <a href="http://schema.org/medicalSpecialty">medicalSpecialty</a>
     */
    public static final IRI medicalSpecialty;

    /**
     * MedicalStudy
     * <p>
     * {@code http://schema.org/MedicalStudy}
     * <p>
     * A medical study is an umbrella type covering all kinds of research
     * studies relating to human medicine or health, including observational
     * studies and interventional trials and registries, randomized,
     * controlled or not. When the specific type of study is known, use one
     * of the extensions of this type, such as MedicalTrial or
     * MedicalObservationalStudy. Also, note that this type should be used to
     * mark up data that describes the study itself; to tag an article that
     * publishes the results of a study, use MedicalScholarlyArticle. Note:
     * use the code property of MedicalEntity to store study IDs, e.g.
     * clinicaltrials.gov ID.
     *
     * @see <a href="http://schema.org/MedicalStudy">MedicalStudy</a>
     */
    public static final IRI MedicalStudy;

    /**
     * MedicalStudyStatus
     * <p>
     * {@code http://schema.org/MedicalStudyStatus}
     * <p>
     * The status of a medical study. Enumerated type.
     *
     * @see <a href="http://schema.org/MedicalStudyStatus">MedicalStudyStatus</a>
     */
    public static final IRI MedicalStudyStatus;

    /**
     * MedicalSymptom
     * <p>
     * {@code http://schema.org/MedicalSymptom}
     * <p>
     * Any complaint sensed and expressed by the patient (therefore defined
     * as subjective)  like stomachache, lower-back pain, or fatigue.
     *
     * @see <a href="http://schema.org/MedicalSymptom">MedicalSymptom</a>
     */
    public static final IRI MedicalSymptom;

    /**
     * MedicalTest
     * <p>
     * {@code http://schema.org/MedicalTest}
     * <p>
     * Any medical test, typically performed for diagnostic purposes.
     *
     * @see <a href="http://schema.org/MedicalTest">MedicalTest</a>
     */
    public static final IRI MedicalTest;

    /**
     * MedicalTestPanel
     * <p>
     * {@code http://schema.org/MedicalTestPanel}
     * <p>
     * Any collection of tests commonly ordered together.
     *
     * @see <a href="http://schema.org/MedicalTestPanel">MedicalTestPanel</a>
     */
    public static final IRI MedicalTestPanel;

    /**
     * MedicalTherapy
     * <p>
     * {@code http://schema.org/MedicalTherapy}
     * <p>
     * Any medical intervention designed to prevent, treat, and cure human
     * diseases and medical conditions, including both curative and
     * palliative therapies. Medical therapies are typically processes of
     * care relying upon pharmacotherapy, behavioral therapy, supportive
     * therapy (with fluid or nutrition for example), or detoxification (e.g.
     * hemodialysis) aimed at improving or preventing a health condition.
     *
     * @see <a href="http://schema.org/MedicalTherapy">MedicalTherapy</a>
     */
    public static final IRI MedicalTherapy;

    /**
     * MedicalTrial
     * <p>
     * {@code http://schema.org/MedicalTrial}
     * <p>
     * A medical trial is a type of medical study that uses scientific
     * process used to compare the safety and efficacy of medical therapies
     * or medical procedures. In general, medical trials are controlled and
     * subjects are allocated at random to the different treatment and/or
     * control groups.
     *
     * @see <a href="http://schema.org/MedicalTrial">MedicalTrial</a>
     */
    public static final IRI MedicalTrial;

    /**
     * MedicalTrialDesign
     * <p>
     * {@code http://schema.org/MedicalTrialDesign}
     * <p>
     * Design models for medical trials. Enumerated type.
     *
     * @see <a href="http://schema.org/MedicalTrialDesign">MedicalTrialDesign</a>
     */
    public static final IRI MedicalTrialDesign;

    /**
     * MedicalWebPage
     * <p>
     * {@code http://schema.org/MedicalWebPage}
     * <p>
     * A web page that provides medical information.
     *
     * @see <a href="http://schema.org/MedicalWebPage">MedicalWebPage</a>
     */
    public static final IRI MedicalWebPage;

    /**
     * MedicineSystem
     * <p>
     * {@code http://schema.org/MedicineSystem}
     * <p>
     * Systems of medical practice.
     *
     * @see <a href="http://schema.org/MedicineSystem">MedicineSystem</a>
     */
    public static final IRI MedicineSystem;

    /**
     * medicineSystem
     * <p>
     * {@code http://schema.org/medicineSystem}
     * <p>
     * The system of medicine that includes this MedicalEntity, for example
     * &#39;evidence-based&#39;, &#39;homeopathic&#39;,
     * &#39;chiropractic&#39;, etc.
     *
     * @see <a href="http://schema.org/medicineSystem">medicineSystem</a>
     */
    public static final IRI medicineSystem;

    /**
     * MeetingRoom
     * <p>
     * {@code http://schema.org/MeetingRoom}
     * <p>
     * A meeting room, conference room, or conference hall is a room provided
     * for singular events such as business conferences and meetings (Source:
     * Wikipedia, the free encyclopedia, see &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/Conference_hall&quot;&gt;http://en.wikipedia.org/wiki/Conference_hall&lt;/a&gt;).
     * &lt;br
     * /&gt;&lt;br /&gt;
     * See also the &lt;a
     * href=&quot;/docs/hotels.html&quot;&gt;dedicated document on the use of
     * schema.org for marking up hotels and other forms of
     * accommodations&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/MeetingRoom">MeetingRoom</a>
     */
    public static final IRI MeetingRoom;

    /**
     * meetsEmissionStandard
     * <p>
     * {@code http://schema.org/meetsEmissionStandard}
     * <p>
     * Indicates that the vehicle meets the respective emission standard.
     *
     * @see <a href="http://schema.org/meetsEmissionStandard">meetsEmissionStandard</a>
     */
    public static final IRI meetsEmissionStandard;

    /**
     * member
     * <p>
     * {@code http://schema.org/member}
     * <p>
     * A member of an Organization or a ProgramMembership. Organizations can
     * be members of organizations; ProgramMembership is typically for
     * individuals.
     *
     * @see <a href="http://schema.org/member">member</a>
     */
    public static final IRI member;

    /**
     * memberOf
     * <p>
     * {@code http://schema.org/memberOf}
     * <p>
     * An Organization (or ProgramMembership) to which this Person or
     * Organization belongs.
     *
     * @see <a href="http://schema.org/memberOf">memberOf</a>
     */
    public static final IRI memberOf;

    /**
     * members
     * <p>
     * {@code http://schema.org/members}
     * <p>
     * A member of this organization.
     *
     * @see <a href="http://schema.org/members">members</a>
     */
    public static final IRI members;

    /**
     * membershipNumber
     * <p>
     * {@code http://schema.org/membershipNumber}
     * <p>
     * A unique identifier for the membership.
     *
     * @see <a href="http://schema.org/membershipNumber">membershipNumber</a>
     */
    public static final IRI membershipNumber;

    /**
     * memoryRequirements
     * <p>
     * {@code http://schema.org/memoryRequirements}
     * <p>
     * Minimum memory requirements.
     *
     * @see <a href="http://schema.org/memoryRequirements">memoryRequirements</a>
     */
    public static final IRI memoryRequirements;

    /**
     * MensClothingStore
     * <p>
     * {@code http://schema.org/MensClothingStore}
     * <p>
     * A men&#39;s clothing store.
     *
     * @see <a href="http://schema.org/MensClothingStore">MensClothingStore</a>
     */
    public static final IRI MensClothingStore;

    /**
     * mentions
     * <p>
     * {@code http://schema.org/mentions}
     * <p>
     * Indicates that the CreativeWork contains a reference to, but is not
     * necessarily about a concept.
     *
     * @see <a href="http://schema.org/mentions">mentions</a>
     */
    public static final IRI mentions;

    /**
     * menu
     * <p>
     * {@code http://schema.org/menu}
     * <p>
     * Either the actual menu as a structured representation, as text, or a
     * URL of the menu.
     *
     * @see <a href="http://schema.org/menu">menu</a>
     */
    public static final IRI menu;

    /**
     * Menu
     * <p>
     * {@code http://schema.org/Menu}
     * <p>
     * A structured representation of food or drink items available from a
     * FoodEstablishment.
     *
     * @see <a href="http://schema.org/Menu">Menu</a>
     */
    public static final IRI Menu;

    /**
     * menuAddOn
     * <p>
     * {@code http://schema.org/menuAddOn}
     * <p>
     * Additional menu item(s) such as a side dish of salad or side order of
     * fries that can be added to this menu item. Additionally it can be a
     * menu section containing allowed add-on menu items for this menu item.
     *
     * @see <a href="http://schema.org/menuAddOn">menuAddOn</a>
     */
    public static final IRI menuAddOn;

    /**
     * MenuItem
     * <p>
     * {@code http://schema.org/MenuItem}
     * <p>
     * A food or drink item listed in a menu or menu section.
     *
     * @see <a href="http://schema.org/MenuItem">MenuItem</a>
     */
    public static final IRI MenuItem;

    /**
     * MenuSection
     * <p>
     * {@code http://schema.org/MenuSection}
     * <p>
     * A sub-grouping of food or drink items in a menu. E.g. courses (such as
     * &#39;Dinner&#39;, &#39;Breakfast&#39;, etc.), specific type of dishes
     * (such as &#39;Meat&#39;, &#39;Vegan&#39;, &#39;Drinks&#39;, etc.), or
     * some other classification made by the menu provider.
     *
     * @see <a href="http://schema.org/MenuSection">MenuSection</a>
     */
    public static final IRI MenuSection;

    /**
     * merchant
     * <p>
     * {@code http://schema.org/merchant}
     * <p>
     * &#39;merchant&#39; is an out-dated term for &#39;seller&#39;.
     *
     * @see <a href="http://schema.org/merchant">merchant</a>
     */
    public static final IRI merchant;

    /**
     * Message
     * <p>
     * {@code http://schema.org/Message}
     * <p>
     * A single message from a sender to one or more organizations or people.
     *
     * @see <a href="http://schema.org/Message">Message</a>
     */
    public static final IRI Message;

    /**
     * messageAttachment
     * <p>
     * {@code http://schema.org/messageAttachment}
     * <p>
     * A CreativeWork attached to the message.
     *
     * @see <a href="http://schema.org/messageAttachment">messageAttachment</a>
     */
    public static final IRI messageAttachment;

    /**
     * MiddleSchool
     * <p>
     * {@code http://schema.org/MiddleSchool}
     * <p>
     * A middle school (typically for children aged around 11-14, although
     * this varies somewhat).
     *
     * @see <a href="http://schema.org/MiddleSchool">MiddleSchool</a>
     */
    public static final IRI MiddleSchool;

    /**
     * mileageFromOdometer
     * <p>
     * {@code http://schema.org/mileageFromOdometer}
     * <p>
     * The total distance travelled by the particular vehicle since its
     * initial production, as read from its
     * odometer.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s): KMT for
     * kilometers, SMI for statute miles
     *
     * @see <a href="http://schema.org/mileageFromOdometer">mileageFromOdometer</a>
     */
    public static final IRI mileageFromOdometer;

    /**
     * minimumPaymentDue
     * <p>
     * {@code http://schema.org/minimumPaymentDue}
     * <p>
     * The minimum payment required at this time.
     *
     * @see <a href="http://schema.org/minimumPaymentDue">minimumPaymentDue</a>
     */
    public static final IRI minimumPaymentDue;

    /**
     * minPrice
     * <p>
     * {@code http://schema.org/minPrice}
     * <p>
     * The lowest price if the price is a range.
     *
     * @see <a href="http://schema.org/minPrice">minPrice</a>
     */
    public static final IRI minPrice;

    /**
     * minValue
     * <p>
     * {@code http://schema.org/minValue}
     * <p>
     * The lower value of some characteristic or property.
     *
     * @see <a href="http://schema.org/minValue">minValue</a>
     */
    public static final IRI minValue;

    /**
     * missionCoveragePrioritiesPolicy
     * <p>
     * {@code http://schema.org/missionCoveragePrioritiesPolicy}
     * <p>
     * For a &lt;a
     * href=&quot;http://schema.org/NewsMediaOrganization&quot;&gt;NewsMediaOrganization&lt;/a&gt;,
     * a statement on coverage priorities, including any public agenda or
     * stance on issues.
     *
     * @see <a href="http://schema.org/missionCoveragePrioritiesPolicy">missionCoveragePrioritiesPolicy</a>
     */
    public static final IRI missionCoveragePrioritiesPolicy;

    /**
     * MobileApplication
     * <p>
     * {@code http://schema.org/MobileApplication}
     * <p>
     * A software application designed specifically to work well on a mobile
     * device such as a telephone.
     *
     * @see <a href="http://schema.org/MobileApplication">MobileApplication</a>
     */
    public static final IRI MobileApplication;

    /**
     * MobilePhoneStore
     * <p>
     * {@code http://schema.org/MobilePhoneStore}
     * <p>
     * A store that sells mobile phones and related accessories.
     *
     * @see <a href="http://schema.org/MobilePhoneStore">MobilePhoneStore</a>
     */
    public static final IRI MobilePhoneStore;

    /**
     * model
     * <p>
     * {@code http://schema.org/model}
     * <p>
     * The model of the product. Use with the URL of a ProductModel or a
     * textual representation of the model identifier. The URL of the
     * ProductModel can be from an external source. It is recommended to
     * additionally provide strong product identifiers via the
     * gtin8/gtin13/gtin14 and mpn properties.
     *
     * @see <a href="http://schema.org/model">model</a>
     */
    public static final IRI model;

    /**
     * modelDate
     * <p>
     * {@code http://schema.org/modelDate}
     * <p>
     * The release date of a vehicle model (often used to differentiate
     * versions of the same make and model).
     *
     * @see <a href="http://schema.org/modelDate">modelDate</a>
     */
    public static final IRI modelDate;

    /**
     * modifiedTime
     * <p>
     * {@code http://schema.org/modifiedTime}
     * <p>
     * The date and time the reservation was modified.
     *
     * @see <a href="http://schema.org/modifiedTime">modifiedTime</a>
     */
    public static final IRI modifiedTime;

    /**
     * MonetaryAmount
     * <p>
     * {@code http://schema.org/MonetaryAmount}
     * <p>
     * A monetary value or range. This type can be used to describe an amount
     * of money such as $50 USD, or a range as in describing a bank account
     * being suitable for a balance between £1,000 and £1,000,000 GBP, or the
     * value of a salary, etc. It is recommended to use &lt;a
     * href=&quot;http://schema.org/PriceSpecification&quot;&gt;PriceSpecification&lt;/a&gt;
     * Types to describe the price of an Offer, Invoice, etc.
     *
     * @see <a href="http://schema.org/MonetaryAmount">MonetaryAmount</a>
     */
    public static final IRI MonetaryAmount;

    /**
     * MonetaryAmountDistribution
     * <p>
     * {@code http://schema.org/MonetaryAmountDistribution}
     * <p>
     * A statistical distribution of monetary amounts.
     *
     * @see <a href="http://schema.org/MonetaryAmountDistribution">MonetaryAmountDistribution</a>
     */
    public static final IRI MonetaryAmountDistribution;

    /**
     * MoneyTransfer
     * <p>
     * {@code http://schema.org/MoneyTransfer}
     * <p>
     * The act of transferring money from one place to another place. This
     * may occur electronically or physically.
     *
     * @see <a href="http://schema.org/MoneyTransfer">MoneyTransfer</a>
     */
    public static final IRI MoneyTransfer;

    /**
     * monthlyMinimumRepaymentAmount
     * <p>
     * {@code http://schema.org/monthlyMinimumRepaymentAmount}
     * <p>
     * The minimum payment is the lowest amount of money that one is required
     * to pay on a credit card statement each month.
     *
     * @see <a href="http://schema.org/monthlyMinimumRepaymentAmount">monthlyMinimumRepaymentAmount</a>
     */
    public static final IRI monthlyMinimumRepaymentAmount;

    /**
     * MortgageLoan
     * <p>
     * {@code http://schema.org/MortgageLoan}
     * <p>
     * A loan in which property or real estate is used as collateral. (A loan
     * securitized against some real estate.)
     *
     * @see <a href="http://schema.org/MortgageLoan">MortgageLoan</a>
     */
    public static final IRI MortgageLoan;

    /**
     * Mosque
     * <p>
     * {@code http://schema.org/Mosque}
     * <p>
     * A mosque.
     *
     * @see <a href="http://schema.org/Mosque">Mosque</a>
     */
    public static final IRI Mosque;

    /**
     * Motel
     * <p>
     * {@code http://schema.org/Motel}
     * <p>
     * A motel.
     * &lt;br /&gt;&lt;br /&gt;
     * See also the &lt;a
     * href=&quot;/docs/hotels.html&quot;&gt;dedicated document on the use of
     * schema.org for marking up hotels and other forms of
     * accommodations&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Motel">Motel</a>
     */
    public static final IRI Motel;

    /**
     * Motorcycle
     * <p>
     * {@code http://schema.org/Motorcycle}
     * <p>
     * A motorcycle or motorbike is a single-track, two-wheeled motor
     * vehicle.
     *
     * @see <a href="http://schema.org/Motorcycle">Motorcycle</a>
     */
    public static final IRI Motorcycle;

    /**
     * MotorcycleDealer
     * <p>
     * {@code http://schema.org/MotorcycleDealer}
     * <p>
     * A motorcycle dealer.
     *
     * @see <a href="http://schema.org/MotorcycleDealer">MotorcycleDealer</a>
     */
    public static final IRI MotorcycleDealer;

    /**
     * MotorcycleRepair
     * <p>
     * {@code http://schema.org/MotorcycleRepair}
     * <p>
     * A motorcycle repair shop.
     *
     * @see <a href="http://schema.org/MotorcycleRepair">MotorcycleRepair</a>
     */
    public static final IRI MotorcycleRepair;

    /**
     * MotorizedBicycle
     * <p>
     * {@code http://schema.org/MotorizedBicycle}
     * <p>
     * A motorized bicycle is a bicycle with an attached motor used to power
     * the vehicle, or to assist with pedaling.
     *
     * @see <a href="http://schema.org/MotorizedBicycle">MotorizedBicycle</a>
     */
    public static final IRI MotorizedBicycle;

    /**
     * Mountain
     * <p>
     * {@code http://schema.org/Mountain}
     * <p>
     * A mountain, like Mount Whitney or Mount Everest.
     *
     * @see <a href="http://schema.org/Mountain">Mountain</a>
     */
    public static final IRI Mountain;

    /**
     * MoveAction
     * <p>
     * {@code http://schema.org/MoveAction}
     * <p>
     * The act of an agent relocating to a
     * place.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/TransferAction&quot;&gt;TransferAction&lt;/a&gt;:
     * Unlike TransferAction, the subject of the move is a living Person or
     * Organization rather than an inanimate object.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/MoveAction">MoveAction</a>
     */
    public static final IRI MoveAction;

    /**
     * Movie
     * <p>
     * {@code http://schema.org/Movie}
     * <p>
     * A movie.
     *
     * @see <a href="http://schema.org/Movie">Movie</a>
     */
    public static final IRI Movie;

    /**
     * MovieClip
     * <p>
     * {@code http://schema.org/MovieClip}
     * <p>
     * A short segment/part of a movie.
     *
     * @see <a href="http://schema.org/MovieClip">MovieClip</a>
     */
    public static final IRI MovieClip;

    /**
     * MovieRentalStore
     * <p>
     * {@code http://schema.org/MovieRentalStore}
     * <p>
     * A movie rental store.
     *
     * @see <a href="http://schema.org/MovieRentalStore">MovieRentalStore</a>
     */
    public static final IRI MovieRentalStore;

    /**
     * MovieSeries
     * <p>
     * {@code http://schema.org/MovieSeries}
     * <p>
     * A series of movies. Included movies can be indicated with the hasPart
     * property.
     *
     * @see <a href="http://schema.org/MovieSeries">MovieSeries</a>
     */
    public static final IRI MovieSeries;

    /**
     * MovieTheater
     * <p>
     * {@code http://schema.org/MovieTheater}
     * <p>
     * A movie theater.
     *
     * @see <a href="http://schema.org/MovieTheater">MovieTheater</a>
     */
    public static final IRI MovieTheater;

    /**
     * MovingCompany
     * <p>
     * {@code http://schema.org/MovingCompany}
     * <p>
     * A moving company.
     *
     * @see <a href="http://schema.org/MovingCompany">MovingCompany</a>
     */
    public static final IRI MovingCompany;

    /**
     * mpn
     * <p>
     * {@code http://schema.org/mpn}
     * <p>
     * The Manufacturer Part Number (MPN) of the product, or the product to
     * which the offer refers.
     *
     * @see <a href="http://schema.org/mpn">mpn</a>
     */
    public static final IRI mpn;

    /**
     * multipleValues
     * <p>
     * {@code http://schema.org/multipleValues}
     * <p>
     * Whether multiple values are allowed for the property.  Default is
     * false.
     *
     * @see <a href="http://schema.org/multipleValues">multipleValues</a>
     */
    public static final IRI multipleValues;

    /**
     * Muscle
     * <p>
     * {@code http://schema.org/Muscle}
     * <p>
     * A muscle is an anatomical structure consisting of a contractile form
     * of tissue that animals use to effect movement.
     *
     * @see <a href="http://schema.org/Muscle">Muscle</a>
     */
    public static final IRI Muscle;

    /**
     * muscleAction
     * <p>
     * {@code http://schema.org/muscleAction}
     * <p>
     * The movement the muscle generates.
     *
     * @see <a href="http://schema.org/muscleAction">muscleAction</a>
     */
    public static final IRI muscleAction;

    /**
     * Museum
     * <p>
     * {@code http://schema.org/Museum}
     * <p>
     * A museum.
     *
     * @see <a href="http://schema.org/Museum">Museum</a>
     */
    public static final IRI Museum;

    /**
     * MusicAlbum
     * <p>
     * {@code http://schema.org/MusicAlbum}
     * <p>
     * A collection of music tracks.
     *
     * @see <a href="http://schema.org/MusicAlbum">MusicAlbum</a>
     */
    public static final IRI MusicAlbum;

    /**
     * MusicAlbumProductionType
     * <p>
     * {@code http://schema.org/MusicAlbumProductionType}
     * <p>
     * Classification of the album by it&#39;s type of content: soundtrack,
     * live album, studio album, etc.
     *
     * @see <a href="http://schema.org/MusicAlbumProductionType">MusicAlbumProductionType</a>
     */
    public static final IRI MusicAlbumProductionType;

    /**
     * MusicAlbumReleaseType
     * <p>
     * {@code http://schema.org/MusicAlbumReleaseType}
     * <p>
     * The kind of release which this album is: single, EP or album.
     *
     * @see <a href="http://schema.org/MusicAlbumReleaseType">MusicAlbumReleaseType</a>
     */
    public static final IRI MusicAlbumReleaseType;

    /**
     * musicalKey
     * <p>
     * {@code http://schema.org/musicalKey}
     * <p>
     * The key, mode, or scale this composition uses.
     *
     * @see <a href="http://schema.org/musicalKey">musicalKey</a>
     */
    public static final IRI musicalKey;

    /**
     * musicArrangement
     * <p>
     * {@code http://schema.org/musicArrangement}
     * <p>
     * An arrangement derived from the composition.
     *
     * @see <a href="http://schema.org/musicArrangement">musicArrangement</a>
     */
    public static final IRI musicArrangement;

    /**
     * musicBy
     * <p>
     * {@code http://schema.org/musicBy}
     * <p>
     * The composer of the soundtrack.
     *
     * @see <a href="http://schema.org/musicBy">musicBy</a>
     */
    public static final IRI musicBy;

    /**
     * MusicComposition
     * <p>
     * {@code http://schema.org/MusicComposition}
     * <p>
     * A musical composition.
     *
     * @see <a href="http://schema.org/MusicComposition">MusicComposition</a>
     */
    public static final IRI MusicComposition;

    /**
     * musicCompositionForm
     * <p>
     * {@code http://schema.org/musicCompositionForm}
     * <p>
     * The type of composition (e.g. overture, sonata, symphony, etc.).
     *
     * @see <a href="http://schema.org/musicCompositionForm">musicCompositionForm</a>
     */
    public static final IRI musicCompositionForm;

    /**
     * MusicEvent
     * <p>
     * {@code http://schema.org/MusicEvent}
     * <p>
     * Event type: Music event.
     *
     * @see <a href="http://schema.org/MusicEvent">MusicEvent</a>
     */
    public static final IRI MusicEvent;

    /**
     * MusicGroup
     * <p>
     * {@code http://schema.org/MusicGroup}
     * <p>
     * A musical group, such as a band, an orchestra, or a choir. Can also be
     * a solo musician.
     *
     * @see <a href="http://schema.org/MusicGroup">MusicGroup</a>
     */
    public static final IRI MusicGroup;

    /**
     * musicGroupMember
     * <p>
     * {@code http://schema.org/musicGroupMember}
     * <p>
     * A member of a music group&amp;#x2014;for example, John, Paul, George,
     * or Ringo.
     *
     * @see <a href="http://schema.org/musicGroupMember">musicGroupMember</a>
     */
    public static final IRI musicGroupMember;

    /**
     * MusicPlaylist
     * <p>
     * {@code http://schema.org/MusicPlaylist}
     * <p>
     * A collection of music tracks in playlist form.
     *
     * @see <a href="http://schema.org/MusicPlaylist">MusicPlaylist</a>
     */
    public static final IRI MusicPlaylist;

    /**
     * MusicRecording
     * <p>
     * {@code http://schema.org/MusicRecording}
     * <p>
     * A music recording (track), usually a single song.
     *
     * @see <a href="http://schema.org/MusicRecording">MusicRecording</a>
     */
    public static final IRI MusicRecording;

    /**
     * MusicRelease
     * <p>
     * {@code http://schema.org/MusicRelease}
     * <p>
     * A MusicRelease is a specific release of a music album.
     *
     * @see <a href="http://schema.org/MusicRelease">MusicRelease</a>
     */
    public static final IRI MusicRelease;

    /**
     * musicReleaseFormat
     * <p>
     * {@code http://schema.org/musicReleaseFormat}
     * <p>
     * Format of this release (the type of recording media used, ie. compact
     * disc, digital media, LP, etc.).
     *
     * @see <a href="http://schema.org/musicReleaseFormat">musicReleaseFormat</a>
     */
    public static final IRI musicReleaseFormat;

    /**
     * MusicReleaseFormatType
     * <p>
     * {@code http://schema.org/MusicReleaseFormatType}
     * <p>
     * Format of this release (the type of recording media used, ie. compact
     * disc, digital media, LP, etc.).
     *
     * @see <a href="http://schema.org/MusicReleaseFormatType">MusicReleaseFormatType</a>
     */
    public static final IRI MusicReleaseFormatType;

    /**
     * MusicStore
     * <p>
     * {@code http://schema.org/MusicStore}
     * <p>
     * A music store.
     *
     * @see <a href="http://schema.org/MusicStore">MusicStore</a>
     */
    public static final IRI MusicStore;

    /**
     * MusicVenue
     * <p>
     * {@code http://schema.org/MusicVenue}
     * <p>
     * A music venue.
     *
     * @see <a href="http://schema.org/MusicVenue">MusicVenue</a>
     */
    public static final IRI MusicVenue;

    /**
     * MusicVideoObject
     * <p>
     * {@code http://schema.org/MusicVideoObject}
     * <p>
     * A music video file.
     *
     * @see <a href="http://schema.org/MusicVideoObject">MusicVideoObject</a>
     */
    public static final IRI MusicVideoObject;

    /**
     * naics
     * <p>
     * {@code http://schema.org/naics}
     * <p>
     * The North American Industry Classification System (NAICS) code for a
     * particular organization or business person.
     *
     * @see <a href="http://schema.org/naics">naics</a>
     */
    public static final IRI naics;

    /**
     * NailSalon
     * <p>
     * {@code http://schema.org/NailSalon}
     * <p>
     * A nail salon.
     *
     * @see <a href="http://schema.org/NailSalon">NailSalon</a>
     */
    public static final IRI NailSalon;

    /**
     * name
     * <p>
     * {@code http://schema.org/name}
     * <p>
     * The name of the item.
     *
     * @see <a href="http://schema.org/name">name</a>
     */
    public static final IRI name;

    /**
     * namedPosition
     * <p>
     * {@code http://schema.org/namedPosition}
     * <p>
     * A position played, performed or filled by a person or organization, as
     * part of an organization. For example, an athlete in a SportsTeam might
     * play in the position named &#39;Quarterback&#39;.
     *
     * @see <a href="http://schema.org/namedPosition">namedPosition</a>
     */
    public static final IRI namedPosition;

    /**
     * nationality
     * <p>
     * {@code http://schema.org/nationality}
     * <p>
     * Nationality of the person.
     *
     * @see <a href="http://schema.org/nationality">nationality</a>
     */
    public static final IRI nationality;

    /**
     * naturalProgression
     * <p>
     * {@code http://schema.org/naturalProgression}
     * <p>
     * The expected progression of the condition if it is not treated and
     * allowed to progress naturally.
     *
     * @see <a href="http://schema.org/naturalProgression">naturalProgression</a>
     */
    public static final IRI naturalProgression;

    /**
     * Nerve
     * <p>
     * {@code http://schema.org/Nerve}
     * <p>
     * A common pathway for the electrochemical nerve impulses that are
     * transmitted along each of the axons.
     *
     * @see <a href="http://schema.org/Nerve">Nerve</a>
     */
    public static final IRI Nerve;

    /**
     * nerve
     * <p>
     * {@code http://schema.org/nerve}
     * <p>
     * The underlying innervation associated with the muscle.
     *
     * @see <a href="http://schema.org/nerve">nerve</a>
     */
    public static final IRI nerve;

    /**
     * nerveMotor
     * <p>
     * {@code http://schema.org/nerveMotor}
     * <p>
     * The neurological pathway extension that involves muscle control.
     *
     * @see <a href="http://schema.org/nerveMotor">nerveMotor</a>
     */
    public static final IRI nerveMotor;

    /**
     * netWorth
     * <p>
     * {@code http://schema.org/netWorth}
     * <p>
     * The total financial value of the person as calculated by subtracting
     * assets from liabilities.
     *
     * @see <a href="http://schema.org/netWorth">netWorth</a>
     */
    public static final IRI netWorth;

    /**
     * NewsArticle
     * <p>
     * {@code http://schema.org/NewsArticle}
     * <p>
     * A NewsArticle is an article whose content reports news, or provides
     * background context and supporting materials for understanding the
     * news.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * A more detailed overview of &lt;a
     * href=&quot;/docs/news.html&quot;&gt;schema.org News markup&lt;/a&gt;
     * is also available.
     *
     * @see <a href="http://schema.org/NewsArticle">NewsArticle</a>
     */
    public static final IRI NewsArticle;

    /**
     * NewsMediaOrganization
     * <p>
     * {@code http://schema.org/NewsMediaOrganization}
     * <p>
     * A News/Media organization such as a newspaper or TV station.
     *
     * @see <a href="http://schema.org/NewsMediaOrganization">NewsMediaOrganization</a>
     */
    public static final IRI NewsMediaOrganization;

    /**
     * Newspaper
     * <p>
     * {@code http://schema.org/Newspaper}
     * <p>
     * A publication containing information about varied topics that are
     * pertinent to general information, a geographic area, or a specific
     * subject matter (i.e. business, culture, education). Often published
     * daily.
     *
     * @see <a href="http://schema.org/Newspaper">Newspaper</a>
     */
    public static final IRI Newspaper;

    /**
     * nextItem
     * <p>
     * {@code http://schema.org/nextItem}
     * <p>
     * A link to the ListItem that follows the current one.
     *
     * @see <a href="http://schema.org/nextItem">nextItem</a>
     */
    public static final IRI nextItem;

    /**
     * NGO
     * <p>
     * {@code http://schema.org/NGO}
     * <p>
     * Organization: Non-governmental Organization.
     *
     * @see <a href="http://schema.org/NGO">NGO</a>
     */
    public static final IRI NGO;

    /**
     * NightClub
     * <p>
     * {@code http://schema.org/NightClub}
     * <p>
     * A nightclub or discotheque.
     *
     * @see <a href="http://schema.org/NightClub">NightClub</a>
     */
    public static final IRI NightClub;

    /**
     * noBylinesPolicy
     * <p>
     * {@code http://schema.org/noBylinesPolicy}
     * <p>
     * For a &lt;a
     * href=&quot;http://schema.org/NewsMediaOrganization&quot;&gt;NewsMediaOrganization&lt;/a&gt;
     * or other news-related &lt;a
     * href=&quot;http://schema.org/Organization&quot;&gt;Organization&lt;/a&gt;,
     * a statement explaining when authors of articles are not named in
     * bylines.
     *
     * @see <a href="http://schema.org/noBylinesPolicy">noBylinesPolicy</a>
     */
    public static final IRI noBylinesPolicy;

    /**
     * nonEqual
     * <p>
     * {@code http://schema.org/nonEqual}
     * <p>
     * This ordering relation for qualitative values indicates that the
     * subject is not equal to the object.
     *
     * @see <a href="http://schema.org/nonEqual">nonEqual</a>
     */
    public static final IRI nonEqual;

    /**
     * nonProprietaryName
     * <p>
     * {@code http://schema.org/nonProprietaryName}
     * <p>
     * The generic name of this drug or supplement.
     *
     * @see <a href="http://schema.org/nonProprietaryName">nonProprietaryName</a>
     */
    public static final IRI nonProprietaryName;

    /**
     * normalRange
     * <p>
     * {@code http://schema.org/normalRange}
     * <p>
     * Range of acceptable values for a typical patient, when applicable.
     *
     * @see <a href="http://schema.org/normalRange">normalRange</a>
     */
    public static final IRI normalRange;

    /**
     * Notary
     * <p>
     * {@code http://schema.org/Notary}
     * <p>
     * A notary.
     *
     * @see <a href="http://schema.org/Notary">Notary</a>
     */
    public static final IRI Notary;

    /**
     * NoteDigitalDocument
     * <p>
     * {@code http://schema.org/NoteDigitalDocument}
     * <p>
     * A file containing a note, primarily for the author.
     *
     * @see <a href="http://schema.org/NoteDigitalDocument">NoteDigitalDocument</a>
     */
    public static final IRI NoteDigitalDocument;

    /**
     * numAdults
     * <p>
     * {@code http://schema.org/numAdults}
     * <p>
     * The number of adults staying in the unit.
     *
     * @see <a href="http://schema.org/numAdults">numAdults</a>
     */
    public static final IRI numAdults;

    /**
     * Number
     * <p>
     * {@code http://schema.org/Number}
     * <p>
     * Data type: Number.
     *
     * @see <a href="http://schema.org/Number">Number</a>
     */
    public static final IRI Number;

    /**
     * numberedPosition
     * <p>
     * {@code http://schema.org/numberedPosition}
     * <p>
     * A number associated with a role in an organization, for example, the
     * number on an athlete&#39;s jersey.
     *
     * @see <a href="http://schema.org/numberedPosition">numberedPosition</a>
     */
    public static final IRI numberedPosition;

    /**
     * numberOfAirbags
     * <p>
     * {@code http://schema.org/numberOfAirbags}
     * <p>
     * The number or type of airbags in the vehicle.
     *
     * @see <a href="http://schema.org/numberOfAirbags">numberOfAirbags</a>
     */
    public static final IRI numberOfAirbags;

    /**
     * numberOfAxles
     * <p>
     * {@code http://schema.org/numberOfAxles}
     * <p>
     * The number of axles.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s): C62
     *
     * @see <a href="http://schema.org/numberOfAxles">numberOfAxles</a>
     */
    public static final IRI numberOfAxles;

    /**
     * numberOfBeds
     * <p>
     * {@code http://schema.org/numberOfBeds}
     * <p>
     * The quantity of the given bed type available in the HotelRoom, Suite,
     * House, or Apartment.
     *
     * @see <a href="http://schema.org/numberOfBeds">numberOfBeds</a>
     */
    public static final IRI numberOfBeds;

    /**
     * numberOfDoors
     * <p>
     * {@code http://schema.org/numberOfDoors}
     * <p>
     * The number of doors.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s): C62
     *
     * @see <a href="http://schema.org/numberOfDoors">numberOfDoors</a>
     */
    public static final IRI numberOfDoors;

    /**
     * numberOfEmployees
     * <p>
     * {@code http://schema.org/numberOfEmployees}
     * <p>
     * The number of employees in an organization e.g. business.
     *
     * @see <a href="http://schema.org/numberOfEmployees">numberOfEmployees</a>
     */
    public static final IRI numberOfEmployees;

    /**
     * numberOfEpisodes
     * <p>
     * {@code http://schema.org/numberOfEpisodes}
     * <p>
     * The number of episodes in this season or series.
     *
     * @see <a href="http://schema.org/numberOfEpisodes">numberOfEpisodes</a>
     */
    public static final IRI numberOfEpisodes;

    /**
     * numberOfForwardGears
     * <p>
     * {@code http://schema.org/numberOfForwardGears}
     * <p>
     * The total number of forward gears available for the transmission
     * system of the vehicle.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s):
     * C62
     *
     * @see <a href="http://schema.org/numberOfForwardGears">numberOfForwardGears</a>
     */
    public static final IRI numberOfForwardGears;

    /**
     * numberOfItems
     * <p>
     * {@code http://schema.org/numberOfItems}
     * <p>
     * The number of items in an ItemList. Note that some descriptions might
     * not fully describe all items in a list (e.g., multi-page pagination);
     * in such cases, the numberOfItems would be for the entire list.
     *
     * @see <a href="http://schema.org/numberOfItems">numberOfItems</a>
     */
    public static final IRI numberOfItems;

    /**
     * numberOfLoanPayments
     * <p>
     * {@code http://schema.org/numberOfLoanPayments}
     * <p>
     * The number of payments contractually required at origination to repay
     * the loan. For monthly paying loans this is the number of months from
     * the contractual first payment date to the maturity date.
     *
     * @see <a href="http://schema.org/numberOfLoanPayments">numberOfLoanPayments</a>
     */
    public static final IRI numberOfLoanPayments;

    /**
     * numberOfPages
     * <p>
     * {@code http://schema.org/numberOfPages}
     * <p>
     * The number of pages in the book.
     *
     * @see <a href="http://schema.org/numberOfPages">numberOfPages</a>
     */
    public static final IRI numberOfPages;

    /**
     * numberOfPlayers
     * <p>
     * {@code http://schema.org/numberOfPlayers}
     * <p>
     * Indicate how many people can play this game (minimum, maximum, or
     * range).
     *
     * @see <a href="http://schema.org/numberOfPlayers">numberOfPlayers</a>
     */
    public static final IRI numberOfPlayers;

    /**
     * numberOfPreviousOwners
     * <p>
     * {@code http://schema.org/numberOfPreviousOwners}
     * <p>
     * The number of owners of the vehicle, including the current
     * one.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s): C62
     *
     * @see <a href="http://schema.org/numberOfPreviousOwners">numberOfPreviousOwners</a>
     */
    public static final IRI numberOfPreviousOwners;

    /**
     * numberOfRooms
     * <p>
     * {@code http://schema.org/numberOfRooms}
     * <p>
     * The number of rooms (excluding bathrooms and closets) of the
     * accommodation or lodging business.
     * Typical unit code(s): ROM for room
     * or C62 for no unit. The type of room can be put in the unitText
     * property of the QuantitativeValue.
     *
     * @see <a href="http://schema.org/numberOfRooms">numberOfRooms</a>
     */
    public static final IRI numberOfRooms;

    /**
     * numberOfSeasons
     * <p>
     * {@code http://schema.org/numberOfSeasons}
     * <p>
     * The number of seasons in this series.
     *
     * @see <a href="http://schema.org/numberOfSeasons">numberOfSeasons</a>
     */
    public static final IRI numberOfSeasons;

    /**
     * numChildren
     * <p>
     * {@code http://schema.org/numChildren}
     * <p>
     * The number of children staying in the unit.
     *
     * @see <a href="http://schema.org/numChildren">numChildren</a>
     */
    public static final IRI numChildren;

    /**
     * numTracks
     * <p>
     * {@code http://schema.org/numTracks}
     * <p>
     * The number of tracks in this album or playlist.
     *
     * @see <a href="http://schema.org/numTracks">numTracks</a>
     */
    public static final IRI numTracks;

    /**
     * nutrition
     * <p>
     * {@code http://schema.org/nutrition}
     * <p>
     * Nutrition information about the recipe or menu item.
     *
     * @see <a href="http://schema.org/nutrition">nutrition</a>
     */
    public static final IRI nutrition;

    /**
     * NutritionInformation
     * <p>
     * {@code http://schema.org/NutritionInformation}
     * <p>
     * Nutritional information about the recipe.
     *
     * @see <a href="http://schema.org/NutritionInformation">NutritionInformation</a>
     */
    public static final IRI NutritionInformation;

    /**
     * object
     * <p>
     * {@code http://schema.org/object}
     * <p>
     * The object upon which the action is carried out, whose state is kept
     * intact or changed. Also known as the semantic roles patient, affected
     * or undergoer (which change their state) or theme (which doesn&#39;t).
     * e.g. John read &lt;em&gt;a book&lt;/em&gt;.
     *
     * @see <a href="http://schema.org/object">object</a>
     */
    public static final IRI object;

    /**
     * occupancy
     * <p>
     * {@code http://schema.org/occupancy}
     * <p>
     * The allowed total occupancy for the accommodation in persons
     * (including infants etc). For individual accommodations, this is not
     * necessarily the legal maximum but defines the permitted usage as per
     * the contractual agreement (e.g. a double room used by a single
     * person).
     * Typical unit code(s): C62 for person
     *
     * @see <a href="http://schema.org/occupancy">occupancy</a>
     */
    public static final IRI occupancy;

    /**
     * Occupation
     * <p>
     * {@code http://schema.org/Occupation}
     * <p>
     * A profession, may involve prolonged training and/or a formal
     * qualification.
     *
     * @see <a href="http://schema.org/Occupation">Occupation</a>
     */
    public static final IRI Occupation;

    /**
     * occupationalCategory
     * <p>
     * {@code http://schema.org/occupationalCategory}
     * <p>
     * Category or categories describing the job. Use BLS O*NET-SOC taxonomy:
     * http://www.onetcenter.org/taxonomy.html. Ideally includes textual
     * label and formal code, with the property repeated for each applicable
     * value.
     *
     * @see <a href="http://schema.org/occupationalCategory">occupationalCategory</a>
     */
    public static final IRI occupationalCategory;

    /**
     * OccupationalTherapy
     * <p>
     * {@code http://schema.org/OccupationalTherapy}
     * <p>
     * A treatment of people with physical, emotional, or social problems,
     * using purposeful activity to help them overcome or learn to deal with
     * their problems.
     *
     * @see <a href="http://schema.org/OccupationalTherapy">OccupationalTherapy</a>
     */
    public static final IRI OccupationalTherapy;

    /**
     * occupationLocation
     * <p>
     * {@code http://schema.org/occupationLocation}
     * <p>
     * The region/country for which this occupational description is
     * appropriate. Note that educational requirements and qualifications can
     * vary between jurisdictions.
     *
     * @see <a href="http://schema.org/occupationLocation">occupationLocation</a>
     */
    public static final IRI occupationLocation;

    /**
     * OceanBodyOfWater
     * <p>
     * {@code http://schema.org/OceanBodyOfWater}
     * <p>
     * An ocean (for example, the Pacific).
     *
     * @see <a href="http://schema.org/OceanBodyOfWater">OceanBodyOfWater</a>
     */
    public static final IRI OceanBodyOfWater;

    /**
     * Offer
     * <p>
     * {@code http://schema.org/Offer}
     * <p>
     * An offer to transfer some rights to an item or to provide a service —
     * for example, an offer to sell tickets to an event, to rent the DVD of
     * a movie, to stream a TV show over the internet, to repair a
     * motorcycle, or to loan a book.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * For &lt;a
     * href=&quot;http://www.gs1.org/barcodes/technical/idkeys/gtin&quot;&gt;GTIN&lt;/a&gt;-related
     * fields, see &lt;a
     * href=&quot;http://www.gs1.org/barcodes/support/check_digit_calculator&quot;&gt;Check
     * Digit calculator&lt;/a&gt; and &lt;a
     * href=&quot;http://www.gs1us.org/resources/standards/gtin-validation-guide&quot;&gt;validation
     * guide&lt;/a&gt; from &lt;a
     * href=&quot;http://www.gs1.org/&quot;&gt;GS1&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Offer">Offer</a>
     */
    public static final IRI Offer;

    /**
     * OfferCatalog
     * <p>
     * {@code http://schema.org/OfferCatalog}
     * <p>
     * An OfferCatalog is an ItemList that contains related Offers and/or
     * further OfferCatalogs that are offeredBy the same provider.
     *
     * @see <a href="http://schema.org/OfferCatalog">OfferCatalog</a>
     */
    public static final IRI OfferCatalog;

    /**
     * offerCount
     * <p>
     * {@code http://schema.org/offerCount}
     * <p>
     * The number of offers for the product.
     *
     * @see <a href="http://schema.org/offerCount">offerCount</a>
     */
    public static final IRI offerCount;

    /**
     * offeredBy
     * <p>
     * {@code http://schema.org/offeredBy}
     * <p>
     * A pointer to the organization or person making the offer.
     *
     * @see <a href="http://schema.org/offeredBy">offeredBy</a>
     */
    public static final IRI offeredBy;

    /**
     * OfferItemCondition
     * <p>
     * {@code http://schema.org/OfferItemCondition}
     * <p>
     * A list of possible conditions for the item.
     *
     * @see <a href="http://schema.org/OfferItemCondition">OfferItemCondition</a>
     */
    public static final IRI OfferItemCondition;

    /**
     * offers
     * <p>
     * {@code http://schema.org/offers}
     * <p>
     * An offer to provide this item&amp;#x2014;for example, an offer to sell
     * a product, rent the DVD of a movie, perform a service, or give away
     * tickets to an event.
     *
     * @see <a href="http://schema.org/offers">offers</a>
     */
    public static final IRI offers;

    /**
     * offersPrescriptionByMail
     * <p>
     * {@code http://schema.org/offersPrescriptionByMail}
     * <p>
     * Whether prescriptions can be delivered by mail.
     *
     * @see <a href="http://schema.org/offersPrescriptionByMail">offersPrescriptionByMail</a>
     */
    public static final IRI offersPrescriptionByMail;

    /**
     * OfficeEquipmentStore
     * <p>
     * {@code http://schema.org/OfficeEquipmentStore}
     * <p>
     * An office equipment store.
     *
     * @see <a href="http://schema.org/OfficeEquipmentStore">OfficeEquipmentStore</a>
     */
    public static final IRI OfficeEquipmentStore;

    /**
     * OnDemandEvent
     * <p>
     * {@code http://schema.org/OnDemandEvent}
     * <p>
     * A publication event e.g. catch-up TV or radio podcast, during which a
     * program is available on-demand.
     *
     * @see <a href="http://schema.org/OnDemandEvent">OnDemandEvent</a>
     */
    public static final IRI OnDemandEvent;

    /**
     * openingHours
     * <p>
     * {@code http://schema.org/openingHours}
     * <p>
     * The general opening hours for a business. Opening hours can be
     * specified as a weekly time range, starting with days, then times per
     * day. Multiple days can be listed with commas &#39;,&#39; separating
     * each day. Day or time ranges are specified using a hyphen
     * &#39;-&#39;.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;Days are
     * specified using the following two-letter combinations:
     * &lt;code&gt;Mo&lt;/code&gt;, &lt;code&gt;Tu&lt;/code&gt;,
     * &lt;code&gt;We&lt;/code&gt;, &lt;code&gt;Th&lt;/code&gt;,
     * &lt;code&gt;Fr&lt;/code&gt;, &lt;code&gt;Sa&lt;/code&gt;,
     * &lt;code&gt;Su&lt;/code&gt;.&lt;/li&gt;
     * &lt;li&gt;Times are specified
     * using 24:00 time. For example, 3pm is specified as
     * &lt;code&gt;15:00&lt;/code&gt;. &lt;/li&gt;
     * &lt;li&gt;Here is an
     * example: &lt;code&gt;&amp;lt;time itemprop=&quot;openingHours&quot;
     * datetime=&amp;quot;Tu,Th 16:00-20:00&amp;quot;&amp;gt;Tuesdays and
     * Thursdays
     * 4-8pm&amp;lt;/time&amp;gt;&lt;/code&gt;.&lt;/li&gt;
     * &lt;li&gt;If a
     * business is open 7 days a week, then it can be specified as
     * &lt;code&gt;&amp;lt;time itemprop=&amp;quot;openingHours&amp;quot;
     * datetime=&amp;quot;Mo-Su&amp;quot;&amp;gt;Monday through Sunday, all
     * day&amp;lt;/time&amp;gt;&lt;/code&gt;.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/openingHours">openingHours</a>
     */
    public static final IRI openingHours;

    /**
     * OpeningHoursSpecification
     * <p>
     * {@code http://schema.org/OpeningHoursSpecification}
     * <p>
     * A structured value providing information about the opening hours of a
     * place or a certain service inside a place.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * The
     * place is &lt;strong&gt;open&lt;/strong&gt; if the &lt;a
     * href=&quot;http://schema.org/opens&quot;&gt;opens&lt;/a&gt; property
     * is specified, and &lt;strong&gt;closed&lt;/strong&gt;
     * otherwise.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * If the value for the &lt;a
     * href=&quot;http://schema.org/closes&quot;&gt;closes&lt;/a&gt; property
     * is less than the value for the &lt;a
     * href=&quot;http://schema.org/opens&quot;&gt;opens&lt;/a&gt; property
     * then the hour range is assumed to span over the next day.
     *
     * @see <a href="http://schema.org/OpeningHoursSpecification">OpeningHoursSpecification</a>
     */
    public static final IRI OpeningHoursSpecification;

    /**
     * openingHoursSpecification
     * <p>
     * {@code http://schema.org/openingHoursSpecification}
     * <p>
     * The opening hours of a certain place.
     *
     * @see <a href="http://schema.org/openingHoursSpecification">openingHoursSpecification</a>
     */
    public static final IRI openingHoursSpecification;

    /**
     * opens
     * <p>
     * {@code http://schema.org/opens}
     * <p>
     * The opening hour of the place or service on the given day(s) of the
     * week.
     *
     * @see <a href="http://schema.org/opens">opens</a>
     */
    public static final IRI opens;

    /**
     * operatingSystem
     * <p>
     * {@code http://schema.org/operatingSystem}
     * <p>
     * Operating systems supported (Windows 7, OSX 10.6, Android 1.6).
     *
     * @see <a href="http://schema.org/operatingSystem">operatingSystem</a>
     */
    public static final IRI operatingSystem;

    /**
     * OpinionNewsArticle
     * <p>
     * {@code http://schema.org/OpinionNewsArticle}
     * <p>
     * An &lt;a
     * href=&quot;http://schema.org/OpinionNewsArticle&quot;&gt;OpinionNewsArticle&lt;/a&gt;
     * is a &lt;a
     * href=&quot;http://schema.org/NewsArticle&quot;&gt;NewsArticle&lt;/a&gt;
     * that primarily expresses opinions rather than journalistic reporting
     * of news and events. For example, a &lt;a
     * href=&quot;http://schema.org/NewsArticle&quot;&gt;NewsArticle&lt;/a&gt;
     * consisting of a column or &lt;a
     * href=&quot;http://schema.org/Blog&quot;&gt;Blog&lt;/a&gt;/&lt;a
     * href=&quot;http://schema.org/BlogPosting&quot;&gt;BlogPosting&lt;/a&gt;
     * entry in the Opinions section of a news publication.
     *
     * @see <a href="http://schema.org/OpinionNewsArticle">OpinionNewsArticle</a>
     */
    public static final IRI OpinionNewsArticle;

    /**
     * opponent
     * <p>
     * {@code http://schema.org/opponent}
     * <p>
     * A sub property of participant. The opponent on this action.
     *
     * @see <a href="http://schema.org/opponent">opponent</a>
     */
    public static final IRI opponent;

    /**
     * Optician
     * <p>
     * {@code http://schema.org/Optician}
     * <p>
     * A store that sells reading glasses and similar devices for improving
     * vision.
     *
     * @see <a href="http://schema.org/Optician">Optician</a>
     */
    public static final IRI Optician;

    /**
     * option
     * <p>
     * {@code http://schema.org/option}
     * <p>
     * A sub property of object. The options subject to this action.
     *
     * @see <a href="http://schema.org/option">option</a>
     */
    public static final IRI option;

    /**
     * Order
     * <p>
     * {@code http://schema.org/Order}
     * <p>
     * An order is a confirmation of a transaction (a receipt), which can
     * contain multiple line items, each represented by an Offer that has
     * been accepted by the customer.
     *
     * @see <a href="http://schema.org/Order">Order</a>
     */
    public static final IRI Order;

    /**
     * OrderAction
     * <p>
     * {@code http://schema.org/OrderAction}
     * <p>
     * An agent orders an object/product/service to be delivered/sent.
     *
     * @see <a href="http://schema.org/OrderAction">OrderAction</a>
     */
    public static final IRI OrderAction;

    /**
     * orderDate
     * <p>
     * {@code http://schema.org/orderDate}
     * <p>
     * Date order was placed.
     *
     * @see <a href="http://schema.org/orderDate">orderDate</a>
     */
    public static final IRI orderDate;

    /**
     * orderDelivery
     * <p>
     * {@code http://schema.org/orderDelivery}
     * <p>
     * The delivery of the parcel related to this order or order item.
     *
     * @see <a href="http://schema.org/orderDelivery">orderDelivery</a>
     */
    public static final IRI orderDelivery;

    /**
     * orderedItem
     * <p>
     * {@code http://schema.org/orderedItem}
     * <p>
     * The item ordered.
     *
     * @see <a href="http://schema.org/orderedItem">orderedItem</a>
     */
    public static final IRI orderedItem;

    /**
     * OrderItem
     * <p>
     * {@code http://schema.org/OrderItem}
     * <p>
     * An order item is a line of an order. It includes the quantity and
     * shipping details of a bought offer.
     *
     * @see <a href="http://schema.org/OrderItem">OrderItem</a>
     */
    public static final IRI OrderItem;

    /**
     * orderItemNumber
     * <p>
     * {@code http://schema.org/orderItemNumber}
     * <p>
     * The identifier of the order item.
     *
     * @see <a href="http://schema.org/orderItemNumber">orderItemNumber</a>
     */
    public static final IRI orderItemNumber;

    /**
     * orderItemStatus
     * <p>
     * {@code http://schema.org/orderItemStatus}
     * <p>
     * The current status of the order item.
     *
     * @see <a href="http://schema.org/orderItemStatus">orderItemStatus</a>
     */
    public static final IRI orderItemStatus;

    /**
     * orderNumber
     * <p>
     * {@code http://schema.org/orderNumber}
     * <p>
     * The identifier of the transaction.
     *
     * @see <a href="http://schema.org/orderNumber">orderNumber</a>
     */
    public static final IRI orderNumber;

    /**
     * orderQuantity
     * <p>
     * {@code http://schema.org/orderQuantity}
     * <p>
     * The number of the item ordered. If the property is not set, assume the
     * quantity is one.
     *
     * @see <a href="http://schema.org/orderQuantity">orderQuantity</a>
     */
    public static final IRI orderQuantity;

    /**
     * orderStatus
     * <p>
     * {@code http://schema.org/orderStatus}
     * <p>
     * The current status of the order.
     *
     * @see <a href="http://schema.org/orderStatus">orderStatus</a>
     */
    public static final IRI orderStatus;

    /**
     * OrderStatus
     * <p>
     * {@code http://schema.org/OrderStatus}
     * <p>
     * Enumerated status values for Order.
     *
     * @see <a href="http://schema.org/OrderStatus">OrderStatus</a>
     */
    public static final IRI OrderStatus;

    /**
     * Organization
     * <p>
     * {@code http://schema.org/Organization}
     * <p>
     * An organization such as a school, NGO, corporation, club, etc.
     *
     * @see <a href="http://schema.org/Organization">Organization</a>
     */
    public static final IRI Organization;

    /**
     * OrganizationRole
     * <p>
     * {@code http://schema.org/OrganizationRole}
     * <p>
     * A subclass of Role used to describe roles within organizations.
     *
     * @see <a href="http://schema.org/OrganizationRole">OrganizationRole</a>
     */
    public static final IRI OrganizationRole;

    /**
     * OrganizeAction
     * <p>
     * {@code http://schema.org/OrganizeAction}
     * <p>
     * The act of manipulating/administering/supervising/controlling one or
     * more objects.
     *
     * @see <a href="http://schema.org/OrganizeAction">OrganizeAction</a>
     */
    public static final IRI OrganizeAction;

    /**
     * organizer
     * <p>
     * {@code http://schema.org/organizer}
     * <p>
     * An organizer of an Event.
     *
     * @see <a href="http://schema.org/organizer">organizer</a>
     */
    public static final IRI organizer;

    /**
     * origin
     * <p>
     * {@code http://schema.org/origin}
     * <p>
     * The place or point where a muscle arises.
     *
     * @see <a href="http://schema.org/origin">origin</a>
     */
    public static final IRI origin;

    /**
     * originAddress
     * <p>
     * {@code http://schema.org/originAddress}
     * <p>
     * Shipper&#39;s address.
     *
     * @see <a href="http://schema.org/originAddress">originAddress</a>
     */
    public static final IRI originAddress;

    /**
     * originatesFrom
     * <p>
     * {@code http://schema.org/originatesFrom}
     * <p>
     * The vasculature the lymphatic structure originates, or afferents,
     * from.
     *
     * @see <a href="http://schema.org/originatesFrom">originatesFrom</a>
     */
    public static final IRI originatesFrom;

    /**
     * outcome
     * <p>
     * {@code http://schema.org/outcome}
     * <p>
     * Expected or actual outcomes of the study.
     *
     * @see <a href="http://schema.org/outcome">outcome</a>
     */
    public static final IRI outcome;

    /**
     * OutletStore
     * <p>
     * {@code http://schema.org/OutletStore}
     * <p>
     * An outlet store.
     *
     * @see <a href="http://schema.org/OutletStore">OutletStore</a>
     */
    public static final IRI OutletStore;

    /**
     * overdosage
     * <p>
     * {@code http://schema.org/overdosage}
     * <p>
     * Any information related to overdose on a drug, including signs or
     * symptoms, treatments, contact information for emergency response.
     *
     * @see <a href="http://schema.org/overdosage">overdosage</a>
     */
    public static final IRI overdosage;

    /**
     * overview
     * <p>
     * {@code http://schema.org/overview}
     * <p>
     * Descriptive information establishing the overarching theory/philosophy
     * of the plan. May include the rationale for the name, the population
     * where the plan first came to prominence, etc.
     *
     * @see <a href="http://schema.org/overview">overview</a>
     */
    public static final IRI overview;

    /**
     * ownedFrom
     * <p>
     * {@code http://schema.org/ownedFrom}
     * <p>
     * The date and time of obtaining the product.
     *
     * @see <a href="http://schema.org/ownedFrom">ownedFrom</a>
     */
    public static final IRI ownedFrom;

    /**
     * ownedThrough
     * <p>
     * {@code http://schema.org/ownedThrough}
     * <p>
     * The date and time of giving up ownership on the product.
     *
     * @see <a href="http://schema.org/ownedThrough">ownedThrough</a>
     */
    public static final IRI ownedThrough;

    /**
     * ownershipFundingInfo
     * <p>
     * {@code http://schema.org/ownershipFundingInfo}
     * <p>
     * For an &lt;a
     * href=&quot;http://schema.org/Organization&quot;&gt;Organization&lt;/a&gt;
     * (often but not necessarily a &lt;a
     * href=&quot;http://schema.org/NewsMediaOrganization&quot;&gt;NewsMediaOrganization&lt;/a&gt;),
     * a description of organizational ownership structure; funding and
     * grants. In a news/media setting, this is with particular reference to
     * editorial independence.   Note that the &lt;a
     * href=&quot;http://schema.org/funder&quot;&gt;funder&lt;/a&gt; is also
     * available and can be used to make basic funder information
     * machine-readable.
     *
     * @see <a href="http://schema.org/ownershipFundingInfo">ownershipFundingInfo</a>
     */
    public static final IRI ownershipFundingInfo;

    /**
     * OwnershipInfo
     * <p>
     * {@code http://schema.org/OwnershipInfo}
     * <p>
     * A structured value providing information about when a certain
     * organization or person owned a certain product.
     *
     * @see <a href="http://schema.org/OwnershipInfo">OwnershipInfo</a>
     */
    public static final IRI OwnershipInfo;

    /**
     * owns
     * <p>
     * {@code http://schema.org/owns}
     * <p>
     * Products owned by the organization or person.
     *
     * @see <a href="http://schema.org/owns">owns</a>
     */
    public static final IRI owns;

    /**
     * pageEnd
     * <p>
     * {@code http://schema.org/pageEnd}
     * <p>
     * The page on which the work ends; for example &quot;138&quot; or
     * &quot;xvi&quot;.
     *
     * @see <a href="http://schema.org/pageEnd">pageEnd</a>
     */
    public static final IRI pageEnd;

    /**
     * pageStart
     * <p>
     * {@code http://schema.org/pageStart}
     * <p>
     * The page on which the work starts; for example &quot;135&quot; or
     * &quot;xiii&quot;.
     *
     * @see <a href="http://schema.org/pageStart">pageStart</a>
     */
    public static final IRI pageStart;

    /**
     * pagination
     * <p>
     * {@code http://schema.org/pagination}
     * <p>
     * Any description of pages that is not separated into pageStart and
     * pageEnd; for example, &quot;1-6, 9, 55&quot; or &quot;10-12,
     * 46-49&quot;.
     *
     * @see <a href="http://schema.org/pagination">pagination</a>
     */
    public static final IRI pagination;

    /**
     * PaintAction
     * <p>
     * {@code http://schema.org/PaintAction}
     * <p>
     * The act of producing a painting, typically with paint and canvas as
     * instruments.
     *
     * @see <a href="http://schema.org/PaintAction">PaintAction</a>
     */
    public static final IRI PaintAction;

    /**
     * Painting
     * <p>
     * {@code http://schema.org/Painting}
     * <p>
     * A painting.
     *
     * @see <a href="http://schema.org/Painting">Painting</a>
     */
    public static final IRI Painting;

    /**
     * PalliativeProcedure
     * <p>
     * {@code http://schema.org/PalliativeProcedure}
     * <p>
     * A medical procedure intended primarily for palliative purposes, aimed
     * at relieving the symptoms of an underlying health condition.
     *
     * @see <a href="http://schema.org/PalliativeProcedure">PalliativeProcedure</a>
     */
    public static final IRI PalliativeProcedure;

    /**
     * ParcelDelivery
     * <p>
     * {@code http://schema.org/ParcelDelivery}
     * <p>
     * The delivery of a parcel either via the postal service or a commercial
     * service.
     *
     * @see <a href="http://schema.org/ParcelDelivery">ParcelDelivery</a>
     */
    public static final IRI ParcelDelivery;

    /**
     * ParcelService
     * <p>
     * {@code http://schema.org/ParcelService}
     * <p>
     * A private parcel service as the delivery mode available for a certain
     * offer.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Commonly used
     * values:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#DHL&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#FederalExpress&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#UPS&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/ParcelService">ParcelService</a>
     */
    public static final IRI ParcelService;

    /**
     * parent
     * <p>
     * {@code http://schema.org/parent}
     * <p>
     * A parent of this person.
     *
     * @see <a href="http://schema.org/parent">parent</a>
     */
    public static final IRI parent;

    /**
     * ParentAudience
     * <p>
     * {@code http://schema.org/ParentAudience}
     * <p>
     * A set of characteristics describing parents, who can be interested in
     * viewing some content.
     *
     * @see <a href="http://schema.org/ParentAudience">ParentAudience</a>
     */
    public static final IRI ParentAudience;

    /**
     * parentItem
     * <p>
     * {@code http://schema.org/parentItem}
     * <p>
     * The parent of a question, answer or item in general.
     *
     * @see <a href="http://schema.org/parentItem">parentItem</a>
     */
    public static final IRI parentItem;

    /**
     * parentOrganization
     * <p>
     * {@code http://schema.org/parentOrganization}
     * <p>
     * The larger organization that this organization is a &lt;a
     * href=&quot;http://schema.org/subOrganization&quot;&gt;subOrganization&lt;/a&gt;
     * of, if any.
     *
     * @see <a href="http://schema.org/parentOrganization">parentOrganization</a>
     */
    public static final IRI parentOrganization;

    /**
     * parents
     * <p>
     * {@code http://schema.org/parents}
     * <p>
     * A parents of the person.
     *
     * @see <a href="http://schema.org/parents">parents</a>
     */
    public static final IRI parents;

    /**
     * parentService
     * <p>
     * {@code http://schema.org/parentService}
     * <p>
     * A broadcast service to which the broadcast service may belong to such
     * as regional variations of a national channel.
     *
     * @see <a href="http://schema.org/parentService">parentService</a>
     */
    public static final IRI parentService;

    /**
     * Park
     * <p>
     * {@code http://schema.org/Park}
     * <p>
     * A park.
     *
     * @see <a href="http://schema.org/Park">Park</a>
     */
    public static final IRI Park;

    /**
     * ParkingFacility
     * <p>
     * {@code http://schema.org/ParkingFacility}
     * <p>
     * A parking lot or other parking facility.
     *
     * @see <a href="http://schema.org/ParkingFacility">ParkingFacility</a>
     */
    public static final IRI ParkingFacility;

    /**
     * participant
     * <p>
     * {@code http://schema.org/participant}
     * <p>
     * Other co-agents that participated in the action indirectly. e.g. John
     * wrote a book with &lt;em&gt;Steve&lt;/em&gt;.
     *
     * @see <a href="http://schema.org/participant">participant</a>
     */
    public static final IRI participant;

    /**
     * partOfEpisode
     * <p>
     * {@code http://schema.org/partOfEpisode}
     * <p>
     * The episode to which this clip belongs.
     *
     * @see <a href="http://schema.org/partOfEpisode">partOfEpisode</a>
     */
    public static final IRI partOfEpisode;

    /**
     * partOfInvoice
     * <p>
     * {@code http://schema.org/partOfInvoice}
     * <p>
     * The order is being paid as part of the referenced Invoice.
     *
     * @see <a href="http://schema.org/partOfInvoice">partOfInvoice</a>
     */
    public static final IRI partOfInvoice;

    /**
     * partOfOrder
     * <p>
     * {@code http://schema.org/partOfOrder}
     * <p>
     * The overall order the items in this delivery were included in.
     *
     * @see <a href="http://schema.org/partOfOrder">partOfOrder</a>
     */
    public static final IRI partOfOrder;

    /**
     * partOfSeason
     * <p>
     * {@code http://schema.org/partOfSeason}
     * <p>
     * The season to which this episode belongs.
     *
     * @see <a href="http://schema.org/partOfSeason">partOfSeason</a>
     */
    public static final IRI partOfSeason;

    /**
     * partOfSeries
     * <p>
     * {@code http://schema.org/partOfSeries}
     * <p>
     * The series to which this episode or season belongs.
     *
     * @see <a href="http://schema.org/partOfSeries">partOfSeries</a>
     */
    public static final IRI partOfSeries;

    /**
     * partOfSystem
     * <p>
     * {@code http://schema.org/partOfSystem}
     * <p>
     * The anatomical or organ system that this structure is part of.
     *
     * @see <a href="http://schema.org/partOfSystem">partOfSystem</a>
     */
    public static final IRI partOfSystem;

    /**
     * partOfTVSeries
     * <p>
     * {@code http://schema.org/partOfTVSeries}
     * <p>
     * The TV series to which this episode or season belongs.
     *
     * @see <a href="http://schema.org/partOfTVSeries">partOfTVSeries</a>
     */
    public static final IRI partOfTVSeries;

    /**
     * partySize
     * <p>
     * {@code http://schema.org/partySize}
     * <p>
     * Number of people the reservation should accommodate.
     *
     * @see <a href="http://schema.org/partySize">partySize</a>
     */
    public static final IRI partySize;

    /**
     * passengerPriorityStatus
     * <p>
     * {@code http://schema.org/passengerPriorityStatus}
     * <p>
     * The priority status assigned to a passenger for security or boarding
     * (e.g. FastTrack or Priority).
     *
     * @see <a href="http://schema.org/passengerPriorityStatus">passengerPriorityStatus</a>
     */
    public static final IRI passengerPriorityStatus;

    /**
     * passengerSequenceNumber
     * <p>
     * {@code http://schema.org/passengerSequenceNumber}
     * <p>
     * The passenger&#39;s sequence number as assigned by the airline.
     *
     * @see <a href="http://schema.org/passengerSequenceNumber">passengerSequenceNumber</a>
     */
    public static final IRI passengerSequenceNumber;

    /**
     * PathologyTest
     * <p>
     * {@code http://schema.org/PathologyTest}
     * <p>
     * A medical test performed by a laboratory that typically involves
     * examination of a tissue sample by a pathologist.
     *
     * @see <a href="http://schema.org/PathologyTest">PathologyTest</a>
     */
    public static final IRI PathologyTest;

    /**
     * pathophysiology
     * <p>
     * {@code http://schema.org/pathophysiology}
     * <p>
     * Changes in the normal mechanical, physical, and biochemical functions
     * that are associated with this activity or condition.
     *
     * @see <a href="http://schema.org/pathophysiology">pathophysiology</a>
     */
    public static final IRI pathophysiology;

    /**
     * Patient
     * <p>
     * {@code http://schema.org/Patient}
     * <p>
     * A patient is any person recipient of health care services.
     *
     * @see <a href="http://schema.org/Patient">Patient</a>
     */
    public static final IRI Patient;

    /**
     * PawnShop
     * <p>
     * {@code http://schema.org/PawnShop}
     * <p>
     * A shop that will buy, or lend money against the security of, personal
     * possessions.
     *
     * @see <a href="http://schema.org/PawnShop">PawnShop</a>
     */
    public static final IRI PawnShop;

    /**
     * PayAction
     * <p>
     * {@code http://schema.org/PayAction}
     * <p>
     * An agent pays a price to a participant.
     *
     * @see <a href="http://schema.org/PayAction">PayAction</a>
     */
    public static final IRI PayAction;

    /**
     * payload
     * <p>
     * {@code http://schema.org/payload}
     * <p>
     * The permitted weight of passengers and cargo, EXCLUDING the weight of
     * the empty vehicle.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s): KGM
     * for kilogram, LBR for
     * pound&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;Note 1: Many
     * databases specify the permitted TOTAL weight instead, which is the sum
     * of &lt;a href=&quot;http://schema.org/weight&quot;&gt;weight&lt;/a&gt;
     * and &lt;a
     * href=&quot;http://schema.org/payload&quot;&gt;payload&lt;/a&gt;&lt;/li&gt;
     * &lt;li&gt;Note
     * 2: You can indicate additional information in the &lt;a
     * href=&quot;http://schema.org/name&quot;&gt;name&lt;/a&gt; of the &lt;a
     * href=&quot;http://schema.org/QuantitativeValue&quot;&gt;QuantitativeValue&lt;/a&gt;
     * node.&lt;/li&gt;
     * &lt;li&gt;Note 3: You may also link to a &lt;a
     * href=&quot;http://schema.org/QualitativeValue&quot;&gt;QualitativeValue&lt;/a&gt;
     * node that provides additional information using &lt;a
     * href=&quot;http://schema.org/valueReference&quot;&gt;valueReference&lt;/a&gt;.&lt;/li&gt;
     * &lt;li&gt;Note
     * 4: Note that you can use &lt;a
     * href=&quot;http://schema.org/minValue&quot;&gt;minValue&lt;/a&gt; and
     * &lt;a
     * href=&quot;http://schema.org/maxValue&quot;&gt;maxValue&lt;/a&gt; to
     * indicate ranges.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/payload">payload</a>
     */
    public static final IRI payload;

    /**
     * paymentAccepted
     * <p>
     * {@code http://schema.org/paymentAccepted}
     * <p>
     * Cash, Credit Card, Cryptocurrency, Local Exchange Tradings System,
     * etc.
     *
     * @see <a href="http://schema.org/paymentAccepted">paymentAccepted</a>
     */
    public static final IRI paymentAccepted;

    /**
     * PaymentCard
     * <p>
     * {@code http://schema.org/PaymentCard}
     * <p>
     * A payment method using a credit, debit, store or other card to
     * associate the payment with an account.
     *
     * @see <a href="http://schema.org/PaymentCard">PaymentCard</a>
     */
    public static final IRI PaymentCard;

    /**
     * PaymentChargeSpecification
     * <p>
     * {@code http://schema.org/PaymentChargeSpecification}
     * <p>
     * The costs of settling the payment using a particular payment method.
     *
     * @see <a href="http://schema.org/PaymentChargeSpecification">PaymentChargeSpecification</a>
     */
    public static final IRI PaymentChargeSpecification;

    /**
     * paymentDue
     * <p>
     * {@code http://schema.org/paymentDue}
     * <p>
     * The date that payment is due.
     *
     * @see <a href="http://schema.org/paymentDue">paymentDue</a>
     */
    public static final IRI paymentDue;

    /**
     * paymentDueDate
     * <p>
     * {@code http://schema.org/paymentDueDate}
     * <p>
     * The date that payment is due.
     *
     * @see <a href="http://schema.org/paymentDueDate">paymentDueDate</a>
     */
    public static final IRI paymentDueDate;

    /**
     * paymentMethod
     * <p>
     * {@code http://schema.org/paymentMethod}
     * <p>
     * The name of the credit card or other method of payment for the order.
     *
     * @see <a href="http://schema.org/paymentMethod">paymentMethod</a>
     */
    public static final IRI paymentMethod;

    /**
     * PaymentMethod
     * <p>
     * {@code http://schema.org/PaymentMethod}
     * <p>
     * A payment method is a standardized procedure for transferring the
     * monetary amount for a purchase. Payment methods are characterized by
     * the legal and technical structures used, and by the organization or
     * group carrying out the transaction.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Commonly
     * used
     * values:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#ByBankTransferInAdvance&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#ByInvoice&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#Cash&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#CheckInAdvance&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#COD&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#DirectDebit&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#GoogleCheckout&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#PayPal&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#PaySwarm&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/PaymentMethod">PaymentMethod</a>
     */
    public static final IRI PaymentMethod;

    /**
     * paymentMethodId
     * <p>
     * {@code http://schema.org/paymentMethodId}
     * <p>
     * An identifier for the method of payment used (e.g. the last 4 digits
     * of the credit card).
     *
     * @see <a href="http://schema.org/paymentMethodId">paymentMethodId</a>
     */
    public static final IRI paymentMethodId;

    /**
     * PaymentService
     * <p>
     * {@code http://schema.org/PaymentService}
     * <p>
     * A Service to transfer funds from a person or organization to a
     * beneficiary person or organization.
     *
     * @see <a href="http://schema.org/PaymentService">PaymentService</a>
     */
    public static final IRI PaymentService;

    /**
     * paymentStatus
     * <p>
     * {@code http://schema.org/paymentStatus}
     * <p>
     * The status of payment; whether the invoice has been paid or not.
     *
     * @see <a href="http://schema.org/paymentStatus">paymentStatus</a>
     */
    public static final IRI paymentStatus;

    /**
     * PaymentStatusType
     * <p>
     * {@code http://schema.org/PaymentStatusType}
     * <p>
     * A specific payment status. For example, PaymentDue, PaymentComplete,
     * etc.
     *
     * @see <a href="http://schema.org/PaymentStatusType">PaymentStatusType</a>
     */
    public static final IRI PaymentStatusType;

    /**
     * paymentUrl
     * <p>
     * {@code http://schema.org/paymentUrl}
     * <p>
     * The URL for sending a payment.
     *
     * @see <a href="http://schema.org/paymentUrl">paymentUrl</a>
     */
    public static final IRI paymentUrl;

    /**
     * penciler
     * <p>
     * {@code http://schema.org/penciler}
     * <p>
     * The individual who draws the primary narrative artwork.
     *
     * @see <a href="http://schema.org/penciler">penciler</a>
     */
    public static final IRI penciler;

    /**
     * PeopleAudience
     * <p>
     * {@code http://schema.org/PeopleAudience}
     * <p>
     * A set of characteristics belonging to people, e.g. who compose an
     * item&#39;s target audience.
     *
     * @see <a href="http://schema.org/PeopleAudience">PeopleAudience</a>
     */
    public static final IRI PeopleAudience;

    /**
     * percentile10
     * <p>
     * {@code http://schema.org/percentile10}
     * <p>
     * The 10th percentile value.
     *
     * @see <a href="http://schema.org/percentile10">percentile10</a>
     */
    public static final IRI percentile10;

    /**
     * percentile25
     * <p>
     * {@code http://schema.org/percentile25}
     * <p>
     * The 25th percentile value.
     *
     * @see <a href="http://schema.org/percentile25">percentile25</a>
     */
    public static final IRI percentile25;

    /**
     * percentile75
     * <p>
     * {@code http://schema.org/percentile75}
     * <p>
     * The 75th percentile value.
     *
     * @see <a href="http://schema.org/percentile75">percentile75</a>
     */
    public static final IRI percentile75;

    /**
     * percentile90
     * <p>
     * {@code http://schema.org/percentile90}
     * <p>
     * The 90th percentile value.
     *
     * @see <a href="http://schema.org/percentile90">percentile90</a>
     */
    public static final IRI percentile90;

    /**
     * PerformAction
     * <p>
     * {@code http://schema.org/PerformAction}
     * <p>
     * The act of participating in performance arts.
     *
     * @see <a href="http://schema.org/PerformAction">PerformAction</a>
     */
    public static final IRI PerformAction;

    /**
     * PerformanceRole
     * <p>
     * {@code http://schema.org/PerformanceRole}
     * <p>
     * A PerformanceRole is a Role that some entity places with regard to a
     * theatrical performance, e.g. in a Movie, TVSeries etc.
     *
     * @see <a href="http://schema.org/PerformanceRole">PerformanceRole</a>
     */
    public static final IRI PerformanceRole;

    /**
     * performer
     * <p>
     * {@code http://schema.org/performer}
     * <p>
     * A performer at the event&amp;#x2014;for example, a presenter,
     * musician, musical group or actor.
     *
     * @see <a href="http://schema.org/performer">performer</a>
     */
    public static final IRI performer;

    /**
     * performerIn
     * <p>
     * {@code http://schema.org/performerIn}
     * <p>
     * Event that this person is a performer or participant in.
     *
     * @see <a href="http://schema.org/performerIn">performerIn</a>
     */
    public static final IRI performerIn;

    /**
     * performers
     * <p>
     * {@code http://schema.org/performers}
     * <p>
     * The main performer or performers of the event&amp;#x2014;for example,
     * a presenter, musician, or actor.
     *
     * @see <a href="http://schema.org/performers">performers</a>
     */
    public static final IRI performers;

    /**
     * PerformingArtsTheater
     * <p>
     * {@code http://schema.org/PerformingArtsTheater}
     * <p>
     * A theater or other performing art center.
     *
     * @see <a href="http://schema.org/PerformingArtsTheater">PerformingArtsTheater</a>
     */
    public static final IRI PerformingArtsTheater;

    /**
     * PerformingGroup
     * <p>
     * {@code http://schema.org/PerformingGroup}
     * <p>
     * A performance group, such as a band, an orchestra, or a circus.
     *
     * @see <a href="http://schema.org/PerformingGroup">PerformingGroup</a>
     */
    public static final IRI PerformingGroup;

    /**
     * performTime
     * <p>
     * {@code http://schema.org/performTime}
     * <p>
     * The length of time it takes to perform instructions or a direction
     * (not including time to prepare the supplies), in &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/ISO_8601&quot;&gt;ISO 8601
     * duration format&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/performTime">performTime</a>
     */
    public static final IRI performTime;

    /**
     * Periodical
     * <p>
     * {@code http://schema.org/Periodical}
     * <p>
     * A publication in any medium issued in successive parts bearing
     * numerical or chronological designations and intended, such as a
     * magazine, scholarly journal, or newspaper to continue
     * indefinitely.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * See also &lt;a
     * href=&quot;http://blog.schema.org/2014/09/schemaorg-support-for-bibliographic_2.html&quot;&gt;blog
     * post&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Periodical">Periodical</a>
     */
    public static final IRI Periodical;

    /**
     * permissions
     * <p>
     * {@code http://schema.org/permissions}
     * <p>
     * Permission(s) required to run the app (for example, a mobile app may
     * require full internet access or may run only on wifi).
     *
     * @see <a href="http://schema.org/permissions">permissions</a>
     */
    public static final IRI permissions;

    /**
     * permissionType
     * <p>
     * {@code http://schema.org/permissionType}
     * <p>
     * The type of permission granted the person, organization, or audience.
     *
     * @see <a href="http://schema.org/permissionType">permissionType</a>
     */
    public static final IRI permissionType;

    /**
     * Permit
     * <p>
     * {@code http://schema.org/Permit}
     * <p>
     * A permit issued by an organization, e.g. a parking pass.
     *
     * @see <a href="http://schema.org/Permit">Permit</a>
     */
    public static final IRI Permit;

    /**
     * permitAudience
     * <p>
     * {@code http://schema.org/permitAudience}
     * <p>
     * The target audience for this permit.
     *
     * @see <a href="http://schema.org/permitAudience">permitAudience</a>
     */
    public static final IRI permitAudience;

    /**
     * permittedUsage
     * <p>
     * {@code http://schema.org/permittedUsage}
     * <p>
     * Indications regarding the permitted usage of the accommodation.
     *
     * @see <a href="http://schema.org/permittedUsage">permittedUsage</a>
     */
    public static final IRI permittedUsage;

    /**
     * Person
     * <p>
     * {@code http://schema.org/Person}
     * <p>
     * A person (alive, dead, undead, or fictional).
     *
     * @see <a href="http://schema.org/Person">Person</a>
     */
    public static final IRI Person;

    /**
     * petsAllowed
     * <p>
     * {@code http://schema.org/petsAllowed}
     * <p>
     * Indicates whether pets are allowed to enter the accommodation or
     * lodging business. More detailed information can be put in a text
     * value.
     *
     * @see <a href="http://schema.org/petsAllowed">petsAllowed</a>
     */
    public static final IRI petsAllowed;

    /**
     * PetStore
     * <p>
     * {@code http://schema.org/PetStore}
     * <p>
     * A pet store.
     *
     * @see <a href="http://schema.org/PetStore">PetStore</a>
     */
    public static final IRI PetStore;

    /**
     * Pharmacy
     * <p>
     * {@code http://schema.org/Pharmacy}
     * <p>
     * A pharmacy or drugstore.
     *
     * @see <a href="http://schema.org/Pharmacy">Pharmacy</a>
     */
    public static final IRI Pharmacy;

    /**
     * phase
     * <p>
     * {@code http://schema.org/phase}
     * <p>
     * The phase of the clinical trial.
     *
     * @see <a href="http://schema.org/phase">phase</a>
     */
    public static final IRI phase;

    /**
     * photo
     * <p>
     * {@code http://schema.org/photo}
     * <p>
     * A photograph of this place.
     *
     * @see <a href="http://schema.org/photo">photo</a>
     */
    public static final IRI photo;

    /**
     * Photograph
     * <p>
     * {@code http://schema.org/Photograph}
     * <p>
     * A photograph.
     *
     * @see <a href="http://schema.org/Photograph">Photograph</a>
     */
    public static final IRI Photograph;

    /**
     * PhotographAction
     * <p>
     * {@code http://schema.org/PhotographAction}
     * <p>
     * The act of capturing still images of objects using a camera.
     *
     * @see <a href="http://schema.org/PhotographAction">PhotographAction</a>
     */
    public static final IRI PhotographAction;

    /**
     * photos
     * <p>
     * {@code http://schema.org/photos}
     * <p>
     * Photographs of this place.
     *
     * @see <a href="http://schema.org/photos">photos</a>
     */
    public static final IRI photos;

    /**
     * PhysicalActivity
     * <p>
     * {@code http://schema.org/PhysicalActivity}
     * <p>
     * Any bodily activity that enhances or maintains physical fitness and
     * overall health and wellness. Includes activity that is part of daily
     * living and routine, structured exercise, and exercise prescribed as
     * part of a medical treatment or recovery plan.
     *
     * @see <a href="http://schema.org/PhysicalActivity">PhysicalActivity</a>
     */
    public static final IRI PhysicalActivity;

    /**
     * PhysicalActivityCategory
     * <p>
     * {@code http://schema.org/PhysicalActivityCategory}
     * <p>
     * Categories of physical activity, organized by physiologic
     * classification.
     *
     * @see <a href="http://schema.org/PhysicalActivityCategory">PhysicalActivityCategory</a>
     */
    public static final IRI PhysicalActivityCategory;

    /**
     * PhysicalExam
     * <p>
     * {@code http://schema.org/PhysicalExam}
     * <p>
     * A type of physical examination of a patient performed by a physician.
     *
     * @see <a href="http://schema.org/PhysicalExam">PhysicalExam</a>
     */
    public static final IRI PhysicalExam;

    /**
     * PhysicalTherapy
     * <p>
     * {@code http://schema.org/PhysicalTherapy}
     * <p>
     * A process of progressive physical care and rehabilitation aimed at
     * improving a health condition.
     *
     * @see <a href="http://schema.org/PhysicalTherapy">PhysicalTherapy</a>
     */
    public static final IRI PhysicalTherapy;

    /**
     * Physician
     * <p>
     * {@code http://schema.org/Physician}
     * <p>
     * A doctor&#39;s office.
     *
     * @see <a href="http://schema.org/Physician">Physician</a>
     */
    public static final IRI Physician;

    /**
     * physiologicalBenefits
     * <p>
     * {@code http://schema.org/physiologicalBenefits}
     * <p>
     * Specific physiologic benefits associated to the plan.
     *
     * @see <a href="http://schema.org/physiologicalBenefits">physiologicalBenefits</a>
     */
    public static final IRI physiologicalBenefits;

    /**
     * pickupLocation
     * <p>
     * {@code http://schema.org/pickupLocation}
     * <p>
     * Where a taxi will pick up a passenger or a rental car can be picked
     * up.
     *
     * @see <a href="http://schema.org/pickupLocation">pickupLocation</a>
     */
    public static final IRI pickupLocation;

    /**
     * pickupTime
     * <p>
     * {@code http://schema.org/pickupTime}
     * <p>
     * When a taxi will pickup a passenger or a rental car can be picked up.
     *
     * @see <a href="http://schema.org/pickupTime">pickupTime</a>
     */
    public static final IRI pickupTime;

    /**
     * Place
     * <p>
     * {@code http://schema.org/Place}
     * <p>
     * Entities that have a somewhat fixed, physical extension.
     *
     * @see <a href="http://schema.org/Place">Place</a>
     */
    public static final IRI Place;

    /**
     * PlaceOfWorship
     * <p>
     * {@code http://schema.org/PlaceOfWorship}
     * <p>
     * Place of worship, such as a church, synagogue, or mosque.
     *
     * @see <a href="http://schema.org/PlaceOfWorship">PlaceOfWorship</a>
     */
    public static final IRI PlaceOfWorship;

    /**
     * PlanAction
     * <p>
     * {@code http://schema.org/PlanAction}
     * <p>
     * The act of planning the execution of an
     * event/task/action/reservation/plan to a future date.
     *
     * @see <a href="http://schema.org/PlanAction">PlanAction</a>
     */
    public static final IRI PlanAction;

    /**
     * PlayAction
     * <p>
     * {@code http://schema.org/PlayAction}
     * <p>
     * The act of playing/exercising/training/performing for enjoyment,
     * leisure, recreation, Competition or
     * exercise.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/ListenAction&quot;&gt;ListenAction&lt;/a&gt;:
     * Unlike ListenAction (which is under ConsumeAction), PlayAction refers
     * to performing for an audience or at an event, rather than consuming
     * music.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/WatchAction&quot;&gt;WatchAction&lt;/a&gt;:
     * Unlike WatchAction (which is under ConsumeAction), PlayAction refers
     * to showing/displaying for an audience or at an event, rather than
     * consuming visual content.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/PlayAction">PlayAction</a>
     */
    public static final IRI PlayAction;

    /**
     * playersOnline
     * <p>
     * {@code http://schema.org/playersOnline}
     * <p>
     * Number of players on the server.
     *
     * @see <a href="http://schema.org/playersOnline">playersOnline</a>
     */
    public static final IRI playersOnline;

    /**
     * playerType
     * <p>
     * {@code http://schema.org/playerType}
     * <p>
     * Player type required&amp;#x2014;for example, Flash or Silverlight.
     *
     * @see <a href="http://schema.org/playerType">playerType</a>
     */
    public static final IRI playerType;

    /**
     * Playground
     * <p>
     * {@code http://schema.org/Playground}
     * <p>
     * A playground.
     *
     * @see <a href="http://schema.org/Playground">Playground</a>
     */
    public static final IRI Playground;

    /**
     * playMode
     * <p>
     * {@code http://schema.org/playMode}
     * <p>
     * Indicates whether this game is multi-player, co-op or single-player.
     * The game can be marked as multi-player, co-op and single-player at the
     * same time.
     *
     * @see <a href="http://schema.org/playMode">playMode</a>
     */
    public static final IRI playMode;

    /**
     * Plumber
     * <p>
     * {@code http://schema.org/Plumber}
     * <p>
     * A plumbing service.
     *
     * @see <a href="http://schema.org/Plumber">Plumber</a>
     */
    public static final IRI Plumber;

    /**
     * PoliceStation
     * <p>
     * {@code http://schema.org/PoliceStation}
     * <p>
     * A police station.
     *
     * @see <a href="http://schema.org/PoliceStation">PoliceStation</a>
     */
    public static final IRI PoliceStation;

    /**
     * polygon
     * <p>
     * {@code http://schema.org/polygon}
     * <p>
     * A polygon is the area enclosed by a point-to-point path for which the
     * starting and ending points are the same. A polygon is expressed as a
     * series of four or more space delimited points where the first and
     * final points are identical.
     *
     * @see <a href="http://schema.org/polygon">polygon</a>
     */
    public static final IRI polygon;

    /**
     * Pond
     * <p>
     * {@code http://schema.org/Pond}
     * <p>
     * A pond.
     *
     * @see <a href="http://schema.org/Pond">Pond</a>
     */
    public static final IRI Pond;

    /**
     * population
     * <p>
     * {@code http://schema.org/population}
     * <p>
     * Any characteristics of the population used in the study, e.g.
     * &#39;males under 65&#39;.
     *
     * @see <a href="http://schema.org/population">population</a>
     */
    public static final IRI population;

    /**
     * position
     * <p>
     * {@code http://schema.org/position}
     * <p>
     * The position of an item in a series or sequence of items.
     *
     * @see <a href="http://schema.org/position">position</a>
     */
    public static final IRI position;

    /**
     * possibleComplication
     * <p>
     * {@code http://schema.org/possibleComplication}
     * <p>
     * A possible unexpected and unfavorable evolution of a medical
     * condition. Complications may include worsening of the signs or
     * symptoms of the disease, extension of the condition to other organ
     * systems, etc.
     *
     * @see <a href="http://schema.org/possibleComplication">possibleComplication</a>
     */
    public static final IRI possibleComplication;

    /**
     * possibleTreatment
     * <p>
     * {@code http://schema.org/possibleTreatment}
     * <p>
     * A possible treatment to address this condition, sign or symptom.
     *
     * @see <a href="http://schema.org/possibleTreatment">possibleTreatment</a>
     */
    public static final IRI possibleTreatment;

    /**
     * PostalAddress
     * <p>
     * {@code http://schema.org/PostalAddress}
     * <p>
     * The mailing address.
     *
     * @see <a href="http://schema.org/PostalAddress">PostalAddress</a>
     */
    public static final IRI PostalAddress;

    /**
     * postalCode
     * <p>
     * {@code http://schema.org/postalCode}
     * <p>
     * The postal code. For example, 94043.
     *
     * @see <a href="http://schema.org/postalCode">postalCode</a>
     */
    public static final IRI postalCode;

    /**
     * PostOffice
     * <p>
     * {@code http://schema.org/PostOffice}
     * <p>
     * A post office.
     *
     * @see <a href="http://schema.org/PostOffice">PostOffice</a>
     */
    public static final IRI PostOffice;

    /**
     * postOfficeBoxNumber
     * <p>
     * {@code http://schema.org/postOfficeBoxNumber}
     * <p>
     * The post office box number for PO box addresses.
     *
     * @see <a href="http://schema.org/postOfficeBoxNumber">postOfficeBoxNumber</a>
     */
    public static final IRI postOfficeBoxNumber;

    /**
     * postOp
     * <p>
     * {@code http://schema.org/postOp}
     * <p>
     * A description of the postoperative procedures, care, and/or followups
     * for this device.
     *
     * @see <a href="http://schema.org/postOp">postOp</a>
     */
    public static final IRI postOp;

    /**
     * potentialAction
     * <p>
     * {@code http://schema.org/potentialAction}
     * <p>
     * Indicates a potential Action, which describes an idealized action in
     * which this thing would play an &#39;object&#39; role.
     *
     * @see <a href="http://schema.org/potentialAction">potentialAction</a>
     */
    public static final IRI potentialAction;

    /**
     * predecessorOf
     * <p>
     * {@code http://schema.org/predecessorOf}
     * <p>
     * A pointer from a previous, often discontinued variant of the product
     * to its newer variant.
     *
     * @see <a href="http://schema.org/predecessorOf">predecessorOf</a>
     */
    public static final IRI predecessorOf;

    /**
     * pregnancyCategory
     * <p>
     * {@code http://schema.org/pregnancyCategory}
     * <p>
     * Pregnancy category of this drug.
     *
     * @see <a href="http://schema.org/pregnancyCategory">pregnancyCategory</a>
     */
    public static final IRI pregnancyCategory;

    /**
     * pregnancyWarning
     * <p>
     * {@code http://schema.org/pregnancyWarning}
     * <p>
     * Any precaution, guidance, contraindication, etc. related to this
     * drug&#39;s use during pregnancy.
     *
     * @see <a href="http://schema.org/pregnancyWarning">pregnancyWarning</a>
     */
    public static final IRI pregnancyWarning;

    /**
     * preOp
     * <p>
     * {@code http://schema.org/preOp}
     * <p>
     * A description of the workup, testing, and other preparations required
     * before implanting this device.
     *
     * @see <a href="http://schema.org/preOp">preOp</a>
     */
    public static final IRI preOp;

    /**
     * PreOrderAction
     * <p>
     * {@code http://schema.org/PreOrderAction}
     * <p>
     * An agent orders a (not yet released) object/product/service to be
     * delivered/sent.
     *
     * @see <a href="http://schema.org/PreOrderAction">PreOrderAction</a>
     */
    public static final IRI PreOrderAction;

    /**
     * preparation
     * <p>
     * {@code http://schema.org/preparation}
     * <p>
     * Typical preparation that a patient must undergo before having the
     * procedure performed.
     *
     * @see <a href="http://schema.org/preparation">preparation</a>
     */
    public static final IRI preparation;

    /**
     * PrependAction
     * <p>
     * {@code http://schema.org/PrependAction}
     * <p>
     * The act of inserting at the beginning if an ordered collection.
     *
     * @see <a href="http://schema.org/PrependAction">PrependAction</a>
     */
    public static final IRI PrependAction;

    /**
     * prepTime
     * <p>
     * {@code http://schema.org/prepTime}
     * <p>
     * The length of time it takes to prepare the items to be used in
     * instructions or a direction, in &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/ISO_8601&quot;&gt;ISO 8601
     * duration format&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/prepTime">prepTime</a>
     */
    public static final IRI prepTime;

    /**
     * Preschool
     * <p>
     * {@code http://schema.org/Preschool}
     * <p>
     * A preschool.
     *
     * @see <a href="http://schema.org/Preschool">Preschool</a>
     */
    public static final IRI Preschool;

    /**
     * prescribingInfo
     * <p>
     * {@code http://schema.org/prescribingInfo}
     * <p>
     * Link to prescribing information for the drug.
     *
     * @see <a href="http://schema.org/prescribingInfo">prescribingInfo</a>
     */
    public static final IRI prescribingInfo;

    /**
     * prescriptionStatus
     * <p>
     * {@code http://schema.org/prescriptionStatus}
     * <p>
     * Indicates the status of drug prescription eg. local catalogs
     * classifications or whether the drug is available by prescription or
     * over-the-counter, etc.
     *
     * @see <a href="http://schema.org/prescriptionStatus">prescriptionStatus</a>
     */
    public static final IRI prescriptionStatus;

    /**
     * PresentationDigitalDocument
     * <p>
     * {@code http://schema.org/PresentationDigitalDocument}
     * <p>
     * A file containing slides or used for a presentation.
     *
     * @see <a href="http://schema.org/PresentationDigitalDocument">PresentationDigitalDocument</a>
     */
    public static final IRI PresentationDigitalDocument;

    /**
     * PreventionIndication
     * <p>
     * {@code http://schema.org/PreventionIndication}
     * <p>
     * An indication for preventing an underlying condition, symptom, etc.
     *
     * @see <a href="http://schema.org/PreventionIndication">PreventionIndication</a>
     */
    public static final IRI PreventionIndication;

    /**
     * previousItem
     * <p>
     * {@code http://schema.org/previousItem}
     * <p>
     * A link to the ListItem that preceeds the current one.
     *
     * @see <a href="http://schema.org/previousItem">previousItem</a>
     */
    public static final IRI previousItem;

    /**
     * previousStartDate
     * <p>
     * {@code http://schema.org/previousStartDate}
     * <p>
     * Used in conjunction with eventStatus for rescheduled or cancelled
     * events. This property contains the previously scheduled start date.
     * For rescheduled events, the startDate property should be used for the
     * newly scheduled start date. In the (rare) case of an event that has
     * been postponed and rescheduled multiple times, this field may be
     * repeated.
     *
     * @see <a href="http://schema.org/previousStartDate">previousStartDate</a>
     */
    public static final IRI previousStartDate;

    /**
     * price
     * <p>
     * {@code http://schema.org/price}
     * <p>
     * The offer price of a product, or of a price component when attached to
     * PriceSpecification and its subtypes.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Usage
     * guidelines:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;Use the &lt;a
     * href=&quot;http://schema.org/priceCurrency&quot;&gt;priceCurrency&lt;/a&gt;
     * property (with standard formats: &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/ISO_4217&quot;&gt;ISO 4217
     * currency format&lt;/a&gt; e.g. &quot;USD&quot;; &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/List_of_cryptocurrencies&quot;&gt;Ticker
     * symbol&lt;/a&gt; for cryptocurrencies e.g. &quot;BTC&quot;; well known
     * names for &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/Local_exchange_trading_system&quot;&gt;Local
     * Exchange Tradings Systems&lt;/a&gt; (LETS) and other currency types
     * e.g. &quot;Ithaca HOUR&quot;) instead of including &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/Dollar_sign#Currencies_that_use_the_dollar_or_peso_sign&quot;&gt;ambiguous
     * symbols&lt;/a&gt; such as &#39;$&#39; in the
     * value.&lt;/li&gt;
     * &lt;li&gt;Use &#39;.&#39; (Unicode &#39;FULL
     * STOP&#39; (U+002E)) rather than &#39;,&#39; to indicate a decimal
     * point. Avoid using these symbols as a readability
     * separator.&lt;/li&gt;
     * &lt;li&gt;Note that both &lt;a
     * href=&quot;http://www.w3.org/TR/xhtml-rdfa-primer/#using-the-content-attribute&quot;&gt;RDFa&lt;/a&gt;
     * and Microdata syntax allow the use of a &quot;content=&quot; attribute
     * for publishing simple machine-readable values alongside more
     * human-friendly formatting.&lt;/li&gt;
     * &lt;li&gt;Use values from
     * 0123456789 (Unicode &#39;DIGIT ZERO&#39; (U+0030) to &#39;DIGIT
     * NINE&#39; (U+0039)) rather than superficially similiar Unicode
     * symbols.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/price">price</a>
     */
    public static final IRI price;

    /**
     * priceComponent
     * <p>
     * {@code http://schema.org/priceComponent}
     * <p>
     * This property links to all &lt;a
     * href=&quot;http://schema.org/UnitPriceSpecification&quot;&gt;UnitPriceSpecification&lt;/a&gt;
     * nodes that apply in parallel for the &lt;a
     * href=&quot;http://schema.org/CompoundPriceSpecification&quot;&gt;CompoundPriceSpecification&lt;/a&gt;
     * node.
     *
     * @see <a href="http://schema.org/priceComponent">priceComponent</a>
     */
    public static final IRI priceComponent;

    /**
     * priceCurrency
     * <p>
     * {@code http://schema.org/priceCurrency}
     * <p>
     * The currency of the price, or a price component when attached to &lt;a
     * href=&quot;http://schema.org/PriceSpecification&quot;&gt;PriceSpecification&lt;/a&gt;
     * and its subtypes.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Use standard formats: &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/ISO_4217&quot;&gt;ISO 4217
     * currency format&lt;/a&gt; e.g. &quot;USD&quot;; &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/List_of_cryptocurrencies&quot;&gt;Ticker
     * symbol&lt;/a&gt; for cryptocurrencies e.g. &quot;BTC&quot;; well known
     * names for &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/Local_exchange_trading_system&quot;&gt;Local
     * Exchange Tradings Systems&lt;/a&gt; (LETS) and other currency types
     * e.g. &quot;Ithaca HOUR&quot;.
     *
     * @see <a href="http://schema.org/priceCurrency">priceCurrency</a>
     */
    public static final IRI priceCurrency;

    /**
     * priceRange
     * <p>
     * {@code http://schema.org/priceRange}
     * <p>
     * The price range of the business, for example
     * &lt;code&gt;$$$&lt;/code&gt;.
     *
     * @see <a href="http://schema.org/priceRange">priceRange</a>
     */
    public static final IRI priceRange;

    /**
     * priceSpecification
     * <p>
     * {@code http://schema.org/priceSpecification}
     * <p>
     * One or more detailed price specifications, indicating the unit price
     * and delivery or payment charges.
     *
     * @see <a href="http://schema.org/priceSpecification">priceSpecification</a>
     */
    public static final IRI priceSpecification;

    /**
     * PriceSpecification
     * <p>
     * {@code http://schema.org/PriceSpecification}
     * <p>
     * A structured value representing a price or price range. Typically,
     * only the subclasses of this type are used for markup. It is
     * recommended to use &lt;a
     * href=&quot;http://schema.org/MonetaryAmount&quot;&gt;MonetaryAmount&lt;/a&gt;
     * to describe independent amounts of money such as a salary, credit card
     * limits, etc.
     *
     * @see <a href="http://schema.org/PriceSpecification">PriceSpecification</a>
     */
    public static final IRI PriceSpecification;

    /**
     * priceType
     * <p>
     * {@code http://schema.org/priceType}
     * <p>
     * A short text or acronym indicating multiple price specifications for
     * the same offer, e.g. SRP for the suggested retail price or INVOICE for
     * the invoice price, mostly used in the car industry.
     *
     * @see <a href="http://schema.org/priceType">priceType</a>
     */
    public static final IRI priceType;

    /**
     * priceValidUntil
     * <p>
     * {@code http://schema.org/priceValidUntil}
     * <p>
     * The date after which the price is no longer available.
     *
     * @see <a href="http://schema.org/priceValidUntil">priceValidUntil</a>
     */
    public static final IRI priceValidUntil;

    /**
     * primaryImageOfPage
     * <p>
     * {@code http://schema.org/primaryImageOfPage}
     * <p>
     * Indicates the main image on the page.
     *
     * @see <a href="http://schema.org/primaryImageOfPage">primaryImageOfPage</a>
     */
    public static final IRI primaryImageOfPage;

    /**
     * primaryPrevention
     * <p>
     * {@code http://schema.org/primaryPrevention}
     * <p>
     * A preventative therapy used to prevent an initial occurrence of the
     * medical condition, such as vaccination.
     *
     * @see <a href="http://schema.org/primaryPrevention">primaryPrevention</a>
     */
    public static final IRI primaryPrevention;

    /**
     * printColumn
     * <p>
     * {@code http://schema.org/printColumn}
     * <p>
     * The number of the column in which the NewsArticle appears in the print
     * edition.
     *
     * @see <a href="http://schema.org/printColumn">printColumn</a>
     */
    public static final IRI printColumn;

    /**
     * printEdition
     * <p>
     * {@code http://schema.org/printEdition}
     * <p>
     * The edition of the print product in which the NewsArticle appears.
     *
     * @see <a href="http://schema.org/printEdition">printEdition</a>
     */
    public static final IRI printEdition;

    /**
     * printPage
     * <p>
     * {@code http://schema.org/printPage}
     * <p>
     * If this NewsArticle appears in print, this field indicates the name of
     * the page on which the article is found. Please note that this field is
     * intended for the exact page name (e.g. A5, B18).
     *
     * @see <a href="http://schema.org/printPage">printPage</a>
     */
    public static final IRI printPage;

    /**
     * printSection
     * <p>
     * {@code http://schema.org/printSection}
     * <p>
     * If this NewsArticle appears in print, this field indicates the print
     * section in which the article appeared.
     *
     * @see <a href="http://schema.org/printSection">printSection</a>
     */
    public static final IRI printSection;

    /**
     * procedure
     * <p>
     * {@code http://schema.org/procedure}
     * <p>
     * A description of the procedure involved in setting up, using, and/or
     * installing the device.
     *
     * @see <a href="http://schema.org/procedure">procedure</a>
     */
    public static final IRI procedure;

    /**
     * procedureType
     * <p>
     * {@code http://schema.org/procedureType}
     * <p>
     * The type of procedure, for example Surgical, Noninvasive, or
     * Percutaneous.
     *
     * @see <a href="http://schema.org/procedureType">procedureType</a>
     */
    public static final IRI procedureType;

    /**
     * processingTime
     * <p>
     * {@code http://schema.org/processingTime}
     * <p>
     * Estimated processing time for the service using this channel.
     *
     * @see <a href="http://schema.org/processingTime">processingTime</a>
     */
    public static final IRI processingTime;

    /**
     * processorRequirements
     * <p>
     * {@code http://schema.org/processorRequirements}
     * <p>
     * Processor architecture required to run the application (e.g. IA64).
     *
     * @see <a href="http://schema.org/processorRequirements">processorRequirements</a>
     */
    public static final IRI processorRequirements;

    /**
     * producer
     * <p>
     * {@code http://schema.org/producer}
     * <p>
     * The person or organization who produced the work (e.g. music album,
     * movie, tv/radio series etc.).
     *
     * @see <a href="http://schema.org/producer">producer</a>
     */
    public static final IRI producer;

    /**
     * produces
     * <p>
     * {@code http://schema.org/produces}
     * <p>
     * The tangible thing generated by the service, e.g. a passport, permit,
     * etc.
     *
     * @see <a href="http://schema.org/produces">produces</a>
     */
    public static final IRI produces;

    /**
     * Product
     * <p>
     * {@code http://schema.org/Product}
     * <p>
     * Any offered product or service. For example: a pair of shoes; a
     * concert ticket; the rental of a car; a haircut; or an episode of a TV
     * show streamed online.
     *
     * @see <a href="http://schema.org/Product">Product</a>
     */
    public static final IRI Product;

    /**
     * productID
     * <p>
     * {@code http://schema.org/productID}
     * <p>
     * The product identifier, such as ISBN. For example: &lt;code&gt;meta
     * itemprop=&quot;productID&quot;
     * content=&quot;isbn:123-456-789&quot;&lt;/code&gt;.
     *
     * @see <a href="http://schema.org/productID">productID</a>
     */
    public static final IRI productID;

    /**
     * productionCompany
     * <p>
     * {@code http://schema.org/productionCompany}
     * <p>
     * The production company or studio responsible for the item e.g. series,
     * video game, episode etc.
     *
     * @see <a href="http://schema.org/productionCompany">productionCompany</a>
     */
    public static final IRI productionCompany;

    /**
     * productionDate
     * <p>
     * {@code http://schema.org/productionDate}
     * <p>
     * The date of production of the item, e.g. vehicle.
     *
     * @see <a href="http://schema.org/productionDate">productionDate</a>
     */
    public static final IRI productionDate;

    /**
     * ProductModel
     * <p>
     * {@code http://schema.org/ProductModel}
     * <p>
     * A datasheet or vendor specification of a product (in the sense of a
     * prototypical description).
     *
     * @see <a href="http://schema.org/ProductModel">ProductModel</a>
     */
    public static final IRI ProductModel;

    /**
     * productSupported
     * <p>
     * {@code http://schema.org/productSupported}
     * <p>
     * The product or service this support contact point is related to (such
     * as product support for a particular product line). This can be a
     * specific product or product line (e.g. &quot;iPhone&quot;) or a
     * general category of products or services (e.g.
     * &quot;smartphones&quot;).
     *
     * @see <a href="http://schema.org/productSupported">productSupported</a>
     */
    public static final IRI productSupported;

    /**
     * ProfessionalService
     * <p>
     * {@code http://schema.org/ProfessionalService}
     * <p>
     * Original definition: &quot;provider of professional
     * services.&quot;&lt;br/&gt;&lt;br/&gt;
     * <p>
     * The general &lt;a
     * href=&quot;http://schema.org/ProfessionalService&quot;&gt;ProfessionalService&lt;/a&gt;
     * type for local businesses was deprecated due to confusion with &lt;a
     * href=&quot;http://schema.org/Service&quot;&gt;Service&lt;/a&gt;. For
     * reference, the types that it included were: &lt;a
     * href=&quot;http://schema.org/Dentist&quot;&gt;Dentist&lt;/a&gt;,
     * <p>
     * &lt;a
     * href=&quot;http://schema.org/AccountingService&quot;&gt;AccountingService&lt;/a&gt;,
     * &lt;a
     * href=&quot;http://schema.org/Attorney&quot;&gt;Attorney&lt;/a&gt;,
     * &lt;a href=&quot;http://schema.org/Notary&quot;&gt;Notary&lt;/a&gt;,
     * as well as types for several kinds of &lt;a
     * href=&quot;http://schema.org/HomeAndConstructionBusiness&quot;&gt;HomeAndConstructionBusiness&lt;/a&gt;:
     * &lt;a
     * href=&quot;http://schema.org/Electrician&quot;&gt;Electrician&lt;/a&gt;,
     * &lt;a
     * href=&quot;http://schema.org/GeneralContractor&quot;&gt;GeneralContractor&lt;/a&gt;,
     * <p>
     * &lt;a
     * href=&quot;http://schema.org/HousePainter&quot;&gt;HousePainter&lt;/a&gt;,
     * &lt;a
     * href=&quot;http://schema.org/Locksmith&quot;&gt;Locksmith&lt;/a&gt;,
     * &lt;a href=&quot;http://schema.org/Plumber&quot;&gt;Plumber&lt;/a&gt;,
     * &lt;a
     * href=&quot;http://schema.org/RoofingContractor&quot;&gt;RoofingContractor&lt;/a&gt;.
     * &lt;a
     * href=&quot;http://schema.org/LegalService&quot;&gt;LegalService&lt;/a&gt;
     * was introduced as a more inclusive supertype of &lt;a
     * href=&quot;http://schema.org/Attorney&quot;&gt;Attorney&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/ProfessionalService">ProfessionalService</a>
     */
    public static final IRI ProfessionalService;

    /**
     * proficiencyLevel
     * <p>
     * {@code http://schema.org/proficiencyLevel}
     * <p>
     * Proficiency needed for this content; expected values:
     * &#39;Beginner&#39;, &#39;Expert&#39;.
     *
     * @see <a href="http://schema.org/proficiencyLevel">proficiencyLevel</a>
     */
    public static final IRI proficiencyLevel;

    /**
     * ProfilePage
     * <p>
     * {@code http://schema.org/ProfilePage}
     * <p>
     * Web page type: Profile page.
     *
     * @see <a href="http://schema.org/ProfilePage">ProfilePage</a>
     */
    public static final IRI ProfilePage;

    /**
     * ProgramMembership
     * <p>
     * {@code http://schema.org/ProgramMembership}
     * <p>
     * Used to describe membership in a loyalty programs (e.g.
     * &quot;StarAliance&quot;), traveler clubs (e.g. &quot;AAA&quot;),
     * purchase clubs (&quot;Safeway Club&quot;), etc.
     *
     * @see <a href="http://schema.org/ProgramMembership">ProgramMembership</a>
     */
    public static final IRI ProgramMembership;

    /**
     * programMembershipUsed
     * <p>
     * {@code http://schema.org/programMembershipUsed}
     * <p>
     * Any membership in a frequent flyer, hotel loyalty program, etc. being
     * applied to the reservation.
     *
     * @see <a href="http://schema.org/programMembershipUsed">programMembershipUsed</a>
     */
    public static final IRI programMembershipUsed;

    /**
     * programmingLanguage
     * <p>
     * {@code http://schema.org/programmingLanguage}
     * <p>
     * The computer programming language.
     *
     * @see <a href="http://schema.org/programmingLanguage">programmingLanguage</a>
     */
    public static final IRI programmingLanguage;

    /**
     * programmingModel
     * <p>
     * {@code http://schema.org/programmingModel}
     * <p>
     * Indicates whether API is managed or unmanaged.
     *
     * @see <a href="http://schema.org/programmingModel">programmingModel</a>
     */
    public static final IRI programmingModel;

    /**
     * programName
     * <p>
     * {@code http://schema.org/programName}
     * <p>
     * The program providing the membership.
     *
     * @see <a href="http://schema.org/programName">programName</a>
     */
    public static final IRI programName;

    /**
     * Property
     * <p>
     * {@code http://schema.org/Property}
     * <p>
     * A property, used to indicate attributes and relationships of some
     * Thing; equivalent to rdf:Property.
     *
     * @see <a href="http://schema.org/Property">Property</a>
     */
    public static final IRI Property;

    /**
     * propertyID
     * <p>
     * {@code http://schema.org/propertyID}
     * <p>
     * A commonly used identifier for the characteristic represented by the
     * property, e.g. a manufacturer or a standard code for a property.
     * propertyID can be
     * (1) a prefixed string, mainly meant to be used with
     * standards for product properties; (2) a site-specific, non-prefixed
     * string (e.g. the primary key of the property or the vendor-specific id
     * of the property), or (3)
     * a URL indicating the type of the property,
     * either pointing to an external vocabulary, or a Web resource that
     * describes the property (e.g. a glossary entry).
     * Standards bodies
     * should promote a standard prefix for the identifiers of properties
     * from their standards.
     *
     * @see <a href="http://schema.org/propertyID">propertyID</a>
     */
    public static final IRI propertyID;

    /**
     * PropertyValue
     * <p>
     * {@code http://schema.org/PropertyValue}
     * <p>
     * A property-value pair, e.g. representing a feature of a product or
     * place. Use the &#39;name&#39; property for the name of the property.
     * If there is an additional human-readable version of the value, put
     * that into the &#39;description&#39;
     * property.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Always use specific schema.org
     * properties when a) they exist and b) you can populate them. Using
     * PropertyValue as a substitute will typically not trigger the same
     * effect as using the original, specific property.
     *
     * @see <a href="http://schema.org/PropertyValue">PropertyValue</a>
     */
    public static final IRI PropertyValue;

    /**
     * PropertyValueSpecification
     * <p>
     * {@code http://schema.org/PropertyValueSpecification}
     * <p>
     * A Property value specification.
     *
     * @see <a href="http://schema.org/PropertyValueSpecification">PropertyValueSpecification</a>
     */
    public static final IRI PropertyValueSpecification;

    /**
     * proprietaryName
     * <p>
     * {@code http://schema.org/proprietaryName}
     * <p>
     * Proprietary name given to the diet plan, typically by its originator
     * or creator.
     *
     * @see <a href="http://schema.org/proprietaryName">proprietaryName</a>
     */
    public static final IRI proprietaryName;

    /**
     * proteinContent
     * <p>
     * {@code http://schema.org/proteinContent}
     * <p>
     * The number of grams of protein.
     *
     * @see <a href="http://schema.org/proteinContent">proteinContent</a>
     */
    public static final IRI proteinContent;

    /**
     * provider
     * <p>
     * {@code http://schema.org/provider}
     * <p>
     * The service provider, service operator, or service performer; the
     * goods producer. Another party (a seller) may offer those services or
     * goods on behalf of the provider. A provider may also serve as the
     * seller.
     *
     * @see <a href="http://schema.org/provider">provider</a>
     */
    public static final IRI provider;

    /**
     * providerMobility
     * <p>
     * {@code http://schema.org/providerMobility}
     * <p>
     * Indicates the mobility of a provided service (e.g. &#39;static&#39;,
     * &#39;dynamic&#39;).
     *
     * @see <a href="http://schema.org/providerMobility">providerMobility</a>
     */
    public static final IRI providerMobility;

    /**
     * providesBroadcastService
     * <p>
     * {@code http://schema.org/providesBroadcastService}
     * <p>
     * The BroadcastService offered on this channel.
     *
     * @see <a href="http://schema.org/providesBroadcastService">providesBroadcastService</a>
     */
    public static final IRI providesBroadcastService;

    /**
     * providesService
     * <p>
     * {@code http://schema.org/providesService}
     * <p>
     * The service provided by this channel.
     *
     * @see <a href="http://schema.org/providesService">providesService</a>
     */
    public static final IRI providesService;

    /**
     * PsychologicalTreatment
     * <p>
     * {@code http://schema.org/PsychologicalTreatment}
     * <p>
     * A process of care relying upon counseling, dialogue and communication
     * aimed at improving a mental health condition without use of drugs.
     *
     * @see <a href="http://schema.org/PsychologicalTreatment">PsychologicalTreatment</a>
     */
    public static final IRI PsychologicalTreatment;

    /**
     * publicAccess
     * <p>
     * {@code http://schema.org/publicAccess}
     * <p>
     * A flag to signal that the &lt;a
     * href=&quot;http://schema.org/Place&quot;&gt;Place&lt;/a&gt; is open to
     * public visitors.  If this property is omitted there is no assumed
     * default boolean value
     *
     * @see <a href="http://schema.org/publicAccess">publicAccess</a>
     */
    public static final IRI publicAccess;

    /**
     * publication
     * <p>
     * {@code http://schema.org/publication}
     * <p>
     * A publication event associated with the item.
     *
     * @see <a href="http://schema.org/publication">publication</a>
     */
    public static final IRI publication;

    /**
     * PublicationEvent
     * <p>
     * {@code http://schema.org/PublicationEvent}
     * <p>
     * A PublicationEvent corresponds indifferently to the event of
     * publication for a CreativeWork of any type e.g. a broadcast event, an
     * on-demand event, a book/journal publication via a variety of delivery
     * media.
     *
     * @see <a href="http://schema.org/PublicationEvent">PublicationEvent</a>
     */
    public static final IRI PublicationEvent;

    /**
     * PublicationIssue
     * <p>
     * {@code http://schema.org/PublicationIssue}
     * <p>
     * A part of a successively published publication such as a periodical or
     * publication volume, often numbered, usually containing a grouping of
     * works such as articles.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;a
     * href=&quot;http://blog.schema.org/2014/09/schemaorg-support-for-bibliographic_2.html&quot;&gt;blog
     * post&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/PublicationIssue">PublicationIssue</a>
     */
    public static final IRI PublicationIssue;

    /**
     * publicationType
     * <p>
     * {@code http://schema.org/publicationType}
     * <p>
     * The type of the medical article, taken from the US NLM MeSH
     * publication type catalog. See also &lt;a
     * href=&quot;http://www.nlm.nih.gov/mesh/pubtypes.html&quot;&gt;MeSH
     * documentation&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/publicationType">publicationType</a>
     */
    public static final IRI publicationType;

    /**
     * PublicationVolume
     * <p>
     * {@code http://schema.org/PublicationVolume}
     * <p>
     * A part of a successively published publication such as a periodical or
     * multi-volume work, often numbered. It may represent a time span, such
     * as a year.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;pre&gt;&lt;code&gt;
     * &amp;lt;br/&amp;gt;&amp;lt;br/&amp;gt;See also &amp;lt;a
     * href=&quot;http://blog.schema.org/2014/09/schemaorg-support-for-bibliographic_2.html&quot;&amp;gt;blog
     * post&amp;lt;/a&amp;gt;.
     * &lt;/code&gt;&lt;/pre&gt;
     *
     * @see <a href="http://schema.org/PublicationVolume">PublicationVolume</a>
     */
    public static final IRI PublicationVolume;

    /**
     * PublicSwimmingPool
     * <p>
     * {@code http://schema.org/PublicSwimmingPool}
     * <p>
     * A public swimming pool.
     *
     * @see <a href="http://schema.org/PublicSwimmingPool">PublicSwimmingPool</a>
     */
    public static final IRI PublicSwimmingPool;

    /**
     * PublicToilet
     * <p>
     * {@code http://schema.org/PublicToilet}
     * <p>
     * A public toilet is a room or small building containing one or more
     * toilets (and possibly also urinals) which is available for use by the
     * general public, or by customers or employees of certain businesses.
     *
     * @see <a href="http://schema.org/PublicToilet">PublicToilet</a>
     */
    public static final IRI PublicToilet;

    /**
     * publishedBy
     * <p>
     * {@code http://schema.org/publishedBy}
     * <p>
     * An agent associated with the publication event.
     *
     * @see <a href="http://schema.org/publishedBy">publishedBy</a>
     */
    public static final IRI publishedBy;

    /**
     * publishedOn
     * <p>
     * {@code http://schema.org/publishedOn}
     * <p>
     * A broadcast service associated with the publication event.
     *
     * @see <a href="http://schema.org/publishedOn">publishedOn</a>
     */
    public static final IRI publishedOn;

    /**
     * publisher
     * <p>
     * {@code http://schema.org/publisher}
     * <p>
     * The publisher of the creative work.
     *
     * @see <a href="http://schema.org/publisher">publisher</a>
     */
    public static final IRI publisher;

    /**
     * publisherImprint
     * <p>
     * {@code http://schema.org/publisherImprint}
     * <p>
     * The publishing division which published the comic.
     *
     * @see <a href="http://schema.org/publisherImprint">publisherImprint</a>
     */
    public static final IRI publisherImprint;

    /**
     * publishingPrinciples
     * <p>
     * {@code http://schema.org/publishingPrinciples}
     * <p>
     * The publishingPrinciples property indicates (typically via &lt;a
     * href=&quot;http://schema.org/URL&quot;&gt;URL&lt;/a&gt;) a document
     * describing the editorial principles of an &lt;a
     * href=&quot;http://schema.org/Organization&quot;&gt;Organization&lt;/a&gt;
     * (or individual e.g. a &lt;a
     * href=&quot;http://schema.org/Person&quot;&gt;Person&lt;/a&gt; writing
     * a blog) that relate to their activities as a publisher, e.g. ethics or
     * diversity policies. When applied to a &lt;a
     * href=&quot;http://schema.org/CreativeWork&quot;&gt;CreativeWork&lt;/a&gt;
     * (e.g. &lt;a
     * href=&quot;http://schema.org/NewsArticle&quot;&gt;NewsArticle&lt;/a&gt;)
     * the principles are those of the party primarily responsible for the
     * creation of the &lt;a
     * href=&quot;http://schema.org/CreativeWork&quot;&gt;CreativeWork&lt;/a&gt;.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * While
     * such policies are most typically expressed in natural language,
     * sometimes related information (e.g. indicating a &lt;a
     * href=&quot;http://schema.org/funder&quot;&gt;funder&lt;/a&gt;) can be
     * expressed using schema.org terminology.
     *
     * @see <a href="http://schema.org/publishingPrinciples">publishingPrinciples</a>
     */
    public static final IRI publishingPrinciples;

    /**
     * purchaseDate
     * <p>
     * {@code http://schema.org/purchaseDate}
     * <p>
     * The date the item e.g. vehicle was purchased by the current owner.
     *
     * @see <a href="http://schema.org/purchaseDate">purchaseDate</a>
     */
    public static final IRI purchaseDate;

    /**
     * purpose
     * <p>
     * {@code http://schema.org/purpose}
     * <p>
     * A goal towards an action is taken. Can be concrete or abstract.
     *
     * @see <a href="http://schema.org/purpose">purpose</a>
     */
    public static final IRI purpose;

    /**
     * QAPage
     * <p>
     * {@code http://schema.org/QAPage}
     * <p>
     * A QAPage is a WebPage focussed on a specific Question and its
     * Answer(s), e.g. in a question answering site or documenting Frequently
     * Asked Questions (FAQs).
     *
     * @see <a href="http://schema.org/QAPage">QAPage</a>
     */
    public static final IRI QAPage;

    /**
     * qualifications
     * <p>
     * {@code http://schema.org/qualifications}
     * <p>
     * Specific qualifications required for this role or Occupation.
     *
     * @see <a href="http://schema.org/qualifications">qualifications</a>
     */
    public static final IRI qualifications;

    /**
     * QualitativeValue
     * <p>
     * {@code http://schema.org/QualitativeValue}
     * <p>
     * A predefined value for a product characteristic, e.g. the power cord
     * plug type &#39;US&#39; or the garment sizes &#39;S&#39;, &#39;M&#39;,
     * &#39;L&#39;, and &#39;XL&#39;.
     *
     * @see <a href="http://schema.org/QualitativeValue">QualitativeValue</a>
     */
    public static final IRI QualitativeValue;

    /**
     * QuantitativeValue
     * <p>
     * {@code http://schema.org/QuantitativeValue}
     * <p>
     * A point value or interval for product characteristics and other
     * purposes.
     *
     * @see <a href="http://schema.org/QuantitativeValue">QuantitativeValue</a>
     */
    public static final IRI QuantitativeValue;

    /**
     * QuantitativeValueDistribution
     * <p>
     * {@code http://schema.org/QuantitativeValueDistribution}
     * <p>
     * A statistical distribution of values.
     *
     * @see <a href="http://schema.org/QuantitativeValueDistribution">QuantitativeValueDistribution</a>
     */
    public static final IRI QuantitativeValueDistribution;

    /**
     * Quantity
     * <p>
     * {@code http://schema.org/Quantity}
     * <p>
     * Quantities such as distance, time, mass, weight, etc. Particular
     * instances of say Mass are entities like &#39;3 Kg&#39; or &#39;4
     * milligrams&#39;.
     *
     * @see <a href="http://schema.org/Quantity">Quantity</a>
     */
    public static final IRI Quantity;

    /**
     * query
     * <p>
     * {@code http://schema.org/query}
     * <p>
     * A sub property of instrument. The query used on this action.
     *
     * @see <a href="http://schema.org/query">query</a>
     */
    public static final IRI query;

    /**
     * quest
     * <p>
     * {@code http://schema.org/quest}
     * <p>
     * The task that a player-controlled character, or group of characters
     * may complete in order to gain a reward.
     *
     * @see <a href="http://schema.org/quest">quest</a>
     */
    public static final IRI quest;

    /**
     * question
     * <p>
     * {@code http://schema.org/question}
     * <p>
     * A sub property of object. A question.
     *
     * @see <a href="http://schema.org/question">question</a>
     */
    public static final IRI question;

    /**
     * Question
     * <p>
     * {@code http://schema.org/Question}
     * <p>
     * A specific question - e.g. from a user seeking answers online, or
     * collected in a Frequently Asked Questions (FAQ) document.
     *
     * @see <a href="http://schema.org/Question">Question</a>
     */
    public static final IRI Question;

    /**
     * Quotation
     * <p>
     * {@code http://schema.org/Quotation}
     * <p>
     * A quotation. Often but not necessarily from some written work,
     * attributable to a real world author and - if associated with a
     * fictional character - to any fictional Person. Use &lt;a
     * href=&quot;http://schema.org/isBasedOn&quot;&gt;isBasedOn&lt;/a&gt; to
     * link to source/origin. The &lt;a
     * href=&quot;http://schema.org/recordedIn&quot;&gt;recordedIn&lt;/a&gt;
     * property can be used to reference a Quotation from an &lt;a
     * href=&quot;http://schema.org/Event&quot;&gt;Event&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Quotation">Quotation</a>
     */
    public static final IRI Quotation;

    /**
     * QuoteAction
     * <p>
     * {@code http://schema.org/QuoteAction}
     * <p>
     * An agent quotes/estimates/appraises an object/product/service with a
     * price at a location/store.
     *
     * @see <a href="http://schema.org/QuoteAction">QuoteAction</a>
     */
    public static final IRI QuoteAction;

    /**
     * RadiationTherapy
     * <p>
     * {@code http://schema.org/RadiationTherapy}
     * <p>
     * A process of care using radiation aimed at improving a health
     * condition.
     *
     * @see <a href="http://schema.org/RadiationTherapy">RadiationTherapy</a>
     */
    public static final IRI RadiationTherapy;

    /**
     * RadioChannel
     * <p>
     * {@code http://schema.org/RadioChannel}
     * <p>
     * A unique instance of a radio BroadcastService on a
     * CableOrSatelliteService lineup.
     *
     * @see <a href="http://schema.org/RadioChannel">RadioChannel</a>
     */
    public static final IRI RadioChannel;

    /**
     * RadioClip
     * <p>
     * {@code http://schema.org/RadioClip}
     * <p>
     * A short radio program or a segment/part of a radio program.
     *
     * @see <a href="http://schema.org/RadioClip">RadioClip</a>
     */
    public static final IRI RadioClip;

    /**
     * RadioEpisode
     * <p>
     * {@code http://schema.org/RadioEpisode}
     * <p>
     * A radio episode which can be part of a series or season.
     *
     * @see <a href="http://schema.org/RadioEpisode">RadioEpisode</a>
     */
    public static final IRI RadioEpisode;

    /**
     * RadioSeason
     * <p>
     * {@code http://schema.org/RadioSeason}
     * <p>
     * Season dedicated to radio broadcast and associated online delivery.
     *
     * @see <a href="http://schema.org/RadioSeason">RadioSeason</a>
     */
    public static final IRI RadioSeason;

    /**
     * RadioSeries
     * <p>
     * {@code http://schema.org/RadioSeries}
     * <p>
     * CreativeWorkSeries dedicated to radio broadcast and associated online
     * delivery.
     *
     * @see <a href="http://schema.org/RadioSeries">RadioSeries</a>
     */
    public static final IRI RadioSeries;

    /**
     * RadioStation
     * <p>
     * {@code http://schema.org/RadioStation}
     * <p>
     * A radio station.
     *
     * @see <a href="http://schema.org/RadioStation">RadioStation</a>
     */
    public static final IRI RadioStation;

    /**
     * rangeIncludes
     * <p>
     * {@code http://schema.org/rangeIncludes}
     * <p>
     * Relates a property to a class that constitutes (one of) the expected
     * type(s) for values of the property.
     *
     * @see <a href="http://schema.org/rangeIncludes">rangeIncludes</a>
     */
    public static final IRI rangeIncludes;

    /**
     * Rating
     * <p>
     * {@code http://schema.org/Rating}
     * <p>
     * A rating is an evaluation on a numeric scale, such as 1 to 5 stars.
     *
     * @see <a href="http://schema.org/Rating">Rating</a>
     */
    public static final IRI Rating;

    /**
     * ratingCount
     * <p>
     * {@code http://schema.org/ratingCount}
     * <p>
     * The count of total number of ratings.
     *
     * @see <a href="http://schema.org/ratingCount">ratingCount</a>
     */
    public static final IRI ratingCount;

    /**
     * ratingValue
     * <p>
     * {@code http://schema.org/ratingValue}
     * <p>
     * The rating for the content.
     *
     * @see <a href="http://schema.org/ratingValue">ratingValue</a>
     */
    public static final IRI ratingValue;

    /**
     * ReactAction
     * <p>
     * {@code http://schema.org/ReactAction}
     * <p>
     * The act of responding instinctively and emotionally to an object,
     * expressing a sentiment.
     *
     * @see <a href="http://schema.org/ReactAction">ReactAction</a>
     */
    public static final IRI ReactAction;

    /**
     * ReadAction
     * <p>
     * {@code http://schema.org/ReadAction}
     * <p>
     * The act of consuming written content.
     *
     * @see <a href="http://schema.org/ReadAction">ReadAction</a>
     */
    public static final IRI ReadAction;

    /**
     * readBy
     * <p>
     * {@code http://schema.org/readBy}
     * <p>
     * A person who reads (performs) the audiobook.
     *
     * @see <a href="http://schema.org/readBy">readBy</a>
     */
    public static final IRI readBy;

    /**
     * readonlyValue
     * <p>
     * {@code http://schema.org/readonlyValue}
     * <p>
     * Whether or not a property is mutable.  Default is false. Specifying
     * this for a property that also has a value makes it act similar to a
     * &quot;hidden&quot; input in an HTML form.
     *
     * @see <a href="http://schema.org/readonlyValue">readonlyValue</a>
     */
    public static final IRI readonlyValue;

    /**
     * realEstateAgent
     * <p>
     * {@code http://schema.org/realEstateAgent}
     * <p>
     * A sub property of participant. The real estate agent involved in the
     * action.
     *
     * @see <a href="http://schema.org/realEstateAgent">realEstateAgent</a>
     */
    public static final IRI realEstateAgent;

    /**
     * RealEstateAgent
     * <p>
     * {@code http://schema.org/RealEstateAgent}
     * <p>
     * A real-estate agent.
     *
     * @see <a href="http://schema.org/RealEstateAgent">RealEstateAgent</a>
     */
    public static final IRI RealEstateAgent;

    /**
     * ReceiveAction
     * <p>
     * {@code http://schema.org/ReceiveAction}
     * <p>
     * The act of physically/electronically taking delivery of an object
     * thathas been transferred from an origin to a destination. Reciprocal
     * of SendAction.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/SendAction&quot;&gt;SendAction&lt;/a&gt;:
     * The reciprocal of ReceiveAction.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/TakeAction&quot;&gt;TakeAction&lt;/a&gt;:
     * Unlike TakeAction, ReceiveAction does not imply that the ownership has
     * been transfered (e.g. I can receive a package, but it does not mean
     * the package is now mine).&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/ReceiveAction">ReceiveAction</a>
     */
    public static final IRI ReceiveAction;

    /**
     * Recipe
     * <p>
     * {@code http://schema.org/Recipe}
     * <p>
     * A recipe. For dietary restrictions covered by the recipe, a few common
     * restrictions are enumerated via &lt;a
     * href=&quot;http://schema.org/suitableForDiet&quot;&gt;suitableForDiet&lt;/a&gt;.
     * The &lt;a
     * href=&quot;http://schema.org/keywords&quot;&gt;keywords&lt;/a&gt;
     * property can also be used to add more detail.
     *
     * @see <a href="http://schema.org/Recipe">Recipe</a>
     */
    public static final IRI Recipe;

    /**
     * recipe
     * <p>
     * {@code http://schema.org/recipe}
     * <p>
     * A sub property of instrument. The recipe/instructions used to perform
     * the action.
     *
     * @see <a href="http://schema.org/recipe">recipe</a>
     */
    public static final IRI recipe;

    /**
     * recipeCategory
     * <p>
     * {@code http://schema.org/recipeCategory}
     * <p>
     * The category of the recipe—for example, appetizer, entree, etc.
     *
     * @see <a href="http://schema.org/recipeCategory">recipeCategory</a>
     */
    public static final IRI recipeCategory;

    /**
     * recipeCuisine
     * <p>
     * {@code http://schema.org/recipeCuisine}
     * <p>
     * The cuisine of the recipe (for example, French or Ethiopian).
     *
     * @see <a href="http://schema.org/recipeCuisine">recipeCuisine</a>
     */
    public static final IRI recipeCuisine;

    /**
     * recipeIngredient
     * <p>
     * {@code http://schema.org/recipeIngredient}
     * <p>
     * A single ingredient used in the recipe, e.g. sugar, flour or garlic.
     *
     * @see <a href="http://schema.org/recipeIngredient">recipeIngredient</a>
     */
    public static final IRI recipeIngredient;

    /**
     * recipeInstructions
     * <p>
     * {@code http://schema.org/recipeInstructions}
     * <p>
     * A step in making the recipe, in the form of a single item (document,
     * video, etc.) or an ordered list with HowToStep and/or HowToSection
     * items.
     *
     * @see <a href="http://schema.org/recipeInstructions">recipeInstructions</a>
     */
    public static final IRI recipeInstructions;

    /**
     * recipeYield
     * <p>
     * {@code http://schema.org/recipeYield}
     * <p>
     * The quantity produced by the recipe (for example, number of people
     * served, number of servings, etc).
     *
     * @see <a href="http://schema.org/recipeYield">recipeYield</a>
     */
    public static final IRI recipeYield;

    /**
     * recipient
     * <p>
     * {@code http://schema.org/recipient}
     * <p>
     * A sub property of participant. The participant who is at the receiving
     * end of the action.
     *
     * @see <a href="http://schema.org/recipient">recipient</a>
     */
    public static final IRI recipient;

    /**
     * recognizingAuthority
     * <p>
     * {@code http://schema.org/recognizingAuthority}
     * <p>
     * If applicable, the organization that officially recognizes this entity
     * as part of its endorsed system of medicine.
     *
     * @see <a href="http://schema.org/recognizingAuthority">recognizingAuthority</a>
     */
    public static final IRI recognizingAuthority;

    /**
     * recommendationStrength
     * <p>
     * {@code http://schema.org/recommendationStrength}
     * <p>
     * Strength of the guideline&#39;s recommendation (e.g. &#39;class
     * I&#39;).
     *
     * @see <a href="http://schema.org/recommendationStrength">recommendationStrength</a>
     */
    public static final IRI recommendationStrength;

    /**
     * RecommendedDoseSchedule
     * <p>
     * {@code http://schema.org/RecommendedDoseSchedule}
     * <p>
     * A recommended dosing schedule for a drug or supplement as prescribed
     * or recommended by an authority or by the drug/supplement&#39;s
     * manufacturer. Capture the recommending authority in the
     * recognizingAuthority property of MedicalEntity.
     *
     * @see <a href="http://schema.org/RecommendedDoseSchedule">RecommendedDoseSchedule</a>
     */
    public static final IRI RecommendedDoseSchedule;

    /**
     * recommendedIntake
     * <p>
     * {@code http://schema.org/recommendedIntake}
     * <p>
     * Recommended intake of this supplement for a given population as
     * defined by a specific recommending authority.
     *
     * @see <a href="http://schema.org/recommendedIntake">recommendedIntake</a>
     */
    public static final IRI recommendedIntake;

    /**
     * recordedAs
     * <p>
     * {@code http://schema.org/recordedAs}
     * <p>
     * An audio recording of the work.
     *
     * @see <a href="http://schema.org/recordedAs">recordedAs</a>
     */
    public static final IRI recordedAs;

    /**
     * recordedAt
     * <p>
     * {@code http://schema.org/recordedAt}
     * <p>
     * The Event where the CreativeWork was recorded. The CreativeWork may
     * capture all or part of the event.
     *
     * @see <a href="http://schema.org/recordedAt">recordedAt</a>
     */
    public static final IRI recordedAt;

    /**
     * recordedIn
     * <p>
     * {@code http://schema.org/recordedIn}
     * <p>
     * The CreativeWork that captured all or part of this Event.
     *
     * @see <a href="http://schema.org/recordedIn">recordedIn</a>
     */
    public static final IRI recordedIn;

    /**
     * recordingOf
     * <p>
     * {@code http://schema.org/recordingOf}
     * <p>
     * The composition this track is a recording of.
     *
     * @see <a href="http://schema.org/recordingOf">recordingOf</a>
     */
    public static final IRI recordingOf;

    /**
     * recordLabel
     * <p>
     * {@code http://schema.org/recordLabel}
     * <p>
     * The label that issued the release.
     *
     * @see <a href="http://schema.org/recordLabel">recordLabel</a>
     */
    public static final IRI recordLabel;

    /**
     * recourseLoan
     * <p>
     * {@code http://schema.org/recourseLoan}
     * <p>
     * The only way you get the money back in the event of default is the
     * security. Recourse is where you still have the opportunity to go back
     * to the borrower for the rest of the money.
     *
     * @see <a href="http://schema.org/recourseLoan">recourseLoan</a>
     */
    public static final IRI recourseLoan;

    /**
     * RecyclingCenter
     * <p>
     * {@code http://schema.org/RecyclingCenter}
     * <p>
     * A recycling center.
     *
     * @see <a href="http://schema.org/RecyclingCenter">RecyclingCenter</a>
     */
    public static final IRI RecyclingCenter;

    /**
     * referenceQuantity
     * <p>
     * {@code http://schema.org/referenceQuantity}
     * <p>
     * The reference quantity for which a certain price applies, e.g. 1 EUR
     * per 4 kWh of electricity. This property is a replacement for
     * unitOfMeasurement for the advanced cases where the price does not
     * relate to a standard unit.
     *
     * @see <a href="http://schema.org/referenceQuantity">referenceQuantity</a>
     */
    public static final IRI referenceQuantity;

    /**
     * referencesOrder
     * <p>
     * {@code http://schema.org/referencesOrder}
     * <p>
     * The Order(s) related to this Invoice. One or more Orders may be
     * combined into a single Invoice.
     *
     * @see <a href="http://schema.org/referencesOrder">referencesOrder</a>
     */
    public static final IRI referencesOrder;

    /**
     * regionDrained
     * <p>
     * {@code http://schema.org/regionDrained}
     * <p>
     * The anatomical or organ system drained by this vessel; generally
     * refers to a specific part of an organ.
     *
     * @see <a href="http://schema.org/regionDrained">regionDrained</a>
     */
    public static final IRI regionDrained;

    /**
     * regionsAllowed
     * <p>
     * {@code http://schema.org/regionsAllowed}
     * <p>
     * The regions where the media is allowed. If not specified, then
     * it&#39;s assumed to be allowed everywhere. Specify the countries in
     * &lt;a href=&quot;http://en.wikipedia.org/wiki/ISO_3166&quot;&gt;ISO
     * 3166 format&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/regionsAllowed">regionsAllowed</a>
     */
    public static final IRI regionsAllowed;

    /**
     * RegisterAction
     * <p>
     * {@code http://schema.org/RegisterAction}
     * <p>
     * The act of registering to be a user of a service, product or web
     * page.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/JoinAction&quot;&gt;JoinAction&lt;/a&gt;:
     * Unlike JoinAction, RegisterAction implies you are registering to be a
     * user of a service, &lt;em&gt;not&lt;/em&gt; a group/team of
     * people.&lt;/li&gt;
     * &lt;li&gt;[FollowAction]]: Unlike FollowAction,
     * RegisterAction doesn&#39;t imply that the agent is expecting to poll
     * for updates from the object.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/SubscribeAction&quot;&gt;SubscribeAction&lt;/a&gt;:
     * Unlike SubscribeAction, RegisterAction doesn&#39;t imply that the
     * agent is expecting updates from the object.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/RegisterAction">RegisterAction</a>
     */
    public static final IRI RegisterAction;

    /**
     * RejectAction
     * <p>
     * {@code http://schema.org/RejectAction}
     * <p>
     * The act of rejecting to/adopting an
     * object.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/AcceptAction&quot;&gt;AcceptAction&lt;/a&gt;:
     * The antonym of RejectAction.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/RejectAction">RejectAction</a>
     */
    public static final IRI RejectAction;

    /**
     * relatedAnatomy
     * <p>
     * {@code http://schema.org/relatedAnatomy}
     * <p>
     * Anatomical systems or structures that relate to the superficial
     * anatomy.
     *
     * @see <a href="http://schema.org/relatedAnatomy">relatedAnatomy</a>
     */
    public static final IRI relatedAnatomy;

    /**
     * relatedCondition
     * <p>
     * {@code http://schema.org/relatedCondition}
     * <p>
     * A medical condition associated with this anatomy.
     *
     * @see <a href="http://schema.org/relatedCondition">relatedCondition</a>
     */
    public static final IRI relatedCondition;

    /**
     * relatedDrug
     * <p>
     * {@code http://schema.org/relatedDrug}
     * <p>
     * Any other drug related to this one, for example commonly-prescribed
     * alternatives.
     *
     * @see <a href="http://schema.org/relatedDrug">relatedDrug</a>
     */
    public static final IRI relatedDrug;

    /**
     * relatedLink
     * <p>
     * {@code http://schema.org/relatedLink}
     * <p>
     * A link related to this web page, for example to other related web
     * pages.
     *
     * @see <a href="http://schema.org/relatedLink">relatedLink</a>
     */
    public static final IRI relatedLink;

    /**
     * relatedStructure
     * <p>
     * {@code http://schema.org/relatedStructure}
     * <p>
     * Related anatomical structure(s) that are not part of the system but
     * relate or connect to it, such as vascular bundles associated with an
     * organ system.
     *
     * @see <a href="http://schema.org/relatedStructure">relatedStructure</a>
     */
    public static final IRI relatedStructure;

    /**
     * relatedTherapy
     * <p>
     * {@code http://schema.org/relatedTherapy}
     * <p>
     * A medical therapy related to this anatomy.
     *
     * @see <a href="http://schema.org/relatedTherapy">relatedTherapy</a>
     */
    public static final IRI relatedTherapy;

    /**
     * relatedTo
     * <p>
     * {@code http://schema.org/relatedTo}
     * <p>
     * The most generic familial relation.
     *
     * @see <a href="http://schema.org/relatedTo">relatedTo</a>
     */
    public static final IRI relatedTo;

    /**
     * releaseDate
     * <p>
     * {@code http://schema.org/releaseDate}
     * <p>
     * The release date of a product or product model. This can be used to
     * distinguish the exact variant of a product.
     *
     * @see <a href="http://schema.org/releaseDate">releaseDate</a>
     */
    public static final IRI releaseDate;

    /**
     * releasedEvent
     * <p>
     * {@code http://schema.org/releasedEvent}
     * <p>
     * The place and time the release was issued, expressed as a
     * PublicationEvent.
     *
     * @see <a href="http://schema.org/releasedEvent">releasedEvent</a>
     */
    public static final IRI releasedEvent;

    /**
     * releaseNotes
     * <p>
     * {@code http://schema.org/releaseNotes}
     * <p>
     * Description of what changed in this version.
     *
     * @see <a href="http://schema.org/releaseNotes">releaseNotes</a>
     */
    public static final IRI releaseNotes;

    /**
     * releaseOf
     * <p>
     * {@code http://schema.org/releaseOf}
     * <p>
     * The album this is a release of.
     *
     * @see <a href="http://schema.org/releaseOf">releaseOf</a>
     */
    public static final IRI releaseOf;

    /**
     * relevantOccupation
     * <p>
     * {@code http://schema.org/relevantOccupation}
     * <p>
     * The Occupation for the JobPosting.
     *
     * @see <a href="http://schema.org/relevantOccupation">relevantOccupation</a>
     */
    public static final IRI relevantOccupation;

    /**
     * relevantSpecialty
     * <p>
     * {@code http://schema.org/relevantSpecialty}
     * <p>
     * If applicable, a medical specialty in which this entity is relevant.
     *
     * @see <a href="http://schema.org/relevantSpecialty">relevantSpecialty</a>
     */
    public static final IRI relevantSpecialty;

    /**
     * remainingAttendeeCapacity
     * <p>
     * {@code http://schema.org/remainingAttendeeCapacity}
     * <p>
     * The number of attendee places for an event that remain unallocated.
     *
     * @see <a href="http://schema.org/remainingAttendeeCapacity">remainingAttendeeCapacity</a>
     */
    public static final IRI remainingAttendeeCapacity;

    /**
     * renegotiableLoan
     * <p>
     * {@code http://schema.org/renegotiableLoan}
     * <p>
     * Whether the terms for payment of interest can be renegotiated during
     * the life of the loan.
     *
     * @see <a href="http://schema.org/renegotiableLoan">renegotiableLoan</a>
     */
    public static final IRI renegotiableLoan;

    /**
     * RentAction
     * <p>
     * {@code http://schema.org/RentAction}
     * <p>
     * The act of giving money in return for temporary use, but not
     * ownership, of an object such as a vehicle or property. For example, an
     * agent rents a property from a landlord in exchange for a periodic
     * payment.
     *
     * @see <a href="http://schema.org/RentAction">RentAction</a>
     */
    public static final IRI RentAction;

    /**
     * RentalCarReservation
     * <p>
     * {@code http://schema.org/RentalCarReservation}
     * <p>
     * A reservation for a rental car.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Note: This type
     * is for information about actual reservations, e.g. in confirmation
     * emails or HTML pages with individual confirmations of reservations.
     *
     * @see <a href="http://schema.org/RentalCarReservation">RentalCarReservation</a>
     */
    public static final IRI RentalCarReservation;

    /**
     * RepaymentSpecification
     * <p>
     * {@code http://schema.org/RepaymentSpecification}
     * <p>
     * A structured value representing repayment.
     *
     * @see <a href="http://schema.org/RepaymentSpecification">RepaymentSpecification</a>
     */
    public static final IRI RepaymentSpecification;

    /**
     * repeatCount
     * <p>
     * {@code http://schema.org/repeatCount}
     * <p>
     * Defines the number of times a recurring &lt;a
     * href=&quot;http://schema.org/Event&quot;&gt;Event&lt;/a&gt; will take
     * place
     *
     * @see <a href="http://schema.org/repeatCount">repeatCount</a>
     */
    public static final IRI repeatCount;

    /**
     * repeatFrequency
     * <p>
     * {@code http://schema.org/repeatFrequency}
     * <p>
     * Defines the frequency at which &lt;a
     * href=&quot;http://schema.org/Events&quot;&gt;Events&lt;/a&gt; will
     * occur according to a schedule &lt;a
     * href=&quot;http://schema.org/Schedule&quot;&gt;Schedule&lt;/a&gt;. The
     * intervals between
     * events should be defined as a &lt;a
     * href=&quot;http://schema.org/Duration&quot;&gt;Duration&lt;/a&gt; of
     * time.
     *
     * @see <a href="http://schema.org/repeatFrequency">repeatFrequency</a>
     */
    public static final IRI repeatFrequency;

    /**
     * repetitions
     * <p>
     * {@code http://schema.org/repetitions}
     * <p>
     * Number of times one should repeat the activity.
     *
     * @see <a href="http://schema.org/repetitions">repetitions</a>
     */
    public static final IRI repetitions;

    /**
     * ReplaceAction
     * <p>
     * {@code http://schema.org/ReplaceAction}
     * <p>
     * The act of editing a recipient by replacing an old object with a new
     * object.
     *
     * @see <a href="http://schema.org/ReplaceAction">ReplaceAction</a>
     */
    public static final IRI ReplaceAction;

    /**
     * replacee
     * <p>
     * {@code http://schema.org/replacee}
     * <p>
     * A sub property of object. The object that is being replaced.
     *
     * @see <a href="http://schema.org/replacee">replacee</a>
     */
    public static final IRI replacee;

    /**
     * replacer
     * <p>
     * {@code http://schema.org/replacer}
     * <p>
     * A sub property of object. The object that replaces.
     *
     * @see <a href="http://schema.org/replacer">replacer</a>
     */
    public static final IRI replacer;

    /**
     * ReplyAction
     * <p>
     * {@code http://schema.org/ReplyAction}
     * <p>
     * The act of responding to a question/message asked/sent by the object.
     * Related to &lt;a
     * href=&quot;http://schema.org/AskAction&quot;&gt;AskAction&lt;/a&gt;&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/AskAction&quot;&gt;AskAction&lt;/a&gt;:
     * Appears generally as an origin of a
     * ReplyAction.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/ReplyAction">ReplyAction</a>
     */
    public static final IRI ReplyAction;

    /**
     * replyToUrl
     * <p>
     * {@code http://schema.org/replyToUrl}
     * <p>
     * The URL at which a reply may be posted to the specified UserComment.
     *
     * @see <a href="http://schema.org/replyToUrl">replyToUrl</a>
     */
    public static final IRI replyToUrl;

    /**
     * Report
     * <p>
     * {@code http://schema.org/Report}
     * <p>
     * A Report generated by governmental or non-governmental organization.
     *
     * @see <a href="http://schema.org/Report">Report</a>
     */
    public static final IRI Report;

    /**
     * ReportageNewsArticle
     * <p>
     * {@code http://schema.org/ReportageNewsArticle}
     * <p>
     * The &lt;a
     * href=&quot;http://schema.org/ReportageNewsArticle&quot;&gt;ReportageNewsArticle&lt;/a&gt;
     * type is a subtype of &lt;a
     * href=&quot;http://schema.org/NewsArticle&quot;&gt;NewsArticle&lt;/a&gt;
     * representing
     * news articles which are the result of journalistic news
     * reporting conventions.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * In practice many news
     * publishers produce a wide variety of article types, many of which
     * might be considered a &lt;a
     * href=&quot;http://schema.org/NewsArticle&quot;&gt;NewsArticle&lt;/a&gt;
     * but not a &lt;a
     * href=&quot;http://schema.org/ReportageNewsArticle&quot;&gt;ReportageNewsArticle&lt;/a&gt;.
     * For example, opinion pieces, reviews, analysis, sponsored or satirical
     * articles, or articles that combine several of these
     * elements.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * The &lt;a
     * href=&quot;http://schema.org/ReportageNewsArticle&quot;&gt;ReportageNewsArticle&lt;/a&gt;
     * type is based on a stricter ideal for &quot;news&quot; as a work of
     * journalism, with articles based on factual information either observed
     * or verified by the author, or reported and verified from knowledgeable
     * sources.  This often includes perspectives from multiple viewpoints on
     * a particular issue (distinguishing news reports from public relations
     * or propaganda).  News reports in the &lt;a
     * href=&quot;http://schema.org/ReportageNewsArticle&quot;&gt;ReportageNewsArticle&lt;/a&gt;
     * sense de-emphasize the opinion of the author, with commentary and
     * value judgements typically expressed
     * elsewhere.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * A &lt;a
     * href=&quot;http://schema.org/ReportageNewsArticle&quot;&gt;ReportageNewsArticle&lt;/a&gt;
     * which goes deeper into analysis can also be marked with an additional
     * type of &lt;a
     * href=&quot;http://schema.org/AnalysisNewsArticle&quot;&gt;AnalysisNewsArticle&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/ReportageNewsArticle">ReportageNewsArticle</a>
     */
    public static final IRI ReportageNewsArticle;

    /**
     * ReportedDoseSchedule
     * <p>
     * {@code http://schema.org/ReportedDoseSchedule}
     * <p>
     * A patient-reported or observed dosing schedule for a drug or
     * supplement.
     *
     * @see <a href="http://schema.org/ReportedDoseSchedule">ReportedDoseSchedule</a>
     */
    public static final IRI ReportedDoseSchedule;

    /**
     * reportNumber
     * <p>
     * {@code http://schema.org/reportNumber}
     * <p>
     * The number or other unique designator assigned to a Report by the
     * publishing organization.
     *
     * @see <a href="http://schema.org/reportNumber">reportNumber</a>
     */
    public static final IRI reportNumber;

    /**
     * representativeOfPage
     * <p>
     * {@code http://schema.org/representativeOfPage}
     * <p>
     * Indicates whether this image is representative of the content of the
     * page.
     *
     * @see <a href="http://schema.org/representativeOfPage">representativeOfPage</a>
     */
    public static final IRI representativeOfPage;

    /**
     * requiredCollateral
     * <p>
     * {@code http://schema.org/requiredCollateral}
     * <p>
     * Assets required to secure loan or credit repayments. It may take form
     * of third party pledge, goods, financial instruments (cash, securities,
     * etc.)
     *
     * @see <a href="http://schema.org/requiredCollateral">requiredCollateral</a>
     */
    public static final IRI requiredCollateral;

    /**
     * requiredGender
     * <p>
     * {@code http://schema.org/requiredGender}
     * <p>
     * Audiences defined by a person&#39;s gender.
     *
     * @see <a href="http://schema.org/requiredGender">requiredGender</a>
     */
    public static final IRI requiredGender;

    /**
     * requiredMaxAge
     * <p>
     * {@code http://schema.org/requiredMaxAge}
     * <p>
     * Audiences defined by a person&#39;s maximum age.
     *
     * @see <a href="http://schema.org/requiredMaxAge">requiredMaxAge</a>
     */
    public static final IRI requiredMaxAge;

    /**
     * requiredMinAge
     * <p>
     * {@code http://schema.org/requiredMinAge}
     * <p>
     * Audiences defined by a person&#39;s minimum age.
     *
     * @see <a href="http://schema.org/requiredMinAge">requiredMinAge</a>
     */
    public static final IRI requiredMinAge;

    /**
     * requiredQuantity
     * <p>
     * {@code http://schema.org/requiredQuantity}
     * <p>
     * The required quantity of the item(s).
     *
     * @see <a href="http://schema.org/requiredQuantity">requiredQuantity</a>
     */
    public static final IRI requiredQuantity;

    /**
     * requirements
     * <p>
     * {@code http://schema.org/requirements}
     * <p>
     * Component dependency requirements for application. This includes
     * runtime environments and shared libraries that are not included in the
     * application distribution package, but required to run the application
     * (Examples: DirectX, Java or .NET runtime).
     *
     * @see <a href="http://schema.org/requirements">requirements</a>
     */
    public static final IRI requirements;

    /**
     * requiresSubscription
     * <p>
     * {@code http://schema.org/requiresSubscription}
     * <p>
     * Indicates if use of the media require a subscription  (either paid or
     * free). Allowed values are &lt;code&gt;true&lt;/code&gt; or
     * &lt;code&gt;false&lt;/code&gt; (note that an earlier version had
     * &#39;yes&#39;, &#39;no&#39;).
     *
     * @see <a href="http://schema.org/requiresSubscription">requiresSubscription</a>
     */
    public static final IRI requiresSubscription;

    /**
     * Reservation
     * <p>
     * {@code http://schema.org/Reservation}
     * <p>
     * Describes a reservation for travel, dining or an event. Some
     * reservations require tickets. &lt;br/&gt;&lt;br/&gt;
     * <p>
     * Note: This type
     * is for information about actual reservations, e.g. in confirmation
     * emails or HTML pages with individual confirmations of reservations.
     * For offers of tickets, restaurant reservations, flights, or rental
     * cars, use &lt;a
     * href=&quot;http://schema.org/Offer&quot;&gt;Offer&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Reservation">Reservation</a>
     */
    public static final IRI Reservation;

    /**
     * reservationFor
     * <p>
     * {@code http://schema.org/reservationFor}
     * <p>
     * The thing -- flight, event, restaurant,etc. being reserved.
     *
     * @see <a href="http://schema.org/reservationFor">reservationFor</a>
     */
    public static final IRI reservationFor;

    /**
     * reservationId
     * <p>
     * {@code http://schema.org/reservationId}
     * <p>
     * A unique identifier for the reservation.
     *
     * @see <a href="http://schema.org/reservationId">reservationId</a>
     */
    public static final IRI reservationId;

    /**
     * ReservationPackage
     * <p>
     * {@code http://schema.org/ReservationPackage}
     * <p>
     * A group of multiple reservations with common values for all
     * sub-reservations.
     *
     * @see <a href="http://schema.org/ReservationPackage">ReservationPackage</a>
     */
    public static final IRI ReservationPackage;

    /**
     * reservationStatus
     * <p>
     * {@code http://schema.org/reservationStatus}
     * <p>
     * The current status of the reservation.
     *
     * @see <a href="http://schema.org/reservationStatus">reservationStatus</a>
     */
    public static final IRI reservationStatus;

    /**
     * ReservationStatusType
     * <p>
     * {@code http://schema.org/ReservationStatusType}
     * <p>
     * Enumerated status values for Reservation.
     *
     * @see <a href="http://schema.org/ReservationStatusType">ReservationStatusType</a>
     */
    public static final IRI ReservationStatusType;

    /**
     * ReserveAction
     * <p>
     * {@code http://schema.org/ReserveAction}
     * <p>
     * Reserving a concrete object.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/ScheduleAction&quot;&gt;ScheduleAction&lt;/a&gt;&lt;/a&gt;:
     * Unlike ScheduleAction, ReserveAction reserves concrete objects (e.g. a
     * table, a hotel) towards a time slot / spatial
     * allocation.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/ReserveAction">ReserveAction</a>
     */
    public static final IRI ReserveAction;

    /**
     * reservedTicket
     * <p>
     * {@code http://schema.org/reservedTicket}
     * <p>
     * A ticket associated with the reservation.
     *
     * @see <a href="http://schema.org/reservedTicket">reservedTicket</a>
     */
    public static final IRI reservedTicket;

    /**
     * Reservoir
     * <p>
     * {@code http://schema.org/Reservoir}
     * <p>
     * A reservoir of water, typically an artificially created lake, like the
     * Lake Kariba reservoir.
     *
     * @see <a href="http://schema.org/Reservoir">Reservoir</a>
     */
    public static final IRI Reservoir;

    /**
     * Residence
     * <p>
     * {@code http://schema.org/Residence}
     * <p>
     * The place where a person lives.
     *
     * @see <a href="http://schema.org/Residence">Residence</a>
     */
    public static final IRI Residence;

    /**
     * Resort
     * <p>
     * {@code http://schema.org/Resort}
     * <p>
     * A resort is a place used for relaxation or recreation, attracting
     * visitors for holidays or vacations. Resorts are places, towns or
     * sometimes commercial establishment operated by a single company
     * (Source: Wikipedia, the free encyclopedia, see &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/Resort&quot;&gt;http://en.wikipedia.org/wiki/Resort&lt;/a&gt;).
     * &lt;br
     * /&gt;&lt;br /&gt;
     * See also the &lt;a
     * href=&quot;/docs/hotels.html&quot;&gt;dedicated document on the use of
     * schema.org for marking up hotels and other forms of
     * accommodations&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Resort">Resort</a>
     */
    public static final IRI Resort;

    /**
     * responsibilities
     * <p>
     * {@code http://schema.org/responsibilities}
     * <p>
     * Responsibilities associated with this role.
     *
     * @see <a href="http://schema.org/responsibilities">responsibilities</a>
     */
    public static final IRI responsibilities;

    /**
     * Restaurant
     * <p>
     * {@code http://schema.org/Restaurant}
     * <p>
     * A restaurant.
     *
     * @see <a href="http://schema.org/Restaurant">Restaurant</a>
     */
    public static final IRI Restaurant;

    /**
     * restPeriods
     * <p>
     * {@code http://schema.org/restPeriods}
     * <p>
     * How often one should break from the activity.
     *
     * @see <a href="http://schema.org/restPeriods">restPeriods</a>
     */
    public static final IRI restPeriods;

    /**
     * RestrictedDiet
     * <p>
     * {@code http://schema.org/RestrictedDiet}
     * <p>
     * A diet restricted to certain foods or preparations for cultural,
     * religious, health or lifestyle reasons.
     *
     * @see <a href="http://schema.org/RestrictedDiet">RestrictedDiet</a>
     */
    public static final IRI RestrictedDiet;

    /**
     * result
     * <p>
     * {@code http://schema.org/result}
     * <p>
     * The result produced in the action. e.g. John wrote &lt;em&gt;a
     * book&lt;/em&gt;.
     *
     * @see <a href="http://schema.org/result">result</a>
     */
    public static final IRI result;

    /**
     * resultComment
     * <p>
     * {@code http://schema.org/resultComment}
     * <p>
     * A sub property of result. The Comment created or sent as a result of
     * this action.
     *
     * @see <a href="http://schema.org/resultComment">resultComment</a>
     */
    public static final IRI resultComment;

    /**
     * resultReview
     * <p>
     * {@code http://schema.org/resultReview}
     * <p>
     * A sub property of result. The review that resulted in the performing
     * of the action.
     *
     * @see <a href="http://schema.org/resultReview">resultReview</a>
     */
    public static final IRI resultReview;

    /**
     * ResumeAction
     * <p>
     * {@code http://schema.org/ResumeAction}
     * <p>
     * The act of resuming a device or application which was formerly paused
     * (e.g. resume music playback or resume a timer).
     *
     * @see <a href="http://schema.org/ResumeAction">ResumeAction</a>
     */
    public static final IRI ResumeAction;

    /**
     * ReturnAction
     * <p>
     * {@code http://schema.org/ReturnAction}
     * <p>
     * The act of returning to the origin that which was previously received
     * (concrete objects) or taken (ownership).
     *
     * @see <a href="http://schema.org/ReturnAction">ReturnAction</a>
     */
    public static final IRI ReturnAction;

    /**
     * Review
     * <p>
     * {@code http://schema.org/Review}
     * <p>
     * A review of an item - for example, of a restaurant, movie, or store.
     *
     * @see <a href="http://schema.org/Review">Review</a>
     */
    public static final IRI Review;

    /**
     * review
     * <p>
     * {@code http://schema.org/review}
     * <p>
     * A review of the item.
     *
     * @see <a href="http://schema.org/review">review</a>
     */
    public static final IRI review;

    /**
     * ReviewAction
     * <p>
     * {@code http://schema.org/ReviewAction}
     * <p>
     * The act of producing a balanced opinion about the object for an
     * audience. An agent reviews an object with participants resulting in a
     * review.
     *
     * @see <a href="http://schema.org/ReviewAction">ReviewAction</a>
     */
    public static final IRI ReviewAction;

    /**
     * reviewAspect
     * <p>
     * {@code http://schema.org/reviewAspect}
     * <p>
     * This Review or Rating is relevant to this part or facet of the
     * itemReviewed.
     *
     * @see <a href="http://schema.org/reviewAspect">reviewAspect</a>
     */
    public static final IRI reviewAspect;

    /**
     * reviewBody
     * <p>
     * {@code http://schema.org/reviewBody}
     * <p>
     * The actual body of the review.
     *
     * @see <a href="http://schema.org/reviewBody">reviewBody</a>
     */
    public static final IRI reviewBody;

    /**
     * reviewCount
     * <p>
     * {@code http://schema.org/reviewCount}
     * <p>
     * The count of total number of reviews.
     *
     * @see <a href="http://schema.org/reviewCount">reviewCount</a>
     */
    public static final IRI reviewCount;

    /**
     * reviewedBy
     * <p>
     * {@code http://schema.org/reviewedBy}
     * <p>
     * People or organizations that have reviewed the content on this web
     * page for accuracy and/or completeness.
     *
     * @see <a href="http://schema.org/reviewedBy">reviewedBy</a>
     */
    public static final IRI reviewedBy;

    /**
     * ReviewNewsArticle
     * <p>
     * {@code http://schema.org/ReviewNewsArticle}
     * <p>
     * A &lt;a
     * href=&quot;http://schema.org/NewsArticle&quot;&gt;NewsArticle&lt;/a&gt;
     * and &lt;a
     * href=&quot;http://schema.org/CriticReview&quot;&gt;CriticReview&lt;/a&gt;
     * providing a professional critic&#39;s assessment of a service,
     * product, performance, or artistic or literary work.
     *
     * @see <a href="http://schema.org/ReviewNewsArticle">ReviewNewsArticle</a>
     */
    public static final IRI ReviewNewsArticle;

    /**
     * reviewRating
     * <p>
     * {@code http://schema.org/reviewRating}
     * <p>
     * The rating given in this review. Note that reviews can themselves be
     * rated. The &lt;code&gt;reviewRating&lt;/code&gt; applies to rating
     * given by the review. The &lt;a
     * href=&quot;http://schema.org/aggregateRating&quot;&gt;aggregateRating&lt;/a&gt;
     * property applies to the review itself, as a creative work.
     *
     * @see <a href="http://schema.org/reviewRating">reviewRating</a>
     */
    public static final IRI reviewRating;

    /**
     * reviews
     * <p>
     * {@code http://schema.org/reviews}
     * <p>
     * Review of the item.
     *
     * @see <a href="http://schema.org/reviews">reviews</a>
     */
    public static final IRI reviews;

    /**
     * riskFactor
     * <p>
     * {@code http://schema.org/riskFactor}
     * <p>
     * A modifiable or non-modifiable factor that increases the risk of a
     * patient contracting this condition, e.g. age,  coexisting condition.
     *
     * @see <a href="http://schema.org/riskFactor">riskFactor</a>
     */
    public static final IRI riskFactor;

    /**
     * risks
     * <p>
     * {@code http://schema.org/risks}
     * <p>
     * Specific physiologic risks associated to the diet plan.
     *
     * @see <a href="http://schema.org/risks">risks</a>
     */
    public static final IRI risks;

    /**
     * RiverBodyOfWater
     * <p>
     * {@code http://schema.org/RiverBodyOfWater}
     * <p>
     * A river (for example, the broad majestic Shannon).
     *
     * @see <a href="http://schema.org/RiverBodyOfWater">RiverBodyOfWater</a>
     */
    public static final IRI RiverBodyOfWater;

    /**
     * Role
     * <p>
     * {@code http://schema.org/Role}
     * <p>
     * Represents additional information about a relationship or property.
     * For example a Role can be used to say that a &#39;member&#39; role
     * linking some SportsTeam to a player occurred during a particular time
     * period. Or that a Person&#39;s &#39;actor&#39; role in a Movie was for
     * some particular characterName. Such properties can be attached to a
     * Role entity, which is then associated with the main entities using
     * ordinary properties like &#39;member&#39; or
     * &#39;actor&#39;.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * See also &lt;a
     * href=&quot;http://blog.schema.org/2014/06/introducing-role.html&quot;&gt;blog
     * post&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Role">Role</a>
     */
    public static final IRI Role;

    /**
     * roleName
     * <p>
     * {@code http://schema.org/roleName}
     * <p>
     * A role played, performed or filled by a person or organization. For
     * example, the team of creators for a comic book might fill the roles
     * named &#39;inker&#39;, &#39;penciller&#39;, and &#39;letterer&#39;; or
     * an athlete in a SportsTeam might play in the position named
     * &#39;Quarterback&#39;.
     *
     * @see <a href="http://schema.org/roleName">roleName</a>
     */
    public static final IRI roleName;

    /**
     * RoofingContractor
     * <p>
     * {@code http://schema.org/RoofingContractor}
     * <p>
     * A roofing contractor.
     *
     * @see <a href="http://schema.org/RoofingContractor">RoofingContractor</a>
     */
    public static final IRI RoofingContractor;

    /**
     * roofLoad
     * <p>
     * {@code http://schema.org/roofLoad}
     * <p>
     * The permitted total weight of cargo and installations (e.g. a roof
     * rack) on top of the vehicle.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit
     * code(s): KGM for kilogram, LBR for
     * pound&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;Note 1: You can
     * indicate additional information in the &lt;a
     * href=&quot;http://schema.org/name&quot;&gt;name&lt;/a&gt; of the &lt;a
     * href=&quot;http://schema.org/QuantitativeValue&quot;&gt;QuantitativeValue&lt;/a&gt;
     * node.&lt;/li&gt;
     * &lt;li&gt;Note 2: You may also link to a &lt;a
     * href=&quot;http://schema.org/QualitativeValue&quot;&gt;QualitativeValue&lt;/a&gt;
     * node that provides additional information using &lt;a
     * href=&quot;http://schema.org/valueReference&quot;&gt;valueReference&lt;/a&gt;&lt;/li&gt;
     * &lt;li&gt;Note
     * 3: Note that you can use &lt;a
     * href=&quot;http://schema.org/minValue&quot;&gt;minValue&lt;/a&gt; and
     * &lt;a
     * href=&quot;http://schema.org/maxValue&quot;&gt;maxValue&lt;/a&gt; to
     * indicate ranges.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/roofLoad">roofLoad</a>
     */
    public static final IRI roofLoad;

    /**
     * Room
     * <p>
     * {@code http://schema.org/Room}
     * <p>
     * A room is a distinguishable space within a structure, usually
     * separated from other spaces by interior walls. (Source: Wikipedia, the
     * free encyclopedia, see &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/Room&quot;&gt;http://en.wikipedia.org/wiki/Room&lt;/a&gt;).
     * &lt;br
     * /&gt;&lt;br /&gt;
     * See also the &lt;a
     * href=&quot;/docs/hotels.html&quot;&gt;dedicated document on the use of
     * schema.org for marking up hotels and other forms of
     * accommodations&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Room">Room</a>
     */
    public static final IRI Room;

    /**
     * RsvpAction
     * <p>
     * {@code http://schema.org/RsvpAction}
     * <p>
     * The act of notifying an event organizer as to whether you expect to
     * attend the event.
     *
     * @see <a href="http://schema.org/RsvpAction">RsvpAction</a>
     */
    public static final IRI RsvpAction;

    /**
     * rsvpResponse
     * <p>
     * {@code http://schema.org/rsvpResponse}
     * <p>
     * The response (yes, no, maybe) to the RSVP.
     *
     * @see <a href="http://schema.org/rsvpResponse">rsvpResponse</a>
     */
    public static final IRI rsvpResponse;

    /**
     * RsvpResponseType
     * <p>
     * {@code http://schema.org/RsvpResponseType}
     * <p>
     * RsvpResponseType is an enumeration type whose instances represent
     * responding to an RSVP request.
     *
     * @see <a href="http://schema.org/RsvpResponseType">RsvpResponseType</a>
     */
    public static final IRI RsvpResponseType;

    /**
     * runsTo
     * <p>
     * {@code http://schema.org/runsTo}
     * <p>
     * The vasculature the lymphatic structure runs, or efferents, to.
     *
     * @see <a href="http://schema.org/runsTo">runsTo</a>
     */
    public static final IRI runsTo;

    /**
     * runtime
     * <p>
     * {@code http://schema.org/runtime}
     * <p>
     * Runtime platform or script interpreter dependencies (Example - Java
     * v1, Python2.3, .Net Framework 3.0).
     *
     * @see <a href="http://schema.org/runtime">runtime</a>
     */
    public static final IRI runtime;

    /**
     * runtimePlatform
     * <p>
     * {@code http://schema.org/runtimePlatform}
     * <p>
     * Runtime platform or script interpreter dependencies (Example - Java
     * v1, Python2.3, .Net Framework 3.0).
     *
     * @see <a href="http://schema.org/runtimePlatform">runtimePlatform</a>
     */
    public static final IRI runtimePlatform;

    /**
     * RVPark
     * <p>
     * {@code http://schema.org/RVPark}
     * <p>
     * A place offering space for &quot;Recreational Vehicles&quot;,
     * Caravans, mobile homes and the like.
     *
     * @see <a href="http://schema.org/RVPark">RVPark</a>
     */
    public static final IRI RVPark;

    /**
     * rxcui
     * <p>
     * {@code http://schema.org/rxcui}
     * <p>
     * The RxCUI drug identifier from RXNORM.
     *
     * @see <a href="http://schema.org/rxcui">rxcui</a>
     */
    public static final IRI rxcui;

    /**
     * safetyConsideration
     * <p>
     * {@code http://schema.org/safetyConsideration}
     * <p>
     * Any potential safety concern associated with the supplement. May
     * include interactions with other drugs and foods, pregnancy,
     * breastfeeding, known adverse reactions, and documented efficacy of the
     * supplement.
     *
     * @see <a href="http://schema.org/safetyConsideration">safetyConsideration</a>
     */
    public static final IRI safetyConsideration;

    /**
     * salaryCurrency
     * <p>
     * {@code http://schema.org/salaryCurrency}
     * <p>
     * The currency (coded using &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/ISO_4217&quot;&gt;ISO
     * 4217&lt;/a&gt; ) used for the main salary information in this job
     * posting or for this employee.
     *
     * @see <a href="http://schema.org/salaryCurrency">salaryCurrency</a>
     */
    public static final IRI salaryCurrency;

    /**
     * SaleEvent
     * <p>
     * {@code http://schema.org/SaleEvent}
     * <p>
     * Event type: Sales event.
     *
     * @see <a href="http://schema.org/SaleEvent">SaleEvent</a>
     */
    public static final IRI SaleEvent;

    /**
     * sameAs
     * <p>
     * {@code http://schema.org/sameAs}
     * <p>
     * URL of a reference Web page that unambiguously indicates the
     * item&#39;s identity. E.g. the URL of the item&#39;s Wikipedia page,
     * Wikidata entry, or official website.
     *
     * @see <a href="http://schema.org/sameAs">sameAs</a>
     */
    public static final IRI sameAs;

    /**
     * sampleType
     * <p>
     * {@code http://schema.org/sampleType}
     * <p>
     * What type of code sample: full (compile ready) solution, code snippet,
     * inline code, scripts, template.
     *
     * @see <a href="http://schema.org/sampleType">sampleType</a>
     */
    public static final IRI sampleType;

    /**
     * SatiricalArticle
     * <p>
     * {@code http://schema.org/SatiricalArticle}
     * <p>
     * An &lt;a
     * href=&quot;http://schema.org/Article&quot;&gt;Article&lt;/a&gt; whose
     * content is primarily &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/Satire&quot;&gt;[satirical]&lt;/a&gt;
     * in nature, i.e. unlikely to be literally true. A satirical article is
     * sometimes but not necessarily also a &lt;a
     * href=&quot;http://schema.org/NewsArticle&quot;&gt;NewsArticle&lt;/a&gt;.
     * &lt;a
     * href=&quot;http://schema.org/ScholarlyArticle&quot;&gt;ScholarlyArticle&lt;/a&gt;s
     * are also sometimes satirized.
     *
     * @see <a href="http://schema.org/SatiricalArticle">SatiricalArticle</a>
     */
    public static final IRI SatiricalArticle;

    /**
     * saturatedFatContent
     * <p>
     * {@code http://schema.org/saturatedFatContent}
     * <p>
     * The number of grams of saturated fat.
     *
     * @see <a href="http://schema.org/saturatedFatContent">saturatedFatContent</a>
     */
    public static final IRI saturatedFatContent;

    /**
     * Schedule
     * <p>
     * {@code http://schema.org/Schedule}
     * <p>
     * A schedule defines a repeating time period used to describe a
     * regularly occurring &lt;a
     * href=&quot;http://schema.org/Event&quot;&gt;Event&lt;/a&gt;. At a
     * minimum a schedule will specify &lt;a
     * href=&quot;http://schema.org/repeatFrequency&quot;&gt;repeatFrequency&lt;/a&gt;
     * which describes the interval between occurences of the event.
     * Additional information can be provided to specify the schedule more
     * precisely.
     * This includes identifying the day(s) of the week or
     * month when the recurring event will take place, in addition to its
     * start and end time. Schedules may also
     * have start and end dates
     * to indicate when they are active, e.g. to define a limited calendar of
     * events.
     *
     * @see <a href="http://schema.org/Schedule">Schedule</a>
     */
    public static final IRI Schedule;

    /**
     * ScheduleAction
     * <p>
     * {@code http://schema.org/ScheduleAction}
     * <p>
     * Scheduling future actions, events, or
     * tasks.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/ReserveAction&quot;&gt;ReserveAction&lt;/a&gt;:
     * Unlike ReserveAction, ScheduleAction allocates future actions (e.g. an
     * event, a task, etc) towards a time slot / spatial
     * allocation.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/ScheduleAction">ScheduleAction</a>
     */
    public static final IRI ScheduleAction;

    /**
     * scheduledPaymentDate
     * <p>
     * {@code http://schema.org/scheduledPaymentDate}
     * <p>
     * The date the invoice is scheduled to be paid.
     *
     * @see <a href="http://schema.org/scheduledPaymentDate">scheduledPaymentDate</a>
     */
    public static final IRI scheduledPaymentDate;

    /**
     * scheduledTime
     * <p>
     * {@code http://schema.org/scheduledTime}
     * <p>
     * The time the object is scheduled to.
     *
     * @see <a href="http://schema.org/scheduledTime">scheduledTime</a>
     */
    public static final IRI scheduledTime;

    /**
     * schemaVersion
     * <p>
     * {@code http://schema.org/schemaVersion}
     * <p>
     * Indicates (by URL or string) a particular version of a schema used in
     * some CreativeWork. For example, a document could declare a
     * schemaVersion using an URL such as http://schema.org/version/2.0/ if
     * precise indication of schema version was required by some application.
     *
     * @see <a href="http://schema.org/schemaVersion">schemaVersion</a>
     */
    public static final IRI schemaVersion;

    /**
     * ScholarlyArticle
     * <p>
     * {@code http://schema.org/ScholarlyArticle}
     * <p>
     * A scholarly article.
     *
     * @see <a href="http://schema.org/ScholarlyArticle">ScholarlyArticle</a>
     */
    public static final IRI ScholarlyArticle;

    /**
     * School
     * <p>
     * {@code http://schema.org/School}
     * <p>
     * A school.
     *
     * @see <a href="http://schema.org/School">School</a>
     */
    public static final IRI School;

    /**
     * screenCount
     * <p>
     * {@code http://schema.org/screenCount}
     * <p>
     * The number of screens in the movie theater.
     *
     * @see <a href="http://schema.org/screenCount">screenCount</a>
     */
    public static final IRI screenCount;

    /**
     * ScreeningEvent
     * <p>
     * {@code http://schema.org/ScreeningEvent}
     * <p>
     * A screening of a movie or other video.
     *
     * @see <a href="http://schema.org/ScreeningEvent">ScreeningEvent</a>
     */
    public static final IRI ScreeningEvent;

    /**
     * screenshot
     * <p>
     * {@code http://schema.org/screenshot}
     * <p>
     * A link to a screenshot image of the app.
     *
     * @see <a href="http://schema.org/screenshot">screenshot</a>
     */
    public static final IRI screenshot;

    /**
     * Sculpture
     * <p>
     * {@code http://schema.org/Sculpture}
     * <p>
     * A piece of sculpture.
     *
     * @see <a href="http://schema.org/Sculpture">Sculpture</a>
     */
    public static final IRI Sculpture;

    /**
     * sdDatePublished
     * <p>
     * {@code http://schema.org/sdDatePublished}
     * <p>
     * Indicates the date on which the current structured data was generated
     * / published. Typically used alongside &lt;a
     * href=&quot;http://schema.org/sdPublisher&quot;&gt;sdPublisher&lt;/a&gt;
     *
     * @see <a href="http://schema.org/sdDatePublished">sdDatePublished</a>
     */
    public static final IRI sdDatePublished;

    /**
     * sdLicense
     * <p>
     * {@code http://schema.org/sdLicense}
     * <p>
     * A license document that applies to this structured data, typically
     * indicated by URL.
     *
     * @see <a href="http://schema.org/sdLicense">sdLicense</a>
     */
    public static final IRI sdLicense;

    /**
     * sdPublisher
     * <p>
     * {@code http://schema.org/sdPublisher}
     * <p>
     * Indicates the party responsible for generating and publishing the
     * current structured data markup, typically in cases where the
     * structured data is derived automatically from existing published
     * content but published on a different site. For example, student
     * projects and open data initiatives often re-publish existing content
     * with more explicitly structured metadata. The
     * &lt;a
     * href=&quot;http://schema.org/sdPublisher&quot;&gt;sdPublisher&lt;/a&gt;
     * property helps make such practices more explicit.
     *
     * @see <a href="http://schema.org/sdPublisher">sdPublisher</a>
     */
    public static final IRI sdPublisher;

    /**
     * SeaBodyOfWater
     * <p>
     * {@code http://schema.org/SeaBodyOfWater}
     * <p>
     * A sea (for example, the Caspian sea).
     *
     * @see <a href="http://schema.org/SeaBodyOfWater">SeaBodyOfWater</a>
     */
    public static final IRI SeaBodyOfWater;

    /**
     * SearchAction
     * <p>
     * {@code http://schema.org/SearchAction}
     * <p>
     * The act of searching for an object.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/FindAction&quot;&gt;FindAction&lt;/a&gt;:
     * SearchAction generally leads to a FindAction, but not
     * necessarily.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/SearchAction">SearchAction</a>
     */
    public static final IRI SearchAction;

    /**
     * SearchResultsPage
     * <p>
     * {@code http://schema.org/SearchResultsPage}
     * <p>
     * Web page type: Search results page.
     *
     * @see <a href="http://schema.org/SearchResultsPage">SearchResultsPage</a>
     */
    public static final IRI SearchResultsPage;

    /**
     * season
     * <p>
     * {@code http://schema.org/season}
     * <p>
     * A season in a media series.
     *
     * @see <a href="http://schema.org/season">season</a>
     */
    public static final IRI season;

    /**
     * Season
     * <p>
     * {@code http://schema.org/Season}
     * <p>
     * A media season e.g. tv, radio, video game etc.
     *
     * @see <a href="http://schema.org/Season">Season</a>
     */
    public static final IRI Season;

    /**
     * seasonNumber
     * <p>
     * {@code http://schema.org/seasonNumber}
     * <p>
     * Position of the season within an ordered group of seasons.
     *
     * @see <a href="http://schema.org/seasonNumber">seasonNumber</a>
     */
    public static final IRI seasonNumber;

    /**
     * seasons
     * <p>
     * {@code http://schema.org/seasons}
     * <p>
     * A season in a media series.
     *
     * @see <a href="http://schema.org/seasons">seasons</a>
     */
    public static final IRI seasons;

    /**
     * Seat
     * <p>
     * {@code http://schema.org/Seat}
     * <p>
     * Used to describe a seat, such as a reserved seat in an event
     * reservation.
     *
     * @see <a href="http://schema.org/Seat">Seat</a>
     */
    public static final IRI Seat;

    /**
     * seatingCapacity
     * <p>
     * {@code http://schema.org/seatingCapacity}
     * <p>
     * The number of persons that can be seated (e.g. in a vehicle), both in
     * terms of the physical space available, and in terms of limitations set
     * by law.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s): C62 for persons
     *
     * @see <a href="http://schema.org/seatingCapacity">seatingCapacity</a>
     */
    public static final IRI seatingCapacity;

    /**
     * seatingType
     * <p>
     * {@code http://schema.org/seatingType}
     * <p>
     * The type/class of the seat.
     *
     * @see <a href="http://schema.org/seatingType">seatingType</a>
     */
    public static final IRI seatingType;

    /**
     * seatNumber
     * <p>
     * {@code http://schema.org/seatNumber}
     * <p>
     * The location of the reserved seat (e.g., 27).
     *
     * @see <a href="http://schema.org/seatNumber">seatNumber</a>
     */
    public static final IRI seatNumber;

    /**
     * seatRow
     * <p>
     * {@code http://schema.org/seatRow}
     * <p>
     * The row location of the reserved seat (e.g., B).
     *
     * @see <a href="http://schema.org/seatRow">seatRow</a>
     */
    public static final IRI seatRow;

    /**
     * seatSection
     * <p>
     * {@code http://schema.org/seatSection}
     * <p>
     * The section location of the reserved seat (e.g. Orchestra).
     *
     * @see <a href="http://schema.org/seatSection">seatSection</a>
     */
    public static final IRI seatSection;

    /**
     * secondaryPrevention
     * <p>
     * {@code http://schema.org/secondaryPrevention}
     * <p>
     * A preventative therapy used to prevent reoccurrence of the medical
     * condition after an initial episode of the condition.
     *
     * @see <a href="http://schema.org/secondaryPrevention">secondaryPrevention</a>
     */
    public static final IRI secondaryPrevention;

    /**
     * securityScreening
     * <p>
     * {@code http://schema.org/securityScreening}
     * <p>
     * The type of security screening the passenger is subject to.
     *
     * @see <a href="http://schema.org/securityScreening">securityScreening</a>
     */
    public static final IRI securityScreening;

    /**
     * seeks
     * <p>
     * {@code http://schema.org/seeks}
     * <p>
     * A pointer to products or services sought by the organization or person
     * (demand).
     *
     * @see <a href="http://schema.org/seeks">seeks</a>
     */
    public static final IRI seeks;

    /**
     * SelfStorage
     * <p>
     * {@code http://schema.org/SelfStorage}
     * <p>
     * A self-storage facility.
     *
     * @see <a href="http://schema.org/SelfStorage">SelfStorage</a>
     */
    public static final IRI SelfStorage;

    /**
     * SellAction
     * <p>
     * {@code http://schema.org/SellAction}
     * <p>
     * The act of taking money from a buyer in exchange for goods or services
     * rendered. An agent sells an object, product, or service to a buyer for
     * a price. Reciprocal of BuyAction.
     *
     * @see <a href="http://schema.org/SellAction">SellAction</a>
     */
    public static final IRI SellAction;

    /**
     * seller
     * <p>
     * {@code http://schema.org/seller}
     * <p>
     * An entity which offers (sells / leases / lends / loans) the services /
     * goods.  A seller may also be a provider.
     *
     * @see <a href="http://schema.org/seller">seller</a>
     */
    public static final IRI seller;

    /**
     * SendAction
     * <p>
     * {@code http://schema.org/SendAction}
     * <p>
     * The act of physically/electronically dispatching an object for
     * transfer from an origin to a destination.Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/ReceiveAction&quot;&gt;ReceiveAction&lt;/a&gt;:
     * The reciprocal of SendAction.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/GiveAction&quot;&gt;GiveAction&lt;/a&gt;:
     * Unlike GiveAction, SendAction does not imply the transfer of ownership
     * (e.g. I can send you my laptop, but I&#39;m not necessarily giving it
     * to you).&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/SendAction">SendAction</a>
     */
    public static final IRI SendAction;

    /**
     * sender
     * <p>
     * {@code http://schema.org/sender}
     * <p>
     * A sub property of participant. The participant who is at the sending
     * end of the action.
     *
     * @see <a href="http://schema.org/sender">sender</a>
     */
    public static final IRI sender;

    /**
     * sensoryUnit
     * <p>
     * {@code http://schema.org/sensoryUnit}
     * <p>
     * The neurological pathway extension that inputs and sends information
     * to the brain or spinal cord.
     *
     * @see <a href="http://schema.org/sensoryUnit">sensoryUnit</a>
     */
    public static final IRI sensoryUnit;

    /**
     * serialNumber
     * <p>
     * {@code http://schema.org/serialNumber}
     * <p>
     * The serial number or any alphanumeric identifier of a particular
     * product. When attached to an offer, it is a shortcut for the serial
     * number of the product included in the offer.
     *
     * @see <a href="http://schema.org/serialNumber">serialNumber</a>
     */
    public static final IRI serialNumber;

    /**
     * Series
     * <p>
     * {@code http://schema.org/Series}
     * <p>
     * A Series in schema.org is a group of related items, typically but not
     * necessarily of the same kind. See also &lt;a
     * href=&quot;http://schema.org/CreativeWorkSeries&quot;&gt;CreativeWorkSeries&lt;/a&gt;,
     * &lt;a
     * href=&quot;http://schema.org/EventSeries&quot;&gt;EventSeries&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Series">Series</a>
     */
    public static final IRI Series;

    /**
     * seriousAdverseOutcome
     * <p>
     * {@code http://schema.org/seriousAdverseOutcome}
     * <p>
     * A possible serious complication and/or serious side effect of this
     * therapy. Serious adverse outcomes include those that are
     * life-threatening; result in death, disability, or permanent damage;
     * require hospitalization or prolong existing hospitalization; cause
     * congenital anomalies or birth defects; or jeopardize the patient and
     * may require medical or surgical intervention to prevent one of the
     * outcomes in this definition.
     *
     * @see <a href="http://schema.org/seriousAdverseOutcome">seriousAdverseOutcome</a>
     */
    public static final IRI seriousAdverseOutcome;

    /**
     * serverStatus
     * <p>
     * {@code http://schema.org/serverStatus}
     * <p>
     * Status of a game server.
     *
     * @see <a href="http://schema.org/serverStatus">serverStatus</a>
     */
    public static final IRI serverStatus;

    /**
     * servesCuisine
     * <p>
     * {@code http://schema.org/servesCuisine}
     * <p>
     * The cuisine of the restaurant.
     *
     * @see <a href="http://schema.org/servesCuisine">servesCuisine</a>
     */
    public static final IRI servesCuisine;

    /**
     * Service
     * <p>
     * {@code http://schema.org/Service}
     * <p>
     * A service provided by an organization, e.g. delivery service, print
     * services, etc.
     *
     * @see <a href="http://schema.org/Service">Service</a>
     */
    public static final IRI Service;

    /**
     * serviceArea
     * <p>
     * {@code http://schema.org/serviceArea}
     * <p>
     * The geographic area where the service is provided.
     *
     * @see <a href="http://schema.org/serviceArea">serviceArea</a>
     */
    public static final IRI serviceArea;

    /**
     * serviceAudience
     * <p>
     * {@code http://schema.org/serviceAudience}
     * <p>
     * The audience eligible for this service.
     *
     * @see <a href="http://schema.org/serviceAudience">serviceAudience</a>
     */
    public static final IRI serviceAudience;

    /**
     * ServiceChannel
     * <p>
     * {@code http://schema.org/ServiceChannel}
     * <p>
     * A means for accessing a service, e.g. a government office location,
     * web site, or phone number.
     *
     * @see <a href="http://schema.org/ServiceChannel">ServiceChannel</a>
     */
    public static final IRI ServiceChannel;

    /**
     * serviceLocation
     * <p>
     * {@code http://schema.org/serviceLocation}
     * <p>
     * The location (e.g. civic structure, local business, etc.) where a
     * person can go to access the service.
     *
     * @see <a href="http://schema.org/serviceLocation">serviceLocation</a>
     */
    public static final IRI serviceLocation;

    /**
     * serviceOperator
     * <p>
     * {@code http://schema.org/serviceOperator}
     * <p>
     * The operating organization, if different from the provider.  This
     * enables the representation of services that are provided by an
     * organization, but operated by another organization like a
     * subcontractor.
     *
     * @see <a href="http://schema.org/serviceOperator">serviceOperator</a>
     */
    public static final IRI serviceOperator;

    /**
     * serviceOutput
     * <p>
     * {@code http://schema.org/serviceOutput}
     * <p>
     * The tangible thing generated by the service, e.g. a passport, permit,
     * etc.
     *
     * @see <a href="http://schema.org/serviceOutput">serviceOutput</a>
     */
    public static final IRI serviceOutput;

    /**
     * servicePhone
     * <p>
     * {@code http://schema.org/servicePhone}
     * <p>
     * The phone number to use to access the service.
     *
     * @see <a href="http://schema.org/servicePhone">servicePhone</a>
     */
    public static final IRI servicePhone;

    /**
     * servicePostalAddress
     * <p>
     * {@code http://schema.org/servicePostalAddress}
     * <p>
     * The address for accessing the service by mail.
     *
     * @see <a href="http://schema.org/servicePostalAddress">servicePostalAddress</a>
     */
    public static final IRI servicePostalAddress;

    /**
     * serviceSmsNumber
     * <p>
     * {@code http://schema.org/serviceSmsNumber}
     * <p>
     * The number to access the service by text message.
     *
     * @see <a href="http://schema.org/serviceSmsNumber">serviceSmsNumber</a>
     */
    public static final IRI serviceSmsNumber;

    /**
     * serviceType
     * <p>
     * {@code http://schema.org/serviceType}
     * <p>
     * The type of service being offered, e.g. veterans&#39; benefits,
     * emergency relief, etc.
     *
     * @see <a href="http://schema.org/serviceType">serviceType</a>
     */
    public static final IRI serviceType;

    /**
     * serviceUrl
     * <p>
     * {@code http://schema.org/serviceUrl}
     * <p>
     * The website to access the service.
     *
     * @see <a href="http://schema.org/serviceUrl">serviceUrl</a>
     */
    public static final IRI serviceUrl;

    /**
     * servingSize
     * <p>
     * {@code http://schema.org/servingSize}
     * <p>
     * The serving size, in terms of the number of volume or mass.
     *
     * @see <a href="http://schema.org/servingSize">servingSize</a>
     */
    public static final IRI servingSize;

    /**
     * ShareAction
     * <p>
     * {@code http://schema.org/ShareAction}
     * <p>
     * The act of distributing content to people for their amusement or
     * edification.
     *
     * @see <a href="http://schema.org/ShareAction">ShareAction</a>
     */
    public static final IRI ShareAction;

    /**
     * sharedContent
     * <p>
     * {@code http://schema.org/sharedContent}
     * <p>
     * A CreativeWork such as an image, video, or audio clip shared as part
     * of this posting.
     *
     * @see <a href="http://schema.org/sharedContent">sharedContent</a>
     */
    public static final IRI sharedContent;

    /**
     * ShoeStore
     * <p>
     * {@code http://schema.org/ShoeStore}
     * <p>
     * A shoe store.
     *
     * @see <a href="http://schema.org/ShoeStore">ShoeStore</a>
     */
    public static final IRI ShoeStore;

    /**
     * ShoppingCenter
     * <p>
     * {@code http://schema.org/ShoppingCenter}
     * <p>
     * A shopping center or mall.
     *
     * @see <a href="http://schema.org/ShoppingCenter">ShoppingCenter</a>
     */
    public static final IRI ShoppingCenter;

    /**
     * sibling
     * <p>
     * {@code http://schema.org/sibling}
     * <p>
     * A sibling of the person.
     *
     * @see <a href="http://schema.org/sibling">sibling</a>
     */
    public static final IRI sibling;

    /**
     * siblings
     * <p>
     * {@code http://schema.org/siblings}
     * <p>
     * A sibling of the person.
     *
     * @see <a href="http://schema.org/siblings">siblings</a>
     */
    public static final IRI siblings;

    /**
     * signDetected
     * <p>
     * {@code http://schema.org/signDetected}
     * <p>
     * A sign detected by the test.
     *
     * @see <a href="http://schema.org/signDetected">signDetected</a>
     */
    public static final IRI signDetected;

    /**
     * significance
     * <p>
     * {@code http://schema.org/significance}
     * <p>
     * The significance associated with the superficial anatomy; as an
     * example, how characteristics of the superficial anatomy can suggest
     * underlying medical conditions or courses of treatment.
     *
     * @see <a href="http://schema.org/significance">significance</a>
     */
    public static final IRI significance;

    /**
     * significantLink
     * <p>
     * {@code http://schema.org/significantLink}
     * <p>
     * One of the more significant URLs on the page. Typically, these are the
     * non-navigation links that are clicked on the most.
     *
     * @see <a href="http://schema.org/significantLink">significantLink</a>
     */
    public static final IRI significantLink;

    /**
     * significantLinks
     * <p>
     * {@code http://schema.org/significantLinks}
     * <p>
     * The most significant URLs on the page. Typically, these are the
     * non-navigation links that are clicked on the most.
     *
     * @see <a href="http://schema.org/significantLinks">significantLinks</a>
     */
    public static final IRI significantLinks;

    /**
     * signOrSymptom
     * <p>
     * {@code http://schema.org/signOrSymptom}
     * <p>
     * A sign or symptom of this condition. Signs are objective or physically
     * observable manifestations of the medical condition while symptoms are
     * the subjective experience of the medical condition.
     *
     * @see <a href="http://schema.org/signOrSymptom">signOrSymptom</a>
     */
    public static final IRI signOrSymptom;

    /**
     * SingleFamilyResidence
     * <p>
     * {@code http://schema.org/SingleFamilyResidence}
     * <p>
     * Residence type: Single-family home.
     *
     * @see <a href="http://schema.org/SingleFamilyResidence">SingleFamilyResidence</a>
     */
    public static final IRI SingleFamilyResidence;

    /**
     * SiteNavigationElement
     * <p>
     * {@code http://schema.org/SiteNavigationElement}
     * <p>
     * A navigation element of the page.
     *
     * @see <a href="http://schema.org/SiteNavigationElement">SiteNavigationElement</a>
     */
    public static final IRI SiteNavigationElement;

    /**
     * skills
     * <p>
     * {@code http://schema.org/skills}
     * <p>
     * Skills required to fulfill this role or in this Occupation.
     *
     * @see <a href="http://schema.org/skills">skills</a>
     */
    public static final IRI skills;

    /**
     * SkiResort
     * <p>
     * {@code http://schema.org/SkiResort}
     * <p>
     * A ski resort.
     *
     * @see <a href="http://schema.org/SkiResort">SkiResort</a>
     */
    public static final IRI SkiResort;

    /**
     * sku
     * <p>
     * {@code http://schema.org/sku}
     * <p>
     * The Stock Keeping Unit (SKU), i.e. a merchant-specific identifier for
     * a product or service, or the product to which the offer refers.
     *
     * @see <a href="http://schema.org/sku">sku</a>
     */
    public static final IRI sku;

    /**
     * smokingAllowed
     * <p>
     * {@code http://schema.org/smokingAllowed}
     * <p>
     * Indicates whether it is allowed to smoke in the place, e.g. in the
     * restaurant, hotel or hotel room.
     *
     * @see <a href="http://schema.org/smokingAllowed">smokingAllowed</a>
     */
    public static final IRI smokingAllowed;

    /**
     * SocialEvent
     * <p>
     * {@code http://schema.org/SocialEvent}
     * <p>
     * Event type: Social event.
     *
     * @see <a href="http://schema.org/SocialEvent">SocialEvent</a>
     */
    public static final IRI SocialEvent;

    /**
     * SocialMediaPosting
     * <p>
     * {@code http://schema.org/SocialMediaPosting}
     * <p>
     * A post to a social media platform, including blog posts, tweets,
     * Facebook posts, etc.
     *
     * @see <a href="http://schema.org/SocialMediaPosting">SocialMediaPosting</a>
     */
    public static final IRI SocialMediaPosting;

    /**
     * sodiumContent
     * <p>
     * {@code http://schema.org/sodiumContent}
     * <p>
     * The number of milligrams of sodium.
     *
     * @see <a href="http://schema.org/sodiumContent">sodiumContent</a>
     */
    public static final IRI sodiumContent;

    /**
     * softwareAddOn
     * <p>
     * {@code http://schema.org/softwareAddOn}
     * <p>
     * Additional content for a software application.
     *
     * @see <a href="http://schema.org/softwareAddOn">softwareAddOn</a>
     */
    public static final IRI softwareAddOn;

    /**
     * SoftwareApplication
     * <p>
     * {@code http://schema.org/SoftwareApplication}
     * <p>
     * A software application.
     *
     * @see <a href="http://schema.org/SoftwareApplication">SoftwareApplication</a>
     */
    public static final IRI SoftwareApplication;

    /**
     * softwareHelp
     * <p>
     * {@code http://schema.org/softwareHelp}
     * <p>
     * Software application help.
     *
     * @see <a href="http://schema.org/softwareHelp">softwareHelp</a>
     */
    public static final IRI softwareHelp;

    /**
     * softwareRequirements
     * <p>
     * {@code http://schema.org/softwareRequirements}
     * <p>
     * Component dependency requirements for application. This includes
     * runtime environments and shared libraries that are not included in the
     * application distribution package, but required to run the application
     * (Examples: DirectX, Java or .NET runtime).
     *
     * @see <a href="http://schema.org/softwareRequirements">softwareRequirements</a>
     */
    public static final IRI softwareRequirements;

    /**
     * SoftwareSourceCode
     * <p>
     * {@code http://schema.org/SoftwareSourceCode}
     * <p>
     * Computer programming source code. Example: Full (compile ready)
     * solutions, code snippet samples, scripts, templates.
     *
     * @see <a href="http://schema.org/SoftwareSourceCode">SoftwareSourceCode</a>
     */
    public static final IRI SoftwareSourceCode;

    /**
     * softwareVersion
     * <p>
     * {@code http://schema.org/softwareVersion}
     * <p>
     * Version of the software instance.
     *
     * @see <a href="http://schema.org/softwareVersion">softwareVersion</a>
     */
    public static final IRI softwareVersion;

    /**
     * SomeProducts
     * <p>
     * {@code http://schema.org/SomeProducts}
     * <p>
     * A placeholder for multiple similar products of the same kind.
     *
     * @see <a href="http://schema.org/SomeProducts">SomeProducts</a>
     */
    public static final IRI SomeProducts;

    /**
     * source
     * <p>
     * {@code http://schema.org/source}
     * <p>
     * The anatomical or organ system that the artery originates from.
     *
     * @see <a href="http://schema.org/source">source</a>
     */
    public static final IRI source;

    /**
     * sourcedFrom
     * <p>
     * {@code http://schema.org/sourcedFrom}
     * <p>
     * The neurological pathway that originates the neurons.
     *
     * @see <a href="http://schema.org/sourcedFrom">sourcedFrom</a>
     */
    public static final IRI sourcedFrom;

    /**
     * sourceOrganization
     * <p>
     * {@code http://schema.org/sourceOrganization}
     * <p>
     * The Organization on whose behalf the creator was working.
     *
     * @see <a href="http://schema.org/sourceOrganization">sourceOrganization</a>
     */
    public static final IRI sourceOrganization;

    /**
     * spatial
     * <p>
     * {@code http://schema.org/spatial}
     * <p>
     * The range of spatial applicability of a dataset, e.g. for a dataset of
     * New York weather, the state of New York.
     *
     * @see <a href="http://schema.org/spatial">spatial</a>
     */
    public static final IRI spatial;

    /**
     * spatialCoverage
     * <p>
     * {@code http://schema.org/spatialCoverage}
     * <p>
     * The spatialCoverage of a CreativeWork indicates the place(s) which are
     * the focus of the content. It is a subproperty of
     * contentLocation
     * intended primarily for more technical and detailed materials. For
     * example with a Dataset, it indicates
     * areas that the dataset
     * describes: a dataset of New York weather would have spatialCoverage
     * which was the place: the state of New York.
     *
     * @see <a href="http://schema.org/spatialCoverage">spatialCoverage</a>
     */
    public static final IRI spatialCoverage;

    /**
     * speakable
     * <p>
     * {@code http://schema.org/speakable}
     * <p>
     * Indicates sections of a Web page that are particularly
     * &#39;speakable&#39; in the sense of being highlighted as being
     * especially appropriate for text-to-speech conversion. Other sections
     * of a page may also be usefully spoken in particular circumstances; the
     * &#39;speakable&#39; property serves to indicate the parts most likely
     * to be generally useful for speech.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * The
     * &lt;em&gt;speakable&lt;/em&gt; property can be repeated an arbitrary
     * number of times, with three kinds of possible
     * &#39;content-locator&#39; values:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * 1.)
     * &lt;em&gt;id-value&lt;/em&gt; URL references - uses
     * &lt;em&gt;id-value&lt;/em&gt; of an element in the page being
     * annotated. The simplest use of &lt;em&gt;speakable&lt;/em&gt; has
     * (potentially relative) URL values, referencing identified sections of
     * the document concerned.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * 2.) CSS Selectors -
     * addresses content in the annotated page, eg. via class attribute. Use
     * the &lt;a
     * href=&quot;http://schema.org/cssSelector&quot;&gt;cssSelector&lt;/a&gt;
     * property.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * 3.)  XPaths - addresses content via
     * XPaths (assuming an XML view of the content). Use the &lt;a
     * href=&quot;http://schema.org/xpath&quot;&gt;xpath&lt;/a&gt;
     * property.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * For more sophisticated markup of
     * speakable sections beyond simple ID references, either CSS selectors
     * or XPath expressions to pick out document section(s) as speakable. For
     * this
     * we define a supporting type, &lt;a
     * href=&quot;http://schema.org/SpeakableSpecification&quot;&gt;SpeakableSpecification&lt;/a&gt;
     * which is defined to be a possible value of the
     * &lt;em&gt;speakable&lt;/em&gt; property.
     *
     * @see <a href="http://schema.org/speakable">speakable</a>
     */
    public static final IRI speakable;

    /**
     * SpeakableSpecification
     * <p>
     * {@code http://schema.org/SpeakableSpecification}
     * <p>
     * A SpeakableSpecification indicates (typically via &lt;a
     * href=&quot;http://schema.org/xpath&quot;&gt;xpath&lt;/a&gt; or &lt;a
     * href=&quot;http://schema.org/cssSelector&quot;&gt;cssSelector&lt;/a&gt;)
     * sections of a document that are highlighted as particularly &lt;a
     * href=&quot;http://schema.org/speakable&quot;&gt;speakable&lt;/a&gt;.
     * Instances of this type are expected to be used primarily as values of
     * the &lt;a
     * href=&quot;http://schema.org/speakable&quot;&gt;speakable&lt;/a&gt;
     * property.
     *
     * @see <a href="http://schema.org/SpeakableSpecification">SpeakableSpecification</a>
     */
    public static final IRI SpeakableSpecification;

    /**
     * specialCommitments
     * <p>
     * {@code http://schema.org/specialCommitments}
     * <p>
     * Any special commitments associated with this job posting. Valid
     * entries include VeteranCommit, MilitarySpouseCommit, etc.
     *
     * @see <a href="http://schema.org/specialCommitments">specialCommitments</a>
     */
    public static final IRI specialCommitments;

    /**
     * specialOpeningHoursSpecification
     * <p>
     * {@code http://schema.org/specialOpeningHoursSpecification}
     * <p>
     * The special opening hours of a certain
     * place.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Use this to explicitly override general
     * opening hours brought in scope by &lt;a
     * href=&quot;http://schema.org/openingHoursSpecification&quot;&gt;openingHoursSpecification&lt;/a&gt;
     * or &lt;a
     * href=&quot;http://schema.org/openingHours&quot;&gt;openingHours&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/specialOpeningHoursSpecification">specialOpeningHoursSpecification</a>
     */
    public static final IRI specialOpeningHoursSpecification;

    /**
     * Specialty
     * <p>
     * {@code http://schema.org/Specialty}
     * <p>
     * Any branch of a field in which people typically develop specific
     * expertise, usually after significant study, time, and effort.
     *
     * @see <a href="http://schema.org/Specialty">Specialty</a>
     */
    public static final IRI Specialty;

    /**
     * specialty
     * <p>
     * {@code http://schema.org/specialty}
     * <p>
     * One of the domain specialities to which this web page&#39;s content
     * applies.
     *
     * @see <a href="http://schema.org/specialty">specialty</a>
     */
    public static final IRI specialty;

    /**
     * speed
     * <p>
     * {@code http://schema.org/speed}
     * <p>
     * The speed range of the vehicle. If the vehicle is powered by an
     * engine, the upper limit of the speed range (indicated by &lt;a
     * href=&quot;http://schema.org/maxValue&quot;&gt;maxValue&lt;/a&gt;
     * should be the maximum speed achievable under regular
     * conditions.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s): KMH for km/h,
     * HM for mile per hour (0.447 04 m/s), KNT for
     * knot&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Note 1: Use &lt;a
     * href=&quot;http://schema.org/minValue&quot;&gt;minValue&lt;/a&gt; and
     * &lt;a
     * href=&quot;http://schema.org/maxValue&quot;&gt;maxValue&lt;/a&gt; to
     * indicate the range. Typically, the minimal value is zero.
     * Note 2:
     * There are many different ways of measuring the speed range. You can
     * link to information about how the given value has been determined
     * using the &lt;a
     * href=&quot;http://schema.org/valueReference&quot;&gt;valueReference&lt;/a&gt;
     * property.
     *
     * @see <a href="http://schema.org/speed">speed</a>
     */
    public static final IRI speed;

    /**
     * spokenByCharacter
     * <p>
     * {@code http://schema.org/spokenByCharacter}
     * <p>
     * The (e.g. fictional) character, Person or Organization to whom the
     * quotation is attributed within the containing CreativeWork.
     *
     * @see <a href="http://schema.org/spokenByCharacter">spokenByCharacter</a>
     */
    public static final IRI spokenByCharacter;

    /**
     * sponsor
     * <p>
     * {@code http://schema.org/sponsor}
     * <p>
     * A person or organization that supports a thing through a pledge,
     * promise, or financial contribution. e.g. a sponsor of a Medical Study
     * or a corporate sponsor of an event.
     *
     * @see <a href="http://schema.org/sponsor">sponsor</a>
     */
    public static final IRI sponsor;

    /**
     * sport
     * <p>
     * {@code http://schema.org/sport}
     * <p>
     * A type of sport (e.g. Baseball).
     *
     * @see <a href="http://schema.org/sport">sport</a>
     */
    public static final IRI sport;

    /**
     * SportingGoodsStore
     * <p>
     * {@code http://schema.org/SportingGoodsStore}
     * <p>
     * A sporting goods store.
     *
     * @see <a href="http://schema.org/SportingGoodsStore">SportingGoodsStore</a>
     */
    public static final IRI SportingGoodsStore;

    /**
     * sportsActivityLocation
     * <p>
     * {@code http://schema.org/sportsActivityLocation}
     * <p>
     * A sub property of location. The sports activity location where this
     * action occurred.
     *
     * @see <a href="http://schema.org/sportsActivityLocation">sportsActivityLocation</a>
     */
    public static final IRI sportsActivityLocation;

    /**
     * SportsActivityLocation
     * <p>
     * {@code http://schema.org/SportsActivityLocation}
     * <p>
     * A sports location, such as a playing field.
     *
     * @see <a href="http://schema.org/SportsActivityLocation">SportsActivityLocation</a>
     */
    public static final IRI SportsActivityLocation;

    /**
     * SportsClub
     * <p>
     * {@code http://schema.org/SportsClub}
     * <p>
     * A sports club.
     *
     * @see <a href="http://schema.org/SportsClub">SportsClub</a>
     */
    public static final IRI SportsClub;

    /**
     * SportsEvent
     * <p>
     * {@code http://schema.org/SportsEvent}
     * <p>
     * Event type: Sports event.
     *
     * @see <a href="http://schema.org/SportsEvent">SportsEvent</a>
     */
    public static final IRI SportsEvent;

    /**
     * sportsEvent
     * <p>
     * {@code http://schema.org/sportsEvent}
     * <p>
     * A sub property of location. The sports event where this action
     * occurred.
     *
     * @see <a href="http://schema.org/sportsEvent">sportsEvent</a>
     */
    public static final IRI sportsEvent;

    /**
     * SportsOrganization
     * <p>
     * {@code http://schema.org/SportsOrganization}
     * <p>
     * Represents the collection of all sports organizations, including
     * sports teams, governing bodies, and sports associations.
     *
     * @see <a href="http://schema.org/SportsOrganization">SportsOrganization</a>
     */
    public static final IRI SportsOrganization;

    /**
     * SportsTeam
     * <p>
     * {@code http://schema.org/SportsTeam}
     * <p>
     * Organization: Sports team.
     *
     * @see <a href="http://schema.org/SportsTeam">SportsTeam</a>
     */
    public static final IRI SportsTeam;

    /**
     * sportsTeam
     * <p>
     * {@code http://schema.org/sportsTeam}
     * <p>
     * A sub property of participant. The sports team that participated on
     * this action.
     *
     * @see <a href="http://schema.org/sportsTeam">sportsTeam</a>
     */
    public static final IRI sportsTeam;

    /**
     * spouse
     * <p>
     * {@code http://schema.org/spouse}
     * <p>
     * The person&#39;s spouse.
     *
     * @see <a href="http://schema.org/spouse">spouse</a>
     */
    public static final IRI spouse;

    /**
     * SpreadsheetDigitalDocument
     * <p>
     * {@code http://schema.org/SpreadsheetDigitalDocument}
     * <p>
     * A spreadsheet file.
     *
     * @see <a href="http://schema.org/SpreadsheetDigitalDocument">SpreadsheetDigitalDocument</a>
     */
    public static final IRI SpreadsheetDigitalDocument;

    /**
     * StadiumOrArena
     * <p>
     * {@code http://schema.org/StadiumOrArena}
     * <p>
     * A stadium.
     *
     * @see <a href="http://schema.org/StadiumOrArena">StadiumOrArena</a>
     */
    public static final IRI StadiumOrArena;

    /**
     * stage
     * <p>
     * {@code http://schema.org/stage}
     * <p>
     * The stage of the condition, if applicable.
     *
     * @see <a href="http://schema.org/stage">stage</a>
     */
    public static final IRI stage;

    /**
     * stageAsNumber
     * <p>
     * {@code http://schema.org/stageAsNumber}
     * <p>
     * The stage represented as a number, e.g. 3.
     *
     * @see <a href="http://schema.org/stageAsNumber">stageAsNumber</a>
     */
    public static final IRI stageAsNumber;

    /**
     * starRating
     * <p>
     * {@code http://schema.org/starRating}
     * <p>
     * An official rating for a lodging business or food establishment, e.g.
     * from national associations or standards bodies. Use the author
     * property to indicate the rating organization, e.g. as an Organization
     * with name such as (e.g. HOTREC, DEHOGA, WHR, or Hotelstars).
     *
     * @see <a href="http://schema.org/starRating">starRating</a>
     */
    public static final IRI starRating;

    /**
     * startDate
     * <p>
     * {@code http://schema.org/startDate}
     * <p>
     * The start date and time of the item (in &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/ISO_8601&quot;&gt;ISO 8601
     * date format&lt;/a&gt;).
     *
     * @see <a href="http://schema.org/startDate">startDate</a>
     */
    public static final IRI startDate;

    /**
     * startTime
     * <p>
     * {@code http://schema.org/startTime}
     * <p>
     * The startTime of something. For a reserved event or service (e.g.
     * FoodEstablishmentReservation), the time that it is expected to start.
     * For actions that span a period of time, when the action was performed.
     * e.g. John wrote a book from &lt;em&gt;January&lt;/em&gt; to
     * December.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Note that Event uses
     * startDate/endDate instead of startTime/endTime, even when describing
     * dates with times. This situation may be clarified in future revisions.
     *
     * @see <a href="http://schema.org/startTime">startTime</a>
     */
    public static final IRI startTime;

    /**
     * State
     * <p>
     * {@code http://schema.org/State}
     * <p>
     * A state or province of a country.
     *
     * @see <a href="http://schema.org/State">State</a>
     */
    public static final IRI State;

    /**
     * status
     * <p>
     * {@code http://schema.org/status}
     * <p>
     * The status of the study (enumerated).
     *
     * @see <a href="http://schema.org/status">status</a>
     */
    public static final IRI status;

    /**
     * steeringPosition
     * <p>
     * {@code http://schema.org/steeringPosition}
     * <p>
     * The position of the steering wheel or similar device (mostly for
     * cars).
     *
     * @see <a href="http://schema.org/steeringPosition">steeringPosition</a>
     */
    public static final IRI steeringPosition;

    /**
     * SteeringPositionValue
     * <p>
     * {@code http://schema.org/SteeringPositionValue}
     * <p>
     * A value indicating a steering position.
     *
     * @see <a href="http://schema.org/SteeringPositionValue">SteeringPositionValue</a>
     */
    public static final IRI SteeringPositionValue;

    /**
     * step
     * <p>
     * {@code http://schema.org/step}
     * <p>
     * A single step item (as HowToStep, text, document, video, etc.) or a
     * HowToSection.
     *
     * @see <a href="http://schema.org/step">step</a>
     */
    public static final IRI step;

    /**
     * steps
     * <p>
     * {@code http://schema.org/steps}
     * <p>
     * A single step item (as HowToStep, text, document, video, etc.) or a
     * HowToSection (originally misnamed &#39;steps&#39;; &#39;step&#39; is
     * preferred).
     *
     * @see <a href="http://schema.org/steps">steps</a>
     */
    public static final IRI steps;

    /**
     * stepValue
     * <p>
     * {@code http://schema.org/stepValue}
     * <p>
     * The stepValue attribute indicates the granularity that is expected
     * (and required) of the value in a PropertyValueSpecification.
     *
     * @see <a href="http://schema.org/stepValue">stepValue</a>
     */
    public static final IRI stepValue;

    /**
     * storageRequirements
     * <p>
     * {@code http://schema.org/storageRequirements}
     * <p>
     * Storage requirements (free space required).
     *
     * @see <a href="http://schema.org/storageRequirements">storageRequirements</a>
     */
    public static final IRI storageRequirements;

    /**
     * Store
     * <p>
     * {@code http://schema.org/Store}
     * <p>
     * A retail good store.
     *
     * @see <a href="http://schema.org/Store">Store</a>
     */
    public static final IRI Store;

    /**
     * streetAddress
     * <p>
     * {@code http://schema.org/streetAddress}
     * <p>
     * The street address. For example, 1600 Amphitheatre Pkwy.
     *
     * @see <a href="http://schema.org/streetAddress">streetAddress</a>
     */
    public static final IRI streetAddress;

    /**
     * strengthUnit
     * <p>
     * {@code http://schema.org/strengthUnit}
     * <p>
     * The units of an active ingredient&#39;s strength, e.g. mg.
     *
     * @see <a href="http://schema.org/strengthUnit">strengthUnit</a>
     */
    public static final IRI strengthUnit;

    /**
     * strengthValue
     * <p>
     * {@code http://schema.org/strengthValue}
     * <p>
     * The value of an active ingredient&#39;s strength, e.g. 325.
     *
     * @see <a href="http://schema.org/strengthValue">strengthValue</a>
     */
    public static final IRI strengthValue;

    /**
     * structuralClass
     * <p>
     * {@code http://schema.org/structuralClass}
     * <p>
     * The name given to how bone physically connects to each other.
     *
     * @see <a href="http://schema.org/structuralClass">structuralClass</a>
     */
    public static final IRI structuralClass;

    /**
     * StructuredValue
     * <p>
     * {@code http://schema.org/StructuredValue}
     * <p>
     * Structured values are used when the value of a property has a more
     * complex structure than simply being a textual value or a reference to
     * another thing.
     *
     * @see <a href="http://schema.org/StructuredValue">StructuredValue</a>
     */
    public static final IRI StructuredValue;

    /**
     * study
     * <p>
     * {@code http://schema.org/study}
     * <p>
     * A medical study or trial related to this entity.
     *
     * @see <a href="http://schema.org/study">study</a>
     */
    public static final IRI study;

    /**
     * studyDesign
     * <p>
     * {@code http://schema.org/studyDesign}
     * <p>
     * Specifics about the observational study design (enumerated).
     *
     * @see <a href="http://schema.org/studyDesign">studyDesign</a>
     */
    public static final IRI studyDesign;

    /**
     * studyLocation
     * <p>
     * {@code http://schema.org/studyLocation}
     * <p>
     * The location in which the study is taking/took place.
     *
     * @see <a href="http://schema.org/studyLocation">studyLocation</a>
     */
    public static final IRI studyLocation;

    /**
     * studySubject
     * <p>
     * {@code http://schema.org/studySubject}
     * <p>
     * A subject of the study, i.e. one of the medical conditions, therapies,
     * devices, drugs, etc. investigated by the study.
     *
     * @see <a href="http://schema.org/studySubject">studySubject</a>
     */
    public static final IRI studySubject;

    /**
     * subEvent
     * <p>
     * {@code http://schema.org/subEvent}
     * <p>
     * An Event that is part of this event. For example, a conference event
     * includes many presentations, each of which is a subEvent of the
     * conference.
     *
     * @see <a href="http://schema.org/subEvent">subEvent</a>
     */
    public static final IRI subEvent;

    /**
     * subEvents
     * <p>
     * {@code http://schema.org/subEvents}
     * <p>
     * Events that are a part of this event. For example, a conference event
     * includes many presentations, each subEvents of the conference.
     *
     * @see <a href="http://schema.org/subEvents">subEvents</a>
     */
    public static final IRI subEvents;

    /**
     * subjectOf
     * <p>
     * {@code http://schema.org/subjectOf}
     * <p>
     * A CreativeWork or Event about this Thing..
     *
     * @see <a href="http://schema.org/subjectOf">subjectOf</a>
     */
    public static final IRI subjectOf;

    /**
     * subOrganization
     * <p>
     * {@code http://schema.org/subOrganization}
     * <p>
     * A relationship between two organizations where the first includes the
     * second, e.g., as a subsidiary. See also: the more specific
     * &#39;department&#39; property.
     *
     * @see <a href="http://schema.org/subOrganization">subOrganization</a>
     */
    public static final IRI subOrganization;

    /**
     * subReservation
     * <p>
     * {@code http://schema.org/subReservation}
     * <p>
     * The individual reservations included in the package. Typically a
     * repeated property.
     *
     * @see <a href="http://schema.org/subReservation">subReservation</a>
     */
    public static final IRI subReservation;

    /**
     * SubscribeAction
     * <p>
     * {@code http://schema.org/SubscribeAction}
     * <p>
     * The act of forming a personal connection with someone/something
     * (object) unidirectionally/asymmetrically to get updates pushed
     * to.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/FollowAction&quot;&gt;FollowAction&lt;/a&gt;:
     * Unlike FollowAction, SubscribeAction implies that the subscriber acts
     * as a passive agent being constantly/actively pushed for
     * updates.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/RegisterAction&quot;&gt;RegisterAction&lt;/a&gt;:
     * Unlike RegisterAction, SubscribeAction implies that the agent is
     * interested in continuing receiving updates from the
     * object.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/JoinAction&quot;&gt;JoinAction&lt;/a&gt;:
     * Unlike JoinAction, SubscribeAction implies that the agent is
     * interested in continuing receiving updates from the
     * object.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/SubscribeAction">SubscribeAction</a>
     */
    public static final IRI SubscribeAction;

    /**
     * subStageSuffix
     * <p>
     * {@code http://schema.org/subStageSuffix}
     * <p>
     * The substage, e.g. &#39;a&#39; for Stage IIIa.
     *
     * @see <a href="http://schema.org/subStageSuffix">subStageSuffix</a>
     */
    public static final IRI subStageSuffix;

    /**
     * Substance
     * <p>
     * {@code http://schema.org/Substance}
     * <p>
     * Any matter of defined composition that has discrete existence, whose
     * origin may be biological, mineral or chemical.
     *
     * @see <a href="http://schema.org/Substance">Substance</a>
     */
    public static final IRI Substance;

    /**
     * subStructure
     * <p>
     * {@code http://schema.org/subStructure}
     * <p>
     * Component (sub-)structure(s) that comprise this anatomical structure.
     *
     * @see <a href="http://schema.org/subStructure">subStructure</a>
     */
    public static final IRI subStructure;

    /**
     * subTest
     * <p>
     * {@code http://schema.org/subTest}
     * <p>
     * A component test of the panel.
     *
     * @see <a href="http://schema.org/subTest">subTest</a>
     */
    public static final IRI subTest;

    /**
     * subtitleLanguage
     * <p>
     * {@code http://schema.org/subtitleLanguage}
     * <p>
     * Languages in which subtitles/captions are available, in &lt;a
     * href=&quot;http://tools.ietf.org/html/bcp47&quot;&gt;IETF BCP 47
     * standard format&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/subtitleLanguage">subtitleLanguage</a>
     */
    public static final IRI subtitleLanguage;

    /**
     * subtype
     * <p>
     * {@code http://schema.org/subtype}
     * <p>
     * A more specific type of the condition, where applicable, for example
     * &#39;Type 1 Diabetes&#39;, &#39;Type 2 Diabetes&#39;, or
     * &#39;Gestational Diabetes&#39; for Diabetes.
     *
     * @see <a href="http://schema.org/subtype">subtype</a>
     */
    public static final IRI subtype;

    /**
     * SubwayStation
     * <p>
     * {@code http://schema.org/SubwayStation}
     * <p>
     * A subway station.
     *
     * @see <a href="http://schema.org/SubwayStation">SubwayStation</a>
     */
    public static final IRI SubwayStation;

    /**
     * successorOf
     * <p>
     * {@code http://schema.org/successorOf}
     * <p>
     * A pointer from a newer variant of a product  to its previous, often
     * discontinued predecessor.
     *
     * @see <a href="http://schema.org/successorOf">successorOf</a>
     */
    public static final IRI successorOf;

    /**
     * sugarContent
     * <p>
     * {@code http://schema.org/sugarContent}
     * <p>
     * The number of grams of sugar.
     *
     * @see <a href="http://schema.org/sugarContent">sugarContent</a>
     */
    public static final IRI sugarContent;

    /**
     * suggestedAnswer
     * <p>
     * {@code http://schema.org/suggestedAnswer}
     * <p>
     * An answer (possibly one of several, possibly incorrect) to a Question,
     * e.g. on a Question/Answer site.
     *
     * @see <a href="http://schema.org/suggestedAnswer">suggestedAnswer</a>
     */
    public static final IRI suggestedAnswer;

    /**
     * suggestedGender
     * <p>
     * {@code http://schema.org/suggestedGender}
     * <p>
     * The gender of the person or audience.
     *
     * @see <a href="http://schema.org/suggestedGender">suggestedGender</a>
     */
    public static final IRI suggestedGender;

    /**
     * suggestedMaxAge
     * <p>
     * {@code http://schema.org/suggestedMaxAge}
     * <p>
     * Maximal age recommended for viewing content.
     *
     * @see <a href="http://schema.org/suggestedMaxAge">suggestedMaxAge</a>
     */
    public static final IRI suggestedMaxAge;

    /**
     * suggestedMinAge
     * <p>
     * {@code http://schema.org/suggestedMinAge}
     * <p>
     * Minimal age recommended for viewing content.
     *
     * @see <a href="http://schema.org/suggestedMinAge">suggestedMinAge</a>
     */
    public static final IRI suggestedMinAge;

    /**
     * suitableForDiet
     * <p>
     * {@code http://schema.org/suitableForDiet}
     * <p>
     * Indicates a dietary restriction or guideline for which this recipe or
     * menu item is suitable, e.g. diabetic, halal etc.
     *
     * @see <a href="http://schema.org/suitableForDiet">suitableForDiet</a>
     */
    public static final IRI suitableForDiet;

    /**
     * Suite
     * <p>
     * {@code http://schema.org/Suite}
     * <p>
     * A suite in a hotel or other public accommodation, denotes a class of
     * luxury accommodations, the key feature of which is multiple rooms
     * (Source: Wikipedia, the free encyclopedia, see &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/Suite_(hotel)&quot;&gt;http://en.wikipedia.org/wiki/Suite_(hotel)&lt;/a&gt;).
     * &lt;br
     * /&gt;&lt;br /&gt;
     * See also the &lt;a
     * href=&quot;/docs/hotels.html&quot;&gt;dedicated document on the use of
     * schema.org for marking up hotels and other forms of
     * accommodations&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/Suite">Suite</a>
     */
    public static final IRI Suite;

    /**
     * superEvent
     * <p>
     * {@code http://schema.org/superEvent}
     * <p>
     * An event that this event is a part of. For example, a collection of
     * individual music performances might each have a music festival as
     * their superEvent.
     *
     * @see <a href="http://schema.org/superEvent">superEvent</a>
     */
    public static final IRI superEvent;

    /**
     * SuperficialAnatomy
     * <p>
     * {@code http://schema.org/SuperficialAnatomy}
     * <p>
     * Anatomical features that can be observed by sight (without
     * dissection), including the form and proportions of the human body as
     * well as surface landmarks that correspond to deeper subcutaneous
     * structures. Superficial anatomy plays an important role in sports
     * medicine, phlebotomy, and other medical specialties as underlying
     * anatomical structures can be identified through surface palpation. For
     * example, during back surgery, superficial anatomy can be used to
     * palpate and count vertebrae to find the site of incision. Or in
     * phlebotomy, superficial anatomy can be used to locate an underlying
     * vein; for example, the median cubital vein can be located by palpating
     * the borders of the cubital fossa (such as the epicondyles of the
     * humerus) and then looking for the superficial signs of the vein, such
     * as size, prominence, ability to refill after depression, and feel of
     * surrounding tissue support. As another example, in a subluxation
     * (dislocation) of the glenohumeral joint, the bony structure becomes
     * pronounced with the deltoid muscle failing to cover the glenohumeral
     * joint allowing the edges of the scapula to be superficially visible.
     * Here, the superficial anatomy is the visible edges of the scapula,
     * implying the underlying dislocation of the joint (the related
     * anatomical structure).
     *
     * @see <a href="http://schema.org/SuperficialAnatomy">SuperficialAnatomy</a>
     */
    public static final IRI SuperficialAnatomy;

    /**
     * supersededBy
     * <p>
     * {@code http://schema.org/supersededBy}
     * <p>
     * Relates a term (i.e. a property, class or enumeration) to one that
     * supersedes it.
     *
     * @see <a href="http://schema.org/supersededBy">supersededBy</a>
     */
    public static final IRI supersededBy;

    /**
     * supply
     * <p>
     * {@code http://schema.org/supply}
     * <p>
     * A sub-property of instrument. A supply consumed when performing
     * instructions or a direction.
     *
     * @see <a href="http://schema.org/supply">supply</a>
     */
    public static final IRI supply;

    /**
     * supplyTo
     * <p>
     * {@code http://schema.org/supplyTo}
     * <p>
     * The area to which the artery supplies blood.
     *
     * @see <a href="http://schema.org/supplyTo">supplyTo</a>
     */
    public static final IRI supplyTo;

    /**
     * supportingData
     * <p>
     * {@code http://schema.org/supportingData}
     * <p>
     * Supporting data for a SoftwareApplication.
     *
     * @see <a href="http://schema.org/supportingData">supportingData</a>
     */
    public static final IRI supportingData;

    /**
     * surface
     * <p>
     * {@code http://schema.org/surface}
     * <p>
     * A material used as a surface in some artwork, e.g. Canvas, Paper,
     * Wood, Board, etc.
     *
     * @see <a href="http://schema.org/surface">surface</a>
     */
    public static final IRI surface;

    /**
     * SurgicalProcedure
     * <p>
     * {@code http://schema.org/SurgicalProcedure}
     * <p>
     * A type of medical procedure that involves invasive surgical
     * techniques.
     *
     * @see <a href="http://schema.org/SurgicalProcedure">SurgicalProcedure</a>
     */
    public static final IRI SurgicalProcedure;

    /**
     * SuspendAction
     * <p>
     * {@code http://schema.org/SuspendAction}
     * <p>
     * The act of momentarily pausing a device or application (e.g. pause
     * music playback or pause a timer).
     *
     * @see <a href="http://schema.org/SuspendAction">SuspendAction</a>
     */
    public static final IRI SuspendAction;

    /**
     * Synagogue
     * <p>
     * {@code http://schema.org/Synagogue}
     * <p>
     * A synagogue.
     *
     * @see <a href="http://schema.org/Synagogue">Synagogue</a>
     */
    public static final IRI Synagogue;

    /**
     * Table
     * <p>
     * {@code http://schema.org/Table}
     * <p>
     * A table on a Web page.
     *
     * @see <a href="http://schema.org/Table">Table</a>
     */
    public static final IRI Table;

    /**
     * TakeAction
     * <p>
     * {@code http://schema.org/TakeAction}
     * <p>
     * The act of gaining ownership of an object from an origin. Reciprocal
     * of GiveAction.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/GiveAction&quot;&gt;GiveAction&lt;/a&gt;:
     * The reciprocal of TakeAction.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/ReceiveAction&quot;&gt;ReceiveAction&lt;/a&gt;:
     * Unlike ReceiveAction, TakeAction implies that ownership has been
     * transfered.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/TakeAction">TakeAction</a>
     */
    public static final IRI TakeAction;

    /**
     * target
     * <p>
     * {@code http://schema.org/target}
     * <p>
     * Indicates a target EntryPoint for an Action.
     *
     * @see <a href="http://schema.org/target">target</a>
     */
    public static final IRI target;

    /**
     * targetCollection
     * <p>
     * {@code http://schema.org/targetCollection}
     * <p>
     * A sub property of object. The collection target of the action.
     *
     * @see <a href="http://schema.org/targetCollection">targetCollection</a>
     */
    public static final IRI targetCollection;

    /**
     * targetDescription
     * <p>
     * {@code http://schema.org/targetDescription}
     * <p>
     * The description of a node in an established educational framework.
     *
     * @see <a href="http://schema.org/targetDescription">targetDescription</a>
     */
    public static final IRI targetDescription;

    /**
     * targetName
     * <p>
     * {@code http://schema.org/targetName}
     * <p>
     * The name of a node in an established educational framework.
     *
     * @see <a href="http://schema.org/targetName">targetName</a>
     */
    public static final IRI targetName;

    /**
     * targetPlatform
     * <p>
     * {@code http://schema.org/targetPlatform}
     * <p>
     * Type of app development: phone, Metro style, desktop, XBox, etc.
     *
     * @see <a href="http://schema.org/targetPlatform">targetPlatform</a>
     */
    public static final IRI targetPlatform;

    /**
     * targetPopulation
     * <p>
     * {@code http://schema.org/targetPopulation}
     * <p>
     * Characteristics of the population for which this is intended, or which
     * typically uses it, e.g. &#39;adults&#39;.
     *
     * @see <a href="http://schema.org/targetPopulation">targetPopulation</a>
     */
    public static final IRI targetPopulation;

    /**
     * targetProduct
     * <p>
     * {@code http://schema.org/targetProduct}
     * <p>
     * Target Operating System / Product to which the code applies.  If
     * applies to several versions, just the product name can be used.
     *
     * @see <a href="http://schema.org/targetProduct">targetProduct</a>
     */
    public static final IRI targetProduct;

    /**
     * targetUrl
     * <p>
     * {@code http://schema.org/targetUrl}
     * <p>
     * The URL of a node in an established educational framework.
     *
     * @see <a href="http://schema.org/targetUrl">targetUrl</a>
     */
    public static final IRI targetUrl;

    /**
     * TattooParlor
     * <p>
     * {@code http://schema.org/TattooParlor}
     * <p>
     * A tattoo parlor.
     *
     * @see <a href="http://schema.org/TattooParlor">TattooParlor</a>
     */
    public static final IRI TattooParlor;

    /**
     * Taxi
     * <p>
     * {@code http://schema.org/Taxi}
     * <p>
     * A taxi.
     *
     * @see <a href="http://schema.org/Taxi">Taxi</a>
     */
    public static final IRI Taxi;

    /**
     * taxID
     * <p>
     * {@code http://schema.org/taxID}
     * <p>
     * The Tax / Fiscal ID of the organization or person, e.g. the TIN in the
     * US or the CIF/NIF in Spain.
     *
     * @see <a href="http://schema.org/taxID">taxID</a>
     */
    public static final IRI taxID;

    /**
     * TaxiReservation
     * <p>
     * {@code http://schema.org/TaxiReservation}
     * <p>
     * A reservation for a taxi.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Note: This type is
     * for information about actual reservations, e.g. in confirmation emails
     * or HTML pages with individual confirmations of reservations. For
     * offers of tickets, use &lt;a
     * href=&quot;http://schema.org/Offer&quot;&gt;Offer&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/TaxiReservation">TaxiReservation</a>
     */
    public static final IRI TaxiReservation;

    /**
     * TaxiService
     * <p>
     * {@code http://schema.org/TaxiService}
     * <p>
     * A service for a vehicle for hire with a driver for local travel. Fares
     * are usually calculated based on distance traveled.
     *
     * @see <a href="http://schema.org/TaxiService">TaxiService</a>
     */
    public static final IRI TaxiService;

    /**
     * TaxiStand
     * <p>
     * {@code http://schema.org/TaxiStand}
     * <p>
     * A taxi stand.
     *
     * @see <a href="http://schema.org/TaxiStand">TaxiStand</a>
     */
    public static final IRI TaxiStand;

    /**
     * TechArticle
     * <p>
     * {@code http://schema.org/TechArticle}
     * <p>
     * A technical article - Example: How-to (task) topics, step-by-step,
     * procedural troubleshooting, specifications, etc.
     *
     * @see <a href="http://schema.org/TechArticle">TechArticle</a>
     */
    public static final IRI TechArticle;

    /**
     * telephone
     * <p>
     * {@code http://schema.org/telephone}
     * <p>
     * The telephone number.
     *
     * @see <a href="http://schema.org/telephone">telephone</a>
     */
    public static final IRI telephone;

    /**
     * TelevisionChannel
     * <p>
     * {@code http://schema.org/TelevisionChannel}
     * <p>
     * A unique instance of a television BroadcastService on a
     * CableOrSatelliteService lineup.
     *
     * @see <a href="http://schema.org/TelevisionChannel">TelevisionChannel</a>
     */
    public static final IRI TelevisionChannel;

    /**
     * TelevisionStation
     * <p>
     * {@code http://schema.org/TelevisionStation}
     * <p>
     * A television station.
     *
     * @see <a href="http://schema.org/TelevisionStation">TelevisionStation</a>
     */
    public static final IRI TelevisionStation;

    /**
     * temporal
     * <p>
     * {@code http://schema.org/temporal}
     * <p>
     * The range of temporal applicability of a dataset, e.g. for a 2011
     * census dataset, the year 2011 (in ISO 8601 time interval format).
     *
     * @see <a href="http://schema.org/temporal">temporal</a>
     */
    public static final IRI temporal;

    /**
     * temporalCoverage
     * <p>
     * {@code http://schema.org/temporalCoverage}
     * <p>
     * The temporalCoverage of a CreativeWork indicates the period that the
     * content applies to, i.e. that it describes, either as a DateTime or as
     * a textual string indicating a time period in &lt;a
     * href=&quot;https://en.wikipedia.org/wiki/ISO_8601#Time_intervals&quot;&gt;ISO
     * 8601 time interval format&lt;/a&gt;. In
     * the case of a Dataset it
     * will typically indicate the relevant time period in a precise notation
     * (e.g. for a 2011 census dataset, the year 2011 would be written
     * &quot;2011/2012&quot;). Other forms of content e.g. ScholarlyArticle,
     * Book, TVSeries or TVEpisode may indicate their temporalCoverage in
     * broader terms - textually or via well-known URL.
     * Written works
     * such as books may sometimes have precise temporal coverage too, e.g. a
     * work set in 1939 - 1945 can be indicated in ISO 8601 interval format
     * format via &quot;1939/1945&quot;.
     *
     * @see <a href="http://schema.org/temporalCoverage">temporalCoverage</a>
     */
    public static final IRI temporalCoverage;

    /**
     * TennisComplex
     * <p>
     * {@code http://schema.org/TennisComplex}
     * <p>
     * A tennis complex.
     *
     * @see <a href="http://schema.org/TennisComplex">TennisComplex</a>
     */
    public static final IRI TennisComplex;

    /**
     * termCode
     * <p>
     * {@code http://schema.org/termCode}
     * <p>
     * A code that identifies this &lt;a
     * href=&quot;http://schema.org/DefinedTerm&quot;&gt;DefinedTerm&lt;/a&gt;
     * within a &lt;a
     * href=&quot;http://schema.org/DefinedTermSet&quot;&gt;DefinedTermSet&lt;/a&gt;
     *
     * @see <a href="http://schema.org/termCode">termCode</a>
     */
    public static final IRI termCode;

    /**
     * termsOfService
     * <p>
     * {@code http://schema.org/termsOfService}
     * <p>
     * Human-readable terms of service documentation.
     *
     * @see <a href="http://schema.org/termsOfService">termsOfService</a>
     */
    public static final IRI termsOfService;

    /**
     * text
     * <p>
     * {@code http://schema.org/text}
     * <p>
     * The textual content of this CreativeWork.
     *
     * @see <a href="http://schema.org/text">text</a>
     */
    public static final IRI text;

    /**
     * Text
     * <p>
     * {@code http://schema.org/Text}
     * <p>
     * Data type: Text.
     *
     * @see <a href="http://schema.org/Text">Text</a>
     */
    public static final IRI Text;

    /**
     * TextDigitalDocument
     * <p>
     * {@code http://schema.org/TextDigitalDocument}
     * <p>
     * A file composed primarily of text.
     *
     * @see <a href="http://schema.org/TextDigitalDocument">TextDigitalDocument</a>
     */
    public static final IRI TextDigitalDocument;

    /**
     * TheaterEvent
     * <p>
     * {@code http://schema.org/TheaterEvent}
     * <p>
     * Event type: Theater performance.
     *
     * @see <a href="http://schema.org/TheaterEvent">TheaterEvent</a>
     */
    public static final IRI TheaterEvent;

    /**
     * TheaterGroup
     * <p>
     * {@code http://schema.org/TheaterGroup}
     * <p>
     * A theater group or company, for example, the Royal Shakespeare Company
     * or Druid Theatre.
     *
     * @see <a href="http://schema.org/TheaterGroup">TheaterGroup</a>
     */
    public static final IRI TheaterGroup;

    /**
     * TherapeuticProcedure
     * <p>
     * {@code http://schema.org/TherapeuticProcedure}
     * <p>
     * A medical procedure intended primarily for therapeutic purposes, aimed
     * at improving a health condition.
     *
     * @see <a href="http://schema.org/TherapeuticProcedure">TherapeuticProcedure</a>
     */
    public static final IRI TherapeuticProcedure;

    /**
     * Thesis
     * <p>
     * {@code http://schema.org/Thesis}
     * <p>
     * A thesis or dissertation document submitted in support of candidature
     * for an academic degree or professional qualification.
     *
     * @see <a href="http://schema.org/Thesis">Thesis</a>
     */
    public static final IRI Thesis;

    /**
     * Thing
     * <p>
     * {@code http://schema.org/Thing}
     * <p>
     * The most generic type of item.
     *
     * @see <a href="http://schema.org/Thing">Thing</a>
     */
    public static final IRI Thing;

    /**
     * thumbnail
     * <p>
     * {@code http://schema.org/thumbnail}
     * <p>
     * Thumbnail image for an image or video.
     *
     * @see <a href="http://schema.org/thumbnail">thumbnail</a>
     */
    public static final IRI thumbnail;

    /**
     * thumbnailUrl
     * <p>
     * {@code http://schema.org/thumbnailUrl}
     * <p>
     * A thumbnail image relevant to the Thing.
     *
     * @see <a href="http://schema.org/thumbnailUrl">thumbnailUrl</a>
     */
    public static final IRI thumbnailUrl;

    /**
     * tickerSymbol
     * <p>
     * {@code http://schema.org/tickerSymbol}
     * <p>
     * The exchange traded instrument associated with a Corporation object.
     * The tickerSymbol is expressed as an exchange and an instrument name
     * separated by a space character. For the exchange component of the
     * tickerSymbol attribute, we recommend using the controlled vocabulary
     * of Market Identifier Codes (MIC) specified in ISO15022.
     *
     * @see <a href="http://schema.org/tickerSymbol">tickerSymbol</a>
     */
    public static final IRI tickerSymbol;

    /**
     * Ticket
     * <p>
     * {@code http://schema.org/Ticket}
     * <p>
     * Used to describe a ticket to an event, a flight, a bus ride, etc.
     *
     * @see <a href="http://schema.org/Ticket">Ticket</a>
     */
    public static final IRI Ticket;

    /**
     * ticketedSeat
     * <p>
     * {@code http://schema.org/ticketedSeat}
     * <p>
     * The seat associated with the ticket.
     *
     * @see <a href="http://schema.org/ticketedSeat">ticketedSeat</a>
     */
    public static final IRI ticketedSeat;

    /**
     * ticketNumber
     * <p>
     * {@code http://schema.org/ticketNumber}
     * <p>
     * The unique identifier for the ticket.
     *
     * @see <a href="http://schema.org/ticketNumber">ticketNumber</a>
     */
    public static final IRI ticketNumber;

    /**
     * ticketToken
     * <p>
     * {@code http://schema.org/ticketToken}
     * <p>
     * Reference to an asset (e.g., Barcode, QR code image or PDF) usable for
     * entrance.
     *
     * @see <a href="http://schema.org/ticketToken">ticketToken</a>
     */
    public static final IRI ticketToken;

    /**
     * TieAction
     * <p>
     * {@code http://schema.org/TieAction}
     * <p>
     * The act of reaching a draw in a competitive activity.
     *
     * @see <a href="http://schema.org/TieAction">TieAction</a>
     */
    public static final IRI TieAction;

    /**
     * Time
     * <p>
     * {@code http://schema.org/Time}
     * <p>
     * A point in time recurring on multiple days in the form
     * hh:mm:ss[Z|(+|-)hh:mm] (see &lt;a
     * href=&quot;http://www.w3.org/TR/xmlschema-2/#time&quot;&gt;XML schema
     * for details&lt;/a&gt;).
     *
     * @see <a href="http://schema.org/Time">Time</a>
     */
    public static final IRI Time;

    /**
     * timeRequired
     * <p>
     * {@code http://schema.org/timeRequired}
     * <p>
     * Approximate or typical time it takes to work with or through this
     * learning resource for the typical intended target audience, e.g.
     * &#39;P30M&#39;, &#39;P1H25M&#39;.
     *
     * @see <a href="http://schema.org/timeRequired">timeRequired</a>
     */
    public static final IRI timeRequired;

    /**
     * TipAction
     * <p>
     * {@code http://schema.org/TipAction}
     * <p>
     * The act of giving money voluntarily to a beneficiary in recognition of
     * services rendered.
     *
     * @see <a href="http://schema.org/TipAction">TipAction</a>
     */
    public static final IRI TipAction;

    /**
     * TireShop
     * <p>
     * {@code http://schema.org/TireShop}
     * <p>
     * A tire shop.
     *
     * @see <a href="http://schema.org/TireShop">TireShop</a>
     */
    public static final IRI TireShop;

    /**
     * tissueSample
     * <p>
     * {@code http://schema.org/tissueSample}
     * <p>
     * The type of tissue sample required for the test.
     *
     * @see <a href="http://schema.org/tissueSample">tissueSample</a>
     */
    public static final IRI tissueSample;

    /**
     * title
     * <p>
     * {@code http://schema.org/title}
     * <p>
     * The title of the job.
     *
     * @see <a href="http://schema.org/title">title</a>
     */
    public static final IRI title;

    /**
     * toLocation
     * <p>
     * {@code http://schema.org/toLocation}
     * <p>
     * A sub property of location. The final location of the object or the
     * agent after the action.
     *
     * @see <a href="http://schema.org/toLocation">toLocation</a>
     */
    public static final IRI toLocation;

    /**
     * tongueWeight
     * <p>
     * {@code http://schema.org/tongueWeight}
     * <p>
     * The permitted vertical load (TWR) of a trailer attached to the
     * vehicle. Also referred to as Tongue Load Rating (TLR) or Vertical Load
     * Rating (VLR)&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s): KGM for
     * kilogram, LBR for
     * pound&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;Note 1: You can
     * indicate additional information in the &lt;a
     * href=&quot;http://schema.org/name&quot;&gt;name&lt;/a&gt; of the &lt;a
     * href=&quot;http://schema.org/QuantitativeValue&quot;&gt;QuantitativeValue&lt;/a&gt;
     * node.&lt;/li&gt;
     * &lt;li&gt;Note 2: You may also link to a &lt;a
     * href=&quot;http://schema.org/QualitativeValue&quot;&gt;QualitativeValue&lt;/a&gt;
     * node that provides additional information using &lt;a
     * href=&quot;http://schema.org/valueReference&quot;&gt;valueReference&lt;/a&gt;.&lt;/li&gt;
     * &lt;li&gt;Note
     * 3: Note that you can use &lt;a
     * href=&quot;http://schema.org/minValue&quot;&gt;minValue&lt;/a&gt; and
     * &lt;a
     * href=&quot;http://schema.org/maxValue&quot;&gt;maxValue&lt;/a&gt; to
     * indicate ranges.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/tongueWeight">tongueWeight</a>
     */
    public static final IRI tongueWeight;

    /**
     * tool
     * <p>
     * {@code http://schema.org/tool}
     * <p>
     * A sub property of instrument. An object used (but not consumed) when
     * performing instructions or a direction.
     *
     * @see <a href="http://schema.org/tool">tool</a>
     */
    public static final IRI tool;

    /**
     * toRecipient
     * <p>
     * {@code http://schema.org/toRecipient}
     * <p>
     * A sub property of recipient. The recipient who was directly sent the
     * message.
     *
     * @see <a href="http://schema.org/toRecipient">toRecipient</a>
     */
    public static final IRI toRecipient;

    /**
     * torque
     * <p>
     * {@code http://schema.org/torque}
     * <p>
     * The torque (turning force) of the vehicle&#39;s
     * engine.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s): NU for newton
     * metre (N m), F17 for pound-force per foot, or F48 for pound-force per
     * inch&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;Note 1: You can link
     * to information about how the given value has been determined (e.g.
     * reference RPM) using the &lt;a
     * href=&quot;http://schema.org/valueReference&quot;&gt;valueReference&lt;/a&gt;
     * property.&lt;/li&gt;
     * &lt;li&gt;Note 2: You can use &lt;a
     * href=&quot;http://schema.org/minValue&quot;&gt;minValue&lt;/a&gt; and
     * &lt;a
     * href=&quot;http://schema.org/maxValue&quot;&gt;maxValue&lt;/a&gt; to
     * indicate ranges.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/torque">torque</a>
     */
    public static final IRI torque;

    /**
     * totalPaymentDue
     * <p>
     * {@code http://schema.org/totalPaymentDue}
     * <p>
     * The total amount due.
     *
     * @see <a href="http://schema.org/totalPaymentDue">totalPaymentDue</a>
     */
    public static final IRI totalPaymentDue;

    /**
     * totalPrice
     * <p>
     * {@code http://schema.org/totalPrice}
     * <p>
     * The total price for the reservation or ticket, including applicable
     * taxes, shipping, etc.
     *
     * @see <a href="http://schema.org/totalPrice">totalPrice</a>
     */
    public static final IRI totalPrice;

    /**
     * totalTime
     * <p>
     * {@code http://schema.org/totalTime}
     * <p>
     * The total time required to perform instructions or a direction
     * (including time to prepare the supplies), in &lt;a
     * href=&quot;http://en.wikipedia.org/wiki/ISO_8601&quot;&gt;ISO 8601
     * duration format&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/totalTime">totalTime</a>
     */
    public static final IRI totalTime;

    /**
     * TouristAttraction
     * <p>
     * {@code http://schema.org/TouristAttraction}
     * <p>
     * A tourist attraction.  In principle any Thing can be a &lt;a
     * href=&quot;http://schema.org/TouristAttraction&quot;&gt;TouristAttraction&lt;/a&gt;,
     * from a &lt;a
     * href=&quot;http://schema.org/Mountain&quot;&gt;Mountain&lt;/a&gt; and
     * &lt;a
     * href=&quot;http://schema.org/LandmarksOrHistoricalBuildings&quot;&gt;LandmarksOrHistoricalBuildings&lt;/a&gt;
     * to a &lt;a
     * href=&quot;http://schema.org/LocalBusiness&quot;&gt;LocalBusiness&lt;/a&gt;.
     * This Type can be used on its own to describe a general &lt;a
     * href=&quot;http://schema.org/TourstAttraction&quot;&gt;TourstAttraction&lt;/a&gt;,
     * or be used as an &lt;a
     * href=&quot;http://schema.org/additionalType&quot;&gt;additionalType&lt;/a&gt;
     * to add tourist attraction properties to any other type.  (See examples
     * below)
     *
     * @see <a href="http://schema.org/TouristAttraction">TouristAttraction</a>
     */
    public static final IRI TouristAttraction;

    /**
     * TouristDestination
     * <p>
     * {@code http://schema.org/TouristDestination}
     * <p>
     * A tourist destination. In principle any &lt;a
     * href=&quot;http://schema.org/Place&quot;&gt;Place&lt;/a&gt; can be a
     * &lt;a
     * href=&quot;http://schema.org/TouristDestination&quot;&gt;TouristDestination&lt;/a&gt;
     * from a &lt;a
     * href=&quot;http://schema.org/City&quot;&gt;City&lt;/a&gt;, &lt;a
     * href=&quot;http://schema.org/Region&quot;&gt;Region&lt;/a&gt; or &lt;a
     * href=&quot;http://schema.org/Country&quot;&gt;Country&lt;/a&gt; to an
     * &lt;a
     * href=&quot;http://schema.org/AmusementPark&quot;&gt;AmusementPark&lt;/a&gt;
     * or &lt;a href=&quot;http://schema.org/Hotel&quot;&gt;Hotel&lt;/a&gt;.
     * This Type can be used on its own to describe a general &lt;a
     * href=&quot;http://schema.org/TourstDestination&quot;&gt;TourstDestination&lt;/a&gt;,
     * or be used as an &lt;a
     * href=&quot;http://schema.org/additionalType&quot;&gt;additionalType&lt;/a&gt;
     * to add tourist relevant properties to any other &lt;a
     * href=&quot;http://schema.org/Place&quot;&gt;Place&lt;/a&gt;.  A &lt;a
     * href=&quot;http://schema.org/TouristDestination&quot;&gt;TouristDestination&lt;/a&gt;
     * is defined as a &lt;a
     * href=&quot;http://schema.org/Place&quot;&gt;Place&lt;/a&gt; that
     * contains, or is colocated with, one or more &lt;a
     * href=&quot;http://schema.org/TourstAttractions&quot;&gt;TourstAttractions&lt;/a&gt;,
     * often linked by a similar theme or interest to a particular &lt;a
     * href=&quot;http://schema.org/touristType&quot;&gt;touristType&lt;/a&gt;.
     * The &lt;a href=&quot;http://www2.unwto.org/&quot;&gt;UNWTO&lt;/a&gt;
     * defines Destination (main destination of a tourism trip) as the place
     * visited that is central to the decision to take the trip.
     * (See
     * examples below).
     *
     * @see <a href="http://schema.org/TouristDestination">TouristDestination</a>
     */
    public static final IRI TouristDestination;

    /**
     * TouristInformationCenter
     * <p>
     * {@code http://schema.org/TouristInformationCenter}
     * <p>
     * A tourist information center.
     *
     * @see <a href="http://schema.org/TouristInformationCenter">TouristInformationCenter</a>
     */
    public static final IRI TouristInformationCenter;

    /**
     * TouristTrip
     * <p>
     * {@code http://schema.org/TouristTrip}
     * <p>
     * A tourist trip. A created itinerary of visits to one or more places of
     * interest (&lt;a
     * href=&quot;http://schema.org/TouristAttraction&quot;&gt;TouristAttraction&lt;/a&gt;/&lt;a
     * href=&quot;http://schema.org/TouristDestination&quot;&gt;TouristDestination&lt;/a&gt;)
     * often linked by a similar theme, geographic area, or interest to a
     * particular &lt;a
     * href=&quot;http://schema.org/touristType&quot;&gt;touristType&lt;/a&gt;.
     * The &lt;a href=&quot;http://www2.unwto.org/&quot;&gt;UNWTO&lt;/a&gt;
     * defines tourism trip as the Trip taken by visitors.
     * (See examples
     * below).
     *
     * @see <a href="http://schema.org/TouristTrip">TouristTrip</a>
     */
    public static final IRI TouristTrip;

    /**
     * touristType
     * <p>
     * {@code http://schema.org/touristType}
     * <p>
     * Attraction suitable for type(s) of tourist. eg. Children, visitors
     * from a particular country, etc.
     *
     * @see <a href="http://schema.org/touristType">touristType</a>
     */
    public static final IRI touristType;

    /**
     * ToyStore
     * <p>
     * {@code http://schema.org/ToyStore}
     * <p>
     * A toy store.
     *
     * @see <a href="http://schema.org/ToyStore">ToyStore</a>
     */
    public static final IRI ToyStore;

    /**
     * track
     * <p>
     * {@code http://schema.org/track}
     * <p>
     * A music recording (track)&amp;#x2014;usually a single song. If an
     * ItemList is given, the list should contain items of type
     * MusicRecording.
     *
     * @see <a href="http://schema.org/track">track</a>
     */
    public static final IRI track;

    /**
     * TrackAction
     * <p>
     * {@code http://schema.org/TrackAction}
     * <p>
     * An agent tracks an object for updates.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/FollowAction&quot;&gt;FollowAction&lt;/a&gt;:
     * Unlike FollowAction, TrackAction refers to the interest on the
     * location of innanimates objects.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/SubscribeAction&quot;&gt;SubscribeAction&lt;/a&gt;:
     * Unlike SubscribeAction, TrackAction refers to  the interest on the
     * location of innanimate objects.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/TrackAction">TrackAction</a>
     */
    public static final IRI TrackAction;

    /**
     * trackingNumber
     * <p>
     * {@code http://schema.org/trackingNumber}
     * <p>
     * Shipper tracking number.
     *
     * @see <a href="http://schema.org/trackingNumber">trackingNumber</a>
     */
    public static final IRI trackingNumber;

    /**
     * trackingUrl
     * <p>
     * {@code http://schema.org/trackingUrl}
     * <p>
     * Tracking url for the parcel delivery.
     *
     * @see <a href="http://schema.org/trackingUrl">trackingUrl</a>
     */
    public static final IRI trackingUrl;

    /**
     * tracks
     * <p>
     * {@code http://schema.org/tracks}
     * <p>
     * A music recording (track)&amp;#x2014;usually a single song.
     *
     * @see <a href="http://schema.org/tracks">tracks</a>
     */
    public static final IRI tracks;

    /**
     * TradeAction
     * <p>
     * {@code http://schema.org/TradeAction}
     * <p>
     * The act of participating in an exchange of goods and services for
     * monetary compensation. An agent trades an object, product or service
     * with a participant in exchange for a one time or periodic payment.
     *
     * @see <a href="http://schema.org/TradeAction">TradeAction</a>
     */
    public static final IRI TradeAction;

    /**
     * trailer
     * <p>
     * {@code http://schema.org/trailer}
     * <p>
     * The trailer of a movie or tv/radio series, season, episode, etc.
     *
     * @see <a href="http://schema.org/trailer">trailer</a>
     */
    public static final IRI trailer;

    /**
     * trailerWeight
     * <p>
     * {@code http://schema.org/trailerWeight}
     * <p>
     * The permitted weight of a trailer attached to the
     * vehicle.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s): KGM for
     * kilogram, LBR for pound
     * Note 1: You can indicate additional
     * information in the &lt;a
     * href=&quot;http://schema.org/name&quot;&gt;name&lt;/a&gt; of the &lt;a
     * href=&quot;http://schema.org/QuantitativeValue&quot;&gt;QuantitativeValue&lt;/a&gt;
     * node.
     * Note 2: You may also link to a &lt;a
     * href=&quot;http://schema.org/QualitativeValue&quot;&gt;QualitativeValue&lt;/a&gt;
     * node that provides additional information using &lt;a
     * href=&quot;http://schema.org/valueReference&quot;&gt;valueReference&lt;/a&gt;.
     * <p>
     * Note 3: Note that you can use &lt;a
     * href=&quot;http://schema.org/minValue&quot;&gt;minValue&lt;/a&gt; and
     * &lt;a
     * href=&quot;http://schema.org/maxValue&quot;&gt;maxValue&lt;/a&gt; to
     * indicate ranges.
     *
     * @see <a href="http://schema.org/trailerWeight">trailerWeight</a>
     */
    public static final IRI trailerWeight;

    /**
     * trainName
     * <p>
     * {@code http://schema.org/trainName}
     * <p>
     * The name of the train (e.g. The Orient Express).
     *
     * @see <a href="http://schema.org/trainName">trainName</a>
     */
    public static final IRI trainName;

    /**
     * trainNumber
     * <p>
     * {@code http://schema.org/trainNumber}
     * <p>
     * The unique identifier for the train.
     *
     * @see <a href="http://schema.org/trainNumber">trainNumber</a>
     */
    public static final IRI trainNumber;

    /**
     * TrainReservation
     * <p>
     * {@code http://schema.org/TrainReservation}
     * <p>
     * A reservation for train travel.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Note: This type
     * is for information about actual reservations, e.g. in confirmation
     * emails or HTML pages with individual confirmations of reservations.
     * For offers of tickets, use &lt;a
     * href=&quot;http://schema.org/Offer&quot;&gt;Offer&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/TrainReservation">TrainReservation</a>
     */
    public static final IRI TrainReservation;

    /**
     * TrainStation
     * <p>
     * {@code http://schema.org/TrainStation}
     * <p>
     * A train station.
     *
     * @see <a href="http://schema.org/TrainStation">TrainStation</a>
     */
    public static final IRI TrainStation;

    /**
     * TrainTrip
     * <p>
     * {@code http://schema.org/TrainTrip}
     * <p>
     * A trip on a commercial train line.
     *
     * @see <a href="http://schema.org/TrainTrip">TrainTrip</a>
     */
    public static final IRI TrainTrip;

    /**
     * transcript
     * <p>
     * {@code http://schema.org/transcript}
     * <p>
     * If this MediaObject is an AudioObject or VideoObject, the transcript
     * of that object.
     *
     * @see <a href="http://schema.org/transcript">transcript</a>
     */
    public static final IRI transcript;

    /**
     * transFatContent
     * <p>
     * {@code http://schema.org/transFatContent}
     * <p>
     * The number of grams of trans fat.
     *
     * @see <a href="http://schema.org/transFatContent">transFatContent</a>
     */
    public static final IRI transFatContent;

    /**
     * TransferAction
     * <p>
     * {@code http://schema.org/TransferAction}
     * <p>
     * The act of transferring/moving (abstract or concrete) animate or
     * inanimate objects from one place to another.
     *
     * @see <a href="http://schema.org/TransferAction">TransferAction</a>
     */
    public static final IRI TransferAction;

    /**
     * translationOfWork
     * <p>
     * {@code http://schema.org/translationOfWork}
     * <p>
     * The work that this work has been translated from. e.g. 物种起源 is a
     * translationOf “On the Origin of Species”
     *
     * @see <a href="http://schema.org/translationOfWork">translationOfWork</a>
     */
    public static final IRI translationOfWork;

    /**
     * translator
     * <p>
     * {@code http://schema.org/translator}
     * <p>
     * Organization or person who adapts a creative work to different
     * languages, regional differences and technical requirements of a target
     * market, or that translates during some event.
     *
     * @see <a href="http://schema.org/translator">translator</a>
     */
    public static final IRI translator;

    /**
     * transmissionMethod
     * <p>
     * {@code http://schema.org/transmissionMethod}
     * <p>
     * How the disease spreads, either as a route or vector, for example
     * &#39;direct contact&#39;, &#39;Aedes aegypti&#39;, etc.
     *
     * @see <a href="http://schema.org/transmissionMethod">transmissionMethod</a>
     */
    public static final IRI transmissionMethod;

    /**
     * TravelAction
     * <p>
     * {@code http://schema.org/TravelAction}
     * <p>
     * The act of traveling from an fromLocation to a destination by a
     * specified mode of transport, optionally with participants.
     *
     * @see <a href="http://schema.org/TravelAction">TravelAction</a>
     */
    public static final IRI TravelAction;

    /**
     * TravelAgency
     * <p>
     * {@code http://schema.org/TravelAgency}
     * <p>
     * A travel agency.
     *
     * @see <a href="http://schema.org/TravelAgency">TravelAgency</a>
     */
    public static final IRI TravelAgency;

    /**
     * TreatmentIndication
     * <p>
     * {@code http://schema.org/TreatmentIndication}
     * <p>
     * An indication for treating an underlying condition, symptom, etc.
     *
     * @see <a href="http://schema.org/TreatmentIndication">TreatmentIndication</a>
     */
    public static final IRI TreatmentIndication;

    /**
     * trialDesign
     * <p>
     * {@code http://schema.org/trialDesign}
     * <p>
     * Specifics about the trial design (enumerated).
     *
     * @see <a href="http://schema.org/trialDesign">trialDesign</a>
     */
    public static final IRI trialDesign;

    /**
     * tributary
     * <p>
     * {@code http://schema.org/tributary}
     * <p>
     * The anatomical or organ system that the vein flows into; a larger
     * structure that the vein connects to.
     *
     * @see <a href="http://schema.org/tributary">tributary</a>
     */
    public static final IRI tributary;

    /**
     * Trip
     * <p>
     * {@code http://schema.org/Trip}
     * <p>
     * A trip or journey. An itinerary of visits to one or more places.
     *
     * @see <a href="http://schema.org/Trip">Trip</a>
     */
    public static final IRI Trip;

    /**
     * True
     * <p>
     * {@code http://schema.org/True}
     * <p>
     * The boolean value true.
     *
     * @see <a href="http://schema.org/True">True</a>
     */
    public static final IRI True;

    /**
     * TVClip
     * <p>
     * {@code http://schema.org/TVClip}
     * <p>
     * A short TV program or a segment/part of a TV program.
     *
     * @see <a href="http://schema.org/TVClip">TVClip</a>
     */
    public static final IRI TVClip;

    /**
     * TVEpisode
     * <p>
     * {@code http://schema.org/TVEpisode}
     * <p>
     * A TV episode which can be part of a series or season.
     *
     * @see <a href="http://schema.org/TVEpisode">TVEpisode</a>
     */
    public static final IRI TVEpisode;

    /**
     * TVSeason
     * <p>
     * {@code http://schema.org/TVSeason}
     * <p>
     * Season dedicated to TV broadcast and associated online delivery.
     *
     * @see <a href="http://schema.org/TVSeason">TVSeason</a>
     */
    public static final IRI TVSeason;

    /**
     * TVSeries
     * <p>
     * {@code http://schema.org/TVSeries}
     * <p>
     * CreativeWorkSeries dedicated to TV broadcast and associated online
     * delivery.
     *
     * @see <a href="http://schema.org/TVSeries">TVSeries</a>
     */
    public static final IRI TVSeries;

    /**
     * TypeAndQuantityNode
     * <p>
     * {@code http://schema.org/TypeAndQuantityNode}
     * <p>
     * A structured value indicating the quantity, unit of measurement, and
     * business function of goods included in a bundle offer.
     *
     * @see <a href="http://schema.org/TypeAndQuantityNode">TypeAndQuantityNode</a>
     */
    public static final IRI TypeAndQuantityNode;

    /**
     * typeOfBed
     * <p>
     * {@code http://schema.org/typeOfBed}
     * <p>
     * The type of bed to which the BedDetail refers, i.e. the type of bed
     * available in the quantity indicated by quantity.
     *
     * @see <a href="http://schema.org/typeOfBed">typeOfBed</a>
     */
    public static final IRI typeOfBed;

    /**
     * typeOfGood
     * <p>
     * {@code http://schema.org/typeOfGood}
     * <p>
     * The product that this structured value is referring to.
     *
     * @see <a href="http://schema.org/typeOfGood">typeOfGood</a>
     */
    public static final IRI typeOfGood;

    /**
     * typicalAgeRange
     * <p>
     * {@code http://schema.org/typicalAgeRange}
     * <p>
     * The typical expected age range, e.g. &#39;7-9&#39;, &#39;11-&#39;.
     *
     * @see <a href="http://schema.org/typicalAgeRange">typicalAgeRange</a>
     */
    public static final IRI typicalAgeRange;

    /**
     * typicalTest
     * <p>
     * {@code http://schema.org/typicalTest}
     * <p>
     * A medical test typically performed given this condition.
     *
     * @see <a href="http://schema.org/typicalTest">typicalTest</a>
     */
    public static final IRI typicalTest;

    /**
     * underName
     * <p>
     * {@code http://schema.org/underName}
     * <p>
     * The person or organization the reservation or ticket is for.
     *
     * @see <a href="http://schema.org/underName">underName</a>
     */
    public static final IRI underName;

    /**
     * unitCode
     * <p>
     * {@code http://schema.org/unitCode}
     * <p>
     * The unit of measurement given using the UN/CEFACT Common Code (3
     * characters) or a URL. Other codes than the UN/CEFACT Common Code may
     * be used with a prefix followed by a colon.
     *
     * @see <a href="http://schema.org/unitCode">unitCode</a>
     */
    public static final IRI unitCode;

    /**
     * UnitPriceSpecification
     * <p>
     * {@code http://schema.org/UnitPriceSpecification}
     * <p>
     * The price asked for a given offer by the respective organization or
     * person.
     *
     * @see <a href="http://schema.org/UnitPriceSpecification">UnitPriceSpecification</a>
     */
    public static final IRI UnitPriceSpecification;

    /**
     * unitText
     * <p>
     * {@code http://schema.org/unitText}
     * <p>
     * A string or text indicating the unit of measurement. Useful if you
     * cannot provide a standard unit code for
     * &lt;a
     * href=&#39;unitCode&#39;&gt;unitCode&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/unitText">unitText</a>
     */
    public static final IRI unitText;

    /**
     * unnamedSourcesPolicy
     * <p>
     * {@code http://schema.org/unnamedSourcesPolicy}
     * <p>
     * For an &lt;a
     * href=&quot;http://schema.org/Organization&quot;&gt;Organization&lt;/a&gt;
     * (typically a &lt;a
     * href=&quot;http://schema.org/NewsMediaOrganization&quot;&gt;NewsMediaOrganization&lt;/a&gt;),
     * a statement about policy on use of unnamed sources and the decision
     * process required.
     *
     * @see <a href="http://schema.org/unnamedSourcesPolicy">unnamedSourcesPolicy</a>
     */
    public static final IRI unnamedSourcesPolicy;

    /**
     * UnRegisterAction
     * <p>
     * {@code http://schema.org/UnRegisterAction}
     * <p>
     * The act of un-registering from a
     * service.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Related
     * actions:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/RegisterAction&quot;&gt;RegisterAction&lt;/a&gt;:
     * antonym of UnRegisterAction.&lt;/li&gt;
     * &lt;li&gt;&lt;a
     * href=&quot;http://schema.org/Leave&quot;&gt;Leave&lt;/a&gt;: Unlike
     * LeaveAction, UnRegisterAction implies that you are unregistering from
     * a service you werer previously registered, rather than leaving a
     * team/group of people.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/UnRegisterAction">UnRegisterAction</a>
     */
    public static final IRI UnRegisterAction;

    /**
     * unsaturatedFatContent
     * <p>
     * {@code http://schema.org/unsaturatedFatContent}
     * <p>
     * The number of grams of unsaturated fat.
     *
     * @see <a href="http://schema.org/unsaturatedFatContent">unsaturatedFatContent</a>
     */
    public static final IRI unsaturatedFatContent;

    /**
     * UpdateAction
     * <p>
     * {@code http://schema.org/UpdateAction}
     * <p>
     * The act of managing by changing/editing the state of the object.
     *
     * @see <a href="http://schema.org/UpdateAction">UpdateAction</a>
     */
    public static final IRI UpdateAction;

    /**
     * uploadDate
     * <p>
     * {@code http://schema.org/uploadDate}
     * <p>
     * Date when this media object was uploaded to this site.
     *
     * @see <a href="http://schema.org/uploadDate">uploadDate</a>
     */
    public static final IRI uploadDate;

    /**
     * upvoteCount
     * <p>
     * {@code http://schema.org/upvoteCount}
     * <p>
     * The number of upvotes this question, answer or comment has received
     * from the community.
     *
     * @see <a href="http://schema.org/upvoteCount">upvoteCount</a>
     */
    public static final IRI upvoteCount;

    /**
     * url
     * <p>
     * {@code http://schema.org/url}
     * <p>
     * URL of the item.
     *
     * @see <a href="http://schema.org/url">url</a>
     */
    public static final IRI url;

    /**
     * URL
     * <p>
     * {@code http://schema.org/URL}
     * <p>
     * Data type: URL.
     *
     * @see <a href="http://schema.org/URL">URL</a>
     */
    public static final IRI URL;

    /**
     * urlTemplate
     * <p>
     * {@code http://schema.org/urlTemplate}
     * <p>
     * An url template (RFC6570) that will be used to construct the target of
     * the execution of the action.
     *
     * @see <a href="http://schema.org/urlTemplate">urlTemplate</a>
     */
    public static final IRI urlTemplate;

    /**
     * UseAction
     * <p>
     * {@code http://schema.org/UseAction}
     * <p>
     * The act of applying an object to its intended purpose.
     *
     * @see <a href="http://schema.org/UseAction">UseAction</a>
     */
    public static final IRI UseAction;

    /**
     * usedToDiagnose
     * <p>
     * {@code http://schema.org/usedToDiagnose}
     * <p>
     * A condition the test is used to diagnose.
     *
     * @see <a href="http://schema.org/usedToDiagnose">usedToDiagnose</a>
     */
    public static final IRI usedToDiagnose;

    /**
     * UserBlocks
     * <p>
     * {@code http://schema.org/UserBlocks}
     * <p>
     * UserInteraction and its subtypes is an old way of talking about users
     * interacting with pages. It is generally better to use &lt;a
     * href=&quot;http://schema.org/Action&quot;&gt;Action&lt;/a&gt;-based
     * vocabulary, alongside types such as &lt;a
     * href=&quot;http://schema.org/Comment&quot;&gt;Comment&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/UserBlocks">UserBlocks</a>
     */
    public static final IRI UserBlocks;

    /**
     * UserCheckins
     * <p>
     * {@code http://schema.org/UserCheckins}
     * <p>
     * UserInteraction and its subtypes is an old way of talking about users
     * interacting with pages. It is generally better to use &lt;a
     * href=&quot;http://schema.org/Action&quot;&gt;Action&lt;/a&gt;-based
     * vocabulary, alongside types such as &lt;a
     * href=&quot;http://schema.org/Comment&quot;&gt;Comment&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/UserCheckins">UserCheckins</a>
     */
    public static final IRI UserCheckins;

    /**
     * UserComments
     * <p>
     * {@code http://schema.org/UserComments}
     * <p>
     * UserInteraction and its subtypes is an old way of talking about users
     * interacting with pages. It is generally better to use &lt;a
     * href=&quot;http://schema.org/Action&quot;&gt;Action&lt;/a&gt;-based
     * vocabulary, alongside types such as &lt;a
     * href=&quot;http://schema.org/Comment&quot;&gt;Comment&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/UserComments">UserComments</a>
     */
    public static final IRI UserComments;

    /**
     * UserDownloads
     * <p>
     * {@code http://schema.org/UserDownloads}
     * <p>
     * UserInteraction and its subtypes is an old way of talking about users
     * interacting with pages. It is generally better to use &lt;a
     * href=&quot;http://schema.org/Action&quot;&gt;Action&lt;/a&gt;-based
     * vocabulary, alongside types such as &lt;a
     * href=&quot;http://schema.org/Comment&quot;&gt;Comment&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/UserDownloads">UserDownloads</a>
     */
    public static final IRI UserDownloads;

    /**
     * UserInteraction
     * <p>
     * {@code http://schema.org/UserInteraction}
     * <p>
     * UserInteraction and its subtypes is an old way of talking about users
     * interacting with pages. It is generally better to use &lt;a
     * href=&quot;http://schema.org/Action&quot;&gt;Action&lt;/a&gt;-based
     * vocabulary, alongside types such as &lt;a
     * href=&quot;http://schema.org/Comment&quot;&gt;Comment&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/UserInteraction">UserInteraction</a>
     */
    public static final IRI UserInteraction;

    /**
     * userInteractionCount
     * <p>
     * {@code http://schema.org/userInteractionCount}
     * <p>
     * The number of interactions for the CreativeWork using the WebSite or
     * SoftwareApplication.
     *
     * @see <a href="http://schema.org/userInteractionCount">userInteractionCount</a>
     */
    public static final IRI userInteractionCount;

    /**
     * UserLikes
     * <p>
     * {@code http://schema.org/UserLikes}
     * <p>
     * UserInteraction and its subtypes is an old way of talking about users
     * interacting with pages. It is generally better to use &lt;a
     * href=&quot;http://schema.org/Action&quot;&gt;Action&lt;/a&gt;-based
     * vocabulary, alongside types such as &lt;a
     * href=&quot;http://schema.org/Comment&quot;&gt;Comment&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/UserLikes">UserLikes</a>
     */
    public static final IRI UserLikes;

    /**
     * UserPageVisits
     * <p>
     * {@code http://schema.org/UserPageVisits}
     * <p>
     * UserInteraction and its subtypes is an old way of talking about users
     * interacting with pages. It is generally better to use &lt;a
     * href=&quot;http://schema.org/Action&quot;&gt;Action&lt;/a&gt;-based
     * vocabulary, alongside types such as &lt;a
     * href=&quot;http://schema.org/Comment&quot;&gt;Comment&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/UserPageVisits">UserPageVisits</a>
     */
    public static final IRI UserPageVisits;

    /**
     * UserPlays
     * <p>
     * {@code http://schema.org/UserPlays}
     * <p>
     * UserInteraction and its subtypes is an old way of talking about users
     * interacting with pages. It is generally better to use &lt;a
     * href=&quot;http://schema.org/Action&quot;&gt;Action&lt;/a&gt;-based
     * vocabulary, alongside types such as &lt;a
     * href=&quot;http://schema.org/Comment&quot;&gt;Comment&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/UserPlays">UserPlays</a>
     */
    public static final IRI UserPlays;

    /**
     * UserPlusOnes
     * <p>
     * {@code http://schema.org/UserPlusOnes}
     * <p>
     * UserInteraction and its subtypes is an old way of talking about users
     * interacting with pages. It is generally better to use &lt;a
     * href=&quot;http://schema.org/Action&quot;&gt;Action&lt;/a&gt;-based
     * vocabulary, alongside types such as &lt;a
     * href=&quot;http://schema.org/Comment&quot;&gt;Comment&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/UserPlusOnes">UserPlusOnes</a>
     */
    public static final IRI UserPlusOnes;

    /**
     * UserReview
     * <p>
     * {@code http://schema.org/UserReview}
     * <p>
     * A review created by an end-user (e.g. consumer, purchaser, attendee
     * etc.), in contrast with &lt;a
     * href=&quot;http://schema.org/CriticReview&quot;&gt;CriticReview&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/UserReview">UserReview</a>
     */
    public static final IRI UserReview;

    /**
     * UserTweets
     * <p>
     * {@code http://schema.org/UserTweets}
     * <p>
     * UserInteraction and its subtypes is an old way of talking about users
     * interacting with pages. It is generally better to use &lt;a
     * href=&quot;http://schema.org/Action&quot;&gt;Action&lt;/a&gt;-based
     * vocabulary, alongside types such as &lt;a
     * href=&quot;http://schema.org/Comment&quot;&gt;Comment&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/UserTweets">UserTweets</a>
     */
    public static final IRI UserTweets;

    /**
     * usesDevice
     * <p>
     * {@code http://schema.org/usesDevice}
     * <p>
     * Device used to perform the test.
     *
     * @see <a href="http://schema.org/usesDevice">usesDevice</a>
     */
    public static final IRI usesDevice;

    /**
     * usesHealthPlanIdStandard
     * <p>
     * {@code http://schema.org/usesHealthPlanIdStandard}
     * <p>
     * The standard for interpreting thePlan ID. The preferred is
     * &quot;HIOS&quot;. See the Centers for Medicare &amp;amp; Medicaid
     * Services for more details.
     *
     * @see <a href="http://schema.org/usesHealthPlanIdStandard">usesHealthPlanIdStandard</a>
     */
    public static final IRI usesHealthPlanIdStandard;

    /**
     * validFor
     * <p>
     * {@code http://schema.org/validFor}
     * <p>
     * The time validity of the permit.
     *
     * @see <a href="http://schema.org/validFor">validFor</a>
     */
    public static final IRI validFor;

    /**
     * validFrom
     * <p>
     * {@code http://schema.org/validFrom}
     * <p>
     * The date when the item becomes valid.
     *
     * @see <a href="http://schema.org/validFrom">validFrom</a>
     */
    public static final IRI validFrom;

    /**
     * validIn
     * <p>
     * {@code http://schema.org/validIn}
     * <p>
     * The geographic area where the permit is valid.
     *
     * @see <a href="http://schema.org/validIn">validIn</a>
     */
    public static final IRI validIn;

    /**
     * validThrough
     * <p>
     * {@code http://schema.org/validThrough}
     * <p>
     * The date after when the item is not valid. For example the end of an
     * offer, salary period, or a period of opening hours.
     *
     * @see <a href="http://schema.org/validThrough">validThrough</a>
     */
    public static final IRI validThrough;

    /**
     * validUntil
     * <p>
     * {@code http://schema.org/validUntil}
     * <p>
     * The date when the item is no longer valid.
     *
     * @see <a href="http://schema.org/validUntil">validUntil</a>
     */
    public static final IRI validUntil;

    /**
     * value
     * <p>
     * {@code http://schema.org/value}
     * <p>
     * The value of the quantitative value or property value
     * node.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;For &lt;a
     * href=&quot;http://schema.org/QuantitativeValue&quot;&gt;QuantitativeValue&lt;/a&gt;
     * and &lt;a
     * href=&quot;http://schema.org/MonetaryAmount&quot;&gt;MonetaryAmount&lt;/a&gt;,
     * the recommended type for values is
     * &#39;Number&#39;.&lt;/li&gt;
     * &lt;li&gt;For &lt;a
     * href=&quot;http://schema.org/PropertyValue&quot;&gt;PropertyValue&lt;/a&gt;,
     * it can be &#39;Text;&#39;, &#39;Number&#39;, &#39;Boolean&#39;, or
     * &#39;StructuredValue&#39;.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/value">value</a>
     */
    public static final IRI value;

    /**
     * valueAddedTaxIncluded
     * <p>
     * {@code http://schema.org/valueAddedTaxIncluded}
     * <p>
     * Specifies whether the applicable value-added tax (VAT) is included in
     * the price specification or not.
     *
     * @see <a href="http://schema.org/valueAddedTaxIncluded">valueAddedTaxIncluded</a>
     */
    public static final IRI valueAddedTaxIncluded;

    /**
     * valueMaxLength
     * <p>
     * {@code http://schema.org/valueMaxLength}
     * <p>
     * Specifies the allowed range for number of characters in a literal
     * value.
     *
     * @see <a href="http://schema.org/valueMaxLength">valueMaxLength</a>
     */
    public static final IRI valueMaxLength;

    /**
     * valueMinLength
     * <p>
     * {@code http://schema.org/valueMinLength}
     * <p>
     * Specifies the minimum allowed range for number of characters in a
     * literal value.
     *
     * @see <a href="http://schema.org/valueMinLength">valueMinLength</a>
     */
    public static final IRI valueMinLength;

    /**
     * valueName
     * <p>
     * {@code http://schema.org/valueName}
     * <p>
     * Indicates the name of the PropertyValueSpecification to be used in URL
     * templates and form encoding in a manner analogous to HTML&#39;s
     * input@name.
     *
     * @see <a href="http://schema.org/valueName">valueName</a>
     */
    public static final IRI valueName;

    /**
     * valuePattern
     * <p>
     * {@code http://schema.org/valuePattern}
     * <p>
     * Specifies a regular expression for testing literal values according to
     * the HTML spec.
     *
     * @see <a href="http://schema.org/valuePattern">valuePattern</a>
     */
    public static final IRI valuePattern;

    /**
     * valueReference
     * <p>
     * {@code http://schema.org/valueReference}
     * <p>
     * A pointer to a secondary value that provides additional information on
     * the original value, e.g. a reference temperature.
     *
     * @see <a href="http://schema.org/valueReference">valueReference</a>
     */
    public static final IRI valueReference;

    /**
     * valueRequired
     * <p>
     * {@code http://schema.org/valueRequired}
     * <p>
     * Whether the property must be filled in to complete the action.
     * Default is false.
     *
     * @see <a href="http://schema.org/valueRequired">valueRequired</a>
     */
    public static final IRI valueRequired;

    /**
     * variableMeasured
     * <p>
     * {@code http://schema.org/variableMeasured}
     * <p>
     * The variableMeasured property can indicate (repeated as necessary) the
     * variables that are measured in some dataset, either described as text
     * or as pairs of identifier and description using PropertyValue.
     *
     * @see <a href="http://schema.org/variableMeasured">variableMeasured</a>
     */
    public static final IRI variableMeasured;

    /**
     * variantCover
     * <p>
     * {@code http://schema.org/variantCover}
     * <p>
     * A description of the variant cover
     * for the issue, if the issue is
     * a variant printing. For example, &quot;Bryan Hitch
     * Variant
     * Cover&quot; or &quot;2nd Printing Variant&quot;.
     *
     * @see <a href="http://schema.org/variantCover">variantCover</a>
     */
    public static final IRI variantCover;

    /**
     * vatID
     * <p>
     * {@code http://schema.org/vatID}
     * <p>
     * The Value-added Tax ID of the organization or person.
     *
     * @see <a href="http://schema.org/vatID">vatID</a>
     */
    public static final IRI vatID;

    /**
     * Vehicle
     * <p>
     * {@code http://schema.org/Vehicle}
     * <p>
     * A vehicle is a device that is designed or used to transport people or
     * cargo over land, water, air, or through space.
     *
     * @see <a href="http://schema.org/Vehicle">Vehicle</a>
     */
    public static final IRI Vehicle;

    /**
     * vehicleConfiguration
     * <p>
     * {@code http://schema.org/vehicleConfiguration}
     * <p>
     * A short text indicating the configuration of the vehicle, e.g.
     * &#39;5dr hatchback ST 2.5 MT 225 hp&#39; or &#39;limited edition&#39;.
     *
     * @see <a href="http://schema.org/vehicleConfiguration">vehicleConfiguration</a>
     */
    public static final IRI vehicleConfiguration;

    /**
     * vehicleEngine
     * <p>
     * {@code http://schema.org/vehicleEngine}
     * <p>
     * Information about the engine or engines of the vehicle.
     *
     * @see <a href="http://schema.org/vehicleEngine">vehicleEngine</a>
     */
    public static final IRI vehicleEngine;

    /**
     * vehicleIdentificationNumber
     * <p>
     * {@code http://schema.org/vehicleIdentificationNumber}
     * <p>
     * The Vehicle Identification Number (VIN) is a unique serial number used
     * by the automotive industry to identify individual motor vehicles.
     *
     * @see <a href="http://schema.org/vehicleIdentificationNumber">vehicleIdentificationNumber</a>
     */
    public static final IRI vehicleIdentificationNumber;

    /**
     * vehicleInteriorColor
     * <p>
     * {@code http://schema.org/vehicleInteriorColor}
     * <p>
     * The color or color combination of the interior of the vehicle.
     *
     * @see <a href="http://schema.org/vehicleInteriorColor">vehicleInteriorColor</a>
     */
    public static final IRI vehicleInteriorColor;

    /**
     * vehicleInteriorType
     * <p>
     * {@code http://schema.org/vehicleInteriorType}
     * <p>
     * The type or material of the interior of the vehicle (e.g. synthetic
     * fabric, leather, wood, etc.). While most interior types are
     * characterized by the material used, an interior type can also be based
     * on vehicle usage or target audience.
     *
     * @see <a href="http://schema.org/vehicleInteriorType">vehicleInteriorType</a>
     */
    public static final IRI vehicleInteriorType;

    /**
     * vehicleModelDate
     * <p>
     * {@code http://schema.org/vehicleModelDate}
     * <p>
     * The release date of a vehicle model (often used to differentiate
     * versions of the same make and model).
     *
     * @see <a href="http://schema.org/vehicleModelDate">vehicleModelDate</a>
     */
    public static final IRI vehicleModelDate;

    /**
     * vehicleSeatingCapacity
     * <p>
     * {@code http://schema.org/vehicleSeatingCapacity}
     * <p>
     * The number of passengers that can be seated in the vehicle, both in
     * terms of the physical space available, and in terms of limitations set
     * by law.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s): C62 for persons.
     *
     * @see <a href="http://schema.org/vehicleSeatingCapacity">vehicleSeatingCapacity</a>
     */
    public static final IRI vehicleSeatingCapacity;

    /**
     * vehicleSpecialUsage
     * <p>
     * {@code http://schema.org/vehicleSpecialUsage}
     * <p>
     * Indicates whether the vehicle has been used for special purposes, like
     * commercial rental, driving school, or as a taxi. The legislation in
     * many countries requires this information to be revealed when offering
     * a car for sale.
     *
     * @see <a href="http://schema.org/vehicleSpecialUsage">vehicleSpecialUsage</a>
     */
    public static final IRI vehicleSpecialUsage;

    /**
     * vehicleTransmission
     * <p>
     * {@code http://schema.org/vehicleTransmission}
     * <p>
     * The type of component used for transmitting the power from a rotating
     * power source to the wheels or other relevant component(s)
     * (&quot;gearbox&quot; for cars).
     *
     * @see <a href="http://schema.org/vehicleTransmission">vehicleTransmission</a>
     */
    public static final IRI vehicleTransmission;

    /**
     * Vein
     * <p>
     * {@code http://schema.org/Vein}
     * <p>
     * A type of blood vessel that specifically carries blood to the heart.
     *
     * @see <a href="http://schema.org/Vein">Vein</a>
     */
    public static final IRI Vein;

    /**
     * vendor
     * <p>
     * {@code http://schema.org/vendor}
     * <p>
     * &#39;vendor&#39; is an earlier term for &#39;seller&#39;.
     *
     * @see <a href="http://schema.org/vendor">vendor</a>
     */
    public static final IRI vendor;

    /**
     * verificationFactCheckingPolicy
     * <p>
     * {@code http://schema.org/verificationFactCheckingPolicy}
     * <p>
     * Disclosure about verification and fact-checking processes for a &lt;a
     * href=&quot;http://schema.org/NewsMediaOrganization&quot;&gt;NewsMediaOrganization&lt;/a&gt;
     * or other fact-checking &lt;a
     * href=&quot;http://schema.org/Organization&quot;&gt;Organization&lt;/a&gt;.
     *
     * @see <a href="http://schema.org/verificationFactCheckingPolicy">verificationFactCheckingPolicy</a>
     */
    public static final IRI verificationFactCheckingPolicy;

    /**
     * version
     * <p>
     * {@code http://schema.org/version}
     * <p>
     * The version of the CreativeWork embodied by a specified resource.
     *
     * @see <a href="http://schema.org/version">version</a>
     */
    public static final IRI version;

    /**
     * Vessel
     * <p>
     * {@code http://schema.org/Vessel}
     * <p>
     * A component of the human body circulatory system comprised of an
     * intricate network of hollow tubes that transport blood throughout the
     * entire body.
     *
     * @see <a href="http://schema.org/Vessel">Vessel</a>
     */
    public static final IRI Vessel;

    /**
     * VeterinaryCare
     * <p>
     * {@code http://schema.org/VeterinaryCare}
     * <p>
     * A vet&#39;s office.
     *
     * @see <a href="http://schema.org/VeterinaryCare">VeterinaryCare</a>
     */
    public static final IRI VeterinaryCare;

    /**
     * video
     * <p>
     * {@code http://schema.org/video}
     * <p>
     * An embedded video object.
     *
     * @see <a href="http://schema.org/video">video</a>
     */
    public static final IRI video;

    /**
     * videoFormat
     * <p>
     * {@code http://schema.org/videoFormat}
     * <p>
     * The type of screening or video broadcast used (e.g. IMAX, 3D, SD, HD,
     * etc.).
     *
     * @see <a href="http://schema.org/videoFormat">videoFormat</a>
     */
    public static final IRI videoFormat;

    /**
     * videoFrameSize
     * <p>
     * {@code http://schema.org/videoFrameSize}
     * <p>
     * The frame size of the video.
     *
     * @see <a href="http://schema.org/videoFrameSize">videoFrameSize</a>
     */
    public static final IRI videoFrameSize;

    /**
     * VideoGallery
     * <p>
     * {@code http://schema.org/VideoGallery}
     * <p>
     * Web page type: Video gallery page.
     *
     * @see <a href="http://schema.org/VideoGallery">VideoGallery</a>
     */
    public static final IRI VideoGallery;

    /**
     * VideoGame
     * <p>
     * {@code http://schema.org/VideoGame}
     * <p>
     * A video game is an electronic game that involves human interaction
     * with a user interface to generate visual feedback on a video device.
     *
     * @see <a href="http://schema.org/VideoGame">VideoGame</a>
     */
    public static final IRI VideoGame;

    /**
     * VideoGameClip
     * <p>
     * {@code http://schema.org/VideoGameClip}
     * <p>
     * A short segment/part of a video game.
     *
     * @see <a href="http://schema.org/VideoGameClip">VideoGameClip</a>
     */
    public static final IRI VideoGameClip;

    /**
     * VideoGameSeries
     * <p>
     * {@code http://schema.org/VideoGameSeries}
     * <p>
     * A video game series.
     *
     * @see <a href="http://schema.org/VideoGameSeries">VideoGameSeries</a>
     */
    public static final IRI VideoGameSeries;

    /**
     * VideoObject
     * <p>
     * {@code http://schema.org/VideoObject}
     * <p>
     * A video file.
     *
     * @see <a href="http://schema.org/VideoObject">VideoObject</a>
     */
    public static final IRI VideoObject;

    /**
     * videoQuality
     * <p>
     * {@code http://schema.org/videoQuality}
     * <p>
     * The quality of the video.
     *
     * @see <a href="http://schema.org/videoQuality">videoQuality</a>
     */
    public static final IRI videoQuality;

    /**
     * ViewAction
     * <p>
     * {@code http://schema.org/ViewAction}
     * <p>
     * The act of consuming static visual content.
     *
     * @see <a href="http://schema.org/ViewAction">ViewAction</a>
     */
    public static final IRI ViewAction;

    /**
     * VisualArtsEvent
     * <p>
     * {@code http://schema.org/VisualArtsEvent}
     * <p>
     * Event type: Visual arts event.
     *
     * @see <a href="http://schema.org/VisualArtsEvent">VisualArtsEvent</a>
     */
    public static final IRI VisualArtsEvent;

    /**
     * VisualArtwork
     * <p>
     * {@code http://schema.org/VisualArtwork}
     * <p>
     * A work of art that is primarily visual in character.
     *
     * @see <a href="http://schema.org/VisualArtwork">VisualArtwork</a>
     */
    public static final IRI VisualArtwork;

    /**
     * VitalSign
     * <p>
     * {@code http://schema.org/VitalSign}
     * <p>
     * Vital signs are measures of various physiological functions in order
     * to assess the most basic body functions.
     *
     * @see <a href="http://schema.org/VitalSign">VitalSign</a>
     */
    public static final IRI VitalSign;

    /**
     * Volcano
     * <p>
     * {@code http://schema.org/Volcano}
     * <p>
     * A volcano, like Fuji san.
     *
     * @see <a href="http://schema.org/Volcano">Volcano</a>
     */
    public static final IRI Volcano;

    /**
     * volumeNumber
     * <p>
     * {@code http://schema.org/volumeNumber}
     * <p>
     * Identifies the volume of publication or multi-part work; for example,
     * &quot;iii&quot; or &quot;2&quot;.
     *
     * @see <a href="http://schema.org/volumeNumber">volumeNumber</a>
     */
    public static final IRI volumeNumber;

    /**
     * VoteAction
     * <p>
     * {@code http://schema.org/VoteAction}
     * <p>
     * The act of expressing a preference from a fixed/finite/structured set
     * of choices/options.
     *
     * @see <a href="http://schema.org/VoteAction">VoteAction</a>
     */
    public static final IRI VoteAction;

    /**
     * WantAction
     * <p>
     * {@code http://schema.org/WantAction}
     * <p>
     * The act of expressing a desire about the object. An agent wants an
     * object.
     *
     * @see <a href="http://schema.org/WantAction">WantAction</a>
     */
    public static final IRI WantAction;

    /**
     * warning
     * <p>
     * {@code http://schema.org/warning}
     * <p>
     * Any FDA or other warnings about the drug (text or URL).
     *
     * @see <a href="http://schema.org/warning">warning</a>
     */
    public static final IRI warning;

    /**
     * warranty
     * <p>
     * {@code http://schema.org/warranty}
     * <p>
     * The warranty promise(s) included in the offer.
     *
     * @see <a href="http://schema.org/warranty">warranty</a>
     */
    public static final IRI warranty;

    /**
     * warrantyPromise
     * <p>
     * {@code http://schema.org/warrantyPromise}
     * <p>
     * The warranty promise(s) included in the offer.
     *
     * @see <a href="http://schema.org/warrantyPromise">warrantyPromise</a>
     */
    public static final IRI warrantyPromise;

    /**
     * WarrantyPromise
     * <p>
     * {@code http://schema.org/WarrantyPromise}
     * <p>
     * A structured value representing the duration and scope of services
     * that will be provided to a customer free of charge in case of a defect
     * or malfunction of a product.
     *
     * @see <a href="http://schema.org/WarrantyPromise">WarrantyPromise</a>
     */
    public static final IRI WarrantyPromise;

    /**
     * WarrantyScope
     * <p>
     * {@code http://schema.org/WarrantyScope}
     * <p>
     * A range of of services that will be provided to a customer free of
     * charge in case of a defect or malfunction of a
     * product.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Commonly used
     * values:&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#Labor-BringIn&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#PartsAndLabor-BringIn&lt;/li&gt;
     * &lt;li&gt;http://purl.org/goodrelations/v1#PartsAndLabor-PickUp&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/WarrantyScope">WarrantyScope</a>
     */
    public static final IRI WarrantyScope;

    /**
     * warrantyScope
     * <p>
     * {@code http://schema.org/warrantyScope}
     * <p>
     * The scope of the warranty promise.
     *
     * @see <a href="http://schema.org/warrantyScope">warrantyScope</a>
     */
    public static final IRI warrantyScope;

    /**
     * WatchAction
     * <p>
     * {@code http://schema.org/WatchAction}
     * <p>
     * The act of consuming dynamic/moving visual content.
     *
     * @see <a href="http://schema.org/WatchAction">WatchAction</a>
     */
    public static final IRI WatchAction;

    /**
     * Waterfall
     * <p>
     * {@code http://schema.org/Waterfall}
     * <p>
     * A waterfall, like Niagara.
     *
     * @see <a href="http://schema.org/Waterfall">Waterfall</a>
     */
    public static final IRI Waterfall;

    /**
     * WearAction
     * <p>
     * {@code http://schema.org/WearAction}
     * <p>
     * The act of dressing oneself in clothing.
     *
     * @see <a href="http://schema.org/WearAction">WearAction</a>
     */
    public static final IRI WearAction;

    /**
     * WebAPI
     * <p>
     * {@code http://schema.org/WebAPI}
     * <p>
     * An application programming interface accessible over Web/Internet
     * technologies.
     *
     * @see <a href="http://schema.org/WebAPI">WebAPI</a>
     */
    public static final IRI WebAPI;

    /**
     * WebApplication
     * <p>
     * {@code http://schema.org/WebApplication}
     * <p>
     * Web applications.
     *
     * @see <a href="http://schema.org/WebApplication">WebApplication</a>
     */
    public static final IRI WebApplication;

    /**
     * webCheckinTime
     * <p>
     * {@code http://schema.org/webCheckinTime}
     * <p>
     * The time when a passenger can check into the flight online.
     *
     * @see <a href="http://schema.org/webCheckinTime">webCheckinTime</a>
     */
    public static final IRI webCheckinTime;

    /**
     * WebPage
     * <p>
     * {@code http://schema.org/WebPage}
     * <p>
     * A web page. Every web page is implicitly assumed to be declared to be
     * of type WebPage, so the various properties about that webpage, such as
     * &lt;code&gt;breadcrumb&lt;/code&gt; may be used. We recommend explicit
     * declaration if these properties are specified, but if they are found
     * outside of an itemscope, they will be assumed to be about the page.
     *
     * @see <a href="http://schema.org/WebPage">WebPage</a>
     */
    public static final IRI WebPage;

    /**
     * WebPageElement
     * <p>
     * {@code http://schema.org/WebPageElement}
     * <p>
     * A web page element, like a table or an image.
     *
     * @see <a href="http://schema.org/WebPageElement">WebPageElement</a>
     */
    public static final IRI WebPageElement;

    /**
     * WebSite
     * <p>
     * {@code http://schema.org/WebSite}
     * <p>
     * A WebSite is a set of related web pages and other items typically
     * served from a single web domain and accessible via URLs.
     *
     * @see <a href="http://schema.org/WebSite">WebSite</a>
     */
    public static final IRI WebSite;

    /**
     * weight
     * <p>
     * {@code http://schema.org/weight}
     * <p>
     * The weight of the product or person.
     *
     * @see <a href="http://schema.org/weight">weight</a>
     */
    public static final IRI weight;

    /**
     * weightTotal
     * <p>
     * {@code http://schema.org/weightTotal}
     * <p>
     * The permitted total weight of the loaded vehicle, including passengers
     * and cargo and the weight of the empty
     * vehicle.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s): KGM for
     * kilogram, LBR for
     * pound&lt;br/&gt;&lt;br/&gt;
     * <p>
     * &lt;ul&gt;
     * &lt;li&gt;Note 1: You can
     * indicate additional information in the &lt;a
     * href=&quot;http://schema.org/name&quot;&gt;name&lt;/a&gt; of the &lt;a
     * href=&quot;http://schema.org/QuantitativeValue&quot;&gt;QuantitativeValue&lt;/a&gt;
     * node.&lt;/li&gt;
     * &lt;li&gt;Note 2: You may also link to a &lt;a
     * href=&quot;http://schema.org/QualitativeValue&quot;&gt;QualitativeValue&lt;/a&gt;
     * node that provides additional information using &lt;a
     * href=&quot;http://schema.org/valueReference&quot;&gt;valueReference&lt;/a&gt;.&lt;/li&gt;
     * &lt;li&gt;Note
     * 3: Note that you can use &lt;a
     * href=&quot;http://schema.org/minValue&quot;&gt;minValue&lt;/a&gt; and
     * &lt;a
     * href=&quot;http://schema.org/maxValue&quot;&gt;maxValue&lt;/a&gt; to
     * indicate ranges.&lt;/li&gt;
     * &lt;/ul&gt;
     *
     * @see <a href="http://schema.org/weightTotal">weightTotal</a>
     */
    public static final IRI weightTotal;

    /**
     * wheelbase
     * <p>
     * {@code http://schema.org/wheelbase}
     * <p>
     * The distance between the centers of the front and rear
     * wheels.&lt;br/&gt;&lt;br/&gt;
     * <p>
     * Typical unit code(s): CMT for
     * centimeters, MTR for meters, INH for inches, FOT for foot/feet
     *
     * @see <a href="http://schema.org/wheelbase">wheelbase</a>
     */
    public static final IRI wheelbase;

    /**
     * WholesaleStore
     * <p>
     * {@code http://schema.org/WholesaleStore}
     * <p>
     * A wholesale store.
     *
     * @see <a href="http://schema.org/WholesaleStore">WholesaleStore</a>
     */
    public static final IRI WholesaleStore;

    /**
     * width
     * <p>
     * {@code http://schema.org/width}
     * <p>
     * The width of the item.
     *
     * @see <a href="http://schema.org/width">width</a>
     */
    public static final IRI width;

    /**
     * WinAction
     * <p>
     * {@code http://schema.org/WinAction}
     * <p>
     * The act of achieving victory in a competitive activity.
     *
     * @see <a href="http://schema.org/WinAction">WinAction</a>
     */
    public static final IRI WinAction;

    /**
     * Winery
     * <p>
     * {@code http://schema.org/Winery}
     * <p>
     * A winery.
     *
     * @see <a href="http://schema.org/Winery">Winery</a>
     */
    public static final IRI Winery;

    /**
     * winner
     * <p>
     * {@code http://schema.org/winner}
     * <p>
     * A sub property of participant. The winner of the action.
     *
     * @see <a href="http://schema.org/winner">winner</a>
     */
    public static final IRI winner;

    /**
     * wordCount
     * <p>
     * {@code http://schema.org/wordCount}
     * <p>
     * The number of words in the text of the Article.
     *
     * @see <a href="http://schema.org/wordCount">wordCount</a>
     */
    public static final IRI wordCount;

    /**
     * WorkersUnion
     * <p>
     * {@code http://schema.org/WorkersUnion}
     * <p>
     * A Workers Union (also known as a Labor Union, Labour Union, or Trade
     * Union) is an organization that promotes the interests of its worker
     * members by collectively bargaining with management, organizing, and
     * political lobbying.
     *
     * @see <a href="http://schema.org/WorkersUnion">WorkersUnion</a>
     */
    public static final IRI WorkersUnion;

    /**
     * workExample
     * <p>
     * {@code http://schema.org/workExample}
     * <p>
     * Example/instance/realization/derivation of the concept of this
     * creative work. eg. The paperback edition, first edition, or eBook.
     *
     * @see <a href="http://schema.org/workExample">workExample</a>
     */
    public static final IRI workExample;

    /**
     * workFeatured
     * <p>
     * {@code http://schema.org/workFeatured}
     * <p>
     * A work featured in some event, e.g. exhibited in an ExhibitionEvent.
     * <p>
     * Specific subproperties are available for workPerformed (e.g. a play),
     * or a workPresented (a Movie at a ScreeningEvent).
     *
     * @see <a href="http://schema.org/workFeatured">workFeatured</a>
     */
    public static final IRI workFeatured;

    /**
     * workHours
     * <p>
     * {@code http://schema.org/workHours}
     * <p>
     * The typical working hours for this job (e.g. 1st shift, night shift,
     * 8am-5pm).
     *
     * @see <a href="http://schema.org/workHours">workHours</a>
     */
    public static final IRI workHours;

    /**
     * workload
     * <p>
     * {@code http://schema.org/workload}
     * <p>
     * Quantitative measure of the physiologic output of the exercise; also
     * referred to as energy expenditure.
     *
     * @see <a href="http://schema.org/workload">workload</a>
     */
    public static final IRI workload;

    /**
     * workLocation
     * <p>
     * {@code http://schema.org/workLocation}
     * <p>
     * A contact location for a person&#39;s place of work.
     *
     * @see <a href="http://schema.org/workLocation">workLocation</a>
     */
    public static final IRI workLocation;

    /**
     * workPerformed
     * <p>
     * {@code http://schema.org/workPerformed}
     * <p>
     * A work performed in some event, for example a play performed in a
     * TheaterEvent.
     *
     * @see <a href="http://schema.org/workPerformed">workPerformed</a>
     */
    public static final IRI workPerformed;

    /**
     * workPresented
     * <p>
     * {@code http://schema.org/workPresented}
     * <p>
     * The movie presented during this event.
     *
     * @see <a href="http://schema.org/workPresented">workPresented</a>
     */
    public static final IRI workPresented;

    /**
     * worksFor
     * <p>
     * {@code http://schema.org/worksFor}
     * <p>
     * Organizations that the person works for.
     *
     * @see <a href="http://schema.org/worksFor">worksFor</a>
     */
    public static final IRI worksFor;

    /**
     * workTranslation
     * <p>
     * {@code http://schema.org/workTranslation}
     * <p>
     * A work that is a translation of the content of this work. e.g. 西遊記 has
     * an English workTranslation “Journey to the West”,a German
     * workTranslation “Monkeys Pilgerfahrt” and a Vietnamese  translation
     * Tây du ký bình khảo.
     *
     * @see <a href="http://schema.org/workTranslation">workTranslation</a>
     */
    public static final IRI workTranslation;

    /**
     * worstRating
     * <p>
     * {@code http://schema.org/worstRating}
     * <p>
     * The lowest value allowed in this rating system. If worstRating is
     * omitted, 1 is assumed.
     *
     * @see <a href="http://schema.org/worstRating">worstRating</a>
     */
    public static final IRI worstRating;

    /**
     * WPAdBlock
     * <p>
     * {@code http://schema.org/WPAdBlock}
     * <p>
     * An advertising section of the page.
     *
     * @see <a href="http://schema.org/WPAdBlock">WPAdBlock</a>
     */
    public static final IRI WPAdBlock;

    /**
     * WPFooter
     * <p>
     * {@code http://schema.org/WPFooter}
     * <p>
     * The footer section of the page.
     *
     * @see <a href="http://schema.org/WPFooter">WPFooter</a>
     */
    public static final IRI WPFooter;

    /**
     * WPHeader
     * <p>
     * {@code http://schema.org/WPHeader}
     * <p>
     * The header section of the page.
     *
     * @see <a href="http://schema.org/WPHeader">WPHeader</a>
     */
    public static final IRI WPHeader;

    /**
     * WPSideBar
     * <p>
     * {@code http://schema.org/WPSideBar}
     * <p>
     * A sidebar section of the page.
     *
     * @see <a href="http://schema.org/WPSideBar">WPSideBar</a>
     */
    public static final IRI WPSideBar;

    /**
     * WriteAction
     * <p>
     * {@code http://schema.org/WriteAction}
     * <p>
     * The act of authoring written creative content.
     *
     * @see <a href="http://schema.org/WriteAction">WriteAction</a>
     */
    public static final IRI WriteAction;

    /**
     * xpath
     * <p>
     * {@code http://schema.org/xpath}
     * <p>
     * An XPath, e.g. of a &lt;a
     * href=&quot;http://schema.org/SpeakableSpecification&quot;&gt;SpeakableSpecification&lt;/a&gt;
     * or &lt;a
     * href=&quot;http://schema.org/WebPageElement&quot;&gt;WebPageElement&lt;/a&gt;.
     * In the latter case, multiple matches within a page can constitute a
     * single conceptual &quot;Web page element&quot;.
     *
     * @see <a href="http://schema.org/xpath">xpath</a>
     */
    public static final IRI xpath;

    /**
     * XPathType
     * <p>
     * {@code http://schema.org/XPathType}
     * <p>
     * Text representing an XPath (typically but not necessarily version
     * 1.0).
     *
     * @see <a href="http://schema.org/XPathType">XPathType</a>
     */
    public static final IRI XPathType;

    /**
     * yearlyRevenue
     * <p>
     * {@code http://schema.org/yearlyRevenue}
     * <p>
     * The size of the business in annual revenue.
     *
     * @see <a href="http://schema.org/yearlyRevenue">yearlyRevenue</a>
     */
    public static final IRI yearlyRevenue;

    /**
     * yearsInOperation
     * <p>
     * {@code http://schema.org/yearsInOperation}
     * <p>
     * The age of the business.
     *
     * @see <a href="http://schema.org/yearsInOperation">yearsInOperation</a>
     */
    public static final IRI yearsInOperation;

    /**
     * yield
     * <p>
     * {@code http://schema.org/yield}
     * <p>
     * The quantity that results by performing instructions. For example, a
     * paper airplane, 10 personalized candles.
     *
     * @see <a href="http://schema.org/yield">yield</a>
     */
    public static final IRI yield;

    /**
     * Zoo
     * <p>
     * {@code http://schema.org/Zoo}
     * <p>
     * A zoo.
     *
     * @see <a href="http://schema.org/Zoo">Zoo</a>
     */
    public static final IRI Zoo;

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
        about = vf.createIRI("http://schema.org/about");
        AboutPage = vf.createIRI("http://schema.org/AboutPage");
        abridged = vf.createIRI("http://schema.org/abridged");
        accelerationTime = vf.createIRI("http://schema.org/accelerationTime");
        AcceptAction = vf.createIRI("http://schema.org/AcceptAction");
        acceptedAnswer = vf.createIRI("http://schema.org/acceptedAnswer");
        acceptedOffer = vf.createIRI("http://schema.org/acceptedOffer");
        acceptedPaymentMethod = vf.createIRI("http://schema.org/acceptedPaymentMethod");
        acceptsReservations = vf.createIRI("http://schema.org/acceptsReservations");
        accessCode = vf.createIRI("http://schema.org/accessCode");
        accessibilityAPI = vf.createIRI("http://schema.org/accessibilityAPI");
        accessibilityControl = vf.createIRI("http://schema.org/accessibilityControl");
        accessibilityFeature = vf.createIRI("http://schema.org/accessibilityFeature");
        accessibilityHazard = vf.createIRI("http://schema.org/accessibilityHazard");
        accessibilitySummary = vf.createIRI("http://schema.org/accessibilitySummary");
        accessMode = vf.createIRI("http://schema.org/accessMode");
        accessModeSufficient = vf.createIRI("http://schema.org/accessModeSufficient");
        Accommodation = vf.createIRI("http://schema.org/Accommodation");
        accountablePerson = vf.createIRI("http://schema.org/accountablePerson");
        accountId = vf.createIRI("http://schema.org/accountId");
        AccountingService = vf.createIRI("http://schema.org/AccountingService");
        accountMinimumInflow = vf.createIRI("http://schema.org/accountMinimumInflow");
        accountOverdraftLimit = vf.createIRI("http://schema.org/accountOverdraftLimit");
        AchieveAction = vf.createIRI("http://schema.org/AchieveAction");
        acquiredFrom = vf.createIRI("http://schema.org/acquiredFrom");
        acrissCode = vf.createIRI("http://schema.org/acrissCode");
        action = vf.createIRI("http://schema.org/action");
        Action = vf.createIRI("http://schema.org/Action");
        actionableFeedbackPolicy = vf.createIRI("http://schema.org/actionableFeedbackPolicy");
        actionAccessibilityRequirement = vf.createIRI("http://schema.org/actionAccessibilityRequirement");
        ActionAccessSpecification = vf.createIRI("http://schema.org/ActionAccessSpecification");
        actionApplication = vf.createIRI("http://schema.org/actionApplication");
        actionOption = vf.createIRI("http://schema.org/actionOption");
        actionPlatform = vf.createIRI("http://schema.org/actionPlatform");
        actionStatus = vf.createIRI("http://schema.org/actionStatus");
        ActionStatusType = vf.createIRI("http://schema.org/ActionStatusType");
        ActivateAction = vf.createIRI("http://schema.org/ActivateAction");
        activeIngredient = vf.createIRI("http://schema.org/activeIngredient");
        activityDuration = vf.createIRI("http://schema.org/activityDuration");
        activityFrequency = vf.createIRI("http://schema.org/activityFrequency");
        actor = vf.createIRI("http://schema.org/actor");
        actors = vf.createIRI("http://schema.org/actors");
        AddAction = vf.createIRI("http://schema.org/AddAction");
        additionalName = vf.createIRI("http://schema.org/additionalName");
        additionalNumberOfGuests = vf.createIRI("http://schema.org/additionalNumberOfGuests");
        additionalProperty = vf.createIRI("http://schema.org/additionalProperty");
        additionalType = vf.createIRI("http://schema.org/additionalType");
        additionalVariable = vf.createIRI("http://schema.org/additionalVariable");
        addOn = vf.createIRI("http://schema.org/addOn");
        address = vf.createIRI("http://schema.org/address");
        addressCountry = vf.createIRI("http://schema.org/addressCountry");
        addressLocality = vf.createIRI("http://schema.org/addressLocality");
        addressRegion = vf.createIRI("http://schema.org/addressRegion");
        administrationRoute = vf.createIRI("http://schema.org/administrationRoute");
        AdministrativeArea = vf.createIRI("http://schema.org/AdministrativeArea");
        AdultEntertainment = vf.createIRI("http://schema.org/AdultEntertainment");
        advanceBookingRequirement = vf.createIRI("http://schema.org/advanceBookingRequirement");
        adverseOutcome = vf.createIRI("http://schema.org/adverseOutcome");
        AdvertiserContentArticle = vf.createIRI("http://schema.org/AdvertiserContentArticle");
        affectedBy = vf.createIRI("http://schema.org/affectedBy");
        affiliation = vf.createIRI("http://schema.org/affiliation");
        afterMedia = vf.createIRI("http://schema.org/afterMedia");
        agent = vf.createIRI("http://schema.org/agent");
        AggregateOffer = vf.createIRI("http://schema.org/AggregateOffer");
        AggregateRating = vf.createIRI("http://schema.org/AggregateRating");
        aggregateRating = vf.createIRI("http://schema.org/aggregateRating");
        AgreeAction = vf.createIRI("http://schema.org/AgreeAction");
        aircraft = vf.createIRI("http://schema.org/aircraft");
        Airline = vf.createIRI("http://schema.org/Airline");
        Airport = vf.createIRI("http://schema.org/Airport");
        album = vf.createIRI("http://schema.org/album");
        albumProductionType = vf.createIRI("http://schema.org/albumProductionType");
        albumRelease = vf.createIRI("http://schema.org/albumRelease");
        albumReleaseType = vf.createIRI("http://schema.org/albumReleaseType");
        albums = vf.createIRI("http://schema.org/albums");
        alcoholWarning = vf.createIRI("http://schema.org/alcoholWarning");
        algorithm = vf.createIRI("http://schema.org/algorithm");
        AlignmentObject = vf.createIRI("http://schema.org/AlignmentObject");
        alignmentType = vf.createIRI("http://schema.org/alignmentType");
        AllocateAction = vf.createIRI("http://schema.org/AllocateAction");
        alternateName = vf.createIRI("http://schema.org/alternateName");
        alternativeHeadline = vf.createIRI("http://schema.org/alternativeHeadline");
        alumni = vf.createIRI("http://schema.org/alumni");
        alumniOf = vf.createIRI("http://schema.org/alumniOf");
        amenityFeature = vf.createIRI("http://schema.org/amenityFeature");
        amount = vf.createIRI("http://schema.org/amount");
        amountOfThisGood = vf.createIRI("http://schema.org/amountOfThisGood");
        AMRadioChannel = vf.createIRI("http://schema.org/AMRadioChannel");
        AmusementPark = vf.createIRI("http://schema.org/AmusementPark");
        AnalysisNewsArticle = vf.createIRI("http://schema.org/AnalysisNewsArticle");
        AnatomicalStructure = vf.createIRI("http://schema.org/AnatomicalStructure");
        AnatomicalSystem = vf.createIRI("http://schema.org/AnatomicalSystem");
        AnimalShelter = vf.createIRI("http://schema.org/AnimalShelter");
        annualPercentageRate = vf.createIRI("http://schema.org/annualPercentageRate");
        Answer = vf.createIRI("http://schema.org/Answer");
        answerCount = vf.createIRI("http://schema.org/answerCount");
        antagonist = vf.createIRI("http://schema.org/antagonist");
        Apartment = vf.createIRI("http://schema.org/Apartment");
        ApartmentComplex = vf.createIRI("http://schema.org/ApartmentComplex");
        APIReference = vf.createIRI("http://schema.org/APIReference");
        appearance = vf.createIRI("http://schema.org/appearance");
        AppendAction = vf.createIRI("http://schema.org/AppendAction");
        applicableLocation = vf.createIRI("http://schema.org/applicableLocation");
        application = vf.createIRI("http://schema.org/application");
        applicationCategory = vf.createIRI("http://schema.org/applicationCategory");
        applicationSubCategory = vf.createIRI("http://schema.org/applicationSubCategory");
        applicationSuite = vf.createIRI("http://schema.org/applicationSuite");
        appliesToDeliveryMethod = vf.createIRI("http://schema.org/appliesToDeliveryMethod");
        appliesToPaymentMethod = vf.createIRI("http://schema.org/appliesToPaymentMethod");
        ApplyAction = vf.createIRI("http://schema.org/ApplyAction");
        ApprovedIndication = vf.createIRI("http://schema.org/ApprovedIndication");
        Aquarium = vf.createIRI("http://schema.org/Aquarium");
        area = vf.createIRI("http://schema.org/area");
        areaServed = vf.createIRI("http://schema.org/areaServed");
        arrivalAirport = vf.createIRI("http://schema.org/arrivalAirport");
        arrivalBusStop = vf.createIRI("http://schema.org/arrivalBusStop");
        arrivalGate = vf.createIRI("http://schema.org/arrivalGate");
        arrivalPlatform = vf.createIRI("http://schema.org/arrivalPlatform");
        arrivalStation = vf.createIRI("http://schema.org/arrivalStation");
        arrivalTerminal = vf.createIRI("http://schema.org/arrivalTerminal");
        arrivalTime = vf.createIRI("http://schema.org/arrivalTime");
        ArriveAction = vf.createIRI("http://schema.org/ArriveAction");
        artEdition = vf.createIRI("http://schema.org/artEdition");
        arterialBranch = vf.createIRI("http://schema.org/arterialBranch");
        Artery = vf.createIRI("http://schema.org/Artery");
        artform = vf.createIRI("http://schema.org/artform");
        ArtGallery = vf.createIRI("http://schema.org/ArtGallery");
        Article = vf.createIRI("http://schema.org/Article");
        articleBody = vf.createIRI("http://schema.org/articleBody");
        articleSection = vf.createIRI("http://schema.org/articleSection");
        artist = vf.createIRI("http://schema.org/artist");
        artMedium = vf.createIRI("http://schema.org/artMedium");
        artworkSurface = vf.createIRI("http://schema.org/artworkSurface");
        AskAction = vf.createIRI("http://schema.org/AskAction");
        AskPublicNewsArticle = vf.createIRI("http://schema.org/AskPublicNewsArticle");
        aspect = vf.createIRI("http://schema.org/aspect");
        assembly = vf.createIRI("http://schema.org/assembly");
        assemblyVersion = vf.createIRI("http://schema.org/assemblyVersion");
        AssessAction = vf.createIRI("http://schema.org/AssessAction");
        AssignAction = vf.createIRI("http://schema.org/AssignAction");
        associatedAnatomy = vf.createIRI("http://schema.org/associatedAnatomy");
        associatedArticle = vf.createIRI("http://schema.org/associatedArticle");
        associatedMedia = vf.createIRI("http://schema.org/associatedMedia");
        associatedPathophysiology = vf.createIRI("http://schema.org/associatedPathophysiology");
        athlete = vf.createIRI("http://schema.org/athlete");
        Atlas = vf.createIRI("http://schema.org/Atlas");
        attendee = vf.createIRI("http://schema.org/attendee");
        attendees = vf.createIRI("http://schema.org/attendees");
        Attorney = vf.createIRI("http://schema.org/Attorney");
        audience = vf.createIRI("http://schema.org/audience");
        Audience = vf.createIRI("http://schema.org/Audience");
        audienceType = vf.createIRI("http://schema.org/audienceType");
        audio = vf.createIRI("http://schema.org/audio");
        Audiobook = vf.createIRI("http://schema.org/Audiobook");
        AudioObject = vf.createIRI("http://schema.org/AudioObject");
        authenticator = vf.createIRI("http://schema.org/authenticator");
        author = vf.createIRI("http://schema.org/author");
        AuthorizeAction = vf.createIRI("http://schema.org/AuthorizeAction");
        AutoBodyShop = vf.createIRI("http://schema.org/AutoBodyShop");
        AutoDealer = vf.createIRI("http://schema.org/AutoDealer");
        AutomatedTeller = vf.createIRI("http://schema.org/AutomatedTeller");
        AutomotiveBusiness = vf.createIRI("http://schema.org/AutomotiveBusiness");
        AutoPartsStore = vf.createIRI("http://schema.org/AutoPartsStore");
        AutoRental = vf.createIRI("http://schema.org/AutoRental");
        AutoRepair = vf.createIRI("http://schema.org/AutoRepair");
        AutoWash = vf.createIRI("http://schema.org/AutoWash");
        availability = vf.createIRI("http://schema.org/availability");
        availabilityEnds = vf.createIRI("http://schema.org/availabilityEnds");
        availabilityStarts = vf.createIRI("http://schema.org/availabilityStarts");
        availableAtOrFrom = vf.createIRI("http://schema.org/availableAtOrFrom");
        availableChannel = vf.createIRI("http://schema.org/availableChannel");
        availableDeliveryMethod = vf.createIRI("http://schema.org/availableDeliveryMethod");
        availableFrom = vf.createIRI("http://schema.org/availableFrom");
        availableIn = vf.createIRI("http://schema.org/availableIn");
        availableLanguage = vf.createIRI("http://schema.org/availableLanguage");
        availableOnDevice = vf.createIRI("http://schema.org/availableOnDevice");
        availableService = vf.createIRI("http://schema.org/availableService");
        availableStrength = vf.createIRI("http://schema.org/availableStrength");
        availableTest = vf.createIRI("http://schema.org/availableTest");
        availableThrough = vf.createIRI("http://schema.org/availableThrough");
        award = vf.createIRI("http://schema.org/award");
        awards = vf.createIRI("http://schema.org/awards");
        awayTeam = vf.createIRI("http://schema.org/awayTeam");
        background = vf.createIRI("http://schema.org/background");
        BackgroundNewsArticle = vf.createIRI("http://schema.org/BackgroundNewsArticle");
        backstory = vf.createIRI("http://schema.org/backstory");
        Bakery = vf.createIRI("http://schema.org/Bakery");
        BankAccount = vf.createIRI("http://schema.org/BankAccount");
        bankAccountType = vf.createIRI("http://schema.org/bankAccountType");
        BankOrCreditUnion = vf.createIRI("http://schema.org/BankOrCreditUnion");
        Barcode = vf.createIRI("http://schema.org/Barcode");
        BarOrPub = vf.createIRI("http://schema.org/BarOrPub");
        baseSalary = vf.createIRI("http://schema.org/baseSalary");
        bccRecipient = vf.createIRI("http://schema.org/bccRecipient");
        Beach = vf.createIRI("http://schema.org/Beach");
        BeautySalon = vf.createIRI("http://schema.org/BeautySalon");
        bed = vf.createIRI("http://schema.org/bed");
        BedAndBreakfast = vf.createIRI("http://schema.org/BedAndBreakfast");
        BedDetails = vf.createIRI("http://schema.org/BedDetails");
        BedType = vf.createIRI("http://schema.org/BedType");
        beforeMedia = vf.createIRI("http://schema.org/beforeMedia");
        BefriendAction = vf.createIRI("http://schema.org/BefriendAction");
        beneficiaryBank = vf.createIRI("http://schema.org/beneficiaryBank");
        benefits = vf.createIRI("http://schema.org/benefits");
        benefitsSummaryUrl = vf.createIRI("http://schema.org/benefitsSummaryUrl");
        bestRating = vf.createIRI("http://schema.org/bestRating");
        BikeStore = vf.createIRI("http://schema.org/BikeStore");
        billingAddress = vf.createIRI("http://schema.org/billingAddress");
        billingIncrement = vf.createIRI("http://schema.org/billingIncrement");
        billingPeriod = vf.createIRI("http://schema.org/billingPeriod");
        biomechnicalClass = vf.createIRI("http://schema.org/biomechnicalClass");
        birthDate = vf.createIRI("http://schema.org/birthDate");
        birthPlace = vf.createIRI("http://schema.org/birthPlace");
        bitrate = vf.createIRI("http://schema.org/bitrate");
        Blog = vf.createIRI("http://schema.org/Blog");
        blogPost = vf.createIRI("http://schema.org/blogPost");
        BlogPosting = vf.createIRI("http://schema.org/BlogPosting");
        blogPosts = vf.createIRI("http://schema.org/blogPosts");
        bloodSupply = vf.createIRI("http://schema.org/bloodSupply");
        BloodTest = vf.createIRI("http://schema.org/BloodTest");
        boardingGroup = vf.createIRI("http://schema.org/boardingGroup");
        boardingPolicy = vf.createIRI("http://schema.org/boardingPolicy");
        BoardingPolicyType = vf.createIRI("http://schema.org/BoardingPolicyType");
        bodyLocation = vf.createIRI("http://schema.org/bodyLocation");
        BodyOfWater = vf.createIRI("http://schema.org/BodyOfWater");
        bodyType = vf.createIRI("http://schema.org/bodyType");
        Bone = vf.createIRI("http://schema.org/Bone");
        Book = vf.createIRI("http://schema.org/Book");
        bookEdition = vf.createIRI("http://schema.org/bookEdition");
        bookFormat = vf.createIRI("http://schema.org/bookFormat");
        BookFormatType = vf.createIRI("http://schema.org/BookFormatType");
        bookingAgent = vf.createIRI("http://schema.org/bookingAgent");
        bookingTime = vf.createIRI("http://schema.org/bookingTime");
        BookmarkAction = vf.createIRI("http://schema.org/BookmarkAction");
        BookSeries = vf.createIRI("http://schema.org/BookSeries");
        BookStore = vf.createIRI("http://schema.org/BookStore");
        Boolean = vf.createIRI("http://schema.org/Boolean");
        BorrowAction = vf.createIRI("http://schema.org/BorrowAction");
        borrower = vf.createIRI("http://schema.org/borrower");
        BowlingAlley = vf.createIRI("http://schema.org/BowlingAlley");
        box = vf.createIRI("http://schema.org/box");
        BrainStructure = vf.createIRI("http://schema.org/BrainStructure");
        branch = vf.createIRI("http://schema.org/branch");
        branchCode = vf.createIRI("http://schema.org/branchCode");
        branchOf = vf.createIRI("http://schema.org/branchOf");
        Brand = vf.createIRI("http://schema.org/Brand");
        brand = vf.createIRI("http://schema.org/brand");
        breadcrumb = vf.createIRI("http://schema.org/breadcrumb");
        BreadcrumbList = vf.createIRI("http://schema.org/BreadcrumbList");
        breastfeedingWarning = vf.createIRI("http://schema.org/breastfeedingWarning");
        Brewery = vf.createIRI("http://schema.org/Brewery");
        Bridge = vf.createIRI("http://schema.org/Bridge");
        broadcastAffiliateOf = vf.createIRI("http://schema.org/broadcastAffiliateOf");
        BroadcastChannel = vf.createIRI("http://schema.org/BroadcastChannel");
        broadcastChannelId = vf.createIRI("http://schema.org/broadcastChannelId");
        broadcastDisplayName = vf.createIRI("http://schema.org/broadcastDisplayName");
        broadcaster = vf.createIRI("http://schema.org/broadcaster");
        BroadcastEvent = vf.createIRI("http://schema.org/BroadcastEvent");
        broadcastFrequency = vf.createIRI("http://schema.org/broadcastFrequency");
        BroadcastFrequencySpecification = vf.createIRI("http://schema.org/BroadcastFrequencySpecification");
        broadcastFrequencyValue = vf.createIRI("http://schema.org/broadcastFrequencyValue");
        broadcastOfEvent = vf.createIRI("http://schema.org/broadcastOfEvent");
        BroadcastService = vf.createIRI("http://schema.org/BroadcastService");
        broadcastServiceTier = vf.createIRI("http://schema.org/broadcastServiceTier");
        broadcastTimezone = vf.createIRI("http://schema.org/broadcastTimezone");
        broker = vf.createIRI("http://schema.org/broker");
        BrokerageAccount = vf.createIRI("http://schema.org/BrokerageAccount");
        browserRequirements = vf.createIRI("http://schema.org/browserRequirements");
        BuddhistTemple = vf.createIRI("http://schema.org/BuddhistTemple");
        BusinessAudience = vf.createIRI("http://schema.org/BusinessAudience");
        BusinessEntityType = vf.createIRI("http://schema.org/BusinessEntityType");
        BusinessEvent = vf.createIRI("http://schema.org/BusinessEvent");
        BusinessFunction = vf.createIRI("http://schema.org/BusinessFunction");
        businessFunction = vf.createIRI("http://schema.org/businessFunction");
        busName = vf.createIRI("http://schema.org/busName");
        busNumber = vf.createIRI("http://schema.org/busNumber");
        BusOrCoach = vf.createIRI("http://schema.org/BusOrCoach");
        BusReservation = vf.createIRI("http://schema.org/BusReservation");
        BusStation = vf.createIRI("http://schema.org/BusStation");
        BusStop = vf.createIRI("http://schema.org/BusStop");
        BusTrip = vf.createIRI("http://schema.org/BusTrip");
        BuyAction = vf.createIRI("http://schema.org/BuyAction");
        buyer = vf.createIRI("http://schema.org/buyer");
        byArtist = vf.createIRI("http://schema.org/byArtist");
        byDay = vf.createIRI("http://schema.org/byDay");
        byMonth = vf.createIRI("http://schema.org/byMonth");
        byMonthDay = vf.createIRI("http://schema.org/byMonthDay");
        CableOrSatelliteService = vf.createIRI("http://schema.org/CableOrSatelliteService");
        CafeOrCoffeeShop = vf.createIRI("http://schema.org/CafeOrCoffeeShop");
        calories = vf.createIRI("http://schema.org/calories");
        Campground = vf.createIRI("http://schema.org/Campground");
        CampingPitch = vf.createIRI("http://schema.org/CampingPitch");
        Canal = vf.createIRI("http://schema.org/Canal");
        CancelAction = vf.createIRI("http://schema.org/CancelAction");
        candidate = vf.createIRI("http://schema.org/candidate");
        caption = vf.createIRI("http://schema.org/caption");
        Car = vf.createIRI("http://schema.org/Car");
        carbohydrateContent = vf.createIRI("http://schema.org/carbohydrateContent");
        cargoVolume = vf.createIRI("http://schema.org/cargoVolume");
        carrier = vf.createIRI("http://schema.org/carrier");
        carrierRequirements = vf.createIRI("http://schema.org/carrierRequirements");
        CarUsageType = vf.createIRI("http://schema.org/CarUsageType");
        cashBack = vf.createIRI("http://schema.org/cashBack");
        Casino = vf.createIRI("http://schema.org/Casino");
        catalog = vf.createIRI("http://schema.org/catalog");
        catalogNumber = vf.createIRI("http://schema.org/catalogNumber");
        category = vf.createIRI("http://schema.org/category");
        CategoryCode = vf.createIRI("http://schema.org/CategoryCode");
        CategoryCodeSet = vf.createIRI("http://schema.org/CategoryCodeSet");
        CatholicChurch = vf.createIRI("http://schema.org/CatholicChurch");
        cause = vf.createIRI("http://schema.org/cause");
        causeOf = vf.createIRI("http://schema.org/causeOf");
        ccRecipient = vf.createIRI("http://schema.org/ccRecipient");
        Cemetery = vf.createIRI("http://schema.org/Cemetery");
        Chapter = vf.createIRI("http://schema.org/Chapter");
        character = vf.createIRI("http://schema.org/character");
        characterAttribute = vf.createIRI("http://schema.org/characterAttribute");
        characterName = vf.createIRI("http://schema.org/characterName");
        cheatCode = vf.createIRI("http://schema.org/cheatCode");
        CheckAction = vf.createIRI("http://schema.org/CheckAction");
        CheckInAction = vf.createIRI("http://schema.org/CheckInAction");
        checkinTime = vf.createIRI("http://schema.org/checkinTime");
        CheckOutAction = vf.createIRI("http://schema.org/CheckOutAction");
        CheckoutPage = vf.createIRI("http://schema.org/CheckoutPage");
        checkoutTime = vf.createIRI("http://schema.org/checkoutTime");
        ChildCare = vf.createIRI("http://schema.org/ChildCare");
        childMaxAge = vf.createIRI("http://schema.org/childMaxAge");
        childMinAge = vf.createIRI("http://schema.org/childMinAge");
        children = vf.createIRI("http://schema.org/children");
        ChildrensEvent = vf.createIRI("http://schema.org/ChildrensEvent");
        cholesterolContent = vf.createIRI("http://schema.org/cholesterolContent");
        ChooseAction = vf.createIRI("http://schema.org/ChooseAction");
        Church = vf.createIRI("http://schema.org/Church");
        circle = vf.createIRI("http://schema.org/circle");
        citation = vf.createIRI("http://schema.org/citation");
        City = vf.createIRI("http://schema.org/City");
        CityHall = vf.createIRI("http://schema.org/CityHall");
        CivicStructure = vf.createIRI("http://schema.org/CivicStructure");
        Claim = vf.createIRI("http://schema.org/Claim");
        ClaimReview = vf.createIRI("http://schema.org/ClaimReview");
        claimReviewed = vf.createIRI("http://schema.org/claimReviewed");
        Class = vf.createIRI("http://schema.org/Class");
        clincalPharmacology = vf.createIRI("http://schema.org/clincalPharmacology");
        clinicalPharmacology = vf.createIRI("http://schema.org/clinicalPharmacology");
        Clip = vf.createIRI("http://schema.org/Clip");
        clipNumber = vf.createIRI("http://schema.org/clipNumber");
        closes = vf.createIRI("http://schema.org/closes");
        ClothingStore = vf.createIRI("http://schema.org/ClothingStore");
        coach = vf.createIRI("http://schema.org/coach");
        Code = vf.createIRI("http://schema.org/Code");
        code = vf.createIRI("http://schema.org/code");
        codeRepository = vf.createIRI("http://schema.org/codeRepository");
        codeSampleType = vf.createIRI("http://schema.org/codeSampleType");
        codeValue = vf.createIRI("http://schema.org/codeValue");
        codingSystem = vf.createIRI("http://schema.org/codingSystem");
        colleague = vf.createIRI("http://schema.org/colleague");
        colleagues = vf.createIRI("http://schema.org/colleagues");
        Collection = vf.createIRI("http://schema.org/Collection");
        collection = vf.createIRI("http://schema.org/collection");
        CollectionPage = vf.createIRI("http://schema.org/CollectionPage");
        CollegeOrUniversity = vf.createIRI("http://schema.org/CollegeOrUniversity");
        color = vf.createIRI("http://schema.org/color");
        colorist = vf.createIRI("http://schema.org/colorist");
        ComedyClub = vf.createIRI("http://schema.org/ComedyClub");
        ComedyEvent = vf.createIRI("http://schema.org/ComedyEvent");
        ComicCoverArt = vf.createIRI("http://schema.org/ComicCoverArt");
        ComicIssue = vf.createIRI("http://schema.org/ComicIssue");
        ComicSeries = vf.createIRI("http://schema.org/ComicSeries");
        ComicStory = vf.createIRI("http://schema.org/ComicStory");
        comment = vf.createIRI("http://schema.org/comment");
        Comment = vf.createIRI("http://schema.org/Comment");
        CommentAction = vf.createIRI("http://schema.org/CommentAction");
        commentCount = vf.createIRI("http://schema.org/commentCount");
        commentText = vf.createIRI("http://schema.org/commentText");
        commentTime = vf.createIRI("http://schema.org/commentTime");
        CommunicateAction = vf.createIRI("http://schema.org/CommunicateAction");
        competitor = vf.createIRI("http://schema.org/competitor");
        CompleteDataFeed = vf.createIRI("http://schema.org/CompleteDataFeed");
        composer = vf.createIRI("http://schema.org/composer");
        CompoundPriceSpecification = vf.createIRI("http://schema.org/CompoundPriceSpecification");
        comprisedOf = vf.createIRI("http://schema.org/comprisedOf");
        ComputerLanguage = vf.createIRI("http://schema.org/ComputerLanguage");
        ComputerStore = vf.createIRI("http://schema.org/ComputerStore");
        ConfirmAction = vf.createIRI("http://schema.org/ConfirmAction");
        confirmationNumber = vf.createIRI("http://schema.org/confirmationNumber");
        connectedTo = vf.createIRI("http://schema.org/connectedTo");
        Consortium = vf.createIRI("http://schema.org/Consortium");
        ConsumeAction = vf.createIRI("http://schema.org/ConsumeAction");
        contactlessPayment = vf.createIRI("http://schema.org/contactlessPayment");
        contactOption = vf.createIRI("http://schema.org/contactOption");
        ContactPage = vf.createIRI("http://schema.org/ContactPage");
        ContactPoint = vf.createIRI("http://schema.org/ContactPoint");
        contactPoint = vf.createIRI("http://schema.org/contactPoint");
        ContactPointOption = vf.createIRI("http://schema.org/ContactPointOption");
        contactPoints = vf.createIRI("http://schema.org/contactPoints");
        contactType = vf.createIRI("http://schema.org/contactType");
        containedIn = vf.createIRI("http://schema.org/containedIn");
        containedInPlace = vf.createIRI("http://schema.org/containedInPlace");
        containsPlace = vf.createIRI("http://schema.org/containsPlace");
        containsSeason = vf.createIRI("http://schema.org/containsSeason");
        contentLocation = vf.createIRI("http://schema.org/contentLocation");
        contentRating = vf.createIRI("http://schema.org/contentRating");
        contentReferenceTime = vf.createIRI("http://schema.org/contentReferenceTime");
        contentSize = vf.createIRI("http://schema.org/contentSize");
        contentType = vf.createIRI("http://schema.org/contentType");
        contentUrl = vf.createIRI("http://schema.org/contentUrl");
        Continent = vf.createIRI("http://schema.org/Continent");
        contraindication = vf.createIRI("http://schema.org/contraindication");
        contributor = vf.createIRI("http://schema.org/contributor");
        ControlAction = vf.createIRI("http://schema.org/ControlAction");
        ConvenienceStore = vf.createIRI("http://schema.org/ConvenienceStore");
        Conversation = vf.createIRI("http://schema.org/Conversation");
        CookAction = vf.createIRI("http://schema.org/CookAction");
        cookingMethod = vf.createIRI("http://schema.org/cookingMethod");
        cookTime = vf.createIRI("http://schema.org/cookTime");
        copyrightHolder = vf.createIRI("http://schema.org/copyrightHolder");
        copyrightYear = vf.createIRI("http://schema.org/copyrightYear");
        Corporation = vf.createIRI("http://schema.org/Corporation");
        correctionsPolicy = vf.createIRI("http://schema.org/correctionsPolicy");
        cost = vf.createIRI("http://schema.org/cost");
        costCategory = vf.createIRI("http://schema.org/costCategory");
        costCurrency = vf.createIRI("http://schema.org/costCurrency");
        costOrigin = vf.createIRI("http://schema.org/costOrigin");
        costPerUnit = vf.createIRI("http://schema.org/costPerUnit");
        countriesNotSupported = vf.createIRI("http://schema.org/countriesNotSupported");
        countriesSupported = vf.createIRI("http://schema.org/countriesSupported");
        Country = vf.createIRI("http://schema.org/Country");
        countryOfOrigin = vf.createIRI("http://schema.org/countryOfOrigin");
        Course = vf.createIRI("http://schema.org/Course");
        course = vf.createIRI("http://schema.org/course");
        courseCode = vf.createIRI("http://schema.org/courseCode");
        CourseInstance = vf.createIRI("http://schema.org/CourseInstance");
        courseMode = vf.createIRI("http://schema.org/courseMode");
        coursePrerequisites = vf.createIRI("http://schema.org/coursePrerequisites");
        Courthouse = vf.createIRI("http://schema.org/Courthouse");
        coverageEndTime = vf.createIRI("http://schema.org/coverageEndTime");
        coverageStartTime = vf.createIRI("http://schema.org/coverageStartTime");
        CoverArt = vf.createIRI("http://schema.org/CoverArt");
        CreateAction = vf.createIRI("http://schema.org/CreateAction");
        CreativeWork = vf.createIRI("http://schema.org/CreativeWork");
        CreativeWorkSeason = vf.createIRI("http://schema.org/CreativeWorkSeason");
        CreativeWorkSeries = vf.createIRI("http://schema.org/CreativeWorkSeries");
        creator = vf.createIRI("http://schema.org/creator");
        CreditCard = vf.createIRI("http://schema.org/CreditCard");
        creditedTo = vf.createIRI("http://schema.org/creditedTo");
        Crematorium = vf.createIRI("http://schema.org/Crematorium");
        CriticReview = vf.createIRI("http://schema.org/CriticReview");
        cssSelector = vf.createIRI("http://schema.org/cssSelector");
        CssSelectorType = vf.createIRI("http://schema.org/CssSelectorType");
        currenciesAccepted = vf.createIRI("http://schema.org/currenciesAccepted");
        currency = vf.createIRI("http://schema.org/currency");
        CurrencyConversionService = vf.createIRI("http://schema.org/CurrencyConversionService");
        currentExchangeRate = vf.createIRI("http://schema.org/currentExchangeRate");
        customer = vf.createIRI("http://schema.org/customer");
        DanceEvent = vf.createIRI("http://schema.org/DanceEvent");
        DanceGroup = vf.createIRI("http://schema.org/DanceGroup");
        DataCatalog = vf.createIRI("http://schema.org/DataCatalog");
        DataDownload = vf.createIRI("http://schema.org/DataDownload");
        DataFeed = vf.createIRI("http://schema.org/DataFeed");
        dataFeedElement = vf.createIRI("http://schema.org/dataFeedElement");
        DataFeedItem = vf.createIRI("http://schema.org/DataFeedItem");
        dataset = vf.createIRI("http://schema.org/dataset");
        Dataset = vf.createIRI("http://schema.org/Dataset");
        datasetTimeInterval = vf.createIRI("http://schema.org/datasetTimeInterval");
        DataType = vf.createIRI("http://schema.org/DataType");
        Date = vf.createIRI("http://schema.org/Date");
        dateCreated = vf.createIRI("http://schema.org/dateCreated");
        dateDeleted = vf.createIRI("http://schema.org/dateDeleted");
        DatedMoneySpecification = vf.createIRI("http://schema.org/DatedMoneySpecification");
        dateIssued = vf.createIRI("http://schema.org/dateIssued");
        dateline = vf.createIRI("http://schema.org/dateline");
        dateModified = vf.createIRI("http://schema.org/dateModified");
        datePosted = vf.createIRI("http://schema.org/datePosted");
        datePublished = vf.createIRI("http://schema.org/datePublished");
        dateRead = vf.createIRI("http://schema.org/dateRead");
        dateReceived = vf.createIRI("http://schema.org/dateReceived");
        dateSent = vf.createIRI("http://schema.org/dateSent");
        DateTime = vf.createIRI("http://schema.org/DateTime");
        dateVehicleFirstRegistered = vf.createIRI("http://schema.org/dateVehicleFirstRegistered");
        DayOfWeek = vf.createIRI("http://schema.org/DayOfWeek");
        dayOfWeek = vf.createIRI("http://schema.org/dayOfWeek");
        DaySpa = vf.createIRI("http://schema.org/DaySpa");
        DDxElement = vf.createIRI("http://schema.org/DDxElement");
        DeactivateAction = vf.createIRI("http://schema.org/DeactivateAction");
        deathDate = vf.createIRI("http://schema.org/deathDate");
        deathPlace = vf.createIRI("http://schema.org/deathPlace");
        defaultValue = vf.createIRI("http://schema.org/defaultValue");
        DefenceEstablishment = vf.createIRI("http://schema.org/DefenceEstablishment");
        DefinedTerm = vf.createIRI("http://schema.org/DefinedTerm");
        DefinedTermSet = vf.createIRI("http://schema.org/DefinedTermSet");
        DeleteAction = vf.createIRI("http://schema.org/DeleteAction");
        deliveryAddress = vf.createIRI("http://schema.org/deliveryAddress");
        DeliveryChargeSpecification = vf.createIRI("http://schema.org/DeliveryChargeSpecification");
        DeliveryEvent = vf.createIRI("http://schema.org/DeliveryEvent");
        deliveryLeadTime = vf.createIRI("http://schema.org/deliveryLeadTime");
        DeliveryMethod = vf.createIRI("http://schema.org/DeliveryMethod");
        deliveryMethod = vf.createIRI("http://schema.org/deliveryMethod");
        deliveryStatus = vf.createIRI("http://schema.org/deliveryStatus");
        Demand = vf.createIRI("http://schema.org/Demand");
        Dentist = vf.createIRI("http://schema.org/Dentist");
        DepartAction = vf.createIRI("http://schema.org/DepartAction");
        department = vf.createIRI("http://schema.org/department");
        DepartmentStore = vf.createIRI("http://schema.org/DepartmentStore");
        departureAirport = vf.createIRI("http://schema.org/departureAirport");
        departureBusStop = vf.createIRI("http://schema.org/departureBusStop");
        departureGate = vf.createIRI("http://schema.org/departureGate");
        departurePlatform = vf.createIRI("http://schema.org/departurePlatform");
        departureStation = vf.createIRI("http://schema.org/departureStation");
        departureTerminal = vf.createIRI("http://schema.org/departureTerminal");
        departureTime = vf.createIRI("http://schema.org/departureTime");
        dependencies = vf.createIRI("http://schema.org/dependencies");
        DepositAccount = vf.createIRI("http://schema.org/DepositAccount");
        depth = vf.createIRI("http://schema.org/depth");
        description = vf.createIRI("http://schema.org/description");
        device = vf.createIRI("http://schema.org/device");
        diagnosis = vf.createIRI("http://schema.org/diagnosis");
        DiagnosticLab = vf.createIRI("http://schema.org/DiagnosticLab");
        DiagnosticProcedure = vf.createIRI("http://schema.org/DiagnosticProcedure");
        diagram = vf.createIRI("http://schema.org/diagram");
        Diet = vf.createIRI("http://schema.org/Diet");
        diet = vf.createIRI("http://schema.org/diet");
        DietarySupplement = vf.createIRI("http://schema.org/DietarySupplement");
        dietFeatures = vf.createIRI("http://schema.org/dietFeatures");
        differentialDiagnosis = vf.createIRI("http://schema.org/differentialDiagnosis");
        DigitalDocument = vf.createIRI("http://schema.org/DigitalDocument");
        DigitalDocumentPermission = vf.createIRI("http://schema.org/DigitalDocumentPermission");
        DigitalDocumentPermissionType = vf.createIRI("http://schema.org/DigitalDocumentPermissionType");
        director = vf.createIRI("http://schema.org/director");
        directors = vf.createIRI("http://schema.org/directors");
        DisagreeAction = vf.createIRI("http://schema.org/DisagreeAction");
        disambiguatingDescription = vf.createIRI("http://schema.org/disambiguatingDescription");
        discount = vf.createIRI("http://schema.org/discount");
        discountCode = vf.createIRI("http://schema.org/discountCode");
        discountCurrency = vf.createIRI("http://schema.org/discountCurrency");
        DiscoverAction = vf.createIRI("http://schema.org/DiscoverAction");
        discusses = vf.createIRI("http://schema.org/discusses");
        DiscussionForumPosting = vf.createIRI("http://schema.org/DiscussionForumPosting");
        discussionUrl = vf.createIRI("http://schema.org/discussionUrl");
        DislikeAction = vf.createIRI("http://schema.org/DislikeAction");
        dissolutionDate = vf.createIRI("http://schema.org/dissolutionDate");
        Distance = vf.createIRI("http://schema.org/Distance");
        distance = vf.createIRI("http://schema.org/distance");
        Distillery = vf.createIRI("http://schema.org/Distillery");
        distinguishingSign = vf.createIRI("http://schema.org/distinguishingSign");
        distribution = vf.createIRI("http://schema.org/distribution");
        diversityPolicy = vf.createIRI("http://schema.org/diversityPolicy");
        diversityStaffingReport = vf.createIRI("http://schema.org/diversityStaffingReport");
        documentation = vf.createIRI("http://schema.org/documentation");
        domainIncludes = vf.createIRI("http://schema.org/domainIncludes");
        domiciledMortgage = vf.createIRI("http://schema.org/domiciledMortgage");
        DonateAction = vf.createIRI("http://schema.org/DonateAction");
        doorTime = vf.createIRI("http://schema.org/doorTime");
        dosageForm = vf.createIRI("http://schema.org/dosageForm");
        DoseSchedule = vf.createIRI("http://schema.org/DoseSchedule");
        doseSchedule = vf.createIRI("http://schema.org/doseSchedule");
        doseUnit = vf.createIRI("http://schema.org/doseUnit");
        doseValue = vf.createIRI("http://schema.org/doseValue");
        DownloadAction = vf.createIRI("http://schema.org/DownloadAction");
        downloadUrl = vf.createIRI("http://schema.org/downloadUrl");
        downPayment = vf.createIRI("http://schema.org/downPayment");
        downvoteCount = vf.createIRI("http://schema.org/downvoteCount");
        drainsTo = vf.createIRI("http://schema.org/drainsTo");
        DrawAction = vf.createIRI("http://schema.org/DrawAction");
        DrinkAction = vf.createIRI("http://schema.org/DrinkAction");
        driveWheelConfiguration = vf.createIRI("http://schema.org/driveWheelConfiguration");
        DriveWheelConfigurationValue = vf.createIRI("http://schema.org/DriveWheelConfigurationValue");
        dropoffLocation = vf.createIRI("http://schema.org/dropoffLocation");
        dropoffTime = vf.createIRI("http://schema.org/dropoffTime");
        Drug = vf.createIRI("http://schema.org/Drug");
        drug = vf.createIRI("http://schema.org/drug");
        drugClass = vf.createIRI("http://schema.org/drugClass");
        DrugClass = vf.createIRI("http://schema.org/DrugClass");
        DrugCost = vf.createIRI("http://schema.org/DrugCost");
        DrugCostCategory = vf.createIRI("http://schema.org/DrugCostCategory");
        DrugLegalStatus = vf.createIRI("http://schema.org/DrugLegalStatus");
        DrugPregnancyCategory = vf.createIRI("http://schema.org/DrugPregnancyCategory");
        DrugPrescriptionStatus = vf.createIRI("http://schema.org/DrugPrescriptionStatus");
        DrugStrength = vf.createIRI("http://schema.org/DrugStrength");
        drugUnit = vf.createIRI("http://schema.org/drugUnit");
        DryCleaningOrLaundry = vf.createIRI("http://schema.org/DryCleaningOrLaundry");
        duns = vf.createIRI("http://schema.org/duns");
        duplicateTherapy = vf.createIRI("http://schema.org/duplicateTherapy");
        duration = vf.createIRI("http://schema.org/duration");
        Duration = vf.createIRI("http://schema.org/Duration");
        durationOfWarranty = vf.createIRI("http://schema.org/durationOfWarranty");
        duringMedia = vf.createIRI("http://schema.org/duringMedia");
        earlyPrepaymentPenalty = vf.createIRI("http://schema.org/earlyPrepaymentPenalty");
        EatAction = vf.createIRI("http://schema.org/EatAction");
        editor = vf.createIRI("http://schema.org/editor");
        educationalAlignment = vf.createIRI("http://schema.org/educationalAlignment");
        EducationalAudience = vf.createIRI("http://schema.org/EducationalAudience");
        educationalCredentialAwarded = vf.createIRI("http://schema.org/educationalCredentialAwarded");
        educationalFramework = vf.createIRI("http://schema.org/educationalFramework");
        EducationalOrganization = vf.createIRI("http://schema.org/EducationalOrganization");
        educationalRole = vf.createIRI("http://schema.org/educationalRole");
        educationalUse = vf.createIRI("http://schema.org/educationalUse");
        EducationEvent = vf.createIRI("http://schema.org/EducationEvent");
        educationRequirements = vf.createIRI("http://schema.org/educationRequirements");
        Electrician = vf.createIRI("http://schema.org/Electrician");
        ElectronicsStore = vf.createIRI("http://schema.org/ElectronicsStore");
        ElementarySchool = vf.createIRI("http://schema.org/ElementarySchool");
        elevation = vf.createIRI("http://schema.org/elevation");
        eligibleCustomerType = vf.createIRI("http://schema.org/eligibleCustomerType");
        eligibleDuration = vf.createIRI("http://schema.org/eligibleDuration");
        eligibleQuantity = vf.createIRI("http://schema.org/eligibleQuantity");
        eligibleRegion = vf.createIRI("http://schema.org/eligibleRegion");
        eligibleTransactionVolume = vf.createIRI("http://schema.org/eligibleTransactionVolume");
        email = vf.createIRI("http://schema.org/email");
        EmailMessage = vf.createIRI("http://schema.org/EmailMessage");
        Embassy = vf.createIRI("http://schema.org/Embassy");
        embedUrl = vf.createIRI("http://schema.org/embedUrl");
        EmergencyService = vf.createIRI("http://schema.org/EmergencyService");
        emissionsCO2 = vf.createIRI("http://schema.org/emissionsCO2");
        employee = vf.createIRI("http://schema.org/employee");
        EmployeeRole = vf.createIRI("http://schema.org/EmployeeRole");
        employees = vf.createIRI("http://schema.org/employees");
        EmployerAggregateRating = vf.createIRI("http://schema.org/EmployerAggregateRating");
        EmployerReview = vf.createIRI("http://schema.org/EmployerReview");
        EmploymentAgency = vf.createIRI("http://schema.org/EmploymentAgency");
        employmentType = vf.createIRI("http://schema.org/employmentType");
        encodesCreativeWork = vf.createIRI("http://schema.org/encodesCreativeWork");
        encoding = vf.createIRI("http://schema.org/encoding");
        encodingFormat = vf.createIRI("http://schema.org/encodingFormat");
        encodings = vf.createIRI("http://schema.org/encodings");
        encodingType = vf.createIRI("http://schema.org/encodingType");
        endDate = vf.createIRI("http://schema.org/endDate");
        EndorseAction = vf.createIRI("http://schema.org/EndorseAction");
        endorsee = vf.createIRI("http://schema.org/endorsee");
        EndorsementRating = vf.createIRI("http://schema.org/EndorsementRating");
        endorsers = vf.createIRI("http://schema.org/endorsers");
        endTime = vf.createIRI("http://schema.org/endTime");
        Energy = vf.createIRI("http://schema.org/Energy");
        engineDisplacement = vf.createIRI("http://schema.org/engineDisplacement");
        enginePower = vf.createIRI("http://schema.org/enginePower");
        EngineSpecification = vf.createIRI("http://schema.org/EngineSpecification");
        engineType = vf.createIRI("http://schema.org/engineType");
        entertainmentBusiness = vf.createIRI("http://schema.org/entertainmentBusiness");
        EntertainmentBusiness = vf.createIRI("http://schema.org/EntertainmentBusiness");
        EntryPoint = vf.createIRI("http://schema.org/EntryPoint");
        Enumeration = vf.createIRI("http://schema.org/Enumeration");
        epidemiology = vf.createIRI("http://schema.org/epidemiology");
        Episode = vf.createIRI("http://schema.org/Episode");
        episode = vf.createIRI("http://schema.org/episode");
        episodeNumber = vf.createIRI("http://schema.org/episodeNumber");
        episodes = vf.createIRI("http://schema.org/episodes");
        equal = vf.createIRI("http://schema.org/equal");
        error = vf.createIRI("http://schema.org/error");
        estimatedCost = vf.createIRI("http://schema.org/estimatedCost");
        estimatedFlightDuration = vf.createIRI("http://schema.org/estimatedFlightDuration");
        estimatedSalary = vf.createIRI("http://schema.org/estimatedSalary");
        estimatesRiskOf = vf.createIRI("http://schema.org/estimatesRiskOf");
        ethicsPolicy = vf.createIRI("http://schema.org/ethicsPolicy");
        Event = vf.createIRI("http://schema.org/Event");
        event = vf.createIRI("http://schema.org/event");
        EventReservation = vf.createIRI("http://schema.org/EventReservation");
        events = vf.createIRI("http://schema.org/events");
        eventSchedule = vf.createIRI("http://schema.org/eventSchedule");
        EventSeries = vf.createIRI("http://schema.org/EventSeries");
        eventStatus = vf.createIRI("http://schema.org/eventStatus");
        EventStatusType = vf.createIRI("http://schema.org/EventStatusType");
        EventVenue = vf.createIRI("http://schema.org/EventVenue");
        evidenceLevel = vf.createIRI("http://schema.org/evidenceLevel");
        evidenceOrigin = vf.createIRI("http://schema.org/evidenceOrigin");
        exampleOfWork = vf.createIRI("http://schema.org/exampleOfWork");
        exceptDate = vf.createIRI("http://schema.org/exceptDate");
        ExchangeRateSpecification = vf.createIRI("http://schema.org/ExchangeRateSpecification");
        exchangeRateSpread = vf.createIRI("http://schema.org/exchangeRateSpread");
        executableLibraryName = vf.createIRI("http://schema.org/executableLibraryName");
        ExerciseAction = vf.createIRI("http://schema.org/ExerciseAction");
        exerciseCourse = vf.createIRI("http://schema.org/exerciseCourse");
        ExerciseGym = vf.createIRI("http://schema.org/ExerciseGym");
        exercisePlan = vf.createIRI("http://schema.org/exercisePlan");
        ExercisePlan = vf.createIRI("http://schema.org/ExercisePlan");
        exerciseRelatedDiet = vf.createIRI("http://schema.org/exerciseRelatedDiet");
        exerciseType = vf.createIRI("http://schema.org/exerciseType");
        ExhibitionEvent = vf.createIRI("http://schema.org/ExhibitionEvent");
        exifData = vf.createIRI("http://schema.org/exifData");
        expectedArrivalFrom = vf.createIRI("http://schema.org/expectedArrivalFrom");
        expectedArrivalUntil = vf.createIRI("http://schema.org/expectedArrivalUntil");
        expectedPrognosis = vf.createIRI("http://schema.org/expectedPrognosis");
        expectsAcceptanceOf = vf.createIRI("http://schema.org/expectsAcceptanceOf");
        experienceRequirements = vf.createIRI("http://schema.org/experienceRequirements");
        expertConsiderations = vf.createIRI("http://schema.org/expertConsiderations");
        expires = vf.createIRI("http://schema.org/expires");
        False = vf.createIRI("http://schema.org/False");
        familyName = vf.createIRI("http://schema.org/familyName");
        FAQPage = vf.createIRI("http://schema.org/FAQPage");
        FastFoodRestaurant = vf.createIRI("http://schema.org/FastFoodRestaurant");
        fatContent = vf.createIRI("http://schema.org/fatContent");
        faxNumber = vf.createIRI("http://schema.org/faxNumber");
        featureList = vf.createIRI("http://schema.org/featureList");
        feesAndCommissionsSpecification = vf.createIRI("http://schema.org/feesAndCommissionsSpecification");
        Festival = vf.createIRI("http://schema.org/Festival");
        fiberContent = vf.createIRI("http://schema.org/fiberContent");
        fileFormat = vf.createIRI("http://schema.org/fileFormat");
        fileSize = vf.createIRI("http://schema.org/fileSize");
        FilmAction = vf.createIRI("http://schema.org/FilmAction");
        FinancialProduct = vf.createIRI("http://schema.org/FinancialProduct");
        FinancialService = vf.createIRI("http://schema.org/FinancialService");
        FindAction = vf.createIRI("http://schema.org/FindAction");
        FireStation = vf.createIRI("http://schema.org/FireStation");
        firstAppearance = vf.createIRI("http://schema.org/firstAppearance");
        firstPerformance = vf.createIRI("http://schema.org/firstPerformance");
        Flight = vf.createIRI("http://schema.org/Flight");
        flightDistance = vf.createIRI("http://schema.org/flightDistance");
        flightNumber = vf.createIRI("http://schema.org/flightNumber");
        FlightReservation = vf.createIRI("http://schema.org/FlightReservation");
        Float = vf.createIRI("http://schema.org/Float");
        floorLimit = vf.createIRI("http://schema.org/floorLimit");
        floorSize = vf.createIRI("http://schema.org/floorSize");
        Florist = vf.createIRI("http://schema.org/Florist");
        FMRadioChannel = vf.createIRI("http://schema.org/FMRadioChannel");
        FollowAction = vf.createIRI("http://schema.org/FollowAction");
        followee = vf.createIRI("http://schema.org/followee");
        follows = vf.createIRI("http://schema.org/follows");
        followup = vf.createIRI("http://schema.org/followup");
        foodEstablishment = vf.createIRI("http://schema.org/foodEstablishment");
        FoodEstablishment = vf.createIRI("http://schema.org/FoodEstablishment");
        FoodEstablishmentReservation = vf.createIRI("http://schema.org/FoodEstablishmentReservation");
        FoodEvent = vf.createIRI("http://schema.org/FoodEvent");
        foodEvent = vf.createIRI("http://schema.org/foodEvent");
        FoodService = vf.createIRI("http://schema.org/FoodService");
        foodWarning = vf.createIRI("http://schema.org/foodWarning");
        founder = vf.createIRI("http://schema.org/founder");
        founders = vf.createIRI("http://schema.org/founders");
        foundingDate = vf.createIRI("http://schema.org/foundingDate");
        foundingLocation = vf.createIRI("http://schema.org/foundingLocation");
        free = vf.createIRI("http://schema.org/free");
        frequency = vf.createIRI("http://schema.org/frequency");
        fromLocation = vf.createIRI("http://schema.org/fromLocation");
        fuelCapacity = vf.createIRI("http://schema.org/fuelCapacity");
        fuelConsumption = vf.createIRI("http://schema.org/fuelConsumption");
        fuelEfficiency = vf.createIRI("http://schema.org/fuelEfficiency");
        fuelType = vf.createIRI("http://schema.org/fuelType");
        function = vf.createIRI("http://schema.org/function");
        functionalClass = vf.createIRI("http://schema.org/functionalClass");
        funder = vf.createIRI("http://schema.org/funder");
        FurnitureStore = vf.createIRI("http://schema.org/FurnitureStore");
        Game = vf.createIRI("http://schema.org/Game");
        game = vf.createIRI("http://schema.org/game");
        gameItem = vf.createIRI("http://schema.org/gameItem");
        gameLocation = vf.createIRI("http://schema.org/gameLocation");
        gamePlatform = vf.createIRI("http://schema.org/gamePlatform");
        GamePlayMode = vf.createIRI("http://schema.org/GamePlayMode");
        gameServer = vf.createIRI("http://schema.org/gameServer");
        GameServer = vf.createIRI("http://schema.org/GameServer");
        GameServerStatus = vf.createIRI("http://schema.org/GameServerStatus");
        gameTip = vf.createIRI("http://schema.org/gameTip");
        GardenStore = vf.createIRI("http://schema.org/GardenStore");
        GasStation = vf.createIRI("http://schema.org/GasStation");
        GatedResidenceCommunity = vf.createIRI("http://schema.org/GatedResidenceCommunity");
        gender = vf.createIRI("http://schema.org/gender");
        GenderType = vf.createIRI("http://schema.org/GenderType");
        GeneralContractor = vf.createIRI("http://schema.org/GeneralContractor");
        genre = vf.createIRI("http://schema.org/genre");
        geo = vf.createIRI("http://schema.org/geo");
        GeoCircle = vf.createIRI("http://schema.org/GeoCircle");
        GeoCoordinates = vf.createIRI("http://schema.org/GeoCoordinates");
        geographicArea = vf.createIRI("http://schema.org/geographicArea");
        geoMidpoint = vf.createIRI("http://schema.org/geoMidpoint");
        geoRadius = vf.createIRI("http://schema.org/geoRadius");
        GeoShape = vf.createIRI("http://schema.org/GeoShape");
        GeospatialGeometry = vf.createIRI("http://schema.org/GeospatialGeometry");
        geospatiallyContains = vf.createIRI("http://schema.org/geospatiallyContains");
        geospatiallyCoveredBy = vf.createIRI("http://schema.org/geospatiallyCoveredBy");
        geospatiallyCovers = vf.createIRI("http://schema.org/geospatiallyCovers");
        geospatiallyCrosses = vf.createIRI("http://schema.org/geospatiallyCrosses");
        geospatiallyDisjoint = vf.createIRI("http://schema.org/geospatiallyDisjoint");
        geospatiallyEquals = vf.createIRI("http://schema.org/geospatiallyEquals");
        geospatiallyIntersects = vf.createIRI("http://schema.org/geospatiallyIntersects");
        geospatiallyOverlaps = vf.createIRI("http://schema.org/geospatiallyOverlaps");
        geospatiallyTouches = vf.createIRI("http://schema.org/geospatiallyTouches");
        geospatiallyWithin = vf.createIRI("http://schema.org/geospatiallyWithin");
        GiveAction = vf.createIRI("http://schema.org/GiveAction");
        givenName = vf.createIRI("http://schema.org/givenName");
        globalLocationNumber = vf.createIRI("http://schema.org/globalLocationNumber");
        GolfCourse = vf.createIRI("http://schema.org/GolfCourse");
        GovernmentBuilding = vf.createIRI("http://schema.org/GovernmentBuilding");
        GovernmentOffice = vf.createIRI("http://schema.org/GovernmentOffice");
        GovernmentOrganization = vf.createIRI("http://schema.org/GovernmentOrganization");
        GovernmentPermit = vf.createIRI("http://schema.org/GovernmentPermit");
        GovernmentService = vf.createIRI("http://schema.org/GovernmentService");
        gracePeriod = vf.createIRI("http://schema.org/gracePeriod");
        grantee = vf.createIRI("http://schema.org/grantee");
        greater = vf.createIRI("http://schema.org/greater");
        greaterOrEqual = vf.createIRI("http://schema.org/greaterOrEqual");
        GroceryStore = vf.createIRI("http://schema.org/GroceryStore");
        gtin12 = vf.createIRI("http://schema.org/gtin12");
        gtin13 = vf.createIRI("http://schema.org/gtin13");
        gtin14 = vf.createIRI("http://schema.org/gtin14");
        gtin8 = vf.createIRI("http://schema.org/gtin8");
        guideline = vf.createIRI("http://schema.org/guideline");
        guidelineDate = vf.createIRI("http://schema.org/guidelineDate");
        guidelineSubject = vf.createIRI("http://schema.org/guidelineSubject");
        HairSalon = vf.createIRI("http://schema.org/HairSalon");
        HardwareStore = vf.createIRI("http://schema.org/HardwareStore");
        hasBroadcastChannel = vf.createIRI("http://schema.org/hasBroadcastChannel");
        hasCategoryCode = vf.createIRI("http://schema.org/hasCategoryCode");
        hasCourseInstance = vf.createIRI("http://schema.org/hasCourseInstance");
        hasDefinedTerm = vf.createIRI("http://schema.org/hasDefinedTerm");
        hasDeliveryMethod = vf.createIRI("http://schema.org/hasDeliveryMethod");
        hasDigitalDocumentPermission = vf.createIRI("http://schema.org/hasDigitalDocumentPermission");
        hasMap = vf.createIRI("http://schema.org/hasMap");
        hasMenu = vf.createIRI("http://schema.org/hasMenu");
        hasMenuItem = vf.createIRI("http://schema.org/hasMenuItem");
        hasMenuSection = vf.createIRI("http://schema.org/hasMenuSection");
        hasOccupation = vf.createIRI("http://schema.org/hasOccupation");
        hasOfferCatalog = vf.createIRI("http://schema.org/hasOfferCatalog");
        hasPart = vf.createIRI("http://schema.org/hasPart");
        hasPOS = vf.createIRI("http://schema.org/hasPOS");
        headline = vf.createIRI("http://schema.org/headline");
        HealthAndBeautyBusiness = vf.createIRI("http://schema.org/HealthAndBeautyBusiness");
        HealthClub = vf.createIRI("http://schema.org/HealthClub");
        healthCondition = vf.createIRI("http://schema.org/healthCondition");
        HealthInsurancePlan = vf.createIRI("http://schema.org/HealthInsurancePlan");
        healthPlanCoinsuranceOption = vf.createIRI("http://schema.org/healthPlanCoinsuranceOption");
        healthPlanCoinsuranceRate = vf.createIRI("http://schema.org/healthPlanCoinsuranceRate");
        healthPlanCopay = vf.createIRI("http://schema.org/healthPlanCopay");
        healthPlanCopayOption = vf.createIRI("http://schema.org/healthPlanCopayOption");
        healthPlanCostSharing = vf.createIRI("http://schema.org/healthPlanCostSharing");
        HealthPlanCostSharingSpecification = vf.createIRI("http://schema.org/HealthPlanCostSharingSpecification");
        healthPlanDrugOption = vf.createIRI("http://schema.org/healthPlanDrugOption");
        healthPlanDrugTier = vf.createIRI("http://schema.org/healthPlanDrugTier");
        HealthPlanFormulary = vf.createIRI("http://schema.org/HealthPlanFormulary");
        healthPlanId = vf.createIRI("http://schema.org/healthPlanId");
        healthPlanMarketingUrl = vf.createIRI("http://schema.org/healthPlanMarketingUrl");
        HealthPlanNetwork = vf.createIRI("http://schema.org/HealthPlanNetwork");
        healthPlanNetworkId = vf.createIRI("http://schema.org/healthPlanNetworkId");
        healthPlanNetworkTier = vf.createIRI("http://schema.org/healthPlanNetworkTier");
        healthPlanPharmacyCategory = vf.createIRI("http://schema.org/healthPlanPharmacyCategory");
        height = vf.createIRI("http://schema.org/height");
        highPrice = vf.createIRI("http://schema.org/highPrice");
        HighSchool = vf.createIRI("http://schema.org/HighSchool");
        HinduTemple = vf.createIRI("http://schema.org/HinduTemple");
        hiringOrganization = vf.createIRI("http://schema.org/hiringOrganization");
        HobbyShop = vf.createIRI("http://schema.org/HobbyShop");
        HomeAndConstructionBusiness = vf.createIRI("http://schema.org/HomeAndConstructionBusiness");
        HomeGoodsStore = vf.createIRI("http://schema.org/HomeGoodsStore");
        homeLocation = vf.createIRI("http://schema.org/homeLocation");
        homeTeam = vf.createIRI("http://schema.org/homeTeam");
        honorificPrefix = vf.createIRI("http://schema.org/honorificPrefix");
        honorificSuffix = vf.createIRI("http://schema.org/honorificSuffix");
        Hospital = vf.createIRI("http://schema.org/Hospital");
        hospitalAffiliation = vf.createIRI("http://schema.org/hospitalAffiliation");
        Hostel = vf.createIRI("http://schema.org/Hostel");
        hostingOrganization = vf.createIRI("http://schema.org/hostingOrganization");
        Hotel = vf.createIRI("http://schema.org/Hotel");
        HotelRoom = vf.createIRI("http://schema.org/HotelRoom");
        hoursAvailable = vf.createIRI("http://schema.org/hoursAvailable");
        House = vf.createIRI("http://schema.org/House");
        HousePainter = vf.createIRI("http://schema.org/HousePainter");
        howPerformed = vf.createIRI("http://schema.org/howPerformed");
        HowTo = vf.createIRI("http://schema.org/HowTo");
        HowToDirection = vf.createIRI("http://schema.org/HowToDirection");
        HowToItem = vf.createIRI("http://schema.org/HowToItem");
        HowToSection = vf.createIRI("http://schema.org/HowToSection");
        HowToStep = vf.createIRI("http://schema.org/HowToStep");
        HowToSupply = vf.createIRI("http://schema.org/HowToSupply");
        HowToTip = vf.createIRI("http://schema.org/HowToTip");
        HowToTool = vf.createIRI("http://schema.org/HowToTool");
        httpMethod = vf.createIRI("http://schema.org/httpMethod");
        HVACBusiness = vf.createIRI("http://schema.org/HVACBusiness");
        iataCode = vf.createIRI("http://schema.org/iataCode");
        icaoCode = vf.createIRI("http://schema.org/icaoCode");
        IceCreamShop = vf.createIRI("http://schema.org/IceCreamShop");
        identifier = vf.createIRI("http://schema.org/identifier");
        identifyingExam = vf.createIRI("http://schema.org/identifyingExam");
        identifyingTest = vf.createIRI("http://schema.org/identifyingTest");
        IgnoreAction = vf.createIRI("http://schema.org/IgnoreAction");
        illustrator = vf.createIRI("http://schema.org/illustrator");
        image = vf.createIRI("http://schema.org/image");
        ImageGallery = vf.createIRI("http://schema.org/ImageGallery");
        ImageObject = vf.createIRI("http://schema.org/ImageObject");
        imagingTechnique = vf.createIRI("http://schema.org/imagingTechnique");
        ImagingTest = vf.createIRI("http://schema.org/ImagingTest");
        inAlbum = vf.createIRI("http://schema.org/inAlbum");
        inBroadcastLineup = vf.createIRI("http://schema.org/inBroadcastLineup");
        incentiveCompensation = vf.createIRI("http://schema.org/incentiveCompensation");
        incentives = vf.createIRI("http://schema.org/incentives");
        includedComposition = vf.createIRI("http://schema.org/includedComposition");
        includedDataCatalog = vf.createIRI("http://schema.org/includedDataCatalog");
        includedInDataCatalog = vf.createIRI("http://schema.org/includedInDataCatalog");
        includedInHealthInsurancePlan = vf.createIRI("http://schema.org/includedInHealthInsurancePlan");
        includedRiskFactor = vf.createIRI("http://schema.org/includedRiskFactor");
        includesAttraction = vf.createIRI("http://schema.org/includesAttraction");
        includesHealthPlanFormulary = vf.createIRI("http://schema.org/includesHealthPlanFormulary");
        includesHealthPlanNetwork = vf.createIRI("http://schema.org/includesHealthPlanNetwork");
        includesObject = vf.createIRI("http://schema.org/includesObject");
        inCodeSet = vf.createIRI("http://schema.org/inCodeSet");
        increasesRiskOf = vf.createIRI("http://schema.org/increasesRiskOf");
        inDefinedTermSet = vf.createIRI("http://schema.org/inDefinedTermSet");
        indication = vf.createIRI("http://schema.org/indication");
        IndividualProduct = vf.createIRI("http://schema.org/IndividualProduct");
        industry = vf.createIRI("http://schema.org/industry");
        ineligibleRegion = vf.createIRI("http://schema.org/ineligibleRegion");
        infectiousAgent = vf.createIRI("http://schema.org/infectiousAgent");
        InfectiousAgentClass = vf.createIRI("http://schema.org/InfectiousAgentClass");
        infectiousAgentClass = vf.createIRI("http://schema.org/infectiousAgentClass");
        InfectiousDisease = vf.createIRI("http://schema.org/InfectiousDisease");
        InformAction = vf.createIRI("http://schema.org/InformAction");
        ingredients = vf.createIRI("http://schema.org/ingredients");
        inker = vf.createIRI("http://schema.org/inker");
        inLanguage = vf.createIRI("http://schema.org/inLanguage");
        inPlaylist = vf.createIRI("http://schema.org/inPlaylist");
        InsertAction = vf.createIRI("http://schema.org/InsertAction");
        insertion = vf.createIRI("http://schema.org/insertion");
        InstallAction = vf.createIRI("http://schema.org/InstallAction");
        installUrl = vf.createIRI("http://schema.org/installUrl");
        instructor = vf.createIRI("http://schema.org/instructor");
        instrument = vf.createIRI("http://schema.org/instrument");
        inSupportOf = vf.createIRI("http://schema.org/inSupportOf");
        InsuranceAgency = vf.createIRI("http://schema.org/InsuranceAgency");
        Intangible = vf.createIRI("http://schema.org/Intangible");
        Integer = vf.createIRI("http://schema.org/Integer");
        intensity = vf.createIRI("http://schema.org/intensity");
        InteractAction = vf.createIRI("http://schema.org/InteractAction");
        interactingDrug = vf.createIRI("http://schema.org/interactingDrug");
        interactionCount = vf.createIRI("http://schema.org/interactionCount");
        InteractionCounter = vf.createIRI("http://schema.org/InteractionCounter");
        interactionService = vf.createIRI("http://schema.org/interactionService");
        interactionStatistic = vf.createIRI("http://schema.org/interactionStatistic");
        interactionType = vf.createIRI("http://schema.org/interactionType");
        interactivityType = vf.createIRI("http://schema.org/interactivityType");
        interestRate = vf.createIRI("http://schema.org/interestRate");
        InternetCafe = vf.createIRI("http://schema.org/InternetCafe");
        inventoryLevel = vf.createIRI("http://schema.org/inventoryLevel");
        inverseOf = vf.createIRI("http://schema.org/inverseOf");
        InvestmentFund = vf.createIRI("http://schema.org/InvestmentFund");
        InvestmentOrDeposit = vf.createIRI("http://schema.org/InvestmentOrDeposit");
        InviteAction = vf.createIRI("http://schema.org/InviteAction");
        Invoice = vf.createIRI("http://schema.org/Invoice");
        isAcceptingNewPatients = vf.createIRI("http://schema.org/isAcceptingNewPatients");
        isAccessibleForFree = vf.createIRI("http://schema.org/isAccessibleForFree");
        isAccessoryOrSparePartFor = vf.createIRI("http://schema.org/isAccessoryOrSparePartFor");
        isAvailableGenerically = vf.createIRI("http://schema.org/isAvailableGenerically");
        isBasedOn = vf.createIRI("http://schema.org/isBasedOn");
        isBasedOnUrl = vf.createIRI("http://schema.org/isBasedOnUrl");
        isbn = vf.createIRI("http://schema.org/isbn");
        isConsumableFor = vf.createIRI("http://schema.org/isConsumableFor");
        isFamilyFriendly = vf.createIRI("http://schema.org/isFamilyFriendly");
        isGift = vf.createIRI("http://schema.org/isGift");
        isicV4 = vf.createIRI("http://schema.org/isicV4");
        isLiveBroadcast = vf.createIRI("http://schema.org/isLiveBroadcast");
        isPartOf = vf.createIRI("http://schema.org/isPartOf");
        isProprietary = vf.createIRI("http://schema.org/isProprietary");
        isrcCode = vf.createIRI("http://schema.org/isrcCode");
        isRelatedTo = vf.createIRI("http://schema.org/isRelatedTo");
        isSimilarTo = vf.createIRI("http://schema.org/isSimilarTo");
        issn = vf.createIRI("http://schema.org/issn");
        issuedBy = vf.createIRI("http://schema.org/issuedBy");
        issuedThrough = vf.createIRI("http://schema.org/issuedThrough");
        issueNumber = vf.createIRI("http://schema.org/issueNumber");
        isVariantOf = vf.createIRI("http://schema.org/isVariantOf");
        iswcCode = vf.createIRI("http://schema.org/iswcCode");
        item = vf.createIRI("http://schema.org/item");
        ItemAvailability = vf.createIRI("http://schema.org/ItemAvailability");
        itemCondition = vf.createIRI("http://schema.org/itemCondition");
        ItemList = vf.createIRI("http://schema.org/ItemList");
        itemListElement = vf.createIRI("http://schema.org/itemListElement");
        itemListOrder = vf.createIRI("http://schema.org/itemListOrder");
        ItemListOrderType = vf.createIRI("http://schema.org/ItemListOrderType");
        itemOffered = vf.createIRI("http://schema.org/itemOffered");
        ItemPage = vf.createIRI("http://schema.org/ItemPage");
        itemReviewed = vf.createIRI("http://schema.org/itemReviewed");
        itemShipped = vf.createIRI("http://schema.org/itemShipped");
        itinerary = vf.createIRI("http://schema.org/itinerary");
        JewelryStore = vf.createIRI("http://schema.org/JewelryStore");
        jobBenefits = vf.createIRI("http://schema.org/jobBenefits");
        jobLocation = vf.createIRI("http://schema.org/jobLocation");
        JobPosting = vf.createIRI("http://schema.org/JobPosting");
        jobTitle = vf.createIRI("http://schema.org/jobTitle");
        JoinAction = vf.createIRI("http://schema.org/JoinAction");
        Joint = vf.createIRI("http://schema.org/Joint");
        keywords = vf.createIRI("http://schema.org/keywords");
        knownVehicleDamages = vf.createIRI("http://schema.org/knownVehicleDamages");
        knows = vf.createIRI("http://schema.org/knows");
        knowsAbout = vf.createIRI("http://schema.org/knowsAbout");
        knowsLanguage = vf.createIRI("http://schema.org/knowsLanguage");
        labelDetails = vf.createIRI("http://schema.org/labelDetails");
        LakeBodyOfWater = vf.createIRI("http://schema.org/LakeBodyOfWater");
        Landform = vf.createIRI("http://schema.org/Landform");
        landlord = vf.createIRI("http://schema.org/landlord");
        LandmarksOrHistoricalBuildings = vf.createIRI("http://schema.org/LandmarksOrHistoricalBuildings");
        Language = vf.createIRI("http://schema.org/Language");
        language = vf.createIRI("http://schema.org/language");
        lastReviewed = vf.createIRI("http://schema.org/lastReviewed");
        latitude = vf.createIRI("http://schema.org/latitude");
        learningResourceType = vf.createIRI("http://schema.org/learningResourceType");
        LeaveAction = vf.createIRI("http://schema.org/LeaveAction");
        LegalForceStatus = vf.createIRI("http://schema.org/LegalForceStatus");
        legalName = vf.createIRI("http://schema.org/legalName");
        LegalService = vf.createIRI("http://schema.org/LegalService");
        legalStatus = vf.createIRI("http://schema.org/legalStatus");
        LegalValueLevel = vf.createIRI("http://schema.org/LegalValueLevel");
        Legislation = vf.createIRI("http://schema.org/Legislation");
        legislationApplies = vf.createIRI("http://schema.org/legislationApplies");
        legislationChanges = vf.createIRI("http://schema.org/legislationChanges");
        legislationConsolidates = vf.createIRI("http://schema.org/legislationConsolidates");
        legislationDate = vf.createIRI("http://schema.org/legislationDate");
        legislationDateVersion = vf.createIRI("http://schema.org/legislationDateVersion");
        legislationIdentifier = vf.createIRI("http://schema.org/legislationIdentifier");
        legislationJurisdiction = vf.createIRI("http://schema.org/legislationJurisdiction");
        legislationLegalForce = vf.createIRI("http://schema.org/legislationLegalForce");
        legislationLegalValue = vf.createIRI("http://schema.org/legislationLegalValue");
        LegislationObject = vf.createIRI("http://schema.org/LegislationObject");
        legislationPassedBy = vf.createIRI("http://schema.org/legislationPassedBy");
        legislationResponsible = vf.createIRI("http://schema.org/legislationResponsible");
        legislationTransposes = vf.createIRI("http://schema.org/legislationTransposes");
        legislationType = vf.createIRI("http://schema.org/legislationType");
        LegislativeBuilding = vf.createIRI("http://schema.org/LegislativeBuilding");
        leiCode = vf.createIRI("http://schema.org/leiCode");
        LendAction = vf.createIRI("http://schema.org/LendAction");
        lender = vf.createIRI("http://schema.org/lender");
        lesser = vf.createIRI("http://schema.org/lesser");
        lesserOrEqual = vf.createIRI("http://schema.org/lesserOrEqual");
        letterer = vf.createIRI("http://schema.org/letterer");
        Library = vf.createIRI("http://schema.org/Library");
        LibrarySystem = vf.createIRI("http://schema.org/LibrarySystem");
        license = vf.createIRI("http://schema.org/license");
        LifestyleModification = vf.createIRI("http://schema.org/LifestyleModification");
        Ligament = vf.createIRI("http://schema.org/Ligament");
        LikeAction = vf.createIRI("http://schema.org/LikeAction");
        line = vf.createIRI("http://schema.org/line");
        linkRelationship = vf.createIRI("http://schema.org/linkRelationship");
        LinkRole = vf.createIRI("http://schema.org/LinkRole");
        LiquorStore = vf.createIRI("http://schema.org/LiquorStore");
        ListenAction = vf.createIRI("http://schema.org/ListenAction");
        ListItem = vf.createIRI("http://schema.org/ListItem");
        LiteraryEvent = vf.createIRI("http://schema.org/LiteraryEvent");
        LiveBlogPosting = vf.createIRI("http://schema.org/LiveBlogPosting");
        liveBlogUpdate = vf.createIRI("http://schema.org/liveBlogUpdate");
        loanMortgageMandateAmount = vf.createIRI("http://schema.org/loanMortgageMandateAmount");
        LoanOrCredit = vf.createIRI("http://schema.org/LoanOrCredit");
        loanPaymentAmount = vf.createIRI("http://schema.org/loanPaymentAmount");
        loanPaymentFrequency = vf.createIRI("http://schema.org/loanPaymentFrequency");
        loanRepaymentForm = vf.createIRI("http://schema.org/loanRepaymentForm");
        loanTerm = vf.createIRI("http://schema.org/loanTerm");
        loanType = vf.createIRI("http://schema.org/loanType");
        LocalBusiness = vf.createIRI("http://schema.org/LocalBusiness");
        location = vf.createIRI("http://schema.org/location");
        locationCreated = vf.createIRI("http://schema.org/locationCreated");
        LocationFeatureSpecification = vf.createIRI("http://schema.org/LocationFeatureSpecification");
        LockerDelivery = vf.createIRI("http://schema.org/LockerDelivery");
        Locksmith = vf.createIRI("http://schema.org/Locksmith");
        LodgingBusiness = vf.createIRI("http://schema.org/LodgingBusiness");
        LodgingReservation = vf.createIRI("http://schema.org/LodgingReservation");
        lodgingUnitDescription = vf.createIRI("http://schema.org/lodgingUnitDescription");
        lodgingUnitType = vf.createIRI("http://schema.org/lodgingUnitType");
        logo = vf.createIRI("http://schema.org/logo");
        longitude = vf.createIRI("http://schema.org/longitude");
        LoseAction = vf.createIRI("http://schema.org/LoseAction");
        loser = vf.createIRI("http://schema.org/loser");
        lowPrice = vf.createIRI("http://schema.org/lowPrice");
        LymphaticVessel = vf.createIRI("http://schema.org/LymphaticVessel");
        lyricist = vf.createIRI("http://schema.org/lyricist");
        lyrics = vf.createIRI("http://schema.org/lyrics");
        mainContentOfPage = vf.createIRI("http://schema.org/mainContentOfPage");
        mainEntity = vf.createIRI("http://schema.org/mainEntity");
        mainEntityOfPage = vf.createIRI("http://schema.org/mainEntityOfPage");
        makesOffer = vf.createIRI("http://schema.org/makesOffer");
        manufacturer = vf.createIRI("http://schema.org/manufacturer");
        map = vf.createIRI("http://schema.org/map");
        Map = vf.createIRI("http://schema.org/Map");
        MapCategoryType = vf.createIRI("http://schema.org/MapCategoryType");
        maps = vf.createIRI("http://schema.org/maps");
        mapType = vf.createIRI("http://schema.org/mapType");
        MarryAction = vf.createIRI("http://schema.org/MarryAction");
        Mass = vf.createIRI("http://schema.org/Mass");
        masthead = vf.createIRI("http://schema.org/masthead");
        material = vf.createIRI("http://schema.org/material");
        maximumAttendeeCapacity = vf.createIRI("http://schema.org/maximumAttendeeCapacity");
        MaximumDoseSchedule = vf.createIRI("http://schema.org/MaximumDoseSchedule");
        maximumIntake = vf.createIRI("http://schema.org/maximumIntake");
        maxPrice = vf.createIRI("http://schema.org/maxPrice");
        maxValue = vf.createIRI("http://schema.org/maxValue");
        mealService = vf.createIRI("http://schema.org/mealService");
        measurementTechnique = vf.createIRI("http://schema.org/measurementTechnique");
        mechanismOfAction = vf.createIRI("http://schema.org/mechanismOfAction");
        median = vf.createIRI("http://schema.org/median");
        MediaObject = vf.createIRI("http://schema.org/MediaObject");
        MediaSubscription = vf.createIRI("http://schema.org/MediaSubscription");
        MedicalAudience = vf.createIRI("http://schema.org/MedicalAudience");
        MedicalBusiness = vf.createIRI("http://schema.org/MedicalBusiness");
        MedicalCause = vf.createIRI("http://schema.org/MedicalCause");
        MedicalClinic = vf.createIRI("http://schema.org/MedicalClinic");
        MedicalCode = vf.createIRI("http://schema.org/MedicalCode");
        MedicalCondition = vf.createIRI("http://schema.org/MedicalCondition");
        MedicalConditionStage = vf.createIRI("http://schema.org/MedicalConditionStage");
        MedicalContraindication = vf.createIRI("http://schema.org/MedicalContraindication");
        MedicalDevice = vf.createIRI("http://schema.org/MedicalDevice");
        MedicalDevicePurpose = vf.createIRI("http://schema.org/MedicalDevicePurpose");
        MedicalEntity = vf.createIRI("http://schema.org/MedicalEntity");
        MedicalEnumeration = vf.createIRI("http://schema.org/MedicalEnumeration");
        MedicalEvidenceLevel = vf.createIRI("http://schema.org/MedicalEvidenceLevel");
        MedicalGuideline = vf.createIRI("http://schema.org/MedicalGuideline");
        MedicalGuidelineContraindication = vf.createIRI("http://schema.org/MedicalGuidelineContraindication");
        MedicalGuidelineRecommendation = vf.createIRI("http://schema.org/MedicalGuidelineRecommendation");
        MedicalImagingTechnique = vf.createIRI("http://schema.org/MedicalImagingTechnique");
        MedicalIndication = vf.createIRI("http://schema.org/MedicalIndication");
        MedicalIntangible = vf.createIRI("http://schema.org/MedicalIntangible");
        MedicalObservationalStudy = vf.createIRI("http://schema.org/MedicalObservationalStudy");
        MedicalObservationalStudyDesign = vf.createIRI("http://schema.org/MedicalObservationalStudyDesign");
        MedicalOrganization = vf.createIRI("http://schema.org/MedicalOrganization");
        MedicalProcedure = vf.createIRI("http://schema.org/MedicalProcedure");
        MedicalProcedureType = vf.createIRI("http://schema.org/MedicalProcedureType");
        MedicalRiskCalculator = vf.createIRI("http://schema.org/MedicalRiskCalculator");
        MedicalRiskEstimator = vf.createIRI("http://schema.org/MedicalRiskEstimator");
        MedicalRiskFactor = vf.createIRI("http://schema.org/MedicalRiskFactor");
        MedicalRiskScore = vf.createIRI("http://schema.org/MedicalRiskScore");
        MedicalScholarlyArticle = vf.createIRI("http://schema.org/MedicalScholarlyArticle");
        MedicalSign = vf.createIRI("http://schema.org/MedicalSign");
        MedicalSignOrSymptom = vf.createIRI("http://schema.org/MedicalSignOrSymptom");
        MedicalSpecialty = vf.createIRI("http://schema.org/MedicalSpecialty");
        medicalSpecialty = vf.createIRI("http://schema.org/medicalSpecialty");
        MedicalStudy = vf.createIRI("http://schema.org/MedicalStudy");
        MedicalStudyStatus = vf.createIRI("http://schema.org/MedicalStudyStatus");
        MedicalSymptom = vf.createIRI("http://schema.org/MedicalSymptom");
        MedicalTest = vf.createIRI("http://schema.org/MedicalTest");
        MedicalTestPanel = vf.createIRI("http://schema.org/MedicalTestPanel");
        MedicalTherapy = vf.createIRI("http://schema.org/MedicalTherapy");
        MedicalTrial = vf.createIRI("http://schema.org/MedicalTrial");
        MedicalTrialDesign = vf.createIRI("http://schema.org/MedicalTrialDesign");
        MedicalWebPage = vf.createIRI("http://schema.org/MedicalWebPage");
        MedicineSystem = vf.createIRI("http://schema.org/MedicineSystem");
        medicineSystem = vf.createIRI("http://schema.org/medicineSystem");
        MeetingRoom = vf.createIRI("http://schema.org/MeetingRoom");
        meetsEmissionStandard = vf.createIRI("http://schema.org/meetsEmissionStandard");
        member = vf.createIRI("http://schema.org/member");
        memberOf = vf.createIRI("http://schema.org/memberOf");
        members = vf.createIRI("http://schema.org/members");
        membershipNumber = vf.createIRI("http://schema.org/membershipNumber");
        memoryRequirements = vf.createIRI("http://schema.org/memoryRequirements");
        MensClothingStore = vf.createIRI("http://schema.org/MensClothingStore");
        mentions = vf.createIRI("http://schema.org/mentions");
        menu = vf.createIRI("http://schema.org/menu");
        Menu = vf.createIRI("http://schema.org/Menu");
        menuAddOn = vf.createIRI("http://schema.org/menuAddOn");
        MenuItem = vf.createIRI("http://schema.org/MenuItem");
        MenuSection = vf.createIRI("http://schema.org/MenuSection");
        merchant = vf.createIRI("http://schema.org/merchant");
        Message = vf.createIRI("http://schema.org/Message");
        messageAttachment = vf.createIRI("http://schema.org/messageAttachment");
        MiddleSchool = vf.createIRI("http://schema.org/MiddleSchool");
        mileageFromOdometer = vf.createIRI("http://schema.org/mileageFromOdometer");
        minimumPaymentDue = vf.createIRI("http://schema.org/minimumPaymentDue");
        minPrice = vf.createIRI("http://schema.org/minPrice");
        minValue = vf.createIRI("http://schema.org/minValue");
        missionCoveragePrioritiesPolicy = vf.createIRI("http://schema.org/missionCoveragePrioritiesPolicy");
        MobileApplication = vf.createIRI("http://schema.org/MobileApplication");
        MobilePhoneStore = vf.createIRI("http://schema.org/MobilePhoneStore");
        model = vf.createIRI("http://schema.org/model");
        modelDate = vf.createIRI("http://schema.org/modelDate");
        modifiedTime = vf.createIRI("http://schema.org/modifiedTime");
        MonetaryAmount = vf.createIRI("http://schema.org/MonetaryAmount");
        MonetaryAmountDistribution = vf.createIRI("http://schema.org/MonetaryAmountDistribution");
        MoneyTransfer = vf.createIRI("http://schema.org/MoneyTransfer");
        monthlyMinimumRepaymentAmount = vf.createIRI("http://schema.org/monthlyMinimumRepaymentAmount");
        MortgageLoan = vf.createIRI("http://schema.org/MortgageLoan");
        Mosque = vf.createIRI("http://schema.org/Mosque");
        Motel = vf.createIRI("http://schema.org/Motel");
        Motorcycle = vf.createIRI("http://schema.org/Motorcycle");
        MotorcycleDealer = vf.createIRI("http://schema.org/MotorcycleDealer");
        MotorcycleRepair = vf.createIRI("http://schema.org/MotorcycleRepair");
        MotorizedBicycle = vf.createIRI("http://schema.org/MotorizedBicycle");
        Mountain = vf.createIRI("http://schema.org/Mountain");
        MoveAction = vf.createIRI("http://schema.org/MoveAction");
        Movie = vf.createIRI("http://schema.org/Movie");
        MovieClip = vf.createIRI("http://schema.org/MovieClip");
        MovieRentalStore = vf.createIRI("http://schema.org/MovieRentalStore");
        MovieSeries = vf.createIRI("http://schema.org/MovieSeries");
        MovieTheater = vf.createIRI("http://schema.org/MovieTheater");
        MovingCompany = vf.createIRI("http://schema.org/MovingCompany");
        mpn = vf.createIRI("http://schema.org/mpn");
        multipleValues = vf.createIRI("http://schema.org/multipleValues");
        Muscle = vf.createIRI("http://schema.org/Muscle");
        muscleAction = vf.createIRI("http://schema.org/muscleAction");
        Museum = vf.createIRI("http://schema.org/Museum");
        MusicAlbum = vf.createIRI("http://schema.org/MusicAlbum");
        MusicAlbumProductionType = vf.createIRI("http://schema.org/MusicAlbumProductionType");
        MusicAlbumReleaseType = vf.createIRI("http://schema.org/MusicAlbumReleaseType");
        musicalKey = vf.createIRI("http://schema.org/musicalKey");
        musicArrangement = vf.createIRI("http://schema.org/musicArrangement");
        musicBy = vf.createIRI("http://schema.org/musicBy");
        MusicComposition = vf.createIRI("http://schema.org/MusicComposition");
        musicCompositionForm = vf.createIRI("http://schema.org/musicCompositionForm");
        MusicEvent = vf.createIRI("http://schema.org/MusicEvent");
        MusicGroup = vf.createIRI("http://schema.org/MusicGroup");
        musicGroupMember = vf.createIRI("http://schema.org/musicGroupMember");
        MusicPlaylist = vf.createIRI("http://schema.org/MusicPlaylist");
        MusicRecording = vf.createIRI("http://schema.org/MusicRecording");
        MusicRelease = vf.createIRI("http://schema.org/MusicRelease");
        musicReleaseFormat = vf.createIRI("http://schema.org/musicReleaseFormat");
        MusicReleaseFormatType = vf.createIRI("http://schema.org/MusicReleaseFormatType");
        MusicStore = vf.createIRI("http://schema.org/MusicStore");
        MusicVenue = vf.createIRI("http://schema.org/MusicVenue");
        MusicVideoObject = vf.createIRI("http://schema.org/MusicVideoObject");
        naics = vf.createIRI("http://schema.org/naics");
        NailSalon = vf.createIRI("http://schema.org/NailSalon");
        name = vf.createIRI("http://schema.org/name");
        namedPosition = vf.createIRI("http://schema.org/namedPosition");
        nationality = vf.createIRI("http://schema.org/nationality");
        naturalProgression = vf.createIRI("http://schema.org/naturalProgression");
        Nerve = vf.createIRI("http://schema.org/Nerve");
        nerve = vf.createIRI("http://schema.org/nerve");
        nerveMotor = vf.createIRI("http://schema.org/nerveMotor");
        netWorth = vf.createIRI("http://schema.org/netWorth");
        NewsArticle = vf.createIRI("http://schema.org/NewsArticle");
        NewsMediaOrganization = vf.createIRI("http://schema.org/NewsMediaOrganization");
        Newspaper = vf.createIRI("http://schema.org/Newspaper");
        nextItem = vf.createIRI("http://schema.org/nextItem");
        NGO = vf.createIRI("http://schema.org/NGO");
        NightClub = vf.createIRI("http://schema.org/NightClub");
        noBylinesPolicy = vf.createIRI("http://schema.org/noBylinesPolicy");
        nonEqual = vf.createIRI("http://schema.org/nonEqual");
        nonProprietaryName = vf.createIRI("http://schema.org/nonProprietaryName");
        normalRange = vf.createIRI("http://schema.org/normalRange");
        Notary = vf.createIRI("http://schema.org/Notary");
        NoteDigitalDocument = vf.createIRI("http://schema.org/NoteDigitalDocument");
        numAdults = vf.createIRI("http://schema.org/numAdults");
        Number = vf.createIRI("http://schema.org/Number");
        numberedPosition = vf.createIRI("http://schema.org/numberedPosition");
        numberOfAirbags = vf.createIRI("http://schema.org/numberOfAirbags");
        numberOfAxles = vf.createIRI("http://schema.org/numberOfAxles");
        numberOfBeds = vf.createIRI("http://schema.org/numberOfBeds");
        numberOfDoors = vf.createIRI("http://schema.org/numberOfDoors");
        numberOfEmployees = vf.createIRI("http://schema.org/numberOfEmployees");
        numberOfEpisodes = vf.createIRI("http://schema.org/numberOfEpisodes");
        numberOfForwardGears = vf.createIRI("http://schema.org/numberOfForwardGears");
        numberOfItems = vf.createIRI("http://schema.org/numberOfItems");
        numberOfLoanPayments = vf.createIRI("http://schema.org/numberOfLoanPayments");
        numberOfPages = vf.createIRI("http://schema.org/numberOfPages");
        numberOfPlayers = vf.createIRI("http://schema.org/numberOfPlayers");
        numberOfPreviousOwners = vf.createIRI("http://schema.org/numberOfPreviousOwners");
        numberOfRooms = vf.createIRI("http://schema.org/numberOfRooms");
        numberOfSeasons = vf.createIRI("http://schema.org/numberOfSeasons");
        numChildren = vf.createIRI("http://schema.org/numChildren");
        numTracks = vf.createIRI("http://schema.org/numTracks");
        nutrition = vf.createIRI("http://schema.org/nutrition");
        NutritionInformation = vf.createIRI("http://schema.org/NutritionInformation");
        object = vf.createIRI("http://schema.org/object");
        occupancy = vf.createIRI("http://schema.org/occupancy");
        Occupation = vf.createIRI("http://schema.org/Occupation");
        occupationalCategory = vf.createIRI("http://schema.org/occupationalCategory");
        OccupationalTherapy = vf.createIRI("http://schema.org/OccupationalTherapy");
        occupationLocation = vf.createIRI("http://schema.org/occupationLocation");
        OceanBodyOfWater = vf.createIRI("http://schema.org/OceanBodyOfWater");
        Offer = vf.createIRI("http://schema.org/Offer");
        OfferCatalog = vf.createIRI("http://schema.org/OfferCatalog");
        offerCount = vf.createIRI("http://schema.org/offerCount");
        offeredBy = vf.createIRI("http://schema.org/offeredBy");
        OfferItemCondition = vf.createIRI("http://schema.org/OfferItemCondition");
        offers = vf.createIRI("http://schema.org/offers");
        offersPrescriptionByMail = vf.createIRI("http://schema.org/offersPrescriptionByMail");
        OfficeEquipmentStore = vf.createIRI("http://schema.org/OfficeEquipmentStore");
        OnDemandEvent = vf.createIRI("http://schema.org/OnDemandEvent");
        openingHours = vf.createIRI("http://schema.org/openingHours");
        OpeningHoursSpecification = vf.createIRI("http://schema.org/OpeningHoursSpecification");
        openingHoursSpecification = vf.createIRI("http://schema.org/openingHoursSpecification");
        opens = vf.createIRI("http://schema.org/opens");
        operatingSystem = vf.createIRI("http://schema.org/operatingSystem");
        OpinionNewsArticle = vf.createIRI("http://schema.org/OpinionNewsArticle");
        opponent = vf.createIRI("http://schema.org/opponent");
        Optician = vf.createIRI("http://schema.org/Optician");
        option = vf.createIRI("http://schema.org/option");
        Order = vf.createIRI("http://schema.org/Order");
        OrderAction = vf.createIRI("http://schema.org/OrderAction");
        orderDate = vf.createIRI("http://schema.org/orderDate");
        orderDelivery = vf.createIRI("http://schema.org/orderDelivery");
        orderedItem = vf.createIRI("http://schema.org/orderedItem");
        OrderItem = vf.createIRI("http://schema.org/OrderItem");
        orderItemNumber = vf.createIRI("http://schema.org/orderItemNumber");
        orderItemStatus = vf.createIRI("http://schema.org/orderItemStatus");
        orderNumber = vf.createIRI("http://schema.org/orderNumber");
        orderQuantity = vf.createIRI("http://schema.org/orderQuantity");
        orderStatus = vf.createIRI("http://schema.org/orderStatus");
        OrderStatus = vf.createIRI("http://schema.org/OrderStatus");
        Organization = vf.createIRI("http://schema.org/Organization");
        OrganizationRole = vf.createIRI("http://schema.org/OrganizationRole");
        OrganizeAction = vf.createIRI("http://schema.org/OrganizeAction");
        organizer = vf.createIRI("http://schema.org/organizer");
        origin = vf.createIRI("http://schema.org/origin");
        originAddress = vf.createIRI("http://schema.org/originAddress");
        originatesFrom = vf.createIRI("http://schema.org/originatesFrom");
        outcome = vf.createIRI("http://schema.org/outcome");
        OutletStore = vf.createIRI("http://schema.org/OutletStore");
        overdosage = vf.createIRI("http://schema.org/overdosage");
        overview = vf.createIRI("http://schema.org/overview");
        ownedFrom = vf.createIRI("http://schema.org/ownedFrom");
        ownedThrough = vf.createIRI("http://schema.org/ownedThrough");
        ownershipFundingInfo = vf.createIRI("http://schema.org/ownershipFundingInfo");
        OwnershipInfo = vf.createIRI("http://schema.org/OwnershipInfo");
        owns = vf.createIRI("http://schema.org/owns");
        pageEnd = vf.createIRI("http://schema.org/pageEnd");
        pageStart = vf.createIRI("http://schema.org/pageStart");
        pagination = vf.createIRI("http://schema.org/pagination");
        PaintAction = vf.createIRI("http://schema.org/PaintAction");
        Painting = vf.createIRI("http://schema.org/Painting");
        PalliativeProcedure = vf.createIRI("http://schema.org/PalliativeProcedure");
        ParcelDelivery = vf.createIRI("http://schema.org/ParcelDelivery");
        ParcelService = vf.createIRI("http://schema.org/ParcelService");
        parent = vf.createIRI("http://schema.org/parent");
        ParentAudience = vf.createIRI("http://schema.org/ParentAudience");
        parentItem = vf.createIRI("http://schema.org/parentItem");
        parentOrganization = vf.createIRI("http://schema.org/parentOrganization");
        parents = vf.createIRI("http://schema.org/parents");
        parentService = vf.createIRI("http://schema.org/parentService");
        Park = vf.createIRI("http://schema.org/Park");
        ParkingFacility = vf.createIRI("http://schema.org/ParkingFacility");
        participant = vf.createIRI("http://schema.org/participant");
        partOfEpisode = vf.createIRI("http://schema.org/partOfEpisode");
        partOfInvoice = vf.createIRI("http://schema.org/partOfInvoice");
        partOfOrder = vf.createIRI("http://schema.org/partOfOrder");
        partOfSeason = vf.createIRI("http://schema.org/partOfSeason");
        partOfSeries = vf.createIRI("http://schema.org/partOfSeries");
        partOfSystem = vf.createIRI("http://schema.org/partOfSystem");
        partOfTVSeries = vf.createIRI("http://schema.org/partOfTVSeries");
        partySize = vf.createIRI("http://schema.org/partySize");
        passengerPriorityStatus = vf.createIRI("http://schema.org/passengerPriorityStatus");
        passengerSequenceNumber = vf.createIRI("http://schema.org/passengerSequenceNumber");
        PathologyTest = vf.createIRI("http://schema.org/PathologyTest");
        pathophysiology = vf.createIRI("http://schema.org/pathophysiology");
        Patient = vf.createIRI("http://schema.org/Patient");
        PawnShop = vf.createIRI("http://schema.org/PawnShop");
        PayAction = vf.createIRI("http://schema.org/PayAction");
        payload = vf.createIRI("http://schema.org/payload");
        paymentAccepted = vf.createIRI("http://schema.org/paymentAccepted");
        PaymentCard = vf.createIRI("http://schema.org/PaymentCard");
        PaymentChargeSpecification = vf.createIRI("http://schema.org/PaymentChargeSpecification");
        paymentDue = vf.createIRI("http://schema.org/paymentDue");
        paymentDueDate = vf.createIRI("http://schema.org/paymentDueDate");
        paymentMethod = vf.createIRI("http://schema.org/paymentMethod");
        PaymentMethod = vf.createIRI("http://schema.org/PaymentMethod");
        paymentMethodId = vf.createIRI("http://schema.org/paymentMethodId");
        PaymentService = vf.createIRI("http://schema.org/PaymentService");
        paymentStatus = vf.createIRI("http://schema.org/paymentStatus");
        PaymentStatusType = vf.createIRI("http://schema.org/PaymentStatusType");
        paymentUrl = vf.createIRI("http://schema.org/paymentUrl");
        penciler = vf.createIRI("http://schema.org/penciler");
        PeopleAudience = vf.createIRI("http://schema.org/PeopleAudience");
        percentile10 = vf.createIRI("http://schema.org/percentile10");
        percentile25 = vf.createIRI("http://schema.org/percentile25");
        percentile75 = vf.createIRI("http://schema.org/percentile75");
        percentile90 = vf.createIRI("http://schema.org/percentile90");
        PerformAction = vf.createIRI("http://schema.org/PerformAction");
        PerformanceRole = vf.createIRI("http://schema.org/PerformanceRole");
        performer = vf.createIRI("http://schema.org/performer");
        performerIn = vf.createIRI("http://schema.org/performerIn");
        performers = vf.createIRI("http://schema.org/performers");
        PerformingArtsTheater = vf.createIRI("http://schema.org/PerformingArtsTheater");
        PerformingGroup = vf.createIRI("http://schema.org/PerformingGroup");
        performTime = vf.createIRI("http://schema.org/performTime");
        Periodical = vf.createIRI("http://schema.org/Periodical");
        permissions = vf.createIRI("http://schema.org/permissions");
        permissionType = vf.createIRI("http://schema.org/permissionType");
        Permit = vf.createIRI("http://schema.org/Permit");
        permitAudience = vf.createIRI("http://schema.org/permitAudience");
        permittedUsage = vf.createIRI("http://schema.org/permittedUsage");
        Person = vf.createIRI("http://schema.org/Person");
        petsAllowed = vf.createIRI("http://schema.org/petsAllowed");
        PetStore = vf.createIRI("http://schema.org/PetStore");
        Pharmacy = vf.createIRI("http://schema.org/Pharmacy");
        phase = vf.createIRI("http://schema.org/phase");
        photo = vf.createIRI("http://schema.org/photo");
        Photograph = vf.createIRI("http://schema.org/Photograph");
        PhotographAction = vf.createIRI("http://schema.org/PhotographAction");
        photos = vf.createIRI("http://schema.org/photos");
        PhysicalActivity = vf.createIRI("http://schema.org/PhysicalActivity");
        PhysicalActivityCategory = vf.createIRI("http://schema.org/PhysicalActivityCategory");
        PhysicalExam = vf.createIRI("http://schema.org/PhysicalExam");
        PhysicalTherapy = vf.createIRI("http://schema.org/PhysicalTherapy");
        Physician = vf.createIRI("http://schema.org/Physician");
        physiologicalBenefits = vf.createIRI("http://schema.org/physiologicalBenefits");
        pickupLocation = vf.createIRI("http://schema.org/pickupLocation");
        pickupTime = vf.createIRI("http://schema.org/pickupTime");
        Place = vf.createIRI("http://schema.org/Place");
        PlaceOfWorship = vf.createIRI("http://schema.org/PlaceOfWorship");
        PlanAction = vf.createIRI("http://schema.org/PlanAction");
        PlayAction = vf.createIRI("http://schema.org/PlayAction");
        playersOnline = vf.createIRI("http://schema.org/playersOnline");
        playerType = vf.createIRI("http://schema.org/playerType");
        Playground = vf.createIRI("http://schema.org/Playground");
        playMode = vf.createIRI("http://schema.org/playMode");
        Plumber = vf.createIRI("http://schema.org/Plumber");
        PoliceStation = vf.createIRI("http://schema.org/PoliceStation");
        polygon = vf.createIRI("http://schema.org/polygon");
        Pond = vf.createIRI("http://schema.org/Pond");
        population = vf.createIRI("http://schema.org/population");
        position = vf.createIRI("http://schema.org/position");
        possibleComplication = vf.createIRI("http://schema.org/possibleComplication");
        possibleTreatment = vf.createIRI("http://schema.org/possibleTreatment");
        PostalAddress = vf.createIRI("http://schema.org/PostalAddress");
        postalCode = vf.createIRI("http://schema.org/postalCode");
        PostOffice = vf.createIRI("http://schema.org/PostOffice");
        postOfficeBoxNumber = vf.createIRI("http://schema.org/postOfficeBoxNumber");
        postOp = vf.createIRI("http://schema.org/postOp");
        potentialAction = vf.createIRI("http://schema.org/potentialAction");
        predecessorOf = vf.createIRI("http://schema.org/predecessorOf");
        pregnancyCategory = vf.createIRI("http://schema.org/pregnancyCategory");
        pregnancyWarning = vf.createIRI("http://schema.org/pregnancyWarning");
        preOp = vf.createIRI("http://schema.org/preOp");
        PreOrderAction = vf.createIRI("http://schema.org/PreOrderAction");
        preparation = vf.createIRI("http://schema.org/preparation");
        PrependAction = vf.createIRI("http://schema.org/PrependAction");
        prepTime = vf.createIRI("http://schema.org/prepTime");
        Preschool = vf.createIRI("http://schema.org/Preschool");
        prescribingInfo = vf.createIRI("http://schema.org/prescribingInfo");
        prescriptionStatus = vf.createIRI("http://schema.org/prescriptionStatus");
        PresentationDigitalDocument = vf.createIRI("http://schema.org/PresentationDigitalDocument");
        PreventionIndication = vf.createIRI("http://schema.org/PreventionIndication");
        previousItem = vf.createIRI("http://schema.org/previousItem");
        previousStartDate = vf.createIRI("http://schema.org/previousStartDate");
        price = vf.createIRI("http://schema.org/price");
        priceComponent = vf.createIRI("http://schema.org/priceComponent");
        priceCurrency = vf.createIRI("http://schema.org/priceCurrency");
        priceRange = vf.createIRI("http://schema.org/priceRange");
        priceSpecification = vf.createIRI("http://schema.org/priceSpecification");
        PriceSpecification = vf.createIRI("http://schema.org/PriceSpecification");
        priceType = vf.createIRI("http://schema.org/priceType");
        priceValidUntil = vf.createIRI("http://schema.org/priceValidUntil");
        primaryImageOfPage = vf.createIRI("http://schema.org/primaryImageOfPage");
        primaryPrevention = vf.createIRI("http://schema.org/primaryPrevention");
        printColumn = vf.createIRI("http://schema.org/printColumn");
        printEdition = vf.createIRI("http://schema.org/printEdition");
        printPage = vf.createIRI("http://schema.org/printPage");
        printSection = vf.createIRI("http://schema.org/printSection");
        procedure = vf.createIRI("http://schema.org/procedure");
        procedureType = vf.createIRI("http://schema.org/procedureType");
        processingTime = vf.createIRI("http://schema.org/processingTime");
        processorRequirements = vf.createIRI("http://schema.org/processorRequirements");
        producer = vf.createIRI("http://schema.org/producer");
        produces = vf.createIRI("http://schema.org/produces");
        Product = vf.createIRI("http://schema.org/Product");
        productID = vf.createIRI("http://schema.org/productID");
        productionCompany = vf.createIRI("http://schema.org/productionCompany");
        productionDate = vf.createIRI("http://schema.org/productionDate");
        ProductModel = vf.createIRI("http://schema.org/ProductModel");
        productSupported = vf.createIRI("http://schema.org/productSupported");
        ProfessionalService = vf.createIRI("http://schema.org/ProfessionalService");
        proficiencyLevel = vf.createIRI("http://schema.org/proficiencyLevel");
        ProfilePage = vf.createIRI("http://schema.org/ProfilePage");
        ProgramMembership = vf.createIRI("http://schema.org/ProgramMembership");
        programMembershipUsed = vf.createIRI("http://schema.org/programMembershipUsed");
        programmingLanguage = vf.createIRI("http://schema.org/programmingLanguage");
        programmingModel = vf.createIRI("http://schema.org/programmingModel");
        programName = vf.createIRI("http://schema.org/programName");
        Property = vf.createIRI("http://schema.org/Property");
        propertyID = vf.createIRI("http://schema.org/propertyID");
        PropertyValue = vf.createIRI("http://schema.org/PropertyValue");
        PropertyValueSpecification = vf.createIRI("http://schema.org/PropertyValueSpecification");
        proprietaryName = vf.createIRI("http://schema.org/proprietaryName");
        proteinContent = vf.createIRI("http://schema.org/proteinContent");
        provider = vf.createIRI("http://schema.org/provider");
        providerMobility = vf.createIRI("http://schema.org/providerMobility");
        providesBroadcastService = vf.createIRI("http://schema.org/providesBroadcastService");
        providesService = vf.createIRI("http://schema.org/providesService");
        PsychologicalTreatment = vf.createIRI("http://schema.org/PsychologicalTreatment");
        publicAccess = vf.createIRI("http://schema.org/publicAccess");
        publication = vf.createIRI("http://schema.org/publication");
        PublicationEvent = vf.createIRI("http://schema.org/PublicationEvent");
        PublicationIssue = vf.createIRI("http://schema.org/PublicationIssue");
        publicationType = vf.createIRI("http://schema.org/publicationType");
        PublicationVolume = vf.createIRI("http://schema.org/PublicationVolume");
        PublicSwimmingPool = vf.createIRI("http://schema.org/PublicSwimmingPool");
        PublicToilet = vf.createIRI("http://schema.org/PublicToilet");
        publishedBy = vf.createIRI("http://schema.org/publishedBy");
        publishedOn = vf.createIRI("http://schema.org/publishedOn");
        publisher = vf.createIRI("http://schema.org/publisher");
        publisherImprint = vf.createIRI("http://schema.org/publisherImprint");
        publishingPrinciples = vf.createIRI("http://schema.org/publishingPrinciples");
        purchaseDate = vf.createIRI("http://schema.org/purchaseDate");
        purpose = vf.createIRI("http://schema.org/purpose");
        QAPage = vf.createIRI("http://schema.org/QAPage");
        qualifications = vf.createIRI("http://schema.org/qualifications");
        QualitativeValue = vf.createIRI("http://schema.org/QualitativeValue");
        QuantitativeValue = vf.createIRI("http://schema.org/QuantitativeValue");
        QuantitativeValueDistribution = vf.createIRI("http://schema.org/QuantitativeValueDistribution");
        Quantity = vf.createIRI("http://schema.org/Quantity");
        query = vf.createIRI("http://schema.org/query");
        quest = vf.createIRI("http://schema.org/quest");
        question = vf.createIRI("http://schema.org/question");
        Question = vf.createIRI("http://schema.org/Question");
        Quotation = vf.createIRI("http://schema.org/Quotation");
        QuoteAction = vf.createIRI("http://schema.org/QuoteAction");
        RadiationTherapy = vf.createIRI("http://schema.org/RadiationTherapy");
        RadioChannel = vf.createIRI("http://schema.org/RadioChannel");
        RadioClip = vf.createIRI("http://schema.org/RadioClip");
        RadioEpisode = vf.createIRI("http://schema.org/RadioEpisode");
        RadioSeason = vf.createIRI("http://schema.org/RadioSeason");
        RadioSeries = vf.createIRI("http://schema.org/RadioSeries");
        RadioStation = vf.createIRI("http://schema.org/RadioStation");
        rangeIncludes = vf.createIRI("http://schema.org/rangeIncludes");
        Rating = vf.createIRI("http://schema.org/Rating");
        ratingCount = vf.createIRI("http://schema.org/ratingCount");
        ratingValue = vf.createIRI("http://schema.org/ratingValue");
        ReactAction = vf.createIRI("http://schema.org/ReactAction");
        ReadAction = vf.createIRI("http://schema.org/ReadAction");
        readBy = vf.createIRI("http://schema.org/readBy");
        readonlyValue = vf.createIRI("http://schema.org/readonlyValue");
        realEstateAgent = vf.createIRI("http://schema.org/realEstateAgent");
        RealEstateAgent = vf.createIRI("http://schema.org/RealEstateAgent");
        ReceiveAction = vf.createIRI("http://schema.org/ReceiveAction");
        Recipe = vf.createIRI("http://schema.org/Recipe");
        recipe = vf.createIRI("http://schema.org/recipe");
        recipeCategory = vf.createIRI("http://schema.org/recipeCategory");
        recipeCuisine = vf.createIRI("http://schema.org/recipeCuisine");
        recipeIngredient = vf.createIRI("http://schema.org/recipeIngredient");
        recipeInstructions = vf.createIRI("http://schema.org/recipeInstructions");
        recipeYield = vf.createIRI("http://schema.org/recipeYield");
        recipient = vf.createIRI("http://schema.org/recipient");
        recognizingAuthority = vf.createIRI("http://schema.org/recognizingAuthority");
        recommendationStrength = vf.createIRI("http://schema.org/recommendationStrength");
        RecommendedDoseSchedule = vf.createIRI("http://schema.org/RecommendedDoseSchedule");
        recommendedIntake = vf.createIRI("http://schema.org/recommendedIntake");
        recordedAs = vf.createIRI("http://schema.org/recordedAs");
        recordedAt = vf.createIRI("http://schema.org/recordedAt");
        recordedIn = vf.createIRI("http://schema.org/recordedIn");
        recordingOf = vf.createIRI("http://schema.org/recordingOf");
        recordLabel = vf.createIRI("http://schema.org/recordLabel");
        recourseLoan = vf.createIRI("http://schema.org/recourseLoan");
        RecyclingCenter = vf.createIRI("http://schema.org/RecyclingCenter");
        referenceQuantity = vf.createIRI("http://schema.org/referenceQuantity");
        referencesOrder = vf.createIRI("http://schema.org/referencesOrder");
        regionDrained = vf.createIRI("http://schema.org/regionDrained");
        regionsAllowed = vf.createIRI("http://schema.org/regionsAllowed");
        RegisterAction = vf.createIRI("http://schema.org/RegisterAction");
        RejectAction = vf.createIRI("http://schema.org/RejectAction");
        relatedAnatomy = vf.createIRI("http://schema.org/relatedAnatomy");
        relatedCondition = vf.createIRI("http://schema.org/relatedCondition");
        relatedDrug = vf.createIRI("http://schema.org/relatedDrug");
        relatedLink = vf.createIRI("http://schema.org/relatedLink");
        relatedStructure = vf.createIRI("http://schema.org/relatedStructure");
        relatedTherapy = vf.createIRI("http://schema.org/relatedTherapy");
        relatedTo = vf.createIRI("http://schema.org/relatedTo");
        releaseDate = vf.createIRI("http://schema.org/releaseDate");
        releasedEvent = vf.createIRI("http://schema.org/releasedEvent");
        releaseNotes = vf.createIRI("http://schema.org/releaseNotes");
        releaseOf = vf.createIRI("http://schema.org/releaseOf");
        relevantOccupation = vf.createIRI("http://schema.org/relevantOccupation");
        relevantSpecialty = vf.createIRI("http://schema.org/relevantSpecialty");
        remainingAttendeeCapacity = vf.createIRI("http://schema.org/remainingAttendeeCapacity");
        renegotiableLoan = vf.createIRI("http://schema.org/renegotiableLoan");
        RentAction = vf.createIRI("http://schema.org/RentAction");
        RentalCarReservation = vf.createIRI("http://schema.org/RentalCarReservation");
        RepaymentSpecification = vf.createIRI("http://schema.org/RepaymentSpecification");
        repeatCount = vf.createIRI("http://schema.org/repeatCount");
        repeatFrequency = vf.createIRI("http://schema.org/repeatFrequency");
        repetitions = vf.createIRI("http://schema.org/repetitions");
        ReplaceAction = vf.createIRI("http://schema.org/ReplaceAction");
        replacee = vf.createIRI("http://schema.org/replacee");
        replacer = vf.createIRI("http://schema.org/replacer");
        ReplyAction = vf.createIRI("http://schema.org/ReplyAction");
        replyToUrl = vf.createIRI("http://schema.org/replyToUrl");
        Report = vf.createIRI("http://schema.org/Report");
        ReportageNewsArticle = vf.createIRI("http://schema.org/ReportageNewsArticle");
        ReportedDoseSchedule = vf.createIRI("http://schema.org/ReportedDoseSchedule");
        reportNumber = vf.createIRI("http://schema.org/reportNumber");
        representativeOfPage = vf.createIRI("http://schema.org/representativeOfPage");
        requiredCollateral = vf.createIRI("http://schema.org/requiredCollateral");
        requiredGender = vf.createIRI("http://schema.org/requiredGender");
        requiredMaxAge = vf.createIRI("http://schema.org/requiredMaxAge");
        requiredMinAge = vf.createIRI("http://schema.org/requiredMinAge");
        requiredQuantity = vf.createIRI("http://schema.org/requiredQuantity");
        requirements = vf.createIRI("http://schema.org/requirements");
        requiresSubscription = vf.createIRI("http://schema.org/requiresSubscription");
        Reservation = vf.createIRI("http://schema.org/Reservation");
        reservationFor = vf.createIRI("http://schema.org/reservationFor");
        reservationId = vf.createIRI("http://schema.org/reservationId");
        ReservationPackage = vf.createIRI("http://schema.org/ReservationPackage");
        reservationStatus = vf.createIRI("http://schema.org/reservationStatus");
        ReservationStatusType = vf.createIRI("http://schema.org/ReservationStatusType");
        ReserveAction = vf.createIRI("http://schema.org/ReserveAction");
        reservedTicket = vf.createIRI("http://schema.org/reservedTicket");
        Reservoir = vf.createIRI("http://schema.org/Reservoir");
        Residence = vf.createIRI("http://schema.org/Residence");
        Resort = vf.createIRI("http://schema.org/Resort");
        responsibilities = vf.createIRI("http://schema.org/responsibilities");
        Restaurant = vf.createIRI("http://schema.org/Restaurant");
        restPeriods = vf.createIRI("http://schema.org/restPeriods");
        RestrictedDiet = vf.createIRI("http://schema.org/RestrictedDiet");
        result = vf.createIRI("http://schema.org/result");
        resultComment = vf.createIRI("http://schema.org/resultComment");
        resultReview = vf.createIRI("http://schema.org/resultReview");
        ResumeAction = vf.createIRI("http://schema.org/ResumeAction");
        ReturnAction = vf.createIRI("http://schema.org/ReturnAction");
        Review = vf.createIRI("http://schema.org/Review");
        review = vf.createIRI("http://schema.org/review");
        ReviewAction = vf.createIRI("http://schema.org/ReviewAction");
        reviewAspect = vf.createIRI("http://schema.org/reviewAspect");
        reviewBody = vf.createIRI("http://schema.org/reviewBody");
        reviewCount = vf.createIRI("http://schema.org/reviewCount");
        reviewedBy = vf.createIRI("http://schema.org/reviewedBy");
        ReviewNewsArticle = vf.createIRI("http://schema.org/ReviewNewsArticle");
        reviewRating = vf.createIRI("http://schema.org/reviewRating");
        reviews = vf.createIRI("http://schema.org/reviews");
        riskFactor = vf.createIRI("http://schema.org/riskFactor");
        risks = vf.createIRI("http://schema.org/risks");
        RiverBodyOfWater = vf.createIRI("http://schema.org/RiverBodyOfWater");
        Role = vf.createIRI("http://schema.org/Role");
        roleName = vf.createIRI("http://schema.org/roleName");
        RoofingContractor = vf.createIRI("http://schema.org/RoofingContractor");
        roofLoad = vf.createIRI("http://schema.org/roofLoad");
        Room = vf.createIRI("http://schema.org/Room");
        RsvpAction = vf.createIRI("http://schema.org/RsvpAction");
        rsvpResponse = vf.createIRI("http://schema.org/rsvpResponse");
        RsvpResponseType = vf.createIRI("http://schema.org/RsvpResponseType");
        runsTo = vf.createIRI("http://schema.org/runsTo");
        runtime = vf.createIRI("http://schema.org/runtime");
        runtimePlatform = vf.createIRI("http://schema.org/runtimePlatform");
        RVPark = vf.createIRI("http://schema.org/RVPark");
        rxcui = vf.createIRI("http://schema.org/rxcui");
        safetyConsideration = vf.createIRI("http://schema.org/safetyConsideration");
        salaryCurrency = vf.createIRI("http://schema.org/salaryCurrency");
        SaleEvent = vf.createIRI("http://schema.org/SaleEvent");
        sameAs = vf.createIRI("http://schema.org/sameAs");
        sampleType = vf.createIRI("http://schema.org/sampleType");
        SatiricalArticle = vf.createIRI("http://schema.org/SatiricalArticle");
        saturatedFatContent = vf.createIRI("http://schema.org/saturatedFatContent");
        Schedule = vf.createIRI("http://schema.org/Schedule");
        ScheduleAction = vf.createIRI("http://schema.org/ScheduleAction");
        scheduledPaymentDate = vf.createIRI("http://schema.org/scheduledPaymentDate");
        scheduledTime = vf.createIRI("http://schema.org/scheduledTime");
        schemaVersion = vf.createIRI("http://schema.org/schemaVersion");
        ScholarlyArticle = vf.createIRI("http://schema.org/ScholarlyArticle");
        School = vf.createIRI("http://schema.org/School");
        screenCount = vf.createIRI("http://schema.org/screenCount");
        ScreeningEvent = vf.createIRI("http://schema.org/ScreeningEvent");
        screenshot = vf.createIRI("http://schema.org/screenshot");
        Sculpture = vf.createIRI("http://schema.org/Sculpture");
        sdDatePublished = vf.createIRI("http://schema.org/sdDatePublished");
        sdLicense = vf.createIRI("http://schema.org/sdLicense");
        sdPublisher = vf.createIRI("http://schema.org/sdPublisher");
        SeaBodyOfWater = vf.createIRI("http://schema.org/SeaBodyOfWater");
        SearchAction = vf.createIRI("http://schema.org/SearchAction");
        SearchResultsPage = vf.createIRI("http://schema.org/SearchResultsPage");
        season = vf.createIRI("http://schema.org/season");
        Season = vf.createIRI("http://schema.org/Season");
        seasonNumber = vf.createIRI("http://schema.org/seasonNumber");
        seasons = vf.createIRI("http://schema.org/seasons");
        Seat = vf.createIRI("http://schema.org/Seat");
        seatingCapacity = vf.createIRI("http://schema.org/seatingCapacity");
        seatingType = vf.createIRI("http://schema.org/seatingType");
        seatNumber = vf.createIRI("http://schema.org/seatNumber");
        seatRow = vf.createIRI("http://schema.org/seatRow");
        seatSection = vf.createIRI("http://schema.org/seatSection");
        secondaryPrevention = vf.createIRI("http://schema.org/secondaryPrevention");
        securityScreening = vf.createIRI("http://schema.org/securityScreening");
        seeks = vf.createIRI("http://schema.org/seeks");
        SelfStorage = vf.createIRI("http://schema.org/SelfStorage");
        SellAction = vf.createIRI("http://schema.org/SellAction");
        seller = vf.createIRI("http://schema.org/seller");
        SendAction = vf.createIRI("http://schema.org/SendAction");
        sender = vf.createIRI("http://schema.org/sender");
        sensoryUnit = vf.createIRI("http://schema.org/sensoryUnit");
        serialNumber = vf.createIRI("http://schema.org/serialNumber");
        Series = vf.createIRI("http://schema.org/Series");
        seriousAdverseOutcome = vf.createIRI("http://schema.org/seriousAdverseOutcome");
        serverStatus = vf.createIRI("http://schema.org/serverStatus");
        servesCuisine = vf.createIRI("http://schema.org/servesCuisine");
        Service = vf.createIRI("http://schema.org/Service");
        serviceArea = vf.createIRI("http://schema.org/serviceArea");
        serviceAudience = vf.createIRI("http://schema.org/serviceAudience");
        ServiceChannel = vf.createIRI("http://schema.org/ServiceChannel");
        serviceLocation = vf.createIRI("http://schema.org/serviceLocation");
        serviceOperator = vf.createIRI("http://schema.org/serviceOperator");
        serviceOutput = vf.createIRI("http://schema.org/serviceOutput");
        servicePhone = vf.createIRI("http://schema.org/servicePhone");
        servicePostalAddress = vf.createIRI("http://schema.org/servicePostalAddress");
        serviceSmsNumber = vf.createIRI("http://schema.org/serviceSmsNumber");
        serviceType = vf.createIRI("http://schema.org/serviceType");
        serviceUrl = vf.createIRI("http://schema.org/serviceUrl");
        servingSize = vf.createIRI("http://schema.org/servingSize");
        ShareAction = vf.createIRI("http://schema.org/ShareAction");
        sharedContent = vf.createIRI("http://schema.org/sharedContent");
        ShoeStore = vf.createIRI("http://schema.org/ShoeStore");
        ShoppingCenter = vf.createIRI("http://schema.org/ShoppingCenter");
        sibling = vf.createIRI("http://schema.org/sibling");
        siblings = vf.createIRI("http://schema.org/siblings");
        signDetected = vf.createIRI("http://schema.org/signDetected");
        significance = vf.createIRI("http://schema.org/significance");
        significantLink = vf.createIRI("http://schema.org/significantLink");
        significantLinks = vf.createIRI("http://schema.org/significantLinks");
        signOrSymptom = vf.createIRI("http://schema.org/signOrSymptom");
        SingleFamilyResidence = vf.createIRI("http://schema.org/SingleFamilyResidence");
        SiteNavigationElement = vf.createIRI("http://schema.org/SiteNavigationElement");
        skills = vf.createIRI("http://schema.org/skills");
        SkiResort = vf.createIRI("http://schema.org/SkiResort");
        sku = vf.createIRI("http://schema.org/sku");
        smokingAllowed = vf.createIRI("http://schema.org/smokingAllowed");
        SocialEvent = vf.createIRI("http://schema.org/SocialEvent");
        SocialMediaPosting = vf.createIRI("http://schema.org/SocialMediaPosting");
        sodiumContent = vf.createIRI("http://schema.org/sodiumContent");
        softwareAddOn = vf.createIRI("http://schema.org/softwareAddOn");
        SoftwareApplication = vf.createIRI("http://schema.org/SoftwareApplication");
        softwareHelp = vf.createIRI("http://schema.org/softwareHelp");
        softwareRequirements = vf.createIRI("http://schema.org/softwareRequirements");
        SoftwareSourceCode = vf.createIRI("http://schema.org/SoftwareSourceCode");
        softwareVersion = vf.createIRI("http://schema.org/softwareVersion");
        SomeProducts = vf.createIRI("http://schema.org/SomeProducts");
        source = vf.createIRI("http://schema.org/source");
        sourcedFrom = vf.createIRI("http://schema.org/sourcedFrom");
        sourceOrganization = vf.createIRI("http://schema.org/sourceOrganization");
        spatial = vf.createIRI("http://schema.org/spatial");
        spatialCoverage = vf.createIRI("http://schema.org/spatialCoverage");
        speakable = vf.createIRI("http://schema.org/speakable");
        SpeakableSpecification = vf.createIRI("http://schema.org/SpeakableSpecification");
        specialCommitments = vf.createIRI("http://schema.org/specialCommitments");
        specialOpeningHoursSpecification = vf.createIRI("http://schema.org/specialOpeningHoursSpecification");
        Specialty = vf.createIRI("http://schema.org/Specialty");
        specialty = vf.createIRI("http://schema.org/specialty");
        speed = vf.createIRI("http://schema.org/speed");
        spokenByCharacter = vf.createIRI("http://schema.org/spokenByCharacter");
        sponsor = vf.createIRI("http://schema.org/sponsor");
        sport = vf.createIRI("http://schema.org/sport");
        SportingGoodsStore = vf.createIRI("http://schema.org/SportingGoodsStore");
        sportsActivityLocation = vf.createIRI("http://schema.org/sportsActivityLocation");
        SportsActivityLocation = vf.createIRI("http://schema.org/SportsActivityLocation");
        SportsClub = vf.createIRI("http://schema.org/SportsClub");
        SportsEvent = vf.createIRI("http://schema.org/SportsEvent");
        sportsEvent = vf.createIRI("http://schema.org/sportsEvent");
        SportsOrganization = vf.createIRI("http://schema.org/SportsOrganization");
        SportsTeam = vf.createIRI("http://schema.org/SportsTeam");
        sportsTeam = vf.createIRI("http://schema.org/sportsTeam");
        spouse = vf.createIRI("http://schema.org/spouse");
        SpreadsheetDigitalDocument = vf.createIRI("http://schema.org/SpreadsheetDigitalDocument");
        StadiumOrArena = vf.createIRI("http://schema.org/StadiumOrArena");
        stage = vf.createIRI("http://schema.org/stage");
        stageAsNumber = vf.createIRI("http://schema.org/stageAsNumber");
        starRating = vf.createIRI("http://schema.org/starRating");
        startDate = vf.createIRI("http://schema.org/startDate");
        startTime = vf.createIRI("http://schema.org/startTime");
        State = vf.createIRI("http://schema.org/State");
        status = vf.createIRI("http://schema.org/status");
        steeringPosition = vf.createIRI("http://schema.org/steeringPosition");
        SteeringPositionValue = vf.createIRI("http://schema.org/SteeringPositionValue");
        step = vf.createIRI("http://schema.org/step");
        steps = vf.createIRI("http://schema.org/steps");
        stepValue = vf.createIRI("http://schema.org/stepValue");
        storageRequirements = vf.createIRI("http://schema.org/storageRequirements");
        Store = vf.createIRI("http://schema.org/Store");
        streetAddress = vf.createIRI("http://schema.org/streetAddress");
        strengthUnit = vf.createIRI("http://schema.org/strengthUnit");
        strengthValue = vf.createIRI("http://schema.org/strengthValue");
        structuralClass = vf.createIRI("http://schema.org/structuralClass");
        StructuredValue = vf.createIRI("http://schema.org/StructuredValue");
        study = vf.createIRI("http://schema.org/study");
        studyDesign = vf.createIRI("http://schema.org/studyDesign");
        studyLocation = vf.createIRI("http://schema.org/studyLocation");
        studySubject = vf.createIRI("http://schema.org/studySubject");
        subEvent = vf.createIRI("http://schema.org/subEvent");
        subEvents = vf.createIRI("http://schema.org/subEvents");
        subjectOf = vf.createIRI("http://schema.org/subjectOf");
        subOrganization = vf.createIRI("http://schema.org/subOrganization");
        subReservation = vf.createIRI("http://schema.org/subReservation");
        SubscribeAction = vf.createIRI("http://schema.org/SubscribeAction");
        subStageSuffix = vf.createIRI("http://schema.org/subStageSuffix");
        Substance = vf.createIRI("http://schema.org/Substance");
        subStructure = vf.createIRI("http://schema.org/subStructure");
        subTest = vf.createIRI("http://schema.org/subTest");
        subtitleLanguage = vf.createIRI("http://schema.org/subtitleLanguage");
        subtype = vf.createIRI("http://schema.org/subtype");
        SubwayStation = vf.createIRI("http://schema.org/SubwayStation");
        successorOf = vf.createIRI("http://schema.org/successorOf");
        sugarContent = vf.createIRI("http://schema.org/sugarContent");
        suggestedAnswer = vf.createIRI("http://schema.org/suggestedAnswer");
        suggestedGender = vf.createIRI("http://schema.org/suggestedGender");
        suggestedMaxAge = vf.createIRI("http://schema.org/suggestedMaxAge");
        suggestedMinAge = vf.createIRI("http://schema.org/suggestedMinAge");
        suitableForDiet = vf.createIRI("http://schema.org/suitableForDiet");
        Suite = vf.createIRI("http://schema.org/Suite");
        superEvent = vf.createIRI("http://schema.org/superEvent");
        SuperficialAnatomy = vf.createIRI("http://schema.org/SuperficialAnatomy");
        supersededBy = vf.createIRI("http://schema.org/supersededBy");
        supply = vf.createIRI("http://schema.org/supply");
        supplyTo = vf.createIRI("http://schema.org/supplyTo");
        supportingData = vf.createIRI("http://schema.org/supportingData");
        surface = vf.createIRI("http://schema.org/surface");
        SurgicalProcedure = vf.createIRI("http://schema.org/SurgicalProcedure");
        SuspendAction = vf.createIRI("http://schema.org/SuspendAction");
        Synagogue = vf.createIRI("http://schema.org/Synagogue");
        Table = vf.createIRI("http://schema.org/Table");
        TakeAction = vf.createIRI("http://schema.org/TakeAction");
        target = vf.createIRI("http://schema.org/target");
        targetCollection = vf.createIRI("http://schema.org/targetCollection");
        targetDescription = vf.createIRI("http://schema.org/targetDescription");
        targetName = vf.createIRI("http://schema.org/targetName");
        targetPlatform = vf.createIRI("http://schema.org/targetPlatform");
        targetPopulation = vf.createIRI("http://schema.org/targetPopulation");
        targetProduct = vf.createIRI("http://schema.org/targetProduct");
        targetUrl = vf.createIRI("http://schema.org/targetUrl");
        TattooParlor = vf.createIRI("http://schema.org/TattooParlor");
        Taxi = vf.createIRI("http://schema.org/Taxi");
        taxID = vf.createIRI("http://schema.org/taxID");
        TaxiReservation = vf.createIRI("http://schema.org/TaxiReservation");
        TaxiService = vf.createIRI("http://schema.org/TaxiService");
        TaxiStand = vf.createIRI("http://schema.org/TaxiStand");
        TechArticle = vf.createIRI("http://schema.org/TechArticle");
        telephone = vf.createIRI("http://schema.org/telephone");
        TelevisionChannel = vf.createIRI("http://schema.org/TelevisionChannel");
        TelevisionStation = vf.createIRI("http://schema.org/TelevisionStation");
        temporal = vf.createIRI("http://schema.org/temporal");
        temporalCoverage = vf.createIRI("http://schema.org/temporalCoverage");
        TennisComplex = vf.createIRI("http://schema.org/TennisComplex");
        termCode = vf.createIRI("http://schema.org/termCode");
        termsOfService = vf.createIRI("http://schema.org/termsOfService");
        text = vf.createIRI("http://schema.org/text");
        Text = vf.createIRI("http://schema.org/Text");
        TextDigitalDocument = vf.createIRI("http://schema.org/TextDigitalDocument");
        TheaterEvent = vf.createIRI("http://schema.org/TheaterEvent");
        TheaterGroup = vf.createIRI("http://schema.org/TheaterGroup");
        TherapeuticProcedure = vf.createIRI("http://schema.org/TherapeuticProcedure");
        Thesis = vf.createIRI("http://schema.org/Thesis");
        Thing = vf.createIRI("http://schema.org/Thing");
        thumbnail = vf.createIRI("http://schema.org/thumbnail");
        thumbnailUrl = vf.createIRI("http://schema.org/thumbnailUrl");
        tickerSymbol = vf.createIRI("http://schema.org/tickerSymbol");
        Ticket = vf.createIRI("http://schema.org/Ticket");
        ticketedSeat = vf.createIRI("http://schema.org/ticketedSeat");
        ticketNumber = vf.createIRI("http://schema.org/ticketNumber");
        ticketToken = vf.createIRI("http://schema.org/ticketToken");
        TieAction = vf.createIRI("http://schema.org/TieAction");
        Time = vf.createIRI("http://schema.org/Time");
        timeRequired = vf.createIRI("http://schema.org/timeRequired");
        TipAction = vf.createIRI("http://schema.org/TipAction");
        TireShop = vf.createIRI("http://schema.org/TireShop");
        tissueSample = vf.createIRI("http://schema.org/tissueSample");
        title = vf.createIRI("http://schema.org/title");
        toLocation = vf.createIRI("http://schema.org/toLocation");
        tongueWeight = vf.createIRI("http://schema.org/tongueWeight");
        tool = vf.createIRI("http://schema.org/tool");
        toRecipient = vf.createIRI("http://schema.org/toRecipient");
        torque = vf.createIRI("http://schema.org/torque");
        totalPaymentDue = vf.createIRI("http://schema.org/totalPaymentDue");
        totalPrice = vf.createIRI("http://schema.org/totalPrice");
        totalTime = vf.createIRI("http://schema.org/totalTime");
        TouristAttraction = vf.createIRI("http://schema.org/TouristAttraction");
        TouristDestination = vf.createIRI("http://schema.org/TouristDestination");
        TouristInformationCenter = vf.createIRI("http://schema.org/TouristInformationCenter");
        TouristTrip = vf.createIRI("http://schema.org/TouristTrip");
        touristType = vf.createIRI("http://schema.org/touristType");
        ToyStore = vf.createIRI("http://schema.org/ToyStore");
        track = vf.createIRI("http://schema.org/track");
        TrackAction = vf.createIRI("http://schema.org/TrackAction");
        trackingNumber = vf.createIRI("http://schema.org/trackingNumber");
        trackingUrl = vf.createIRI("http://schema.org/trackingUrl");
        tracks = vf.createIRI("http://schema.org/tracks");
        TradeAction = vf.createIRI("http://schema.org/TradeAction");
        trailer = vf.createIRI("http://schema.org/trailer");
        trailerWeight = vf.createIRI("http://schema.org/trailerWeight");
        trainName = vf.createIRI("http://schema.org/trainName");
        trainNumber = vf.createIRI("http://schema.org/trainNumber");
        TrainReservation = vf.createIRI("http://schema.org/TrainReservation");
        TrainStation = vf.createIRI("http://schema.org/TrainStation");
        TrainTrip = vf.createIRI("http://schema.org/TrainTrip");
        transcript = vf.createIRI("http://schema.org/transcript");
        transFatContent = vf.createIRI("http://schema.org/transFatContent");
        TransferAction = vf.createIRI("http://schema.org/TransferAction");
        translationOfWork = vf.createIRI("http://schema.org/translationOfWork");
        translator = vf.createIRI("http://schema.org/translator");
        transmissionMethod = vf.createIRI("http://schema.org/transmissionMethod");
        TravelAction = vf.createIRI("http://schema.org/TravelAction");
        TravelAgency = vf.createIRI("http://schema.org/TravelAgency");
        TreatmentIndication = vf.createIRI("http://schema.org/TreatmentIndication");
        trialDesign = vf.createIRI("http://schema.org/trialDesign");
        tributary = vf.createIRI("http://schema.org/tributary");
        Trip = vf.createIRI("http://schema.org/Trip");
        True = vf.createIRI("http://schema.org/True");
        TVClip = vf.createIRI("http://schema.org/TVClip");
        TVEpisode = vf.createIRI("http://schema.org/TVEpisode");
        TVSeason = vf.createIRI("http://schema.org/TVSeason");
        TVSeries = vf.createIRI("http://schema.org/TVSeries");
        TypeAndQuantityNode = vf.createIRI("http://schema.org/TypeAndQuantityNode");
        typeOfBed = vf.createIRI("http://schema.org/typeOfBed");
        typeOfGood = vf.createIRI("http://schema.org/typeOfGood");
        typicalAgeRange = vf.createIRI("http://schema.org/typicalAgeRange");
        typicalTest = vf.createIRI("http://schema.org/typicalTest");
        underName = vf.createIRI("http://schema.org/underName");
        unitCode = vf.createIRI("http://schema.org/unitCode");
        UnitPriceSpecification = vf.createIRI("http://schema.org/UnitPriceSpecification");
        unitText = vf.createIRI("http://schema.org/unitText");
        unnamedSourcesPolicy = vf.createIRI("http://schema.org/unnamedSourcesPolicy");
        UnRegisterAction = vf.createIRI("http://schema.org/UnRegisterAction");
        unsaturatedFatContent = vf.createIRI("http://schema.org/unsaturatedFatContent");
        UpdateAction = vf.createIRI("http://schema.org/UpdateAction");
        uploadDate = vf.createIRI("http://schema.org/uploadDate");
        upvoteCount = vf.createIRI("http://schema.org/upvoteCount");
        url = vf.createIRI("http://schema.org/url");
        URL = vf.createIRI("http://schema.org/URL");
        urlTemplate = vf.createIRI("http://schema.org/urlTemplate");
        UseAction = vf.createIRI("http://schema.org/UseAction");
        usedToDiagnose = vf.createIRI("http://schema.org/usedToDiagnose");
        UserBlocks = vf.createIRI("http://schema.org/UserBlocks");
        UserCheckins = vf.createIRI("http://schema.org/UserCheckins");
        UserComments = vf.createIRI("http://schema.org/UserComments");
        UserDownloads = vf.createIRI("http://schema.org/UserDownloads");
        UserInteraction = vf.createIRI("http://schema.org/UserInteraction");
        userInteractionCount = vf.createIRI("http://schema.org/userInteractionCount");
        UserLikes = vf.createIRI("http://schema.org/UserLikes");
        UserPageVisits = vf.createIRI("http://schema.org/UserPageVisits");
        UserPlays = vf.createIRI("http://schema.org/UserPlays");
        UserPlusOnes = vf.createIRI("http://schema.org/UserPlusOnes");
        UserReview = vf.createIRI("http://schema.org/UserReview");
        UserTweets = vf.createIRI("http://schema.org/UserTweets");
        usesDevice = vf.createIRI("http://schema.org/usesDevice");
        usesHealthPlanIdStandard = vf.createIRI("http://schema.org/usesHealthPlanIdStandard");
        validFor = vf.createIRI("http://schema.org/validFor");
        validFrom = vf.createIRI("http://schema.org/validFrom");
        validIn = vf.createIRI("http://schema.org/validIn");
        validThrough = vf.createIRI("http://schema.org/validThrough");
        validUntil = vf.createIRI("http://schema.org/validUntil");
        value = vf.createIRI("http://schema.org/value");
        valueAddedTaxIncluded = vf.createIRI("http://schema.org/valueAddedTaxIncluded");
        valueMaxLength = vf.createIRI("http://schema.org/valueMaxLength");
        valueMinLength = vf.createIRI("http://schema.org/valueMinLength");
        valueName = vf.createIRI("http://schema.org/valueName");
        valuePattern = vf.createIRI("http://schema.org/valuePattern");
        valueReference = vf.createIRI("http://schema.org/valueReference");
        valueRequired = vf.createIRI("http://schema.org/valueRequired");
        variableMeasured = vf.createIRI("http://schema.org/variableMeasured");
        variantCover = vf.createIRI("http://schema.org/variantCover");
        vatID = vf.createIRI("http://schema.org/vatID");
        Vehicle = vf.createIRI("http://schema.org/Vehicle");
        vehicleConfiguration = vf.createIRI("http://schema.org/vehicleConfiguration");
        vehicleEngine = vf.createIRI("http://schema.org/vehicleEngine");
        vehicleIdentificationNumber = vf.createIRI("http://schema.org/vehicleIdentificationNumber");
        vehicleInteriorColor = vf.createIRI("http://schema.org/vehicleInteriorColor");
        vehicleInteriorType = vf.createIRI("http://schema.org/vehicleInteriorType");
        vehicleModelDate = vf.createIRI("http://schema.org/vehicleModelDate");
        vehicleSeatingCapacity = vf.createIRI("http://schema.org/vehicleSeatingCapacity");
        vehicleSpecialUsage = vf.createIRI("http://schema.org/vehicleSpecialUsage");
        vehicleTransmission = vf.createIRI("http://schema.org/vehicleTransmission");
        Vein = vf.createIRI("http://schema.org/Vein");
        vendor = vf.createIRI("http://schema.org/vendor");
        verificationFactCheckingPolicy = vf.createIRI("http://schema.org/verificationFactCheckingPolicy");
        version = vf.createIRI("http://schema.org/version");
        Vessel = vf.createIRI("http://schema.org/Vessel");
        VeterinaryCare = vf.createIRI("http://schema.org/VeterinaryCare");
        video = vf.createIRI("http://schema.org/video");
        videoFormat = vf.createIRI("http://schema.org/videoFormat");
        videoFrameSize = vf.createIRI("http://schema.org/videoFrameSize");
        VideoGallery = vf.createIRI("http://schema.org/VideoGallery");
        VideoGame = vf.createIRI("http://schema.org/VideoGame");
        VideoGameClip = vf.createIRI("http://schema.org/VideoGameClip");
        VideoGameSeries = vf.createIRI("http://schema.org/VideoGameSeries");
        VideoObject = vf.createIRI("http://schema.org/VideoObject");
        videoQuality = vf.createIRI("http://schema.org/videoQuality");
        ViewAction = vf.createIRI("http://schema.org/ViewAction");
        VisualArtsEvent = vf.createIRI("http://schema.org/VisualArtsEvent");
        VisualArtwork = vf.createIRI("http://schema.org/VisualArtwork");
        VitalSign = vf.createIRI("http://schema.org/VitalSign");
        Volcano = vf.createIRI("http://schema.org/Volcano");
        volumeNumber = vf.createIRI("http://schema.org/volumeNumber");
        VoteAction = vf.createIRI("http://schema.org/VoteAction");
        WantAction = vf.createIRI("http://schema.org/WantAction");
        warning = vf.createIRI("http://schema.org/warning");
        warranty = vf.createIRI("http://schema.org/warranty");
        warrantyPromise = vf.createIRI("http://schema.org/warrantyPromise");
        WarrantyPromise = vf.createIRI("http://schema.org/WarrantyPromise");
        WarrantyScope = vf.createIRI("http://schema.org/WarrantyScope");
        warrantyScope = vf.createIRI("http://schema.org/warrantyScope");
        WatchAction = vf.createIRI("http://schema.org/WatchAction");
        Waterfall = vf.createIRI("http://schema.org/Waterfall");
        WearAction = vf.createIRI("http://schema.org/WearAction");
        WebAPI = vf.createIRI("http://schema.org/WebAPI");
        WebApplication = vf.createIRI("http://schema.org/WebApplication");
        webCheckinTime = vf.createIRI("http://schema.org/webCheckinTime");
        WebPage = vf.createIRI("http://schema.org/WebPage");
        WebPageElement = vf.createIRI("http://schema.org/WebPageElement");
        WebSite = vf.createIRI("http://schema.org/WebSite");
        weight = vf.createIRI("http://schema.org/weight");
        weightTotal = vf.createIRI("http://schema.org/weightTotal");
        wheelbase = vf.createIRI("http://schema.org/wheelbase");
        WholesaleStore = vf.createIRI("http://schema.org/WholesaleStore");
        width = vf.createIRI("http://schema.org/width");
        WinAction = vf.createIRI("http://schema.org/WinAction");
        Winery = vf.createIRI("http://schema.org/Winery");
        winner = vf.createIRI("http://schema.org/winner");
        wordCount = vf.createIRI("http://schema.org/wordCount");
        WorkersUnion = vf.createIRI("http://schema.org/WorkersUnion");
        workExample = vf.createIRI("http://schema.org/workExample");
        workFeatured = vf.createIRI("http://schema.org/workFeatured");
        workHours = vf.createIRI("http://schema.org/workHours");
        workload = vf.createIRI("http://schema.org/workload");
        workLocation = vf.createIRI("http://schema.org/workLocation");
        workPerformed = vf.createIRI("http://schema.org/workPerformed");
        workPresented = vf.createIRI("http://schema.org/workPresented");
        worksFor = vf.createIRI("http://schema.org/worksFor");
        workTranslation = vf.createIRI("http://schema.org/workTranslation");
        worstRating = vf.createIRI("http://schema.org/worstRating");
        WPAdBlock = vf.createIRI("http://schema.org/WPAdBlock");
        WPFooter = vf.createIRI("http://schema.org/WPFooter");
        WPHeader = vf.createIRI("http://schema.org/WPHeader");
        WPSideBar = vf.createIRI("http://schema.org/WPSideBar");
        WriteAction = vf.createIRI("http://schema.org/WriteAction");
        xpath = vf.createIRI("http://schema.org/xpath");
        XPathType = vf.createIRI("http://schema.org/XPathType");
        yearlyRevenue = vf.createIRI("http://schema.org/yearlyRevenue");
        yearsInOperation = vf.createIRI("http://schema.org/yearsInOperation");
        yield = vf.createIRI("http://schema.org/yield");
        Zoo = vf.createIRI("http://schema.org/Zoo");

        _VALUES = Vocabularies.getIRIs(SchemaOrgVocabulary.class);
    }

    public SchemaOrgVocabulary() {
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