import { OutputData } from "@editorjs/editorjs";
import { IconType } from "react-icons";

export type SidebarItem = {
  title: string;
  href: string;
  icon?: IconType;
  submenu?: boolean;
  subMenuItems?: SidebarItem[];
};
export type Unit = {
  id: number;
  name: string;
  numberStaffs: number;
  manager: {
    id: number;
    email: string;
    phone: string;
    name: string;
    image: string;
  };
  staffs: {
    id: number;
    email: string;
    phone: string;
    name: string;
    image: string;
  }[];
  features: {
    id: number;
    name: string;
    has: boolean;
  }[];
};
export type Employee = {
  id: number;
  name: string;
  image: string;
  phone: string;
  email: string;
  address: string;
  dob: string;
  male: boolean;
  unit: {
    id: number;
    name: string;
  };
};
export type Feature = {
  id: number;
  name: string;
};
export type UnitLink = {
  value: string;
  label: string;
  href: string;
};
export type Resource = {
  id: number;
  name: string;
};
export type Room = {
  id: number;
  name: string;
  location: string;
};
export enum ShiftType {
  DAY = "DAY",
  NIGHT = "NIGHT",
}

export type Notification = {
  id: number;
  title: string;
  description: string;
  from: {
    id: number;
    email: string;
    phone: string;
    name: string;
    image: string;
  };
  to: {
    id: number;
    email: string;
    phone: string;
    name: string;
    image: string;
  };
  createdAt: string;
  seen: boolean;
};

export type News = {
  id: number;
  title: string;
  description: string;
  image: string;
  updatedAt: string;
  content: OutputData;
  createdBy: {
    id: number;
    email: string;
    phone: string;
    name: string;
    image: string;
  };
  tags: {
    id: number;
    name: string;
    numberPost: number;
  }[];
};

export type Tag = {
  id: number;
  name: string;
  numberPost: number;
};
