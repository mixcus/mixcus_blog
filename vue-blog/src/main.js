
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElIcon from '@element-plus/icons-vue'
import '@/assets/main.css'
import axios from 'axios'
import zhCn from 'element-plus/es/locale/lang/zh-cn'
import persist from 'pinia-plugin-persistedstate'
import {createPinia} from 'pinia'

const app = createApp(App)
const pinia = createPinia()
pinia.use(persist)
app.use(pinia)

app.provide('$axios',axios)

Object.keys(ElIcon).forEach((key) => {
  app.component(key, ElIcon[key])
})
app.use(ElementPlus,{locale: zhCn})
app.use(router)


app.mount('#app')
