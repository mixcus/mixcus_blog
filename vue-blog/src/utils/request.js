import axios from "axios";
import { ElMessage } from "element-plus";
import router from "@/router";
import {useUserStore} from "@/store/modules/user/index"

//基址
const baseURL = 'http://localhost:8080'

const instance = axios.create({
    // 基础地址，超时时间
    baseURL,
    timeout: 5000,
})
//请求拦截器
instance.interceptors.request.use(
    (config) => {
        // TODO 2. 携带token
        const userStore = useUserStore()
        const token = userStore.userInfo.token;
        //token不为空   
        if(token){
            //头部添加token
            config.headers.Authorization = `Bearer ${token}`
        }
        return config
    },
    (err) => Promise.reject(err)
    
)

//响应拦截器
instance.interceptors.response.use(
    (res) => {
        //处理业务成功
        if (res.data.flag) {
            return res
        }
        //打印错误信息
        ElMessage({ message: res.data.message || '服务异常', type: 'error' })
        
        return Promise.reject(res.data)
    },
    (err) => {
        // TODO 5. 处理401错误
        //ElMessage({ message: err.response.data.message || '服务异常', type: 'error' })
        if (err.response.status === 401) {
            router.push('/login')
        }
        return Promise.reject(err)
    }
)

export default instance
export {baseURL}