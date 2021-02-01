package au.gov.nsw.service.vouchersignup

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.persistence.Embeddable
import javax.persistence.Embedded

@SpringBootApplication
class VoucherSignupApplication

fun main(args: Array<String>) {
	runApplication<VoucherSignupApplication>(*args)
}

 data class Transaction(
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

fun getRandomString(length: Int) : String {
	val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
	return (1..length)
			.map { allowedChars.random() }
			.joinToString("")
}

@RestController
class TransactionController {

	@PostMapping("/submission")
	fun newVoucher(@RequestBody transaction: Transaction): Any {
		return object {
			val voucherNumber = getRandomString(12)

		}
	}
}


