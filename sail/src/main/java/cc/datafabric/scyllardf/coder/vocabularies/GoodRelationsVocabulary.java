package cc.datafabric.scyllardf.coder.vocabularies;

import cc.datafabric.scyllardf.coder.IVocabulary;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.util.Vocabularies;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Set;

public class GoodRelationsVocabulary implements IVocabulary {

    /**
     * {@code <http://purl.org/goodrelations/v1>}
     */
    public static final String NAMESPACE = "http://purl.org/goodrelations/v1#";

    /**
     * {@code <http://purl.org/goodrelations/v1>}
     */
    public static final IRI NAMESPACE_IRI;

    /**
     * {@code <GoodRelationsVocabulary>}
     */
    public static final String PREFIX = "GoodRelationsVocabulary";

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
     * accepted payment methods (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#acceptedPaymentMethods}
     * <p>
     * The gr:PaymentMethod or methods accepted by the gr:BusinessEntity for
     * the given gr:Offering.
     *
     * @see <a href="http://purl.org/goodrelations/v1#acceptedPaymentMethods">#acceptedPaymentMethods</a>
     */
    public static final IRI acceptedPaymentMethods;

    /**
     * Actual product or service instance (DEPRECATED)
     * <p>
     * {@code http://purl.org/goodrelations/v1#ActualProductOrServiceInstance}
     * <p>
     * DEPRECATED - This class is superseded by gr:Individual. Replace all
     * occurrences of gr:ActualProductOrServiceInstance by gr:Individual, if
     * possible.
     *
     * @see <a href="http://purl.org/goodrelations/v1#ActualProductOrServiceInstance">#ActualProductOrServiceInstance</a>
     */
    public static final IRI ActualProductOrServiceInstance;

    /**
     * add-on (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#addOn}
     * <p>
     * This property points from a gr:Offering to additional offerings that
     * can only be obtained in combination with the first offering. This can
     * be used to model supplements and extensions that are available for a
     * surcharge. Any gr:PriceSpecification attached to the secondary
     * offering is to be understood as an additional charge.
     *
     * @see <a href="http://purl.org/goodrelations/v1#addOn">#addOn</a>
     */
    public static final IRI addOn;

    /**
     * advance booking requirement (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#advanceBookingRequirement}
     * <p>
     * The minimal and maximal amount of time that is required between
     * accepting the gr:Offering and the actual usage of the resource or
     * service. This is mostly relevant for offers regarding hotel rooms, the
     * rental of objects, or the provisioning of services. The duration is
     * specified relatively to the beginning of the usage of the contracted
     * object. It is represented by attaching an instance of the class
     * gr:QuantitativeValueInteger. The lower and upper boundaries are
     * specified using the properties gr:hasMinValueInteger and
     * gr:hasMaxValueInteger to that instance. The unit of measurement is
     * specified using the property gr:hasUnitOfMeasurement with a string
     * holding a UN/CEFACT code suitable for durations, e.g. MON (months),
     * DAY (days), HUR (hours), or MIN (minutes).
     * <p>
     * The difference to the
     * gr:validFrom and gr:validThrough properties is that those specify the
     * interval during which the gr:Offering is valid, while
     * gr:advanceBookingRequirement specifies the acceptable relative amount
     * of time between accepting the offer and the fulfilment or usage.
     *
     * @see <a href="http://purl.org/goodrelations/v1#advanceBookingRequirement">#advanceBookingRequirement</a>
     */
    public static final IRI advanceBookingRequirement;

    /**
     * American Express (payment method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#AmericanExpress}
     * <p>
     * Payment by credit or debit cards issued by the American Express
     * network.
     *
     * @see <a href="http://purl.org/goodrelations/v1#AmericanExpress">#AmericanExpress</a>
     */
    public static final IRI AmericanExpress;

    /**
     * amount of this good (1..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#amountOfThisGood}
     * <p>
     * This property specifies the quantity of the goods included in the
     * gr:Offering via this gr:TypeAndQuantityNode. The quantity is given in
     * the unit of measurement attached to the gr:TypeAndQuantityNode.
     *
     * @see <a href="http://purl.org/goodrelations/v1#amountOfThisGood">#amountOfThisGood</a>
     */
    public static final IRI amountOfThisGood;

    /**
     * applies to delivery method (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#appliesToDeliveryMethod}
     * <p>
     * This property specifies the gr:DeliveryMethod to which the
     * gr:DeliveryChargeSpecification applies.
     *
     * @see <a href="http://purl.org/goodrelations/v1#appliesToDeliveryMethod">#appliesToDeliveryMethod</a>
     */
    public static final IRI appliesToDeliveryMethod;

    /**
     * applies to payment method (1..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#appliesToPaymentMethod}
     * <p>
     * This property specifies the gr:PaymentMethod to which the
     * gr:PaymentChargeSpecification applies.
     *
     * @see <a href="http://purl.org/goodrelations/v1#appliesToPaymentMethod">#appliesToPaymentMethod</a>
     */
    public static final IRI appliesToPaymentMethod;

    /**
     * availability ends (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#availabilityEnds}
     * <p>
     * This property specifies the end of the availability of the
     * gr:ProductOrService included in the gr:Offering.
     * The difference to the
     * properties gr:validFrom and gr:validThrough is that those specify the
     * period of time during which the offer is valid and can be
     * accepted.
     * <p>
     * Example: I offer to lease my boat for the period of August
     * 1 - August 31, 2010, but you must accept by offer no later than July
     * 15.
     * <p>
     * A time-zone should be specified. For a time in GMT/UTC, simply
     * add a &quot;Z&quot; following the
     * time:
     * <p>
     * 2008-05-30T09:30:10Z.
     * <p>
     * Alternatively, you can specify an offset
     * from the UTC time by adding a positive or negative time following the
     * time:
     * <p>
     * 2008-05-30T09:30:10-09:00
     * <p>
     * or
     * <p>
     * 2008-05-30T09:30:10+09:00.
     * <p>
     * Note:
     * There is another property gr:availableAtOrFrom, which is used to
     * indicate the gr:Location (e.g. store or shop) from which the goods
     * would be available.
     *
     * @see <a href="http://purl.org/goodrelations/v1#availabilityEnds">#availabilityEnds</a>
     */
    public static final IRI availabilityEnds;

    /**
     * availability starts (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#availabilityStarts}
     * <p>
     * This property specifies the beginning of the availability of the
     * gr:ProductOrService included in the gr:Offering.
     * The difference to the
     * properties gr:validFrom and gr:validThrough is that those specify the
     * period of time during which the offer is valid and can be
     * accepted.
     * <p>
     * Example: I offer to lease my boat for the period of August
     * 1 - August 31, 2010, but you must accept by offer no later than July
     * 15.
     * <p>
     * A time-zone should be specified. For a time in GMT/UTC, simply
     * add a &quot;Z&quot; following the
     * time:
     * <p>
     * 2008-05-30T09:30:10Z.
     * <p>
     * Alternatively, you can specify an offset
     * from the UTC time by adding a positive or negative time following the
     * time:
     * <p>
     * 2008-05-30T09:30:10-09:00
     * <p>
     * or
     * <p>
     * 2008-05-30T09:30:10+09:00.
     * <p>
     * Note:
     * There is another property gr:availableAtOrFrom, which is used to
     * indicate the gr:Location (e.g. store or shop) from which the goods
     * would be available.
     *
     * @see <a href="http://purl.org/goodrelations/v1#availabilityStarts">#availabilityStarts</a>
     */
    public static final IRI availabilityStarts;

    /**
     * available at or from (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#availableAtOrFrom}
     * <p>
     * This states that a particular gr:Offering is available at or from the
     * given gr:Location (e.g. shop or branch).
     *
     * @see <a href="http://purl.org/goodrelations/v1#availableAtOrFrom">#availableAtOrFrom</a>
     */
    public static final IRI availableAtOrFrom;

    /**
     * available delivery methods (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#availableDeliveryMethods}
     * <p>
     * This specifies the gr:DeliveryMethod or methods available for a given
     * gr:Offering.
     *
     * @see <a href="http://purl.org/goodrelations/v1#availableDeliveryMethods">#availableDeliveryMethods</a>
     */
    public static final IRI availableDeliveryMethods;

    /**
     * billing increment (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#billingIncrement}
     * <p>
     * This property specifies the minimal quantity and rounding increment
     * that will be the basis for the billing.
     * The unit of measurement is
     * specified by the UN/CEFACT code attached to the
     * gr:UnitPriceSpecification via the gr:hasUnitOfMeasurement
     * property.
     * <p>
     * Examples:
     * - The price for gasoline is 4 USD per gallon at
     * the pump, but you will be charged in units of 0.1 gallons.
     * - The price
     * for legal consulting is 100 USD per hour, but you will be charged in
     * units of 15 minutes.
     * <p>
     * This property makes sense only for instances of
     * gr:Offering that include not more than one type of good or service.
     *
     * @see <a href="http://purl.org/goodrelations/v1#billingIncrement">#billingIncrement</a>
     */
    public static final IRI billingIncrement;

    /**
     * Brand
     * <p>
     * {@code http://purl.org/goodrelations/v1#Brand}
     * <p>
     * A brand is the identity of a specific product, service, or business.
     * Use foaf:logo for attaching a brand logo and gr:name or rdfs:label for
     * attaching the brand name.
     * <p>
     * (Source: Wikipedia, the free encyclopedia,
     * see http://en.wikipedia.org/wiki/Brand)
     *
     * @see <a href="http://purl.org/goodrelations/v1#Brand">#Brand</a>
     */
    public static final IRI Brand;

    /**
     * Business (business entity type)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Business}
     * <p>
     * The gr:BusinessEntityType representing such agents that are themselves
     * offering commercial services or products on the market. Usually,
     * businesses are characterized by the fact that they are officially
     * registered with the public administration and strive for profits by
     * their activities.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Business">#Business</a>
     */
    public static final IRI Business;

    /**
     * Business entity
     * <p>
     * {@code http://purl.org/goodrelations/v1#BusinessEntity}
     * <p>
     * An instance of this class represents the legal agent making (or
     * seeking) a particular offering. This can be a legal body or a person.
     * A business entity has at least a primary mailing address and contact
     * details. For this, typical address standards (vCard) and location data
     * (geo, WGS84) can be attached. Note that the location of the business
     * entity is not necessarily the location from which the product or
     * service is being available (e.g. the branch or store). Use gr:Location
     * for stores and branches.
     * <p>
     * Example: Siemens Austria AG, Volkswagen
     * Ltd., Peter Miller&#39;s Cell phone Shop LLC
     * <p>
     * Compatibility with
     * schema.org: This class is equivalent to the union of
     * http://schema.org/Person and http://schema.org/Organization.
     *
     * @see <a href="http://purl.org/goodrelations/v1#BusinessEntity">#BusinessEntity</a>
     */
    public static final IRI BusinessEntity;

    /**
     * Business entity type
     * <p>
     * {@code http://purl.org/goodrelations/v1#BusinessEntityType}
     * <p>
     * A business entity type is a conceptual entity representing the legal
     * form, the size, the main line of business, the position in the value
     * chain, or any combination thereof, of a gr:BusinessEntity. From the
     * ontological point of view, business entity types are mostly roles that
     * a business entity has in the market. Business entity types are
     * important for specifying eligible customers, since a gr:Offering is
     * often valid only for business entities of a certain size, legal
     * structure, or role in the value chain.
     * <p>
     * Examples: Consumers,
     * Retailers, Wholesalers, or Public Institutions
     *
     * @see <a href="http://purl.org/goodrelations/v1#BusinessEntityType">#BusinessEntityType</a>
     */
    public static final IRI BusinessEntityType;

    /**
     * Business function
     * <p>
     * {@code http://purl.org/goodrelations/v1#BusinessFunction}
     * <p>
     * The business function specifies the type of activity or access (i.e.,
     * the bundle of rights) offered by the gr:BusinessEntity on the
     * gr:ProductOrService through the gr:Offering. Typical are sell, rental
     * or lease, maintenance or repair, manufacture / produce, recycle /
     * dispose, engineering / construction, or installation.
     * <p>
     * Licenses and
     * other proprietary specifications of access rights are also instances
     * of this class.
     * <p>
     * Examples: A particular offering made by Miller Rentals
     * Ltd. says that they (1) sell Volkswagen Golf convertibles, (2) lease
     * out a particular Ford pick-up truck, and (3) dispose car wrecks of any
     * make and model.
     *
     * @see <a href="http://purl.org/goodrelations/v1#BusinessFunction">#BusinessFunction</a>
     */
    public static final IRI BusinessFunction;

    /**
     * Buy (business function, DEPRECATED)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Buy}
     * <p>
     * This gr:BusinessFunction indicates that the gr:BusinessEntity is in
     * general interested in purchasing the specified
     * gr:ProductOrService.
     * DEPRECATED. Use gr:seeks instead.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Buy">#Buy</a>
     */
    public static final IRI Buy;

    /**
     * By bank transfer in advance (payment method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#ByBankTransferInAdvance}
     * <p>
     * Payment by bank transfer in advance, i.e., the offering
     * gr:BusinessEntity will inform the buying party about their bank
     * account details and will deliver the goods upon receipt of the due
     * amount.
     * This is equivalent to payment by wire transfer.
     *
     * @see <a href="http://purl.org/goodrelations/v1#ByBankTransferInAdvance">#ByBankTransferInAdvance</a>
     */
    public static final IRI ByBankTransferInAdvance;

    /**
     * By invoice (payment method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#ByInvoice}
     * <p>
     * Payment by bank transfer after delivery, i.e., the offering
     * gr:BusinessEntity will deliver first, inform the buying party about
     * the due amount and their bank account details, and expect payment
     * shortly after delivery.
     *
     * @see <a href="http://purl.org/goodrelations/v1#ByInvoice">#ByInvoice</a>
     */
    public static final IRI ByInvoice;

    /**
     * Cash (payment method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Cash}
     * <p>
     * Payment by cash upon delivery or pickup.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Cash">#Cash</a>
     */
    public static final IRI Cash;

    /**
     * category (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#category}
     * <p>
     * The name of a category to which this gr:ProductOrService, gr:Offering,
     * gr:BusinessEntity, or gr:Location belongs.
     * <p>
     * Note 1: For products, it
     * is better to add an rdf:type statement referring to a
     * GoodRelations-compliant ontology for vertical industries instead, but
     * if you just have a short text label, gr:category is simpler.
     * Note 2:
     * You can use greater signs or slashes to informally indicate a category
     * hierarchy, e.g. &quot;restaurants/asian_restaurants&quot; or
     * &quot;cables &gt; usb_cables&quot;
     *
     * @see <a href="http://purl.org/goodrelations/v1#category">#category</a>
     */
    public static final IRI category;

    /**
     * Check in advance (payment method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#CheckInAdvance}
     * <p>
     * Payment by sending a check in advance, i.e., the offering
     * gr:BusinessEntity will deliver the goods upon receipt of a check over
     * the due amount. There are variations in handling payment by check -
     * sometimes, shipment will be upon receipt of the check as a document,
     * sometimes the shipment will take place only upon successful crediting
     * of the check.
     *
     * @see <a href="http://purl.org/goodrelations/v1#CheckInAdvance">#CheckInAdvance</a>
     */
    public static final IRI CheckInAdvance;

    /**
     * closes (1..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#closes}
     * <p>
     * The closing  hour of the gr:Location on the given gr:DayOfWeek.
     * If no
     * time-zone suffix is included, the time is given in the local time
     * valid at the gr:Location.
     * <p>
     * For a time in GMT/UTC, simply add a
     * &quot;Z&quot; following the time:
     * <p>
     * 09:30:10Z.
     * <p>
     * Alternatively, you can
     * specify an offset from the UTC time by adding a positive or negative
     * time following the time:
     * <p>
     * 09:30:10-09:00
     * <p>
     * 09:30:10+09:00.
     * <p>
     * Note 1: Use
     * 00:00:00 for the first second of the respective day and 23:59:59 for
     * the last second of that day.
     * Note 2: If a store opens at 17:00 on
     * Saturdays and closes at 03:00:00 a.m. next morning, use two instances
     * of this class, one with 17:00:00 - 23:59:59 for Saturday and another
     * one with 00:00:00 - 03:00:00 for Sunday.
     * Note 3: If the shop re-opens
     * on the same day of the week or set of days of the week, you must
     * create a second instance of gr:OpeningHoursSpecification.
     *
     * @see <a href="http://purl.org/goodrelations/v1#closes">#closes</a>
     */
    public static final IRI closes;

    /**
     * COD (payment method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#COD}
     * <p>
     * Collect on delivery / Cash on delivery - A payment method where the
     * recipient of goods pays at the time of delivery. Usually, the amount
     * of money is collected by the transportation company handling the
     * goods.
     *
     * @see <a href="http://purl.org/goodrelations/v1#COD">#COD</a>
     */
    public static final IRI COD;

    /**
     * color (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#color}
     * <p>
     * The color of the product.
     *
     * @see <a href="http://purl.org/goodrelations/v1#color">#color</a>
     */
    public static final IRI color;

    /**
     * condition (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#condition}
     * <p>
     * A textual description of the condition of the product or service, or
     * the products or services included in the offer (when attached to a
     * gr:Offering)
     *
     * @see <a href="http://purl.org/goodrelations/v1#condition">#condition</a>
     */
    public static final IRI condition;

    /**
     * Construction / installation (business function)
     * <p>
     * {@code http://purl.org/goodrelations/v1#ConstructionInstallation}
     * <p>
     * This gr:BusinessFunction indicates that the gr:BusinessEntity offers
     * (or seeks) the construction and/or installation of the specified
     * gr:ProductOrService at the customer&#39;s location.
     *
     * @see <a href="http://purl.org/goodrelations/v1#ConstructionInstallation">#ConstructionInstallation</a>
     */
    public static final IRI ConstructionInstallation;

    /**
     * datatype product or service property (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#datatypeProductOrServiceProperty}
     * <p>
     * This property is the super property for all pure datatype properties
     * that can be used to describe a gr:ProductOrService.
     * <p>
     * In products and
     * services ontologies, only such properties that are no quantitative
     * properties and that have no predefined gr:QualitativeValue instances
     * are subproperties of this property. In practice, this refers to a few
     * integer properties for which the integer value represents qualitative
     * aspects, for string datatypes (as long as no predefined values exist),
     * for boolean datatype properties, and for dates and times.
     *
     * @see <a href="http://purl.org/goodrelations/v1#datatypeProductOrServiceProperty">#datatypeProductOrServiceProperty</a>
     */
    public static final IRI datatypeProductOrServiceProperty;

    /**
     * Day of week
     * <p>
     * {@code http://purl.org/goodrelations/v1#DayOfWeek}
     * <p>
     * The day of the week, used to specify  to which day the opening hours
     * of a gr:OpeningHoursSpecification refer.
     * <p>
     * Examples: Monday, Tuesday,
     * Wednesday,...
     *
     * @see <a href="http://purl.org/goodrelations/v1#DayOfWeek">#DayOfWeek</a>
     */
    public static final IRI DayOfWeek;

    /**
     * Delivery charge specification
     * <p>
     * {@code http://purl.org/goodrelations/v1#DeliveryChargeSpecification}
     * <p>
     * A delivery charge specification is a conceptual entity that specifies
     * the additional costs asked for the delivery of a given gr:Offering
     * using a particular gr:DeliveryMethod by the respective
     * gr:BusinessEntity. A delivery charge specification is characterized by
     * (1) a monetary amount per order, specified as a literal value of type
     * float in combination with a currency, (2) the delivery method, (3) the
     * target country or region, and (4)  whether this charge includes local
     * sales taxes, namely VAT.
     * A gr:Offering may be linked to multiple
     * gr:DeliveryChargeSpecification nodes that specify alternative charges
     * for disjoint combinations of target countries or regions, and delivery
     * methods.
     * <p>
     * Examples: Delivery by direct download is free of charge
     * worldwide, delivery by UPS to Germany is 10 Euros per order, delivery
     * by mail within the US is 5 Euros per order.
     * <p>
     * The total amount of this
     * charge is specified as a float value of the gr:hasCurrencyValue
     * property. The currency is specified via the gr:hasCurrency datatype
     * property. Whether the price includes VAT or not is indicated by the
     * gr:valueAddedTaxIncluded property. The gr:DeliveryMethod to which this
     * charge applies is specified using the gr:appliesToDeliveryMethod
     * object property. The region or regions to which this charge applies is
     * specified using the gr:eligibleRegions property, which uses ISO 3166-1
     * and ISO 3166-2 codes.
     * <p>
     * If the price can only be given as a range, use
     * gr:hasMaxCurrencyValue and gr:hasMinCurrencyValue for the upper and
     * lower bounds.
     * <p>
     * Important: When querying for the price, always use
     * gr:hasMaxCurrencyValue and gr:hasMinCurrencyValue.
     *
     * @see <a href="http://purl.org/goodrelations/v1#DeliveryChargeSpecification">#DeliveryChargeSpecification</a>
     */
    public static final IRI DeliveryChargeSpecification;

    /**
     * delivery lead time (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#deliveryLeadTime}
     * <p>
     * This property can be used to indicate the promised delay between the
     * receipt of the order and the goods leaving the warehouse.
     * <p>
     * The
     * duration is specified by attaching an instance of
     * gr:QuantitativeValueInteger. The lower and upper boundaries are
     * specified using the properties gr:hasMinValueInteger and
     * gr:hasMaxValueInteger to that instance. A point value can be modeled
     * with the gr:hasValueInteger property. The unit of measurement is
     * specified using the property gr:hasUnitOfMeasurement with a string
     * holding a UN/CEFACT code suitable for durations, e.g. MON (months),
     * DAY (days), HUR (hours), or MIN (minutes).
     *
     * @see <a href="http://purl.org/goodrelations/v1#deliveryLeadTime">#deliveryLeadTime</a>
     */
    public static final IRI deliveryLeadTime;

    /**
     * Delivery method
     * <p>
     * {@code http://purl.org/goodrelations/v1#DeliveryMethod}
     * <p>
     * A delivery method is a standardized procedure for transferring the
     * product or service to the destination of fulfilment chosen by the
     * customer. Delivery methods are characterized by the means of
     * transportation used, and by the organization or group that is the
     * contracting party for the sending gr:BusinessEntity (this is
     * important, since the contracted party may subcontract the fulfilment
     * to smaller, regional businesses).
     * <p>
     * Examples: Delivery by mail,
     * delivery by direct download, delivery by UPS
     *
     * @see <a href="http://purl.org/goodrelations/v1#DeliveryMethod">#DeliveryMethod</a>
     */
    public static final IRI DeliveryMethod;

    /**
     * Delivery mode direct download (delivery method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#DeliveryModeDirectDownload}
     * <p>
     * Delivery of the goods via direct download from the Internet, i.e., the
     * offering gr:BusinessEntity provides the buying party with details on
     * how to retrieve the goods online. Connection fees and other costs of
     * using the infrastructure are to be carried by the buying party.
     *
     * @see <a href="http://purl.org/goodrelations/v1#DeliveryModeDirectDownload">#DeliveryModeDirectDownload</a>
     */
    public static final IRI DeliveryModeDirectDownload;

    /**
     * Delivery mode freight (delivery method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#DeliveryModeFreight}
     * <p>
     * Delivery by an unspecified air, sea, or ground freight carrier or
     * cargo company.
     *
     * @see <a href="http://purl.org/goodrelations/v1#DeliveryModeFreight">#DeliveryModeFreight</a>
     */
    public static final IRI DeliveryModeFreight;

    /**
     * Delivery mode mail (delivery method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#DeliveryModeMail}
     * <p>
     * Delivery via regular mail service (private or public postal services).
     *
     * @see <a href="http://purl.org/goodrelations/v1#DeliveryModeMail">#DeliveryModeMail</a>
     */
    public static final IRI DeliveryModeMail;

    /**
     * Delivery mode own fleet (delivery method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#DeliveryModeOwnFleet}
     * <p>
     * Delivery of the goods by using a fleet of vehicles either owned and
     * operated or subcontracted by the gr:BusinessEntity.
     *
     * @see <a href="http://purl.org/goodrelations/v1#DeliveryModeOwnFleet">#DeliveryModeOwnFleet</a>
     */
    public static final IRI DeliveryModeOwnFleet;

    /**
     * Delivery mode parcel service
     * <p>
     * {@code http://purl.org/goodrelations/v1#DeliveryModeParcelService}
     * <p>
     * A private parcel service as the delivery mode available for a certain
     * offering.
     * <p>
     * Examples: UPS, DHL
     *
     * @see <a href="http://purl.org/goodrelations/v1#DeliveryModeParcelService">#DeliveryModeParcelService</a>
     */
    public static final IRI DeliveryModeParcelService;

    /**
     * Delivery mode pick up (delivery method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#DeliveryModePickUp}
     * <p>
     * Delivery of the goods by picking them up at one of the stores etc.
     * (gr:Location) during the opening hours as specified by respective
     * instances of gr:OpeningHoursSpecification.
     *
     * @see <a href="http://purl.org/goodrelations/v1#DeliveryModePickUp">#DeliveryModePickUp</a>
     */
    public static final IRI DeliveryModePickUp;

    /**
     * depth (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#depth}
     * <p>
     * The depth of the product.
     * Typical unit code(s): CMT for centimeters,
     * INH for inches
     *
     * @see <a href="http://purl.org/goodrelations/v1#depth">#depth</a>
     */
    public static final IRI depth;

    /**
     * description (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#description}
     * <p>
     * A short textual description of the resource.
     * <p>
     * This property is
     * semantically equivalent to rdfs:comment and just meant as a handy
     * shortcut for marking up data.
     *
     * @see <a href="http://purl.org/goodrelations/v1#description">#description</a>
     */
    public static final IRI description;

    /**
     * DHL (delivery method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#DHL}
     * <p>
     * Delivery via the parcel service DHL.
     *
     * @see <a href="http://purl.org/goodrelations/v1#DHL">#DHL</a>
     */
    public static final IRI DHL;

    /**
     * Diners Club (payment method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#DinersClub}
     * <p>
     * Payment by credit or debit cards issued by the Diner&#39;s Club
     * network.
     *
     * @see <a href="http://purl.org/goodrelations/v1#DinersClub">#DinersClub</a>
     */
    public static final IRI DinersClub;

    /**
     * Direct debit (payment method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#DirectDebit}
     * <p>
     * Payment by direct debit, i.e., the buying party will inform the
     * offering gr:BusinessEntity about its bank account details and
     * authorizes the gr:BusinessEntity to collect the agreed amount directly
     * from that account.
     *
     * @see <a href="http://purl.org/goodrelations/v1#DirectDebit">#DirectDebit</a>
     */
    public static final IRI DirectDebit;

    /**
     * Discover (payment method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Discover}
     * <p>
     * Payment by credit or debit cards issued by the Discover network.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Discover">#Discover</a>
     */
    public static final IRI Discover;

    /**
     * display position (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#displayPosition}
     * <p>
     * The position at which the option or element should be listed in a menu
     * or user dialog, lower numbers come first.
     * <p>
     * The main usage of this
     * property are the days of the week (gr:DayOfWeek), but it is also
     * possible to apply it e.g. to product features or any other conceptual
     * element.
     * Note: Rely on this property only for data originating from a
     * single RDF graph; otherwise, unpredictable results are possible.
     *
     * @see <a href="http://purl.org/goodrelations/v1#displayPosition">#displayPosition</a>
     */
    public static final IRI displayPosition;

    /**
     * Dispose (business function)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Dispose}
     * <p>
     * This gr:BusinessFunction indicates that the gr:BusinessEntity offers
     * (or seeks) the acceptance of the specified gr:ProductOrService for
     * proper disposal, recycling, or any other kind of allowed usages,
     * freeing the current owner from all rights and obligations of
     * ownership.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Dispose">#Dispose</a>
     */
    public static final IRI Dispose;

    /**
     * duration of warranty in months (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#durationOfWarrantyInMonths}
     * <p>
     * This property specifies the duration of the gr:WarrantyPromise in
     * months.
     *
     * @see <a href="http://purl.org/goodrelations/v1#durationOfWarrantyInMonths">#durationOfWarrantyInMonths</a>
     */
    public static final IRI durationOfWarrantyInMonths;

    /**
     * eligible customer types (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#eligibleCustomerTypes}
     * <p>
     * The types of customers (gr:BusinessEntityType) for which the given
     * gr:Offering is valid.
     *
     * @see <a href="http://purl.org/goodrelations/v1#eligibleCustomerTypes">#eligibleCustomerTypes</a>
     */
    public static final IRI eligibleCustomerTypes;

    /**
     * eligible duration (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#eligibleDuration}
     * <p>
     * The minimal and maximal duration for which the given gr:Offering or
     * gr:License is valid. This is mostly used for offers regarding
     * accommodation, the rental of objects, or software licenses. The
     * duration is specified by attaching an instance of
     * gr:QuantitativeValue. The lower and upper boundaries are specified
     * using the properties gr:hasMinValue and gr:hasMaxValue to that
     * instance. If they are the same, use the gr:hasValue property. The unit
     * of measurement is specified using the property gr:hasUnitOfMeasurement
     * with a string holding a UN/CEFACT code suitable for durations, e.g.
     * MON (months), DAY (days), HUR (hours), or MIN (minutes).
     * <p>
     * The
     * difference to the gr:validFrom and gr:validThrough properties is that
     * those specify the absiolute interval during which the gr:Offering or
     * gr:License is valid, while gr:eligibleDuration specifies the
     * acceptable duration of the contract or usage.
     *
     * @see <a href="http://purl.org/goodrelations/v1#eligibleDuration">#eligibleDuration</a>
     */
    public static final IRI eligibleDuration;

    /**
     * eligible regions (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#eligibleRegions}
     * <p>
     * This property specifies the geo-political region or regions for which
     * the gr:Offering, gr:License, or gr:DeliveryChargeSpecification is
     * valid using the two-character version of ISO 3166-1 (ISO 3166-1
     * alpha-2)  for regions or ISO 3166-2 , which breaks down the countries
     * from ISO 3166-1 into administrative subdivisions.
     * <p>
     * Important: Do NOT
     * use 3-letter ISO 3166-1 codes!
     *
     * @see <a href="http://purl.org/goodrelations/v1#eligibleRegions">#eligibleRegions</a>
     */
    public static final IRI eligibleRegions;

    /**
     * eligible transaction volume (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#eligibleTransactionVolume}
     * <p>
     * This property can be used to indicate the transaction volume, in a
     * monetary unit, for which the gr:Offering or gr:PriceSpecification is
     * valid. This is mostly used to specify a minimal purchasing volume, to
     * express free shipping above a certain order volume, or to limit the
     * acceptance of credit cards to purchases above a certain amount.
     * <p>
     * The
     * object is a gr:PriceSpecification that uses the properties
     * gr:hasMaxCurrencyValue and gr:hasMinCurrencyValue to indicate the
     * lower and upper boundaries and gr:hasCurrency to indicate the currency
     * using the ISO 4217 standard (3 characters).
     *
     * @see <a href="http://purl.org/goodrelations/v1#eligibleTransactionVolume">#eligibleTransactionVolume</a>
     */
    public static final IRI eligibleTransactionVolume;

    /**
     * Enduser (business entity type)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Enduser}
     * <p>
     * The gr:BusinessEntityType representing such agents that are purchasing
     * the good or service for private consumption, in particular not for
     * resale or for usage within an industrial enterprise. By default, a
     * Business Entity is an Enduser.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Enduser">#Enduser</a>
     */
    public static final IRI Enduser;

    /**
     * equal (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#equal}
     * <p>
     * This ordering relation for qualitative values indicates that the
     * subject is equal to the object.
     *
     * @see <a href="http://purl.org/goodrelations/v1#equal">#equal</a>
     */
    public static final IRI equal;

    /**
     * Federal Express (delivery method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#FederalExpress}
     * <p>
     * Delivery via the parcel service Federal Express.
     *
     * @see <a href="http://purl.org/goodrelations/v1#FederalExpress">#FederalExpress</a>
     */
    public static final IRI FederalExpress;

    /**
     * Friday (day of week)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Friday}
     * <p>
     * Friday as a day of the week.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Friday">#Friday</a>
     */
    public static final IRI Friday;

    /**
     * Google Checkout (payment method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#GoogleCheckout}
     * <p>
     * Payment via the Google Checkout payment service.
     *
     * @see <a href="http://purl.org/goodrelations/v1#GoogleCheckout">#GoogleCheckout</a>
     */
    public static final IRI GoogleCheckout;

    /**
     * greater (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#greater}
     * <p>
     * This ordering relation for qualitative values indicates that the
     * subject is greater than the object.
     *
     * @see <a href="http://purl.org/goodrelations/v1#greater">#greater</a>
     */
    public static final IRI greater;

    /**
     * greater or equal (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#greaterOrEqual}
     * <p>
     * This ordering relation for qualitative values indicates that the
     * subject is greater than or equal to the object.
     *
     * @see <a href="http://purl.org/goodrelations/v1#greaterOrEqual">#greaterOrEqual</a>
     */
    public static final IRI greaterOrEqual;

    /**
     * has brand (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasBrand}
     * <p>
     * This specifies the brand or brands (gr:Brand) associated with a
     * gr:ProductOrService, or the brand or brands maintained by a
     * gr:BusinessEntity.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasBrand">#hasBrand</a>
     */
    public static final IRI hasBrand;

    /**
     * has business function (1..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasBusinessFunction}
     * <p>
     * This specifies the business function of the gr:Offering, i.e. whether
     * the gr:BusinessEntity is offering to sell, to lease, or to repair the
     * particular type of product. In the case of bundles, it is also
     * possible to attach individual business functions to each
     * gr:TypeAndQuantityNode. The business function of the main gr:Offering
     * determines the business function for all included objects or services,
     * unless a business function attached to a gr:TypeAndQuantityNode
     * overrides it.
     * <p>
     * Note: While it is possible that an entity is offering
     * multiple types of business functions for the same set of objects (e.g.
     * rental and sales), this should usually not be stated by attaching
     * multiple business functions to the same gr:Offering, since the
     * gr:UnitPriceSpecification for the varying business functions will
     * typically be very different.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasBusinessFunction">#hasBusinessFunction</a>
     */
    public static final IRI hasBusinessFunction;

    /**
     * has currency (1..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasCurrency}
     * <p>
     * The currency for all prices in the gr:PriceSpecification given using
     * the ISO 4217 standard (3 characters).
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasCurrency">#hasCurrency</a>
     */
    public static final IRI hasCurrency;

    /**
     * has currency value (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasCurrencyValue}
     * <p>
     * This property specifies the amount of money for a price per unit,
     * shipping charges, or payment charges. The currency and other relevant
     * details are attached to the respective gr:PriceSpecification etc.
     * <p>
     * For
     * a gr:UnitPriceSpecification, this is the price for one unit or bundle
     * (as specified in the unit of measurement of the unit price
     * specification) of the respective gr:ProductOrService. For a
     * gr:DeliveryChargeSpecification or a gr:PaymentChargeSpecification, it
     * is the price per delivery or payment.
     * <p>
     * GoodRelations also supports
     * giving price information as intervals only. If this is needed, use
     * gr:hasMaxCurrencyValue for the upper bound and gr:hasMinCurrencyValue
     * for the lower bound.
     * <p>
     * Using gr:hasCurrencyValue sets the upper and
     * lower bounds to the same given value, i.e., x gr:hasCurrencyValue y
     * implies x gr:hasMinCurrencyValue y, x gr:hasMaxCurrencyValue y.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasCurrencyValue">#hasCurrencyValue</a>
     */
    public static final IRI hasCurrencyValue;

    /**
     * has DUNS (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasDUNS}
     * <p>
     * The Dun &amp; Bradstreet DUNS number for identifying a
     * gr:BusinessEntity. The Dun &amp; Bradstreet DUNS is a nine-digit
     * number used to identify legal entities (but usually not branches or
     * locations of logistical importance only).
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasDUNS">#hasDUNS</a>
     */
    public static final IRI hasDUNS;

    /**
     * has EAN/UCC-13 (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasEAN_UCC-13}
     * <p>
     * The EAN·UCC-13 code of the given gr:ProductOrService or gr:Offering.
     * This code is now officially called GTIN-13 (Global Trade Identifier
     * Number) or EAN·UCC-13. Former 12-digit UPC codes can be converted into
     * EAN·UCC-13 code by simply adding a preceeding zero.
     * <p>
     * Note 1: When
     * using this property for searching by 12-digit UPC codes, you must add
     * a preceeding zero digit.
     * Note 2: As of January 1, 2007, the former
     * ISBN numbers for books etc. have been integrated into the EAN·UCC-13
     * code. For each old ISBN-10 code, there exists a proper translation
     * into EAN·UCC-13 by adding &quot;978&quot; or &quot;979&quot; as
     * prefix. Since the old ISBN-10 is now deprecated, GoodRelations does
     * not provide a property for ISBNs.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasEAN_UCC-13">#hasEAN_UCC-13</a>
     */
    public static final IRI hasEAN_UCC_13;

    /**
     * has eligible quantity (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasEligibleQuantity}
     * <p>
     * This specifies the interval and unit of measurement of ordering
     * quantities for which the gr:Offering or gr:PriceSpecification is
     * valid. This allows e.g. specifying that a certain freight charge is
     * valid only for a certain quantity.
     * Note that if an offering is a
     * bundle, i.e. it consists of more than one unit of a single type of
     * good, or if the unit of measurement for the good is different from
     * unit (Common Code C62), then gr:hasEligibleQuantity refers to units of
     * this bundle. In other words, &quot;C62&quot; for &quot;Units or
     * pieces&quot; is usually the appropriate unit of measurement.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasEligibleQuantity">#hasEligibleQuantity</a>
     */
    public static final IRI hasEligibleQuantity;

    /**
     * has Global Location Number (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasGlobalLocationNumber}
     * <p>
     * The Global Location Number (GLN, sometimes also referred to as
     * International Location Number or ILN) of the respective
     * gr:BusinessEntity or gr:Location.
     * The Global Location Number is a
     * thirteen-digit number used to identify parties and physical locations.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasGlobalLocationNumber">#hasGlobalLocationNumber</a>
     */
    public static final IRI hasGlobalLocationNumber;

    /**
     * has GTIN-14 (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasGTIN-14}
     * <p>
     * The Global Trade Item Number (GTIN-14) of the given
     * gr:ProductOrService or gr:Offering.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasGTIN-14">#hasGTIN-14</a>
     */
    public static final IRI hasGTIN_14;

    /**
     * has GTIN-8 (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasGTIN-8}
     * <p>
     * The 8-digit Global Trade Item Number (GTIN-8) of the given
     * gr:ProductOrService or gr:Offering, also known as EAN/UCC-8 (8-digit
     * EAN).
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasGTIN-8">#hasGTIN-8</a>
     */
    public static final IRI hasGTIN_8;

    /**
     * has inventory level (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasInventoryLevel}
     * <p>
     * This property specifies the current approximate inventory level for
     * gr:SomeItems. The unit of measurement and the point value or interval
     * are indicated using the attached gr:QuantitativeValueFloat
     * instance.
     * <p>
     * This property can also be attached to a gr:Offering in
     * cases where the included products are not modeled in more detail.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasInventoryLevel">#hasInventoryLevel</a>
     */
    public static final IRI hasInventoryLevel;

    /**
     * has ISIC v4 (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasISICv4}
     * <p>
     * The International Standard of Industrial Classification of All
     * Economic Activities (ISIC), Revision 4 code for a particular
     * gr:BusinessEntity or gr:Location. See
     * http://unstats.un.org/unsd/cr/registry/isic-4.asp for more
     * information.
     * <p>
     * Note: While ISIC codes are sometimes misused for
     * classifying products or services, they are designed and suited only
     * for classifying business establishments.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasISICv4">#hasISICv4</a>
     */
    public static final IRI hasISICv4;

    /**
     * has make and model (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasMakeAndModel}
     * <p>
     * This states that an actual product instance (gr:Individual) or a
     * placeholder instance for multiple, unidentified such instances
     * (gr:SomeItems) is one occurence of a particular
     * gr:ProductOrServiceModel.
     * <p>
     * Example: myFordT hasMakeAndModel FordT.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasMakeAndModel">#hasMakeAndModel</a>
     */
    public static final IRI hasMakeAndModel;

    /**
     * has manufacturer (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasManufacturer}
     * <p>
     * This object property links a gr:ProductOrService to the
     * gr:BusinessEntity that produces it. Mostly used with
     * gr:ProductOrServiceModel.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasManufacturer">#hasManufacturer</a>
     */
    public static final IRI hasManufacturer;

    /**
     * has max currency value (1..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasMaxCurrencyValue}
     * <p>
     * This property specifies the UPPER BOUND of the amount of money for a
     * price RANGE per unit, shipping charges, or payment charges. The
     * currency and other relevant details are attached to the respective
     * gr:PriceSpecification etc.
     * For a gr:UnitPriceSpecification, this is
     * the UPPER BOUND for the price for one unit or bundle (as specified in
     * the unit of measurement of the unit price specification) of the
     * respective gr:ProductOrService. For a gr:DeliveryChargeSpecification
     * or a gr:PaymentChargeSpecification, it is the UPPER BOUND of the price
     * per delivery or payment.
     * <p>
     * Using gr:hasCurrencyValue sets the upper and
     * lower bounds to the same given value, i.e., x gr:hasCurrencyValue y
     * implies x gr:hasMinCurrencyValue y, x gr:hasMaxCurrencyValue y.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasMaxCurrencyValue">#hasMaxCurrencyValue</a>
     */
    public static final IRI hasMaxCurrencyValue;

    /**
     * has max value (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasMaxValue}
     * <p>
     * This property captures the upper limit of a gr:QuantitativeValue
     * instance.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasMaxValue">#hasMaxValue</a>
     */
    public static final IRI hasMaxValue;

    /**
     * has max value float (1..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasMaxValueFloat}
     * <p>
     * This property captures the upper limit of a gr:QuantitativeValueFloat
     * instance.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasMaxValueFloat">#hasMaxValueFloat</a>
     */
    public static final IRI hasMaxValueFloat;

    /**
     * has max value integer (1..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasMaxValueInteger}
     * <p>
     * This property captures the upper limit of a
     * gr:QuantitativeValueInteger instance.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasMaxValueInteger">#hasMaxValueInteger</a>
     */
    public static final IRI hasMaxValueInteger;

    /**
     * has min currency value (1..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasMinCurrencyValue}
     * <p>
     * This property specifies the LOWER BOUND of the amount of money for a
     * price RANGE per unit, shipping charges, or payment charges. The
     * currency and other relevant details are attached to the respective
     * gr:PriceSpecification etc.
     * For a gr:UnitPriceSpecification, this is
     * the LOWER BOUND for the price for one unit or bundle (as specified in
     * the unit of measurement of the unit price specification) of the
     * respective gr:ProductOrService. For a gr:DeliveryChargeSpecification
     * or a gr:PaymentChargeSpecification, it is the LOWER BOUND of the price
     * per delivery or payment.
     * <p>
     * Using gr:hasCurrencyValue sets the upper and
     * lower bounds to the same given value, i.e., x gr:hasCurrencyValue y
     * implies x gr:hasMinCurrencyValue y, x gr:hasMaxCurrencyValue y.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasMinCurrencyValue">#hasMinCurrencyValue</a>
     */
    public static final IRI hasMinCurrencyValue;

    /**
     * has min value (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasMinValue}
     * <p>
     * This property captures the lower limit of a gr:QuantitativeValue
     * instance.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasMinValue">#hasMinValue</a>
     */
    public static final IRI hasMinValue;

    /**
     * has min value float (1..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasMinValueFloat}
     * <p>
     * This property captures the lower limit of a gr:QuantitativeValueFloat
     * instance.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasMinValueFloat">#hasMinValueFloat</a>
     */
    public static final IRI hasMinValueFloat;

    /**
     * has min value integer (1..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasMinValueInteger}
     * <p>
     * This property captures the lower limit of a
     * gr:QuantitativeValueInteger instance.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasMinValueInteger">#hasMinValueInteger</a>
     */
    public static final IRI hasMinValueInteger;

    /**
     * has MPN (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasMPN}
     * <p>
     * The Manufacturer Part Number or MPN is a unique identifier for a
     * product, service, or bundle from the perspective of a particular
     * manufacturer. MPNs can be assigned to products or product datasheets,
     * or bundles. Accordingly, the domain of this property is the union of
     * gr:ProductOrService (the common superclass of goods and datasheets),
     * and gr:Offering.
     * <p>
     * Important: Be careful when assuming two products or
     * services instances or offering instances to be identical based on the
     * MPN. Since MPNs are unique only for the same gr:BusinessEntity, this
     * holds only when the two MPN values refer to the same
     * gr:BusinessEntity. Such can be done by taking into account the
     * provenance of the data.
     * <p>
     * Usually, the properties gr:hasEAN_UCC-13 and
     * gr:hasGTIN-14 are much more reliable identifiers, because they are
     * globally unique.
     * <p>
     * See also http://en.wikipedia.org/wiki/Part_number
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasMPN">#hasMPN</a>
     */
    public static final IRI hasMPN;

    /**
     * has NAICS (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasNAICS}
     * <p>
     * The North American Industry Classification System (NAICS) code for a
     * particular gr:BusinessEntity.
     * See http://www.census.gov/eos/www/naics/
     * for more details.
     * <p>
     * Note: While NAICS codes are sometimes misused for
     * classifying products or services, they are designed and suited only
     * for classifying business establishments.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasNAICS">#hasNAICS</a>
     */
    public static final IRI hasNAICS;

    /**
     * has next (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasNext}
     * <p>
     * This ordering relation for gr:DayOfWeek indicates that the subject is
     * directly followed by the object.
     * <p>
     * Example: Monday hasNext
     * Tuesday
     * <p>
     * Since days of the week are a cycle, this property is not
     * transitive.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasNext">#hasNext</a>
     */
    public static final IRI hasNext;

    /**
     * has opening hours day of week (1..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasOpeningHoursDayOfWeek}
     * <p>
     * This specifies the gr:DayOfWeek to which the
     * gr:OpeningHoursSpecification is related.
     * <p>
     * Note: Use multiple instances
     * of gr:OpeningHoursSpecification for specifying the opening hours for
     * multiple days if the opening hours differ.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasOpeningHoursDayOfWeek">#hasOpeningHoursDayOfWeek</a>
     */
    public static final IRI hasOpeningHoursDayOfWeek;

    /**
     * has opening hours specification (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasOpeningHoursSpecification}
     * <p>
     * This property links a gr:Location to a gr:OpeningHoursSpecification.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasOpeningHoursSpecification">#hasOpeningHoursSpecification</a>
     */
    public static final IRI hasOpeningHoursSpecification;

    /**
     * has POS (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasPOS}
     * <p>
     * This property states that the respective gr:Location is a point of
     * sale for the respective gr:BusinessEntity. It allows linking those two
     * types of entities without the need for a particular gr:Offering.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasPOS">#hasPOS</a>
     */
    public static final IRI hasPOS;

    /**
     * has previous (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasPrevious}
     * <p>
     * This ordering relation for gr:DayOfWeek indicates that the subject is
     * directly preceeded by the object.
     * <p>
     * Example: Tuesday hasPrevious
     * Monday
     * <p>
     * Since days of the week are a cycle, this property is not
     * transitive.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasPrevious">#hasPrevious</a>
     */
    public static final IRI hasPrevious;

    /**
     * has price specification (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasPriceSpecification}
     * <p>
     * This links a gr:Offering to a gr:PriceSpecification or specifications.
     * There can be unit price specifications, payment charge specifications,
     * and delivery charge specifications. For each type, multiple
     * specifications for the same gr:Offering are possible, e.g. for
     * different quantity ranges or for different currencies, or for
     * different combinations of gr:DeliveryMethod and target
     * destinations.
     * <p>
     * Recommended retail prices etc. can be marked by the
     * gr:priceType property of the gr:UnitPriceSpecification.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasPriceSpecification">#hasPriceSpecification</a>
     */
    public static final IRI hasPriceSpecification;

    /**
     * has Stock Keeping Unit (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasStockKeepingUnit}
     * <p>
     * The Stock Keeping Unit, or SKU is a unique identifier for a product,
     * service, or bundle from the perspective of a particular supplier, i.e.
     * SKUs are mostly assigned and serialized at the merchant level.
     * <p>
     * Examples of SKUs are the ordering or parts numbers used by a
     * particular Web shop or catalog.
     * <p>
     * Consequently, the domain of
     * gr:hasStockKeepingUnit is the union of the classes gr:Offering and
     * gr:ProductOrService.
     * If attached to a gr:Offering, the SKU will
     * usually reflect a merchant-specific identifier, i.e. one valid only
     * for that particular retailer or shop.
     * If attached to a
     * gr:ProductOrServiceModel, the SKU can reflect either the identifier
     * used by the merchant or the part number used by the official
     * manufacturer of that part. For the latter, gr:hasMPN is a better
     * choice.
     * <p>
     * Important: Be careful when assuming two products or services
     * instances or offering instances to be identical based on the SKU.
     * Since SKUs are unique only for the same gr:BusinessEntity, this can be
     * assumed only when you are sure that the two SKU values refer to the
     * same business entity. Such can be done by taking into account the
     * provenance of the data. As long as instances of gr:Offering are
     * concerned, you can also check that the offerings are being offered by
     * the same gr:Business Entity.
     * <p>
     * Usually, the properties gr:hasEAN_UCC-13
     * and gr:hasGTIN-14 are much more reliable identifiers, because they are
     * globally unique.
     * <p>
     * See also
     * http://en.wikipedia.org/wiki/Stock_Keeping_Unit.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasStockKeepingUnit">#hasStockKeepingUnit</a>
     */
    public static final IRI hasStockKeepingUnit;

    /**
     * has unit of measurement (1..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasUnitOfMeasurement}
     * <p>
     * The unit of measurement for a gr:QuantitativeValue, a
     * gr:UnitPriceSpecification, or a gr:TypeAndQuantityNode given using the
     * UN/CEFACT Common Code (3 characters).
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasUnitOfMeasurement">#hasUnitOfMeasurement</a>
     */
    public static final IRI hasUnitOfMeasurement;

    /**
     * has value (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasValue}
     * <p>
     * This subproperty specifies that the upper and lower limit of the given
     * gr:QuantitativeValue are identical and have the respective value. It
     * is a shortcut for such cases where a quantitative property is (at
     * least practically) a single point value and not an interval.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasValue">#hasValue</a>
     */
    public static final IRI hasValue;

    /**
     * has value float (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasValueFloat}
     * <p>
     * This subproperty specifies that the upper and lower limit of the given
     * gr:QuantitativeValueFloat are identical and have the respective float
     * value. It is a shortcut for such cases where a quantitative property
     * is (at least practically) a single point value and not an interval.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasValueFloat">#hasValueFloat</a>
     */
    public static final IRI hasValueFloat;

    /**
     * has value integer (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasValueInteger}
     * <p>
     * This subproperty specifies that the upper and lower limit of the given
     * gr:QuantitativeValueInteger are identical and have the respective
     * integer value. It is a shortcut for such cases where a quantitative
     * property is (at least practically) a single point value and not an
     * interval.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasValueInteger">#hasValueInteger</a>
     */
    public static final IRI hasValueInteger;

    /**
     * has warranty promise (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasWarrantyPromise}
     * <p>
     * This specifies the gr:WarrantyPromise made by the gr:BusinessEntity
     * for the given gr:Offering.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasWarrantyPromise">#hasWarrantyPromise</a>
     */
    public static final IRI hasWarrantyPromise;

    /**
     * has warranty scope (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#hasWarrantyScope}
     * <p>
     * This states the gr:WarrantyScope of a given gr:WarrantyPromise.
     *
     * @see <a href="http://purl.org/goodrelations/v1#hasWarrantyScope">#hasWarrantyScope</a>
     */
    public static final IRI hasWarrantyScope;

    /**
     * height (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#height}
     * <p>
     * The height of the product.
     * Typical unit code(s): CMT for centimeters,
     * INH for inches
     *
     * @see <a href="http://purl.org/goodrelations/v1#height">#height</a>
     */
    public static final IRI height;

    /**
     * includes (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#includes}
     * <p>
     * This object property is a shortcut for the original gr:includesObject
     * property for the common case of having exactly one single
     * gr:ProductOrService instance included in an Offering.
     * <p>
     * When linking
     * to an instance of gr:SomeItems or gr:Individual, it is equivalent to
     * using a gr:TypeAndQuantityNode with
     * gr:hasUnitOfMeasurement=&quot;C62&quot;^^xsd:string and
     * gr:amountOfThisGood=&quot;1.0&quot;^^xsd:float for that good.
     * <p>
     * When
     * linking to a gr:ProductOrServiceModel, it is equivalent to
     * 1.
     * defining an blank node for a gr:SomeItems
     * 2. linking that blank node
     * via gr:hasMakeAndModel to the gr:ProductOrServiceModel, and
     * 3. linking
     * from the gr:Offering to that blank node using another blank node of
     * type gr:TypeAndQuantityNode with
     * gr:hasUnitOfMeasurement=&quot;C62&quot;^^xsd:string and
     * gr:amountOfThisGood=&quot;1.0&quot;^^xsd:float for that good.
     *
     * @see <a href="http://purl.org/goodrelations/v1#includes">#includes</a>
     */
    public static final IRI includes;

    /**
     * includes object (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#includesObject}
     * <p>
     * This object property links a gr:Offering to one or multiple
     * gr:TypeAndQuantityNode or nodes that specify the components that are
     * included in the respective offer.
     *
     * @see <a href="http://purl.org/goodrelations/v1#includesObject">#includesObject</a>
     */
    public static final IRI includesObject;

    /**
     * Individual
     * <p>
     * {@code http://purl.org/goodrelations/v1#Individual}
     * <p>
     * A gr:Individual is an actual product or service instance, i.e., a
     * single identifiable object or action that creates some increase in
     * utility (in the economic sense) for the individual possessing or using
     * this very object (product) or for the individual in whose favor this
     * very action is being taken (service). Products or services are types
     * of goods in the economic sense. For an overview of goods and
     * commodities in economics, see Milgate (1987).
     * <p>
     * Examples: MyThinkpad
     * T60, the pint of beer standing in front of me, my Volkswagen Golf, the
     * haircut that I received or will be receiving at a given date and
     * time.
     * <p>
     * Note 1: In many cases, product or service instances are not
     * explicitly exposed on the Web but only claimed to exist (i.e.
     * existentially quantified). In this case, use gr:SomeItems.
     * Note 2:
     * This class is the new, shorter form of the former
     * gr:ActualProductOrServiceInstance.
     * <p>
     * Compatibility with schema.org:
     * This class is a subclass of http://schema.org/Product.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Individual">#Individual</a>
     */
    public static final IRI Individual;

    /**
     * is accessory or spare part for (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#isAccessoryOrSparePartFor}
     * <p>
     * This states that a particular gr:ProductOrService is an accessory or
     * spare part for another product or service.
     *
     * @see <a href="http://purl.org/goodrelations/v1#isAccessoryOrSparePartFor">#isAccessoryOrSparePartFor</a>
     */
    public static final IRI isAccessoryOrSparePartFor;

    /**
     * is consumable for (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#isConsumableFor}
     * <p>
     * This states that a particular gr:ProductOrService is a consumable for
     * another product or service.
     *
     * @see <a href="http://purl.org/goodrelations/v1#isConsumableFor">#isConsumableFor</a>
     */
    public static final IRI isConsumableFor;

    /**
     * is list price (DEPRECATED)
     * <p>
     * {@code http://purl.org/goodrelations/v1#isListPrice}
     * <p>
     * This boolean attribute indicates whether a gr:UnitPriceSpecification
     * is a list price (usually a vendor recommendation) or not.
     * &quot;true&quot;  indicates it is a list price, &quot;false&quot;
     * indicates it is not.
     * DEPRECATED. Use the gr:priceType property
     * instead.
     *
     * @see <a href="http://purl.org/goodrelations/v1#isListPrice">#isListPrice</a>
     */
    public static final IRI isListPrice;

    /**
     * is similar to (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#isSimilarTo}
     * <p>
     * This states that a given gr:ProductOrService is similar to another
     * product or service. Of course, this is a subjective statement; when
     * interpreting it, the trust in the origin of the statement should be
     * taken into account.
     *
     * @see <a href="http://purl.org/goodrelations/v1#isSimilarTo">#isSimilarTo</a>
     */
    public static final IRI isSimilarTo;

    /**
     * is variant of (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#isVariantOf}
     * <p>
     * This states that a particular gr:ProductOrServiceModel is a variant of
     * another product or service model. It is pretty safe to infer that the
     * variant inherits all gr:quantitativeProductOrServiceProperty,
     * gr:qualitativeProductOrServiceProperty, and
     * gr:datatypeProductOrServiceProperty values that are defined for the
     * first gr:ProductOrServiceModel.
     * <p>
     * Example:
     * foo:Red_Ford_T_Model
     * gr:isVariantOf foo:Ford_T_Model
     *
     * @see <a href="http://purl.org/goodrelations/v1#isVariantOf">#isVariantOf</a>
     */
    public static final IRI isVariantOf;

    /**
     * JCB (payment method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#JCB}
     * <p>
     * Payment by credit or debit cards issued by the JCB network.
     *
     * @see <a href="http://purl.org/goodrelations/v1#JCB">#JCB</a>
     */
    public static final IRI JCB;

    /**
     * Labor / bring-in (warranty scope)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Labor-BringIn}
     * <p>
     * In case of a defect or malfunction, the buying party has the right to
     * transport the good to a service location determined by the the selling
     * gr:BusinessEntity and will be charged only for parts and materials
     * needed to fix the problem. Labor will be covered by the selling
     * business entity or one of its partnering business entities.
     * <p>
     * Note:
     * This is just a rough classification for filtering offers. It is up to
     * the buying party to check the exact scope and terms and conditions of
     * the gr:WarrantyPromise.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Labor-BringIn">#Labor-BringIn</a>
     */
    public static final IRI Labor_BringIn;

    /**
     * Lease Out (business function)
     * <p>
     * {@code http://purl.org/goodrelations/v1#LeaseOut}
     * <p>
     * This gr:BusinessFunction indicates that the gr:BusinessEntity offers
     * (or seeks) the temporary right to use the specified
     * gr:ProductOrService.
     *
     * @see <a href="http://purl.org/goodrelations/v1#LeaseOut">#LeaseOut</a>
     */
    public static final IRI LeaseOut;

    /**
     * legal name (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#legalName}
     * <p>
     * The legal name of the gr:BusinessEntity.
     *
     * @see <a href="http://purl.org/goodrelations/v1#legalName">#legalName</a>
     */
    public static final IRI legalName;

    /**
     * lesser (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#lesser}
     * <p>
     * This ordering relation for gr:QualitativeValue pairs indicates that
     * the subject is lesser than the object.
     *
     * @see <a href="http://purl.org/goodrelations/v1#lesser">#lesser</a>
     */
    public static final IRI lesser;

    /**
     * lesser or equal (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#lesserOrEqual}
     * <p>
     * This ordering relation for gr:QualitativeValue pairs indicates that
     * the subject is lesser than or equal to the object.
     *
     * @see <a href="http://purl.org/goodrelations/v1#lesserOrEqual">#lesserOrEqual</a>
     */
    public static final IRI lesserOrEqual;

    /**
     * License
     * <p>
     * {@code http://purl.org/goodrelations/v1#License}
     * <p>
     * A license is the specification of a bundle of rights that determines
     * the type of activity or access offered by the gr:BusinessEntity on the
     * gr:ProductOrService through the gr:Offering.
     * <p>
     * Licenses can be
     * standardized (e.g. LPGL, Creative Commons, ...), vendor-specific, or
     * individually defined for a single offer or product. Whether there is a
     * fee for obtaining the license is specified using the
     * gr:UnitPriceSpecification attached to the gr:Offering. Use foaf:page
     * for linking to a document containing the license, e.g. in PDF or HTML.
     *
     * @see <a href="http://purl.org/goodrelations/v1#License">#License</a>
     */
    public static final IRI License;

    /**
     * Location
     * <p>
     * {@code http://purl.org/goodrelations/v1#Location}
     * <p>
     * A location is a point or area of interest from which a particular
     * product or service is available, e.g. a store, a bus stop, a gas
     * station, or a ticket booth. The difference to gr:BusinessEntity is
     * that the gr:BusinessEntity is the legal entity (e.g. a person or
     * corporation) making the offer, while gr:Location is the store, office,
     * or place. A chain restaurant will e.g. have one legal entity but
     * multiple restaurant locations. Locations are characterized by an
     * address or geographical position and a set of opening hour
     * specifications for various days of the week.
     * <p>
     * Example: A rental car
     * company may offer the Business Function Lease Out of cars from two
     * locations, one in Fort Myers, Florida, and one in Boston,
     * Massachussetts. Both stations are open 7:00 - 23:00 Mondays through
     * Saturdays.
     * <p>
     * Note: Typical address standards (vcard) and location data
     * (geo, WGC84) should be attached to a gr:Location node. Since there
     * already exist established vocabularies for this, the GoodRelations
     * ontology does not provide respective attributes. Instead, the use of
     * respective vocabularies is recommended. However, the
     * gr:hasGlobalLocationNumber property is  provided for linking to public
     * identifiers for business locations.
     * <p>
     * Compatibility with schema.org:
     * This class is equivalent to http://schema.org/Place.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Location">#Location</a>
     */
    public static final IRI Location;

    /**
     * Location of sales or service provisioning (DEPRECATED)
     * <p>
     * {@code http://purl.org/goodrelations/v1#LocationOfSalesOrServiceProvisioning}
     * <p>
     * DEPRECATED - This class is superseded by gr:Location. Replace all
     * occurrences of gr:LocationOfSalesOrServiceProvisioning by gr:Location,
     * if possible.
     *
     * @see <a href="http://purl.org/goodrelations/v1#LocationOfSalesOrServiceProvisioning">#LocationOfSalesOrServiceProvisioning</a>
     */
    public static final IRI LocationOfSalesOrServiceProvisioning;

    /**
     * Maintain (business function)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Maintain}
     * <p>
     * This gr:BusinessFunction indicates that the gr:BusinessEntity offers
     * (or seeks) typical maintenance tasks for the specified
     * gr:ProductOrService. Maintenance tasks are actions that undo or
     * compensate for wear or other deterioriation caused by regular usage,
     * in order to restore the originally intended function of the product,
     * or to prevent outage or malfunction.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Maintain">#Maintain</a>
     */
    public static final IRI Maintain;

    /**
     * MasterCard (payment method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#MasterCard}
     * <p>
     * Payment by credit or debit cards issued by the MasterCard network.
     *
     * @see <a href="http://purl.org/goodrelations/v1#MasterCard">#MasterCard</a>
     */
    public static final IRI MasterCard;

    /**
     * Monday (day of week)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Monday}
     * <p>
     * Monday as a day of the week.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Monday">#Monday</a>
     */
    public static final IRI Monday;

    /**
     * N-ary relations (DEPRECATED)
     * <p>
     * {@code http://purl.org/goodrelations/v1#N-Ary-Relations}
     * <p>
     * This is the superclass for all classes that are placeholders for n-ary
     * relations, which OWL cannot represent.
     * DEPRECATED. Do not use this
     * class in data or queries.
     *
     * @see <a href="http://purl.org/goodrelations/v1#N-Ary-Relations">#N-Ary-Relations</a>
     */
    public static final IRI N_Ary_Relations;

    /**
     * name (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#name}
     * <p>
     * A short text describing the respective resource.
     * <p>
     * This property is
     * semantically equivalent to dcterms:title and rdfs:label and just meant
     * as a handy shortcut for marking up data.
     *
     * @see <a href="http://purl.org/goodrelations/v1#name">#name</a>
     */
    public static final IRI name;

    /**
     * non equal (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#nonEqual}
     * <p>
     * This ordering relation for gr:QualitativeValue pairs indicates that
     * the subject is not equal to the object.
     *
     * @see <a href="http://purl.org/goodrelations/v1#nonEqual">#nonEqual</a>
     */
    public static final IRI nonEqual;

    /**
     * Offering
     * <p>
     * {@code http://purl.org/goodrelations/v1#Offering}
     * <p>
     * An offering represents the public, not necessarily binding, not
     * necessarily exclusive, announcement by a gr:BusinessEntity to provide
     * (or seek) a certain gr:BusinessFunction for a certain
     * gr:ProductOrService to a specified target audience. An offering is
     * specified by the type of product or service or bundle it refers to,
     * what business function is being offered (sales, rental, ...), and a
     * set of commercial properties. It can either refer to
     * (1) a clearly
     * specified instance (gr:Individual),
     * (2) to a set of anonymous
     * instances of a given type (gr:SomeItems),
     * (3) a product model
     * specification (gr:ProductOrServiceModel), see also section 3.3.3 of
     * the GoodRelations Technical Report.
     * <p>
     * An offering may be constrained
     * in terms of the eligible type of business partner, countries,
     * quantities, and other commercial properties. The definition of the
     * commercial properties, the type of product offered, and the business
     * function are explained in other parts of this vocabulary in more
     * detail.
     * <p>
     * Example: Peter Miller offers to repair TV sets made by
     * Siemens, Volkswagen Innsbruck sells a particular instance of a
     * Volkswagen Golf at $10,000.
     * <p>
     * Compatibility with schema.org: This class
     * is a superclass to http://schema.org/Offer, since gr:Offering can also
     * represent demand.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Offering">#Offering</a>
     */
    public static final IRI Offering;

    /**
     * offers (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#offers}
     * <p>
     * This links a gr:BusinessEntity to the offers (gr:Offering) it makes.
     * If you want to express interest in receiving offers, use gr:seeks
     * instead.
     *
     * @see <a href="http://purl.org/goodrelations/v1#offers">#offers</a>
     */
    public static final IRI offers;

    /**
     * Opening hours specification
     * <p>
     * {@code http://purl.org/goodrelations/v1#OpeningHoursSpecification}
     * <p>
     * This is a conceptual entity that holds together all information about
     * the opening hours on a given day (gr:DayOfWeek).
     *
     * @see <a href="http://purl.org/goodrelations/v1#OpeningHoursSpecification">#OpeningHoursSpecification</a>
     */
    public static final IRI OpeningHoursSpecification;

    /**
     * opens (1..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#opens}
     * <p>
     * The opening hour of the gr:Location on the given gr:DayOfWeek.
     * If no
     * time-zone suffix is included, the time is given in the local time
     * valid at the gr:Location.
     * <p>
     * For a time in GMT/UTC, simply add a
     * &quot;Z&quot; following the time:
     * <p>
     * 09:30:10Z.
     * <p>
     * Alternatively, you can
     * specify an offset from the UTC time by adding a positive or negative
     * time following the time:
     * <p>
     * 09:30:10-09:00
     * <p>
     * or
     * <p>
     * 09:30:10+09:00.
     * <p>
     * Note 1:
     * Use 00:00:00 for the first second of the respective day and 23:59:59
     * for the last second of that day.
     * Note 2: If a store opens at 17:00 on
     * Saturdays and closes at 03:00:00 a.m. next morning, use 17:00:00 -
     * 23:59:59 for Saturday and 00:00:00 - 03:00:00 for Sunday.
     * Note 3: If
     * the shop re-opens on the same day of the week or set of days of the
     * week, you must create a second instance of
     * gr:OpeningHoursSpecification.
     *
     * @see <a href="http://purl.org/goodrelations/v1#opens">#opens</a>
     */
    public static final IRI opens;

    /**
     * owns (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#owns}
     * <p>
     * This property indicates that a particular person or business owns a
     * particular product. It can be used to expose the products in one&#39;s
     * posession in order to empower recommender systems to suggest matching
     * offers.
     * <p>
     * Note that the product must be an instance of the class
     * gr:Individual.
     * <p>
     * This property can also be safely applied to foaf:Agent
     * instances.
     *
     * @see <a href="http://purl.org/goodrelations/v1#owns">#owns</a>
     */
    public static final IRI owns;

    /**
     * Parts and labor / bring-in (warranty scope)
     * <p>
     * {@code http://purl.org/goodrelations/v1#PartsAndLabor-BringIn}
     * <p>
     * In case of a defect or malfunction, the buying party has the right to
     * transport the good to a service location determined by the the selling
     * gr:BusinessEntity and will not be be charged for labor, parts, and
     * materials needed to fix the problem. All those costs will be covered
     * by the selling business entity or one of its partnering business
     * entities.
     * <p>
     * Note: This is just a rough classification for filtering
     * offers. It is up to the buying party to check the exact scope and
     * terms and conditions of the gr:WarrantyPromise.
     *
     * @see <a href="http://purl.org/goodrelations/v1#PartsAndLabor-BringIn">#PartsAndLabor-BringIn</a>
     */
    public static final IRI PartsAndLabor_BringIn;

    /**
     * Parts and labor / pick up (warranty scope)
     * <p>
     * {@code http://purl.org/goodrelations/v1#PartsAndLabor-PickUp}
     * <p>
     * In case of a defect or malfunction, the buying party has the right to
     * request from the selling gr:Business Entity to pick-up the good from
     * its current location to a suitable service location, where the
     * functionality of the good will be restored. All transportation, labor,
     * parts, and materials needed to fix the problem will be covered by the
     * selling business entity or one of its partnering business entities.
     * <p>
     * <p>
     * Note: This is just a rough classification for filtering offers. It is
     * up to the buying party to check the exact scope and terms and
     * conditions of the gr:WarrantyPromise.
     *
     * @see <a href="http://purl.org/goodrelations/v1#PartsAndLabor-PickUp">#PartsAndLabor-PickUp</a>
     */
    public static final IRI PartsAndLabor_PickUp;

    /**
     * Payment charge specification
     * <p>
     * {@code http://purl.org/goodrelations/v1#PaymentChargeSpecification}
     * <p>
     * A payment charge specification is a conceptual entity that specifies
     * the additional costs asked for settling the payment after accepting a
     * given gr:Offering using a particular gr:PaymentMethod. A payment
     * charge specification is characterized by (1) a monetary amount per
     * order specified as a literal value of type float in combination with a
     * Currency, (2) the payment method, and (3) a whether this charge
     * includes local sales taxes, namely VAT.
     * A gr:Offering may be linked to
     * multiple payment charge specifications that specify alternative
     * charges for various payment methods.
     * <p>
     * Examples: Payment by VISA or
     * Mastercard costs a fee of 3 Euros including VAT, payment by bank
     * transfer in advance is free of charge.
     * <p>
     * The total amount of this
     * surcharge is specified as a float value of the gr:hasCurrencyValue
     * property. The currency is specified via the gr:hasCurrency datatype
     * property. Whether the price includes VAT or not is indicated by the
     * gr:valueAddedTaxIncluded datatype property. The gr:PaymentMethod to
     * which this charge applies is specified using the
     * gr:appliesToPaymentMethod object property.
     * <p>
     * If the price can only be
     * given as a range, use gr:hasMaxCurrencyValue and
     * gr:hasMinCurrencyValue for the upper and lower bounds.
     * <p>
     * Important:
     * When querying for the price, always use gr:hasMaxCurrencyValue and
     * gr:hasMinCurrencyValue.
     *
     * @see <a href="http://purl.org/goodrelations/v1#PaymentChargeSpecification">#PaymentChargeSpecification</a>
     */
    public static final IRI PaymentChargeSpecification;

    /**
     * Payment method
     * <p>
     * {@code http://purl.org/goodrelations/v1#PaymentMethod}
     * <p>
     * A payment method is a standardized procedure for transferring the
     * monetary amount for a purchase. Payment methods are characterized by
     * the legal and technical structures used, and by the organization or
     * group carrying out the transaction. This element is mostly used for
     * specifying the types of payment accepted by a
     * gr:BusinessEntity.
     * <p>
     * Examples: VISA, MasterCard, Diners, cash, or bank
     * transfer in advance.
     *
     * @see <a href="http://purl.org/goodrelations/v1#PaymentMethod">#PaymentMethod</a>
     */
    public static final IRI PaymentMethod;

    /**
     * Payment method credit card
     * <p>
     * {@code http://purl.org/goodrelations/v1#PaymentMethodCreditCard}
     * <p>
     * The subclass of gr:PaymentMethod represents all variants and brands of
     * credit or debit cards as a standardized procedure for transferring the
     * monetary amount for a purchase. It is mostly used for specifying the
     * types of payment accepted by a gr:Business Entity.
     * <p>
     * Examples: VISA,
     * MasterCard, or American Express.
     *
     * @see <a href="http://purl.org/goodrelations/v1#PaymentMethodCreditCard">#PaymentMethodCreditCard</a>
     */
    public static final IRI PaymentMethodCreditCard;

    /**
     * PayPal (payment method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#PayPal}
     * <p>
     * Payment via the PayPal payment service.
     *
     * @see <a href="http://purl.org/goodrelations/v1#PayPal">#PayPal</a>
     */
    public static final IRI PayPal;

    /**
     * PaySwarm (payment method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#PaySwarm}
     * <p>
     * Payment via the PaySwarm distributed micropayment service.
     *
     * @see <a href="http://purl.org/goodrelations/v1#PaySwarm">#PaySwarm</a>
     */
    public static final IRI PaySwarm;

    /**
     * predecessor of (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#predecessorOf}
     * <p>
     * This property indicates that the subject is a previous, often
     * discontinued variant of the gr:ProductOrServiceModel used as the
     * object.
     * <p>
     * Example: Golf III predecessorOf Golf IV
     * <p>
     * This relation is
     * transitive.
     *
     * @see <a href="http://purl.org/goodrelations/v1#predecessorOf">#predecessorOf</a>
     */
    public static final IRI predecessorOf;

    /**
     * Price specification
     * <p>
     * {@code http://purl.org/goodrelations/v1#PriceSpecification}
     * <p>
     * The superclass of all price specifications.
     *
     * @see <a href="http://purl.org/goodrelations/v1#PriceSpecification">#PriceSpecification</a>
     */
    public static final IRI PriceSpecification;

    /**
     * price type (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#priceType}
     * <p>
     * This attribute can be used to distinguish multiple different price
     * specifications for the same gr:Offering. It supersedes the former
     * gr:isListPrice property. The following values are recommended:
     * <p>
     * The
     * absence of this property marks the actual sales price.
     * <p>
     * SRP:
     * &quot;suggested retail price&quot; - applicable for all sorts of a
     * non-binding retail price recommendations, e.g. such published by the
     * manufacturer or the distributor. This value replaces the former
     * gr:isListPrice property.
     * <p>
     * INVOICE: The invoice price, mostly used in
     * the car industry - this is the price a dealer pays to the
     * manufacturer, excluding rebates and charges.
     *
     * @see <a href="http://purl.org/goodrelations/v1#priceType">#priceType</a>
     */
    public static final IRI priceType;

    /**
     * Product or service
     * <p>
     * {@code http://purl.org/goodrelations/v1#ProductOrService}
     * <p>
     * The superclass of all classes describing products or services types,
     * either by nature or purpose. Examples for such subclasses are &quot;TV
     * set&quot;, &quot;vacuum cleaner&quot;, etc. An instance of this class
     * can be either an actual product or service (gr:Individual), a
     * placeholder instance for unknown instances of a mass-produced
     * commodity (gr:SomeItems), or a model / prototype specification
     * (gr:ProductOrServiceModel). When in doubt, use
     * gr:SomeItems.
     * <p>
     * Examples:
     * a) MyCellphone123, i.e. my personal,
     * tangible cell phone (gr:Individual)
     * b) Siemens1234, i.e. the Siemens
     * cell phone make and model 1234 (gr:ProductOrServiceModel)
     * c)
     * dummyCellPhone123 as a placeholder for actual instances of a certain
     * kind of cell phones (gr:SomeItems)
     * <p>
     * Note: Your first choice for
     * specializations of gr:ProductOrService should be
     * http://www.productontology.org.
     * <p>
     * Compatibility with schema.org: This
     * class is (approximately) equivalent to http://schema.org/Product.
     *
     * @see <a href="http://purl.org/goodrelations/v1#ProductOrService">#ProductOrService</a>
     */
    public static final IRI ProductOrService;

    /**
     * Product or service model
     * <p>
     * {@code http://purl.org/goodrelations/v1#ProductOrServiceModel}
     * <p>
     * A product or service model is a intangible entity that specifies some
     * characteristics of a group of similar, usually mass-produced products,
     * in the sense of a prototype. In case of mass-produced products, there
     * exists a relation gr:hasMakeAndModel between the actual product or
     * service (gr:Individual or gr:SomeItems) and the prototype
     * (gr:ProductOrServiceModel). GoodRelations treats product or service
     * models as &quot;prototypes&quot; instead of a completely separate kind
     * of entities, because this allows using the same domain-specific
     * properties (e.g. gr:weight) for describing makes and models and for
     * describing actual products.
     * <p>
     * Examples: Ford T, Volkswagen Golf, Sony
     * Ericsson W123 cell phone
     * <p>
     * Note: An actual product or service
     * (gr:Individual) by default shares the features of its model (e.g. the
     * weight). However, this requires non-standard reasoning. See
     * http://wiki.goodrelations-vocabulary.org/Axioms for respective rule
     * sets.
     * <p>
     * Compatibility with schema.org: This class is (approximately) a
     * subclass of http://schema.org/Product.
     *
     * @see <a href="http://purl.org/goodrelations/v1#ProductOrServiceModel">#ProductOrServiceModel</a>
     */
    public static final IRI ProductOrServiceModel;

    /**
     * Product or services some instances placeholder (DEPRECATED)
     * <p>
     * {@code http://purl.org/goodrelations/v1#ProductOrServicesSomeInstancesPlaceholder}
     * <p>
     * DEPRECATED - This class is superseded by gr:SomeItems. Replace all
     * occurrences of gr:ProductOrServicesSomeInstancesPlaceholder by
     * gr:SomeItems, if possible.
     *
     * @see <a href="http://purl.org/goodrelations/v1#ProductOrServicesSomeInstancesPlaceholder">#ProductOrServicesSomeInstancesPlaceholder</a>
     */
    public static final IRI ProductOrServicesSomeInstancesPlaceholder;

    /**
     * Provide service (business function)
     * <p>
     * {@code http://purl.org/goodrelations/v1#ProvideService}
     * <p>
     * This gr:BusinessFunction indicates that the gr:BusinessEntity offers
     * (or seeks) the respective type of service.
     * <p>
     * Note: Maintain and Repair
     * are also types of Services. However, products and services ontologies
     * often provide classes for tangible products as well as for types of
     * services. The business function gr:ProvideService is to be used with
     * such goods that are services, while gr:Maintain and gr:Repair can be
     * used with goods for which only the class of product exists in the
     * ontology, but not the respective type of service.
     * <p>
     * Example: Car
     * maintenance could be expressed both as &quot;provide the service car
     * maintenance&quot; or &quot;maintain cars&quot;.
     *
     * @see <a href="http://purl.org/goodrelations/v1#ProvideService">#ProvideService</a>
     */
    public static final IRI ProvideService;

    /**
     * Public holidays (day of week)
     * <p>
     * {@code http://purl.org/goodrelations/v1#PublicHolidays}
     * <p>
     * A placeholder for all official public holidays at the gr:Location.
     * This allows specifying the opening hours on public holidays. If a
     * given day is a public holiday, this specification supersedes the
     * opening hours for the respective day of the week.
     *
     * @see <a href="http://purl.org/goodrelations/v1#PublicHolidays">#PublicHolidays</a>
     */
    public static final IRI PublicHolidays;

    /**
     * Public institution (business entity type)
     * <p>
     * {@code http://purl.org/goodrelations/v1#PublicInstitution}
     * <p>
     * The gr:BusinessEntityType representing such agents that are part of
     * the adminstration or owned by the public.
     *
     * @see <a href="http://purl.org/goodrelations/v1#PublicInstitution">#PublicInstitution</a>
     */
    public static final IRI PublicInstitution;

    /**
     * qualitative product or service property (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#qualitativeProductOrServiceProperty}
     * <p>
     * This is the super property of all qualitative properties for products
     * and services. All properties in product or service ontologies for
     * which gr:QualitativeValue instances are specified are subproperties of
     * this property.
     *
     * @see <a href="http://purl.org/goodrelations/v1#qualitativeProductOrServiceProperty">#qualitativeProductOrServiceProperty</a>
     */
    public static final IRI qualitativeProductOrServiceProperty;

    /**
     * Qualitative value
     * <p>
     * {@code http://purl.org/goodrelations/v1#QualitativeValue}
     * <p>
     * A qualitative value is a predefined value for a product
     * characteristic.
     * <p>
     * Examples: the color &quot;green&quot; or the power
     * cord plug type &quot;US&quot;; the garment sizes &quot;S&quot;,
     * &quot;M&quot;, &quot;L&quot;, and &quot;XL&quot;.
     * <p>
     * Note: Value sets
     * are supported by creating subclasses of this class. Ordinal relations
     * between values (gr:greater, gr:lesser, ...) are provided directly by
     * GoodRelations.
     * <p>
     * Compatibility with schema.org: This class is
     * equivalent to http://schema.org/Enumeration.
     *
     * @see <a href="http://purl.org/goodrelations/v1#QualitativeValue">#QualitativeValue</a>
     */
    public static final IRI QualitativeValue;

    /**
     * quantitative product or service property (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#quantitativeProductOrServiceProperty}
     * <p>
     * This is the super property of all quantitative  properties for
     * products and services. All properties in product or service ontologies
     * that specify quantitative characteristics, for which an interval is at
     * least theoretically an appropriate value, are subproperties of this
     * property.
     *
     * @see <a href="http://purl.org/goodrelations/v1#quantitativeProductOrServiceProperty">#quantitativeProductOrServiceProperty</a>
     */
    public static final IRI quantitativeProductOrServiceProperty;

    /**
     * Quantitative value
     * <p>
     * {@code http://purl.org/goodrelations/v1#QuantitativeValue}
     * <p>
     * A quantitative value is a numerical interval that represents the range
     * of a certain gr:quantitativeProductOrServiceProperty in terms of the
     * lower and upper bounds for a particular gr:ProductOrService. It is to
     * be interpreted in combination with the respective unit of measurement.
     * Most quantitative values are intervals even if they are in practice
     * often treated as a single point value.
     * <p>
     * Example: a weight between 10
     * and 25 kilogramms, a length between 10 and 15
     * milimeters.
     * <p>
     * Compatibility with schema.org: This class is equivalent
     * to http://schema.org/Quantity.
     *
     * @see <a href="http://purl.org/goodrelations/v1#QuantitativeValue">#QuantitativeValue</a>
     */
    public static final IRI QuantitativeValue;

    /**
     * Quantitative value float
     * <p>
     * {@code http://purl.org/goodrelations/v1#QuantitativeValueFloat}
     * <p>
     * An instance of this class is an actual float value for a quantitative
     * property of a product. This instance is usually characterized by a
     * minimal value, a maximal value, and a unit of measurement.
     * <p>
     * Examples:
     * The intervals &quot;between 10.0  and 25.4 kilogramms&quot; or
     * &quot;10.2 and 15.5 milimeters&quot;.
     * <p>
     * Compatibility with schema.org:
     * This class is a subclass of http://schema.org/Quantity.
     *
     * @see <a href="http://purl.org/goodrelations/v1#QuantitativeValueFloat">#QuantitativeValueFloat</a>
     */
    public static final IRI QuantitativeValueFloat;

    /**
     * Quantitative value integer
     * <p>
     * {@code http://purl.org/goodrelations/v1#QuantitativeValueInteger}
     * <p>
     * An instance of this class is an actual integer value for a
     * quantitative property of a product. This instance is usually
     * characterized by a minimal value, a maximal value, and a unit of
     * measurement.
     * <p>
     * Example: A seating capacity between 1 and 8
     * persons.
     * <p>
     * Note: Users must keep in mind that ranges in here mean that
     * ALL possible values in this interval are covered. (Sometimes, the
     * actual commitment may be less than that: &quot;We sell cars from 2 -
     * 12 seats&quot; does often not really mean that they have cars with
     * 2,3,4,...12 seats.). Someone renting out two types of rowing boats,
     * one that fits for 1 or 2 people, and another that must be operated by
     * 4 people cannot claim to rent boats with a seating capacity between 1
     * and 4 people. He or she is offering two boat types for 1-2 and 4
     * persons.
     * <p>
     * Compatibility with schema.org: This class is a subclass of
     * http://schema.org/Quantity.
     *
     * @see <a href="http://purl.org/goodrelations/v1#QuantitativeValueInteger">#QuantitativeValueInteger</a>
     */
    public static final IRI QuantitativeValueInteger;

    /**
     * related Web Service (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#relatedWebService}
     * <p>
     * The URI of a SOAP or REST Web Service from which additional
     * information about the gr:BusinessEntity, gr:Offering,
     * gr:PriceSpecification, or gr:ProductOrService, or any other element,
     * can be obtained. The recommended range is xsd:anyURI i.e., the URI of
     * a SOAP or REST Web Service.
     * <p>
     * In principle, any existing or upcoming
     * vocabulary for Web Services can be used in combination with
     * GoodRelations, because the association between (a) the service
     * description and (b) the GoodRelations description can be found via the
     * Web Service URI value used with this gr:relatedWebService property.
     *
     * @see <a href="http://purl.org/goodrelations/v1#relatedWebService">#relatedWebService</a>
     */
    public static final IRI relatedWebService;

    /**
     * Repair (business function)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Repair}
     * <p>
     * This gr:BusinessFunction indicates that the gr:BusinessEntity offers
     * (or seeks) the evaluation of the chances for repairing, and, if
     * positive, repair of the specified gr:ProductOrService. Repairing means
     * actions that restore the originally intended function of a product
     * that suffers from outage or malfunction.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Repair">#Repair</a>
     */
    public static final IRI Repair;

    /**
     * Reseller (business entity type)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Reseller}
     * <p>
     * The gr:BusinessEntityType representing such agents that are purchasing
     * the scope of products included in the gr:Offering for resale on the
     * market. Resellers are also businesses, i.e., they are officially
     * registered with the public administration and strive for profits by
     * their activities.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Reseller">#Reseller</a>
     */
    public static final IRI Reseller;

    /**
     * Saturday (day of week)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Saturday}
     * <p>
     * Saturday as a day of the week.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Saturday">#Saturday</a>
     */
    public static final IRI Saturday;

    /**
     * seeks (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#seeks}
     * <p>
     * This links a gr:BusinessEntity to gr:Offering nodes that describe what
     * the business entity is interested in (i.e., the buy side). If you want
     * to express interest in offering something, use gr:offers instead. Note
     * that this substitutes the former gr:BusinessFunction gr:Buy, which is
     * now deprecated.
     *
     * @see <a href="http://purl.org/goodrelations/v1#seeks">#seeks</a>
     */
    public static final IRI seeks;

    /**
     * Sell (business function)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Sell}
     * <p>
     * This gr:BusinessFunction indicates that the gr:BusinessEntity offers
     * to permanently transfer all property rights on the specified
     * gr:ProductOrService.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Sell">#Sell</a>
     */
    public static final IRI Sell;

    /**
     * serial number (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#serialNumber}
     * <p>
     * The serial number or any alphanumeric identifier of a particular
     * product. Note that serial number are unique only for the same brand or
     * the same model, so you cannot infer from two occurrences of the same
     * serial number that the objects to which they are attached are
     * identical.
     * <p>
     * This property can also be attached to a gr:Offering in
     * cases where the included products are not modeled in more detail.
     *
     * @see <a href="http://purl.org/goodrelations/v1#serialNumber">#serialNumber</a>
     */
    public static final IRI serialNumber;

    /**
     * Some items
     * <p>
     * {@code http://purl.org/goodrelations/v1#SomeItems}
     * <p>
     * A placeholder instance for unknown instances of a mass-produced
     * commodity. This is used as a computationally cheap work-around for
     * such instances that are not individually exposed on the Web but just
     * stated to exist (i.e., which are existentially quantified).
     * <p>
     * Example:
     * An instance of this class can represent an anonymous set of green
     * Siemens1234 phones. It is different from the gr:ProductOrServiceModel
     * Siemens1234, since this refers to the make and model, and it is
     * different from a particular instance of this make and model (e.g. my
     * individual phone) since the latter can be sold only once.
     * <p>
     * Note: This
     * class is the new, shorter form of the former
     * gr:ProductOrServicesSomeInstancesPlaceholder.
     * <p>
     * Compatibility with
     * schema.org: This class is (approximately) a subclass of
     * http://schema.org/Product.
     *
     * @see <a href="http://purl.org/goodrelations/v1#SomeItems">#SomeItems</a>
     */
    public static final IRI SomeItems;

    /**
     * successor of (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#successorOf}
     * <p>
     * This property indicates that the subject is a newer, often updated or
     * improved variant of the gr:ProductOrServiceModel used as the
     * object.
     * <p>
     * Example: Golf III successorOf Golf II
     * <p>
     * This relation is
     * transitive.
     *
     * @see <a href="http://purl.org/goodrelations/v1#successorOf">#successorOf</a>
     */
    public static final IRI successorOf;

    /**
     * Sunday (day of week)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Sunday}
     * <p>
     * Sunday as a day of the week.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Sunday">#Sunday</a>
     */
    public static final IRI Sunday;

    /**
     * Tax ID (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#taxID}
     * <p>
     * The Tax / Fiscal ID of the gr:BusinessEntity, e.g. the TIN in the US
     * or the CIF/NIF in Spain. It is usually assigned by the country of
     * residence
     *
     * @see <a href="http://purl.org/goodrelations/v1#taxID">#taxID</a>
     */
    public static final IRI taxID;

    /**
     * Thursday (day of week)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Thursday}
     * <p>
     * Thursday as a day of the week.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Thursday">#Thursday</a>
     */
    public static final IRI Thursday;

    /**
     * Tuesday (day of week)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Tuesday}
     * <p>
     * Tuesday as a day of the week.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Tuesday">#Tuesday</a>
     */
    public static final IRI Tuesday;

    /**
     * Type and quantity node
     * <p>
     * {@code http://purl.org/goodrelations/v1#TypeAndQuantityNode}
     * <p>
     * This class collates all the information about a gr:ProductOrService
     * included in a bundle. If a gr:Offering contains just one item, you can
     * directly link from the gr:Offering to the gr:ProductOrService using
     * gr:includes. If the offering contains multiple items, use an instance
     * of this class for each component to indicate the quantity, unit of
     * measurement, and type of product, and link from the gr:Offering via
     * gr:includesObject.
     * <p>
     * Example: An offering may include of 100g of Butter
     * and 1 kg of potatoes, or 1 cell phone and 2 headsets.
     *
     * @see <a href="http://purl.org/goodrelations/v1#TypeAndQuantityNode">#TypeAndQuantityNode</a>
     */
    public static final IRI TypeAndQuantityNode;

    /**
     * type of good (1..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#typeOfGood}
     * <p>
     * This specifies the gr:ProductOrService that the gr:TypeAndQuantityNode
     * is referring to.
     *
     * @see <a href="http://purl.org/goodrelations/v1#typeOfGood">#typeOfGood</a>
     */
    public static final IRI typeOfGood;

    /**
     * Unit price specification
     * <p>
     * {@code http://purl.org/goodrelations/v1#UnitPriceSpecification}
     * <p>
     * A unit price specification is a conceptual entity that specifies the
     * price asked for a given gr:Offering by the respective gr:Business
     * Entity. An offering may be linked to multiple unit price
     * specifications that specify alternative prices for non-overlapping
     * sets of conditions (e.g. quantities or sales regions) or with
     * differing validity periods.
     * <p>
     * A unit price specification is
     * characterized by (1) the lower and upper limits and the unit of
     * measurement of the eligible quantity, (2) by a monetary amount per
     * unit of the product or service, and (3)  whether this prices includes
     * local sales taxes, namely VAT.
     * <p>
     * Example: The price, including VAT,
     * for 1 kg of a given material is 5 Euros per kg for 0 - 5 kg and 4
     * Euros for quantities above 5 kg.
     * <p>
     * The eligible quantity interval for a
     * given price is specified using the object property
     * gr:hasEligibleQuantity, which points to an instance of
     * gr:QuantitativeValue. The currency is specified using the
     * gr:hasCurrency property, which points to an ISO 4217 currency code.
     * The unit of measurement for the eligible quantity is specified using
     * the gr:hasUnitOfMeasurement datatype property, which points to an
     * UN/CEFACT Common Code (3 characters).
     * <p>
     * In most cases, the appropriate
     * unit of measurement is the UN/CEFACT Common Code &quot;C62&quot; for
     * &quot;Unit or piece&quot;, since a gr:Offering is defined by the
     * quantity and unit of measurement of all items included (e.g. &quot;1
     * kg of bananas plus a 2 kg of apples&quot;). As long at the offering
     * consists of only one item, it is also possible to use an unit of
     * measurement of choice for specifying the price per unit. For bundles,
     * however, only  &quot;C62&quot; for &quot;Unit or piece&quot; is a
     * valid unit of measurement.
     * <p>
     * You can assume that the price is given per
     * unit or piece if there is no gr:hasUnitOfMeasurement property attached
     * to the price.
     * <p>
     * Whether VAT and sales taxes are included in this price
     * is specified using the property gr:valueAddedTaxIncluded
     * (xsd:boolean).
     * <p>
     * The price per unit of measurement is specified as a
     * float value of the gr:hasCurrencyValue property. The currency is
     * specified via the gr:hasCurrency datatype property. Whether the price
     * includes VAT or not is indicated by the gr:valueAddedTaxIncluded
     * datatype property.
     * <p>
     * The property priceType can be used to indicate
     * that the price is a retail price recommendation only (i.e. a list
     * price).
     * <p>
     * If the price can only be given as a range, use
     * gr:hasMaxCurrencyValue and gr:hasMinCurrencyValue for the upper and
     * lower bounds.
     * <p>
     * Important: When querying for the price, always use
     * gr:hasMaxCurrencyValue and gr:hasMinCurrencyValue.
     * <p>
     * Note 1: Due to the
     * complexity of pricing scenarios in various industries, it may be
     * necessary to create extensions of this fundamental model of price
     * specifications. Such can be done easily by importing and refining the
     * GoodRelations ontology.
     * <p>
     * Note 2: For Google, attaching a
     * gr:validThrough statement to a gr:UnitPriceSpecification is mandatory.
     *
     * @see <a href="http://purl.org/goodrelations/v1#UnitPriceSpecification">#UnitPriceSpecification</a>
     */
    public static final IRI UnitPriceSpecification;

    /**
     * UPS (delivery method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#UPS}
     * <p>
     * Delivery via the parcel service UPS.
     *
     * @see <a href="http://purl.org/goodrelations/v1#UPS">#UPS</a>
     */
    public static final IRI UPS;

    /**
     * valid from (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#validFrom}
     * <p>
     * This property specifies the beginning of the validity of the
     * gr:Offering, gr:PriceSpecification, gr:License, or
     * gr:OpeningHoursSpecification.
     * A time-zone should be specified. For a
     * time in GMT/UTC, simply add a &quot;Z&quot; following the
     * time:
     * <p>
     * 2008-05-30T09:30:10Z.
     * <p>
     * Alternatively, you can specify an offset
     * from the UTC time by adding a positive or negative time following the
     * time:
     * <p>
     * 2008-05-30T09:30:10-09:00
     * <p>
     * or
     * <p>
     * 2008-05-30T09:30:10+09:00.
     * <p>
     * Note:
     * If multiple contradicting instances of a gr:Offering,
     * gr:PriceSpecification, or gr:OpeningHoursSpecification exist, it is a
     * good heuristics to assume that
     * 1. Information with validity
     * information for the respective period of time ranks higher than
     * information without validity information.
     * 2. Among conflicting nodes
     * both having validity information, the one with the shorter validity
     * span ranks higher.
     *
     * @see <a href="http://purl.org/goodrelations/v1#validFrom">#validFrom</a>
     */
    public static final IRI validFrom;

    /**
     * valid through (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#validThrough}
     * <p>
     * This property specifies the end of the validity of the gr:Offering,
     * gr:PriceSpecification, gr:License, or gr:OpeningHoursSpecification.
     * A
     * time-zone should be specified. For a time in GMT/UTC, simply add a
     * &quot;Z&quot; following the
     * time:
     * <p>
     * 2008-05-30T09:30:10Z.
     * <p>
     * Alternatively, you can specify an offset
     * from the UTC time by adding a positive or negative time following the
     * time:
     * <p>
     * 2008-05-30T09:30:10-09:00
     * <p>
     * or
     * 2008-05-30T09:30:10+09:00.
     * <p>
     * Note
     * 1: If multiple contradicting instances of a gr:Offering,
     * gr:PriceSpecification, or gr:OpeningHoursSpecification exist, it is a
     * good heuristics to assume that
     * 1. Information with validity
     * information for the respective period of time ranks higher than
     * information without validity information.
     * 2. Among conflicting nodes
     * both having validity information, the one with the shorter validity
     * span ranks higher.
     * Note 2: For Google, attaching a gr:validThrough
     * statement to a gr:UnitPriceSpecification is mandatory.
     *
     * @see <a href="http://purl.org/goodrelations/v1#validThrough">#validThrough</a>
     */
    public static final IRI validThrough;

    /**
     * value added tax included (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#valueAddedTaxIncluded}
     * <p>
     * This property specifies whether the applicable value-added tax (VAT)
     * is included in the price of the gr:PriceSpecification or not.
     * <p>
     * Note:
     * This is a simple representation which may not properly reflect all
     * details of local taxation.
     *
     * @see <a href="http://purl.org/goodrelations/v1#valueAddedTaxIncluded">#valueAddedTaxIncluded</a>
     */
    public static final IRI valueAddedTaxIncluded;

    /**
     * value reference (0..*)
     * <p>
     * {@code http://purl.org/goodrelations/v1#valueReference}
     * <p>
     * The superclass of properties that link a gr:QuantitativeValue or a
     * gr:QualitativeValue to a second gr:QuantitativeValue or a
     * gr:QualitativeValue that provides additional information on the
     * original value. A good modeling practice is to define specializations
     * of this property (e.g. foo:referenceTemperature) for your particular
     * domain.
     *
     * @see <a href="http://purl.org/goodrelations/v1#valueReference">#valueReference</a>
     */
    public static final IRI valueReference;

    /**
     * VAT ID (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#vatID}
     * <p>
     * The Value-added Tax ID of the gr:BusinessEntity. See
     * http://en.wikipedia.org/wiki/Value_added_tax_identification_number for
     * details.
     *
     * @see <a href="http://purl.org/goodrelations/v1#vatID">#vatID</a>
     */
    public static final IRI vatID;

    /**
     * VISA (payment method)
     * <p>
     * {@code http://purl.org/goodrelations/v1#VISA}
     * <p>
     * Payment by credit or debit cards issued by the VISA network.
     *
     * @see <a href="http://purl.org/goodrelations/v1#VISA">#VISA</a>
     */
    public static final IRI VISA;

    /**
     * Warranty promise
     * <p>
     * {@code http://purl.org/goodrelations/v1#WarrantyPromise}
     * <p>
     * This is a conceptual entity that holds together all aspects of the
     * n-ary relation gr:hasWarrantyPromise.
     * <p>
     * A Warranty promise is an entity
     * representing the duration and scope of services that will be provided
     * to a customer free of charge in case of a defect or malfunction of the
     * gr:ProductOrService. A warranty promise is characterized by its
     * temporal duration (usually starting with the date of purchase) and its
     * gr:WarrantyScope. The warranty scope represents the types of services
     * provided (e.g. labor and parts, just parts) of the warranty included
     * in an gr:Offering. The actual services may be provided by the
     * gr:BusinessEntity making the offering, by the manufacturer of the
     * product, or by a third party. There may be multiple warranty promises
     * associated with a particular offering, which differ in duration and
     * scope (e.g. pick-up service during the first 12 months, just parts and
     * labor for 36 months).
     * <p>
     * Examples: 12 months parts and labor, 36 months
     * parts
     *
     * @see <a href="http://purl.org/goodrelations/v1#WarrantyPromise">#WarrantyPromise</a>
     */
    public static final IRI WarrantyPromise;

    /**
     * Warranty scope
     * <p>
     * {@code http://purl.org/goodrelations/v1#WarrantyScope}
     * <p>
     * The warranty scope represents types of services that will be provided
     * free of charge by the vendor or manufacturer in the case of a defect
     * (e.g. labor and parts, just parts), as part of the warranty included
     * in an gr:Offering. The actual services may be provided by the
     * gr:BusinessEntity making the offering, by the manufacturer of the
     * product, or by a third party.
     * <p>
     * Examples: Parts and Labor, Parts
     *
     * @see <a href="http://purl.org/goodrelations/v1#WarrantyScope">#WarrantyScope</a>
     */
    public static final IRI WarrantyScope;

    /**
     * Wednesday (day of week)
     * <p>
     * {@code http://purl.org/goodrelations/v1#Wednesday}
     * <p>
     * Wednesday as a day of the week.
     *
     * @see <a href="http://purl.org/goodrelations/v1#Wednesday">#Wednesday</a>
     */
    public static final IRI Wednesday;

    /**
     * weight (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#weight}
     * <p>
     * The weight of the gr:ProductOrService.
     * Typical unit code(s): GRM for
     * gram, KGM for kilogram, LBR for pound
     *
     * @see <a href="http://purl.org/goodrelations/v1#weight">#weight</a>
     */
    public static final IRI weight;

    /**
     * width (0..1)
     * <p>
     * {@code http://purl.org/goodrelations/v1#width}
     * <p>
     * The width of the gr:ProductOrService.
     * Typical unit code(s): CMT for
     * centimeters, INH for inches
     *
     * @see <a href="http://purl.org/goodrelations/v1#width">#width</a>
     */
    public static final IRI width;

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
        acceptedPaymentMethods = vf.createIRI("http://purl.org/goodrelations/v1#acceptedPaymentMethods");
        ActualProductOrServiceInstance = vf.createIRI("http://purl.org/goodrelations/v1#ActualProductOrServiceInstance");
        addOn = vf.createIRI("http://purl.org/goodrelations/v1#addOn");
        advanceBookingRequirement = vf.createIRI("http://purl.org/goodrelations/v1#advanceBookingRequirement");
        AmericanExpress = vf.createIRI("http://purl.org/goodrelations/v1#AmericanExpress");
        amountOfThisGood = vf.createIRI("http://purl.org/goodrelations/v1#amountOfThisGood");
        appliesToDeliveryMethod = vf.createIRI("http://purl.org/goodrelations/v1#appliesToDeliveryMethod");
        appliesToPaymentMethod = vf.createIRI("http://purl.org/goodrelations/v1#appliesToPaymentMethod");
        availabilityEnds = vf.createIRI("http://purl.org/goodrelations/v1#availabilityEnds");
        availabilityStarts = vf.createIRI("http://purl.org/goodrelations/v1#availabilityStarts");
        availableAtOrFrom = vf.createIRI("http://purl.org/goodrelations/v1#availableAtOrFrom");
        availableDeliveryMethods = vf.createIRI("http://purl.org/goodrelations/v1#availableDeliveryMethods");
        billingIncrement = vf.createIRI("http://purl.org/goodrelations/v1#billingIncrement");
        Brand = vf.createIRI("http://purl.org/goodrelations/v1#Brand");
        Business = vf.createIRI("http://purl.org/goodrelations/v1#Business");
        BusinessEntity = vf.createIRI("http://purl.org/goodrelations/v1#BusinessEntity");
        BusinessEntityType = vf.createIRI("http://purl.org/goodrelations/v1#BusinessEntityType");
        BusinessFunction = vf.createIRI("http://purl.org/goodrelations/v1#BusinessFunction");
        Buy = vf.createIRI("http://purl.org/goodrelations/v1#Buy");
        ByBankTransferInAdvance = vf.createIRI("http://purl.org/goodrelations/v1#ByBankTransferInAdvance");
        ByInvoice = vf.createIRI("http://purl.org/goodrelations/v1#ByInvoice");
        Cash = vf.createIRI("http://purl.org/goodrelations/v1#Cash");
        category = vf.createIRI("http://purl.org/goodrelations/v1#category");
        CheckInAdvance = vf.createIRI("http://purl.org/goodrelations/v1#CheckInAdvance");
        closes = vf.createIRI("http://purl.org/goodrelations/v1#closes");
        COD = vf.createIRI("http://purl.org/goodrelations/v1#COD");
        color = vf.createIRI("http://purl.org/goodrelations/v1#color");
        condition = vf.createIRI("http://purl.org/goodrelations/v1#condition");
        ConstructionInstallation = vf.createIRI("http://purl.org/goodrelations/v1#ConstructionInstallation");
        datatypeProductOrServiceProperty = vf.createIRI("http://purl.org/goodrelations/v1#datatypeProductOrServiceProperty");
        DayOfWeek = vf.createIRI("http://purl.org/goodrelations/v1#DayOfWeek");
        DeliveryChargeSpecification = vf.createIRI("http://purl.org/goodrelations/v1#DeliveryChargeSpecification");
        deliveryLeadTime = vf.createIRI("http://purl.org/goodrelations/v1#deliveryLeadTime");
        DeliveryMethod = vf.createIRI("http://purl.org/goodrelations/v1#DeliveryMethod");
        DeliveryModeDirectDownload = vf.createIRI("http://purl.org/goodrelations/v1#DeliveryModeDirectDownload");
        DeliveryModeFreight = vf.createIRI("http://purl.org/goodrelations/v1#DeliveryModeFreight");
        DeliveryModeMail = vf.createIRI("http://purl.org/goodrelations/v1#DeliveryModeMail");
        DeliveryModeOwnFleet = vf.createIRI("http://purl.org/goodrelations/v1#DeliveryModeOwnFleet");
        DeliveryModeParcelService = vf.createIRI("http://purl.org/goodrelations/v1#DeliveryModeParcelService");
        DeliveryModePickUp = vf.createIRI("http://purl.org/goodrelations/v1#DeliveryModePickUp");
        depth = vf.createIRI("http://purl.org/goodrelations/v1#depth");
        description = vf.createIRI("http://purl.org/goodrelations/v1#description");
        DHL = vf.createIRI("http://purl.org/goodrelations/v1#DHL");
        DinersClub = vf.createIRI("http://purl.org/goodrelations/v1#DinersClub");
        DirectDebit = vf.createIRI("http://purl.org/goodrelations/v1#DirectDebit");
        Discover = vf.createIRI("http://purl.org/goodrelations/v1#Discover");
        displayPosition = vf.createIRI("http://purl.org/goodrelations/v1#displayPosition");
        Dispose = vf.createIRI("http://purl.org/goodrelations/v1#Dispose");
        durationOfWarrantyInMonths = vf.createIRI("http://purl.org/goodrelations/v1#durationOfWarrantyInMonths");
        eligibleCustomerTypes = vf.createIRI("http://purl.org/goodrelations/v1#eligibleCustomerTypes");
        eligibleDuration = vf.createIRI("http://purl.org/goodrelations/v1#eligibleDuration");
        eligibleRegions = vf.createIRI("http://purl.org/goodrelations/v1#eligibleRegions");
        eligibleTransactionVolume = vf.createIRI("http://purl.org/goodrelations/v1#eligibleTransactionVolume");
        Enduser = vf.createIRI("http://purl.org/goodrelations/v1#Enduser");
        equal = vf.createIRI("http://purl.org/goodrelations/v1#equal");
        FederalExpress = vf.createIRI("http://purl.org/goodrelations/v1#FederalExpress");
        Friday = vf.createIRI("http://purl.org/goodrelations/v1#Friday");
        GoogleCheckout = vf.createIRI("http://purl.org/goodrelations/v1#GoogleCheckout");
        greater = vf.createIRI("http://purl.org/goodrelations/v1#greater");
        greaterOrEqual = vf.createIRI("http://purl.org/goodrelations/v1#greaterOrEqual");
        hasBrand = vf.createIRI("http://purl.org/goodrelations/v1#hasBrand");
        hasBusinessFunction = vf.createIRI("http://purl.org/goodrelations/v1#hasBusinessFunction");
        hasCurrency = vf.createIRI("http://purl.org/goodrelations/v1#hasCurrency");
        hasCurrencyValue = vf.createIRI("http://purl.org/goodrelations/v1#hasCurrencyValue");
        hasDUNS = vf.createIRI("http://purl.org/goodrelations/v1#hasDUNS");
        hasEAN_UCC_13 = vf.createIRI("http://purl.org/goodrelations/v1#hasEAN_UCC-13");
        hasEligibleQuantity = vf.createIRI("http://purl.org/goodrelations/v1#hasEligibleQuantity");
        hasGlobalLocationNumber = vf.createIRI("http://purl.org/goodrelations/v1#hasGlobalLocationNumber");
        hasGTIN_14 = vf.createIRI("http://purl.org/goodrelations/v1#hasGTIN-14");
        hasGTIN_8 = vf.createIRI("http://purl.org/goodrelations/v1#hasGTIN-8");
        hasInventoryLevel = vf.createIRI("http://purl.org/goodrelations/v1#hasInventoryLevel");
        hasISICv4 = vf.createIRI("http://purl.org/goodrelations/v1#hasISICv4");
        hasMakeAndModel = vf.createIRI("http://purl.org/goodrelations/v1#hasMakeAndModel");
        hasManufacturer = vf.createIRI("http://purl.org/goodrelations/v1#hasManufacturer");
        hasMaxCurrencyValue = vf.createIRI("http://purl.org/goodrelations/v1#hasMaxCurrencyValue");
        hasMaxValue = vf.createIRI("http://purl.org/goodrelations/v1#hasMaxValue");
        hasMaxValueFloat = vf.createIRI("http://purl.org/goodrelations/v1#hasMaxValueFloat");
        hasMaxValueInteger = vf.createIRI("http://purl.org/goodrelations/v1#hasMaxValueInteger");
        hasMinCurrencyValue = vf.createIRI("http://purl.org/goodrelations/v1#hasMinCurrencyValue");
        hasMinValue = vf.createIRI("http://purl.org/goodrelations/v1#hasMinValue");
        hasMinValueFloat = vf.createIRI("http://purl.org/goodrelations/v1#hasMinValueFloat");
        hasMinValueInteger = vf.createIRI("http://purl.org/goodrelations/v1#hasMinValueInteger");
        hasMPN = vf.createIRI("http://purl.org/goodrelations/v1#hasMPN");
        hasNAICS = vf.createIRI("http://purl.org/goodrelations/v1#hasNAICS");
        hasNext = vf.createIRI("http://purl.org/goodrelations/v1#hasNext");
        hasOpeningHoursDayOfWeek = vf.createIRI("http://purl.org/goodrelations/v1#hasOpeningHoursDayOfWeek");
        hasOpeningHoursSpecification = vf.createIRI("http://purl.org/goodrelations/v1#hasOpeningHoursSpecification");
        hasPOS = vf.createIRI("http://purl.org/goodrelations/v1#hasPOS");
        hasPrevious = vf.createIRI("http://purl.org/goodrelations/v1#hasPrevious");
        hasPriceSpecification = vf.createIRI("http://purl.org/goodrelations/v1#hasPriceSpecification");
        hasStockKeepingUnit = vf.createIRI("http://purl.org/goodrelations/v1#hasStockKeepingUnit");
        hasUnitOfMeasurement = vf.createIRI("http://purl.org/goodrelations/v1#hasUnitOfMeasurement");
        hasValue = vf.createIRI("http://purl.org/goodrelations/v1#hasValue");
        hasValueFloat = vf.createIRI("http://purl.org/goodrelations/v1#hasValueFloat");
        hasValueInteger = vf.createIRI("http://purl.org/goodrelations/v1#hasValueInteger");
        hasWarrantyPromise = vf.createIRI("http://purl.org/goodrelations/v1#hasWarrantyPromise");
        hasWarrantyScope = vf.createIRI("http://purl.org/goodrelations/v1#hasWarrantyScope");
        height = vf.createIRI("http://purl.org/goodrelations/v1#height");
        includes = vf.createIRI("http://purl.org/goodrelations/v1#includes");
        includesObject = vf.createIRI("http://purl.org/goodrelations/v1#includesObject");
        Individual = vf.createIRI("http://purl.org/goodrelations/v1#Individual");
        isAccessoryOrSparePartFor = vf.createIRI("http://purl.org/goodrelations/v1#isAccessoryOrSparePartFor");
        isConsumableFor = vf.createIRI("http://purl.org/goodrelations/v1#isConsumableFor");
        isListPrice = vf.createIRI("http://purl.org/goodrelations/v1#isListPrice");
        isSimilarTo = vf.createIRI("http://purl.org/goodrelations/v1#isSimilarTo");
        isVariantOf = vf.createIRI("http://purl.org/goodrelations/v1#isVariantOf");
        JCB = vf.createIRI("http://purl.org/goodrelations/v1#JCB");
        Labor_BringIn = vf.createIRI("http://purl.org/goodrelations/v1#Labor-BringIn");
        LeaseOut = vf.createIRI("http://purl.org/goodrelations/v1#LeaseOut");
        legalName = vf.createIRI("http://purl.org/goodrelations/v1#legalName");
        lesser = vf.createIRI("http://purl.org/goodrelations/v1#lesser");
        lesserOrEqual = vf.createIRI("http://purl.org/goodrelations/v1#lesserOrEqual");
        License = vf.createIRI("http://purl.org/goodrelations/v1#License");
        Location = vf.createIRI("http://purl.org/goodrelations/v1#Location");
        LocationOfSalesOrServiceProvisioning = vf.createIRI("http://purl.org/goodrelations/v1#LocationOfSalesOrServiceProvisioning");
        Maintain = vf.createIRI("http://purl.org/goodrelations/v1#Maintain");
        MasterCard = vf.createIRI("http://purl.org/goodrelations/v1#MasterCard");
        Monday = vf.createIRI("http://purl.org/goodrelations/v1#Monday");
        N_Ary_Relations = vf.createIRI("http://purl.org/goodrelations/v1#N-Ary-Relations");
        name = vf.createIRI("http://purl.org/goodrelations/v1#name");
        nonEqual = vf.createIRI("http://purl.org/goodrelations/v1#nonEqual");
        Offering = vf.createIRI("http://purl.org/goodrelations/v1#Offering");
        offers = vf.createIRI("http://purl.org/goodrelations/v1#offers");
        OpeningHoursSpecification = vf.createIRI("http://purl.org/goodrelations/v1#OpeningHoursSpecification");
        opens = vf.createIRI("http://purl.org/goodrelations/v1#opens");
        owns = vf.createIRI("http://purl.org/goodrelations/v1#owns");
        PartsAndLabor_BringIn = vf.createIRI("http://purl.org/goodrelations/v1#PartsAndLabor-BringIn");
        PartsAndLabor_PickUp = vf.createIRI("http://purl.org/goodrelations/v1#PartsAndLabor-PickUp");
        PaymentChargeSpecification = vf.createIRI("http://purl.org/goodrelations/v1#PaymentChargeSpecification");
        PaymentMethod = vf.createIRI("http://purl.org/goodrelations/v1#PaymentMethod");
        PaymentMethodCreditCard = vf.createIRI("http://purl.org/goodrelations/v1#PaymentMethodCreditCard");
        PayPal = vf.createIRI("http://purl.org/goodrelations/v1#PayPal");
        PaySwarm = vf.createIRI("http://purl.org/goodrelations/v1#PaySwarm");
        predecessorOf = vf.createIRI("http://purl.org/goodrelations/v1#predecessorOf");
        PriceSpecification = vf.createIRI("http://purl.org/goodrelations/v1#PriceSpecification");
        priceType = vf.createIRI("http://purl.org/goodrelations/v1#priceType");
        ProductOrService = vf.createIRI("http://purl.org/goodrelations/v1#ProductOrService");
        ProductOrServiceModel = vf.createIRI("http://purl.org/goodrelations/v1#ProductOrServiceModel");
        ProductOrServicesSomeInstancesPlaceholder = vf.createIRI("http://purl.org/goodrelations/v1#ProductOrServicesSomeInstancesPlaceholder");
        ProvideService = vf.createIRI("http://purl.org/goodrelations/v1#ProvideService");
        PublicHolidays = vf.createIRI("http://purl.org/goodrelations/v1#PublicHolidays");
        PublicInstitution = vf.createIRI("http://purl.org/goodrelations/v1#PublicInstitution");
        qualitativeProductOrServiceProperty = vf.createIRI("http://purl.org/goodrelations/v1#qualitativeProductOrServiceProperty");
        QualitativeValue = vf.createIRI("http://purl.org/goodrelations/v1#QualitativeValue");
        quantitativeProductOrServiceProperty = vf.createIRI("http://purl.org/goodrelations/v1#quantitativeProductOrServiceProperty");
        QuantitativeValue = vf.createIRI("http://purl.org/goodrelations/v1#QuantitativeValue");
        QuantitativeValueFloat = vf.createIRI("http://purl.org/goodrelations/v1#QuantitativeValueFloat");
        QuantitativeValueInteger = vf.createIRI("http://purl.org/goodrelations/v1#QuantitativeValueInteger");
        relatedWebService = vf.createIRI("http://purl.org/goodrelations/v1#relatedWebService");
        Repair = vf.createIRI("http://purl.org/goodrelations/v1#Repair");
        Reseller = vf.createIRI("http://purl.org/goodrelations/v1#Reseller");
        Saturday = vf.createIRI("http://purl.org/goodrelations/v1#Saturday");
        seeks = vf.createIRI("http://purl.org/goodrelations/v1#seeks");
        Sell = vf.createIRI("http://purl.org/goodrelations/v1#Sell");
        serialNumber = vf.createIRI("http://purl.org/goodrelations/v1#serialNumber");
        SomeItems = vf.createIRI("http://purl.org/goodrelations/v1#SomeItems");
        successorOf = vf.createIRI("http://purl.org/goodrelations/v1#successorOf");
        Sunday = vf.createIRI("http://purl.org/goodrelations/v1#Sunday");
        taxID = vf.createIRI("http://purl.org/goodrelations/v1#taxID");
        Thursday = vf.createIRI("http://purl.org/goodrelations/v1#Thursday");
        Tuesday = vf.createIRI("http://purl.org/goodrelations/v1#Tuesday");
        TypeAndQuantityNode = vf.createIRI("http://purl.org/goodrelations/v1#TypeAndQuantityNode");
        typeOfGood = vf.createIRI("http://purl.org/goodrelations/v1#typeOfGood");
        UnitPriceSpecification = vf.createIRI("http://purl.org/goodrelations/v1#UnitPriceSpecification");
        UPS = vf.createIRI("http://purl.org/goodrelations/v1#UPS");
        validFrom = vf.createIRI("http://purl.org/goodrelations/v1#validFrom");
        validThrough = vf.createIRI("http://purl.org/goodrelations/v1#validThrough");
        valueAddedTaxIncluded = vf.createIRI("http://purl.org/goodrelations/v1#valueAddedTaxIncluded");
        valueReference = vf.createIRI("http://purl.org/goodrelations/v1#valueReference");
        vatID = vf.createIRI("http://purl.org/goodrelations/v1#vatID");
        VISA = vf.createIRI("http://purl.org/goodrelations/v1#VISA");
        WarrantyPromise = vf.createIRI("http://purl.org/goodrelations/v1#WarrantyPromise");
        WarrantyScope = vf.createIRI("http://purl.org/goodrelations/v1#WarrantyScope");
        Wednesday = vf.createIRI("http://purl.org/goodrelations/v1#Wednesday");
        weight = vf.createIRI("http://purl.org/goodrelations/v1#weight");
        width = vf.createIRI("http://purl.org/goodrelations/v1#width");

        _VALUES = Vocabularies.getIRIs(GoodRelationsVocabulary.class);
    }

    public GoodRelationsVocabulary() {
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