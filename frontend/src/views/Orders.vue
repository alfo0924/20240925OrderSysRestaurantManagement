<template>
  <div class="orders">
    <h2>訂單管理</h2>
    <OrderList :orders="orders" @update-order="updateOrder" />
  </div>
</template>

<script>
import OrderList from '@/components/OrderList.vue'
import axios from 'axios'

export default {
  name: 'Orders',
  components: {
    OrderList
  },
  data() {
    return {
      orders: []
    }
  },
  methods: {
    async fetchOrders() {
      try {
        const response = await axios.get('/api/orders')
        this.orders = response.data
      } catch (error) {
        console.error('Error fetching orders:', error)
      }
    },
    async updateOrder(orderId, newStatus) {
      try {
        await axios.put(`/api/orders/${orderId}`, { status: newStatus })
        this.fetchOrders()
      } catch (error) {
        console.error('Error updating order:', error)
      }
    }
  },
  mounted() {
    this.fetchOrders()
  }
}
</script>

<style scoped>
.orders {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}
</style>