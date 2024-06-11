import axios from 'axios';

const API_URL = 'http://localhost:8080/api/emergencies';

class EmergencyService {
    submitReport(report) {
        return axios.post(API_URL, report);
    }
}

export default new EmergencyService();
