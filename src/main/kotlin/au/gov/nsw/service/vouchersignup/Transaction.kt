package au.gov.nsw.service.vouchersignup

import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.Valid
import javax.validation.constraints.*

@Entity
class Transaction (
        @Id
        var voucherNumber: String? = null,
        @field:NotEmpty @field:Size(max = 500) var firstname: String? = null,
        @field:NotEmpty @field:Size(max = 500) var lastname: String? = null,
        @field:Min(1) @field:Max(125) var age: Int? = null,
        @field:NotEmpty @field:Pattern(regexp="^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[\\/\\-]\\d{4}\$") var dateOfBirth: String? = null,
        @field:NotEmpty @field:Email var email: String,
        @field:NotEmpty @field:Pattern(regexp="^04[0-9]{8}$") var mobileNumber: String? = null,
        @Valid @Embedded var medicareCard: MedicareCard
)