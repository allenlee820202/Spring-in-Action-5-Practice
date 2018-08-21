"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var RecentTacosComponent = /** @class */ (function () {
    function RecentTacosComponent(httpClient) {
        this.httpClient = httpClient;
    }
    RecentTacosComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.httpClient.get('http://localhost:8080/design/recent')
            .subscribe(function (data) { return _this.recentTacos = data; });
    };
    RecentTacosComponent = __decorate([
        core_1.Component({
            selector: 'recent-tacos',
            templateUrl: 'recents.component.html', styleUrls: ['./recents.component.css']
        }),
        core_1.Injectable()
    ], RecentTacosComponent);
    return RecentTacosComponent;
}());
exports.RecentTacosComponent = RecentTacosComponent;
