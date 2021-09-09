import {CategoryPrice} from './category-price';

export interface Category {
  categoryId: number;
  startTime: string;
  endTime: string;
  fee: string;
  discount: string;
  description: string;
  categoryPrice: CategoryPrice;
}
