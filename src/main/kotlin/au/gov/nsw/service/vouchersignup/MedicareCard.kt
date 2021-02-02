package au.gov.nsw.service.vouchersignup

import javax.persistence.Embeddable

@Embeddable
class MedicareCard (
		var number: Long? = null,
		var expiryMonth: Int? = null,
		var expiryYear: Int? = null
)