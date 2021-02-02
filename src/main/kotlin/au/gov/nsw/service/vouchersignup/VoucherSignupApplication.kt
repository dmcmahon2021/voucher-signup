package au.gov.nsw.service.vouchersignup

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@SpringBootApplication
class VoucherSignupApplication

fun main(args: Array<String>) {
	runApplication<VoucherSignupApplication>(*args)
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

fun getRandomString(length: Int) : String {
	val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
	return (1..length)
			.map { allowedChars.random() }
			.joinToString("")
}
