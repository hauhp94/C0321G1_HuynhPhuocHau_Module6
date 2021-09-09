import {Role} from './role';
import {Category} from '../category/category';

export interface Account {
  accountId: number;
  accountUsername: string;
  accountPassword: string;
  accountRole: Role;
  accountCategory: Category;
}
