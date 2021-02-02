package au.gov.nsw.service.vouchersignup

import javax.persistence.Embedded
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

class Transaction(
        @field:NotEmpty @field:Size(max = 500) var firstname: String? = null,
        @field:NotEmpty @field:Size(max = 500) var lastname: String? = null,
        var age: Int? = null,
        @field:NotEmpty @field:Pattern(regexp="^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[\\/\\-]\\d{4}\$") var dateOfBirth: String? = null,
        @field:NotEmpty @field:Email var email: String,
        @field:NotEmpty @field:Pattern(regexp="^04[0-9]{8}$") var mobileNumber: String? = null,
        @Embedded
        var medicareCard: MedicareCard
)