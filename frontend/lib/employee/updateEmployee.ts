import { endpoint } from "@/constants";
import axios from "axios";
import { getApiKey } from "../auth/action";

export type Props = {
  id: string;
  name?: string;
  phone?: string;
  dob?: string;
  address?: string;
  image?: string;
  male?: boolean;
  unit?: number;
  userIdentity?: string;
};
export default async function updateEmployee({
  id,
  name,
  address,
  image,
  dob,
  phone,
  male,
  unit,
  userIdentity,
}: Props) {
  const url = `${endpoint}/staff/${id}`;

  const data = {
    ...(address && { address: address }),
    ...(image && { image: image }),
    ...(name && { name: name.trim() }),
    ...(phone && { phone: phone }),
    ...(dob && { dob: dob }),
    ...(male && { male: male }),
    ...(unit && { unit: unit }),
    ...(userIdentity && { userIdentity: userIdentity }),
  };

  const token = await getApiKey();
  const headers = {
    accept: "*/*",
    "Content-Type": "application/json",
    Authorization: `Bearer ${token}`,
    // Add other headers as needed
  };

  // Make a POST request with headers
  const res = axios
    .put(url, data, { headers: headers })
    .then((response) => {
      if (response) return response.data;
    })
    .catch((error) => {
      console.error("Error:", error);
      return error;
    });
  return res;
}
