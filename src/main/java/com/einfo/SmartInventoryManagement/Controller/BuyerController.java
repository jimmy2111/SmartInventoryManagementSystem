package com.einfo.SmartInventoryManagement.Controller;

import java.net.http.HttpRequest;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.einfo.SmartInventoryManagement.Logger.LoggerImplementation;
import com.einfo.SmartInventoryManagement.Model.Product;
import com.einfo.SmartInventoryManagement.Repo.BuyerRepo;
import com.einfo.SmartInventoryManagement.Repo.SenderRepo;
import com.einfo.SmartInventoryManagement.Services.BuyerServices;
import com.einfo.SmartInventoryManagement.Services.EmailService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BuyerController {

	private Logger logger = LoggerImplementation.getLogger(BuyerController.class);

	@Autowired
	BuyerServices buyerServices;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	BuyerRepo buyerRepo;

	@Autowired
	SenderRepo senderRepo;
	
	private static String SORTING_ORDER="asc";

	@PostMapping("/AddProduct")
	public String getAddProduct(@RequestParam Integer product_Id, String product_name, String desc, Integer quantity,
			Integer threshold, String price) {
		String methodname = "getAddProduct";
		logger.info(methodname + "Called");
//		emailService.sendEmail("akshatgandhi1111@gmail.com", "product added", product_name + " is added successfully with quantity " + quantity);
		return buyerServices.getAddProduct(product_Id, product_name, desc, quantity, threshold, price);
	}

	@GetMapping("ViewProductData")

	public ModelAndView getLimitedRecordsWithOffset(@RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "3") Integer limit, HttpServletRequest req, Integer currPage,
			@RequestParam(value = "sortBy", defaultValue = "productname") String sortBy,
			@RequestParam(value = "sortBydesc", defaultValue = "productdecs") String sortBydesc,
			@RequestParam(value = "sortDir", defaultValue = "asc") String sortDir) {
		// Create a PageRequest object with the offset, limit, and sorting order
			String methodname1="getproductdata";
			logger.info(methodname1+ " Called ");
		
			Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
			PageRequest pageRequest = PageRequest.of(offset, limit, sort);

		
			
		if (offset < 0) {
			offset = 0;
		}
		//System.out.println(buyerRepo.findAll(PageRequest.of(offset, limit)).getContent());
		// Call the repository method with the PageRequest object
		ModelAndView mv = new ModelAndView("buyer/viewProduct");
		req.setAttribute("totalData", buyerRepo.findAll(pageRequest).getContent().size());
		req.setAttribute("buyerspage", buyerRepo.findAll(pageRequest).getContent());
		req.setAttribute("limit", limit);
		req.setAttribute("currPage", offset);
		return mv;
	}

	@GetMapping("ViewSellerDetail")
	public ModelAndView getsellersdetail(@RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "3") Integer limit, HttpServletRequest req, Integer currpage) {
		PageRequest pageRequest = PageRequest.of(offset, limit);
		if (offset < 0) {
			offset = 0;
		}
		ModelAndView mv = new ModelAndView("buyer/viewSeller");
		req.setAttribute("sellerdetail", senderRepo.findAll(pageRequest).getContent());
		req.setAttribute("currPage", offset);
		return mv;
	}

	@RequestMapping("AddSenderDetail")
	public String getsenderdetailpage() {
		return buyerServices.getsenderdetailpage();
	}

	@PostMapping("AddDetail")
	public String getaddsenderdetail(@RequestParam String sender_name, String shop_name, String address,
			String contact) {
		return buyerServices.getaddsenderdetail(sender_name, shop_name, address, contact);
	}

}
