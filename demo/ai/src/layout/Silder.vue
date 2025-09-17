<script setup lang="ts">
import { useRouter } from 'vue-router'
import { ref, computed } from "vue"

const router = useRouter()
const routes = router.options.routes

const validRoutes = ref(
  routes.filter(item => item.children && item.children[0]?.meta?.title)
)

const RouterT = computed(() =>
  validRoutes.value.map(item => item.children![0].meta.title)
)

const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>

<template>
  <div class="menu-container">
    <el-row class="tac">
      <el-col :span="24" class="menu-col">
        <h5 class="mb-2">Default colors</h5>
        <el-menu
          default-active="1"
          class="el-menu-vertical-demo menu-list"
          @open="handleOpen"
          @close="handleClose"
        >
          <el-menu-item
            v-for="(item, index) in RouterT"
            :key="index"
            index="1"
          >
            <el-icon><Avatar /></el-icon> {{ item }}
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<style scoped>


</style>
