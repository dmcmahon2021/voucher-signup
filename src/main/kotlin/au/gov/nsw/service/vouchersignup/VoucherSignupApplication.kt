package au.gov.nsw.service.vouchersignup

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping
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
class TransactionController(var repository: TransactionRepository) {

	@GetMapping("/vouchers")
	fun findAll(): MutableIterable<Transaction> {
		return repository.findAll()
	}

	@PostMapping("/submission")
	fun newVoucher(@Valid @RequestBody data: Transaction): Any {
			return object {
				var voucherNumber = getRandomString(12)
			}
	}
}

	fun getRandomString(length: Int): String {
		val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
		return (1..length)
				.map { allowedChars.random() }
				.joinToString("")
	}

@Repository
interface TransactionRepository : CrudRepository<Transaction, String>

