package com.finalProject.demo.controller.front.shopManagerment;


import com.finalProject.demo.model.entity.product.Products;
import com.finalProject.demo.repository.product.ProductRepository;
import com.finalProject.demo.service.cart.CartService;
import com.finalProject.demo.service.product.PhotoService;
import com.finalProject.demo.service.product.ProductService;
import com.finalProject.demo.service.product.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;
	 ProductService productService;
    PhotoService photoService;
    @Autowired
    CartService cartservice;
    
    @Autowired
    ProductRepository pDao;
	
	
	/*
	 * 設定每頁有幾筆商品顯示在頁面上
	 * 第一頁:http://localhost:8080/Chezmoi/shop/page
	 * 第二頁:http://localhost:8080/Chezmoi/shop/page?p=2 以此類推
	 */
	@GetMapping("/shop")
	public String viewProducts(@RequestParam(name="p", defaultValue="1") Integer pageNumber,Model model) {
		Page<Products>page=shopService.findByPage(pageNumber);
		model.addAttribute("page", page);
//		Photo photo=photoService.findById(photoId);
//		model.addAttribute("Photo", photo);
		return "front/shop";
		
	}



	/*
	for Shop頁面的Ajax
	 */
	@ResponseBody
	@GetMapping("/distinctProduct")
	public List<Map<String,Object>> distinctProduct(){
		List<Map<String,Object>> objList = pDao.distinctProduct();
		return objList;
		}

	/*
	for ShopDetail頁面Size的Ajax
	 */
	@ResponseBody
	@GetMapping("/distinctSize")
	public List<Map<String,Object>> distinctSize(@RequestParam("series") String series){
		List<Map<String,Object>> objListSize = pDao.distinctSize(series);
		return objListSize;
	}

	/*
	for ShopDetail頁面Color的Ajax
	 */
	@ResponseBody
	@GetMapping("/distinctColor")
	public List<Map<String,Object>> distinctColor(@RequestParam("series") String series){
		List<Map<String,Object>> objListColor = pDao.distinctColor(series);
		return objListColor;
	}

	/*
	 * 設定按下商品分類可跳出相對應的商品
	 */
//	@GetMapping("/shop/{category}")
//	public String viewTopProducts(@PathVariable("category")String category, Model model) {
//		List<Products> productcategory=shopService.findProductByCategory(category);
//		model.addAttribute("category", productcategory);
//		return "front/CatProduct";
//	}
	/*
for Cat頁面的Ajax
 */
//	@ResponseBody
	@GetMapping("/shop/{category}")
	public String distinctCatProduct(@PathVariable String category,Model model){
		List<Map<String,Object>> objListCat = pDao.distinctCatProduct(category);
//		return objListCat;

		System.out.println(objListCat.get(0).get("productName"));

		model.addAttribute("category", objListCat);
		return "front/CatProduct";
	}

	
//		
//		for(int i =0; i<objList.length; i++) {
//			Object[] firstObjArray = objList.get(0);
//			
//		List<ShopDto> list= new ArrayList<ShopDto>();
//			
//			for(int j=0; j<list.length; i++) {
//				ShopDto dto = new ShopDto();
//				String name = (String) firstObjArray[0];
//				Integer price = (Integer) firstObjArray[1];
//				Integer photoId = (Integer) firstObjArray[2];
//				String series = (String) firstObjArray[3];
//			}
//			}
/*
 * 製作點擊商品名字可以進入"商品明細"
 */
@GetMapping("/shop/productDetail")
public String productdetail(@RequestParam("series")String series,Model model) {
	//商品明細內頁秀出color跟size
	List<Products> productSeries=shopService.findBySeries(series);
	model.addAttribute("productSeries",productSeries);
	//series陣列取出productId
	Products productsId= shopService.findById(productSeries.get(0).getProductId());
	model.addAttribute("productsId",productsId);
	return "front/productDetail";
}

	/*
	 * 找出熱銷商品
	 */
//	@RestController
	
//	@GetMapping("/")
//	public String viewBestProducts(@RequestParam("productId")String productId,Model model) {
//		List<OrderDetail> findBestProduct = shopService.findBestProduct(productId);
//		model.addAttribute("bestProduct",findBestProduct);
//		return "front/index";
//	}
		
//		String best = dto.getBest();
//		OrderDetail newOrderDetail=new OrderDetail();
//		newOrderDetail.setProductId(best);
//		productService.findAll(newOrderDetail);
////		Page<OrderDetail>page=shopService.findByPageIndex(pageNumber);
////		model.addAttribute("page", page);
////		return "front/index";



	
	
	
	

    
//    public myProductAllController(PhotoService photoService, ProductService productService) {
//        super();
//        this.photoService = photoService;
//        this.productService = productService;
//    }


//    @GetMapping(value = "/MyProduct",produces = { "application/json; charset=UTF-8" })//進入畫面就會顯示全部
//    public String getProducts(@RequestParam(name = "page",defaultValue = "1") Integer pageNumber, Model model) {
//        Page<Products> findByPage = productService.findByPage(pageNumber);
//        model.addAttribute("page",findByPage);
//        return "front/shop";
//    }
	
	

	
}

