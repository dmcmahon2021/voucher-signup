package au.gov.nsw.service.vouchersignup

import javax.persistence.Embeddable
import javax.validation.constraints.Max
import javax.validation.constraints.NotEmpty

@Embeddable
class MedicareCard (
		@field:NotEmpty @field:Max(10) var number: Long? = null,
		@field:NotEmpty @field:Max(2) var expiryMonth: Int? = null,
		@field:NotEmpty @field:Max( 4) var expiryYear: Int? = null
)