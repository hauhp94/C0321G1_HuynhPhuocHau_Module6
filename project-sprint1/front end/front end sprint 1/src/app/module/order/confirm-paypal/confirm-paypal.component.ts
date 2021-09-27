import {Component, OnInit} from '@angular/core';
import {OrderService} from "../../../service/order/order.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";
import {Order} from "../../../model/order-detail/order";
import {OrderDetailService} from "../../../service/order-detail/order-detail.service";
import {OrderDetail} from "../../../model/order-detail/order-detail";
import {UntilService} from "../../../service/order/until.service";
import {CategoryService} from "../../../service/category/category.service";
import {TokenStorageService} from "../../../service/account/token-storage.service";
import {Category} from "../../../model/category/category";

@Component({
  selector: 'app-confirm-paypal',
  templateUrl: './confirm-paypal.component.html',
  styleUrls: ['./confirm-paypal.component.css']
})
export class ConfirmPaypalComponent implements OnInit {
  orderId: string;
  order: any;
  orderDetailList: any;
  totalMoneyStr: string;
  category: any
  totalMoneyHours: number;

  constructor(
    private orderService: OrderService,
    private toast: ToastrService,
    public router: Router,
    private orderDetailService: OrderDetailService,
    private untilServices: UntilService,
    private categoryService: CategoryService,
    private tokenStorageService: TokenStorageService
  ) {

  }

  ngOnInit(): void {
    this.orderId = localStorage.getItem("orderId")
    this.orderService.getOrderById(parseInt(this.orderId)).subscribe(value => {
      this.order = value;
    })
    this.getTotalMoney(Number(this.orderId));

    this.getCategory()

  }

  confirm() {
    this.orderService.confirmPayment(parseInt(this.orderId)).subscribe(() => {
      if(this.totalMoneyHours>0){
        this.categoryService.addMoney(this.category,this.totalMoneyHours).subscribe()
      }
      this.toast.success('successful payment of customer service ' + this.order.customer.fullName +
      ", total money : "+this.totalMoneyStr);
      this.router.navigateByUrl('/order/list-order-customer')
    })
  }

  getTotalMoney(idOrder: number) {
    let totalMoney = 0
    this.orderDetailService.getAllOderDetailByIdOder(idOrder).subscribe(value => {
      this.orderDetailList = value;
      for (let orderDetail of this.orderDetailList) {
        if (orderDetail.services.name == "Giờ") {
          this.totalMoneyHours = orderDetail.quantity * orderDetail.services.prices

        }
        totalMoney += (orderDetail.services.prices * orderDetail.quantity);
      }
      this.totalMoneyStr = this.disPlayMoney(totalMoney);
    })
  }

  disPlayMoney(num: number) {
    return this.untilServices.numberWithCommas(num)
  }


  getCategory() {
    this.categoryService.findById(this.tokenStorageService.getUser().category).subscribe(data => {
      this.category = data;
    })
  }

}
