import { createStore } from 'vuex'
import axios from 'axios'

export default createStore({
    state: {
        isDarkMode: true,
        user: null
    },
    mutations: {
        toggleDarkMode(state) {
            state.isDarkMode = !state.isDarkMode
        },
        setUser(state, user) {
            state.user = user
        }
    },
    actions: {
        async login({ commit }, credentials) {
            try {
                const response = await axios.post('/api/login', credentials)
                commit('setUser', response.data)
                return response.data
            } catch (error) {
                console.error('Login error:', error)
                throw error
            }
        },
        async logout({ commit }) {
            try {
                await axios.post('/api/logout')
                commit('setUser', null)
            } catch (error) {
                console.error('Logout error:', error)
                throw error
            }
        }
    },
    getters: {
        isLoggedIn: state => !!state.user
    }
})