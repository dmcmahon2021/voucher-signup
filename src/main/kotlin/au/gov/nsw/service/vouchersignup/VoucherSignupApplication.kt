package au.gov.nsw.service.vouchersignup

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.persistence.Embeddable
import javax.persistence.Embedded
import javax.validation.Valid
import javax.validation.constraints.*

@SpringBootApplication
class VoucherSignupApplication

fun main(args: Array<String>) {
	runApplication<VoucherSignupApplication>(*args)
}

 data class Transaction(
		 @field:NotEmpty @field:Size(max = 25) var firstname: String? = null,
		 @field:NotEmpty @field:Size(max = 25) var lastname: String? = null,
		 var age: Int? = null,
		 @field:NotEmpty @field:Pattern(regexp="^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[\\/\\-]\\d{4}\$")
		 var dateOfBirth: String? = null,
		 @field:NotEmpty @field:Email var email: String,
		 @field:NotEmpty @field:Pattern(regexp="^04[0-9]{8}$") var mobileNumber: String? = null,
		 @Embedded
		 var medicareCard: MedicareCard
)

@Embeddable
class MedicareCard (
	var number: Long? = null,
	var expiryMonth: Int? = null,
	var expiryYear: Int? = null
)

fun getRandomString(length: Int) : String {
	val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
	return (1..length)
			.map { allowedChars.random() }
			.joinToString("")
}

@RestController
class TransactionController {

	@PostMapping("/submission")
	fun newVoucher(@RequestBody @Valid data: Transaction): Any {
		return object {
			val voucherNumber = getRandomString(12)

		}
	}
}


