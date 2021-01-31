package au.gov.nsw.service.vouchersignup

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.persistence.Embeddable
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Id

@SpringBootApplication
class VoucherSignupApplication

fun main(args: Array<String>) {
	runApplication<VoucherSignupApplication>(*args)
}

@Entity
 data class Transaction(
		@Id
		var voucherNumber: String? = null,
		var firstname: String? = null,
		var lastname: String? = null,
		var age: Int? = null,
		var dateOfBirth: String? = null,
		var email: String? = null,
		var mobileNumber: String? = null,
		@Embedded
		var medicareCard: MedicareCard
)

@Embeddable
class MedicareCard {
	 var number: Long? = null
	 var expiryMonth: Int? = null
	 var expiryYear: Int? = null
}

