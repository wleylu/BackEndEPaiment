package com.efacture.dev.conttroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efacture.dev.exception.ResourceNotFoundException;
import com.efacture.dev.model.Transaction;

import com.efacture.dev.repository.TransactionRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture/")
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepository;

	@GetMapping("/tr/transactions")
	public List<Transaction> getAlltransaction() {
		return transactionRepository.findAll();
	}
	
	
	@PostMapping("/tr/Addtransaction")
	public Transaction ajoutTransaction(@RequestBody Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	
	@PutMapping("/tr/transaction/{id_transaction}/update")
	public ResponseEntity<Transaction> updateTransaction(@PathVariable(value = "id_transaction") Long TransactionId,
			@RequestBody Transaction transactionDetails) throws ResourceNotFoundException {

		Transaction t_transaction = transactionRepository.findById(TransactionId)
				.orElseThrow(() -> new ResourceNotFoundException("Transaction inexistante ::" + TransactionId));

		t_transaction.setStatutTraitement(transactionDetails.getStatutTraitement());
		t_transaction.setCodeTraitement(transactionDetails.getCodeTraitement());
		

		return ResponseEntity.ok(this.transactionRepository.save(t_transaction));

	}
	
	
	
	@PutMapping("/tr/transaction/{id_transaction}")
	public ResponseEntity<Transaction> referenceUpdate(@PathVariable("id_transaction") Long id_transaction, @RequestBody Transaction transaction){
		Optional<Transaction> transactions = transactionRepository.findById(id_transaction);
		
		if(transactions.isPresent()) {
			Transaction _transac = transactions.get();
			_transac.setCodeTraitement(transaction.getCodeTraitement());
			_transac.setStatutTraitement(transaction.getStatutTraitement());
			
			return new ResponseEntity<>(transactionRepository.save(_transac), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
