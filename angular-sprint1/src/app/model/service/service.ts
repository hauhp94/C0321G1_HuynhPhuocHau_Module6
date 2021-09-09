import {Unit} from './unit';

export interface Service {
  serviceId: number;
  serviceCode: string;
  serviceName: string;
  price: number;
  quantity: number;
  image: string;
  flag: number;
  unit: Unit;
}
