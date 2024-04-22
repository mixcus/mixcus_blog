
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElIcon from '@element-plus/icons-vue'
import '@/assets/main.css'
import axios from 'axios'


const app = createApp(App)
app.provide('$axios',axios)

Object.keys(ElIcon).forEach((key) => {
  app.component(key, ElIcon[key])
})
app.use(ElementPlus)
app.use(router)

app.mount('#app')
