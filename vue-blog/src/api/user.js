import request from '@/utils/request'
import { baseURL } from '@/utils/request'

//注册方法
export const userRegisterService = ({ username, password}) => {
    request.post(baseURL+'/register', { username, password })
}
 
//登入方法
export const userLoginService = ({username,password}) =>{
    request.post(baseURL+'/login',{username,password})
}
