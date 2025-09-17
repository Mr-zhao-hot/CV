import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: '/',
      component: () => import('../views/AboutView.vue'),
      children: [
        {
          path:"Ai",
          name:"Ai",
          meta:{
            index:"1",
            icon:`<el-icon><Avatar /></el-icon>`,
            title:"Ai简历"
          },
          component: () => import('../views/AI/index.vue'),
        }
      ]
    },
  ],
})


export default router
