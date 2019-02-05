package cc.datafabric.scyllardf.coder.vocabularies.fibo_ru

import cc.datafabric.scyllardf.coder.IVocabulary
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.impl.SimpleValueFactory

class FIBO_RUVocabulary : IVocabulary {

    companion object {
        private const val NS = "https://w3id.org/datafabric.cc/ontologies/fibo-ru#"

        private val VF = SimpleValueFactory.getInstance()
        private val values = arrayListOf<IRI>(
            VF.createIRI(NS, "asPercentage"),
            VF.createIRI(NS, "hasCommercialActivity"),
            VF.createIRI(NS, "hasPrimaryCommercialActivity"),
            VF.createIRI(NS, "hasReasonCodeOfIssuance"),
            VF.createIRI(NS, "hasRegistrationIdentifier"),
            VF.createIRI(NS, "hasVATRegistrationNumber"),
            VF.createIRI(NS, "hasReasonCodeOfIssuance"),
            VF.createIRI(NS, "Attorney"),
            VF.createIRI(NS, "MutualFund"),
            VF.createIRI(NS, "SignatoryRoleInRFJ"),
            VF.createIRI(NS, "VATIN"),

            VF.createIRI(NS, "RUOrgStatus-0"),
            VF.createIRI(NS, "RUOrgStatus-1"),
            VF.createIRI(NS, "RUOrgStatus-101"),
            VF.createIRI(NS, "RUOrgStatus-105"),
            VF.createIRI(NS, "RUOrgStatus-121"),
            VF.createIRI(NS, "RUOrgStatus-122"),
            VF.createIRI(NS, "RUOrgStatus-123"),
            VF.createIRI(NS, "RUOrgStatus-124"),
            VF.createIRI(NS, "RUOrgStatus-125"),
            VF.createIRI(NS, "RUOrgStatus-126"),
            VF.createIRI(NS, "RUOrgStatus-127"),
            VF.createIRI(NS, "RUOrgStatus-128"),
            VF.createIRI(NS, "RUOrgStatus-131"),
            VF.createIRI(NS, "RUOrgStatus-132"),
            VF.createIRI(NS, "RUOrgStatus-133"),
            VF.createIRI(NS, "RUOrgStatus-134"),
            VF.createIRI(NS, "RUOrgStatus-135"),
            VF.createIRI(NS, "RUOrgStatus-136"),
            VF.createIRI(NS, "RUOrgStatus-201"),
            VF.createIRI(NS, "RUOrgStatus-202"),
            VF.createIRI(NS, "RUOrgStatus-301"),
            VF.createIRI(NS, "RUOrgStatus-501"),
            VF.createIRI(NS, "RUOrgStatus-701"),
            VF.createIRI(NS, "RUOrgStatus-702"),
            VF.createIRI(NS, "RUOrgStatus-801"),

            VF.createIRI(NS, "RUOrgStatusClassificationSystem"),
            VF.createIRI(NS, "RUSignatoryRolesClassificationSystem"),
            VF.createIRI(NS, "RussianFederationEntity"),
            VF.createIRI(NS, "RussianFederationJurisdiction"),

            VF.createIRI(NS, "SignatoryRoleInRFJ-02"),
            VF.createIRI(NS, "SignatoryRoleInRFJ-03"),
            VF.createIRI(NS, "SignatoryRoleInRFJ-04"),
            VF.createIRI(NS, "SignatoryRoleInRFJ-05"),
            VF.createIRI(NS, "SignatoryRoleInRFJ-06"),
            VF.createIRI(NS, "SignatoryRoleInRFJ-07"),
            VF.createIRI(NS, "SignatoryRoleInRFJ-08"),
            VF.createIRI(NS, "SignatoryRoleInRFJ-09"),
            VF.createIRI(NS, "SignatoryRoleInRFJ-10"),
            VF.createIRI(NS, "SignatoryRoleInRFJ-11")
        )
    }

    override fun getNamespace(): String {
        return NS
    }

    override fun getValues(): Iterator<IRI> {
        return values.iterator()
    }
}