
import 'element-plus/dist/index.css' // 引入Element Plus样式

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import ElementPlus from 'element-plus' // 引入Element Plus
import * as ElementPlusIconsVue from '@element-plus/icons-vue' // 引入Element Plus图标

import App from './App.vue'
import router from './router'

const app = createApp(App)

// 注册所有Element Plus图标
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}

app.use(createPinia())
app.use(router)
app.use(ElementPlus) // 使用Element Plus

app.mount('#app')

