import (
    "math"
    "math/rand"
)

type Solution struct {
    x_center float64
    y_center float64
    radius float64
}


func Constructor(radius float64, x_center float64, y_center float64) Solution {
    return Solution{x_center, y_center, radius}
}


func (this *Solution) RandPoint() []float64 {
    point := make([]float64, 2)
    
    for {
        x_delta := rand.Float64() * 2 * this.radius - this.radius
        y_delta := rand.Float64() * 2 * this.radius - this.radius

        point[0] = this.x_center + x_delta
        point[1] = this.y_center + y_delta
        if math.Pow(point[0]-this.x_center, 2) + math.Pow(point[1]-this.y_center,2) <= math.Pow(this.radius, 2) {
            return point
        }
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(radius, x_center, y_center);
 * param_1 := obj.RandPoint();
 */
