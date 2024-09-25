<template>
  <div class="order-list">
    <table>
      <thead>
      <tr>
        <th>訂單ID</th>
        <th>客戶</th>
        <th>餐廳</th>
        <th>訂單日期</th>
        <th>訂單價格</th>
        <th>訂單狀態</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="order in orders" :key="order.orderId">
        <td>{{ order.orderId }}</td>
        <td>{{ order.customerName }}</td>
        <td>{{ order.restaurantName }}</td>
        <td>{{ formatDate(order.orderDate) }}</td>
        <td>{{ order.orderPrice }}</td>
        <td>{{ order.orderStatus }}</td>
        <td>
          <select @change="updateOrderStatus(order.orderId, $event)">
            <option value="">更新狀態</option>
            <option value="待處理">待處理</option>
            <option value="準備中">準備中</option>
            <option value="配送中">配送中</option>
            <option value="已完成">已完成</option>
            <option value="已取消">已取消</option>
          </select>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: 'OrderList',
  props: {
    orders: {
      type: Array,
      required: true
    }
  },
  methods: {
    formatDate(date) {
      return new Date(date).toLocaleDateString()
    },
    updateOrderStatus(orderId, event) {
      const newStatus = event.target.value
      if (newStatus) {
        this.$emit('update-order', orderId, newStatus)
      }
    }
  }
}
</script>

<style scoped>
.order-list {
  margin-top: 20px;
}

table {
  width: 100%;
  border-collapse: collapse;
}

th, td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

th {
  background-color: #f2f2f2;
  font-weight: bold;
}

select {
  padding: 5px;
}
</style>