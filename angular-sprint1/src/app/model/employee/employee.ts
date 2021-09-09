import {Address} from '../address/address';

export interface Employee {
  employeeId: number;
  employeeCode: string;
  employeeFullname: string;
  employeePosition: Position;
  employeeEmail: string;
  employeeDateOfBirth: string;
  employeeStartWorkDate: string;
  employeeAddress: Address;
  employeePhoneNumber: string;
  employeeAccount: Account;
  employeeLevel: number;
  employeeYearOfExp: number;
  employeeFlagDel: number;
}
