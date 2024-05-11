
// import axios from "axios";
// import store from "./store/index";

// const instance = axios.create({
//     baseURL: "localhost:8080",
//     timeout: 3000
// });

// /**
//  * 请求拦截
//  */
// instance.interceptors.request.use(

//     config => {
//         if(store.state.Authorization!=null && store.state.Authorization!= ""){
//             //请求头的Authorization加上token信息
//             config.headers.Authorization = store.state.Authorization;
//         }else{
//             console.log("no token!");
//         }
//         return config;
//     },
//     error => {
//         console.log('error in request');
//         return Promise.reject(error);
//     }

// )
// // 导出给 main.js 挂载
// export default instance