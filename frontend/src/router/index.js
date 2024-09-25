import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/views/Home.vue'
import Menu from '@/views/Menu.vue'
import Orders from '@/views/Orders.vue'
import Inventory from '@/views/Inventory.vue'

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/menu',
        name: 'Menu',
        component: Menu
    },
    {
        path: '/orders',
        name: 'Orders',
        component: Orders
    },
    {
        path: '/inventory',
        name: 'Inventory',
        component: Inventory
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router