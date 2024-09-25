<template>
  <div class="menu">
    <h2>菜單管理</h2>
    <MenuList :menus="menus" @edit-menu="editMenu" @delete-menu="deleteMenu" />
    <button @click="showAddForm = true">新增菜單</button>
    <div v-if="showAddForm">
      <h3>新增菜單</h3>
      <form @submit.prevent="addMenu">
        <input v-model="newMenu.menuName" placeholder="菜單名稱" required>
        <input v-model="newMenu.menuDescribe" placeholder="菜單描述" required>
        <input v-model="newMenu.menuStatus" placeholder="菜單狀態" required>
        <input type="file" @change="onFileChange">
        <button type="submit">新增</button>
      </form>
    </div>
  </div>
</template>

<script>
import MenuList from '@/components/MenuList.vue'
import axios from 'axios'

export default {
  name: 'Menu',
  components: {
    MenuList
  },
  data() {
    return {
      menus: [],
      showAddForm: false,
      newMenu: {
        menuName: '',
        menuDescribe: '',
        menuStatus: '',
        menuImage: null
      }
    }
  },
  methods: {
    async fetchMenus() {
      try {
        const response = await axios.get('/api/menus')
        this.menus = response.data
      } catch (error) {
        console.error('Error fetching menus:', error)
      }
    },
    async addMenu() {
      try {
        const formData = new FormData()
        formData.append('menuName', this.newMenu.menuName)
        formData.append('menuDescribe', this.newMenu.menuDescribe)
        formData.append('menuStatus', this.newMenu.menu