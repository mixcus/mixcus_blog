import { defineStore } from 'pinia'
import { ref } from 'vue'

// 用户模块
export const useUserStore = defineStore('blog-user',() => {

        const userInfo = ref({}) // 定义 token

        const setValue = (value)=>{
            userInfo.value = value
        }
        const getToken = ()=>{
            return userInfo.value.token
        }
        // 设置 token
        const clearUserInfo= () => {
            userInfo.value = '';
        } 
        return {
            userInfo, setValue,clearUserInfo,getToken
        }
    },
    {
        persist: true // 持久化
    }
)