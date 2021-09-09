import {Orders} from "./orders";
import {Service} from "../service/service";
import {Unit} from '../service/unit';

export interface OrderDetail {
  orderDetailId: number;
  order: Orders;
  quantity: number;
  prices: number;
  totalPrices: number;
  service: Service;
  unit: Unit;
}
